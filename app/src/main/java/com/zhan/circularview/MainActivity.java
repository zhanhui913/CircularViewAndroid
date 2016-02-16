package com.zhan.circularview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.zhan.library.CircularView;

public class MainActivity extends AppCompatActivity {

    private CircularView circularView;

    private SeekBar topSlider, bottomSlider, leftSlider, rightSlider;
    private SeekBar strokeWidthSlider, strokePaddingSlider;
    private SeekBar circleRadiusSlider;

    private TextView topPaddingValue, bottomPaddingValue, leftPaddingValue, rightPaddingValue;
    private TextView strokeWidthValue, strokePaddingValue;
    private TextView circleRadiusValue;

    private ImageButton button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        circularView = (CircularView) findViewById(R.id.circularView);
        circularView.setCircleColor(R.color.green);
        circularView.setIconColor(R.color.purple);
        circularView.setStrokeColor(R.color.gray);

        init();
        addListeners();
    }

    private void init(){
        topPaddingValue = (TextView) findViewById(R.id.topPaddingValue);
        bottomPaddingValue = (TextView) findViewById(R.id.bottomPaddingValue);
        leftPaddingValue = (TextView) findViewById(R.id.leftPaddingValue);
        rightPaddingValue = (TextView) findViewById(R.id.rightPaddingValue);
        strokeWidthValue = (TextView) findViewById(R.id.strokeWidthValue);
        strokePaddingValue = (TextView) findViewById(R.id.strokePaddingValue);
        circleRadiusValue = (TextView) findViewById(R.id.circleRadiusValue);

        topSlider = (SeekBar) findViewById(R.id.topPaddingSlider);
        bottomSlider = (SeekBar) findViewById(R.id.bottomPaddingSlider);
        leftSlider = (SeekBar) findViewById(R.id.leftPaddingSlider);
        rightSlider = (SeekBar) findViewById(R.id.rightPaddingSlider);
        strokeWidthSlider = (SeekBar) findViewById(R.id.strokeWidthSlider);
        strokePaddingSlider = (SeekBar) findViewById(R.id.strokePaddingSlider);
        circleRadiusSlider = (SeekBar) findViewById(R.id.circleRadiusSlider);

        button1 = (ImageButton) findViewById(R.id.iconButton1);
        button2 = (ImageButton) findViewById(R.id.iconButton2);
        button3 = (ImageButton) findViewById(R.id.iconButton3);

        //default icon padding is 10dp
        topSlider.setProgress(10);
        bottomSlider.setProgress(10);
        leftSlider.setProgress(10);
        rightSlider.setProgress(10);
        strokeWidthSlider.setProgress(0);
        strokePaddingSlider.setProgress(0);
        circleRadiusSlider.setProgress(50);

        topPaddingValue.setText("10");
        bottomPaddingValue.setText("10");
        leftPaddingValue.setText("10");
        rightPaddingValue.setText("10");
        strokeWidthValue.setText("0");
        strokePaddingValue.setText("0");
        circleRadiusValue.setText("50");
    }

    private void addListeners(){
        topSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                circularView.setIconTopPaddingInDP(progress);
                topPaddingValue.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        bottomSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                circularView.setIconBottomPaddingInDP(progress);
                bottomPaddingValue.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        leftSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                circularView.setIconLeftPaddingInDP(progress);
                leftPaddingValue.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rightSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                circularView.setIconRightPaddingInDP(progress);
                rightPaddingValue.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        strokeWidthSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                circularView.setStrokeWidthInDP(progress);
                strokeWidthValue.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        strokePaddingSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                circularView.setStrokePaddingInDP(progress);
                strokePaddingValue.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        circleRadiusSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                circularView.setCircleRadiusInDP(progress);
                circleRadiusValue.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circularView.setIconResource(R.drawable.white);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circularView.setIconResource(R.drawable.c_bowtie);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circularView.setIconResource(R.drawable.c_camera);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
