package com.iecisa.ctausuario.utils.maputils;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.MapStop;

/* loaded from: classes5.dex */
public class MarkerClusterRenderer extends DefaultClusterRenderer<MapStop> {
    private BitmapDescriptor clusterableIcon;
    private Context context;
    private BitmapDescriptor nonClusterableIcon;

    public MarkerClusterRenderer(Context context, GoogleMap map, ClusterManager<MapStop> clusterManager, BitmapDescriptor clusterableIcon, BitmapDescriptor nonClusterableIcon) {
        super(context, map, clusterManager);
        this.context = context;
        this.clusterableIcon = clusterableIcon;
        this.nonClusterableIcon = nonClusterableIcon;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.maps.android.clustering.view.DefaultClusterRenderer
    public void onClusterItemRendered(MapStop mapStop, Marker marker) {
        super.onClusterItemRendered((MarkerClusterRenderer) mapStop, marker);
        if (mapStop.isClusterable()) {
            marker.setIcon(this.clusterableIcon);
        } else {
            marker.setIcon(this.nonClusterableIcon);
        }
    }

    @Override // com.google.maps.android.clustering.view.DefaultClusterRenderer
    protected void onClusterRendered(Cluster<MapStop> cluster, Marker marker) {
        super.onClusterRendered(cluster, marker);
        marker.setTitle(null);
        marker.setSnippet(this.context.getString(R.string.label_map_cluster));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.maps.android.clustering.view.DefaultClusterRenderer
    public void onBeforeClusterItemRendered(MapStop item, MarkerOptions markerOptions) {
        markerOptions.title(null);
        markerOptions.snippet(item.getSnippet());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.maps.android.clustering.view.DefaultClusterRenderer
    public void onClusterItemUpdated(MapStop item, Marker marker) {
        super.onClusterItemUpdated((MarkerClusterRenderer) item, marker);
        marker.setTitle(null);
        marker.setSnippet(item.getSnippet());
    }
}
