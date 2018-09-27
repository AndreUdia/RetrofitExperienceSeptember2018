package com.example.andre.retrofitexperience;

// used https://www.youtube.com/watch?v=sYWRv7Fasgg as reference to this project.

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "teste";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private List<Contact> contacts;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.i(TAG, "olá console");

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        retrofit2.Call<List<Contact>> call = apiInterface.getContacts();

        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Contact>> call, Response<List<Contact>> response) {

                if(!response.isSuccessful()) {
                    Log.i(TAG, "Entrou aqui! - resposta não foi bem sucedida");
                }

                contacts = response.body();
                adapter = new RecyclerAdapter(contacts);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(retrofit2.Call<List<Contact>> call, Throwable t) {
                Log.i(TAG, t.getMessage() + t.getLocalizedMessage() + t.toString());
            }
        });
    }
}
