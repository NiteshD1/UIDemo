package com.upwards.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.upwards.uidemo.databinding.ActivityViewDemoBinding;

import java.util.ArrayList;

public class ViewDemoActivity extends AppCompatActivity {

    ActivityViewDemoBinding binding;
    StringBuilder checkedString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupToggleButton();
        setupSwitch();

    }

    private void setupSwitch() {

        binding.switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(binding.switchButton.isChecked()){
                    showToast("Wifi is ON");
                }else{
                    showToast("Wifi is OFF");
                }
            }
        });
    }

    private void setupToggleButton() {
        binding.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(binding.toggleButton.isChecked()){
                    showToast("Toggle Button Checked");
                }else {
                    showToast("Toggle Button Unchecked");
                }
            }
        });
    }


    private void showToast(String s) {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();
    }

}