package com.upwards.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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


        setupCheckBox();

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedString = new StringBuilder("Selected Languages are");
                setupCheckBox();

                showToast(checkedString.toString());

            }
        });
    }

    private void setupCheckBox() {

        if(binding.checkBoxC.isChecked()) checkedString.append("\n C++");
        if(binding.checkBoxJava.isChecked()) checkedString.append("\n JAVA");
        if(binding.checkBoxPython.isChecked()) checkedString.append("\n Python");

    }


    private void showToast(String s) {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();
    }

}