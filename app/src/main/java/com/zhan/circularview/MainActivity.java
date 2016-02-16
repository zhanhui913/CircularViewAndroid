package com.zhan.circularview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.zhan.library.CircularView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CircularView circularView = (CircularView) findViewById(R.id.circularView);

        circularView.setCircleColor(R.color.green);
        circularView.setCircleRadius(50);

        circularView.setIconColor(R.color.purple);
        circularView.setIconResource(R.drawable.c_android);
        circularView.setIconTopPadding(20);
        circularView.setIconBottomPadding(20);
        circularView.setIconLeftPadding(20);
        circularView.setIconRightPadding(20);
        circularView.setStrokeColor(R.color.gray);
        circularView.setStrokeWidth(10);
        circularView.setStrokePadding(5);


        CircularView circularView2 = (CircularView) findViewById(R.id.circularView2);
        circularView2.setIconResource(R.drawable.c_android);
        circularView2.setStrokeColor(R.color.red);
        circularView2.setStrokeWidth(5);
        circularView2.setStrokePadding(15);
        circularView2.setCircleRadius(50);
        circularView2.setCircleColor(R.color.colorAccent);

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
