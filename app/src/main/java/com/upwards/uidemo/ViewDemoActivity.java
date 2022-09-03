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

        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = binding.editTextUserName.getText().toString();
                String password = binding.editTextPassword.getText().toString();

                if(userName != null && password != null && userName.length()>0 && password.length()>0){
                    showToast("User Signed In");
                }else {
                    showToast("Please Enter Details First!");
                }
            }
        });

        binding.clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editTextUserName.setText("");
                binding.editTextPassword.setText("");
            }
        });
    }

    private void showToast(String s) {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();
    }

}