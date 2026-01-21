package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzja {
    private zza[] addressComponents;
    private String businessStatus;
    private Boolean curbsidePickup;
    private zzd currentOpeningHours;
    private Boolean delivery;
    private Boolean dineIn;
    private zzb editorialSummary;
    private String formattedAddress;
    private zzc geometry;
    private String icon;
    private String iconBackgroundColor;
    private String iconMaskBaseUri;
    private String internationalPhoneNumber;
    private String name;
    private zzd openingHours;
    private zze[] photos;
    private String placeId;
    private zzf plusCode;
    private Integer priceLevel;
    private Double rating;
    private Boolean reservable;
    private zzd[] secondaryOpeningHours;
    private Boolean servesBeer;
    private Boolean servesBreakfast;
    private Boolean servesBrunch;
    private Boolean servesDinner;
    private Boolean servesLunch;
    private Boolean servesVegetarianFood;
    private Boolean servesWine;
    private Boolean takeout;
    private String[] types;
    private Integer userRatingsTotal;
    private Integer utcOffset;
    private String website;
    private Boolean wheelchairAccessibleEntrance;

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    class zza {
        private String longName;
        private String shortName;
        private String[] types;

        zza() {
        }

        final zznx zza() {
            String[] strArr = this.types;
            return strArr != null ? zznx.zzk(strArr) : zznx.zzl();
        }

        final String zzb() {
            return this.longName;
        }

        final String zzc() {
            return this.shortName;
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    class zzb {
        private String language;
        private String overview;

        zzb() {
        }

        final String zza() {
            return this.language;
        }

        final String zzb() {
            return this.overview;
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    class zzc {
        private zza location;
        private zzb viewport;

        /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
        class zza {
            private Double lat;
            private Double lng;

            zza() {
            }

            final Double zza() {
                return this.lat;
            }

            final Double zzb() {
                return this.lng;
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
        class zzb {
            private zza northeast;
            private zza southwest;

            zzb() {
            }

            final zza zza() {
                return this.northeast;
            }

            final zza zzb() {
                return this.southwest;
            }
        }

        zzc() {
        }

        final zza zza() {
            return this.location;
        }

        final zzb zzb() {
            return this.viewport;
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    class zzd {
        private zza[] periods;
        private zzb[] specialDays;
        private String type;
        private String[] weekdayText;

        /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
        class zza {
            private zzc close;
            private zzc open;

            zza() {
            }

            final zzc zza() {
                return this.close;
            }

            final zzc zzb() {
                return this.open;
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
        class zzb {
            private String date;
            private Boolean exceptionalHours;

            zzb() {
            }

            final Boolean zza() {
                return this.exceptionalHours;
            }

            final String zzb() {
                return this.date;
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
        class zzc {
            private String date;
            private Integer day;
            private String time;
            private Boolean truncated;

            zzc() {
            }

            final Boolean zza() {
                return this.truncated;
            }

            final Integer zzb() {
                return this.day;
            }

            final String zzc() {
                return this.date;
            }

            final String zzd() {
                return this.time;
            }
        }

        zzd() {
        }

        final zznx zza() {
            zza[] zzaVarArr = this.periods;
            return zzaVarArr != null ? zznx.zzk(zzaVarArr) : zznx.zzl();
        }

        final zznx zzb() {
            zzb[] zzbVarArr = this.specialDays;
            return zzbVarArr != null ? zznx.zzk(zzbVarArr) : zznx.zzl();
        }

        final zznx zzc() {
            String[] strArr = this.weekdayText;
            return strArr != null ? zznx.zzk(strArr) : zznx.zzl();
        }

        final String zzd() {
            return this.type;
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    class zze {
        private Integer height;
        private String[] htmlAttributions;
        private String photoReference;
        private Integer width;

        zze() {
        }

        final zznx zza() {
            String[] strArr = this.htmlAttributions;
            return strArr != null ? zznx.zzk(strArr) : zznx.zzl();
        }

        final Integer zzb() {
            return this.height;
        }

        final Integer zzc() {
            return this.width;
        }

        final String zzd() {
            return this.photoReference;
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    class zzf {
        private String compoundCode;
        private String globalCode;

        zzf() {
        }

        final String zza() {
            return this.compoundCode;
        }

        final String zzb() {
            return this.globalCode;
        }
    }

    zzja() {
    }

    final String zzA() {
        return this.formattedAddress;
    }

    final String zzB() {
        return this.iconBackgroundColor;
    }

    final String zzC() {
        return this.iconMaskBaseUri;
    }

    final String zzD() {
        return this.internationalPhoneNumber;
    }

    final String zzE() {
        return this.name;
    }

    final String zzF() {
        return this.placeId;
    }

    final String zzG() {
        return this.website;
    }

    final zzb zza() {
        return this.editorialSummary;
    }

    final zzc zzb() {
        return this.geometry;
    }

    final zzd zzc() {
        return this.currentOpeningHours;
    }

    final zzd zzd() {
        return this.openingHours;
    }

    final zzf zze() {
        return this.plusCode;
    }

    final zznx zzf() {
        zza[] zzaVarArr = this.addressComponents;
        return zzaVarArr != null ? zznx.zzk(zzaVarArr) : zznx.zzl();
    }

    final zznx zzg() {
        zze[] zzeVarArr = this.photos;
        return zzeVarArr != null ? zznx.zzk(zzeVarArr) : zznx.zzl();
    }

    final zznx zzh() {
        zzd[] zzdVarArr = this.secondaryOpeningHours;
        return zzdVarArr != null ? zznx.zzk(zzdVarArr) : zznx.zzl();
    }

    final zznx zzi() {
        String[] strArr = this.types;
        return strArr != null ? zznx.zzk(strArr) : zznx.zzl();
    }

    final Boolean zzj() {
        return this.curbsidePickup;
    }

    final Boolean zzk() {
        return this.delivery;
    }

    final Boolean zzl() {
        return this.dineIn;
    }

    final Boolean zzm() {
        return this.reservable;
    }

    final Boolean zzn() {
        return this.servesBeer;
    }

    final Boolean zzo() {
        return this.servesBreakfast;
    }

    final Boolean zzp() {
        return this.servesDinner;
    }

    final Boolean zzq() {
        return this.servesLunch;
    }

    final Boolean zzr() {
        return this.servesVegetarianFood;
    }

    final Boolean zzs() {
        return this.servesWine;
    }

    final Boolean zzt() {
        return this.takeout;
    }

    final Boolean zzu() {
        return this.wheelchairAccessibleEntrance;
    }

    final Double zzv() {
        return this.rating;
    }

    final Integer zzw() {
        return this.priceLevel;
    }

    final Integer zzx() {
        return this.userRatingsTotal;
    }

    final Integer zzy() {
        return this.utcOffset;
    }

    final String zzz() {
        return this.businessStatus;
    }
}
