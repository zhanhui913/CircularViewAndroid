package com.zhan.circularview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.zhan.library.CircularView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextCircularViewFragment extends Fragment {

    private View view;
    private CircularView circularView;

    private SeekBar topSlider, bottomSlider, leftSlider, rightSlider;
    private SeekBar strokeWidthSlider, strokePaddingSlider;
    private SeekBar circleRadiusSlider;

    private TextView topPaddingValue, bottomPaddingValue, leftPaddingValue, rightPaddingValue;
    private TextView strokeWidthValue, strokePaddingValue;
    private TextView circleRadiusValue;

    private ImageButton button1, button2, button3;

    public TextCircularViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_text_circular_view, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        init();
        addListeners();
    }

    private void init(){
        circularView = (CircularView) view.findViewById(R.id.circularView);
        circularView.setCircleColor(R.color.green);
        circularView.setTextColor(R.color.purple);
        circularView.setTextSize(50);
        circularView.setText("5");

        topPaddingValue = (TextView) view.findViewById(R.id.topPaddingValue);
        bottomPaddingValue = (TextView) view.findViewById(R.id.bottomPaddingValue);
        leftPaddingValue = (TextView) view.findViewById(R.id.leftPaddingValue);
        rightPaddingValue = (TextView) view.findViewById(R.id.rightPaddingValue);
        strokeWidthValue = (TextView) view.findViewById(R.id.strokeWidthValue);
        strokePaddingValue = (TextView) view.findViewById(R.id.strokePaddingValue);
        circleRadiusValue = (TextView) view.findViewById(R.id.circleRadiusValue);

        topSlider = (SeekBar) view.findViewById(R.id.topPaddingSlider);
        bottomSlider = (SeekBar) view.findViewById(R.id.bottomPaddingSlider);
        leftSlider = (SeekBar) view.findViewById(R.id.leftPaddingSlider);
        rightSlider = (SeekBar) view.findViewById(R.id.rightPaddingSlider);
        strokeWidthSlider = (SeekBar) view.findViewById(R.id.strokeWidthSlider);
        strokePaddingSlider = (SeekBar) view.findViewById(R.id.strokePaddingSlider);
        circleRadiusSlider = (SeekBar) view.findViewById(R.id.circleRadiusSlider);

        button1 = (ImageButton) view.findViewById(R.id.iconButton1);
        button2 = (ImageButton) view.findViewById(R.id.iconButton2);
        button3 = (ImageButton) view.findViewById(R.id.iconButton3);

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

}
