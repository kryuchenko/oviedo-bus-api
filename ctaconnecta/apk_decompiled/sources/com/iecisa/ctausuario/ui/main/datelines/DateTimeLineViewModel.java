package com.iecisa.ctausuario.ui.main.datelines;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.MapStop;
import com.iecisa.ctausuario.model.StopTime;
import java.util.List;

/* loaded from: classes5.dex */
public interface DateTimeLineViewModel {
    void deleteFavouriteStop(Integer stopId);

    LiveData<Resource<List<StopTime>>> getTimesForStop(Integer stopId, Context context, String date);

    LiveData<Long> insertFavouriteStop(MapStop stop);
}
