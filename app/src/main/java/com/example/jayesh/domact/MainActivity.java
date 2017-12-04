package com.example.jayesh.domact;


import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       BlankFragment fragment=new BlankFragment();
        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        transaction.replace(android.R.id.content,fragment);
        transaction.commit();


    }
}
