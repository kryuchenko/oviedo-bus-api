package com.iecisa.ctausuario.ui.main.transportcard.detail.incident;

import android.app.Application;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.TransportCardRepository;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class IncidentViewModelImpl extends BaseViewModel implements IncidentViewModel {
    private TransportCardRepository transportCardRepository;

    @Inject
    public IncidentViewModelImpl(Application application, TransportCardRepository transportCardRepository) {
        super(application);
        this.transportCardRepository = transportCardRepository;
    }
}
