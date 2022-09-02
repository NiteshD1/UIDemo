package com.upwards.uidemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.MediaController;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.upwards.uidemo.databinding.ActivityViewDemoBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ViewDemoActivity extends AppCompatActivity{

    ActivityViewDemoBinding binding;
    String[] countryArray = {"India", "Iran","USA", "China", "Australia","Other"};
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Increase Color Scheme Font

        setupAutocompleteTextView();

    }

    private void setupAutocompleteTextView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item,countryArray);
        binding.autoCompleteTextView.setAdapter(adapter);
        binding.autoCompleteTextView.setThreshold(1);
    }

    private void showToast(String s) {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
    }

}