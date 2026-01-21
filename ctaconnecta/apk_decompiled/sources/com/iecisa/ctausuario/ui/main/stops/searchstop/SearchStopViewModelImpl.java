package com.iecisa.ctausuario.ui.main.stops.searchstop;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.StopsRepository;
import com.iecisa.ctausuario.model.MapStop;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SearchStopViewModelImpl extends BaseViewModel implements SearchStopViewModel {
    private StopsRepository stopsRepository;

    @Inject
    public SearchStopViewModelImpl(Application application, StopsRepository stopsRepository) {
        super(application);
        this.stopsRepository = stopsRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.stops.searchstop.SearchStopViewModel
    public LiveData<Resource<List<MapStop>>> getSearchPlaces(String searchQuery, Context context) {
        return this.stopsRepository.getSearchPlaces(searchQuery, context);
    }
}
