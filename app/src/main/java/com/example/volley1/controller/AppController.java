package com.example.volley1.controller;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {

     private RequestQueue req;
     private  static AppController minsta;

     public  static  final String Tag=AppController.class.getSimpleName();


     public  static synchronized AppController getInstance(){

         return minsta;
     }

    public void onCreate(){
         super.onCreate();
         minsta=this;
    }

    public RequestQueue getRequest(){
         if(req==null)
          req= Volley.newRequestQueue(getApplicationContext());

         return  req;
    }

    public<T> void addRequestQueue(Request<T> re){
         re.setTag(Tag);
         getRequest().add(re);
    }

     public void  CancelPendingReq(Object tag){
         if(req!=null) req.cancelAll(tag);
     }
}
