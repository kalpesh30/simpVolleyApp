package com.example.kalpesh.simplevollyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    private static String BASE_URL = "https://jsonplaceholder.typicode.com/todos" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StringRequest stringRequest = new StringRequest(BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    Log.v("Response",response) ;
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                C1[] c1 = gson.fromJson(response,C1[].class) ;
                Log.v("response",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("Error","Couldnt get JSON") ;
            }
        }) ;

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest) ;

        //gson.fromJson(stringRequest.,C1.class)
    }
}
