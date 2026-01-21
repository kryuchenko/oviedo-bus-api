package com.iecisa.ctausuario.ui.main.datelines;

import android.app.DatePickerDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.MapStop;
import com.iecisa.ctausuario.model.StopItinerary;
import com.iecisa.ctausuario.model.StopTime;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class DateTimeLineActivity extends CustomToolbarActivity {
    private String date;
    private DateTimeLineViewModel dateTimeLineViewModel;

    @BindView(R.id.gvTimesForStopLine)
    GridView gvTimesForStopLine;
    private Calendar selectedDateTime;
    private Integer stopId;
    private MapStop stopItinerary;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvDateToTime)
    TextView tvDateToTime;

    @BindView(R.id.tvErrorTimesForStop)
    TextView tvErrorTimesForStop;

    @BindView(R.id.tvIdStopLine)
    TextView tvIdStopLine;

    @BindView(R.id.tvNameStopLine)
    TextView tvNameStopLine;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_date_time_line;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.dateTimeLineViewModel = (DateTimeLineViewModel) new ViewModelProvider(this, this.viewModelFactory).get(DateTimeLineViewModelImpl.class);
        if (getIntent().getExtras() != null) {
            this.stopItinerary = DetailStopActivity.getMapStop();
            setUpViews((StopItinerary) getIntent().getExtras().getParcelable(Constants.IntentData.INTENT_STOP_DETAIL), this.stopItinerary);
        }
    }

    private void setUpViews(StopItinerary stop, MapStop favouriteStop) {
        this.stopId = stop.getId();
        initializeDateTime();
        this.tvNameStopLine.setText(stop.getName());
        this.tvIdStopLine.setVisibility(4);
        setUpToolbar(stop);
        getTimesForStop(stop.getId());
    }

    @OnClick({R.id.tvDateToTime})
    public void onClickEvents(View view) {
        if (view.getId() != R.id.tvDateToTime) {
            return;
        }
        showDatePicker();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return true;
    }

    private void setUpToolbar(StopItinerary stop) {
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_line_detail));
        if (TextUtils.isEmpty(stop.getDirectionDesc())) {
            return;
        }
        setToolbarTitle(stop.getDirectionDesc());
    }

    private void initializeDateTime() {
        this.selectedDateTime = Calendar.getInstance();
        this.date = new SimpleDateFormat(DateUtils.ZULU_DATE_FORMAT, Locale.ENGLISH).format(this.selectedDateTime.getTime());
        this.tvDateToTime.setText(new SimpleDateFormat(DateUtils.DATE_FORMAT, Locale.ENGLISH).format(this.selectedDateTime.getTime()));
    }

    private void showDatePicker() {
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() { // from class: com.iecisa.ctausuario.ui.main.datelines.DateTimeLineActivity$$ExternalSyntheticLambda0
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$showDatePicker$0(datePicker, i, i2, i3);
            }
        }, this.selectedDateTime.get(1), this.selectedDateTime.get(2), this.selectedDateTime.get(5)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDatePicker$0(DatePicker datePicker, int i, int i2, int i3) {
        this.selectedDateTime.set(1, i);
        this.selectedDateTime.set(2, i2);
        this.selectedDateTime.set(5, i3);
        this.date = new SimpleDateFormat(DateUtils.ZULU_DATE_FORMAT, Locale.ENGLISH).format(this.selectedDateTime.getTime());
        this.tvDateToTime.setText(new SimpleDateFormat(DateUtils.DATE_FORMAT, Locale.ENGLISH).format(this.selectedDateTime.getTime()));
        getTimesForStop(this.stopId);
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.datelines.DateTimeLineActivity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$cexmobility$core$data$Resource$Status;

        static {
            int[] iArr = new int[Resource.Status.values().length];
            $SwitchMap$com$cexmobility$core$data$Resource$Status = iArr;
            try {
                iArr[Resource.Status.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$cexmobility$core$data$Resource$Status[Resource.Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$cexmobility$core$data$Resource$Status[Resource.Status.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void getTimesForStop(Integer stopId) {
        this.dateTimeLineViewModel.getTimesForStop(stopId, this, this.date).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.datelines.DateTimeLineActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getTimesForStop$1((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTimesForStop$1(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(this, resource.message);
            return;
        }
        if (i == 2) {
            showLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        if (resource.data != 0 && ((List) resource.data).size() > 0) {
            if (this.gvTimesForStopLine.getAdapter() == null) {
                setUpDateTime((List) resource.data);
            } else {
                updateDateTime((List) resource.data);
            }
            hideErrorNoTimesForStop();
        } else {
            showErrorNoTimesForStop();
        }
        hideLoading();
    }

    private void setUpDateTime(List<StopTime> listStopTime) {
        this.gvTimesForStopLine.setAdapter((ListAdapter) new TimesAdapter(listStopTime, this));
        this.tvIdStopLine.setVisibility(0);
        this.tvIdStopLine.setText(getString(R.string.label_id_stop, new Object[]{String.valueOf(listStopTime.get(0).getId())}));
        ViewCompat.setNestedScrollingEnabled(this.gvTimesForStopLine, true);
    }

    private void updateDateTime(List<StopTime> listStopTime) {
        TimesAdapter timesAdapter = (TimesAdapter) this.gvTimesForStopLine.getAdapter();
        timesAdapter.setListTimes(listStopTime);
        timesAdapter.notifyDataSetChanged();
    }

    private void showErrorNoTimesForStop() {
        this.tvErrorTimesForStop.setVisibility(0);
        GridView gridView = this.gvTimesForStopLine;
        if (gridView != null) {
            gridView.setVisibility(4);
        }
    }

    private void hideErrorNoTimesForStop() {
        this.tvErrorTimesForStop.setVisibility(4);
        GridView gridView = this.gvTimesForStopLine;
        if (gridView != null) {
            gridView.setVisibility(0);
        }
    }
}
