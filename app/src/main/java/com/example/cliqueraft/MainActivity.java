package com.example.cliqueraft;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    Button b1,b2,b3,b4;
    TextView tv;
    public  static String s;

    public static final String NOTIFICATION_ID = "NOTIFICATION_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.ed1);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        tv=findViewById(R.id.tv);

        String Ed = ed1.getText().toString().trim();
        if (TextUtils.isEmpty(Ed))
        {
            Toast.makeText(getApplicationContext(), "please enter the required fields", Toast.LENGTH_LONG).show();
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Ed = ed1.getText().toString().trim();
                if (TextUtils.isEmpty(Ed))
                {
                    Toast.makeText(getApplicationContext(), "please enter the required fields", Toast.LENGTH_LONG).show();
                }
                else {
                    Ed = ed1.getText().toString().trim();
                    tv.setText(Ed);

                    Toast.makeText(getApplicationContext(), "Your text is: "+Ed, Toast.LENGTH_LONG).show();
                }
            }
        });
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My notifiction", "this is the notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        b2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                 String Ed = ed1.getText().toString().trim();
                tv.setText(Ed);

                NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(MainActivity.this, "My notifiction")
                        .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                        .setContentTitle("Yout Text is:")
                        .setContentText(Ed);

                Intent k = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent p = PendingIntent.getActivity(MainActivity.this, 0, k, 0);

                mbuilder.setContentIntent(p);

                int Notifid = 001;
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                // this block of code will display the notification in the notification area
                notificationManager.notify(Notifid, mbuilder.build());
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s=ed1.getText().toString().trim();
                String Ed = ed1.getText().toString().trim();
                if (TextUtils.isEmpty(Ed))
                {
                    Toast.makeText(getApplicationContext(), "please enter the required fields", Toast.LENGTH_LONG).show();
                }
                else {
                    Ed = ed1.getText().toString().trim();
                    tv.setText(Ed);

                    dialogex d = new dialogex();
                    d.show(getSupportFragmentManager(), "example dialog");
                }
                dialogex d = new dialogex();
                d.show(getSupportFragmentManager(), "example dialog");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    tv.setText("completed");
                }




        });

    }
}