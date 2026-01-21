package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.BaseTransportCardActivity;
import com.iecisa.ctausuario.ui.main.MainActivity;
import com.iecisa.ctausuario.ui.main.datelines.DateTimeLineActivity;
import com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeActivity;
import com.iecisa.ctausuario.ui.main.more.news.NewsActivity;
import com.iecisa.ctausuario.ui.main.more.news.newsdetail.NewsDetailActivity;
import com.iecisa.ctausuario.ui.main.more.settings.SettingsActivity;
import com.iecisa.ctausuario.ui.main.notification.NotificationMessageActivity;
import com.iecisa.ctausuario.ui.main.route.detailroute.DetailRouteActivity;
import com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerActivity;
import com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity;
import com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity;
import com.iecisa.ctausuario.ui.main.transportcard.addcard.AddCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.dataprotection.DataProtectionActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.activateautorecharge.ActivateAutoRechargeActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.alias.ChangeAliasActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.AutomaticRechargeActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.autorecharge.edit.EditAutomaticRechargeActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.discountfamily.LargeFamilyDiscountActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.incident.IncidentActivity;
import com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.recoverpassword.RecoverPasswordActivity;
import com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity;
import com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity;
import com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity;
import com.iecisa.ctausuario.ui.main.transportcard.readcardnfc.ReadCardNfcActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.ChangeZonesRechargeActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargebalance.RechargeBalanceCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones.RechargeZonesActivity;
import com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.data.TransportCardRequestDataActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.identification.TransportCardRequestIdentificationActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeActivity;
import com.iecisa.ctausuario.ui.splash.SplashActivity;
import com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
/* loaded from: classes5.dex */
public interface ActivityModule {
    @ContributesAndroidInjector
    AccessSettingsActivity contributesAccessSettingsActivity();

    @ContributesAndroidInjector
    ActivateAutoRechargeActivity contributesActivateAutoRechargeActivity();

    @ContributesAndroidInjector
    AddCardActivity contributesAddCardActivity();

    @ContributesAndroidInjector
    AddressPickerActivity contributesAddressPickerActivity();

    @ContributesAndroidInjector
    AutomaticRechargeActivity contributesAutomaticRechargeActivity();

    @ContributesAndroidInjector
    BaseTransportCardActivity contributesBaseTransportCardActivity();

    @ContributesAndroidInjector
    CertificateActivity contributesCertificateActivity();

    @ContributesAndroidInjector
    ChangeAliasActivity contributesChangeAliasActivity();

    @ContributesAndroidInjector
    ChangeZonesRechargeActivity contributesChangeZonesRechargeActivity();

    @ContributesAndroidInjector
    CreateReportsActivity contributesCreateReportsActivity();

    @ContributesAndroidInjector
    DataProtectionActivity contributesDataProtectionActivity();

    @ContributesAndroidInjector
    DateTimeLineActivity contributesDateTimeLineActivity();

    @ContributesAndroidInjector
    DestinationUserSelectorActivity contributesDestinationUserSelectorActivity();

    @ContributesAndroidInjector
    DetailRouteActivity contributesDetailRouteActivity();

    @ContributesAndroidInjector
    DetailStopActivity contributesDetailStopActivity();

    @ContributesAndroidInjector
    DetailTransportCardActivity contributesDetailTransportCardActivity();

    @ContributesAndroidInjector
    EditAutomaticRechargeActivity contributesEditAutomaticRechargeActivity();

    @ContributesAndroidInjector
    IncidentActivity contributesIncidentActivity();

    @ContributesAndroidInjector
    LargeFamilyDiscountActivity contributesLargeFamilyDiscountActivity();

    @ContributesAndroidInjector
    LegalRepresentativeActivity contributesLegalRepresentativeActivity();

    @ContributesAndroidInjector
    LinesRealTimeActivity contributesLinesRealTimeActivity();

    @ContributesAndroidInjector
    LoginTransportCardActivity contributesLoginTransportCardActivity();

    @ContributesAndroidInjector
    LoginUserCardActivity contributesLoginUserCardActivity();

    @ContributesAndroidInjector
    MainActivity contributesMainActivity();

    @ContributesAndroidInjector
    MyAccountActivity contributesMyAccountActivity();

    @ContributesAndroidInjector
    MyTransportCardsActivity contributesMyCardsActivity();

    @ContributesAndroidInjector
    MyPaymentCardsActivity contributesMyCreditCardsActivity();

    @ContributesAndroidInjector
    NewsDetailActivity contributesNewDetailActivity();

    @ContributesAndroidInjector
    NewsActivity contributesNewsActivity();

    @ContributesAndroidInjector
    NotificationMessageActivity contributesNotificationMessageActivity();

    @ContributesAndroidInjector
    ReadCardNfcActivity contributesReadCardNfcActivity();

    @ContributesAndroidInjector
    RechargeBalanceCardActivity contributesRechargeAmountCardActivity();

    @ContributesAndroidInjector
    RechargeRedsysActivity contributesRechargeRedsysActivity();

    @ContributesAndroidInjector
    RechargeZonesActivity contributesRechargeSuscriptionActivity();

    @ContributesAndroidInjector
    RecoverPasswordActivity contributesRecoverPasswordActivity();

    @ContributesAndroidInjector
    RtmCardActivity contributesRtmRechargeCardActivity();

    @ContributesAndroidInjector
    SettingsActivity contributesSettingsActivity();

    @ContributesAndroidInjector
    SplashActivity contributesSplashActivity();

    @ContributesAndroidInjector
    TransportCardContinueRequestActivity contributesTransportCardContinueRequestActivity();

    @ContributesAndroidInjector
    TransportCardRequestDataActivity contributesTransportCardRequestDataActivity();

    @ContributesAndroidInjector
    TransportCardRequestIdentificationActivity contributesTransportCardRequestIdentificationActivity();

    @ContributesAndroidInjector
    TransportCardRequestInfoActivity contributesTransportCardRequestInfoActivity();
}
