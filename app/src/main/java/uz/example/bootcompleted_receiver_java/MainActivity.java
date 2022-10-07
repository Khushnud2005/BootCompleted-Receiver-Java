package uz.example.bootcompleted_receiver_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BootCompleteReceiver receiver_boot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    void initViews(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.RECEIVE_BOOT_COMPLETED) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.RECEIVE_BOOT_COMPLETED},1000);
        }

       // receiver_boot = new BootCompleteReceiver();
    }
    @Override
    protected void onStart() {
        super.onStart();
/*
        IntentFilter boot_filter = new IntentFilter();
        boot_filter.addAction("android.intent.action.BOOT_COMPLETED");
        boot_filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        registerReceiver(receiver_boot, boot_filter);

        Intent intent = new Intent(this,BootCompleteReceiver.class);
        sendBroadcast(intent);*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // unregisterReceiver(receiver_boot);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "BootCompleted Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "BootCompleted Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}