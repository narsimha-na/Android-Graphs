package com.maverick.graphsample;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChartFragment extends Fragment {


    private View view;
    private BarChart barChart;
    private PieChart pieChart;

    public ChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view  =  inflater.inflate(R.layout.fragment_chart, container, false);

        barChart = (BarChart) view.findViewById(R.id.barGraph);
        pieChart = (PieChart)view.findViewById(R.id.pieGraph);
        
        getChart(getArguments().getString("method"));




        return view;
    }

    private void getChart(final String method) {

        if(method.equals("bar")){

            barChart.setDrawBarShadow(false);
            barChart.setDrawValueAboveBar(true);
            barChart.setMaxVisibleValueCount(50);
            barChart.setPinchZoom(false);
            barChart.setDrawGridBackground(true);


            List<BarEntry>  barEntries = new ArrayList<>();

            barEntries.add(new BarEntry(1,40f));
            barEntries.add(new BarEntry(2,44f));
            barEntries.add(new BarEntry(3,25f));
            barEntries.add(new BarEntry(4,30f));
            barEntries.add(new BarEntry(5,34f));

            BarDataSet barDataSet = new BarDataSet(barEntries, "Data Set");
            barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

            BarData data = new BarData(barDataSet);
            data.setBarWidth(0.9f);
            pieChart.setVisibility(View.GONE);
            barChart.setVisibility(View.VISIBLE);

            barChart.setData(data);



        }else if (method.equals("pie")){


            pieChart.setUsePercentValues(true);
            pieChart.setExtraOffsets(5,10,5,5);
            pieChart.setDragDecelerationFrictionCoef(0.9f);
            pieChart.setVisibility(View.VISIBLE);
            barChart.setVisibility(View.GONE);
            pieChart.setDrawHoleEnabled(false);
            pieChart.setTransparentCircleRadius(0.61f);


            List<PieEntry> pieEntries = new ArrayList<>();

            pieEntries.add(new PieEntry(34f,"Bangladesh"));
            pieEntries.add(new PieEntry(23f,"India"));
            pieEntries.add(new PieEntry(14f,"USA"));
            pieEntries.add(new PieEntry(26f,"China"));
            pieEntries.add(new PieEntry(35,"Russia"));
            pieEntries.add(new PieEntry(40,"Japan"));
            pieEntries.add(new PieEntry(10,"Africa"));

            pieChart.animateXY(5000,5000);

            PieDataSet pieDataSet = new PieDataSet(pieEntries, "Countries");
            pieDataSet.setSliceSpace(3f);
            pieDataSet.setSelectionShift(5f);
            pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

            PieData pieData = new PieData(pieDataSet);
            pieData.setValueTextSize(10f);
            pieData.setValueTextColor(Color.BLACK);
            pieChart.setData(pieData);

        }
    }

}
