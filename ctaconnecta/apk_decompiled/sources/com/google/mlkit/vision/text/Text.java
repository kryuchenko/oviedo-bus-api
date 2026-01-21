package com.google.mlkit.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public class Text {
    private final List<TextBlock> zza = new ArrayList();
    private final String zzb;

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static class Line extends TextBase {
        private final List<Element> zza;

        public String getText() {
            return zza();
        }

        Line(com.google.android.gms.vision.text.Line line) {
            super(line);
            this.zza = new ArrayList();
            for (com.google.android.gms.vision.text.Text text : line.getComponents()) {
                if (text instanceof com.google.android.gms.vision.text.Element) {
                    this.zza.add(new Element((com.google.android.gms.vision.text.Element) text));
                } else {
                    Log.e("Text", "A subcomponent of line is should be an element!");
                }
            }
        }

        public synchronized List<Element> getElements() {
            return this.zza;
        }

        @Override // com.google.mlkit.vision.text.Text.TextBase
        public /* bridge */ /* synthetic */ String getRecognizedLanguage() {
            return super.getRecognizedLanguage();
        }

        @Override // com.google.mlkit.vision.text.Text.TextBase
        public /* bridge */ /* synthetic */ Point[] getCornerPoints() {
            return super.getCornerPoints();
        }

        @Override // com.google.mlkit.vision.text.Text.TextBase
        public /* bridge */ /* synthetic */ Rect getBoundingBox() {
            return super.getBoundingBox();
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static class TextBlock extends TextBase {
        private final List<Line> zza;

        public String getText() {
            return zza();
        }

        TextBlock(com.google.android.gms.vision.text.TextBlock textBlock) {
            super(textBlock);
            this.zza = new ArrayList();
            for (com.google.android.gms.vision.text.Text text : textBlock.getComponents()) {
                if (text instanceof com.google.android.gms.vision.text.Line) {
                    this.zza.add(new Line((com.google.android.gms.vision.text.Line) text));
                } else {
                    Log.e("Text", "A subcomponent of textblock is should be a line!");
                }
            }
        }

        public synchronized List<Line> getLines() {
            return this.zza;
        }

        @Override // com.google.mlkit.vision.text.Text.TextBase
        public /* bridge */ /* synthetic */ String getRecognizedLanguage() {
            return super.getRecognizedLanguage();
        }

        @Override // com.google.mlkit.vision.text.Text.TextBase
        public /* bridge */ /* synthetic */ Point[] getCornerPoints() {
            return super.getCornerPoints();
        }

        @Override // com.google.mlkit.vision.text.Text.TextBase
        public /* bridge */ /* synthetic */ Rect getBoundingBox() {
            return super.getBoundingBox();
        }
    }

    public List<TextBlock> getTextBlocks() {
        return Collections.unmodifiableList(this.zza);
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static class Element extends TextBase {
        Element(com.google.android.gms.vision.text.Element element) {
            super(element);
        }

        public String getText() {
            return zza();
        }

        @Override // com.google.mlkit.vision.text.Text.TextBase
        public /* bridge */ /* synthetic */ String getRecognizedLanguage() {
            return super.getRecognizedLanguage();
        }

        @Override // com.google.mlkit.vision.text.Text.TextBase
        public /* bridge */ /* synthetic */ Point[] getCornerPoints() {
            return super.getCornerPoints();
        }

        @Override // com.google.mlkit.vision.text.Text.TextBase
        public /* bridge */ /* synthetic */ Rect getBoundingBox() {
            return super.getBoundingBox();
        }
    }

    public String getText() {
        return this.zzb;
    }

    public Text(SparseArray<com.google.android.gms.vision.text.TextBlock> sparseArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sparseArray.size(); i++) {
            com.google.android.gms.vision.text.TextBlock textBlock = sparseArray.get(sparseArray.keyAt(i));
            if (textBlock != null) {
                TextBlock textBlock2 = new TextBlock(textBlock);
                this.zza.add(textBlock2);
                if (sb.length() != 0) {
                    sb.append("\n");
                }
                if (textBlock.getValue() != null) {
                    sb.append(textBlock2.getText());
                }
            }
        }
        this.zzb = sb.toString();
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    static class TextBase {
        private final String zza;
        private final Rect zzb;
        private final Point[] zzc;
        private final String zzd;

        TextBase(com.google.android.gms.vision.text.Text text) {
            Preconditions.checkNotNull(text, "Text to construct Text classes can't be null");
            this.zza = text.getValue();
            this.zzb = text.getBoundingBox();
            this.zzc = text.getCornerPoints();
            this.zzd = text.getLanguage();
        }

        public Rect getBoundingBox() {
            return this.zzb;
        }

        public Point[] getCornerPoints() {
            return this.zzc;
        }

        protected final String zza() {
            String str = this.zza;
            return str == null ? "" : str;
        }

        public String getRecognizedLanguage() {
            return this.zzd;
        }
    }
}
