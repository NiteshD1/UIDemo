package com.upwards.uidemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.upwards.uidemo.databinding.ActivityViewDemoBinding;

public class ViewDemoActivity extends AppCompatActivity {

    ActivityViewDemoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupButtons();
    }

    private void setupButtons() {
        binding.moveValueAnimatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveViaValueAnimator();
            }
        });

        binding.moveObjectAnimatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveViaObjectAnimator();
            }
        });

        binding.animationSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runMultipleAnimation();
            }
        });
    }

    private void runMultipleAnimation() {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(binding.imageViewBike,"translationX",0f,500f);
        anim1.setDuration(1000);

        ObjectAnimator anim2 = ObjectAnimator.ofFloat(binding.imageViewBike,"translationX",500f,250f);
        anim2.setDuration(1000);

        ObjectAnimator anim3 = ObjectAnimator.ofFloat(binding.imageViewBike,"rotation",0,360);
        anim3.setDuration(1000);


        AnimatorSet animatorSet = new AnimatorSet();

        animatorSet.play(anim1);
        animatorSet.play(anim2).after(anim1);
        animatorSet.play(anim3).after(anim2);

        animatorSet.start();
    }

    private void moveViaObjectAnimator() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(binding.imageViewBike,"translationX",0f,500f);
        animator.setDuration(1000);
        animator.start();
    }

    private void moveViaValueAnimator() {
        ValueAnimator animator = ValueAnimator.ofFloat(0f,300f);
        animator.setDuration(1000);
        animator.start();

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float updatedValue = (float) valueAnimator.getAnimatedValue();
                binding.imageViewBike.setTranslationX(updatedValue);
            }
        });

    }


    private void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

}