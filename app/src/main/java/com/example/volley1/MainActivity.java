package com.example.volley1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.textclassifier.TextLinks;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.volley1.controller.AppController;
import com.example.volley1.data.QuestionBank;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private String url1 = "https://jsonplaceholder.typicode.com/posts/1";
    private RequestQueue req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   req = Volley.newRequestQueue(this);

//        JsonObjectRequest  jso =new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Log.d("json", "onResponse: "+response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("json", "onErrorResponse: "+"error");
//            }
//        });
//
//
//        req.add(jso);
//    }

//        JsonArrayRequest jso = new JsonArrayRequest(Request.Method.GET, url1, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                for (int i = 0; i < response.length(); i++) {
//
//                    try {
//                        JSONObject js = response.getJSONObject(i);
//                        Log.d("json", "onResponse: " + js.getInt("Id"));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });

         new QuestionBank().getQuestion();

    }
}