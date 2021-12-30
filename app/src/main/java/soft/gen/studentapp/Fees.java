package soft.gen.studentapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONArray;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import soft.gen.studentapp.Adapters.FeesAdapter;
import soft.gen.studentapp.Adapters.FeesAdapterQuarterly;

public class Fees extends AppCompatActivity {

    RecyclerView recyclerView_fees_monthly;

    RecyclerView recyclerView_fees_quarterly;

    FeesAdapter feesAdapter = null;

    FeesAdapterQuarterly feesAdapterQuarterly = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees);

        recyclerView_fees_monthly = findViewById(R.id.recyclerView_fees_monthly);
        recyclerView_fees_monthly.setAdapter(feesAdapter);

        recyclerView_fees_quarterly=findViewById(R.id.recyclerView_fees_quarterly);
        recyclerView_fees_quarterly.setAdapter(feesAdapterQuarterly);
        loadfeesDetalsMonth();
        loadfeesDetalsQuarterly();

        findViewById(R.id.back_button_fees).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
    @SuppressLint("WrongConstant")
    private void loadfeesDetalsMonth() {
        JSONArray jsonArray = new JSONArray();
        feesAdapter = new FeesAdapter(jsonArray, getApplicationContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // set Horizontal Orientation
        recyclerView_fees_monthly.setLayoutManager(layoutManager);
        recyclerView_fees_monthly.setItemAnimator(new DefaultItemAnimator());

       /*  GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        recyler_subjects.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView*/
        this.recyclerView_fees_monthly.setAdapter(feesAdapter);
    }
    @SuppressLint("WrongConstant")
    private void loadfeesDetalsQuarterly() {
        JSONArray jsonArray = new JSONArray();
        feesAdapterQuarterly = new FeesAdapterQuarterly(jsonArray, getApplicationContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // set Horizontal Orientation
        recyclerView_fees_quarterly.setLayoutManager(layoutManager);
        recyclerView_fees_quarterly.setItemAnimator(new DefaultItemAnimator());

       /*  GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        recyler_subjects.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView*/
        this.recyclerView_fees_quarterly.setAdapter(feesAdapterQuarterly);

    }
}
