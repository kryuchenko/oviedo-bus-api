package com.iecisa.ctausuario.ui.main.route.timepicker;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.TimePicker;
import androidx.fragment.app.DialogFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import java.util.Calendar;

/* loaded from: classes5.dex */
public class TimePickerDialogFragment extends DialogFragment {

    @BindView(R.id.btCancel)
    MaterialButton btCancel;

    @BindView(R.id.btSave)
    MaterialButton btSave;

    @BindView(R.id.dpContainer)
    DatePicker dpContainer;
    private boolean isArrival = false;
    private boolean isTime = false;
    private OnNewClickListener listener;
    private Calendar selectedDateTime;

    @BindView(R.id.tpContainer)
    TimePicker tpContainer;

    @BindView(R.id.tvTimeArrival)
    CheckedTextView tvTimeArrival;

    @BindView(R.id.tvTimeDeparture)
    CheckedTextView tvTimeDeparture;

    public interface OnNewClickListener {
        void onNewClick(boolean isArrival, int day, int month, int year, int hour, int minutes);
    }

    public TimePickerDialogFragment(Calendar selectedDateTime, OnNewClickListener listener) {
        this.selectedDateTime = selectedDateTime;
        this.listener = listener;
    }

    public TimePickerDialogFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws NoSuchMethodException, SecurityException {
        View viewInflate = inflater.inflate(R.layout.fragment_time_picker_dialog, container, false);
        ButterKnife.bind(this, viewInflate);
        this.tpContainer.setIs24HourView(true);
        setCheckedTextViewBackgroundColor(this.tvTimeArrival);
        setCheckedTextViewBackgroundColor(this.tvTimeDeparture);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick({R.id.tvTimeArrival, R.id.tvTimeDeparture, R.id.btCancel, R.id.btSave})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btCancel /* 2131361921 */:
                if (this.isTime) {
                    showFields(false);
                    break;
                } else {
                    dismiss();
                    break;
                }
            case R.id.btSave /* 2131361943 */:
                if (!this.isTime) {
                    showFields(true);
                    break;
                } else {
                    saveData();
                    dismiss();
                    break;
                }
            case R.id.tvTimeArrival /* 2131362963 */:
                this.isArrival = true;
                this.tvTimeArrival.setChecked(true);
                setCheckedTextViewBackgroundColor(this.tvTimeArrival);
                this.tvTimeDeparture.setChecked(false);
                setCheckedTextViewBackgroundColor(this.tvTimeDeparture);
                break;
            case R.id.tvTimeDeparture /* 2131362965 */:
                this.isArrival = false;
                this.tvTimeDeparture.setChecked(true);
                setCheckedTextViewBackgroundColor(this.tvTimeDeparture);
                this.tvTimeArrival.setChecked(false);
                setCheckedTextViewBackgroundColor(this.tvTimeArrival);
                break;
        }
    }

    private void setCheckedTextViewBackgroundColor(CheckedTextView checkedTextView) {
        Resources resources;
        int i;
        if (checkedTextView.isChecked()) {
            resources = getResources();
            i = R.color.colorPrimary;
        } else {
            resources = getResources();
            i = R.color.white;
        }
        checkedTextView.setBackgroundColor(resources.getColor(i));
    }

    private void saveData() {
        int iIntValue;
        int iIntValue2;
        if (Build.VERSION.SDK_INT >= 23) {
            iIntValue = this.tpContainer.getHour();
            iIntValue2 = this.tpContainer.getMinute();
        } else {
            iIntValue = this.tpContainer.getCurrentHour().intValue();
            iIntValue2 = this.tpContainer.getCurrentMinute().intValue();
        }
        this.listener.onNewClick(this.isArrival, this.dpContainer.getDayOfMonth(), this.dpContainer.getMonth(), this.dpContainer.getYear(), iIntValue, iIntValue2);
    }

    private void showFields(boolean timer) {
        this.btCancel.setText(getString(timer ? R.string.label_back : R.string.label_cancel));
        this.btSave.setText(getString(timer ? R.string.label_save : R.string.label_next));
        this.tpContainer.setVisibility(timer ? 0 : 4);
        this.dpContainer.setVisibility(timer ? 4 : 0);
        this.isTime = !this.isTime;
    }
}
