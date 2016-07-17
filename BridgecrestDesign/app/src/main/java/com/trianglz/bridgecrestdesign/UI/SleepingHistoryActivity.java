package com.trianglz.bridgecrestdesign.UI;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.trianglz.bridgecrestdesign.R;
import com.trianglz.bridgecrestdesign.model.SortableTable.Sleep;
import com.trianglz.bridgecrestdesign.model.SortableTable.SleepTableDataAdapter;
import com.trianglz.bridgecrestdesign.model.SortableTable.SleepingData;
import com.trianglz.bridgecrestdesign.model.SortableTable.SortableSleepTableView;

import de.codecrafters.tableview.listeners.TableDataClickListener;

public class SleepingHistoryActivity extends AppCompatActivity {
    TextView app_name, date_from_to, rotate;
    Typeface tf, tf1;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleep_history_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final SortableSleepTableView sleepTableView = (SortableSleepTableView) findViewById(R.id.tableView);
        if (sleepTableView != null) {
            sleepTableView.setDataAdapter(new SleepTableDataAdapter(this, SleepingData.createSleepingList()));
            sleepTableView.addDataClickListener(new sleepClickListener());
        }
        app_name = (TextView) findViewById(R.id.app_name);
        date_from_to = (TextView) findViewById(R.id.dateFromTo);
        rotate = (TextView) findViewById(R.id.rotateDevice);
        tf = Typeface.createFromAsset(this.getAssets(), "fonts/OpenSans-Light.ttf");
        tf1 = Typeface.createFromAsset(this.getAssets(), "fonts/Comfortaa-Light.ttf");
        app_name.setTypeface(tf);
        date_from_to.setTypeface(tf1);
        rotate.setTypeface(tf1);
        back = (ImageView) findViewById(R.id.backBTN);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private class sleepClickListener implements TableDataClickListener<Sleep> {

        @Override
        public void onDataClicked(final int rowIndex, final Sleep clickedData) {
            final String dateString = clickedData.getDay();
            Intent sleepTrackingIntent = new Intent(SleepingHistoryActivity.this, SleepTracking.class);
            sleepTrackingIntent.putExtra("date", dateString);
            startActivity(sleepTrackingIntent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
