package jj2000.j2k.image;

import jj2000.j2k.ModuleSpec;

/* loaded from: classes5.dex */
public class CompTransfSpec extends ModuleSpec {
    public CompTransfSpec(int i, int i2, byte b) {
        super(i, i2, b);
    }

    public boolean isCompTransfUsed() {
        if (((Integer) this.def).intValue() != 0) {
            return true;
        }
        if (this.tileDef == null) {
            return false;
        }
        for (int i = this.nTiles - 1; i >= 0; i--) {
            if (this.tileDef[i] != null && ((Integer) this.tileDef[i]).intValue() != 0) {
                return true;
            }
        }
        return false;
    }
}
