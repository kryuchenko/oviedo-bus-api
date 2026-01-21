package com.cexmobility.core.ui;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.cexmobility.core.R;
import com.cexmobility.core.enums.ToolbarActions;

/* loaded from: classes.dex */
public abstract class ToolbarActivity extends BaseActivity {
    private Toolbar toolbar;
    private TextView toolbarTitle;

    @Override // com.cexmobility.core.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setToolbar(ToolbarActions toolbarAction, int title) {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        if (!toolbarAction.equals(ToolbarActions.NONE)) {
            setSupportActionBar(this.toolbar);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayShowTitleEnabled(false);
                int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$enums$ToolbarActions[toolbarAction.ordinal()];
                if (i == 1) {
                    supportActionBar.setDisplayHomeAsUpEnabled(true);
                } else if (i == 2) {
                    supportActionBar.setDisplayHomeAsUpEnabled(true);
                    supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white);
                } else if (i == 3) {
                    supportActionBar.setDisplayHomeAsUpEnabled(true);
                    supportActionBar.setHomeAsUpIndicator(R.drawable.ic_close_error);
                }
            }
        }
        if (title != 0) {
            setToolbarTitle(getString(title));
        }
    }

    /* renamed from: com.cexmobility.core.ui.ToolbarActivity$1, reason: invalid class name */
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

    protected void setToolbarTitle(String title) {
        this.toolbarTitle.setText(title);
    }
}
