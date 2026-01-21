package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.CamcorderProfileResolutionQuirk;
import androidx.camera.core.impl.CamcorderProfileProxy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class CamcorderProfileResolutionValidator {
    private final CamcorderProfileResolutionQuirk mQuirk;
    private final Set<Size> mSupportedResolutions;

    public CamcorderProfileResolutionValidator(CamcorderProfileResolutionQuirk camcorderProfileResolutionQuirk) {
        Set<Size> hashSet;
        this.mQuirk = camcorderProfileResolutionQuirk;
        if (camcorderProfileResolutionQuirk != null) {
            hashSet = new HashSet<>(camcorderProfileResolutionQuirk.getSupportedResolutions());
        } else {
            hashSet = Collections.EMPTY_SET;
        }
        this.mSupportedResolutions = hashSet;
    }

    public boolean hasQuirk() {
        return this.mQuirk != null;
    }

    public boolean hasValidVideoResolution(CamcorderProfileProxy camcorderProfileProxy) {
        if (camcorderProfileProxy == null) {
            return false;
        }
        if (this.mQuirk == null) {
            return true;
        }
        return this.mSupportedResolutions.contains(new Size(camcorderProfileProxy.getVideoFrameWidth(), camcorderProfileProxy.getVideoFrameHeight()));
    }
}
