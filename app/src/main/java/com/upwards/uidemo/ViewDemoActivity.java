package com.upwards.uidemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.upwards.uidemo.databinding.ActivityViewDemoBinding;

public class ViewDemoActivity extends AppCompatActivity {

    ActivityViewDemoBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewDemoActivity.this,MainActivity.class));
            }
        });
        showToast("onCreate Demo Activity");
    }


    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart Demo Activity");

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        showToast("onRestoreInstanceState Demo Activity");

    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("onResume Demo Activity");

    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("onPause Demo Activity");

    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop Demo Activity");

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        showToast("onSaveInstanceState Demo Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy Demo Activity");

    }

    private void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Add New Task")
                .setMessage("Would you like to add new Task?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showToast("New Task added successfully!");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showToast("New task is not added!");
                    }
                })
                .create()
                .show();
    }

    private void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

}