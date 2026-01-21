package com.iecisa.ctausuario.ui.main.linesrealtime;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.LinesRepository;
import com.iecisa.ctausuario.model.MapStop;
import com.iecisa.ctausuario.model.StopItinerary;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class LinesRealTimeViewModelImpl extends BaseViewModel implements LinesRealTimeViewModel {
    private CompositeDisposable compositeDisposable;
    private LinesRepository linesRepository;
    private SchedulerProvider schedulerProvider;

    @Inject
    public LinesRealTimeViewModelImpl(Application application, LinesRepository linesRepository, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(application);
        this.linesRepository = linesRepository;
        this.compositeDisposable = compositeDisposable;
        this.schedulerProvider = schedulerProvider;
    }

    @Override // com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeViewModel
    public LiveData<Resource<List<StopItinerary>>> getAllStopsFromLine(Integer idLine, Integer idVehicle, boolean fromAllLines, Context context) {
        return this.linesRepository.getAllStopsFromLine(idLine, idVehicle, fromAllLines, context);
    }

    @Override // com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeViewModel
    public LiveData<Long> insertFavouriteStop(MapStop stop) {
        final MutableLiveData mutableLiveData = new MutableLiveData();
        this.compositeDisposable.add(this.linesRepository.insertFavouriteStop(stop).subscribeOn(this.schedulerProvider.io()).observeOn(this.schedulerProvider.ui()).subscribe(new Consumer() { // from class: com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeViewModelImpl$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                mutableLiveData.setValue((Long) obj);
            }
        }));
        return mutableLiveData;
    }

    @Override // com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeViewModel
    public void deleteFavouriteStop(Integer stopId) {
        this.compositeDisposable.add(this.linesRepository.deleteFavouriteStopById(stopId).subscribeOn(this.schedulerProvider.io()).observeOn(this.schedulerProvider.ui()).subscribe());
    }
}
