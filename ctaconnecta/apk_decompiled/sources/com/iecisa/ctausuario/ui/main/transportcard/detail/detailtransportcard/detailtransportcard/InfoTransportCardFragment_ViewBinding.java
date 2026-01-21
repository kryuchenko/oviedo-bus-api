package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.detailtransportcard;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class InfoTransportCardFragment_ViewBinding implements Unbinder {
    private InfoTransportCardFragment target;

    public InfoTransportCardFragment_ViewBinding(InfoTransportCardFragment target, View source) {
        this.target = target;
        target.rvZones = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvZones, "field 'rvZones'", RecyclerView.class);
        target.rvDiscount = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvDiscount, "field 'rvDiscount'", RecyclerView.class);
        target.tvLabelCardOwner = (TextView) Utils.findRequiredViewAsType(source, R.id.tvLabelCardOwner, "field 'tvLabelCardOwner'", TextView.class);
        target.tvUserName = (TextView) Utils.findRequiredViewAsType(source, R.id.tvUserName, "field 'tvUserName'", TextView.class);
        target.tvLabelSpendInfo = (TextView) Utils.findRequiredViewAsType(source, R.id.tvLabelSpendInfo, "field 'tvLabelSpendInfo'", TextView.class);
        target.tvSpendInfo = (TextView) Utils.findRequiredViewAsType(source, R.id.tvSpendInfo, "field 'tvSpendInfo'", TextView.class);
        target.gpDiscount = (Group) Utils.findRequiredViewAsType(source, R.id.gpDiscount, "field 'gpDiscount'", Group.class);
        target.gpZones = (Group) Utils.findRequiredViewAsType(source, R.id.gpZones, "field 'gpZones'", Group.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        InfoTransportCardFragment infoTransportCardFragment = this.target;
        if (infoTransportCardFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        infoTransportCardFragment.rvZones = null;
        infoTransportCardFragment.rvDiscount = null;
        infoTransportCardFragment.tvLabelCardOwner = null;
        infoTransportCardFragment.tvUserName = null;
        infoTransportCardFragment.tvLabelSpendInfo = null;
        infoTransportCardFragment.tvSpendInfo = null;
        infoTransportCardFragment.gpDiscount = null;
        infoTransportCardFragment.gpZones = null;
    }
}
