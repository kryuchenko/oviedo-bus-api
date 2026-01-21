package com.iecisa.ctausuario.ui.main.datelines;

import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class DateTimeLineActivity_ViewBinding implements Unbinder {
    private DateTimeLineActivity target;
    private View view7f0a03e9;

    public DateTimeLineActivity_ViewBinding(DateTimeLineActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public DateTimeLineActivity_ViewBinding(final DateTimeLineActivity target, View source) {
        this.target = target;
        target.tvNameStopLine = (TextView) Utils.findRequiredViewAsType(source, R.id.tvNameStopLine, "field 'tvNameStopLine'", TextView.class);
        target.tvIdStopLine = (TextView) Utils.findRequiredViewAsType(source, R.id.tvIdStopLine, "field 'tvIdStopLine'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.tvDateToTime, "field 'tvDateToTime' and method 'onClickEvents'");
        target.tvDateToTime = (TextView) Utils.castView(viewFindRequiredView, R.id.tvDateToTime, "field 'tvDateToTime'", TextView.class);
        this.view7f0a03e9 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.datelines.DateTimeLineActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents(p0);
            }
        });
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.tvErrorTimesForStop = (TextView) Utils.findRequiredViewAsType(source, R.id.tvErrorTimesForStop, "field 'tvErrorTimesForStop'", TextView.class);
        target.gvTimesForStopLine = (GridView) Utils.findRequiredViewAsType(source, R.id.gvTimesForStopLine, "field 'gvTimesForStopLine'", GridView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DateTimeLineActivity dateTimeLineActivity = this.target;
        if (dateTimeLineActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        dateTimeLineActivity.tvNameStopLine = null;
        dateTimeLineActivity.tvIdStopLine = null;
        dateTimeLineActivity.tvDateToTime = null;
        dateTimeLineActivity.toolbar = null;
        dateTimeLineActivity.tvErrorTimesForStop = null;
        dateTimeLineActivity.gvTimesForStopLine = null;
        this.view7f0a03e9.setOnClickListener(null);
        this.view7f0a03e9 = null;
    }
}
