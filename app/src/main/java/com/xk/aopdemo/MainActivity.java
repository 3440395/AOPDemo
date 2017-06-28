package com.xk.aopdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Test1();
        Test2(1);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void Test1(){
        Log.e(TAG,"Test1");
    }

    public void Test2(int a){
        Log.e(TAG,"Test2");
    }
}
