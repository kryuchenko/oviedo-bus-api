package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ResolutionSelector {
    private final ExtraCroppingQuirk mExtraCroppingQuirk;

    public ResolutionSelector() {
        this((ExtraCroppingQuirk) DeviceQuirks.get(ExtraCroppingQuirk.class));
    }

    ResolutionSelector(ExtraCroppingQuirk extraCroppingQuirk) {
        this.mExtraCroppingQuirk = extraCroppingQuirk;
    }

    public List<Size> insertOrPrioritize(SurfaceConfig.ConfigType configType, List<Size> list) {
        Size verifiedResolution;
        ExtraCroppingQuirk extraCroppingQuirk = this.mExtraCroppingQuirk;
        if (extraCroppingQuirk == null || (verifiedResolution = extraCroppingQuirk.getVerifiedResolution(configType)) == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(verifiedResolution);
        for (Size size : list) {
            if (!size.equals(verifiedResolution)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }
}
