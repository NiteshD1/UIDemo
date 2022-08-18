package com.upwards.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.upwards.uidemo.databinding.ActivityViewDemoBinding;

import java.util.ArrayList;

public class ViewDemoActivity extends AppCompatActivity {

    ActivityViewDemoBinding binding;
    String checkedString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedString = "";
                setupCheckBox();

                if(checkedString.isEmpty()){
                    showToast("Nothing is selected");
                }else {
                    showToast(checkedString);
                }
            }
        });

    }

    private void setupCheckBox() {

        if(binding.checkBox1.isChecked()) checkedString = checkedString.concat("C++ Checked ");
        if(binding.checkBox2.isChecked()) checkedString = checkedString.concat("JAVA Checked ");
        if(binding.checkBox3.isChecked()) checkedString = checkedString.concat("Python Checked");

    }

    private void showToast(String s) {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();
    }

}