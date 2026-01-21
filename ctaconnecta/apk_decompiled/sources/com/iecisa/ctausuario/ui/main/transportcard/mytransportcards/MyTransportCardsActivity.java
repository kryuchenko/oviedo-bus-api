package com.iecisa.ctausuario.ui.main.transportcard.mytransportcards;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.AddCardRequestModel;
import com.iecisa.ctausuario.model.CardResponseModel;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import com.iecisa.ctausuario.ui.main.BaseTransportCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.accesssettings.AccessSettingsActivity;
import com.iecisa.ctausuario.ui.main.transportcard.addcard.AddCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.myaccount.MyAccountActivity;
import com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity;
import com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.SwipeHelper;
import com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.adapter.MyTransportCardsAdapter;
import com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.adapter.MyTransportCardsViewHolder;
import com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class MyTransportCardsActivity extends BaseTransportCardActivity {
    private Boolean canRechargeCard = true;
    private CardResponseModel cardResponseModel;

    @Inject
    PreferencesHelper myPreferences;
    private MyTransportCardsAdapter myTransportCardsAdapter;

    @Inject
    PreferencesHelper preferencesHelper;

    @BindView(R.id.rvTransportCards)
    RecyclerView rvTransportCards;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvCardAdded)
    TextView tvCardAdded;

    @BindView(R.id.tvInfoMessage)
    TextView tvInfoMessage;
    private MyTransportCardsViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_my_cards;
    }

    @Override // com.iecisa.ctausuario.ui.main.BaseTransportCardActivity, com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (MyTransportCardsViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(MyTransportCardsViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_my_cards));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupCards() {
        this.viewModel.getTransportCards(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupCards$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupCards$0(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            this.tvInfoMessage.setText(resource.message);
            BaseUtils.showInfoMessage(this.tvInfoMessage);
        } else {
            if (i == 2) {
                showLoading();
                return;
            }
            if (i != 3) {
                return;
            }
            hideLoading();
            if (resource.data != 0) {
                if (this.myTransportCardsAdapter != null) {
                    reloadCards((List) resource.data);
                } else {
                    setupAdapter((List) resource.data);
                }
            }
        }
    }

    private void setupAdapter(List<CardResponseModel> modelList) {
        this.rvTransportCards.setLayoutManager(new LinearLayoutManager(this));
        MyTransportCardsAdapter myTransportCardsAdapter = new MyTransportCardsAdapter(modelList, new MyTransportCardsViewHolder.OnCardListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity$$ExternalSyntheticLambda4
            @Override // com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.adapter.MyTransportCardsViewHolder.OnCardListener
            public final void onClickListener(CardResponseModel cardResponseModel) {
                this.f$0.onClickCard(cardResponseModel);
            }
        }, new MyTransportCardsAdapter.OnRemoveCardListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity$$ExternalSyntheticLambda5
            @Override // com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.adapter.MyTransportCardsAdapter.OnRemoveCardListener
            public final void onRemoveListener(CardResponseModel cardResponseModel) {
                this.f$0.showDialogRemoveCard(cardResponseModel);
            }
        });
        this.myTransportCardsAdapter = myTransportCardsAdapter;
        this.rvTransportCards.setAdapter(myTransportCardsAdapter);
        setDeleteCardSwipe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickCard(CardResponseModel model) {
        showLoading();
        goToReadCard(model);
    }

    private void setDeleteCardSwipe() {
        new ItemTouchHelper(new SwipeHelper(this, this.rvTransportCards, Constants.SwipeType.TRANSPORT_CARD) { // from class: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity.1
            @Override // com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.SwipeHelper
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<SwipeHelper.UnderlayButton> underlayButtons) throws Resources.NotFoundException {
                Integer cardType = MyTransportCardsActivity.this.myTransportCardsAdapter.getCardType(viewHolder.getAdapterPosition());
                if (cardType.equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_CTA) || cardType.equals(Constants.Cards.TRANSPORT_CARD_TYPE_BONO_10)) {
                    Context applicationContext = MyTransportCardsActivity.this.getApplicationContext();
                    String string = MyTransportCardsActivity.this.getString(R.string.label_delete);
                    int color = MyTransportCardsActivity.this.getResources().getColor(R.color.text_color_red);
                    final MyTransportCardsAdapter myTransportCardsAdapter = MyTransportCardsActivity.this.myTransportCardsAdapter;
                    Objects.requireNonNull(myTransportCardsAdapter);
                    underlayButtons.add(new SwipeHelper.UnderlayButton(applicationContext, string, color, new SwipeHelper.UnderlayButtonClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity$1$$ExternalSyntheticLambda0
                        @Override // com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.SwipeHelper.UnderlayButtonClickListener
                        public final void onClick(int i) {
                            myTransportCardsAdapter.removeCard(i);
                        }
                    }));
                }
            }
        }).attachToRecyclerView(this.rvTransportCards);
    }

    private void goToReadCard(CardResponseModel model) {
        this.cardResponseModel = model;
        Intent intent = new Intent(this, (Class<?>) RtmCardActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TYPE_RTM, 1);
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, model.getNumChip());
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TYPE_NAME, model.getCardTypeName());
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_ALIAS, model.getAlias());
        intent.putExtra(Constants.IntentData.INTENT_READ_CARD, true);
        hideLoading();
        startActivityForResult(intent, 10);
    }

    private void goToDetailCard() {
        Intent intent = new Intent(this, (Class<?>) DetailTransportCardActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, this.cardResponseModel);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogRemoveCard(final CardResponseModel model) {
        BaseUtils.showDialog(this, 0, getString(R.string.label_info_remove_my_card), null, getString(R.string.label_yes), getString(R.string.label_no), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity.2
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                MyTransportCardsActivity.this.onRemoveCard(model);
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
                MyTransportCardsActivity.this.setupCards();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRemoveCard(final CardResponseModel model) {
        this.viewModel.removeTransportCard(model.getNumChip(), this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onRemoveCard$1(model, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRemoveCard$1(CardResponseModel cardResponseModel, Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(this, resource.message);
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            removeCard(cardResponseModel.getNumChip());
        }
    }

    private void removeCard(String numChip) {
        int iFindPosition = this.myTransportCardsAdapter.findPosition(numChip);
        this.myTransportCardsAdapter.remove(iFindPosition);
        this.myTransportCardsAdapter.notifyItemRemoved(iFindPosition);
        MyTransportCardsAdapter myTransportCardsAdapter = this.myTransportCardsAdapter;
        myTransportCardsAdapter.notifyItemRangeChanged(iFindPosition, myTransportCardsAdapter.getItemCount());
        this.tvInfoMessage.setText(getString(R.string.label_info_removed_card));
        BaseUtils.showInfoMessage(this.tvInfoMessage);
    }

    @OnClick({R.id.btAddCard})
    public void onClickAddCard() {
        goToAddCard();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        TransportCardModel transportCardModel;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (data == null || data.getExtras() == null) {
                return;
            }
            this.viewModel.addTransportCard(new AddCardRequestModel(data.getExtras().getString(Constants.NFCValues.NFC_KEY_CARD), data.getExtras().getString(Constants.NFCValues.NFC_KEY_CHARACTER), data.getExtras().getString(Constants.NFCValues.NFC_KEY_ALIAS), data.getExtras().getString(Constants.NFCValues.NFC_KEY_CHARACTER)), this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity$$ExternalSyntheticLambda2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$onActivityResult$2((Resource) obj);
                }
            });
            return;
        }
        if (requestCode == 10) {
            if (resultCode != -1) {
                if (resultCode == 1) {
                    goToDetailCard();
                }
            } else {
                if (data == null || data.getExtras() == null || !(data.getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_RECHARGE_RTM) instanceof TransportCardModel) || (transportCardModel = (TransportCardModel) data.getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_RECHARGE_RTM)) == null) {
                    return;
                }
                Intent intent = new Intent(this, (Class<?>) DetailTransportCardActivity.class);
                intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER, transportCardModel);
                intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_RMT, true);
                startActivity(intent);
            }
        }
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$cexmobility$core$data$Resource$Status;

        static {
            int[] iArr = new int[Resource.Status.values().length];
            $SwitchMap$com$cexmobility$core$data$Resource$Status = iArr;
            try {
                iArr[Resource.Status.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$cexmobility$core$data$Resource$Status[Resource.Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$cexmobility$core$data$Resource$Status[Resource.Status.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$2(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showDialogError(resource.message);
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            setupCards();
            BaseUtils.showInfoMessage(this.tvCardAdded);
        }
    }

    private void showDialogError(String message) {
        BaseUtils.showInfoDialog(this, 2, getString(R.string.label_something_go_wrong), message, getString(R.string.label_accept), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.MyTransportCardsActivity.3
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public void onClickPositive() {
                MyTransportCardsActivity.this.goToAddCard();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToAddCard() {
        startActivityForResult(new Intent(this, (Class<?>) AddCardActivity.class), 0);
    }

    private void reloadCards(List<CardResponseModel> cardModelList) {
        this.myTransportCardsAdapter.clearAll();
        this.myTransportCardsAdapter.addAll(cardModelList);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_my_cards, menu);
        menu.findItem(R.id.navMyCreditCard).setVisible(this.canRechargeCard.booleanValue());
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navAccessSettings /* 2131362447 */:
                startActivity(new Intent(this, (Class<?>) AccessSettingsActivity.class));
                return true;
            case R.id.navAutoRecharge /* 2131362448 */:
            case R.id.navCertificate /* 2131362449 */:
            case R.id.navLargeFamilyDiscount /* 2131362451 */:
            default:
                return super.onOptionsItemSelected(item);
            case R.id.navCloseSession /* 2131362450 */:
                deleteTokenBearer();
                return false;
            case R.id.navLegalRepresentative /* 2131362452 */:
                startActivity(new Intent(this, (Class<?>) LegalRepresentativeActivity.class));
                return true;
            case R.id.navMyAccount /* 2131362453 */:
                startActivity(new Intent(this, (Class<?>) MyAccountActivity.class));
                return true;
            case R.id.navMyCreditCard /* 2131362454 */:
                startActivity(new Intent(this, (Class<?>) MyPaymentCardsActivity.class));
                return true;
        }
    }

    private void deleteTokenBearer() {
        this.preferencesHelper.setPassUser();
        this.preferencesHelper.removeBearerToken();
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        setupCards();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT < 29 || Settings.canDrawOverlays(this)) {
            return;
        }
        finish();
    }
}
