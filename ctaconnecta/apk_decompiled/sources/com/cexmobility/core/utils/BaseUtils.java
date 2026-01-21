package com.cexmobility.core.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;
import com.cexmobility.core.R;

/* loaded from: classes.dex */
public class BaseUtils {
    public static ProgressDialog showLoadingDialog(Context context, int message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        if (message != 0) {
            ((TextView) progressDialog.findViewById(R.id.msg_loading)).setText(message);
        }
        return progressDialog;
    }
}
