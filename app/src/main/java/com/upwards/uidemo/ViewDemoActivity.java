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

public class ViewDemoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ActivityViewDemoBinding binding;
    String[] countryArray = {"India", "USA", "China", "America","Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Increase Color Scheme Font

        setupSpinner();
        setupProgressBar();
        setupSeekBar();
        setuRatingBar();

    }

    private void setuRatingBar() {
        binding.showRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Current Rating is " + binding.ratingBar.getRating());
            }
        });
    }

    private void setupSeekBar() {

        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                showToast("Current Progress is " + i);
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
                showToast("Current Progress is " + i);
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
                if(binding.progressBar2.getProgress() <= 95){
                    binding.progressBar2.setProgress(binding.progressBar2.getProgress() + 5);
                    showToast("Current Progress is " + String.valueOf( binding.progressBar2.getProgress() + 5));
                }
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
        showToast(countryArray[i] + " is Selected");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //showToast("Nothing is Selected");
    }
}