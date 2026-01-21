package com.iecisa.ctausuario.ui.main.stops.favouritestops;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.FavouriteStopsRepository;
import com.iecisa.ctausuario.model.MapStop;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class FavouriteStopsViewModelImpl extends BaseViewModel implements FavouriteStopsViewModel {
    private CompositeDisposable compositeDisposable;
    private FavouriteStopsRepository favouriteStopsRepository;
    private SchedulerProvider schedulerProvider;

    @Inject
    public FavouriteStopsViewModelImpl(Application application, FavouriteStopsRepository favouriteStopsRepository, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(application);
        this.favouriteStopsRepository = favouriteStopsRepository;
        this.compositeDisposable = compositeDisposable;
        this.schedulerProvider = schedulerProvider;
    }

    @Override // com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsViewModel
    public LiveData<List<MapStop>> getAllFavouriteStops() {
        return this.favouriteStopsRepository.getAllFavouriteStops();
    }

    @Override // com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsViewModel
    public void deleteFavouriteStop(Integer stopId) {
        this.compositeDisposable.add(this.favouriteStopsRepository.deleteFavouriteStopById(stopId).subscribeOn(this.schedulerProvider.io()).observeOn(this.schedulerProvider.ui()).subscribe());
    }
}
