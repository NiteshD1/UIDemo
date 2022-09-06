package com.upwards.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.upwards.uidemo.databinding.ActivityViewDemoBinding;

import java.util.ArrayList;
import java.util.Objects;

public class ViewDemoActivity extends AppCompatActivity {

    ActivityViewDemoBinding binding;
    StringBuilder checkedString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

    }

    private void showToast(String s) {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();
    }

}