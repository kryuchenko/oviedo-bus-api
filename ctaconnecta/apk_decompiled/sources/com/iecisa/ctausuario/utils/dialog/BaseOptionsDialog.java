package com.iecisa.ctausuario.utils.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cexmobility.core.widgets.dialog.AnimationLoader;
import com.cexmobility.core.widgets.dialog.DisplayUtil;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class BaseOptionsDialog extends Dialog {
    public static final int DIALOG_TYPE_INFO = 0;
    public static final int DIALOG_TYPE_INFO_HTML = 1;
    public static final int DIALOG_TYPE_SUCCESS = 3;
    public static final int DIALOG_TYPE_WARNING = 4;
    public static final int DIALOG_TYPE_WARNING_VERSION = 5;
    public static final int DIALOG_TYPE_WRONG = 2;
    private MaterialButton btnNegative;
    private MaterialButton btnPositive;
    private ConstraintLayout clContent;
    private AnimationSet mAnimIn;
    private AnimationSet mAnimOut;
    private CharSequence mBtnText;
    private CharSequence mBtnTextNegative;
    private CharSequence mContent;
    private int mDialogType;
    private View mDialogView;
    private boolean mIsShowAnim;
    private CharSequence mTitle;
    private onClickCommentsDialog onClickListener;
    private onClickCommentsDialogNegative onClickListenerNegative;
    private TextView tvContent;
    private TextView tvTitle;

    public interface onClickCommentsDialog {
        void onClickPositive(BaseOptionsDialog dialog);
    }

    public interface onClickCommentsDialogNegative {
        void onClickNegative(BaseOptionsDialog dialog);
    }

    public BaseOptionsDialog(Context context) {
        this(context, 0);
    }

    public BaseOptionsDialog(Context context, int theme) {
        super(context, R.style.color_dialog);
        init();
    }

    private void init() {
        this.mAnimIn = AnimationLoader.getInAnimation(getContext());
        this.mAnimOut = AnimationLoader.getOutAnimation(getContext());
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
    }

    private void initView() {
        View viewInflate = View.inflate(getContext(), R.layout.dialog_type, null);
        setContentView(viewInflate);
        resizeDialog();
        this.clContent = (ConstraintLayout) viewInflate.findViewById(R.id.clContent);
        this.mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tvTitle);
        this.tvTitle = textView;
        textView.setText(this.mTitle);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tvContent);
        this.tvContent = textView2;
        if (this.mDialogType == 1) {
            setTextHtml(this.mContent);
        } else {
            textView2.setText(this.mContent);
        }
        this.tvContent.setMovementMethod(LinkMovementMethod.getInstance());
        setButtons(viewInflate);
        if (this.mTitle == null) {
            this.tvTitle.setVisibility(8);
        }
        getDialogStyle(this.mDialogType);
    }

    private void setTextHtml(CharSequence mContent) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.tvContent.setText(Html.fromHtml(mContent.toString(), 63));
        } else {
            this.tvContent.setText(Html.fromHtml(mContent.toString()));
        }
    }

    private void setButtons(View contentView) {
        this.btnPositive = (MaterialButton) contentView.findViewById(R.id.btnPositive);
        this.btnNegative = (MaterialButton) contentView.findViewById(R.id.btnNegative);
        this.btnPositive.setText(this.mBtnText);
        this.btnNegative.setText(this.mBtnTextNegative);
        this.btnNegative.setVisibility(this.mBtnTextNegative != null ? 0 : 8);
    }

    private void getDialogStyle(int mDialogType) {
        if (2 == mDialogType) {
            this.clContent.setBackgroundColor(getContext().getResources().getColor(R.color.text_color_red));
            this.tvTitle.setTextColor(getContext().getResources().getColor(R.color.white));
            this.tvContent.setTextColor(getContext().getResources().getColor(R.color.white));
            this.btnNegative.setTextColor(getContext().getResources().getColor(R.color.white));
            return;
        }
        if (3 == mDialogType) {
            this.clContent.setBackgroundColor(getContext().getResources().getColor(R.color.green_toogle_button));
        } else if (5 == mDialogType) {
            this.clContent.setBackgroundColor(getContext().getResources().getColor(R.color.orange_toogle_button));
        }
    }

    private void resizeDialog() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (int) (DisplayUtil.getScreenSize(getContext()).x * 0.7d);
        getWindow().setAttributes(attributes);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        startWithAnimation(this.mIsShowAnim);
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        dismissWithAnimation(this.mIsShowAnim);
    }

    private void startWithAnimation(boolean showInAnimation) {
        if (showInAnimation) {
            this.mDialogView.startAnimation(this.mAnimIn);
        }
    }

    private void dismissWithAnimation(boolean showOutAnimation) {
        if (showOutAnimation) {
            this.mDialogView.startAnimation(this.mAnimOut);
        } else {
            super.dismiss();
        }
    }

    /* renamed from: com.iecisa.ctausuario.utils.dialog.BaseOptionsDialog$1, reason: invalid class name */
    class AnonymousClass1 implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAnimationEnd$0() {
            BaseOptionsDialog.this.callDismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BaseOptionsDialog.this.mDialogView.post(new Runnable() { // from class: com.iecisa.ctausuario.utils.dialog.BaseOptionsDialog$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAnimationEnd$0();
                }
            });
        }
    }

    private void initAnimListener() {
        this.mAnimOut.setAnimationListener(new AnonymousClass1());
    }

    private void initListener() {
        this.btnPositive.setOnClickListener(new View.OnClickListener() { // from class: com.iecisa.ctausuario.utils.dialog.BaseOptionsDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initListener$0(view);
            }
        });
        this.btnNegative.setOnClickListener(new View.OnClickListener() { // from class: com.iecisa.ctausuario.utils.dialog.BaseOptionsDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initListener$1(view);
            }
        });
        initAnimListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListener$0(View view) {
        onClickCommentsDialog onclickcommentsdialog = this.onClickListener;
        if (onclickcommentsdialog != null) {
            onclickcommentsdialog.onClickPositive(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListener$1(View view) {
        onClickCommentsDialogNegative onclickcommentsdialognegative = this.onClickListenerNegative;
        if (onclickcommentsdialognegative != null) {
            onclickcommentsdialognegative.onClickNegative(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callDismiss() {
        super.dismiss();
    }

    public BaseOptionsDialog setAnimationEnable(boolean enable) {
        this.mIsShowAnim = enable;
        return this;
    }

    public BaseOptionsDialog setTitleText(CharSequence title) {
        this.mTitle = title;
        return this;
    }

    public BaseOptionsDialog setTitleText(int resId) {
        return setTitleText(getContext().getString(resId));
    }

    public BaseOptionsDialog setContentText(CharSequence content) {
        this.mContent = content;
        return this;
    }

    public BaseOptionsDialog setDialogType(int type) {
        this.mDialogType = type;
        return this;
    }

    public BaseOptionsDialog setPositiveListener(CharSequence btnText, onClickCommentsDialog l) {
        this.mBtnText = btnText;
        return setPositiveListener(l);
    }

    public BaseOptionsDialog setPositiveListener(onClickCommentsDialog l) {
        this.onClickListener = l;
        return this;
    }

    public BaseOptionsDialog setNegativeListener(CharSequence btnText, onClickCommentsDialogNegative l) {
        this.mBtnTextNegative = btnText;
        return setNegativeListener(l);
    }

    public BaseOptionsDialog setNegativeListener(onClickCommentsDialogNegative l) {
        this.onClickListenerNegative = l;
        return this;
    }
}
