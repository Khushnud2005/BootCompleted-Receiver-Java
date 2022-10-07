package uz.example.bootcompleted_receiver_java;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){
            Toast.makeText(context, "Device restarted", Toast.LENGTH_SHORT).show();

        }
    }
}
