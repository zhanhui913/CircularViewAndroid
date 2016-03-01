package com.zhan.circularview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.zhan.library.CircularView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextCircularViewFragment extends Fragment {

    private View view;
    private CircularView circularView;

    private SeekBar textSizeSlider;
    private SeekBar strokeWidthSlider, strokePaddingSlider;
    private SeekBar circleRadiusSlider;

    private TextView textSizeValue;
    private TextView strokeWidthValue, strokePaddingValue;
    private TextView circleRadiusValue;

    private Button button1, button2, button3;

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
        circularView.setCircleColor(R.color.lightPurple);
        Log.d("ZHAN", "1 after setting circle color -> " + circularView.getCircleColorHex());

        circularView.setCircleColor("#e76558");
        Log.d("ZHAN","2 after setting circle color -> "+circularView.getCircleColorHex());
        circularView.setTextColor(R.color.purple);
        circularView.setTextSizeInDP(50);
        circularView.setText("5");
        circularView.setTextColor("#ffffffff");

        textSizeValue = (TextView) view.findViewById(R.id.textSizeValue);
        strokeWidthValue = (TextView) view.findViewById(R.id.strokeWidthValue);
        strokePaddingValue = (TextView) view.findViewById(R.id.strokePaddingValue);
        circleRadiusValue = (TextView) view.findViewById(R.id.circleRadiusValue);

        textSizeSlider = (SeekBar) view.findViewById(R.id.textSizeSlider);
        strokeWidthSlider = (SeekBar) view.findViewById(R.id.strokeWidthSlider);
        strokePaddingSlider = (SeekBar) view.findViewById(R.id.strokePaddingSlider);
        circleRadiusSlider = (SeekBar) view.findViewById(R.id.circleRadiusSlider);

        button1 = (Button) view.findViewById(R.id.iconButton1);
        button2 = (Button) view.findViewById(R.id.iconButton2);
        button3 = (Button) view.findViewById(R.id.iconButton3);

        textSizeSlider.setProgress(20);
        strokeWidthSlider.setProgress(0);
        strokePaddingSlider.setProgress(0);
        circleRadiusSlider.setProgress(50);

        textSizeValue.setText("20");
        strokeWidthValue.setText("0");
        strokePaddingValue.setText("0");
        circleRadiusValue.setText("50");
    }

    private void addListeners(){
        textSizeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                circularView.setTextSizeInDP(progress);
                textSizeValue.setText(""+progress);
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
                circularView.setText("4");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circularView.setText("Z");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circularView.setText("a");
            }
        });
    }

}
