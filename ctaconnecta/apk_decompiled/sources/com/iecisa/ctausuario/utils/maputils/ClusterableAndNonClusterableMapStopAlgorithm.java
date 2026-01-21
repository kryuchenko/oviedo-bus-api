package com.iecisa.ctausuario.utils.maputils;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.iecisa.ctausuario.model.MapStop;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes5.dex */
public class ClusterableAndNonClusterableMapStopAlgorithm extends NonHierarchicalDistanceBasedAlgorithm<MapStop> {
    private Collection<Cluster<MapStop>> listOfIndividualMapStops = new ArrayList();

    @Override // com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm, com.google.maps.android.clustering.algo.Algorithm
    public boolean addItem(MapStop mapStop) {
        if (mapStop == null) {
            return false;
        }
        if (mapStop.isClusterable()) {
            return super.addItem((ClusterableAndNonClusterableMapStopAlgorithm) mapStop);
        }
        this.listOfIndividualMapStops.add(new SingleItemCluster(mapStop));
        return true;
    }

    @Override // com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm, com.google.maps.android.clustering.algo.Algorithm
    public void clearItems() {
        super.clearItems();
        this.listOfIndividualMapStops.clear();
    }

    @Override // com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm, com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItem(MapStop mapStop) {
        if (mapStop == null) {
            return false;
        }
        if (mapStop.isClusterable()) {
            return super.removeItem((ClusterableAndNonClusterableMapStopAlgorithm) mapStop);
        }
        if (this.listOfIndividualMapStops.isEmpty()) {
            return false;
        }
        Iterator<Cluster<MapStop>> it = this.listOfIndividualMapStops.iterator();
        while (it.hasNext()) {
            if (it.next().getItems().contains(mapStop)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override // com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm, com.google.maps.android.clustering.algo.Algorithm
    public Set<Cluster<MapStop>> getClusters(float zoom) {
        Set<Cluster<MapStop>> clusters = super.getClusters(zoom);
        clusters.addAll(this.listOfIndividualMapStops);
        return clusters;
    }

    public boolean contains(MapStop mapStop) {
        if (mapStop.isClusterable()) {
            return super.getItems().contains(mapStop);
        }
        return this.listOfIndividualMapStops.contains(mapStop);
    }

    private static class SingleItemCluster implements Cluster<MapStop> {
        private final MapStop mapStop;

        @Override // com.google.maps.android.clustering.Cluster
        public int getSize() {
            return 1;
        }

        SingleItemCluster(MapStop mapPin) {
            this.mapStop = mapPin;
        }

        @Override // com.google.maps.android.clustering.Cluster
        public LatLng getPosition() {
            return this.mapStop.getPosition();
        }

        @Override // com.google.maps.android.clustering.Cluster
        public Collection getItems() {
            return Collections.singleton(this.mapStop);
        }
    }
}
