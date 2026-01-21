package com.iecisa.ctausuario.ui.main.transportcard.dataprotection;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.dataprotection.ConsentModel;

/* loaded from: classes5.dex */
public class DataProtectionViewHolder extends RecyclerView.ViewHolder {
    private Context context;

    @BindView(R.id.swConditions)
    Switch swConditions;

    public DataProtectionViewHolder(Context context, View itemView) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
    }

    public void bindView(final ConsentModel model, boolean isMandatory) {
        this.swConditions.setText(model.getText());
        this.swConditions.setChecked(model.getAccepted().booleanValue());
        this.swConditions.setEnabled(!isMandatory);
        this.swConditions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.dataprotection.DataProtectionViewHolder$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                model.setAccepted(Boolean.valueOf(z));
            }
        });
    }
}
