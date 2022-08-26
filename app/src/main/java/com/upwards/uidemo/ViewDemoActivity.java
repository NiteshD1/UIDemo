package com.upwards.uidemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.upwards.uidemo.databinding.ActivityViewDemoBinding;

import java.util.ArrayList;

public class ViewDemoActivity extends AppCompatActivity implements TimePicker.OnTimeChangedListener {

    ActivityViewDemoBinding binding;
    StringBuilder checkedString;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Increase Color Scheme Font
        setupTimePicker();
        setupDatePicker();
        setupFloatingActionButton();

    }

    private void setupFloatingActionButton() {
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Floating Button Clicked");
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setupDatePicker() {
        binding.buttonShowDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSelectedDate();
            }
        });
    }

    private void showSelectedDate() {
        StringBuilder dateString = new StringBuilder("Selected Date is : ");
        dateString.append("Year : " + String.valueOf(binding.datePicker.getYear()));
        dateString.append(" Month : " + String.valueOf(binding.datePicker.getMonth()));
        dateString.append(" Day : " + String.valueOf(binding.datePicker.getDayOfMonth()));

        showToast(dateString.toString());
    }

    private void setupTimePicker() {
        binding.timePicker.setIs24HourView(true);
        binding.timePicker.setOnTimeChangedListener(this);
//        binding.timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
//                StringBuilder timeString = new StringBuilder("Selected time is : ");
//                timeString.append("Hour : " + String.valueOf(timePicker.getHour()));
//                timeString.append(" Minute : " + String.valueOf(timePicker.getMinute()));
//                showToast(timeString.toString());
//            }
//        });

    }


    private void showToast(String s) {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onTimeChanged(TimePicker timePicker, int i, int i1) {
        StringBuilder timeString = new StringBuilder("Selected time is : ");
        timeString.append("Hour : " + String.valueOf(timePicker.getHour()));
        timeString.append(" Minute : " + String.valueOf(timePicker.getMinute()));
        showToast(timeString.toString());
    }
}