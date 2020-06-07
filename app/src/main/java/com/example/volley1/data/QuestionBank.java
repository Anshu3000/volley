package com.example.volley1.data;

import android.app.DownloadManager;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.volley1.controller.AppController;
import com.example.volley1.model.Question;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    public ArrayList<Question> arl=new ArrayList<>();
    private  String url1="https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";
    public QuestionBank() {
    }


    public List<Question> getQuestion(){

        JsonArrayRequest jso= new JsonArrayRequest(Request.Method.GET, url1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0;i<response.length();i++){

                    try {
                         JSONArray jsonA =response.getJSONArray(i);
                        Log.d("json", "onResponse: "+jsonA.get(0));
                         Question qu=new Question(jsonA.getString(0),jsonA.getBoolean(1));
                          arl.add(qu);
                       } catch (JSONException e) {
                        e.printStackTrace();
                       }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addRequestQueue(jso);

        return  arl;
    }

}
