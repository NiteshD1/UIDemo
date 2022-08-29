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
    String[] countryArray = {"India", "USA", "China", "Australia","Other"};
    ArrayAdapter<String > adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Increase Color Scheme Font

        setupVideoView();
        setupSearchView();

    }

    private void setupSearchView() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,countryArray);
        binding.listView.setAdapter(adapter);

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(Arrays.asList(countryArray).contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    showToast("No match found");
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);

                return false;
            }
        });

    }

    private void setupVideoView() {

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(binding.videoView);

        String uriString="android.resource://"+getPackageName()+"/"+R.raw.demo_video;

        binding.videoView.setMediaController(mediaController);
        binding.videoView.setVideoURI(Uri.parse(uriString));
        binding.videoView.requestFocus();
        binding.videoView.start();
    }

    private void showToast(String s) {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
    }

}