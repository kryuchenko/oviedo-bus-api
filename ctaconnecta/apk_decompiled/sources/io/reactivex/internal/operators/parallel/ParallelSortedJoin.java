package io.reactivex.internal.operators.parallel;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class ParallelSortedJoin<T> extends Flowable<T> {
    final Comparator<? super T> comparator;
    final ParallelFlowable<List<T>> source;

    public ParallelSortedJoin(ParallelFlowable<List<T>> parallelFlowable, Comparator<? super T> comparator) {
        this.source = parallelFlowable;
        this.comparator = comparator;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(subscriber, this.source.parallelism(), this.comparator);
        subscriber.onSubscribe(sortedJoinSubscription);
        this.source.subscribe(sortedJoinSubscription.subscribers);
    }

    static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3481980673745556697L;
        volatile boolean cancelled;
        final Comparator<? super T> comparator;
        final Subscriber<? super T> downstream;
        final int[] indexes;
        final List<T>[] lists;
        final SortedJoinInnerSubscriber<T>[] subscribers;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger remaining = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        SortedJoinSubscription(Subscriber<? super T> subscriber, int i, Comparator<? super T> comparator) {
            this.downstream = subscriber;
            this.comparator = comparator;
            SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr = new SortedJoinInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                sortedJoinInnerSubscriberArr[i2] = new SortedJoinInnerSubscriber<>(this, i2);
            }
            this.subscribers = sortedJoinInnerSubscriberArr;
            this.lists = new List[i];
            this.indexes = new int[i];
            this.remaining.lazySet(i);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                if (this.remaining.get() == 0) {
                    drain();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                Arrays.fill(this.lists, (Object) null);
            }
        }

        void cancelAll() {
            for (SortedJoinInnerSubscriber<T> sortedJoinInnerSubscriber : this.subscribers) {
                sortedJoinInnerSubscriber.cancel();
            }
        }

        void innerNext(List<T> list, int i) {
            this.lists[i] = list;
            if (this.remaining.decrementAndGet() == 0) {
                drain();
            }
        }

        void innerError(Throwable th) {
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.error, null, th)) {
                drain();
            } else if (th != this.error.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a8, code lost:
        
            if (r11 != r7) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00ac, code lost:
        
            if (r19.cancelled == false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00ae, code lost:
        
            java.util.Arrays.fill(r3, (java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00b2, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00b3, code lost:
        
            r5 = r19.error.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00bc, code lost:
        
            if (r5 == null) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00be, code lost:
        
            cancelAll();
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onError(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00c7, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00c8, code lost:
        
            if (r13 >= r4) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00d2, code lost:
        
            if (r0[r13] == r3[r13].size()) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00d5, code lost:
        
            r13 = r13 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00d8, code lost:
        
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00df, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00e2, code lost:
        
            if (r11 == 0) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00eb, code lost:
        
            if (r7 == Long.MAX_VALUE) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00ed, code lost:
        
            r19.requested.addAndGet(-r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00f3, code lost:
        
            r5 = get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00f7, code lost:
        
            if (r5 != r6) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00f9, code lost:
        
            r5 = addAndGet(-r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00fe, code lost:
        
            if (r5 != 0) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            int iAddAndGet;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.downstream;
            List<T>[] listArr = this.lists;
            int[] iArr = this.indexes;
            int length = iArr.length;
            int i = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    int i2 = 0;
                    if (j2 == j) {
                        break;
                    }
                    if (this.cancelled) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th = this.error.get();
                    if (th != null) {
                        cancelAll();
                        Arrays.fill(listArr, (Object) null);
                        subscriber.onError(th);
                        return;
                    }
                    int i3 = -1;
                    T t = null;
                    while (i2 < length) {
                        List<T> list = listArr[i2];
                        int i4 = iArr[i2];
                        if (list.size() != i4) {
                            if (t == null) {
                                t = list.get(i4);
                            } else {
                                T t2 = list.get(i4);
                                try {
                                    if (this.comparator.compare(t, t2) > 0) {
                                        t = t2;
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    cancelAll();
                                    Arrays.fill(listArr, (Object) null);
                                    if (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.error, null, th2)) {
                                        RxJavaPlugins.onError(th2);
                                    }
                                    subscriber.onError(this.error.get());
                                    return;
                                }
                            }
                            i3 = i2;
                        }
                        i2++;
                    }
                    if (t == null) {
                        Arrays.fill(listArr, (Object) null);
                        subscriber.onComplete();
                        return;
                    } else {
                        subscriber.onNext(t);
                        iArr[i3] = iArr[i3] + 1;
                        j2++;
                    }
                }
                i = iAddAndGet;
            }
        }
    }

    static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final SortedJoinSubscription<T> parent;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        SortedJoinInnerSubscriber(SortedJoinSubscription<T> sortedJoinSubscription, int i) {
            this.parent = sortedJoinSubscription;
            this.index = i;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(List<T> list) {
            this.parent.innerNext(list, this.index);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }
}
