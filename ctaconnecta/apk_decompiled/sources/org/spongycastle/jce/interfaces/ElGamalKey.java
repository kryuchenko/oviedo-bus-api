package org.spongycastle.jce.interfaces;

import javax.crypto.interfaces.DHKey;
import org.spongycastle.jce.spec.ElGamalParameterSpec;

/* loaded from: classes6.dex */
public interface ElGamalKey extends DHKey {
    ElGamalParameterSpec getParameters();
}
