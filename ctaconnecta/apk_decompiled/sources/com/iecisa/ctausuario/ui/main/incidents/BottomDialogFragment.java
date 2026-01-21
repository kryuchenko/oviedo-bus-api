package com.iecisa.ctausuario.ui.main.incidents;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.utils.BaseUtils;

/* loaded from: classes5.dex */
public class BottomDialogFragment extends BottomSheetDialogFragment {
    public static final String TAG = "BottomDialogFragment";
    private static BaseUtils.onDialogListener listener;

    public static BottomDialogFragment newInstance(BaseUtils.onDialogListener onDialogListener) {
        BottomDialogFragment bottomDialogFragment = new BottomDialogFragment();
        listener = onDialogListener;
        return bottomDialogFragment;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) throws NoSuchMethodException, SecurityException {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), getTheme());
        final View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_dialog, (ViewGroup) null, false);
        bottomSheetDialog.setContentView(viewInflate);
        ButterKnife.bind(this, viewInflate);
        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.BottomDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                BottomDialogFragment.lambda$onCreateDialog$1(viewInflate, dialogInterface);
            }
        });
        return bottomSheetDialog;
    }

    static /* synthetic */ void lambda$onCreateDialog$1(View view, DialogInterface dialogInterface) {
        BottomSheetBehavior<FrameLayout> behavior = ((BottomSheetDialog) dialogInterface).getBehavior();
        behavior.setFitToContents(true);
        behavior.setState(3);
        ViewCompat.setOnApplyWindowInsetsListener((View) view.getParent(), new OnApplyWindowInsetsListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.BottomDialogFragment$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return BottomDialogFragment.lambda$onCreateDialog$0(view2, windowInsetsCompat);
            }
        });
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreateDialog$0(View view, WindowInsetsCompat windowInsetsCompat) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
        return windowInsetsCompat;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((BottomSheetDialog) getDialog()).getBehavior().setSkipCollapsed(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        new WindowInsetsControllerCompat(requireDialog().getWindow(), requireDialog().getWindow().getDecorView()).setAppearanceLightStatusBars(true);
    }

    @OnClick({R.id.mbCamera, R.id.mbGallery})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.mbCamera) {
            listener.onClickPositive();
        } else if (id == R.id.mbGallery) {
            listener.onClickNegative();
        }
        dismiss();
    }
}
