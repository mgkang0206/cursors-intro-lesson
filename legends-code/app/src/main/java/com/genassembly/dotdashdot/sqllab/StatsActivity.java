package com.genassembly.dotdashdot.sqllab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        final InitDB db = new InitDB(this);

        TextView points = (TextView) findViewById(R.id.mostPoints);
        points.setText(db.getDB().getSumPoints().get(0));

    }

}
