package com.iecisa.ctausuario.ui.main;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.cexmobility.core.enums.ToolbarActions;
import com.cexmobility.core.ui.BaseActivity;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public abstract class CustomToolbarActivity extends BaseActivity {
    private TextView toolbarSubtitle;
    private TextView toolbarTitle;

    protected void setToolbarWithSubtitle(Toolbar toolbar, ToolbarActions toolbarAction, String title, String subtitle) {
        this.toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        this.toolbarSubtitle = (TextView) findViewById(R.id.toolbar_subtitle);
        setupActionBar(toolbar, toolbarAction);
        if (TextUtils.isEmpty(title)) {
            return;
        }
        setToolbarTitle(title, subtitle);
    }

    protected void setToolbar(Toolbar toolbar, ToolbarActions toolbarAction, String title) {
        this.toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        TextView textView = (TextView) findViewById(R.id.toolbar_subtitle);
        this.toolbarSubtitle = textView;
        textView.setVisibility(8);
        if (!toolbarAction.equals(ToolbarActions.NONE)) {
            setupActionBar(toolbar, toolbarAction);
        }
        if (TextUtils.isEmpty(title)) {
            return;
        }
        setToolbarTitle(title);
    }

    private void setupActionBar(Toolbar toolbar, ToolbarActions toolbarAction) {
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
            int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$enums$ToolbarActions[toolbarAction.ordinal()];
            if (i == 1) {
                setActionBar(supportActionBar, R.drawable.ic_arrowleft);
            } else if (i == 2) {
                setActionBar(supportActionBar, 2131231021);
            } else {
                if (i != 3) {
                    return;
                }
                setActionBar(supportActionBar, R.drawable.ic_close_error);
            }
        }
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.CustomToolbarActivity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$cexmobility$core$enums$ToolbarActions;

        static {
            int[] iArr = new int[ToolbarActions.values().length];
            $SwitchMap$com$cexmobility$core$enums$ToolbarActions = iArr;
            try {
                iArr[ToolbarActions.BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$cexmobility$core$enums$ToolbarActions[ToolbarActions.MENU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$cexmobility$core$enums$ToolbarActions[ToolbarActions.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void setActionBar(ActionBar actionBar, int resource) {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(resource);
    }

    protected void setToolbarTitle(String title, String subtitle) {
        this.toolbarTitle.setText(title);
        this.toolbarSubtitle.setText(subtitle);
        this.toolbarTitle.setMaxLines(1);
        this.toolbarSubtitle.setVisibility(0);
    }

    protected void setToolbarSubtitle(String subtitle) {
        this.toolbarSubtitle.setText(subtitle);
        this.toolbarSubtitle.setVisibility(0);
    }

    protected void setToolbarTitle(String title) {
        this.toolbarTitle.setText(title);
    }
}
