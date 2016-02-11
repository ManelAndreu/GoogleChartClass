package com.googlecharts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import charts.Chart;

public class MainActivity extends AppCompatActivity {


    Chart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chart = (Chart) findViewById(R.id.chart);
        chart.create(300, 300, "Google Pie Chart", "http://www.provant.com.es/~greenpoint/Charts/pie.html", "Android", "Orgánico", "Papel", "Vídrio", 3, 4, 5);
    }
}
