package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
interface zzix {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zza(zziw<T> zziwVar, zzgi zzgiVar) throws IOException;

    <T> T zza(Class<T> cls, zzgi zzgiVar) throws IOException;

    void zza(List<Double> list) throws IOException;

    <T> void zza(List<T> list, zziw<T> zziwVar, zzgi zzgiVar) throws IOException;

    <K, V> void zza(Map<K, V> map, zzhy<K, V> zzhyVar, zzgi zzgiVar) throws IOException;

    @Deprecated
    <T> T zzb(Class<T> cls, zzgi zzgiVar) throws IOException;

    void zzb(List<Float> list) throws IOException;

    @Deprecated
    <T> void zzb(List<T> list, zziw<T> zziwVar, zzgi zzgiVar) throws IOException;

    @Deprecated
    <T> T zzc(zziw<T> zziwVar, zzgi zzgiVar) throws IOException;

    void zzc(List<Long> list) throws IOException;

    void zzd(List<Long> list) throws IOException;

    int zzdv() throws IOException;

    boolean zzdw() throws IOException;

    long zzdx() throws IOException;

    long zzdy() throws IOException;

    int zzdz() throws IOException;

    void zze(List<Integer> list) throws IOException;

    long zzea() throws IOException;

    int zzeb() throws IOException;

    boolean zzec() throws IOException;

    String zzed() throws IOException;

    zzfm zzee() throws IOException;

    int zzef() throws IOException;

    int zzeg() throws IOException;

    int zzeh() throws IOException;

    long zzei() throws IOException;

    int zzej() throws IOException;

    long zzek() throws IOException;

    void zzf(List<Long> list) throws IOException;

    void zzg(List<Integer> list) throws IOException;

    void zzh(List<Boolean> list) throws IOException;

    void zzi(List<String> list) throws IOException;

    void zzj(List<zzfm> list) throws IOException;

    void zzk(List<Integer> list) throws IOException;

    void zzl(List<Integer> list) throws IOException;

    void zzm(List<Integer> list) throws IOException;

    void zzn(List<Long> list) throws IOException;

    void zzo(List<Integer> list) throws IOException;

    void zzp(List<Long> list) throws IOException;
}
