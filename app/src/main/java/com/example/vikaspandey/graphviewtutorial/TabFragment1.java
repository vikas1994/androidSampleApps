package com.example.vikaspandey.graphviewtutorial;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Created by vikaspandey on 30/5/18.
 */

public class TabFragment1 extends Fragment {

    LineGraphSeries<DataPoint> series;

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
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
