package com.example.dropdown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //String[] mycountryArray={"Bangladesh","India"};
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySpinner=findViewById(R.id.mySpinnerID);

        ArrayAdapter<CharSequence> myAdapter=ArrayAdapter.createFromResource(this,R.array.mycountryArray,android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Fragment myfragment;
        if(text.equals("Bangladesh")){
           // load BDFragment2;
            myfragment=new BDFragment2();
        }
        else if(text.equals("India")){
         //INFragment2;
            myfragment= new INFragment2();
        }
        else {
           // BlankFragment;
            myfragment=new BlankFragment();
        }

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.myFragmentAreaID,myfragment);
        ft.commit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Fragment myfragment;
        myfragment=new BlankFragment();

    FragmentManager fm=getSupportFragmentManager();
    FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.myFragmentAreaID,myfragment);
        ft.commit();

    }
}