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

import com.upwards.uidemo.Utils.Utils;
import com.upwards.uidemo.databinding.ActivityViewDemoBinding;

public class ViewDemoActivity extends AppCompatActivity {

    ActivityViewDemoBinding binding;

    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        number = 0;

        if(savedInstanceState != null){
            number = Integer.parseInt(savedInstanceState.getString("COUNT"));
            binding.textView.setText(String.valueOf(number));
        }

        Utils.showToast("Toast called from Utils");

        binding.counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increamentCount();
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void increamentCount() {
        number = number + 1;
        binding.textView.setText(String.valueOf(number));
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("COUNT",binding.textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    private void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

}