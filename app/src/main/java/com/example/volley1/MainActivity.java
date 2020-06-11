package com.example.volley1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

     private TextView showque,showcot,scoretext;
     private Button true1,false1;
     private ImageView Next1,Prev1;
     private ArrayList<Question> qr12;
     private int i=0,score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showcot=findViewById(R.id.counttext);
        showque=findViewById(R.id.cardtext);
        true1=findViewById(R.id.tru);
         false1=findViewById(R.id.fal);
         Next1= findViewById(R.id.next1);
         Prev1=findViewById(R.id.prev2);
       scoretext=findViewById(R.id.score1);

          true1.setOnClickListener(this);
          false1.setOnClickListener(this);
          Next1.setOnClickListener(this);
          Prev1.setOnClickListener(this);



        Log.d("he1","start");
        new QuestionBank().getQuestion(new AnswerAsync() {
            @Override
            public void proc(ArrayList<Question> qr) {
                qr12=qr;
                Log.d("hell", "onCreate: "+qr12);
            }
        });



    }

    @Override
  public void onClick(View v) {

        switch(v.getId()){

            case R.id.next1 :
                             i=(i+1)% qr12.size();
                             Log.d("iv","value"+i+"s"+qr12.size());
                               update(i);
                             break;
            case R.id.prev2 :
                           i=(i-1)%qr12.size();
                           if(i<0)
                             i=0;
                          update(i);
                          break;

            case R.id.tru :
                    check(true);
                    break;
            case R.id.fal :
                  check(false);

        }

        i=(i+1)% qr12.size();
        update(i);

    }

    public void update(int i)
    {
        showque.setText(qr12.get(i).getQues());
         showcot.setText(String.valueOf(i)+"/"+String.valueOf(qr12.size()));
   }

   public  void check(boolean che)
   {  boolean ans=qr12.get(i).isAns();
      Toast toa;
        if(che==ans)
        {   Toast.makeText(this,"RIGHT answer",Toast.LENGTH_SHORT).show();
             score=score+10;
             scoretext.setText(String.valueOf(score));
        }else {
           Toast.makeText(this,"WRONG answer",Toast.LENGTH_SHORT).show();
           score=score-10;
           scoretext.setText(String.valueOf(score));
            //toa.show();
        }

   }


}