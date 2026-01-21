package com.iecisa.ctausuario.ui.main.route.selectoradress;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.RouteRepository;
import com.iecisa.ctausuario.model.SearchAddress;
import com.iecisa.ctausuario.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class AddressPickerViewModelImpl extends BaseViewModel implements AddressPickerViewModel {
    private CompositeDisposable compositeDisposable;
    private RouteRepository routeRepository;
    private SchedulerProvider schedulerProvider;

    @Inject
    public AddressPickerViewModelImpl(Application application, RouteRepository routeRepository, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(application);
        this.routeRepository = routeRepository;
        this.compositeDisposable = compositeDisposable;
        this.schedulerProvider = schedulerProvider;
    }

    @Override // com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerViewModel
    public LiveData<List<SearchAddress>> getAllSearchAddress() {
        return this.routeRepository.getAllSearchAddress();
    }

    @Override // com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerViewModel
    public LiveData<Long> insertSearchAddress(SearchAddress searchAddress) {
        final MutableLiveData mutableLiveData = new MutableLiveData();
        this.compositeDisposable.add(this.routeRepository.insertSearchAddress(searchAddress).subscribeOn(this.schedulerProvider.io()).observeOn(this.schedulerProvider.ui()).subscribe(new Consumer() { // from class: com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerViewModelImpl$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                mutableLiveData.setValue((Long) obj);
            }
        }));
        return mutableLiveData;
    }

    @Override // com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerViewModel
    public LiveData<List<SearchAddress>> getSearchAdress(SearchAddress searchAddress) {
        return this.routeRepository.getSearchAdress(searchAddress);
    }

    @Override // com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerViewModel
    public void deleteOldSearchAddresses() {
        this.compositeDisposable.add(this.routeRepository.deleteOldSearchAddresses().subscribeOn(this.schedulerProvider.io()).observeOn(this.schedulerProvider.ui()).subscribe());
    }
}
