package com.iecisa.ctausuario.ui.main.stops.mapstops;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.google.android.gms.maps.model.LatLng;
import com.iecisa.ctausuario.data.RouteRepository;
import com.iecisa.ctausuario.data.StopsRepository;
import com.iecisa.ctausuario.model.MapStop;
import com.iecisa.ctausuario.model.SearchAddress;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class MapStopsViewModelImpl extends BaseViewModel implements MapStopsViewModel {
    private CompositeDisposable compositeDisposable;
    private RouteRepository routeRepository;
    private SchedulerProvider schedulerProvider;
    private StopsRepository stopsRepository;

    @Inject
    public MapStopsViewModelImpl(Application application, StopsRepository stopsRepository, RouteRepository routeRepository, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(application);
        this.stopsRepository = stopsRepository;
        this.routeRepository = routeRepository;
        this.compositeDisposable = compositeDisposable;
        this.schedulerProvider = schedulerProvider;
    }

    @Override // com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsViewModel
    public LiveData<Resource<List<MapStop>>> getStops(LatLng currentLocation, double visibleRegion, Context context, SearchAddress destinationCoordinates) {
        return this.stopsRepository.getStopsFromMap(currentLocation, visibleRegion, context, destinationCoordinates);
    }

    @Override // com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsViewModel
    public LiveData<Long> insertSearchAddress(SearchAddress searchAddress) {
        final MutableLiveData mutableLiveData = new MutableLiveData();
        this.compositeDisposable.add(this.routeRepository.insertSearchAddress(searchAddress).subscribeOn(this.schedulerProvider.io()).observeOn(this.schedulerProvider.ui()).subscribe(new Consumer() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsViewModelImpl$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                mutableLiveData.setValue((Long) obj);
            }
        }));
        return mutableLiveData;
    }

    @Override // com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsViewModel
    public LiveData<List<SearchAddress>> getSearchAdress(SearchAddress searchAddress) {
        return this.routeRepository.getSearchAdress(searchAddress);
    }

    @Override // com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsViewModel
    public void deleteOldSearchAddresses() {
        this.compositeDisposable.add(this.routeRepository.deleteOldSearchAddresses().subscribeOn(this.schedulerProvider.io()).observeOn(this.schedulerProvider.ui()).subscribe());
    }
}
