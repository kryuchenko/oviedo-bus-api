package jj2000.j2k.util;

import java.util.Hashtable;

/* loaded from: classes5.dex */
public class FacilityManager {
    private static final Hashtable loggerList = new Hashtable();
    private static MsgLogger defMsgLogger = new StreamMsgLogger(System.out, System.err, 78);
    private static final Hashtable watchProgList = new Hashtable();
    private static ProgressWatch defWatchProg = null;

    public static void registerProgressWatch(Thread thread, ProgressWatch progressWatch) {
        progressWatch.getClass();
        if (thread == null) {
            defWatchProg = progressWatch;
        } else {
            watchProgList.put(thread, progressWatch);
        }
    }

    public static ProgressWatch getProgressWatch() {
        ProgressWatch progressWatch = (ProgressWatch) watchProgList.get(Thread.currentThread());
        return progressWatch == null ? defWatchProg : progressWatch;
    }

    public static void registerMsgLogger(Thread thread, MsgLogger msgLogger) {
        msgLogger.getClass();
        if (thread == null) {
            defMsgLogger = msgLogger;
        } else {
            loggerList.put(thread, msgLogger);
        }
    }

    public static MsgLogger getMsgLogger() {
        MsgLogger msgLogger = (MsgLogger) loggerList.get(Thread.currentThread());
        return msgLogger == null ? defMsgLogger : msgLogger;
    }

    public static MsgLogger getMsgLogger(Thread thread) {
        MsgLogger msgLogger = (MsgLogger) loggerList.get(thread);
        return msgLogger == null ? defMsgLogger : msgLogger;
    }
}
