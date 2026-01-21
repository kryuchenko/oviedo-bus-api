package com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.PaymentCardModel;
import com.iecisa.ctausuario.ui.main.BaseTransportCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsAdapter;
import com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsViewHolder;
import com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.SwipeHelper;
import com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentgateway.RechargeRedsysActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class MyPaymentCardsActivity extends BaseTransportCardActivity {
    private MyPaymentCardsAdapter adapter;

    @BindView(R.id.rvCard)
    RecyclerView rvCard;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvCardAdded)
    TextView tvCardAdded;

    @BindView(R.id.tvInfoMessage)
    TextView tvInfoMessage;
    private MyPaymentCardsViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_my_payment_cards;
    }

    @Override // com.iecisa.ctausuario.ui.main.BaseTransportCardActivity, com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (MyPaymentCardsViewModel) new ViewModelProvider(this, this.viewModelFactory).get(MyPaymentCardsViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_my_payment_cards));
        setupView();
    }

    private void setupView() {
        getPaymentCards();
    }

    private void setupAdapter(List<PaymentCardModel> data) {
        this.rvCard.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new MyPaymentCardsAdapter(data, new MyPaymentCardsAdapter.OnRemoveCardListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity$$ExternalSyntheticLambda0
            @Override // com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsAdapter.OnRemoveCardListener
            public final void onRemoveListener(PaymentCardModel paymentCardModel) {
                this.f$0.showDialogRemoveCard(paymentCardModel);
            }
        }, new MyPaymentCardsViewHolder.OnCardListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity$$ExternalSyntheticLambda1
            @Override // com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsViewHolder.OnCardListener
            public final void onClickListener(PaymentCardModel paymentCardModel) {
                this.f$0.onSetFavouritePaymentCard(paymentCardModel);
            }
        });
        SwipeHelper swipeHelper = new SwipeHelper(this, this.rvCard, Constants.SwipeType.PAYMENT_CARD) { // from class: com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity.1
            @Override // com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.SwipeHelper
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<SwipeHelper.UnderlayButton> underlayButtons) throws Resources.NotFoundException {
                Context applicationContext = MyPaymentCardsActivity.this.getApplicationContext();
                String string = MyPaymentCardsActivity.this.getString(R.string.label_delete);
                int color = MyPaymentCardsActivity.this.getResources().getColor(R.color.text_color_red);
                final MyPaymentCardsAdapter myPaymentCardsAdapter = MyPaymentCardsActivity.this.adapter;
                Objects.requireNonNull(myPaymentCardsAdapter);
                underlayButtons.add(new SwipeHelper.UnderlayButton(applicationContext, string, color, new SwipeHelper.UnderlayButtonClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity$1$$ExternalSyntheticLambda0
                    @Override // com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.SwipeHelper.UnderlayButtonClickListener
                    public final void onClick(int i) {
                        myPaymentCardsAdapter.removeCard(i);
                    }
                }));
            }
        };
        this.rvCard.setAdapter(this.adapter);
        new ItemTouchHelper(swipeHelper).attachToRecyclerView(this.rvCard);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetFavouritePaymentCard(PaymentCardModel model) {
        this.viewModel.setFavouritePaymentCard(this, model.getIdToken()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onSetFavouritePaymentCard$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSetFavouritePaymentCard$0(Resource resource) {
        int i = AnonymousClass5.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showKoDialog(resource.message);
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            this.adapter.clear();
            getPaymentCards();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRemoveCard(PaymentCardModel model) {
        this.viewModel.removePaymentCard(this, model.getIdToken()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onRemoveCard$1((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRemoveCard$1(Resource resource) {
        int i = AnonymousClass5.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showKoDialog(resource.message);
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            BaseUtils.showInfoMessage(this.tvInfoMessage);
            this.adapter.clear();
            getPaymentCards();
        }
    }

    private void setColorMessage(TextView textView, int backgroundColor, int textColor) {
        textView.setBackgroundColor(backgroundColor);
        textView.setTextColor(textColor);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        setResult(-1, new Intent());
        finish();
        return true;
    }

    @OnClick({R.id.btAddCard})
    public void onViewClicked() {
        getConditions(BuildConfig.ADD_PAYMENT_CARD, new BaseUtils.onGetConditions() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity.2
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onGetConditions
            public void onSuccess(ConditionsResponseModel model) {
                MyPaymentCardsActivity.this.goToOneClickDialog(model.getTitle(), model.getDescription());
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onGetConditions
            public void onError(Integer code, String message) {
                MyPaymentCardsActivity.this.showKoDialog(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToOneClickDialog(String title, String description) {
        BaseUtils.showDialog(this, 1, title, description, getString(R.string.label_payment_one_click_ok), getString(R.string.label_payment_one_click_ko), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity.3
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                MyPaymentCardsActivity.this.addPaymentCard();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPaymentCard() {
        this.viewModel.addPaymentCard(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$addPaymentCard$2((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addPaymentCard$2(Resource resource) {
        int i = AnonymousClass5.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showKoDialog(resource.message);
            return;
        }
        if (i == 2) {
            showLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        hideLoading();
        if (resource.data != 0) {
            Intent intent = new Intent(this, (Class<?>) RechargeRedsysActivity.class);
            intent.putExtra(Constants.IntentData.INTENT_TYPE_RECHARGE_WEBVIEW, (Parcelable) resource.data);
            startActivityForResult(intent, 9);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 9) {
            BaseUtils.showInfoMessage(this.tvCardAdded);
            getPaymentCards();
        } else if (resultCode == 10) {
            getPaymentCards();
        } else if (resultCode == 11) {
            addPaymentCard();
        }
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
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
    public void getPaymentCards() {
        this.viewModel.getPaymentCards(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getPaymentCards$3((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPaymentCards$3(Resource resource) {
        int i = AnonymousClass5.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            return;
        }
        if (i == 2) {
            showLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        hideLoading();
        if (resource.data == 0 || ((List) resource.data).size() <= 0) {
            return;
        }
        if (this.adapter != null) {
            refreshCards((List) resource.data);
        } else {
            setupAdapter((List) resource.data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogRemoveCard(final PaymentCardModel model) {
        setColorMessage(this.tvInfoMessage, getResources().getColor(R.color.green_toogle_button), getResources().getColor(R.color.text_color));
        this.tvInfoMessage.setText(getString((!model.getIsFavourite().booleanValue() || this.adapter.getItemCount() <= 1) ? R.string.label_info_removed_card : R.string.label_info_removed_favourite_card));
        BaseUtils.showDialog(this, 0, getString(R.string.label_info_remove_card), null, getString(R.string.label_yes), getString(R.string.label_no), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mypaymentcards.MyPaymentCardsActivity.4
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                MyPaymentCardsActivity.this.onRemoveCard(model);
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
                MyPaymentCardsActivity.this.getPaymentCards();
            }
        });
    }

    private void refreshCards(List<PaymentCardModel> cardResponseModelList) {
        this.adapter.addAll(cardResponseModelList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showKoDialog(String message) {
        BaseUtils.showKoDialog(this, message);
    }
}
