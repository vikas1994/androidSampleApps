package com.example.vikaspandey.graphviewtutorial;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

/**
 * Created by vikaspandey on 30/5/18.
 */

public class TabFragment1 extends Fragment {

    LineGraphSeries<DataPoint> series;
    private Context context;

    private ArrayList<String> sampleArray1 = new ArrayList<>();
    private ArrayList<String> sampleArray2 = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getContext();

        for (int i=0; i<5;i++) {
            sampleArray1.add("Item" + i);
            sampleArray2.add("Item " + i);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        double y,x;
        x = -5.0;
        GraphView graphView = (GraphView) view.findViewById(R.id.graph_view);
        series = new LineGraphSeries<DataPoint>();

        for (int i=0; i<500; i++) {
            x = x + 0.1;
            y = Math.sin(x);

            series.appendData(new DataPoint(x,y), true, 500);
        }
        graphView.addSeries(series);

        RecyclerView recyclerView1 = (RecyclerView) view.findViewById(R.id.exercise_view);
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.devices_view);
        ItemAdapter adapter1 = new ItemAdapter(getContext(), sampleArray1);
        ItemAdapter adapter2 = new ItemAdapter(getContext(), sampleArray2);
        recyclerView1.setAdapter(adapter1);
        recyclerView2.setAdapter(adapter2);
        recyclerView1.setNestedScrollingEnabled(false);
        recyclerView2.setNestedScrollingEnabled(false);
        recyclerView1.setLayoutManager(new LinearLayoutManager(context));
        recyclerView2.setLayoutManager(new LinearLayoutManager(context));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
