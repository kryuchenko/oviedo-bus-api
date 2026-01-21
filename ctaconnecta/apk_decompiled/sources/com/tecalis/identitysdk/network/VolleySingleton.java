package com.tecalis.identitysdk.network;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.tecalis.identitysdk.SDK;

/* loaded from: classes5.dex */
public class VolleySingleton {
    private static VolleySingleton instance;
    private RequestQueue requestQueue = Volley.newRequestQueue(SDK.getAppContext());
    private ImageLoader imageLoader = new ImageLoader(this.requestQueue, new ImageLoader.ImageCache() { // from class: com.tecalis.identitysdk.network.VolleySingleton.1
        private LruCache<String, Bitmap> cache = new LruCache<>((int) ((Runtime.getRuntime().maxMemory() / 1024) / 8));

        @Override // com.android.volley.toolbox.ImageLoader.ImageCache
        public Bitmap getBitmap(String str) {
            return this.cache.get(str);
        }

        @Override // com.android.volley.toolbox.ImageLoader.ImageCache
        public void putBitmap(String str, Bitmap bitmap) {
            this.cache.put(str, bitmap);
        }
    });

    private VolleySingleton() {
    }

    public static VolleySingleton getInstance() {
        if (instance == null) {
            instance = new VolleySingleton();
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        return this.requestQueue;
    }

    public ImageLoader getImageLoader() {
        return this.imageLoader;
    }
}
