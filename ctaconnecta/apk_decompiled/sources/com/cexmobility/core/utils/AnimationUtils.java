package com.cexmobility.core.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cexmobility.core.R;

/* loaded from: classes.dex */
public class AnimationUtils {
    public static void animateSlideUp(Context context, ConstraintLayout viewSlide) {
        viewSlide.startAnimation(android.view.animation.AnimationUtils.loadAnimation(context, R.anim.view_slide_up));
        viewSlide.setVisibility(0);
    }

    public static void animateSlideDown(final Context context, final ConstraintLayout viewSlide) throws Resources.NotFoundException {
        if (viewSlide.getVisibility() == 0) {
            Animation animationLoadAnimation = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.view_slide_down);
            viewSlide.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.cexmobility.core.utils.AnimationUtils.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    viewSlide.setVisibility(8);
                }
            });
        }
    }

    public static void circularReveal(View view) {
        int width = view.getWidth();
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, width, 0, 0.0f, (float) Math.hypot(width, 0));
        view.setVisibility(0);
        animatorCreateCircularReveal.start();
    }

    public static void circularHide(final View view) {
        int width = view.getWidth();
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, width, 0, (float) Math.hypot(width, 0), 0.0f);
        animatorCreateCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.cexmobility.core.utils.AnimationUtils.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(4);
            }
        });
        animatorCreateCircularReveal.start();
    }

    public static void vibrateView(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, 1.5f, 0.0f, -1.5f, 0.0f);
        objectAnimatorOfFloat.setDuration(100L);
        objectAnimatorOfFloat.setRepeatCount(1);
        objectAnimatorOfFloat.start();
    }
}
