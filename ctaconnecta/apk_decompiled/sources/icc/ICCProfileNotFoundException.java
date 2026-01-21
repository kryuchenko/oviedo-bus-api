package icc;

/* loaded from: classes5.dex */
public class ICCProfileNotFoundException extends ICCProfileException {
    ICCProfileNotFoundException(String str) {
        super(str);
    }

    ICCProfileNotFoundException() {
        super("no icc profile in image");
    }
}
