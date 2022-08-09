package com.upwards.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import com.upwards.uidemo.databinding.ActivityMainBinding;
import com.upwards.uidemo.databinding.ActivityTestBinding;

public class TestActivity extends AppCompatActivity {

    ActivityTestBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                showToast("seekbar touch stopped!");
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast(String.valueOf(binding.ratingBar.getRating()));
            }
        });
    }

    private void showToast(String s) {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();
    }




}