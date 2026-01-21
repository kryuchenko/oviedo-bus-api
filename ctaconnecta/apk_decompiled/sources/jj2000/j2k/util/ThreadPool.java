package jj2000.j2k.util;

/* loaded from: classes5.dex */
public class ThreadPool {
    public static final String CONCURRENCY_PROP_NAME = "jj2000.j2k.util.ThreadPool.concurrency";
    private ThreadPoolThread[] idle;
    private int nidle;
    private String poolName;
    private int poolPriority;
    private volatile Error targetE;
    private volatile RuntimeException targetRE;

    class ThreadPoolThread extends Thread {
        private boolean doNotifyAll;
        private Object lock;
        private Runnable target;

        public ThreadPoolThread(int i, String str) {
            super(str);
            setDaemon(true);
            setPriority(ThreadPool.this.poolPriority);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ThreadPool.this.putInIdleList(this);
            synchronized (this) {
                while (true) {
                    Runnable runnable = this.target;
                    if (runnable == null) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        try {
                            try {
                                try {
                                    runnable.run();
                                } catch (ThreadDeath e) {
                                    FacilityManager.getMsgLogger().printmsg(2, "Thread.stop() called on a ThreadPool thread or ThreadDeath thrown. This is deprecated. Lock-up might occur.");
                                    throw e;
                                }
                            } catch (RuntimeException e2) {
                                ThreadPool.this.targetRE = e2;
                            }
                        } catch (Error e3) {
                            ThreadPool.this.targetE = e3;
                        } catch (Throwable unused2) {
                            ThreadPool.this.targetRE = new RuntimeException("Unchecked exception thrown by target's run() method in pool " + ThreadPool.this.poolName + ".");
                        }
                        ThreadPool.this.putInIdleList(this);
                        this.target = null;
                        Object obj = this.lock;
                        if (obj != null) {
                            synchronized (obj) {
                                if (this.doNotifyAll) {
                                    this.lock.notifyAll();
                                } else {
                                    this.lock.notify();
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        synchronized void setTarget(Runnable runnable, Object obj, boolean z) {
            this.target = runnable;
            this.lock = obj;
            this.doNotifyAll = z;
            notify();
        }
    }

    public ThreadPool(int i, int i2, String str) throws NumberFormatException {
        if (i <= 0) {
            throw new IllegalArgumentException("Pool must be of positive size");
        }
        if (i2 < 1) {
            this.poolPriority = Thread.currentThread().getPriority();
        } else {
            this.poolPriority = i2 >= 10 ? 10 : i2;
        }
        if (str == null) {
            this.poolName = "Anonymous ThreadPool";
        } else {
            this.poolName = str;
        }
        String property = System.getProperty(CONCURRENCY_PROP_NAME);
        if (property != null) {
            try {
                int i3 = Integer.parseInt(property);
                if (i3 < 0) {
                    throw new NumberFormatException();
                }
                if (NativeServices.loadLibrary()) {
                    FacilityManager.getMsgLogger().printmsg(1, "Changing thread concurrency level from " + NativeServices.getThreadConcurrency() + " to " + i3 + ".");
                    NativeServices.setThreadConcurrency(i3);
                } else {
                    FacilityManager.getMsgLogger().printmsg(2, "Native library to set thread concurrency level as specified by the jj2000.j2k.util.ThreadPool.concurrency property not found. Thread concurrency unchanged.");
                }
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("Invalid concurrency level in property jj2000.j2k.util.ThreadPool.concurrency");
            }
        }
        this.idle = new ThreadPoolThread[i];
        this.nidle = 0;
        for (int i4 = 0; i4 < i; i4++) {
            new ThreadPoolThread(i4, this.poolName + "-" + i4).start();
        }
    }

    public int getSize() {
        return this.idle.length;
    }

    public boolean runTarget(Runnable runnable, Object obj) {
        return runTarget(runnable, obj, false, false);
    }

    public boolean runTarget(Runnable runnable, Object obj, boolean z) {
        return runTarget(runnable, obj, z, false);
    }

    public boolean runTarget(Runnable runnable, Object obj, boolean z, boolean z2) {
        ThreadPoolThread idle = getIdle(z);
        if (idle == null) {
            return false;
        }
        idle.setTarget(runnable, obj, z2);
        return true;
    }

    public void checkTargetErrors() {
        if (this.targetE != null) {
            throw this.targetE;
        }
        if (this.targetRE != null) {
            throw this.targetRE;
        }
    }

    public void clearTargetErrors() {
        this.targetE = null;
        this.targetRE = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putInIdleList(ThreadPoolThread threadPoolThread) {
        synchronized (this.idle) {
            ThreadPoolThread[] threadPoolThreadArr = this.idle;
            int i = this.nidle;
            threadPoolThreadArr[i] = threadPoolThread;
            int i2 = i + 1;
            this.nidle = i2;
            if (i2 == 1) {
                threadPoolThreadArr.notify();
            }
        }
    }

    private ThreadPoolThread getIdle(boolean z) {
        synchronized (this.idle) {
            if (z) {
                if (this.nidle == 0) {
                    return null;
                }
            } else {
                while (this.nidle == 0) {
                    try {
                        this.idle.wait();
                    } catch (InterruptedException unused) {
                        return null;
                    }
                }
            }
            int i = this.nidle - 1;
            this.nidle = i;
            return this.idle[i];
        }
    }
}
