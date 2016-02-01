package com.vivianaranha.yqlapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;


public class ResultsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayList<Results> results;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        listView = (ListView) findViewById(R.id.listView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        hideProgressBar();

        String searchTerm = getIntent().getStringExtra("searchTerm");
        String postalCode = getIntent().getStringExtra("postalCode");

        Downloader downloader = new Downloader(this);
        downloader.execute(searchTerm, postalCode);
    }

    public void displayProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void setProgressBarProgress(int progress){
        progressBar.setProgress(progress);
        if(progress == 100){
            hideProgressBar();
        }
    }

    public void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }

    public void drawListView(ArrayList<Results> resultsArray){
        results = new ArrayList<Results>();
        results = resultsArray;
        ResultsAdapter adapter = new ResultsAdapter(this, resultsArray);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Results result = results.get(position);
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}
