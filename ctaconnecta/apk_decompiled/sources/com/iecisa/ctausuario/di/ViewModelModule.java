package com.iecisa.ctausuario.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.cexmobility.core.di.ViewModelKey;
import com.cexmobility.core.ui.BaseViewModelFactory;
import com.iecisa.ctausuario.ui.main.BaseTransportCardViewModelImpl;
import com.iecisa.ctausuario.ui.main.MainViewModelImpl;
import com.iecisa.ctausuario.ui.main.datelines.DateTimeLineViewModelImpl;
import com.iecisa.ctausuario.ui.main.incidents.IncidentsViewModelImpl;
import com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeViewModelImpl;
import com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapViewModelImpl;
import com.iecisa.ctausuario.ui.main.more.news.NewsViewModelImpl;
import com.iecisa.ctausuario.ui.main.more.news.newsdetail.NewsDetailViewModelImpl;
import com.iecisa.ctausuario.ui.main.more.settings.SettingsViewModelImpl;
import com.iecisa.ctausuario.ui.main.route.RouteViewModelImpl;
import com.iecisa.ctausuario.ui.main.route.detailroute.DetailRouteViewModelImpl;
import com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerViewModelImpl;
import com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopViewModelImpl;
import com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesViewModelImpl;
import com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsViewModelImpl;
import com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsViewModelImpl;
import com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsViewModelImpl;
import com.iecisa.ctausuario.ui.main.stops.searchstop.SearchStopViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.addcard.AddCardViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.dataprotection.DataProtectionViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.alias.ChangeAliasViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.incident.IncidentViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.readcardnfc.ReadCardNfcViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZonesViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones.RechargeByZoneViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.data.TransportCardRequestDataViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeViewModelImpl;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
/* loaded from: classes5.dex */
public interface ViewModelModule {
    @ViewModelKey(AccessSettingsViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindAccessSettingsViewModelImpl(AccessSettingsViewModelImpl accessSettingsViewModel);

    @ViewModelKey(ActivateAutoRechargeViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindActivateAutoRechargeViewModel(ActivateAutoRechargeViewModelImpl activateAutoRechargeViewModel);

    @ViewModelKey(AddCardViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindAddCardViewModel(AddCardViewModelImpl loadCardViewModel);

    @ViewModelKey(AddressPickerViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindAddressPickerViewModel(AddressPickerViewModelImpl addressPickerViewModel);

    @ViewModelKey(AllLinesViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindAllLinesViewModel(AllLinesViewModelImpl allLinesViewModel);

    @ViewModelKey(AutomaticRechargeViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindAutomaticRechargeViewModelImpl(AutomaticRechargeViewModelImpl automaticRechargeViewModel);

    @ViewModelKey(EditAutomaticRechargeViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindBaseEditAutomaticRechargeViewModel(EditAutomaticRechargeViewModelImpl editAutomaticRechargeViewModel);

    @ViewModelKey(LegalRepresentativeViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindBaseLegalRepresentativeViewModel(LegalRepresentativeViewModelImpl legalRepresentativeViewModelImpl);

    @ViewModelKey(SettingsViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindBaseSettingsViewModel(SettingsViewModelImpl settingsViewModel);

    @ViewModelKey(TransportCardContinueRequestViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindBaseTransportCardContinueRequestViewModel(TransportCardContinueRequestViewModelImpl transportCardContinueRequestViewModelImpl);

    @ViewModelKey(TransportCardRequestDataViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindBaseTransportCardRequestDataViewModel(TransportCardRequestDataViewModelImpl transportCardRequestDataViewModel);

    @ViewModelKey(TransportCardRequestInfoViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindBaseTransportCardRequestInfoViewModel(TransportCardRequestInfoViewModelImpl transportCardRequestInfoViewModel);

    @ViewModelKey(BaseTransportCardViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindBaseTransportCardViewModel(BaseTransportCardViewModelImpl baseTransportCardViewModel);

    @ViewModelKey(CalculateZonesViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindCalculateZonesViewModelImpl(CalculateZonesViewModelImpl calculateZonesViewModel);

    @ViewModelKey(CertificateViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindCertificateViewModelImpl(CertificateViewModelImpl certificateViewModel);

    @ViewModelKey(ChangeAliasViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindChangeAliasViewModelImpl(ChangeAliasViewModelImpl changeAliasViewModel);

    @ViewModelKey(ChangeZonesRechargeViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindChangeZonesRechargeViewModelImpl(ChangeZonesRechargeViewModelImpl changeZonesRechargeViewModel);

    @ViewModelKey(CreateReportsViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindCreateReportsViewModel(CreateReportsViewModelImpl createReportsViewModel);

    @ViewModelKey(DataProtectionViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindDataProtectionViewModelImpl(DataProtectionViewModelImpl dataProtectionViewModel);

    @ViewModelKey(RechargeRedsysViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindDataRechargeRedsysViewModelImpl(RechargeRedsysViewModelImpl rechargeRedsysViewModel);

    @ViewModelKey(RtmViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindDataRtmRechargeCardViewModelImpl(RtmViewModelImpl rtmRechargeCardViewModel);

    @ViewModelKey(DateTimeLineViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindDateTimeLineViewModel(DateTimeLineViewModelImpl dateTimeLineViewModel);

    @ViewModelKey(DetailRouteViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindDetailRouteViewModel(DetailRouteViewModelImpl detailRouteViewModel);

    @ViewModelKey(DetailStopViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindDetailStopViewModel(DetailStopViewModelImpl detailStopViewModel);

    @ViewModelKey(DetailTransportCardViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindDetailTransportCardViewModel(DetailTransportCardViewModelImpl detailTransportCardViewModel);

    @ViewModelKey(FavouriteStopsViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindFavouriteStopsViewModel(FavouriteStopsViewModelImpl favouriteStopsViewModel);

    @ViewModelKey(IncidentViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindIncidentViewModelImpl(IncidentViewModelImpl incidentViewModel);

    @ViewModelKey(IncidentsViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindIncidentsViewModelImpl(IncidentsViewModelImpl incidentsViewModel);

    @ViewModelKey(LargeFamilyDiscountViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindLargeFamilyDiscountViewModelImpl(LargeFamilyDiscountViewModelImpl largeFamilyDiscountViewModel);

    @ViewModelKey(LinesRealTimeMapViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindLinesRealTimeMapViewModel(LinesRealTimeMapViewModelImpl linesRealTimeMapViewModel);

    @ViewModelKey(LinesRealTimeViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindLinesRealTimeViewModel(LinesRealTimeViewModelImpl linesRealTimeViewModel);

    @ViewModelKey(LoginTransportCardViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindLoginTransportCardViewModelImpl(LoginTransportCardViewModelImpl loginTransportCardViewModel);

    @ViewModelKey(LoginUserCardViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindLoginUserCardViewModel(LoginUserCardViewModelImpl loginUserCardViewModel);

    @ViewModelKey(MapStopsViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindMapStopsViewModel(MapStopsViewModelImpl mapStopsViewModel);

    @ViewModelKey(MyAccountViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindMyAccountViewModelImpl(MyAccountViewModelImpl myAccountViewModel);

    @ViewModelKey(MyTransportCardsViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindMyCardsViewModel(MyTransportCardsViewModelImpl myCardsViewModel);

    @ViewModelKey(MyPaymentCardsViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindMyCreditCardsViewModelImpl(MyPaymentCardsViewModelImpl myCreditCardsViewModel);

    @ViewModelKey(NewsDetailViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindNewsDetailViewModel(NewsDetailViewModelImpl newsDetailViewModel);

    @ViewModelKey(NewsViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindNewsViewModel(NewsViewModelImpl newsViewModel);

    @ViewModelKey(NextArrivalsViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindNextArrivalsViewModel(NextArrivalsViewModelImpl nextArrivalsViewModel);

    @ViewModelKey(ReadCardNfcViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindReadCardNfcViewModel(ReadCardNfcViewModelImpl readCardNfcViewModel);

    @ViewModelKey(RechargeBalanceCardViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindRechargeAmountCardViewModel(RechargeBalanceCardViewModelImpl rechargeAmountCardViewModel);

    @ViewModelKey(RechargeByZoneViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindRechargeByZoneViewModelImpl(RechargeByZoneViewModelImpl rechargeByZoneViewModel);

    @ViewModelKey(RechargeZonesViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindRechargeSuscriptionViewModelImpl(RechargeZonesViewModelImpl rechargeSuscriptionViewModel);

    @ViewModelKey(RecoverPasswordViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindRecoverPasswordViewModelImpl(RecoverPasswordViewModelImpl recoverPasswordViewModel);

    @ViewModelKey(RouteViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindRouteViewModel(RouteViewModelImpl routeViewModel);

    @ViewModelKey(SearchStopViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindSearchStopViewModel(SearchStopViewModelImpl searchStopViewModel);

    @ViewModelKey(MainViewModelImpl.class)
    @Binds
    @IntoMap
    ViewModel bindTransportCardViewModel(MainViewModelImpl transportCardViewModel);

    @Binds
    ViewModelProvider.Factory bindViewModelFactory(BaseViewModelFactory factory);
}
