package com.mohamadian.persianjodatimeexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.PersianChronology;
import org.joda.time.chrono.PersianChronologyKhayyam;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private PersianChronology perChr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        perChr = PersianChronologyKhayyam.getInstance(DateTimeZone.forID("Asia/Tehran"));
        DateTime now = new DateTime(perChr);

        textView = (TextView) findViewById(R.id.text_view);
        textView.setText("Today is : "+ Integer.toString(now.getYear())+"/"+ Integer.toString(now.getMonthOfYear())+"/"+ Integer.toString(now.getDayOfMonth()));

        findViewById(R.id.next_month).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateTime dt = new DateTime(perChr).plusMonths(1);
                textView.setText("Next month : "+ Integer.toString(dt.getYear())+"/"+ Integer.toString(dt.getMonthOfYear())+"/"+ Integer.toString(dt.getDayOfMonth()));
            }
        });

        findViewById(R.id.specific_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateTime dt = new DateTime(1398, 12, 25, 0, 0, perChr);
                textView.setText("Specific date : "+ Integer.toString(dt.getYear())+"/"+ Integer.toString(dt.getMonthOfYear())+"/"+ Integer.toString(dt.getDayOfMonth()));
            }
        });
    }
}
