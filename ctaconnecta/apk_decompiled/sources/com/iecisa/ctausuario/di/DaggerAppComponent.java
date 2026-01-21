package com.iecisa.ctausuario.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.cexmobility.core.ui.BaseActivity_MembersInjector;
import com.cexmobility.core.ui.BaseViewModelFactory;
import com.cexmobility.core.ui.BaseViewModelFactory_Factory;
import com.google.common.collect.ImmutableMap;
import com.iecisa.ctausuario.App;
import com.iecisa.ctausuario.App_MembersInjector;
import com.iecisa.ctausuario.data.DoBRepository;
import com.iecisa.ctausuario.data.DoBRepositoryImpl_Factory;
import com.iecisa.ctausuario.data.FavouriteStopsRepository;
import com.iecisa.ctausuario.data.FavouriteStopsRepositoryImpl;
import com.iecisa.ctausuario.data.FavouriteStopsRepositoryImpl_Factory;
import com.iecisa.ctausuario.data.LinesRepository;
import com.iecisa.ctausuario.data.LinesRepositoryImpl;
import com.iecisa.ctausuario.data.LinesRepositoryImpl_Factory;
import com.iecisa.ctausuario.data.NewsRepository;
import com.iecisa.ctausuario.data.NewsRepositoryImpl_Factory;
import com.iecisa.ctausuario.data.NfcRepository;
import com.iecisa.ctausuario.data.NfcRepositoryImpl;
import com.iecisa.ctausuario.data.NfcRepositoryImpl_Factory;
import com.iecisa.ctausuario.data.NotificationRepository;
import com.iecisa.ctausuario.data.NotificationRepositoryImpl;
import com.iecisa.ctausuario.data.NotificationRepositoryImpl_Factory;
import com.iecisa.ctausuario.data.PaymentCardRepository;
import com.iecisa.ctausuario.data.PaymentCardRepositoryImpl_Factory;
import com.iecisa.ctausuario.data.RechargeRepository;
import com.iecisa.ctausuario.data.RechargeRepositoryImpl_Factory;
import com.iecisa.ctausuario.data.RouteRepository;
import com.iecisa.ctausuario.data.RouteRepositoryImpl;
import com.iecisa.ctausuario.data.RouteRepositoryImpl_Factory;
import com.iecisa.ctausuario.data.RtmRepository;
import com.iecisa.ctausuario.data.RtmRepositoryImpl_Factory;
import com.iecisa.ctausuario.data.StopsRepository;
import com.iecisa.ctausuario.data.StopsRepositoryImpl;
import com.iecisa.ctausuario.data.StopsRepositoryImpl_Factory;
import com.iecisa.ctausuario.data.TransportCardRepository;
import com.iecisa.ctausuario.data.TransportCardRepositoryImpl_Factory;
import com.iecisa.ctausuario.data.UserRepository;
import com.iecisa.ctausuario.data.UserRepositoryImpl_Factory;
import com.iecisa.ctausuario.data.api.RefreshInterceptor;
import com.iecisa.ctausuario.data.api.RefreshInterceptor_MembersInjector;
import com.iecisa.ctausuario.data.database.AppDatabase;
import com.iecisa.ctausuario.data.database.SearchDao;
import com.iecisa.ctausuario.data.database.StopsDao;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.data.preferences.PreferencesHelperImpl;
import com.iecisa.ctausuario.data.preferences.PreferencesHelperImpl_Factory;
import com.iecisa.ctausuario.di.ActivityModule_ContributesAccessSettingsActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesActivateAutoRechargeActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesAddCardActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesAddressPickerActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesAutomaticRechargeActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesBaseTransportCardActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesCertificateActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesChangeAliasActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesChangeZonesRechargeActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesCreateReportsActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesDataProtectionActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesDateTimeLineActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesDestinationUserSelectorActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesDetailRouteActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesDetailStopActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesDetailTransportCardActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesEditAutomaticRechargeActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesIncidentActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesLargeFamilyDiscountActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesLegalRepresentativeActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesLinesRealTimeActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesLoginTransportCardActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesLoginUserCardActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesMainActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesMyAccountActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesMyCardsActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesMyCreditCardsActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesNewDetailActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesNewsActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesNotificationMessageActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesReadCardNfcActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesRechargeAmountCardActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesRechargeRedsysActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesRechargeSuscriptionActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesRecoverPasswordActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesRtmRechargeCardActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesSettingsActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesSplashActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesTransportCardContinueRequestActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesTransportCardRequestDataActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesTransportCardRequestIdentificationActivity;
import com.iecisa.ctausuario.di.ActivityModule_ContributesTransportCardRequestInfoActivity;
import com.iecisa.ctausuario.di.AppComponent;
import com.iecisa.ctausuario.di.FragmentModule_ContributesAllLinesFragment;
import com.iecisa.ctausuario.di.FragmentModule_ContributesCalculateZoneFragment;
import com.iecisa.ctausuario.di.FragmentModule_ContributesFavouriteStopsFragment;
import com.iecisa.ctausuario.di.FragmentModule_ContributesIncidentsFragment;
import com.iecisa.ctausuario.di.FragmentModule_ContributesLinesRealTimeListFragment;
import com.iecisa.ctausuario.di.FragmentModule_ContributesLinesRealTimeMapFragment;
import com.iecisa.ctausuario.di.FragmentModule_ContributesMapStopsFragment;
import com.iecisa.ctausuario.di.FragmentModule_ContributesNextArrivalsFragment;
import com.iecisa.ctausuario.di.FragmentModule_ContributesRechargeByZoneFragment;
import com.iecisa.ctausuario.di.FragmentModule_ContributesRouteFragment;
import com.iecisa.ctausuario.di.FragmentModule_ContributesSearchStopsFragment;
import com.iecisa.ctausuario.ui.main.BaseTransportCardActivity;
import com.iecisa.ctausuario.ui.main.BaseTransportCardActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.BaseTransportCardViewModelImpl;
import com.iecisa.ctausuario.ui.main.BaseTransportCardViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.MainActivity;
import com.iecisa.ctausuario.ui.main.MainActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.MainViewModelImpl;
import com.iecisa.ctausuario.ui.main.MainViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.datelines.DateTimeLineActivity;
import com.iecisa.ctausuario.ui.main.datelines.DateTimeLineActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.datelines.DateTimeLineViewModelImpl;
import com.iecisa.ctausuario.ui.main.datelines.DateTimeLineViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment;
import com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment_MembersInjector;
import com.iecisa.ctausuario.ui.main.incidents.IncidentsViewModelImpl;
import com.iecisa.ctausuario.ui.main.incidents.IncidentsViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeActivity;
import com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeViewModelImpl;
import com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.linesrealtime.lineslist.LinesRealTimeListFragment;
import com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapFragment;
import com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapFragment_MembersInjector;
import com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapViewModelImpl;
import com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.more.news.NewsActivity;
import com.iecisa.ctausuario.ui.main.more.news.NewsActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.more.news.NewsViewModelImpl;
import com.iecisa.ctausuario.ui.main.more.news.NewsViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.more.news.newsdetail.NewsDetailActivity;
import com.iecisa.ctausuario.ui.main.more.news.newsdetail.NewsDetailActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.more.news.newsdetail.NewsDetailViewModelImpl;
import com.iecisa.ctausuario.ui.main.more.news.newsdetail.NewsDetailViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.more.settings.SettingsActivity;
import com.iecisa.ctausuario.ui.main.more.settings.SettingsActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.more.settings.SettingsViewModelImpl;
import com.iecisa.ctausuario.ui.main.more.settings.SettingsViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.notification.NotificationMessageActivity;
import com.iecisa.ctausuario.ui.main.notification.NotificationService;
import com.iecisa.ctausuario.ui.main.route.RouteFragment;
import com.iecisa.ctausuario.ui.main.route.RouteFragment_MembersInjector;
import com.iecisa.ctausuario.ui.main.route.RouteViewModelImpl;
import com.iecisa.ctausuario.ui.main.route.RouteViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.route.detailroute.DetailRouteActivity;
import com.iecisa.ctausuario.ui.main.route.detailroute.DetailRouteActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.route.detailroute.DetailRouteViewModelImpl;
import com.iecisa.ctausuario.ui.main.route.detailroute.DetailRouteViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerActivity;
import com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerViewModelImpl;
import com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity;
import com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopViewModelImpl;
import com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesFragment;
import com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesFragment_MembersInjector;
import com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesViewModelImpl;
import com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsFragment;
import com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsFragment_MembersInjector;
import com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsViewModelImpl;
import com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsFragment;
import com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsFragment_MembersInjector;
import com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsViewModelImpl;
import com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment;
import com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment_MembersInjector;
import com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsViewModelImpl;
import com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.stops.searchstop.SearchStopViewModelImpl;
import com.iecisa.ctausuario.ui.main.stops.searchstop.SearchStopViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.stops.searchstop.SearchStopsFragment;
import com.iecisa.ctausuario.ui.main.stops.searchstop.SearchStopsFragment_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity;
import com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.addcard.AddCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.addcard.AddCardActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.addcard.AddCardViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.addcard.AddCardViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.dataprotection.DataProtectionActivity;
import com.iecisa.ctausuario.ui.main.transportcard.dataprotection.DataProtectionActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.dataprotection.DataProtectionViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.dataprotection.DataProtectionViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.detail.alias.ChangeAliasActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.alias.ChangeAliasActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.detail.alias.ChangeAliasViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.alias.ChangeAliasViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.detail.incident.IncidentActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.incident.IncidentActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.detail.incident.IncidentViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.detail.incident.IncidentViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordActivity;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity;
import com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity;
import com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity;
import com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.readcardnfc.ReadCardNfcActivity;
import com.iecisa.ctausuario.ui.main.transportcard.readcardnfc.ReadCardNfcActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.readcardnfc.ReadCardNfcViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.readcardnfc.ReadCardNfcViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZoneFragment_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZonesViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.CalculateZonesViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones.RechargeByZoneFragment;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones.RechargeByZoneFragment_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones.RechargeByZoneViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.changezones.RechargeByZoneViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmCardActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.data.TransportCardRequestDataActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.data.TransportCardRequestDataActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.data.TransportCardRequestDataViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.data.TransportCardRequestDataViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.identification.TransportCardRequestIdentificationActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeActivity_MembersInjector;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeViewModelImpl;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeViewModelImpl_Factory;
import com.iecisa.ctausuario.ui.splash.SplashActivity;
import com.iecisa.ctausuario.ui.splash.SplashActivity_MembersInjector;
import com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity;
import com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity_MembersInjector;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerAppComponent {
    private DaggerAppComponent() {
    }

    public static AppComponent.Builder builder() {
        return new Builder();
    }

    private static final class Builder implements AppComponent.Builder {
        private Application application;

        private Builder() {
        }

        @Override // com.iecisa.ctausuario.di.AppComponent.Builder
        public Builder application(Application application) {
            this.application = (Application) Preconditions.checkNotNull(application);
            return this;
        }

        @Override // com.iecisa.ctausuario.di.AppComponent.Builder
        public AppComponent build() {
            Preconditions.checkBuilderRequirement(this.application, Application.class);
            return new AppComponentImpl(this.application);
        }
    }

    private static final class MainActivitySubcomponentFactory implements ActivityModule_ContributesMainActivity.MainActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private MainActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesMainActivity.MainActivitySubcomponent create(MainActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new MainActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class SplashActivitySubcomponentFactory implements ActivityModule_ContributesSplashActivity.SplashActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private SplashActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesSplashActivity.SplashActivitySubcomponent create(SplashActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new SplashActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class ReadCardNfcActivitySubcomponentFactory implements ActivityModule_ContributesReadCardNfcActivity.ReadCardNfcActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private ReadCardNfcActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesReadCardNfcActivity.ReadCardNfcActivitySubcomponent create(ReadCardNfcActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new ReadCardNfcActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class DetailStopActivitySubcomponentFactory implements ActivityModule_ContributesDetailStopActivity.DetailStopActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private DetailStopActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesDetailStopActivity.DetailStopActivitySubcomponent create(DetailStopActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new DetailStopActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class LinesRealTimeActivitySubcomponentFactory implements ActivityModule_ContributesLinesRealTimeActivity.LinesRealTimeActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private LinesRealTimeActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesLinesRealTimeActivity.LinesRealTimeActivitySubcomponent create(LinesRealTimeActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new LinesRealTimeActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class DateTimeLineActivitySubcomponentFactory implements ActivityModule_ContributesDateTimeLineActivity.DateTimeLineActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private DateTimeLineActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesDateTimeLineActivity.DateTimeLineActivitySubcomponent create(DateTimeLineActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new DateTimeLineActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class NewsActivitySubcomponentFactory implements ActivityModule_ContributesNewsActivity.NewsActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private NewsActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesNewsActivity.NewsActivitySubcomponent create(NewsActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new NewsActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class AddressPickerActivitySubcomponentFactory implements ActivityModule_ContributesAddressPickerActivity.AddressPickerActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private AddressPickerActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesAddressPickerActivity.AddressPickerActivitySubcomponent create(AddressPickerActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new AddressPickerActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class DestinationUserSelectorActivitySubcomponentFactory implements ActivityModule_ContributesDestinationUserSelectorActivity.DestinationUserSelectorActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private DestinationUserSelectorActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesDestinationUserSelectorActivity.DestinationUserSelectorActivitySubcomponent create(DestinationUserSelectorActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new DestinationUserSelectorActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class RechargeBalanceCardActivitySubcomponentFactory implements ActivityModule_ContributesRechargeAmountCardActivity.RechargeBalanceCardActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private RechargeBalanceCardActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesRechargeAmountCardActivity.RechargeBalanceCardActivitySubcomponent create(RechargeBalanceCardActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new RechargeBalanceCardActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class DetailTransportCardActivitySubcomponentFactory implements ActivityModule_ContributesDetailTransportCardActivity.DetailTransportCardActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private DetailTransportCardActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesDetailTransportCardActivity.DetailTransportCardActivitySubcomponent create(DetailTransportCardActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new DetailTransportCardActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class NewsDetailActivitySubcomponentFactory implements ActivityModule_ContributesNewDetailActivity.NewsDetailActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private NewsDetailActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesNewDetailActivity.NewsDetailActivitySubcomponent create(NewsDetailActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new NewsDetailActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class LoginUserCardActivitySubcomponentFactory implements ActivityModule_ContributesLoginUserCardActivity.LoginUserCardActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private LoginUserCardActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesLoginUserCardActivity.LoginUserCardActivitySubcomponent create(LoginUserCardActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new LoginUserCardActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class MyTransportCardsActivitySubcomponentFactory implements ActivityModule_ContributesMyCardsActivity.MyTransportCardsActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private MyTransportCardsActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesMyCardsActivity.MyTransportCardsActivitySubcomponent create(MyTransportCardsActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new MyTransportCardsActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class CreateReportsActivitySubcomponentFactory implements ActivityModule_ContributesCreateReportsActivity.CreateReportsActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private CreateReportsActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesCreateReportsActivity.CreateReportsActivitySubcomponent create(CreateReportsActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new CreateReportsActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class RecoverPasswordActivitySubcomponentFactory implements ActivityModule_ContributesRecoverPasswordActivity.RecoverPasswordActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private RecoverPasswordActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesRecoverPasswordActivity.RecoverPasswordActivitySubcomponent create(RecoverPasswordActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new RecoverPasswordActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class RechargeZonesActivitySubcomponentFactory implements ActivityModule_ContributesRechargeSuscriptionActivity.RechargeZonesActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private RechargeZonesActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesRechargeSuscriptionActivity.RechargeZonesActivitySubcomponent create(RechargeZonesActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new RechargeZonesActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class AccessSettingsActivitySubcomponentFactory implements ActivityModule_ContributesAccessSettingsActivity.AccessSettingsActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private AccessSettingsActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesAccessSettingsActivity.AccessSettingsActivitySubcomponent create(AccessSettingsActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new AccessSettingsActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class AddCardActivitySubcomponentFactory implements ActivityModule_ContributesAddCardActivity.AddCardActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private AddCardActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesAddCardActivity.AddCardActivitySubcomponent create(AddCardActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new AddCardActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class CertificateActivitySubcomponentFactory implements ActivityModule_ContributesCertificateActivity.CertificateActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private CertificateActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesCertificateActivity.CertificateActivitySubcomponent create(CertificateActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new CertificateActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class LoginTransportCardActivitySubcomponentFactory implements ActivityModule_ContributesLoginTransportCardActivity.LoginTransportCardActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private LoginTransportCardActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesLoginTransportCardActivity.LoginTransportCardActivitySubcomponent create(LoginTransportCardActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new LoginTransportCardActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class ChangeZonesRechargeActivitySubcomponentFactory implements ActivityModule_ContributesChangeZonesRechargeActivity.ChangeZonesRechargeActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private ChangeZonesRechargeActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesChangeZonesRechargeActivity.ChangeZonesRechargeActivitySubcomponent create(ChangeZonesRechargeActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new ChangeZonesRechargeActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class DataProtectionActivitySubcomponentFactory implements ActivityModule_ContributesDataProtectionActivity.DataProtectionActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private DataProtectionActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesDataProtectionActivity.DataProtectionActivitySubcomponent create(DataProtectionActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new DataProtectionActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class MyAccountActivitySubcomponentFactory implements ActivityModule_ContributesMyAccountActivity.MyAccountActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private MyAccountActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesMyAccountActivity.MyAccountActivitySubcomponent create(MyAccountActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new MyAccountActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class AutomaticRechargeActivitySubcomponentFactory implements ActivityModule_ContributesAutomaticRechargeActivity.AutomaticRechargeActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private AutomaticRechargeActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesAutomaticRechargeActivity.AutomaticRechargeActivitySubcomponent create(AutomaticRechargeActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new AutomaticRechargeActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class DetailRouteActivitySubcomponentFactory implements ActivityModule_ContributesDetailRouteActivity.DetailRouteActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private DetailRouteActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesDetailRouteActivity.DetailRouteActivitySubcomponent create(DetailRouteActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new DetailRouteActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class MyPaymentCardsActivitySubcomponentFactory implements ActivityModule_ContributesMyCreditCardsActivity.MyPaymentCardsActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private MyPaymentCardsActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesMyCreditCardsActivity.MyPaymentCardsActivitySubcomponent create(MyPaymentCardsActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new MyPaymentCardsActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class RtmCardActivitySubcomponentFactory implements ActivityModule_ContributesRtmRechargeCardActivity.RtmCardActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private RtmCardActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesRtmRechargeCardActivity.RtmCardActivitySubcomponent create(RtmCardActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new RtmCardActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class RechargeRedsysActivitySubcomponentFactory implements ActivityModule_ContributesRechargeRedsysActivity.RechargeRedsysActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private RechargeRedsysActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesRechargeRedsysActivity.RechargeRedsysActivitySubcomponent create(RechargeRedsysActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new RechargeRedsysActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class LargeFamilyDiscountActivitySubcomponentFactory implements ActivityModule_ContributesLargeFamilyDiscountActivity.LargeFamilyDiscountActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private LargeFamilyDiscountActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesLargeFamilyDiscountActivity.LargeFamilyDiscountActivitySubcomponent create(LargeFamilyDiscountActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new LargeFamilyDiscountActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class IncidentActivitySubcomponentFactory implements ActivityModule_ContributesIncidentActivity.IncidentActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private IncidentActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesIncidentActivity.IncidentActivitySubcomponent create(IncidentActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new IncidentActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class ChangeAliasActivitySubcomponentFactory implements ActivityModule_ContributesChangeAliasActivity.ChangeAliasActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private ChangeAliasActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesChangeAliasActivity.ChangeAliasActivitySubcomponent create(ChangeAliasActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new ChangeAliasActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class ActivateAutoRechargeActivitySubcomponentFactory implements ActivityModule_ContributesActivateAutoRechargeActivity.ActivateAutoRechargeActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private ActivateAutoRechargeActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesActivateAutoRechargeActivity.ActivateAutoRechargeActivitySubcomponent create(ActivateAutoRechargeActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new ActivateAutoRechargeActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class BaseTransportCardActivitySubcomponentFactory implements ActivityModule_ContributesBaseTransportCardActivity.BaseTransportCardActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private BaseTransportCardActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesBaseTransportCardActivity.BaseTransportCardActivitySubcomponent create(BaseTransportCardActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new BaseTransportCardActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class SettingsActivitySubcomponentFactory implements ActivityModule_ContributesSettingsActivity.SettingsActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private SettingsActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesSettingsActivity.SettingsActivitySubcomponent create(SettingsActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new SettingsActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class EditAutomaticRechargeActivitySubcomponentFactory implements ActivityModule_ContributesEditAutomaticRechargeActivity.EditAutomaticRechargeActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private EditAutomaticRechargeActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesEditAutomaticRechargeActivity.EditAutomaticRechargeActivitySubcomponent create(EditAutomaticRechargeActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new EditAutomaticRechargeActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class NotificationMessageActivitySubcomponentFactory implements ActivityModule_ContributesNotificationMessageActivity.NotificationMessageActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private NotificationMessageActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesNotificationMessageActivity.NotificationMessageActivitySubcomponent create(NotificationMessageActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new NotificationMessageActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class TransportCardRequestInfoActivitySubcomponentFactory implements ActivityModule_ContributesTransportCardRequestInfoActivity.TransportCardRequestInfoActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private TransportCardRequestInfoActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesTransportCardRequestInfoActivity.TransportCardRequestInfoActivitySubcomponent create(TransportCardRequestInfoActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new TransportCardRequestInfoActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class TransportCardRequestDataActivitySubcomponentFactory implements ActivityModule_ContributesTransportCardRequestDataActivity.TransportCardRequestDataActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private TransportCardRequestDataActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesTransportCardRequestDataActivity.TransportCardRequestDataActivitySubcomponent create(TransportCardRequestDataActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new TransportCardRequestDataActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class TransportCardContinueRequestActivitySubcomponentFactory implements ActivityModule_ContributesTransportCardContinueRequestActivity.TransportCardContinueRequestActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private TransportCardContinueRequestActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesTransportCardContinueRequestActivity.TransportCardContinueRequestActivitySubcomponent create(TransportCardContinueRequestActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new TransportCardContinueRequestActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class LegalRepresentativeActivitySubcomponentFactory implements ActivityModule_ContributesLegalRepresentativeActivity.LegalRepresentativeActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private LegalRepresentativeActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesLegalRepresentativeActivity.LegalRepresentativeActivitySubcomponent create(LegalRepresentativeActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new LegalRepresentativeActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class TransportCardRequestIdentificationActivitySubcomponentFactory implements ActivityModule_ContributesTransportCardRequestIdentificationActivity.TransportCardRequestIdentificationActivitySubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private TransportCardRequestIdentificationActivitySubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public ActivityModule_ContributesTransportCardRequestIdentificationActivity.TransportCardRequestIdentificationActivitySubcomponent create(TransportCardRequestIdentificationActivity arg0) {
            Preconditions.checkNotNull(arg0);
            return new TransportCardRequestIdentificationActivitySubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class MapStopsFragmentSubcomponentFactory implements FragmentModule_ContributesMapStopsFragment.MapStopsFragmentSubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private MapStopsFragmentSubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public FragmentModule_ContributesMapStopsFragment.MapStopsFragmentSubcomponent create(MapStopsFragment arg0) {
            Preconditions.checkNotNull(arg0);
            return new MapStopsFragmentSubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class AllLinesFragmentSubcomponentFactory implements FragmentModule_ContributesAllLinesFragment.AllLinesFragmentSubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private AllLinesFragmentSubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public FragmentModule_ContributesAllLinesFragment.AllLinesFragmentSubcomponent create(AllLinesFragment arg0) {
            Preconditions.checkNotNull(arg0);
            return new AllLinesFragmentSubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class NextArrivalsFragmentSubcomponentFactory implements FragmentModule_ContributesNextArrivalsFragment.NextArrivalsFragmentSubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private NextArrivalsFragmentSubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public FragmentModule_ContributesNextArrivalsFragment.NextArrivalsFragmentSubcomponent create(NextArrivalsFragment arg0) {
            Preconditions.checkNotNull(arg0);
            return new NextArrivalsFragmentSubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class LinesRealTimeListFragmentSubcomponentFactory implements FragmentModule_ContributesLinesRealTimeListFragment.LinesRealTimeListFragmentSubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private LinesRealTimeListFragmentSubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public FragmentModule_ContributesLinesRealTimeListFragment.LinesRealTimeListFragmentSubcomponent create(LinesRealTimeListFragment arg0) {
            Preconditions.checkNotNull(arg0);
            return new LinesRealTimeListFragmentSubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class LinesRealTimeMapFragmentSubcomponentFactory implements FragmentModule_ContributesLinesRealTimeMapFragment.LinesRealTimeMapFragmentSubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private LinesRealTimeMapFragmentSubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public FragmentModule_ContributesLinesRealTimeMapFragment.LinesRealTimeMapFragmentSubcomponent create(LinesRealTimeMapFragment arg0) {
            Preconditions.checkNotNull(arg0);
            return new LinesRealTimeMapFragmentSubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class SearchStopsFragmentSubcomponentFactory implements FragmentModule_ContributesSearchStopsFragment.SearchStopsFragmentSubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private SearchStopsFragmentSubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public FragmentModule_ContributesSearchStopsFragment.SearchStopsFragmentSubcomponent create(SearchStopsFragment arg0) {
            Preconditions.checkNotNull(arg0);
            return new SearchStopsFragmentSubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class FavouriteStopsFragmentSubcomponentFactory implements FragmentModule_ContributesFavouriteStopsFragment.FavouriteStopsFragmentSubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private FavouriteStopsFragmentSubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public FragmentModule_ContributesFavouriteStopsFragment.FavouriteStopsFragmentSubcomponent create(FavouriteStopsFragment arg0) {
            Preconditions.checkNotNull(arg0);
            return new FavouriteStopsFragmentSubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class CalculateZoneFragmentSubcomponentFactory implements FragmentModule_ContributesCalculateZoneFragment.CalculateZoneFragmentSubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private CalculateZoneFragmentSubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public FragmentModule_ContributesCalculateZoneFragment.CalculateZoneFragmentSubcomponent create(CalculateZoneFragment arg0) {
            Preconditions.checkNotNull(arg0);
            return new CalculateZoneFragmentSubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class RechargeByZoneFragmentSubcomponentFactory implements FragmentModule_ContributesRechargeByZoneFragment.RechargeByZoneFragmentSubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private RechargeByZoneFragmentSubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public FragmentModule_ContributesRechargeByZoneFragment.RechargeByZoneFragmentSubcomponent create(RechargeByZoneFragment arg0) {
            Preconditions.checkNotNull(arg0);
            return new RechargeByZoneFragmentSubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class RouteFragmentSubcomponentFactory implements FragmentModule_ContributesRouteFragment.RouteFragmentSubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private RouteFragmentSubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public FragmentModule_ContributesRouteFragment.RouteFragmentSubcomponent create(RouteFragment arg0) {
            Preconditions.checkNotNull(arg0);
            return new RouteFragmentSubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class IncidentsFragmentSubcomponentFactory implements FragmentModule_ContributesIncidentsFragment.IncidentsFragmentSubcomponent.Factory {
        private final AppComponentImpl appComponentImpl;

        private IncidentsFragmentSubcomponentFactory(AppComponentImpl appComponentImpl) {
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector.Factory
        public FragmentModule_ContributesIncidentsFragment.IncidentsFragmentSubcomponent create(IncidentsFragment arg0) {
            Preconditions.checkNotNull(arg0);
            return new IncidentsFragmentSubcomponentImpl(this.appComponentImpl, arg0);
        }
    }

    private static final class MainActivitySubcomponentImpl implements ActivityModule_ContributesMainActivity.MainActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

        private MainActivitySubcomponentImpl(AppComponentImpl appComponentImpl, MainActivity arg0Param) {
            this.mainActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(MainActivity arg0) {
            injectMainActivity(arg0);
        }

        private MainActivity injectMainActivity(MainActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            MainActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            MainActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class SplashActivitySubcomponentImpl implements ActivityModule_ContributesSplashActivity.SplashActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final SplashActivitySubcomponentImpl splashActivitySubcomponentImpl;

        private SplashActivitySubcomponentImpl(AppComponentImpl appComponentImpl, SplashActivity arg0Param) {
            this.splashActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(SplashActivity arg0) {
            injectSplashActivity(arg0);
        }

        private SplashActivity injectSplashActivity(SplashActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            SplashActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class ReadCardNfcActivitySubcomponentImpl implements ActivityModule_ContributesReadCardNfcActivity.ReadCardNfcActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final ReadCardNfcActivitySubcomponentImpl readCardNfcActivitySubcomponentImpl;

        private ReadCardNfcActivitySubcomponentImpl(AppComponentImpl appComponentImpl, ReadCardNfcActivity arg0Param) {
            this.readCardNfcActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(ReadCardNfcActivity arg0) {
            injectReadCardNfcActivity(arg0);
        }

        private ReadCardNfcActivity injectReadCardNfcActivity(ReadCardNfcActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            ReadCardNfcActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class DetailStopActivitySubcomponentImpl implements ActivityModule_ContributesDetailStopActivity.DetailStopActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final DetailStopActivitySubcomponentImpl detailStopActivitySubcomponentImpl;

        private DetailStopActivitySubcomponentImpl(AppComponentImpl appComponentImpl, DetailStopActivity arg0Param) {
            this.detailStopActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(DetailStopActivity arg0) {
            injectDetailStopActivity(arg0);
        }

        private DetailStopActivity injectDetailStopActivity(DetailStopActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            DetailStopActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            DetailStopActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class LinesRealTimeActivitySubcomponentImpl implements ActivityModule_ContributesLinesRealTimeActivity.LinesRealTimeActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final LinesRealTimeActivitySubcomponentImpl linesRealTimeActivitySubcomponentImpl;

        private LinesRealTimeActivitySubcomponentImpl(AppComponentImpl appComponentImpl, LinesRealTimeActivity arg0Param) {
            this.linesRealTimeActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(LinesRealTimeActivity arg0) {
            injectLinesRealTimeActivity(arg0);
        }

        private LinesRealTimeActivity injectLinesRealTimeActivity(LinesRealTimeActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            LinesRealTimeActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class DateTimeLineActivitySubcomponentImpl implements ActivityModule_ContributesDateTimeLineActivity.DateTimeLineActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final DateTimeLineActivitySubcomponentImpl dateTimeLineActivitySubcomponentImpl;

        private DateTimeLineActivitySubcomponentImpl(AppComponentImpl appComponentImpl, DateTimeLineActivity arg0Param) {
            this.dateTimeLineActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(DateTimeLineActivity arg0) {
            injectDateTimeLineActivity(arg0);
        }

        private DateTimeLineActivity injectDateTimeLineActivity(DateTimeLineActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            DateTimeLineActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class NewsActivitySubcomponentImpl implements ActivityModule_ContributesNewsActivity.NewsActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final NewsActivitySubcomponentImpl newsActivitySubcomponentImpl;

        private NewsActivitySubcomponentImpl(AppComponentImpl appComponentImpl, NewsActivity arg0Param) {
            this.newsActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(NewsActivity arg0) {
            injectNewsActivity(arg0);
        }

        private NewsActivity injectNewsActivity(NewsActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            NewsActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class AddressPickerActivitySubcomponentImpl implements ActivityModule_ContributesAddressPickerActivity.AddressPickerActivitySubcomponent {
        private final AddressPickerActivitySubcomponentImpl addressPickerActivitySubcomponentImpl;
        private final AppComponentImpl appComponentImpl;

        private AddressPickerActivitySubcomponentImpl(AppComponentImpl appComponentImpl, AddressPickerActivity arg0Param) {
            this.addressPickerActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(AddressPickerActivity arg0) {
            injectAddressPickerActivity(arg0);
        }

        private AddressPickerActivity injectAddressPickerActivity(AddressPickerActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            AddressPickerActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class DestinationUserSelectorActivitySubcomponentImpl implements ActivityModule_ContributesDestinationUserSelectorActivity.DestinationUserSelectorActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final DestinationUserSelectorActivitySubcomponentImpl destinationUserSelectorActivitySubcomponentImpl;

        private DestinationUserSelectorActivitySubcomponentImpl(AppComponentImpl appComponentImpl, DestinationUserSelectorActivity arg0Param) {
            this.destinationUserSelectorActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(DestinationUserSelectorActivity arg0) {
            injectDestinationUserSelectorActivity(arg0);
        }

        private DestinationUserSelectorActivity injectDestinationUserSelectorActivity(DestinationUserSelectorActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            DestinationUserSelectorActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class RechargeBalanceCardActivitySubcomponentImpl implements ActivityModule_ContributesRechargeAmountCardActivity.RechargeBalanceCardActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final RechargeBalanceCardActivitySubcomponentImpl rechargeBalanceCardActivitySubcomponentImpl;

        private RechargeBalanceCardActivitySubcomponentImpl(AppComponentImpl appComponentImpl, RechargeBalanceCardActivity arg0Param) {
            this.rechargeBalanceCardActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(RechargeBalanceCardActivity arg0) {
            injectRechargeBalanceCardActivity(arg0);
        }

        private RechargeBalanceCardActivity injectRechargeBalanceCardActivity(RechargeBalanceCardActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            BaseTransportCardActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            BaseTransportCardActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            RechargeBalanceCardActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            RechargeBalanceCardActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class DetailTransportCardActivitySubcomponentImpl implements ActivityModule_ContributesDetailTransportCardActivity.DetailTransportCardActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final DetailTransportCardActivitySubcomponentImpl detailTransportCardActivitySubcomponentImpl;

        private DetailTransportCardActivitySubcomponentImpl(AppComponentImpl appComponentImpl, DetailTransportCardActivity arg0Param) {
            this.detailTransportCardActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(DetailTransportCardActivity arg0) {
            injectDetailTransportCardActivity(arg0);
        }

        private DetailTransportCardActivity injectDetailTransportCardActivity(DetailTransportCardActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            DetailTransportCardActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            DetailTransportCardActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class NewsDetailActivitySubcomponentImpl implements ActivityModule_ContributesNewDetailActivity.NewsDetailActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final NewsDetailActivitySubcomponentImpl newsDetailActivitySubcomponentImpl;

        private NewsDetailActivitySubcomponentImpl(AppComponentImpl appComponentImpl, NewsDetailActivity arg0Param) {
            this.newsDetailActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(NewsDetailActivity arg0) {
            injectNewsDetailActivity(arg0);
        }

        private NewsDetailActivity injectNewsDetailActivity(NewsDetailActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            NewsDetailActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class LoginUserCardActivitySubcomponentImpl implements ActivityModule_ContributesLoginUserCardActivity.LoginUserCardActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final LoginUserCardActivitySubcomponentImpl loginUserCardActivitySubcomponentImpl;

        private LoginUserCardActivitySubcomponentImpl(AppComponentImpl appComponentImpl, LoginUserCardActivity arg0Param) {
            this.loginUserCardActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(LoginUserCardActivity arg0) {
            injectLoginUserCardActivity(arg0);
        }

        private LoginUserCardActivity injectLoginUserCardActivity(LoginUserCardActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            LoginUserCardActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            LoginUserCardActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class MyTransportCardsActivitySubcomponentImpl implements ActivityModule_ContributesMyCardsActivity.MyTransportCardsActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final MyTransportCardsActivitySubcomponentImpl myTransportCardsActivitySubcomponentImpl;

        private MyTransportCardsActivitySubcomponentImpl(AppComponentImpl appComponentImpl, MyTransportCardsActivity arg0Param) {
            this.myTransportCardsActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(MyTransportCardsActivity arg0) {
            injectMyTransportCardsActivity(arg0);
        }

        private MyTransportCardsActivity injectMyTransportCardsActivity(MyTransportCardsActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            BaseTransportCardActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            BaseTransportCardActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            MyTransportCardsActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            MyTransportCardsActivity_MembersInjector.injectPreferencesHelper(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            MyTransportCardsActivity_MembersInjector.injectMyPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class CreateReportsActivitySubcomponentImpl implements ActivityModule_ContributesCreateReportsActivity.CreateReportsActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final CreateReportsActivitySubcomponentImpl createReportsActivitySubcomponentImpl;

        private CreateReportsActivitySubcomponentImpl(AppComponentImpl appComponentImpl, CreateReportsActivity arg0Param) {
            this.createReportsActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(CreateReportsActivity arg0) {
            injectCreateReportsActivity(arg0);
        }

        private CreateReportsActivity injectCreateReportsActivity(CreateReportsActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            CreateReportsActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            CreateReportsActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class RecoverPasswordActivitySubcomponentImpl implements ActivityModule_ContributesRecoverPasswordActivity.RecoverPasswordActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final RecoverPasswordActivitySubcomponentImpl recoverPasswordActivitySubcomponentImpl;

        private RecoverPasswordActivitySubcomponentImpl(AppComponentImpl appComponentImpl, RecoverPasswordActivity arg0Param) {
            this.recoverPasswordActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(RecoverPasswordActivity arg0) {
            injectRecoverPasswordActivity(arg0);
        }

        private RecoverPasswordActivity injectRecoverPasswordActivity(RecoverPasswordActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            RecoverPasswordActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            RecoverPasswordActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class RechargeZonesActivitySubcomponentImpl implements ActivityModule_ContributesRechargeSuscriptionActivity.RechargeZonesActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final RechargeZonesActivitySubcomponentImpl rechargeZonesActivitySubcomponentImpl;

        private RechargeZonesActivitySubcomponentImpl(AppComponentImpl appComponentImpl, RechargeZonesActivity arg0Param) {
            this.rechargeZonesActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(RechargeZonesActivity arg0) {
            injectRechargeZonesActivity(arg0);
        }

        private RechargeZonesActivity injectRechargeZonesActivity(RechargeZonesActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            BaseTransportCardActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            BaseTransportCardActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            RechargeZonesActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            RechargeZonesActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class AccessSettingsActivitySubcomponentImpl implements ActivityModule_ContributesAccessSettingsActivity.AccessSettingsActivitySubcomponent {
        private final AccessSettingsActivitySubcomponentImpl accessSettingsActivitySubcomponentImpl;
        private final AppComponentImpl appComponentImpl;

        private AccessSettingsActivitySubcomponentImpl(AppComponentImpl appComponentImpl, AccessSettingsActivity arg0Param) {
            this.accessSettingsActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(AccessSettingsActivity arg0) {
            injectAccessSettingsActivity(arg0);
        }

        private AccessSettingsActivity injectAccessSettingsActivity(AccessSettingsActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            AccessSettingsActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            AccessSettingsActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            AccessSettingsActivity_MembersInjector.injectPreferencesHelper(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class AddCardActivitySubcomponentImpl implements ActivityModule_ContributesAddCardActivity.AddCardActivitySubcomponent {
        private final AddCardActivitySubcomponentImpl addCardActivitySubcomponentImpl;
        private final AppComponentImpl appComponentImpl;

        private AddCardActivitySubcomponentImpl(AppComponentImpl appComponentImpl, AddCardActivity arg0Param) {
            this.addCardActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(AddCardActivity arg0) {
            injectAddCardActivity(arg0);
        }

        private AddCardActivity injectAddCardActivity(AddCardActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            AddCardActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class CertificateActivitySubcomponentImpl implements ActivityModule_ContributesCertificateActivity.CertificateActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final CertificateActivitySubcomponentImpl certificateActivitySubcomponentImpl;

        private CertificateActivitySubcomponentImpl(AppComponentImpl appComponentImpl, CertificateActivity arg0Param) {
            this.certificateActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(CertificateActivity arg0) {
            injectCertificateActivity(arg0);
        }

        private CertificateActivity injectCertificateActivity(CertificateActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            CertificateActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            CertificateActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class LoginTransportCardActivitySubcomponentImpl implements ActivityModule_ContributesLoginTransportCardActivity.LoginTransportCardActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final LoginTransportCardActivitySubcomponentImpl loginTransportCardActivitySubcomponentImpl;

        private LoginTransportCardActivitySubcomponentImpl(AppComponentImpl appComponentImpl, LoginTransportCardActivity arg0Param) {
            this.loginTransportCardActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(LoginTransportCardActivity arg0) {
            injectLoginTransportCardActivity(arg0);
        }

        private LoginTransportCardActivity injectLoginTransportCardActivity(LoginTransportCardActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            LoginTransportCardActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            LoginTransportCardActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class ChangeZonesRechargeActivitySubcomponentImpl implements ActivityModule_ContributesChangeZonesRechargeActivity.ChangeZonesRechargeActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final ChangeZonesRechargeActivitySubcomponentImpl changeZonesRechargeActivitySubcomponentImpl;

        private ChangeZonesRechargeActivitySubcomponentImpl(AppComponentImpl appComponentImpl, ChangeZonesRechargeActivity arg0Param) {
            this.changeZonesRechargeActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(ChangeZonesRechargeActivity arg0) {
            injectChangeZonesRechargeActivity(arg0);
        }

        private ChangeZonesRechargeActivity injectChangeZonesRechargeActivity(ChangeZonesRechargeActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            ChangeZonesRechargeActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class DataProtectionActivitySubcomponentImpl implements ActivityModule_ContributesDataProtectionActivity.DataProtectionActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final DataProtectionActivitySubcomponentImpl dataProtectionActivitySubcomponentImpl;

        private DataProtectionActivitySubcomponentImpl(AppComponentImpl appComponentImpl, DataProtectionActivity arg0Param) {
            this.dataProtectionActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(DataProtectionActivity arg0) {
            injectDataProtectionActivity(arg0);
        }

        private DataProtectionActivity injectDataProtectionActivity(DataProtectionActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            DataProtectionActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class MyAccountActivitySubcomponentImpl implements ActivityModule_ContributesMyAccountActivity.MyAccountActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final MyAccountActivitySubcomponentImpl myAccountActivitySubcomponentImpl;

        private MyAccountActivitySubcomponentImpl(AppComponentImpl appComponentImpl, MyAccountActivity arg0Param) {
            this.myAccountActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(MyAccountActivity arg0) {
            injectMyAccountActivity(arg0);
        }

        private MyAccountActivity injectMyAccountActivity(MyAccountActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            BaseTransportCardActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            BaseTransportCardActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            MyAccountActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            MyAccountActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class AutomaticRechargeActivitySubcomponentImpl implements ActivityModule_ContributesAutomaticRechargeActivity.AutomaticRechargeActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final AutomaticRechargeActivitySubcomponentImpl automaticRechargeActivitySubcomponentImpl;

        private AutomaticRechargeActivitySubcomponentImpl(AppComponentImpl appComponentImpl, AutomaticRechargeActivity arg0Param) {
            this.automaticRechargeActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(AutomaticRechargeActivity arg0) {
            injectAutomaticRechargeActivity(arg0);
        }

        private AutomaticRechargeActivity injectAutomaticRechargeActivity(AutomaticRechargeActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            AutomaticRechargeActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class DetailRouteActivitySubcomponentImpl implements ActivityModule_ContributesDetailRouteActivity.DetailRouteActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final DetailRouteActivitySubcomponentImpl detailRouteActivitySubcomponentImpl;

        private DetailRouteActivitySubcomponentImpl(AppComponentImpl appComponentImpl, DetailRouteActivity arg0Param) {
            this.detailRouteActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(DetailRouteActivity arg0) {
            injectDetailRouteActivity(arg0);
        }

        private DetailRouteActivity injectDetailRouteActivity(DetailRouteActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            DetailRouteActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class MyPaymentCardsActivitySubcomponentImpl implements ActivityModule_ContributesMyCreditCardsActivity.MyPaymentCardsActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final MyPaymentCardsActivitySubcomponentImpl myPaymentCardsActivitySubcomponentImpl;

        private MyPaymentCardsActivitySubcomponentImpl(AppComponentImpl appComponentImpl, MyPaymentCardsActivity arg0Param) {
            this.myPaymentCardsActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(MyPaymentCardsActivity arg0) {
            injectMyPaymentCardsActivity(arg0);
        }

        private MyPaymentCardsActivity injectMyPaymentCardsActivity(MyPaymentCardsActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            BaseTransportCardActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            BaseTransportCardActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            MyPaymentCardsActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class RtmCardActivitySubcomponentImpl implements ActivityModule_ContributesRtmRechargeCardActivity.RtmCardActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final RtmCardActivitySubcomponentImpl rtmCardActivitySubcomponentImpl;

        private RtmCardActivitySubcomponentImpl(AppComponentImpl appComponentImpl, RtmCardActivity arg0Param) {
            this.rtmCardActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(RtmCardActivity arg0) {
            injectRtmCardActivity(arg0);
        }

        private RtmCardActivity injectRtmCardActivity(RtmCardActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            RtmCardActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            RtmCardActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class RechargeRedsysActivitySubcomponentImpl implements ActivityModule_ContributesRechargeRedsysActivity.RechargeRedsysActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final RechargeRedsysActivitySubcomponentImpl rechargeRedsysActivitySubcomponentImpl;

        private RechargeRedsysActivitySubcomponentImpl(AppComponentImpl appComponentImpl, RechargeRedsysActivity arg0Param) {
            this.rechargeRedsysActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(RechargeRedsysActivity arg0) {
            injectRechargeRedsysActivity(arg0);
        }

        private RechargeRedsysActivity injectRechargeRedsysActivity(RechargeRedsysActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            RechargeRedsysActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            RechargeRedsysActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class LargeFamilyDiscountActivitySubcomponentImpl implements ActivityModule_ContributesLargeFamilyDiscountActivity.LargeFamilyDiscountActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final LargeFamilyDiscountActivitySubcomponentImpl largeFamilyDiscountActivitySubcomponentImpl;

        private LargeFamilyDiscountActivitySubcomponentImpl(AppComponentImpl appComponentImpl, LargeFamilyDiscountActivity arg0Param) {
            this.largeFamilyDiscountActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(LargeFamilyDiscountActivity arg0) {
            injectLargeFamilyDiscountActivity(arg0);
        }

        private LargeFamilyDiscountActivity injectLargeFamilyDiscountActivity(LargeFamilyDiscountActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            BaseTransportCardActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            BaseTransportCardActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            LargeFamilyDiscountActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class IncidentActivitySubcomponentImpl implements ActivityModule_ContributesIncidentActivity.IncidentActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final IncidentActivitySubcomponentImpl incidentActivitySubcomponentImpl;

        private IncidentActivitySubcomponentImpl(AppComponentImpl appComponentImpl, IncidentActivity arg0Param) {
            this.incidentActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(IncidentActivity arg0) {
            injectIncidentActivity(arg0);
        }

        private IncidentActivity injectIncidentActivity(IncidentActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            IncidentActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class ChangeAliasActivitySubcomponentImpl implements ActivityModule_ContributesChangeAliasActivity.ChangeAliasActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final ChangeAliasActivitySubcomponentImpl changeAliasActivitySubcomponentImpl;

        private ChangeAliasActivitySubcomponentImpl(AppComponentImpl appComponentImpl, ChangeAliasActivity arg0Param) {
            this.changeAliasActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(ChangeAliasActivity arg0) {
            injectChangeAliasActivity(arg0);
        }

        private ChangeAliasActivity injectChangeAliasActivity(ChangeAliasActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            ChangeAliasActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class ActivateAutoRechargeActivitySubcomponentImpl implements ActivityModule_ContributesActivateAutoRechargeActivity.ActivateAutoRechargeActivitySubcomponent {
        private final ActivateAutoRechargeActivitySubcomponentImpl activateAutoRechargeActivitySubcomponentImpl;
        private final AppComponentImpl appComponentImpl;

        private ActivateAutoRechargeActivitySubcomponentImpl(AppComponentImpl appComponentImpl, ActivateAutoRechargeActivity arg0Param) {
            this.activateAutoRechargeActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(ActivateAutoRechargeActivity arg0) {
            injectActivateAutoRechargeActivity(arg0);
        }

        private ActivateAutoRechargeActivity injectActivateAutoRechargeActivity(ActivateAutoRechargeActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            BaseTransportCardActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            BaseTransportCardActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            ActivateAutoRechargeActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class BaseTransportCardActivitySubcomponentImpl implements ActivityModule_ContributesBaseTransportCardActivity.BaseTransportCardActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final BaseTransportCardActivitySubcomponentImpl baseTransportCardActivitySubcomponentImpl;

        private BaseTransportCardActivitySubcomponentImpl(AppComponentImpl appComponentImpl, BaseTransportCardActivity arg0Param) {
            this.baseTransportCardActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(BaseTransportCardActivity arg0) {
            injectBaseTransportCardActivity(arg0);
        }

        private BaseTransportCardActivity injectBaseTransportCardActivity(BaseTransportCardActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            BaseTransportCardActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            BaseTransportCardActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class SettingsActivitySubcomponentImpl implements ActivityModule_ContributesSettingsActivity.SettingsActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final SettingsActivitySubcomponentImpl settingsActivitySubcomponentImpl;

        private SettingsActivitySubcomponentImpl(AppComponentImpl appComponentImpl, SettingsActivity arg0Param) {
            this.settingsActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(SettingsActivity arg0) {
            injectSettingsActivity(arg0);
        }

        private SettingsActivity injectSettingsActivity(SettingsActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            SettingsActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            SettingsActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class EditAutomaticRechargeActivitySubcomponentImpl implements ActivityModule_ContributesEditAutomaticRechargeActivity.EditAutomaticRechargeActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final EditAutomaticRechargeActivitySubcomponentImpl editAutomaticRechargeActivitySubcomponentImpl;

        private EditAutomaticRechargeActivitySubcomponentImpl(AppComponentImpl appComponentImpl, EditAutomaticRechargeActivity arg0Param) {
            this.editAutomaticRechargeActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(EditAutomaticRechargeActivity arg0) {
            injectEditAutomaticRechargeActivity(arg0);
        }

        private EditAutomaticRechargeActivity injectEditAutomaticRechargeActivity(EditAutomaticRechargeActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            EditAutomaticRechargeActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class NotificationMessageActivitySubcomponentImpl implements ActivityModule_ContributesNotificationMessageActivity.NotificationMessageActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final NotificationMessageActivitySubcomponentImpl notificationMessageActivitySubcomponentImpl;

        @Override // dagger.android.AndroidInjector
        public void inject(NotificationMessageActivity arg0) {
        }

        private NotificationMessageActivitySubcomponentImpl(AppComponentImpl appComponentImpl, NotificationMessageActivity arg0Param) {
            this.notificationMessageActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }
    }

    private static final class TransportCardRequestInfoActivitySubcomponentImpl implements ActivityModule_ContributesTransportCardRequestInfoActivity.TransportCardRequestInfoActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final TransportCardRequestInfoActivitySubcomponentImpl transportCardRequestInfoActivitySubcomponentImpl;

        private TransportCardRequestInfoActivitySubcomponentImpl(AppComponentImpl appComponentImpl, TransportCardRequestInfoActivity arg0Param) {
            this.transportCardRequestInfoActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(TransportCardRequestInfoActivity arg0) {
            injectTransportCardRequestInfoActivity(arg0);
        }

        private TransportCardRequestInfoActivity injectTransportCardRequestInfoActivity(TransportCardRequestInfoActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            TransportCardRequestInfoActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            TransportCardRequestInfoActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class TransportCardRequestDataActivitySubcomponentImpl implements ActivityModule_ContributesTransportCardRequestDataActivity.TransportCardRequestDataActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final TransportCardRequestDataActivitySubcomponentImpl transportCardRequestDataActivitySubcomponentImpl;

        private TransportCardRequestDataActivitySubcomponentImpl(AppComponentImpl appComponentImpl, TransportCardRequestDataActivity arg0Param) {
            this.transportCardRequestDataActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(TransportCardRequestDataActivity arg0) {
            injectTransportCardRequestDataActivity(arg0);
        }

        private TransportCardRequestDataActivity injectTransportCardRequestDataActivity(TransportCardRequestDataActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            TransportCardRequestDataActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            TransportCardRequestDataActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class TransportCardContinueRequestActivitySubcomponentImpl implements ActivityModule_ContributesTransportCardContinueRequestActivity.TransportCardContinueRequestActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final TransportCardContinueRequestActivitySubcomponentImpl transportCardContinueRequestActivitySubcomponentImpl;

        private TransportCardContinueRequestActivitySubcomponentImpl(AppComponentImpl appComponentImpl, TransportCardContinueRequestActivity arg0Param) {
            this.transportCardContinueRequestActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(TransportCardContinueRequestActivity arg0) {
            injectTransportCardContinueRequestActivity(arg0);
        }

        private TransportCardContinueRequestActivity injectTransportCardContinueRequestActivity(TransportCardContinueRequestActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            TransportCardContinueRequestActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            TransportCardContinueRequestActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class LegalRepresentativeActivitySubcomponentImpl implements ActivityModule_ContributesLegalRepresentativeActivity.LegalRepresentativeActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final LegalRepresentativeActivitySubcomponentImpl legalRepresentativeActivitySubcomponentImpl;

        private LegalRepresentativeActivitySubcomponentImpl(AppComponentImpl appComponentImpl, LegalRepresentativeActivity arg0Param) {
            this.legalRepresentativeActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(LegalRepresentativeActivity arg0) {
            injectLegalRepresentativeActivity(arg0);
        }

        private LegalRepresentativeActivity injectLegalRepresentativeActivity(LegalRepresentativeActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            LegalRepresentativeActivity_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            LegalRepresentativeActivity_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class TransportCardRequestIdentificationActivitySubcomponentImpl implements ActivityModule_ContributesTransportCardRequestIdentificationActivity.TransportCardRequestIdentificationActivitySubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final TransportCardRequestIdentificationActivitySubcomponentImpl transportCardRequestIdentificationActivitySubcomponentImpl;

        private TransportCardRequestIdentificationActivitySubcomponentImpl(AppComponentImpl appComponentImpl, TransportCardRequestIdentificationActivity arg0Param) {
            this.transportCardRequestIdentificationActivitySubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        private DispatchingAndroidInjector<Fragment> dispatchingAndroidInjectorOfFragment() {
            return DispatchingAndroidInjector_Factory.newInstance(this.appComponentImpl.mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        @Override // dagger.android.AndroidInjector
        public void inject(TransportCardRequestIdentificationActivity arg0) {
            injectTransportCardRequestIdentificationActivity(arg0);
        }

        private TransportCardRequestIdentificationActivity injectTransportCardRequestIdentificationActivity(TransportCardRequestIdentificationActivity instance) {
            BaseActivity_MembersInjector.injectSupportFragmentInjector(instance, dispatchingAndroidInjectorOfFragment());
            return instance;
        }
    }

    private static final class MapStopsFragmentSubcomponentImpl implements FragmentModule_ContributesMapStopsFragment.MapStopsFragmentSubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final MapStopsFragmentSubcomponentImpl mapStopsFragmentSubcomponentImpl;

        private MapStopsFragmentSubcomponentImpl(AppComponentImpl appComponentImpl, MapStopsFragment arg0Param) {
            this.mapStopsFragmentSubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector
        public void inject(MapStopsFragment arg0) {
            injectMapStopsFragment(arg0);
        }

        private MapStopsFragment injectMapStopsFragment(MapStopsFragment instance) {
            MapStopsFragment_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class AllLinesFragmentSubcomponentImpl implements FragmentModule_ContributesAllLinesFragment.AllLinesFragmentSubcomponent {
        private final AllLinesFragmentSubcomponentImpl allLinesFragmentSubcomponentImpl;
        private final AppComponentImpl appComponentImpl;

        private AllLinesFragmentSubcomponentImpl(AppComponentImpl appComponentImpl, AllLinesFragment arg0Param) {
            this.allLinesFragmentSubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector
        public void inject(AllLinesFragment arg0) {
            injectAllLinesFragment(arg0);
        }

        private AllLinesFragment injectAllLinesFragment(AllLinesFragment instance) {
            AllLinesFragment_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            AllLinesFragment_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class NextArrivalsFragmentSubcomponentImpl implements FragmentModule_ContributesNextArrivalsFragment.NextArrivalsFragmentSubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final NextArrivalsFragmentSubcomponentImpl nextArrivalsFragmentSubcomponentImpl;

        private NextArrivalsFragmentSubcomponentImpl(AppComponentImpl appComponentImpl, NextArrivalsFragment arg0Param) {
            this.nextArrivalsFragmentSubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector
        public void inject(NextArrivalsFragment arg0) {
            injectNextArrivalsFragment(arg0);
        }

        private NextArrivalsFragment injectNextArrivalsFragment(NextArrivalsFragment instance) {
            NextArrivalsFragment_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            NextArrivalsFragment_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class LinesRealTimeListFragmentSubcomponentImpl implements FragmentModule_ContributesLinesRealTimeListFragment.LinesRealTimeListFragmentSubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final LinesRealTimeListFragmentSubcomponentImpl linesRealTimeListFragmentSubcomponentImpl;

        @Override // dagger.android.AndroidInjector
        public void inject(LinesRealTimeListFragment arg0) {
        }

        private LinesRealTimeListFragmentSubcomponentImpl(AppComponentImpl appComponentImpl, LinesRealTimeListFragment arg0Param) {
            this.linesRealTimeListFragmentSubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }
    }

    private static final class LinesRealTimeMapFragmentSubcomponentImpl implements FragmentModule_ContributesLinesRealTimeMapFragment.LinesRealTimeMapFragmentSubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final LinesRealTimeMapFragmentSubcomponentImpl linesRealTimeMapFragmentSubcomponentImpl;

        private LinesRealTimeMapFragmentSubcomponentImpl(AppComponentImpl appComponentImpl, LinesRealTimeMapFragment arg0Param) {
            this.linesRealTimeMapFragmentSubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector
        public void inject(LinesRealTimeMapFragment arg0) {
            injectLinesRealTimeMapFragment(arg0);
        }

        private LinesRealTimeMapFragment injectLinesRealTimeMapFragment(LinesRealTimeMapFragment instance) {
            LinesRealTimeMapFragment_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class SearchStopsFragmentSubcomponentImpl implements FragmentModule_ContributesSearchStopsFragment.SearchStopsFragmentSubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final SearchStopsFragmentSubcomponentImpl searchStopsFragmentSubcomponentImpl;

        private SearchStopsFragmentSubcomponentImpl(AppComponentImpl appComponentImpl, SearchStopsFragment arg0Param) {
            this.searchStopsFragmentSubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector
        public void inject(SearchStopsFragment arg0) {
            injectSearchStopsFragment(arg0);
        }

        private SearchStopsFragment injectSearchStopsFragment(SearchStopsFragment instance) {
            SearchStopsFragment_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class FavouriteStopsFragmentSubcomponentImpl implements FragmentModule_ContributesFavouriteStopsFragment.FavouriteStopsFragmentSubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final FavouriteStopsFragmentSubcomponentImpl favouriteStopsFragmentSubcomponentImpl;

        private FavouriteStopsFragmentSubcomponentImpl(AppComponentImpl appComponentImpl, FavouriteStopsFragment arg0Param) {
            this.favouriteStopsFragmentSubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector
        public void inject(FavouriteStopsFragment arg0) {
            injectFavouriteStopsFragment(arg0);
        }

        private FavouriteStopsFragment injectFavouriteStopsFragment(FavouriteStopsFragment instance) {
            FavouriteStopsFragment_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class CalculateZoneFragmentSubcomponentImpl implements FragmentModule_ContributesCalculateZoneFragment.CalculateZoneFragmentSubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final CalculateZoneFragmentSubcomponentImpl calculateZoneFragmentSubcomponentImpl;

        private CalculateZoneFragmentSubcomponentImpl(AppComponentImpl appComponentImpl, CalculateZoneFragment arg0Param) {
            this.calculateZoneFragmentSubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector
        public void inject(CalculateZoneFragment arg0) {
            injectCalculateZoneFragment(arg0);
        }

        private CalculateZoneFragment injectCalculateZoneFragment(CalculateZoneFragment instance) {
            CalculateZoneFragment_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class RechargeByZoneFragmentSubcomponentImpl implements FragmentModule_ContributesRechargeByZoneFragment.RechargeByZoneFragmentSubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final RechargeByZoneFragmentSubcomponentImpl rechargeByZoneFragmentSubcomponentImpl;

        private RechargeByZoneFragmentSubcomponentImpl(AppComponentImpl appComponentImpl, RechargeByZoneFragment arg0Param) {
            this.rechargeByZoneFragmentSubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector
        public void inject(RechargeByZoneFragment arg0) {
            injectRechargeByZoneFragment(arg0);
        }

        private RechargeByZoneFragment injectRechargeByZoneFragment(RechargeByZoneFragment instance) {
            RechargeByZoneFragment_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class RouteFragmentSubcomponentImpl implements FragmentModule_ContributesRouteFragment.RouteFragmentSubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final RouteFragmentSubcomponentImpl routeFragmentSubcomponentImpl;

        private RouteFragmentSubcomponentImpl(AppComponentImpl appComponentImpl, RouteFragment arg0Param) {
            this.routeFragmentSubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector
        public void inject(RouteFragment arg0) {
            injectRouteFragment(arg0);
        }

        private RouteFragment injectRouteFragment(RouteFragment instance) {
            RouteFragment_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            return instance;
        }
    }

    private static final class IncidentsFragmentSubcomponentImpl implements FragmentModule_ContributesIncidentsFragment.IncidentsFragmentSubcomponent {
        private final AppComponentImpl appComponentImpl;
        private final IncidentsFragmentSubcomponentImpl incidentsFragmentSubcomponentImpl;

        private IncidentsFragmentSubcomponentImpl(AppComponentImpl appComponentImpl, IncidentsFragment arg0Param) {
            this.incidentsFragmentSubcomponentImpl = this;
            this.appComponentImpl = appComponentImpl;
        }

        @Override // dagger.android.AndroidInjector
        public void inject(IncidentsFragment arg0) {
            injectIncidentsFragment(arg0);
        }

        private IncidentsFragment injectIncidentsFragment(IncidentsFragment instance) {
            IncidentsFragment_MembersInjector.injectViewModelFactory(instance, (ViewModelProvider.Factory) this.appComponentImpl.baseViewModelFactoryProvider.get());
            IncidentsFragment_MembersInjector.injectPreferences(instance, (PreferencesHelper) this.appComponentImpl.providePreferencesHelperProvider.get());
            return instance;
        }
    }

    private static final class AppComponentImpl implements AppComponent {
        private Provider<ActivityModule_ContributesAccessSettingsActivity.AccessSettingsActivitySubcomponent.Factory> accessSettingsActivitySubcomponentFactoryProvider;
        private Provider<AccessSettingsViewModelImpl> accessSettingsViewModelImplProvider;
        private Provider<ActivityModule_ContributesActivateAutoRechargeActivity.ActivateAutoRechargeActivitySubcomponent.Factory> activateAutoRechargeActivitySubcomponentFactoryProvider;
        private Provider<ActivateAutoRechargeViewModelImpl> activateAutoRechargeViewModelImplProvider;
        private Provider<ActivityModule_ContributesAddCardActivity.AddCardActivitySubcomponent.Factory> addCardActivitySubcomponentFactoryProvider;
        private Provider<AddCardViewModelImpl> addCardViewModelImplProvider;
        private Provider<ActivityModule_ContributesAddressPickerActivity.AddressPickerActivitySubcomponent.Factory> addressPickerActivitySubcomponentFactoryProvider;
        private Provider<AddressPickerViewModelImpl> addressPickerViewModelImplProvider;
        private Provider<FragmentModule_ContributesAllLinesFragment.AllLinesFragmentSubcomponent.Factory> allLinesFragmentSubcomponentFactoryProvider;
        private Provider<AllLinesViewModelImpl> allLinesViewModelImplProvider;
        private final AppComponentImpl appComponentImpl;
        private Provider<Application> applicationProvider;
        private Provider<ActivityModule_ContributesAutomaticRechargeActivity.AutomaticRechargeActivitySubcomponent.Factory> automaticRechargeActivitySubcomponentFactoryProvider;
        private Provider<AutomaticRechargeViewModelImpl> automaticRechargeViewModelImplProvider;
        private Provider<ActivityModule_ContributesBaseTransportCardActivity.BaseTransportCardActivitySubcomponent.Factory> baseTransportCardActivitySubcomponentFactoryProvider;
        private Provider<BaseTransportCardViewModelImpl> baseTransportCardViewModelImplProvider;
        private Provider<BaseViewModelFactory> baseViewModelFactoryProvider;
        private Provider<FragmentModule_ContributesCalculateZoneFragment.CalculateZoneFragmentSubcomponent.Factory> calculateZoneFragmentSubcomponentFactoryProvider;
        private Provider<CalculateZonesViewModelImpl> calculateZonesViewModelImplProvider;
        private Provider<ActivityModule_ContributesCertificateActivity.CertificateActivitySubcomponent.Factory> certificateActivitySubcomponentFactoryProvider;
        private Provider<CertificateViewModelImpl> certificateViewModelImplProvider;
        private Provider<ActivityModule_ContributesChangeAliasActivity.ChangeAliasActivitySubcomponent.Factory> changeAliasActivitySubcomponentFactoryProvider;
        private Provider<ChangeAliasViewModelImpl> changeAliasViewModelImplProvider;
        private Provider<ActivityModule_ContributesChangeZonesRechargeActivity.ChangeZonesRechargeActivitySubcomponent.Factory> changeZonesRechargeActivitySubcomponentFactoryProvider;
        private Provider<ChangeZonesRechargeViewModelImpl> changeZonesRechargeViewModelImplProvider;
        private Provider<Context> contextProvider;
        private Provider<ActivityModule_ContributesCreateReportsActivity.CreateReportsActivitySubcomponent.Factory> createReportsActivitySubcomponentFactoryProvider;
        private Provider<CreateReportsViewModelImpl> createReportsViewModelImplProvider;
        private Provider<ActivityModule_ContributesDataProtectionActivity.DataProtectionActivitySubcomponent.Factory> dataProtectionActivitySubcomponentFactoryProvider;
        private Provider<DataProtectionViewModelImpl> dataProtectionViewModelImplProvider;
        private Provider<ActivityModule_ContributesDateTimeLineActivity.DateTimeLineActivitySubcomponent.Factory> dateTimeLineActivitySubcomponentFactoryProvider;
        private Provider<DateTimeLineViewModelImpl> dateTimeLineViewModelImplProvider;
        private Provider<ActivityModule_ContributesDestinationUserSelectorActivity.DestinationUserSelectorActivitySubcomponent.Factory> destinationUserSelectorActivitySubcomponentFactoryProvider;
        private Provider<ActivityModule_ContributesDetailRouteActivity.DetailRouteActivitySubcomponent.Factory> detailRouteActivitySubcomponentFactoryProvider;
        private Provider<DetailRouteViewModelImpl> detailRouteViewModelImplProvider;
        private Provider<ActivityModule_ContributesDetailStopActivity.DetailStopActivitySubcomponent.Factory> detailStopActivitySubcomponentFactoryProvider;
        private Provider<DetailStopViewModelImpl> detailStopViewModelImplProvider;
        private Provider<ActivityModule_ContributesDetailTransportCardActivity.DetailTransportCardActivitySubcomponent.Factory> detailTransportCardActivitySubcomponentFactoryProvider;
        private Provider<DetailTransportCardViewModelImpl> detailTransportCardViewModelImplProvider;
        private Provider<ActivityModule_ContributesEditAutomaticRechargeActivity.EditAutomaticRechargeActivitySubcomponent.Factory> editAutomaticRechargeActivitySubcomponentFactoryProvider;
        private Provider<EditAutomaticRechargeViewModelImpl> editAutomaticRechargeViewModelImplProvider;
        private Provider<FragmentModule_ContributesFavouriteStopsFragment.FavouriteStopsFragmentSubcomponent.Factory> favouriteStopsFragmentSubcomponentFactoryProvider;
        private Provider<FavouriteStopsRepositoryImpl> favouriteStopsRepositoryImplProvider;
        private Provider<FavouriteStopsViewModelImpl> favouriteStopsViewModelImplProvider;
        private Provider<ActivityModule_ContributesIncidentActivity.IncidentActivitySubcomponent.Factory> incidentActivitySubcomponentFactoryProvider;
        private Provider<IncidentViewModelImpl> incidentViewModelImplProvider;
        private Provider<FragmentModule_ContributesIncidentsFragment.IncidentsFragmentSubcomponent.Factory> incidentsFragmentSubcomponentFactoryProvider;
        private Provider<IncidentsViewModelImpl> incidentsViewModelImplProvider;
        private Provider<ActivityModule_ContributesLargeFamilyDiscountActivity.LargeFamilyDiscountActivitySubcomponent.Factory> largeFamilyDiscountActivitySubcomponentFactoryProvider;
        private Provider<LargeFamilyDiscountViewModelImpl> largeFamilyDiscountViewModelImplProvider;
        private Provider<ActivityModule_ContributesLegalRepresentativeActivity.LegalRepresentativeActivitySubcomponent.Factory> legalRepresentativeActivitySubcomponentFactoryProvider;
        private Provider<LegalRepresentativeViewModelImpl> legalRepresentativeViewModelImplProvider;
        private Provider<ActivityModule_ContributesLinesRealTimeActivity.LinesRealTimeActivitySubcomponent.Factory> linesRealTimeActivitySubcomponentFactoryProvider;
        private Provider<FragmentModule_ContributesLinesRealTimeListFragment.LinesRealTimeListFragmentSubcomponent.Factory> linesRealTimeListFragmentSubcomponentFactoryProvider;
        private Provider<FragmentModule_ContributesLinesRealTimeMapFragment.LinesRealTimeMapFragmentSubcomponent.Factory> linesRealTimeMapFragmentSubcomponentFactoryProvider;
        private Provider<LinesRealTimeMapViewModelImpl> linesRealTimeMapViewModelImplProvider;
        private Provider<LinesRealTimeViewModelImpl> linesRealTimeViewModelImplProvider;
        private Provider<LinesRepositoryImpl> linesRepositoryImplProvider;
        private Provider<ActivityModule_ContributesLoginTransportCardActivity.LoginTransportCardActivitySubcomponent.Factory> loginTransportCardActivitySubcomponentFactoryProvider;
        private Provider<LoginTransportCardViewModelImpl> loginTransportCardViewModelImplProvider;
        private Provider<ActivityModule_ContributesLoginUserCardActivity.LoginUserCardActivitySubcomponent.Factory> loginUserCardActivitySubcomponentFactoryProvider;
        private Provider<LoginUserCardViewModelImpl> loginUserCardViewModelImplProvider;
        private Provider<ActivityModule_ContributesMainActivity.MainActivitySubcomponent.Factory> mainActivitySubcomponentFactoryProvider;
        private Provider<MainViewModelImpl> mainViewModelImplProvider;
        private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
        private Provider<FragmentModule_ContributesMapStopsFragment.MapStopsFragmentSubcomponent.Factory> mapStopsFragmentSubcomponentFactoryProvider;
        private Provider<MapStopsViewModelImpl> mapStopsViewModelImplProvider;
        private Provider<ActivityModule_ContributesMyAccountActivity.MyAccountActivitySubcomponent.Factory> myAccountActivitySubcomponentFactoryProvider;
        private Provider<MyAccountViewModelImpl> myAccountViewModelImplProvider;
        private Provider<ActivityModule_ContributesMyCreditCardsActivity.MyPaymentCardsActivitySubcomponent.Factory> myPaymentCardsActivitySubcomponentFactoryProvider;
        private Provider<MyPaymentCardsViewModelImpl> myPaymentCardsViewModelImplProvider;
        private Provider<ActivityModule_ContributesMyCardsActivity.MyTransportCardsActivitySubcomponent.Factory> myTransportCardsActivitySubcomponentFactoryProvider;
        private Provider<MyTransportCardsViewModelImpl> myTransportCardsViewModelImplProvider;
        private Provider<ActivityModule_ContributesNewsActivity.NewsActivitySubcomponent.Factory> newsActivitySubcomponentFactoryProvider;
        private Provider<ActivityModule_ContributesNewDetailActivity.NewsDetailActivitySubcomponent.Factory> newsDetailActivitySubcomponentFactoryProvider;
        private Provider<NewsDetailViewModelImpl> newsDetailViewModelImplProvider;
        private Provider<NewsViewModelImpl> newsViewModelImplProvider;
        private Provider<FragmentModule_ContributesNextArrivalsFragment.NextArrivalsFragmentSubcomponent.Factory> nextArrivalsFragmentSubcomponentFactoryProvider;
        private Provider<NextArrivalsViewModelImpl> nextArrivalsViewModelImplProvider;
        private Provider<NfcRepositoryImpl> nfcRepositoryImplProvider;
        private Provider<ActivityModule_ContributesNotificationMessageActivity.NotificationMessageActivitySubcomponent.Factory> notificationMessageActivitySubcomponentFactoryProvider;
        private Provider<NotificationRepositoryImpl> notificationRepositoryImplProvider;
        private Provider<PreferencesHelperImpl> preferencesHelperImplProvider;
        private Provider<AppDatabase> provideAppDatabaseProvider;
        private Provider<PaymentCardRepository> provideCardTokenRepositoryProvider;
        private Provider<DoBRepository> provideDoBRepositoryProvider;
        private Provider<FavouriteStopsRepository> provideFavouriteStopsRepositoryProvider;
        private Provider<LinesRepository> provideLinesRepositoryProvider;
        private Provider<NewsRepository> provideNewsRepositoryProvider;
        private Provider<NfcRepository> provideNfcRepositoryProvider;
        private Provider<NotificationRepository> provideNotificationRepositoryProvider;
        private Provider<PreferencesHelper> providePreferencesHelperProvider;
        private Provider<RechargeRepository> provideRechargeRepositoryProvider;
        private Provider<RouteRepository> provideRouteRepositoryProvider;
        private Provider<RtmRepository> provideRtmRepositoryProvider;
        private Provider<SearchDao> provideSearchDaoProvider;
        private Provider<StopsRepository> provideStopsRepositoryProvider;
        private Provider<TransportCardRepository> provideTransportCardRespositoryProvider;
        private Provider<UserRepository> provideUserRepositoryProvider;
        private Provider<StopsDao> providesStopsDaoProvider;
        private Provider<ActivityModule_ContributesReadCardNfcActivity.ReadCardNfcActivitySubcomponent.Factory> readCardNfcActivitySubcomponentFactoryProvider;
        private Provider<ReadCardNfcViewModelImpl> readCardNfcViewModelImplProvider;
        private Provider<ActivityModule_ContributesRechargeAmountCardActivity.RechargeBalanceCardActivitySubcomponent.Factory> rechargeBalanceCardActivitySubcomponentFactoryProvider;
        private Provider<RechargeBalanceCardViewModelImpl> rechargeBalanceCardViewModelImplProvider;
        private Provider<FragmentModule_ContributesRechargeByZoneFragment.RechargeByZoneFragmentSubcomponent.Factory> rechargeByZoneFragmentSubcomponentFactoryProvider;
        private Provider<RechargeByZoneViewModelImpl> rechargeByZoneViewModelImplProvider;
        private Provider<ActivityModule_ContributesRechargeRedsysActivity.RechargeRedsysActivitySubcomponent.Factory> rechargeRedsysActivitySubcomponentFactoryProvider;
        private Provider<RechargeRedsysViewModelImpl> rechargeRedsysViewModelImplProvider;
        private Provider<ActivityModule_ContributesRechargeSuscriptionActivity.RechargeZonesActivitySubcomponent.Factory> rechargeZonesActivitySubcomponentFactoryProvider;
        private Provider<RechargeZonesViewModelImpl> rechargeZonesViewModelImplProvider;
        private Provider<ActivityModule_ContributesRecoverPasswordActivity.RecoverPasswordActivitySubcomponent.Factory> recoverPasswordActivitySubcomponentFactoryProvider;
        private Provider<RecoverPasswordViewModelImpl> recoverPasswordViewModelImplProvider;
        private Provider<FragmentModule_ContributesRouteFragment.RouteFragmentSubcomponent.Factory> routeFragmentSubcomponentFactoryProvider;
        private Provider<RouteRepositoryImpl> routeRepositoryImplProvider;
        private Provider<RouteViewModelImpl> routeViewModelImplProvider;
        private Provider<ActivityModule_ContributesRtmRechargeCardActivity.RtmCardActivitySubcomponent.Factory> rtmCardActivitySubcomponentFactoryProvider;
        private Provider<RtmViewModelImpl> rtmViewModelImplProvider;
        private Provider<SearchStopViewModelImpl> searchStopViewModelImplProvider;
        private Provider<FragmentModule_ContributesSearchStopsFragment.SearchStopsFragmentSubcomponent.Factory> searchStopsFragmentSubcomponentFactoryProvider;
        private Provider<ActivityModule_ContributesSettingsActivity.SettingsActivitySubcomponent.Factory> settingsActivitySubcomponentFactoryProvider;
        private Provider<SettingsViewModelImpl> settingsViewModelImplProvider;
        private Provider<ActivityModule_ContributesSplashActivity.SplashActivitySubcomponent.Factory> splashActivitySubcomponentFactoryProvider;
        private Provider<StopsRepositoryImpl> stopsRepositoryImplProvider;
        private Provider<ActivityModule_ContributesTransportCardContinueRequestActivity.TransportCardContinueRequestActivitySubcomponent.Factory> transportCardContinueRequestActivitySubcomponentFactoryProvider;
        private Provider<TransportCardContinueRequestViewModelImpl> transportCardContinueRequestViewModelImplProvider;
        private Provider<ActivityModule_ContributesTransportCardRequestDataActivity.TransportCardRequestDataActivitySubcomponent.Factory> transportCardRequestDataActivitySubcomponentFactoryProvider;
        private Provider<TransportCardRequestDataViewModelImpl> transportCardRequestDataViewModelImplProvider;
        private Provider<ActivityModule_ContributesTransportCardRequestIdentificationActivity.TransportCardRequestIdentificationActivitySubcomponent.Factory> transportCardRequestIdentificationActivitySubcomponentFactoryProvider;
        private Provider<ActivityModule_ContributesTransportCardRequestInfoActivity.TransportCardRequestInfoActivitySubcomponent.Factory> transportCardRequestInfoActivitySubcomponentFactoryProvider;
        private Provider<TransportCardRequestInfoViewModelImpl> transportCardRequestInfoViewModelImplProvider;

        @Override // com.iecisa.ctausuario.di.AppComponent
        public void inject(NotificationService notificationService) {
        }

        private AppComponentImpl(Application applicationParam) {
            this.appComponentImpl = this;
            initialize(applicationParam);
            initialize2(applicationParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<Class<?>, Provider<AndroidInjector.Factory<?>>> mapOfClassOfAndProviderOfAndroidInjectorFactoryOf() {
            return ImmutableMap.builderWithExpectedSize(53).put(MainActivity.class, this.mainActivitySubcomponentFactoryProvider).put(SplashActivity.class, this.splashActivitySubcomponentFactoryProvider).put(ReadCardNfcActivity.class, this.readCardNfcActivitySubcomponentFactoryProvider).put(DetailStopActivity.class, this.detailStopActivitySubcomponentFactoryProvider).put(LinesRealTimeActivity.class, this.linesRealTimeActivitySubcomponentFactoryProvider).put(DateTimeLineActivity.class, this.dateTimeLineActivitySubcomponentFactoryProvider).put(NewsActivity.class, this.newsActivitySubcomponentFactoryProvider).put(AddressPickerActivity.class, this.addressPickerActivitySubcomponentFactoryProvider).put(DestinationUserSelectorActivity.class, this.destinationUserSelectorActivitySubcomponentFactoryProvider).put(RechargeBalanceCardActivity.class, this.rechargeBalanceCardActivitySubcomponentFactoryProvider).put(DetailTransportCardActivity.class, this.detailTransportCardActivitySubcomponentFactoryProvider).put(NewsDetailActivity.class, this.newsDetailActivitySubcomponentFactoryProvider).put(LoginUserCardActivity.class, this.loginUserCardActivitySubcomponentFactoryProvider).put(MyTransportCardsActivity.class, this.myTransportCardsActivitySubcomponentFactoryProvider).put(CreateReportsActivity.class, this.createReportsActivitySubcomponentFactoryProvider).put(RecoverPasswordActivity.class, this.recoverPasswordActivitySubcomponentFactoryProvider).put(RechargeZonesActivity.class, this.rechargeZonesActivitySubcomponentFactoryProvider).put(AccessSettingsActivity.class, this.accessSettingsActivitySubcomponentFactoryProvider).put(AddCardActivity.class, this.addCardActivitySubcomponentFactoryProvider).put(CertificateActivity.class, this.certificateActivitySubcomponentFactoryProvider).put(LoginTransportCardActivity.class, this.loginTransportCardActivitySubcomponentFactoryProvider).put(ChangeZonesRechargeActivity.class, this.changeZonesRechargeActivitySubcomponentFactoryProvider).put(DataProtectionActivity.class, this.dataProtectionActivitySubcomponentFactoryProvider).put(MyAccountActivity.class, this.myAccountActivitySubcomponentFactoryProvider).put(AutomaticRechargeActivity.class, this.automaticRechargeActivitySubcomponentFactoryProvider).put(DetailRouteActivity.class, this.detailRouteActivitySubcomponentFactoryProvider).put(MyPaymentCardsActivity.class, this.myPaymentCardsActivitySubcomponentFactoryProvider).put(RtmCardActivity.class, this.rtmCardActivitySubcomponentFactoryProvider).put(RechargeRedsysActivity.class, this.rechargeRedsysActivitySubcomponentFactoryProvider).put(LargeFamilyDiscountActivity.class, this.largeFamilyDiscountActivitySubcomponentFactoryProvider).put(IncidentActivity.class, this.incidentActivitySubcomponentFactoryProvider).put(ChangeAliasActivity.class, this.changeAliasActivitySubcomponentFactoryProvider).put(ActivateAutoRechargeActivity.class, this.activateAutoRechargeActivitySubcomponentFactoryProvider).put(BaseTransportCardActivity.class, this.baseTransportCardActivitySubcomponentFactoryProvider).put(SettingsActivity.class, this.settingsActivitySubcomponentFactoryProvider).put(EditAutomaticRechargeActivity.class, this.editAutomaticRechargeActivitySubcomponentFactoryProvider).put(NotificationMessageActivity.class, this.notificationMessageActivitySubcomponentFactoryProvider).put(TransportCardRequestInfoActivity.class, this.transportCardRequestInfoActivitySubcomponentFactoryProvider).put(TransportCardRequestDataActivity.class, this.transportCardRequestDataActivitySubcomponentFactoryProvider).put(TransportCardContinueRequestActivity.class, this.transportCardContinueRequestActivitySubcomponentFactoryProvider).put(LegalRepresentativeActivity.class, this.legalRepresentativeActivitySubcomponentFactoryProvider).put(TransportCardRequestIdentificationActivity.class, this.transportCardRequestIdentificationActivitySubcomponentFactoryProvider).put(MapStopsFragment.class, this.mapStopsFragmentSubcomponentFactoryProvider).put(AllLinesFragment.class, this.allLinesFragmentSubcomponentFactoryProvider).put(NextArrivalsFragment.class, this.nextArrivalsFragmentSubcomponentFactoryProvider).put(LinesRealTimeListFragment.class, this.linesRealTimeListFragmentSubcomponentFactoryProvider).put(LinesRealTimeMapFragment.class, this.linesRealTimeMapFragmentSubcomponentFactoryProvider).put(SearchStopsFragment.class, this.searchStopsFragmentSubcomponentFactoryProvider).put(FavouriteStopsFragment.class, this.favouriteStopsFragmentSubcomponentFactoryProvider).put(CalculateZoneFragment.class, this.calculateZoneFragmentSubcomponentFactoryProvider).put(RechargeByZoneFragment.class, this.rechargeByZoneFragmentSubcomponentFactoryProvider).put(RouteFragment.class, this.routeFragmentSubcomponentFactoryProvider).put(IncidentsFragment.class, this.incidentsFragmentSubcomponentFactoryProvider).build();
        }

        private DispatchingAndroidInjector<Activity> dispatchingAndroidInjectorOfActivity() {
            return DispatchingAndroidInjector_Factory.newInstance(mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), ImmutableMap.of());
        }

        private void initialize(final Application applicationParam) {
            this.mainActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesMainActivity.MainActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesMainActivity.MainActivitySubcomponent.Factory get() {
                    return new MainActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.splashActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesSplashActivity.SplashActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesSplashActivity.SplashActivitySubcomponent.Factory get() {
                    return new SplashActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.readCardNfcActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesReadCardNfcActivity.ReadCardNfcActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesReadCardNfcActivity.ReadCardNfcActivitySubcomponent.Factory get() {
                    return new ReadCardNfcActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.detailStopActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesDetailStopActivity.DetailStopActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesDetailStopActivity.DetailStopActivitySubcomponent.Factory get() {
                    return new DetailStopActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.linesRealTimeActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesLinesRealTimeActivity.LinesRealTimeActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.5
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesLinesRealTimeActivity.LinesRealTimeActivitySubcomponent.Factory get() {
                    return new LinesRealTimeActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.dateTimeLineActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesDateTimeLineActivity.DateTimeLineActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.6
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesDateTimeLineActivity.DateTimeLineActivitySubcomponent.Factory get() {
                    return new DateTimeLineActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.newsActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesNewsActivity.NewsActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesNewsActivity.NewsActivitySubcomponent.Factory get() {
                    return new NewsActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.addressPickerActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesAddressPickerActivity.AddressPickerActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.8
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesAddressPickerActivity.AddressPickerActivitySubcomponent.Factory get() {
                    return new AddressPickerActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.destinationUserSelectorActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesDestinationUserSelectorActivity.DestinationUserSelectorActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.9
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesDestinationUserSelectorActivity.DestinationUserSelectorActivitySubcomponent.Factory get() {
                    return new DestinationUserSelectorActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.rechargeBalanceCardActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesRechargeAmountCardActivity.RechargeBalanceCardActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.10
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesRechargeAmountCardActivity.RechargeBalanceCardActivitySubcomponent.Factory get() {
                    return new RechargeBalanceCardActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.detailTransportCardActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesDetailTransportCardActivity.DetailTransportCardActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.11
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesDetailTransportCardActivity.DetailTransportCardActivitySubcomponent.Factory get() {
                    return new DetailTransportCardActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.newsDetailActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesNewDetailActivity.NewsDetailActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.12
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesNewDetailActivity.NewsDetailActivitySubcomponent.Factory get() {
                    return new NewsDetailActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.loginUserCardActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesLoginUserCardActivity.LoginUserCardActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.13
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesLoginUserCardActivity.LoginUserCardActivitySubcomponent.Factory get() {
                    return new LoginUserCardActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.myTransportCardsActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesMyCardsActivity.MyTransportCardsActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.14
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesMyCardsActivity.MyTransportCardsActivitySubcomponent.Factory get() {
                    return new MyTransportCardsActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.createReportsActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesCreateReportsActivity.CreateReportsActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.15
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesCreateReportsActivity.CreateReportsActivitySubcomponent.Factory get() {
                    return new CreateReportsActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.recoverPasswordActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesRecoverPasswordActivity.RecoverPasswordActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.16
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesRecoverPasswordActivity.RecoverPasswordActivitySubcomponent.Factory get() {
                    return new RecoverPasswordActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.rechargeZonesActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesRechargeSuscriptionActivity.RechargeZonesActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.17
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesRechargeSuscriptionActivity.RechargeZonesActivitySubcomponent.Factory get() {
                    return new RechargeZonesActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.accessSettingsActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesAccessSettingsActivity.AccessSettingsActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.18
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesAccessSettingsActivity.AccessSettingsActivitySubcomponent.Factory get() {
                    return new AccessSettingsActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.addCardActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesAddCardActivity.AddCardActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.19
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesAddCardActivity.AddCardActivitySubcomponent.Factory get() {
                    return new AddCardActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.certificateActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesCertificateActivity.CertificateActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.20
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesCertificateActivity.CertificateActivitySubcomponent.Factory get() {
                    return new CertificateActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.loginTransportCardActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesLoginTransportCardActivity.LoginTransportCardActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.21
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesLoginTransportCardActivity.LoginTransportCardActivitySubcomponent.Factory get() {
                    return new LoginTransportCardActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.changeZonesRechargeActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesChangeZonesRechargeActivity.ChangeZonesRechargeActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.22
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesChangeZonesRechargeActivity.ChangeZonesRechargeActivitySubcomponent.Factory get() {
                    return new ChangeZonesRechargeActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.dataProtectionActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesDataProtectionActivity.DataProtectionActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.23
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesDataProtectionActivity.DataProtectionActivitySubcomponent.Factory get() {
                    return new DataProtectionActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.myAccountActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesMyAccountActivity.MyAccountActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.24
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesMyAccountActivity.MyAccountActivitySubcomponent.Factory get() {
                    return new MyAccountActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.automaticRechargeActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesAutomaticRechargeActivity.AutomaticRechargeActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.25
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesAutomaticRechargeActivity.AutomaticRechargeActivitySubcomponent.Factory get() {
                    return new AutomaticRechargeActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.detailRouteActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesDetailRouteActivity.DetailRouteActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.26
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesDetailRouteActivity.DetailRouteActivitySubcomponent.Factory get() {
                    return new DetailRouteActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.myPaymentCardsActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesMyCreditCardsActivity.MyPaymentCardsActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.27
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesMyCreditCardsActivity.MyPaymentCardsActivitySubcomponent.Factory get() {
                    return new MyPaymentCardsActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.rtmCardActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesRtmRechargeCardActivity.RtmCardActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.28
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesRtmRechargeCardActivity.RtmCardActivitySubcomponent.Factory get() {
                    return new RtmCardActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.rechargeRedsysActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesRechargeRedsysActivity.RechargeRedsysActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.29
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesRechargeRedsysActivity.RechargeRedsysActivitySubcomponent.Factory get() {
                    return new RechargeRedsysActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.largeFamilyDiscountActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesLargeFamilyDiscountActivity.LargeFamilyDiscountActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.30
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesLargeFamilyDiscountActivity.LargeFamilyDiscountActivitySubcomponent.Factory get() {
                    return new LargeFamilyDiscountActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.incidentActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesIncidentActivity.IncidentActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.31
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesIncidentActivity.IncidentActivitySubcomponent.Factory get() {
                    return new IncidentActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.changeAliasActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesChangeAliasActivity.ChangeAliasActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.32
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesChangeAliasActivity.ChangeAliasActivitySubcomponent.Factory get() {
                    return new ChangeAliasActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.activateAutoRechargeActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesActivateAutoRechargeActivity.ActivateAutoRechargeActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.33
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesActivateAutoRechargeActivity.ActivateAutoRechargeActivitySubcomponent.Factory get() {
                    return new ActivateAutoRechargeActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.baseTransportCardActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesBaseTransportCardActivity.BaseTransportCardActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.34
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesBaseTransportCardActivity.BaseTransportCardActivitySubcomponent.Factory get() {
                    return new BaseTransportCardActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.settingsActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesSettingsActivity.SettingsActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.35
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesSettingsActivity.SettingsActivitySubcomponent.Factory get() {
                    return new SettingsActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.editAutomaticRechargeActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesEditAutomaticRechargeActivity.EditAutomaticRechargeActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.36
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesEditAutomaticRechargeActivity.EditAutomaticRechargeActivitySubcomponent.Factory get() {
                    return new EditAutomaticRechargeActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.notificationMessageActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesNotificationMessageActivity.NotificationMessageActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.37
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesNotificationMessageActivity.NotificationMessageActivitySubcomponent.Factory get() {
                    return new NotificationMessageActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.transportCardRequestInfoActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesTransportCardRequestInfoActivity.TransportCardRequestInfoActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.38
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesTransportCardRequestInfoActivity.TransportCardRequestInfoActivitySubcomponent.Factory get() {
                    return new TransportCardRequestInfoActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.transportCardRequestDataActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesTransportCardRequestDataActivity.TransportCardRequestDataActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.39
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesTransportCardRequestDataActivity.TransportCardRequestDataActivitySubcomponent.Factory get() {
                    return new TransportCardRequestDataActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.transportCardContinueRequestActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesTransportCardContinueRequestActivity.TransportCardContinueRequestActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.40
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesTransportCardContinueRequestActivity.TransportCardContinueRequestActivitySubcomponent.Factory get() {
                    return new TransportCardContinueRequestActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.legalRepresentativeActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesLegalRepresentativeActivity.LegalRepresentativeActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.41
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesLegalRepresentativeActivity.LegalRepresentativeActivitySubcomponent.Factory get() {
                    return new LegalRepresentativeActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.transportCardRequestIdentificationActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributesTransportCardRequestIdentificationActivity.TransportCardRequestIdentificationActivitySubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.42
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public ActivityModule_ContributesTransportCardRequestIdentificationActivity.TransportCardRequestIdentificationActivitySubcomponent.Factory get() {
                    return new TransportCardRequestIdentificationActivitySubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.mapStopsFragmentSubcomponentFactoryProvider = new Provider<FragmentModule_ContributesMapStopsFragment.MapStopsFragmentSubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.43
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public FragmentModule_ContributesMapStopsFragment.MapStopsFragmentSubcomponent.Factory get() {
                    return new MapStopsFragmentSubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.allLinesFragmentSubcomponentFactoryProvider = new Provider<FragmentModule_ContributesAllLinesFragment.AllLinesFragmentSubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.44
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public FragmentModule_ContributesAllLinesFragment.AllLinesFragmentSubcomponent.Factory get() {
                    return new AllLinesFragmentSubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.nextArrivalsFragmentSubcomponentFactoryProvider = new Provider<FragmentModule_ContributesNextArrivalsFragment.NextArrivalsFragmentSubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.45
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public FragmentModule_ContributesNextArrivalsFragment.NextArrivalsFragmentSubcomponent.Factory get() {
                    return new NextArrivalsFragmentSubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.linesRealTimeListFragmentSubcomponentFactoryProvider = new Provider<FragmentModule_ContributesLinesRealTimeListFragment.LinesRealTimeListFragmentSubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.46
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public FragmentModule_ContributesLinesRealTimeListFragment.LinesRealTimeListFragmentSubcomponent.Factory get() {
                    return new LinesRealTimeListFragmentSubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.linesRealTimeMapFragmentSubcomponentFactoryProvider = new Provider<FragmentModule_ContributesLinesRealTimeMapFragment.LinesRealTimeMapFragmentSubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.47
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public FragmentModule_ContributesLinesRealTimeMapFragment.LinesRealTimeMapFragmentSubcomponent.Factory get() {
                    return new LinesRealTimeMapFragmentSubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.searchStopsFragmentSubcomponentFactoryProvider = new Provider<FragmentModule_ContributesSearchStopsFragment.SearchStopsFragmentSubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.48
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public FragmentModule_ContributesSearchStopsFragment.SearchStopsFragmentSubcomponent.Factory get() {
                    return new SearchStopsFragmentSubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.favouriteStopsFragmentSubcomponentFactoryProvider = new Provider<FragmentModule_ContributesFavouriteStopsFragment.FavouriteStopsFragmentSubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.49
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public FragmentModule_ContributesFavouriteStopsFragment.FavouriteStopsFragmentSubcomponent.Factory get() {
                    return new FavouriteStopsFragmentSubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.calculateZoneFragmentSubcomponentFactoryProvider = new Provider<FragmentModule_ContributesCalculateZoneFragment.CalculateZoneFragmentSubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.50
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public FragmentModule_ContributesCalculateZoneFragment.CalculateZoneFragmentSubcomponent.Factory get() {
                    return new CalculateZoneFragmentSubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.rechargeByZoneFragmentSubcomponentFactoryProvider = new Provider<FragmentModule_ContributesRechargeByZoneFragment.RechargeByZoneFragmentSubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.51
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public FragmentModule_ContributesRechargeByZoneFragment.RechargeByZoneFragmentSubcomponent.Factory get() {
                    return new RechargeByZoneFragmentSubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.routeFragmentSubcomponentFactoryProvider = new Provider<FragmentModule_ContributesRouteFragment.RouteFragmentSubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.52
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public FragmentModule_ContributesRouteFragment.RouteFragmentSubcomponent.Factory get() {
                    return new RouteFragmentSubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            this.incidentsFragmentSubcomponentFactoryProvider = new Provider<FragmentModule_ContributesIncidentsFragment.IncidentsFragmentSubcomponent.Factory>() { // from class: com.iecisa.ctausuario.di.DaggerAppComponent.AppComponentImpl.53
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public FragmentModule_ContributesIncidentsFragment.IncidentsFragmentSubcomponent.Factory get() {
                    return new IncidentsFragmentSubcomponentFactory(AppComponentImpl.this.appComponentImpl);
                }
            };
            Factory factoryCreate = InstanceFactory.create(applicationParam);
            this.applicationProvider = factoryCreate;
            Provider<Context> provider = DoubleCheck.provider(factoryCreate);
            this.contextProvider = provider;
            PreferencesHelperImpl_Factory preferencesHelperImpl_FactoryCreate = PreferencesHelperImpl_Factory.create(provider);
            this.preferencesHelperImplProvider = preferencesHelperImpl_FactoryCreate;
            Provider<PreferencesHelper> provider2 = DoubleCheck.provider(CoreModule_ProvidePreferencesHelperFactory.create(preferencesHelperImpl_FactoryCreate));
            this.providePreferencesHelperProvider = provider2;
            NotificationRepositoryImpl_Factory notificationRepositoryImpl_FactoryCreate = NotificationRepositoryImpl_Factory.create(provider2);
            this.notificationRepositoryImplProvider = notificationRepositoryImpl_FactoryCreate;
            this.provideNotificationRepositoryProvider = DoubleCheck.provider(notificationRepositoryImpl_FactoryCreate);
            NfcRepositoryImpl_Factory nfcRepositoryImpl_FactoryCreate = NfcRepositoryImpl_Factory.create(this.providePreferencesHelperProvider);
            this.nfcRepositoryImplProvider = nfcRepositoryImpl_FactoryCreate;
            Provider<NfcRepository> provider3 = DoubleCheck.provider(nfcRepositoryImpl_FactoryCreate);
            this.provideNfcRepositoryProvider = provider3;
            this.mainViewModelImplProvider = MainViewModelImpl_Factory.create(this.applicationProvider, provider3, this.provideNotificationRepositoryProvider);
            this.readCardNfcViewModelImplProvider = ReadCardNfcViewModelImpl_Factory.create(this.applicationProvider, this.provideNfcRepositoryProvider);
            Provider<AppDatabase> provider4 = DoubleCheck.provider(AppModule_ProvideAppDatabaseFactory.create(this.applicationProvider));
            this.provideAppDatabaseProvider = provider4;
            Provider<StopsDao> provider5 = DoubleCheck.provider(AppModule_ProvidesStopsDaoFactory.create(provider4));
            this.providesStopsDaoProvider = provider5;
            StopsRepositoryImpl_Factory stopsRepositoryImpl_FactoryCreate = StopsRepositoryImpl_Factory.create(provider5);
            this.stopsRepositoryImplProvider = stopsRepositoryImpl_FactoryCreate;
            this.provideStopsRepositoryProvider = DoubleCheck.provider(stopsRepositoryImpl_FactoryCreate);
            Provider<SearchDao> provider6 = DoubleCheck.provider(AppModule_ProvideSearchDaoFactory.create(this.provideAppDatabaseProvider));
            this.provideSearchDaoProvider = provider6;
            RouteRepositoryImpl_Factory routeRepositoryImpl_FactoryCreate = RouteRepositoryImpl_Factory.create(provider6);
            this.routeRepositoryImplProvider = routeRepositoryImpl_FactoryCreate;
            Provider<RouteRepository> provider7 = DoubleCheck.provider(routeRepositoryImpl_FactoryCreate);
            this.provideRouteRepositoryProvider = provider7;
            this.mapStopsViewModelImplProvider = MapStopsViewModelImpl_Factory.create(this.applicationProvider, this.provideStopsRepositoryProvider, provider7, AppModule_ProvideCompositeDisposableFactory.create(), AppModule_ProvideSchedulerProviderFactory.create());
            LinesRepositoryImpl_Factory linesRepositoryImpl_FactoryCreate = LinesRepositoryImpl_Factory.create(this.providesStopsDaoProvider);
            this.linesRepositoryImplProvider = linesRepositoryImpl_FactoryCreate;
            Provider<LinesRepository> provider8 = DoubleCheck.provider(linesRepositoryImpl_FactoryCreate);
            this.provideLinesRepositoryProvider = provider8;
            this.allLinesViewModelImplProvider = AllLinesViewModelImpl_Factory.create(this.applicationProvider, provider8, this.provideNotificationRepositoryProvider);
            this.nextArrivalsViewModelImplProvider = NextArrivalsViewModelImpl_Factory.create(this.applicationProvider, this.provideStopsRepositoryProvider, this.provideNotificationRepositoryProvider);
            this.linesRealTimeViewModelImplProvider = LinesRealTimeViewModelImpl_Factory.create(this.applicationProvider, this.provideLinesRepositoryProvider, AppModule_ProvideCompositeDisposableFactory.create(), AppModule_ProvideSchedulerProviderFactory.create());
            this.linesRealTimeMapViewModelImplProvider = LinesRealTimeMapViewModelImpl_Factory.create(this.applicationProvider, this.provideLinesRepositoryProvider);
            this.dateTimeLineViewModelImplProvider = DateTimeLineViewModelImpl_Factory.create(this.applicationProvider, this.provideStopsRepositoryProvider, AppModule_ProvideCompositeDisposableFactory.create(), AppModule_ProvideSchedulerProviderFactory.create());
            this.searchStopViewModelImplProvider = SearchStopViewModelImpl_Factory.create(this.applicationProvider, this.provideStopsRepositoryProvider);
            Provider<NewsRepository> provider9 = DoubleCheck.provider(NewsRepositoryImpl_Factory.create());
            this.provideNewsRepositoryProvider = provider9;
            this.newsViewModelImplProvider = NewsViewModelImpl_Factory.create(this.applicationProvider, provider9);
            FavouriteStopsRepositoryImpl_Factory favouriteStopsRepositoryImpl_FactoryCreate = FavouriteStopsRepositoryImpl_Factory.create(this.providesStopsDaoProvider);
            this.favouriteStopsRepositoryImplProvider = favouriteStopsRepositoryImpl_FactoryCreate;
            Provider<FavouriteStopsRepository> provider10 = DoubleCheck.provider(favouriteStopsRepositoryImpl_FactoryCreate);
            this.provideFavouriteStopsRepositoryProvider = provider10;
            this.favouriteStopsViewModelImplProvider = FavouriteStopsViewModelImpl_Factory.create(this.applicationProvider, provider10, AppModule_ProvideCompositeDisposableFactory.create(), AppModule_ProvideSchedulerProviderFactory.create());
            this.detailStopViewModelImplProvider = DetailStopViewModelImpl_Factory.create(this.applicationProvider, this.provideStopsRepositoryProvider, AppModule_ProvideCompositeDisposableFactory.create(), AppModule_ProvideSchedulerProviderFactory.create());
            this.addressPickerViewModelImplProvider = AddressPickerViewModelImpl_Factory.create(this.applicationProvider, this.provideRouteRepositoryProvider, AppModule_ProvideCompositeDisposableFactory.create(), AppModule_ProvideSchedulerProviderFactory.create());
            this.provideTransportCardRespositoryProvider = DoubleCheck.provider(TransportCardRepositoryImpl_Factory.create());
            this.provideRechargeRepositoryProvider = DoubleCheck.provider(RechargeRepositoryImpl_Factory.create());
            this.provideCardTokenRepositoryProvider = DoubleCheck.provider(PaymentCardRepositoryImpl_Factory.create());
            this.provideRtmRepositoryProvider = DoubleCheck.provider(RtmRepositoryImpl_Factory.create());
            this.rechargeBalanceCardViewModelImplProvider = RechargeBalanceCardViewModelImpl_Factory.create(this.applicationProvider, this.provideTransportCardRespositoryProvider, this.provideRechargeRepositoryProvider, this.provideCardTokenRepositoryProvider, this.provideNfcRepositoryProvider, AppModule_ProvideCompositeDisposableFactory.create(), AppModule_ProvideSchedulerProviderFactory.create(), this.provideNewsRepositoryProvider, this.provideRtmRepositoryProvider);
            this.detailTransportCardViewModelImplProvider = DetailTransportCardViewModelImpl_Factory.create(this.applicationProvider, this.provideTransportCardRespositoryProvider, this.provideNfcRepositoryProvider);
            this.newsDetailViewModelImplProvider = NewsDetailViewModelImpl_Factory.create(this.applicationProvider, this.provideNewsRepositoryProvider);
            this.routeViewModelImplProvider = RouteViewModelImpl_Factory.create(this.applicationProvider, this.provideRouteRepositoryProvider);
            this.detailRouteViewModelImplProvider = DetailRouteViewModelImpl_Factory.create(this.applicationProvider);
            Provider<UserRepository> provider11 = DoubleCheck.provider(UserRepositoryImpl_Factory.create());
            this.provideUserRepositoryProvider = provider11;
            this.loginUserCardViewModelImplProvider = LoginUserCardViewModelImpl_Factory.create(this.applicationProvider, provider11, AppModule_ProvideCompositeDisposableFactory.create(), AppModule_ProvideSchedulerProviderFactory.create());
            this.myTransportCardsViewModelImplProvider = MyTransportCardsViewModelImpl_Factory.create(this.applicationProvider, this.provideTransportCardRespositoryProvider);
            this.createReportsViewModelImplProvider = CreateReportsViewModelImpl_Factory.create(this.applicationProvider, this.provideTransportCardRespositoryProvider);
            this.recoverPasswordViewModelImplProvider = RecoverPasswordViewModelImpl_Factory.create(this.applicationProvider, this.provideUserRepositoryProvider);
        }

        private void initialize2(final Application applicationParam) {
            this.rechargeZonesViewModelImplProvider = RechargeZonesViewModelImpl_Factory.create(this.applicationProvider, this.provideRechargeRepositoryProvider, this.provideCardTokenRepositoryProvider, this.provideRtmRepositoryProvider, this.provideNfcRepositoryProvider, this.provideNewsRepositoryProvider);
            this.accessSettingsViewModelImplProvider = AccessSettingsViewModelImpl_Factory.create(this.applicationProvider, this.provideUserRepositoryProvider);
            this.addCardViewModelImplProvider = AddCardViewModelImpl_Factory.create(this.applicationProvider, this.provideNfcRepositoryProvider);
            this.certificateViewModelImplProvider = CertificateViewModelImpl_Factory.create(this.applicationProvider, this.provideTransportCardRespositoryProvider, this.provideUserRepositoryProvider, this.provideNewsRepositoryProvider);
            this.loginTransportCardViewModelImplProvider = LoginTransportCardViewModelImpl_Factory.create(this.applicationProvider, this.provideTransportCardRespositoryProvider, this.provideUserRepositoryProvider);
            this.changeZonesRechargeViewModelImplProvider = ChangeZonesRechargeViewModelImpl_Factory.create(this.applicationProvider, this.provideRechargeRepositoryProvider);
            this.calculateZonesViewModelImplProvider = CalculateZonesViewModelImpl_Factory.create(this.applicationProvider, this.provideRechargeRepositoryProvider);
            this.rechargeByZoneViewModelImplProvider = RechargeByZoneViewModelImpl_Factory.create(this.applicationProvider, this.provideTransportCardRespositoryProvider);
            this.dataProtectionViewModelImplProvider = DataProtectionViewModelImpl_Factory.create(this.applicationProvider, this.provideTransportCardRespositoryProvider);
            this.myAccountViewModelImplProvider = MyAccountViewModelImpl_Factory.create(this.applicationProvider, this.provideUserRepositoryProvider);
            this.automaticRechargeViewModelImplProvider = AutomaticRechargeViewModelImpl_Factory.create(this.applicationProvider, this.provideTransportCardRespositoryProvider, this.provideCardTokenRepositoryProvider, this.provideNfcRepositoryProvider);
            this.myPaymentCardsViewModelImplProvider = MyPaymentCardsViewModelImpl_Factory.create(this.applicationProvider, this.provideCardTokenRepositoryProvider);
            this.incidentsViewModelImplProvider = IncidentsViewModelImpl_Factory.create(this.applicationProvider, this.provideTransportCardRespositoryProvider, this.provideUserRepositoryProvider, this.provideNewsRepositoryProvider);
            this.rtmViewModelImplProvider = RtmViewModelImpl_Factory.create(this.applicationProvider, this.provideUserRepositoryProvider, this.provideNfcRepositoryProvider);
            this.rechargeRedsysViewModelImplProvider = RechargeRedsysViewModelImpl_Factory.create(this.applicationProvider, this.provideNfcRepositoryProvider);
            this.largeFamilyDiscountViewModelImplProvider = LargeFamilyDiscountViewModelImpl_Factory.create(this.applicationProvider, this.provideTransportCardRespositoryProvider, this.provideNfcRepositoryProvider, this.provideNewsRepositoryProvider);
            this.incidentViewModelImplProvider = IncidentViewModelImpl_Factory.create(this.applicationProvider, this.provideTransportCardRespositoryProvider);
            this.changeAliasViewModelImplProvider = ChangeAliasViewModelImpl_Factory.create(this.applicationProvider, this.provideUserRepositoryProvider);
            this.activateAutoRechargeViewModelImplProvider = ActivateAutoRechargeViewModelImpl_Factory.create(this.applicationProvider, this.provideCardTokenRepositoryProvider, this.provideTransportCardRespositoryProvider, this.provideNewsRepositoryProvider);
            this.baseTransportCardViewModelImplProvider = BaseTransportCardViewModelImpl_Factory.create(this.applicationProvider, this.provideUserRepositoryProvider, this.provideNewsRepositoryProvider);
            this.settingsViewModelImplProvider = SettingsViewModelImpl_Factory.create(this.applicationProvider);
            this.editAutomaticRechargeViewModelImplProvider = EditAutomaticRechargeViewModelImpl_Factory.create(this.applicationProvider, this.provideTransportCardRespositoryProvider, this.provideCardTokenRepositoryProvider);
            Provider<DoBRepository> provider = DoubleCheck.provider(DoBRepositoryImpl_Factory.create());
            this.provideDoBRepositoryProvider = provider;
            this.transportCardRequestInfoViewModelImplProvider = TransportCardRequestInfoViewModelImpl_Factory.create(this.applicationProvider, this.provideNewsRepositoryProvider, provider);
            this.transportCardRequestDataViewModelImplProvider = TransportCardRequestDataViewModelImpl_Factory.create(this.applicationProvider, this.provideDoBRepositoryProvider);
            this.transportCardContinueRequestViewModelImplProvider = TransportCardContinueRequestViewModelImpl_Factory.create(this.applicationProvider, this.provideDoBRepositoryProvider);
            this.legalRepresentativeViewModelImplProvider = LegalRepresentativeViewModelImpl_Factory.create(this.applicationProvider, this.provideNewsRepositoryProvider, this.provideDoBRepositoryProvider);
            MapProviderFactory mapProviderFactoryBuild = MapProviderFactory.builder(48).put((MapProviderFactory.Builder) MainViewModelImpl.class, (Provider) this.mainViewModelImplProvider).put((MapProviderFactory.Builder) ReadCardNfcViewModelImpl.class, (Provider) this.readCardNfcViewModelImplProvider).put((MapProviderFactory.Builder) MapStopsViewModelImpl.class, (Provider) this.mapStopsViewModelImplProvider).put((MapProviderFactory.Builder) AllLinesViewModelImpl.class, (Provider) this.allLinesViewModelImplProvider).put((MapProviderFactory.Builder) NextArrivalsViewModelImpl.class, (Provider) this.nextArrivalsViewModelImplProvider).put((MapProviderFactory.Builder) LinesRealTimeViewModelImpl.class, (Provider) this.linesRealTimeViewModelImplProvider).put((MapProviderFactory.Builder) LinesRealTimeMapViewModelImpl.class, (Provider) this.linesRealTimeMapViewModelImplProvider).put((MapProviderFactory.Builder) DateTimeLineViewModelImpl.class, (Provider) this.dateTimeLineViewModelImplProvider).put((MapProviderFactory.Builder) SearchStopViewModelImpl.class, (Provider) this.searchStopViewModelImplProvider).put((MapProviderFactory.Builder) NewsViewModelImpl.class, (Provider) this.newsViewModelImplProvider).put((MapProviderFactory.Builder) FavouriteStopsViewModelImpl.class, (Provider) this.favouriteStopsViewModelImplProvider).put((MapProviderFactory.Builder) DetailStopViewModelImpl.class, (Provider) this.detailStopViewModelImplProvider).put((MapProviderFactory.Builder) AddressPickerViewModelImpl.class, (Provider) this.addressPickerViewModelImplProvider).put((MapProviderFactory.Builder) RechargeBalanceCardViewModelImpl.class, (Provider) this.rechargeBalanceCardViewModelImplProvider).put((MapProviderFactory.Builder) DetailTransportCardViewModelImpl.class, (Provider) this.detailTransportCardViewModelImplProvider).put((MapProviderFactory.Builder) NewsDetailViewModelImpl.class, (Provider) this.newsDetailViewModelImplProvider).put((MapProviderFactory.Builder) RouteViewModelImpl.class, (Provider) this.routeViewModelImplProvider).put((MapProviderFactory.Builder) DetailRouteViewModelImpl.class, (Provider) this.detailRouteViewModelImplProvider).put((MapProviderFactory.Builder) LoginUserCardViewModelImpl.class, (Provider) this.loginUserCardViewModelImplProvider).put((MapProviderFactory.Builder) MyTransportCardsViewModelImpl.class, (Provider) this.myTransportCardsViewModelImplProvider).put((MapProviderFactory.Builder) CreateReportsViewModelImpl.class, (Provider) this.createReportsViewModelImplProvider).put((MapProviderFactory.Builder) RecoverPasswordViewModelImpl.class, (Provider) this.recoverPasswordViewModelImplProvider).put((MapProviderFactory.Builder) RechargeZonesViewModelImpl.class, (Provider) this.rechargeZonesViewModelImplProvider).put((MapProviderFactory.Builder) AccessSettingsViewModelImpl.class, (Provider) this.accessSettingsViewModelImplProvider).put((MapProviderFactory.Builder) AddCardViewModelImpl.class, (Provider) this.addCardViewModelImplProvider).put((MapProviderFactory.Builder) CertificateViewModelImpl.class, (Provider) this.certificateViewModelImplProvider).put((MapProviderFactory.Builder) LoginTransportCardViewModelImpl.class, (Provider) this.loginTransportCardViewModelImplProvider).put((MapProviderFactory.Builder) ChangeZonesRechargeViewModelImpl.class, (Provider) this.changeZonesRechargeViewModelImplProvider).put((MapProviderFactory.Builder) CalculateZonesViewModelImpl.class, (Provider) this.calculateZonesViewModelImplProvider).put((MapProviderFactory.Builder) RechargeByZoneViewModelImpl.class, (Provider) this.rechargeByZoneViewModelImplProvider).put((MapProviderFactory.Builder) DataProtectionViewModelImpl.class, (Provider) this.dataProtectionViewModelImplProvider).put((MapProviderFactory.Builder) MyAccountViewModelImpl.class, (Provider) this.myAccountViewModelImplProvider).put((MapProviderFactory.Builder) AutomaticRechargeViewModelImpl.class, (Provider) this.automaticRechargeViewModelImplProvider).put((MapProviderFactory.Builder) MyPaymentCardsViewModelImpl.class, (Provider) this.myPaymentCardsViewModelImplProvider).put((MapProviderFactory.Builder) IncidentsViewModelImpl.class, (Provider) this.incidentsViewModelImplProvider).put((MapProviderFactory.Builder) RtmViewModelImpl.class, (Provider) this.rtmViewModelImplProvider).put((MapProviderFactory.Builder) RechargeRedsysViewModelImpl.class, (Provider) this.rechargeRedsysViewModelImplProvider).put((MapProviderFactory.Builder) LargeFamilyDiscountViewModelImpl.class, (Provider) this.largeFamilyDiscountViewModelImplProvider).put((MapProviderFactory.Builder) IncidentViewModelImpl.class, (Provider) this.incidentViewModelImplProvider).put((MapProviderFactory.Builder) ChangeAliasViewModelImpl.class, (Provider) this.changeAliasViewModelImplProvider).put((MapProviderFactory.Builder) ActivateAutoRechargeViewModelImpl.class, (Provider) this.activateAutoRechargeViewModelImplProvider).put((MapProviderFactory.Builder) BaseTransportCardViewModelImpl.class, (Provider) this.baseTransportCardViewModelImplProvider).put((MapProviderFactory.Builder) SettingsViewModelImpl.class, (Provider) this.settingsViewModelImplProvider).put((MapProviderFactory.Builder) EditAutomaticRechargeViewModelImpl.class, (Provider) this.editAutomaticRechargeViewModelImplProvider).put((MapProviderFactory.Builder) TransportCardRequestInfoViewModelImpl.class, (Provider) this.transportCardRequestInfoViewModelImplProvider).put((MapProviderFactory.Builder) TransportCardRequestDataViewModelImpl.class, (Provider) this.transportCardRequestDataViewModelImplProvider).put((MapProviderFactory.Builder) TransportCardContinueRequestViewModelImpl.class, (Provider) this.transportCardContinueRequestViewModelImplProvider).put((MapProviderFactory.Builder) LegalRepresentativeViewModelImpl.class, (Provider) this.legalRepresentativeViewModelImplProvider).build();
            this.mapOfClassOfAndProviderOfViewModelProvider = mapProviderFactoryBuild;
            this.baseViewModelFactoryProvider = DoubleCheck.provider(BaseViewModelFactory_Factory.create(mapProviderFactoryBuild));
        }

        @Override // com.iecisa.ctausuario.di.AppComponent
        public void inject(App app) {
            injectApp(app);
        }

        @Override // com.iecisa.ctausuario.di.AppComponent
        public void inject(RefreshInterceptor refreshInterceptor) {
            injectRefreshInterceptor(refreshInterceptor);
        }

        private App injectApp(App instance) {
            App_MembersInjector.injectActivityInjector(instance, dispatchingAndroidInjectorOfActivity());
            App_MembersInjector.injectPreferences(instance, this.providePreferencesHelperProvider.get());
            App_MembersInjector.injectNotificationRepository(instance, this.provideNotificationRepositoryProvider.get());
            return instance;
        }

        private RefreshInterceptor injectRefreshInterceptor(RefreshInterceptor instance) {
            RefreshInterceptor_MembersInjector.injectPreferencesHelper(instance, this.providePreferencesHelperProvider.get());
            return instance;
        }
    }
}
