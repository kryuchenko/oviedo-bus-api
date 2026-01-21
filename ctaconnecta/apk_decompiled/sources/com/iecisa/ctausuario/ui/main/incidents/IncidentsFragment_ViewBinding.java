package com.iecisa.ctausuario.ui.main.incidents;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class IncidentsFragment_ViewBinding implements Unbinder {
    private IncidentsFragment target;
    private View view7f0a0080;
    private View view7f0a0098;
    private View view7f0a00bf;
    private View view7f0a0157;
    private TextWatcher view7f0a0157TextWatcher;
    private View view7f0a015d;
    private TextWatcher view7f0a015dTextWatcher;
    private View view7f0a0163;
    private TextWatcher view7f0a0163TextWatcher;
    private View view7f0a0165;
    private TextWatcher view7f0a0165TextWatcher;
    private View view7f0a016e;
    private TextWatcher view7f0a016eTextWatcher;
    private View view7f0a016f;
    private TextWatcher view7f0a016fTextWatcher;
    private View view7f0a0170;
    private TextWatcher view7f0a0170TextWatcher;
    private View view7f0a01ef;
    private View view7f0a01ff;
    private View view7f0a0255;
    private View view7f0a040e;

    public IncidentsFragment_ViewBinding(final IncidentsFragment target, View source) {
        this.target = target;
        target.tvInfoMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoMessage, "field 'tvInfoMessage'", TextView.class);
        target.sTypeIncident = (AutoCompleteTextView) Utils.findRequiredViewAsType(source, R.id.sTypeIncident, "field 'sTypeIncident'", AutoCompleteTextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.etCommentIncidence, "field 'etCommentIncidence' and method 'onTextChangedComment'");
        target.etCommentIncidence = (EditText) Utils.castView(viewFindRequiredView, R.id.etCommentIncidence, "field 'etCommentIncidence'", EditText.class);
        this.view7f0a0157 = viewFindRequiredView;
        TextWatcher textWatcher = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_ViewBinding.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedComment(p0);
            }
        };
        this.view7f0a0157TextWatcher = textWatcher;
        ((TextView) viewFindRequiredView).addTextChangedListener(textWatcher);
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.etName, "field 'etUserName' and method 'onTextChangedUserName'");
        target.etUserName = (EditText) Utils.castView(viewFindRequiredView2, R.id.etName, "field 'etUserName'", EditText.class);
        this.view7f0a0163 = viewFindRequiredView2;
        TextWatcher textWatcher2 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_ViewBinding.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedUserName(p0);
            }
        };
        this.view7f0a0163TextWatcher = textWatcher2;
        ((TextView) viewFindRequiredView2).addTextChangedListener(textWatcher2);
        View viewFindRequiredView3 = Utils.findRequiredView(source, R.id.etSurname, "field 'etUserSurname' and method 'onTextChangedUserSurname'");
        target.etUserSurname = (EditText) Utils.castView(viewFindRequiredView3, R.id.etSurname, "field 'etUserSurname'", EditText.class);
        this.view7f0a016f = viewFindRequiredView3;
        TextWatcher textWatcher3 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_ViewBinding.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedUserSurname(p0);
            }
        };
        this.view7f0a016fTextWatcher = textWatcher3;
        ((TextView) viewFindRequiredView3).addTextChangedListener(textWatcher3);
        View viewFindRequiredView4 = Utils.findRequiredView(source, R.id.etLastname, "field 'etLastname' and method 'onTextChangedUserLastname'");
        target.etLastname = (EditText) Utils.castView(viewFindRequiredView4, R.id.etLastname, "field 'etLastname'", EditText.class);
        this.view7f0a015d = viewFindRequiredView4;
        TextWatcher textWatcher4 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_ViewBinding.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedUserLastname(p0);
            }
        };
        this.view7f0a015dTextWatcher = textWatcher4;
        ((TextView) viewFindRequiredView4).addTextChangedListener(textWatcher4);
        View viewFindRequiredView5 = Utils.findRequiredView(source, R.id.etUserEmail, "field 'etUserEmail' and method 'onTextChangedUserMail'");
        target.etUserEmail = (EditText) Utils.castView(viewFindRequiredView5, R.id.etUserEmail, "field 'etUserEmail'", EditText.class);
        this.view7f0a0170 = viewFindRequiredView5;
        TextWatcher textWatcher5 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_ViewBinding.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedUserMail(p0);
            }
        };
        this.view7f0a0170TextWatcher = textWatcher5;
        ((TextView) viewFindRequiredView5).addTextChangedListener(textWatcher5);
        View viewFindRequiredView6 = Utils.findRequiredView(source, R.id.etPhone, "field 'etUserPhone' and method 'onTextChangedUserPhone'");
        target.etUserPhone = (EditText) Utils.castView(viewFindRequiredView6, R.id.etPhone, "field 'etUserPhone'", EditText.class);
        this.view7f0a0165 = viewFindRequiredView6;
        TextWatcher textWatcher6 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_ViewBinding.6
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedUserPhone();
            }
        };
        this.view7f0a0165TextWatcher = textWatcher6;
        ((TextView) viewFindRequiredView6).addTextChangedListener(textWatcher6);
        View viewFindRequiredView7 = Utils.findRequiredView(source, R.id.etSecondPhone, "field 'etSecondPhone' and method 'onTextChangedSecondPhone'");
        target.etSecondPhone = (EditText) Utils.castView(viewFindRequiredView7, R.id.etSecondPhone, "field 'etSecondPhone'", EditText.class);
        this.view7f0a016e = viewFindRequiredView7;
        TextWatcher textWatcher7 = new TextWatcher() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_ViewBinding.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                target.onTextChangedSecondPhone();
            }
        };
        this.view7f0a016eTextWatcher = textWatcher7;
        ((TextView) viewFindRequiredView7).addTextChangedListener(textWatcher7);
        View viewFindRequiredView8 = Utils.findRequiredView(source, R.id.cbAceptTerms, "field 'cbAcceptTerms' and method 'onChechedChanged'");
        target.cbAcceptTerms = (CheckBox) Utils.castView(viewFindRequiredView8, R.id.cbAceptTerms, "field 'cbAcceptTerms'", CheckBox.class);
        this.view7f0a00bf = viewFindRequiredView8;
        ((CompoundButton) viewFindRequiredView8).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_ViewBinding.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton p0, boolean p1) {
                target.onChechedChanged(p1);
            }
        });
        View viewFindRequiredView9 = Utils.findRequiredView(source, R.id.mbLogin, "field 'mbLogin' and method 'onEventClickListener'");
        target.mbLogin = (TextView) Utils.castView(viewFindRequiredView9, R.id.mbLogin, "field 'mbLogin'", TextView.class);
        this.view7f0a0255 = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClickListener(p0);
            }
        });
        target.etUserNumberTransportCard = (EditText) Utils.findRequiredViewAsType(source, R.id.etCard, "field 'etUserNumberTransportCard'", EditText.class);
        View viewFindRequiredView10 = Utils.findRequiredView(source, R.id.btSendIncident, "field 'btSendIncident' and method 'onEventClickListener'");
        target.btSendIncident = (MaterialButton) Utils.castView(viewFindRequiredView10, R.id.btSendIncident, "field 'btSendIncident'", MaterialButton.class);
        this.view7f0a0098 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClickListener(p0);
            }
        });
        View viewFindRequiredView11 = Utils.findRequiredView(source, R.id.tvLabelAceptTerms, "field 'tvLabelAcceptTerms' and method 'onEventClickListener'");
        target.tvLabelAcceptTerms = (TextView) Utils.castView(viewFindRequiredView11, R.id.tvLabelAceptTerms, "field 'tvLabelAcceptTerms'", TextView.class);
        this.view7f0a040e = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClickListener(p0);
            }
        });
        View viewFindRequiredView12 = Utils.findRequiredView(source, R.id.btCamera, "field 'btCamera' and method 'onEventClickListener'");
        target.btCamera = (MaterialButton) Utils.castView(viewFindRequiredView12, R.id.btCamera, "field 'btCamera'", MaterialButton.class);
        this.view7f0a0080 = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClickListener(p0);
            }
        });
        target.cvFirstPicture = (CardView) Utils.findRequiredViewAsType(source, R.id.cvFirstPicture, "field 'cvFirstPicture'", CardView.class);
        target.cvSecondPicture = (CardView) Utils.findRequiredViewAsType(source, R.id.cvSecondPicture, "field 'cvSecondPicture'", CardView.class);
        View viewFindRequiredView13 = Utils.findRequiredView(source, R.id.ivFirstPicture, "field 'ivFirstPicture' and method 'onEventClickListener'");
        target.ivFirstPicture = (ImageView) Utils.castView(viewFindRequiredView13, R.id.ivFirstPicture, "field 'ivFirstPicture'", ImageView.class);
        this.view7f0a01ef = viewFindRequiredView13;
        viewFindRequiredView13.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_ViewBinding.13
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClickListener(p0);
            }
        });
        View viewFindRequiredView14 = Utils.findRequiredView(source, R.id.ivSecondPicture, "field 'ivSecondPicture' and method 'onEventClickListener'");
        target.ivSecondPicture = (ImageView) Utils.castView(viewFindRequiredView14, R.id.ivSecondPicture, "field 'ivSecondPicture'", ImageView.class);
        this.view7f0a01ff = viewFindRequiredView14;
        viewFindRequiredView14.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_ViewBinding.14
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onEventClickListener(p0);
            }
        });
        target.ivFirstDelete = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivFirstDelete, "field 'ivFirstDelete'", ImageView.class);
        target.ivSecondDelete = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivSecondDelete, "field 'ivSecondDelete'", ImageView.class);
        target.tvLabelCard = (TextView) Utils.findRequiredViewAsType(source, R.id.tvLabelCard, "field 'tvLabelCard'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        IncidentsFragment incidentsFragment = this.target;
        if (incidentsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        incidentsFragment.tvInfoMessage = null;
        incidentsFragment.sTypeIncident = null;
        incidentsFragment.etCommentIncidence = null;
        incidentsFragment.etUserName = null;
        incidentsFragment.etUserSurname = null;
        incidentsFragment.etLastname = null;
        incidentsFragment.etUserEmail = null;
        incidentsFragment.etUserPhone = null;
        incidentsFragment.etSecondPhone = null;
        incidentsFragment.cbAcceptTerms = null;
        incidentsFragment.mbLogin = null;
        incidentsFragment.etUserNumberTransportCard = null;
        incidentsFragment.btSendIncident = null;
        incidentsFragment.tvLabelAcceptTerms = null;
        incidentsFragment.btCamera = null;
        incidentsFragment.cvFirstPicture = null;
        incidentsFragment.cvSecondPicture = null;
        incidentsFragment.ivFirstPicture = null;
        incidentsFragment.ivSecondPicture = null;
        incidentsFragment.ivFirstDelete = null;
        incidentsFragment.ivSecondDelete = null;
        incidentsFragment.tvLabelCard = null;
        ((TextView) this.view7f0a0157).removeTextChangedListener(this.view7f0a0157TextWatcher);
        this.view7f0a0157TextWatcher = null;
        this.view7f0a0157 = null;
        ((TextView) this.view7f0a0163).removeTextChangedListener(this.view7f0a0163TextWatcher);
        this.view7f0a0163TextWatcher = null;
        this.view7f0a0163 = null;
        ((TextView) this.view7f0a016f).removeTextChangedListener(this.view7f0a016fTextWatcher);
        this.view7f0a016fTextWatcher = null;
        this.view7f0a016f = null;
        ((TextView) this.view7f0a015d).removeTextChangedListener(this.view7f0a015dTextWatcher);
        this.view7f0a015dTextWatcher = null;
        this.view7f0a015d = null;
        ((TextView) this.view7f0a0170).removeTextChangedListener(this.view7f0a0170TextWatcher);
        this.view7f0a0170TextWatcher = null;
        this.view7f0a0170 = null;
        ((TextView) this.view7f0a0165).removeTextChangedListener(this.view7f0a0165TextWatcher);
        this.view7f0a0165TextWatcher = null;
        this.view7f0a0165 = null;
        ((TextView) this.view7f0a016e).removeTextChangedListener(this.view7f0a016eTextWatcher);
        this.view7f0a016eTextWatcher = null;
        this.view7f0a016e = null;
        ((CompoundButton) this.view7f0a00bf).setOnCheckedChangeListener(null);
        this.view7f0a00bf = null;
        this.view7f0a0255.setOnClickListener(null);
        this.view7f0a0255 = null;
        this.view7f0a0098.setOnClickListener(null);
        this.view7f0a0098 = null;
        this.view7f0a040e.setOnClickListener(null);
        this.view7f0a040e = null;
        this.view7f0a0080.setOnClickListener(null);
        this.view7f0a0080 = null;
        this.view7f0a01ef.setOnClickListener(null);
        this.view7f0a01ef = null;
        this.view7f0a01ff.setOnClickListener(null);
        this.view7f0a01ff = null;
    }
}
