package com.trianglz.bridgecrestdesign.UI;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.trianglz.bridgecrestdesign.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SleepTracking extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    Typeface tf;
    TextView timeAsleeptxt, sleepScheduletxt, dateTextView, sleepPatterntxt, asleeptxt, restlesstxt, awaketxt;
    String selectedDate;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleep_tracking_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tf = Typeface.createFromAsset(this.getAssets(), "fonts/OpenSans-Light.ttf");

        timeAsleeptxt = (TextView) findViewById(R.id.sleepTimeHeader);
        timeAsleeptxt.setTypeface(tf);

        sleepScheduletxt = (TextView) findViewById(R.id.sleepScheduleHeader);
        sleepScheduletxt.setTypeface(tf);

        dateTextView = (TextView) findViewById(R.id.date_textview);
        dateTextView.setTypeface(tf);

        sleepPatterntxt = (TextView) findViewById(R.id.sleepPatternTXT);
        sleepPatterntxt.setTypeface(tf);

        asleeptxt = (TextView) findViewById(R.id.asleepTXT);
        asleeptxt.setTypeface(tf);

        restlesstxt = (TextView) findViewById(R.id.restlessTXT);
        restlesstxt.setTypeface(tf);

        awaketxt = (TextView) findViewById(R.id.awakeTXT);
        awaketxt.setTypeface(tf);


        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(date);
        dateTextView.setText(dateString);

        dateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        SleepTracking.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
                dpd.vibrate(false);
                dpd.setThemeDark(true);
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            selectedDate = extras.getString("date");
            dateTextView.setText(selectedDate);
        }

        back = (ImageView) findViewById(R.id.backBTN);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        DatePickerDialog dpd = (DatePickerDialog) getFragmentManager().findFragmentByTag("Datepickerdialog");
        if (dpd != null) dpd.setOnDateSetListener(this);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth + "/" + (++monthOfYear) + "/" + year;
        dateTextView.setText(date);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
