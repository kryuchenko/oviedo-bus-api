package com.iecisa.ctausuario.ui.main.stops.searchstop;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.MapStop;
import java.util.List;

/* loaded from: classes5.dex */
public interface SearchStopViewModel {
    LiveData<Resource<List<MapStop>>> getSearchPlaces(String searchQuery, Context context);
}
