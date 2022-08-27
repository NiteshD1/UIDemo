package com.upwards.uidemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.upwards.uidemo.databinding.ActivityViewDemoBinding;

public class ViewDemoActivity extends AppCompatActivity{

    ActivityViewDemoBinding binding;
    StringBuilder checkedString;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Increase Color Scheme Font
        setupDatePicker();
        setupTimePicker();
        setupFloatingActionButton();

    }

    private void setupFloatingActionButton() {
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Floating Action Button Clicked");
            }
        });
    }

    private void setupTimePicker() {
        binding.timePicker.setIs24HourView(false);
        binding.showTimeButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                showSelectedTime();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void showSelectedTime() {
        StringBuilder timeString = new StringBuilder("Selected Time is : ");

        timeString.append("Hour : " + binding.timePicker.getHour());
        timeString.append(" Minute : " + binding.timePicker.getMinute());
        showToast(timeString.toString());

    }

    private void setupDatePicker() {
        binding.showDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSelectedDate();
            }
        });
    }

    private void showSelectedDate() {
        StringBuilder dateString = new StringBuilder("Selected Date is : ");

        dateString.append("Year : " + binding.datePicker.getYear());
        dateString.append(" Month : " + binding.datePicker.getMonth());
        dateString.append(" Day of Month: " +binding.datePicker.getDayOfMonth());
        showToast(dateString.toString());

    }


    private void showToast(String s) {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
    }


}