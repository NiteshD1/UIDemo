package com.upwards.uidemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.upwards.uidemo.databinding.ActivityViewDemoBinding;
import com.upwards.uidemo.models.Person;

import java.util.List;

public class ViewDemoActivity extends AppCompatActivity {

    ActivityViewDemoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupToast();
        setupSnackBar();
        setupDialog();
        setupNotification();
    }

    private void setupNotification() {
        binding.buttonShowNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNotification();
            }
        });
    }

    private void showNotification() {
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_icon_alert)
                .setContentTitle("Alert Notification!")
                .setContentText("This is a Alert Notification!")
                .setAutoCancel(true)
                .setPriority(Notification.PRIORITY_DEFAULT);

        Intent intent = new Intent(this,MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,builder.build());
    }

    private void setupDialog() {
        binding.buttonShowAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Add New Task")
                .setMessage("Would you like to add new Task?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showToast("New Task added successfully!");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showToast("New task is not added!");
                    }
                })
                .create()
                .show();
    }

    private void setupSnackBar() {
        binding.buttonShowSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnackBar();
            }
        });
    }

    private void showSnackBar() {
        Snackbar.make(binding.buttonShowSnackBar,"Show Snackbar is Clicked",Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.show_toast), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showToast("Show Toast From Snackbar is Clicked");
                    }
                })
                .setAnchorView(binding.floatingActionButton)
                .show();
    }

    private void setupToast() {
        binding.buttonShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Show Toast Is Clicked");
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

}