package com.upwards.uidemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("onCreate Main Activity Activity");

//        Bundle bundle = new Bundle();
//        bundle.putString("NAME","Ram");
//        name = bundle.getString("NAME");
    }
    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart Main Activity Activity");

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        showToast("onRestoreInstanceState Main Activity Activity");

    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("onResume Main Activity Activity");

    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("onPause Main Activity Activity");

    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop Main Activity Activity");

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        showToast("onSaveInstanceState Main Activity Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy Main Activity Activity");

    }
    
    private void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

}