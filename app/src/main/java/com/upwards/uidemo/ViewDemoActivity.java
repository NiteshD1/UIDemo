package com.upwards.uidemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Toast;

import com.upwards.uidemo.databinding.ActivityViewDemoBinding;

public class ViewDemoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ActivityViewDemoBinding binding;
    String[] countryArray = {"India", "USA", "China", "Australia","Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Increase Color Scheme Font

        setupSpinner();
        setupProgressBar();
        setupSeekbar();
        setupRatingBar();

    }

    private void setupRatingBar() {
        binding.buttonShowRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Current Rating is " + binding.ratingBar.getRating());
            }
        });
    }

    private void setupSeekbar() {
        binding.seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                showToast("Current Progress is "+ i );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        binding.seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                showToast("Current Progress is "+ i );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void setupProgressBar() {
        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentProgress = binding.progressBar3.getProgress();

                if(currentProgress <= 95){
                    binding.progressBar3.setProgress(currentProgress + 5);
                }
                showToast("Current Progress is " + String.valueOf(currentProgress + 5) );
            }
        });
    }

    private void setupSpinner() {

        binding.spinner.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,countryArray);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.spinner.setAdapter(arrayAdapter);
    }


    private void showToast(String s) {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
       showToast("Selected Country is " + countryArray[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}