package com.iecisa.ctausuario.ui.main.datelines;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.StopsRepository;
import com.iecisa.ctausuario.model.MapStop;
import com.iecisa.ctausuario.model.StopTime;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class DateTimeLineViewModelImpl extends BaseViewModel implements DateTimeLineViewModel {
    private CompositeDisposable compositeDisposable;
    private SchedulerProvider schedulerProvider;
    private StopsRepository stopsRepository;

    @Inject
    public DateTimeLineViewModelImpl(Application application, StopsRepository stopsRepository, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(application);
        this.stopsRepository = stopsRepository;
        this.compositeDisposable = compositeDisposable;
        this.schedulerProvider = schedulerProvider;
    }

    @Override // com.iecisa.ctausuario.ui.main.datelines.DateTimeLineViewModel
    public LiveData<Resource<List<StopTime>>> getTimesForStop(Integer stopId, Context context, String date) {
        return this.stopsRepository.getTimesForStop(stopId, context, date);
    }

    @Override // com.iecisa.ctausuario.ui.main.datelines.DateTimeLineViewModel
    public LiveData<Long> insertFavouriteStop(MapStop stop) {
        final MutableLiveData mutableLiveData = new MutableLiveData();
        this.compositeDisposable.add(this.stopsRepository.insertFavouriteStop(stop).subscribeOn(this.schedulerProvider.io()).observeOn(this.schedulerProvider.ui()).subscribe(new Consumer() { // from class: com.iecisa.ctausuario.ui.main.datelines.DateTimeLineViewModelImpl$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                mutableLiveData.setValue((Long) obj);
            }
        }));
        return mutableLiveData;
    }

    @Override // com.iecisa.ctausuario.ui.main.datelines.DateTimeLineViewModel
    public void deleteFavouriteStop(Integer stopId) {
        this.compositeDisposable.add(this.stopsRepository.deleteFavouriteStopById(stopId).subscribeOn(this.schedulerProvider.io()).observeOn(this.schedulerProvider.ui()).subscribe());
    }
}
