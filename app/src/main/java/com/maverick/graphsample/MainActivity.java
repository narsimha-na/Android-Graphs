package com.maverick.graphsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.model.GradientColor;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void openBarChart(View view){
        Intent na = new Intent(this,ChartActivity.class);
        na.putExtra("method","bar");
        startActivity(na);
    }

    public void openPieChart(View view){
        Intent na = new Intent(this,ChartActivity.class);
        na.putExtra("method","pie");
        startActivity(na);
    }
}
