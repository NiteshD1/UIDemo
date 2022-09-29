package com.upwards.uidemo;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
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
        binding.moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveAnimation();
            }
        });

        binding.fadeOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fadeOutAnimation();
            }
        });

        binding.fadeInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fadeInAnimation();
            }
        });

        binding.rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateAnimation();
            }
        });

        binding.zoomInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomInAnimation();
            }
        });

        binding.zoomOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomOutAnimation();
            }
        });
    }

    private void zoomOutAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.zoom_out_animation);
        binding.imageViewBike.startAnimation(animation);
    }

    private void zoomInAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.zoom_in_animation);
        binding.imageViewBike.startAnimation(animation);
    }

    private void rotateAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotate_animation);
        binding.imageViewBike.startAnimation(animation);
    }

    private void fadeInAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.fade_in_animation);
        binding.imageViewBike.startAnimation(animation);
    }

    private void fadeOutAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.fade_out_animation);
        binding.imageViewBike.startAnimation(animation);
    }

    private void moveAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.move_animation);
        binding.imageViewBike.startAnimation(animation);
    }


    private void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

}