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


//        Test1();
//        Test2(1);
        debugtool1();
        debugtool2();
        exception();
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

    @DebugTool
    public void debugtool1(){
        Log.e(TAG,"debugtool1");
    }
    @DebugTool
    public void debugtool2(){
        Log.e(TAG,"debugtool2");
    }



    public void exception(){
        LogUtil.d("MainActivity-->exception-->前");
        Object o=null;
        o.equals("");
        LogUtil.d("MainActivity-->exception-->后");
    }
}
