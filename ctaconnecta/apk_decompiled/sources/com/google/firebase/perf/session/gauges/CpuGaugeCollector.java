package com.google.firebase.perf.session.gauges;

import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.CpuMetricReading;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class CpuGaugeCollector {
    private static final int CSTIME_POSITION_IN_PROC_PID_STAT = 16;
    private static final int CUTIME_POSITION_IN_PROC_PID_STAT = 15;
    public static final long INVALID_CPU_COLLECTION_FREQUENCY = -1;
    private static final int INVALID_SC_PER_CPU_CLOCK_TICK = -1;
    private static final int STIME_POSITION_IN_PROC_PID_STAT = 14;
    private static final int UNSET_CPU_METRIC_COLLECTION_RATE = -1;
    private static final int UTIME_POSITION_IN_PROC_PID_STAT = 13;
    private final long clockTicksPerSecond;
    private long cpuMetricCollectionRateMs;
    private final ScheduledExecutorService cpuMetricCollectorExecutor;
    private ScheduledFuture cpuMetricCollectorJob;
    public final ConcurrentLinkedQueue<CpuMetricReading> cpuMetricReadings;
    private final String procFileName;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static final long MICROSECONDS_PER_SECOND = TimeUnit.SECONDS.toMicros(1);

    public static boolean isInvalidCollectionFrequency(long j) {
        return j <= 0;
    }

    CpuGaugeCollector() {
        this.cpuMetricCollectorJob = null;
        this.cpuMetricCollectionRateMs = -1L;
        this.cpuMetricReadings = new ConcurrentLinkedQueue<>();
        this.cpuMetricCollectorExecutor = Executors.newSingleThreadScheduledExecutor();
        this.procFileName = "/proc/" + Integer.toString(Process.myPid()) + "/stat";
        this.clockTicksPerSecond = getClockTicksPerSecond();
    }

    CpuGaugeCollector(ScheduledExecutorService scheduledExecutorService, String str, long j) {
        this.cpuMetricCollectorJob = null;
        this.cpuMetricCollectionRateMs = -1L;
        this.cpuMetricReadings = new ConcurrentLinkedQueue<>();
        this.cpuMetricCollectorExecutor = scheduledExecutorService;
        this.procFileName = str;
        this.clockTicksPerSecond = j;
    }

    public void startCollecting(long j, Timer timer) {
        long j2 = this.clockTicksPerSecond;
        if (j2 == -1 || j2 == 0 || isInvalidCollectionFrequency(j)) {
            return;
        }
        if (this.cpuMetricCollectorJob == null) {
            scheduleCpuMetricCollectionWithRate(j, timer);
        } else if (this.cpuMetricCollectionRateMs != j) {
            stopCollecting();
            scheduleCpuMetricCollectionWithRate(j, timer);
        }
    }

    public void stopCollecting() {
        ScheduledFuture scheduledFuture = this.cpuMetricCollectorJob;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.cpuMetricCollectorJob = null;
        this.cpuMetricCollectionRateMs = -1L;
    }

    public void collectOnce(Timer timer) {
        scheduleCpuMetricCollectionOnce(timer);
    }

    private synchronized void scheduleCpuMetricCollectionWithRate(long j, final Timer timer) {
        this.cpuMetricCollectionRateMs = j;
        try {
            this.cpuMetricCollectorJob = this.cpuMetricCollectorExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.google.firebase.perf.session.gauges.CpuGaugeCollector$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    this.f$0.m654x1cbd6996(timer);
                }
            }, 0L, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            logger.warn("Unable to start collecting Cpu Metrics: " + e.getMessage());
        }
    }

    /* renamed from: lambda$scheduleCpuMetricCollectionWithRate$0$com-google-firebase-perf-session-gauges-CpuGaugeCollector, reason: not valid java name */
    /* synthetic */ void m654x1cbd6996(Timer timer) throws IOException {
        CpuMetricReading cpuMetricReadingSyncCollectCpuMetric = syncCollectCpuMetric(timer);
        if (cpuMetricReadingSyncCollectCpuMetric != null) {
            this.cpuMetricReadings.add(cpuMetricReadingSyncCollectCpuMetric);
        }
    }

    private synchronized void scheduleCpuMetricCollectionOnce(final Timer timer) {
        try {
            this.cpuMetricCollectorExecutor.schedule(new Runnable() { // from class: com.google.firebase.perf.session.gauges.CpuGaugeCollector$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    this.f$0.m653xc89eb492(timer);
                }
            }, 0L, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            logger.warn("Unable to collect Cpu Metric: " + e.getMessage());
        }
    }

    /* renamed from: lambda$scheduleCpuMetricCollectionOnce$1$com-google-firebase-perf-session-gauges-CpuGaugeCollector, reason: not valid java name */
    /* synthetic */ void m653xc89eb492(Timer timer) throws IOException {
        CpuMetricReading cpuMetricReadingSyncCollectCpuMetric = syncCollectCpuMetric(timer);
        if (cpuMetricReadingSyncCollectCpuMetric != null) {
            this.cpuMetricReadings.add(cpuMetricReadingSyncCollectCpuMetric);
        }
    }

    private CpuMetricReading syncCollectCpuMetric(Timer timer) throws IOException {
        if (timer == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.procFileName));
            try {
                long currentTimestampMicros = timer.getCurrentTimestampMicros();
                String[] strArrSplit = bufferedReader.readLine().split(" ");
                CpuMetricReading cpuMetricReadingBuild = CpuMetricReading.newBuilder().setClientTimeUs(currentTimestampMicros).setSystemTimeUs(convertClockTicksToMicroseconds(Long.parseLong(strArrSplit[14]) + Long.parseLong(strArrSplit[16]))).setUserTimeUs(convertClockTicksToMicroseconds(Long.parseLong(strArrSplit[13]) + Long.parseLong(strArrSplit[15]))).build();
                bufferedReader.close();
                return cpuMetricReadingBuild;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            logger.warn("Unable to read 'proc/[pid]/stat' file: " + e.getMessage());
            return null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            e = e2;
            logger.warn("Unexpected '/proc/[pid]/stat' file format encountered: " + e.getMessage());
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            logger.warn("Unexpected '/proc/[pid]/stat' file format encountered: " + e.getMessage());
            return null;
        } catch (NumberFormatException e4) {
            e = e4;
            logger.warn("Unexpected '/proc/[pid]/stat' file format encountered: " + e.getMessage());
            return null;
        }
    }

    private long getClockTicksPerSecond() {
        return Os.sysconf(OsConstants._SC_CLK_TCK);
    }

    private long convertClockTicksToMicroseconds(long j) {
        return Math.round((j / this.clockTicksPerSecond) * MICROSECONDS_PER_SECOND);
    }
}
