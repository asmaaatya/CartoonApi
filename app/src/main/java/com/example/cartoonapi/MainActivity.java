package com.example.cartoonapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.cartoonapi.Data.CharAdapter;
import com.example.cartoonapi.Data.DataModel;
import com.example.cartoonapi.pojo.CharachtersResponse;
import com.example.cartoonapi.pojo.Char;
import com.example.cartoonapi.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "check";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rec_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call<CharachtersResponse> characterResponseCall = RetrofitClient.getInstance().getCharachters(1);
        //get response
        characterResponseCall.enqueue(new Callback<CharachtersResponse>() {
            @Override
            public void onResponse(Call<CharachtersResponse> call, Response<CharachtersResponse> response) {
                Log.d(TAG, "onResponse: " + response.isSuccessful());
                Log.d(TAG, "onResponse: " + response.body());
                List<Char> results = response.body().getResults();
                ArrayList<DataModel> myModel = new ArrayList<>();
                for (Char result : results) {
                    DataModel model = new DataModel(result.getImage(), result.getName(), result.getStatus(), result.getSpecies(), result.getGender());
                    //add model to list
                    myModel.add(model);
                    Log.d(TAG, results.toString());
                }
                CharAdapter adapter = new CharAdapter(myModel);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<CharachtersResponse> call, Throwable t) {
                Log.d(TAG, t.getLocalizedMessage());
            }
        });
    }
}