package org.spongycastle.pqc.jcajce.interfaces;

import java.security.PrivateKey;

/* loaded from: classes6.dex */
public interface NHPrivateKey extends NHKey, PrivateKey {
    short[] getSecretData();
}
