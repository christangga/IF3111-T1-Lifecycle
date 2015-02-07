package com.christangga.p3_broadcastreceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AlarmActivity extends ActionBarActivity {

    private EditText editText;
    private Button buttonGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        editText = (EditText) findViewById(R.id.editText);

        buttonGo = (Button) findViewById(R.id.buttonGo);
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please input a number",
                            Toast.LENGTH_SHORT).show();
                } else {
                    int i = Integer.parseInt(editText.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), MyBroadcastReceiver.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 234324243, intent, 0);
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                            + (i * 1000), pendingIntent);
                    Toast.makeText(getApplicationContext(), "Alarm set in " + i + " seconds",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
