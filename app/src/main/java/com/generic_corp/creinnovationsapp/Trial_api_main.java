package com.generic_corp.creinnovationsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Trial_api_main extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DataAdapter dataAdapter;
    private ApiInterface apiInterface;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial_api_main);
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadData();

            }
        });
    }

    private void loadData(){
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getListData().enqueue(new Callback<final_outer_class>() {
            @Override
            public void onResponse(Call<final_outer_class> call, Response<final_outer_class> response) {
                if (response.isSuccessful()){
                    List<model_for_outer_data> contactList = response.body().getData();
                    Log.d("Successssssssssssssssss","onResponse: okkkkkkkkkkkkkk");
                    for (int i = 0; i < contactList.size(); i++) {
                        dataAdapter = new DataAdapter((ArrayList<model_for_outer_data>) contactList);
                        recyclerView.setAdapter(dataAdapter);
                        dataAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<final_outer_class> call, Throwable t) {

            }
        });
    }
}