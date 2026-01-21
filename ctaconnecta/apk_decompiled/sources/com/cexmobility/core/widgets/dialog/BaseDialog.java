package com.cexmobility.core.widgets.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cexmobility.core.R;

/* loaded from: classes.dex */
public class BaseDialog extends Dialog {
    private static final int DEFAULT_RADIUS = 6;
    public static final int DIALOG_TYPE_DEFAULT = 0;
    public static final int DIALOG_TYPE_HELP = 1;
    public static final int DIALOG_TYPE_INFO = 0;
    public static final int DIALOG_TYPE_SUCCESS = 3;
    public static final int DIALOG_TYPE_WARNING = 4;
    public static final int DIALOG_TYPE_WARNING_VERSION = 5;
    public static final int DIALOG_TYPE_WRONG = 2;
    private TextView btnPositive;
    private LinearLayout llTop;
    private ImageView logoIv;
    private AnimationSet mAnimIn;
    private AnimationSet mAnimOut;
    private CharSequence mBtnText;
    private CharSequence mContent;
    private int mDialogType;
    private View mDialogView;
    private boolean mIsShowAnim;
    private CharSequence mTitle;
    private onClickCommentsDialog onClickListener;
    private TextView tvContent;
    private TextView tvTitle;

    public interface onClickCommentsDialog {
        void onClickPositive(BaseDialog dialog);
    }

    public BaseDialog(Context context) {
        this(context, 0);
    }

    public BaseDialog(Context context, int theme) {
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
        View viewInflate = View.inflate(getContext(), R.layout.dialog_color, null);
        setContentView(viewInflate);
        resizeDialog();
        this.mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tvTitle);
        this.tvTitle = textView;
        textView.setText(getTitleDialog(this.mDialogType));
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tvContent);
        this.tvContent = textView2;
        textView2.setText(this.mContent);
        this.btnPositive = (TextView) viewInflate.findViewById(R.id.btnPositive);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.logoIv);
        this.logoIv = imageView;
        imageView.setImageResource(getLogoResId(this.mDialogType));
        this.llTop = (LinearLayout) findViewById(R.id.llTop);
        float fDp2px = DisplayUtil.dp2px(getContext(), 3.0f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{fDp2px, fDp2px, fDp2px, fDp2px, 0.0f, 0.0f, 0.0f, 0.0f}, null, null));
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.getPaint().setColor(getContext().getResources().getColor(getColorResId(this.mDialogType)));
        this.llTop.setBackgroundDrawable(shapeDrawable);
        setButtonBackground(this.btnPositive);
    }

    private int getColorResId(int mDialogType) {
        if (mDialogType == 0) {
            return R.color.color_type_info;
        }
        if (mDialogType == 0) {
            return R.color.color_type_info;
        }
        if (1 == mDialogType) {
            return R.color.color_type_help;
        }
        if (2 == mDialogType) {
            return R.color.color_type_wrong;
        }
        if (3 == mDialogType) {
            return R.color.color_type_success;
        }
        if (5 == mDialogType) {
            return R.color.color_type_warning_version;
        }
        return 4 == mDialogType ? R.color.color_type_warning : R.color.color_type_info;
    }

    private int getLogoResId(int mDialogType) {
        if (mDialogType == 0) {
            return R.drawable.ic_info;
        }
        if (mDialogType == 0) {
            return R.drawable.ic_info;
        }
        if (1 == mDialogType) {
            return R.drawable.ic_help;
        }
        if (2 == mDialogType) {
            return R.drawable.ic_close_error;
        }
        if (3 == mDialogType) {
            return R.drawable.ic_success;
        }
        if (5 == mDialogType) {
            return R.drawable.ic_info;
        }
        return 4 == mDialogType ? R.drawable.ic_warning : R.drawable.ic_info;
    }

    private int getTitleDialog(int mDialogType) {
        if (mDialogType == 0) {
            return R.string.info;
        }
        if (mDialogType == 0) {
            return R.string.info;
        }
        if (1 == mDialogType) {
            return R.string.help;
        }
        if (2 == mDialogType) {
            return R.string.error;
        }
        if (3 == mDialogType) {
            return R.string.success;
        }
        if (5 == mDialogType) {
            return R.string.warning_version;
        }
        return 4 == mDialogType ? R.string.warning : R.string.info;
    }

    private int getButtonShape(int mDialogType) {
        if (mDialogType == 0) {
            return R.drawable.shape_button_info;
        }
        if (mDialogType == 0) {
            return R.drawable.shape_button_info;
        }
        if (1 == mDialogType) {
            return R.drawable.shape_button_help;
        }
        if (2 == mDialogType) {
            return R.drawable.shape_button_error;
        }
        if (3 == mDialogType) {
            return R.string.success;
        }
        if (5 == mDialogType) {
            return R.drawable.shape_button_error;
        }
        return 4 == mDialogType ? R.drawable.shape_button_warning : R.drawable.shape_button_info;
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

    private void initAnimListener() {
        this.mAnimOut.setAnimationListener(new Animation.AnimationListener() { // from class: com.cexmobility.core.widgets.dialog.BaseDialog.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BaseDialog.this.mDialogView.post(new Runnable() { // from class: com.cexmobility.core.widgets.dialog.BaseDialog.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseDialog.this.callDismiss();
                    }
                });
            }
        });
    }

    private void initListener() {
        this.btnPositive.setOnClickListener(new View.OnClickListener() { // from class: com.cexmobility.core.widgets.dialog.BaseDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initListener$0(view);
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
    public void callDismiss() {
        super.dismiss();
    }

    private void setButtonBackground(TextView btnPositive) {
        btnPositive.setTextColor(getContext().getResources().getColor(getColorResId(this.mDialogType)));
        btnPositive.setBackgroundDrawable(getContext().getResources().getDrawable(getButtonShape(this.mDialogType)));
    }

    public BaseDialog setAnimationEnable(boolean enable) {
        this.mIsShowAnim = enable;
        return this;
    }

    public BaseDialog setTitleText(CharSequence title) {
        this.mTitle = title;
        return this;
    }

    public BaseDialog setTitleText(int resId) {
        return setTitleText(getContext().getString(resId));
    }

    public BaseDialog setContentText(CharSequence content) {
        this.mContent = content;
        return this;
    }

    public BaseDialog setContentText(int resId) {
        return setContentText(getContext().getString(resId));
    }

    public TextView getTitleTextView() {
        return this.tvTitle;
    }

    public BaseDialog setDialogType(int type) {
        this.mDialogType = type;
        return this;
    }

    public int getDialogType() {
        return this.mDialogType;
    }

    public BaseDialog setPositiveListener(CharSequence btnText, onClickCommentsDialog l) {
        this.mBtnText = btnText;
        return setPositiveListener(l);
    }

    public BaseDialog setPositiveListener(int stringResId, onClickCommentsDialog l) {
        return setPositiveListener(getContext().getString(stringResId), l);
    }

    public BaseDialog setPositiveListener(onClickCommentsDialog l) {
        this.onClickListener = l;
        return this;
    }
}
