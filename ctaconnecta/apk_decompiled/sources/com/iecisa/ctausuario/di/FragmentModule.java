package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment;
import com.iecisa.ctausuario.ui.main.linesrealtime.lineslist.LinesRealTimeListFragment;
import com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapFragment;
import com.iecisa.ctausuario.ui.main.route.RouteFragment;
import com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesFragment;
import com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsFragment;
import com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsFragment;
import com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment;
import com.iecisa.ctausuario.ui.main.stops.searchstop.SearchStopsFragment;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones.RechargeByZoneFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
/* loaded from: classes5.dex */
public interface FragmentModule {
    @ContributesAndroidInjector
    AllLinesFragment contributesAllLinesFragment();

    @ContributesAndroidInjector
    CalculateZoneFragment contributesCalculateZoneFragment();

    @ContributesAndroidInjector
    FavouriteStopsFragment contributesFavouriteStopsFragment();

    @ContributesAndroidInjector
    IncidentsFragment contributesIncidentsFragment();

    @ContributesAndroidInjector
    LinesRealTimeListFragment contributesLinesRealTimeListFragment();

    @ContributesAndroidInjector
    LinesRealTimeMapFragment contributesLinesRealTimeMapFragment();

    @ContributesAndroidInjector
    MapStopsFragment contributesMapStopsFragment();

    @ContributesAndroidInjector
    NextArrivalsFragment contributesNextArrivalsFragment();

    @ContributesAndroidInjector
    RechargeByZoneFragment contributesRechargeByZoneFragment();

    @ContributesAndroidInjector
    RouteFragment contributesRouteFragment();

    @ContributesAndroidInjector
    SearchStopsFragment contributesSearchStopsFragment();
}
