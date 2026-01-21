package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class SVGImageView extends ImageView {
    private static Method setLayerTypeMethod;

    public SVGImageView(Context context) {
        super(context);
        try {
            setLayerTypeMethod = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    public SVGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        try {
            setLayerTypeMethod = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
        init(attributeSet, 0);
    }

    public SVGImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            setLayerTypeMethod = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGImageView, i, 0);
        try {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
            if (resourceId != -1) {
                setImageResource(resourceId);
                return;
            }
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                if (internalSetImageURI(Uri.parse(string), false)) {
                } else {
                    setImageAsset(string);
                }
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setSVG(SVG svg) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (svg == null) {
            throw new IllegalArgumentException("Null value passed to setSVG()");
        }
        setSoftwareLayerType();
        setImageDrawable(new PictureDrawable(svg.renderToPicture()));
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            SVG fromResource = SVG.getFromResource(getContext(), i);
            setSoftwareLayerType();
            setImageDrawable(new PictureDrawable(fromResource.renderToPicture()));
        } catch (SVGParseException e) {
            Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", Integer.valueOf(i), e.getMessage()));
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) throws IOException {
        internalSetImageURI(uri, true);
    }

    public void setImageAsset(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            SVG fromAsset = SVG.getFromAsset(getContext().getAssets(), str);
            setSoftwareLayerType();
            setImageDrawable(new PictureDrawable(fromAsset.renderToPicture()));
        } catch (SVGParseException e) {
            Log.e("SVGImageView", "Error loading file " + str + ": " + e.getMessage());
        } catch (FileNotFoundException unused) {
            Log.e("SVGImageView", "File not found: " + str);
        } catch (IOException e2) {
            Log.e("SVGImageView", "Unable to load asset file: " + str, e2);
        }
    }

    private boolean internalSetImageURI(Uri uri, boolean z) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = getContext().getContentResolver().openInputStream(uri);
                SVG fromInputStream = SVG.getFromInputStream(inputStreamOpenInputStream);
                setSoftwareLayerType();
                setImageDrawable(new PictureDrawable(fromInputStream.renderToPicture()));
                if (inputStreamOpenInputStream == null) {
                    return true;
                }
                try {
                    inputStreamOpenInputStream.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (SVGParseException e) {
            Log.e("SVGImageView", "Error loading file " + uri + ": " + e.getMessage());
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException unused3) {
                }
            }
            return false;
        } catch (FileNotFoundException unused4) {
            if (z) {
                Log.e("SVGImageView", "File not found: " + uri);
            }
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException unused5) {
                }
            }
            return false;
        }
    }

    private void setSoftwareLayerType() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (setLayerTypeMethod == null) {
            return;
        }
        try {
            setLayerTypeMethod.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()))), null);
        } catch (Exception e) {
            Log.w("SVGImageView", "Unexpected failure calling setLayerType", e);
        }
    }
}
