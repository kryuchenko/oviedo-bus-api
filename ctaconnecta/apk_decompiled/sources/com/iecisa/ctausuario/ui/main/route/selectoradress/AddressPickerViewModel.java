package com.iecisa.ctausuario.ui.main.route.selectoradress;

import androidx.lifecycle.LiveData;
import com.iecisa.ctausuario.model.SearchAddress;
import java.util.List;

/* loaded from: classes5.dex */
public interface AddressPickerViewModel {
    void deleteOldSearchAddresses();

    LiveData<List<SearchAddress>> getAllSearchAddress();

    LiveData<List<SearchAddress>> getSearchAdress(SearchAddress searchAddress);

    LiveData<Long> insertSearchAddress(SearchAddress searchAddress);
}
