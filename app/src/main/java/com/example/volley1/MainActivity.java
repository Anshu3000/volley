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
import com.example.volley1.model.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String url1 = "https://jsonplaceholder.typicode.com/posts/1";
    private RequestQueue req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //List<Question> li= new QuestionBank().getQuestion();
        Log.d("he1","start");
        new QuestionBank().getQuestion(new AnswerAsync() {
            @Override
            public void proc(ArrayList<Question> qr) {
                Log.d("hell", "onCreate: "+qr);
            }
        });
       // Log.d("hello", "onCreate: "+li);
    }
}