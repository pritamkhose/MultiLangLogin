package com.example.pritam.mymultilang;

// http://www.androidhive.info/2014/07/android-building-multi-language-supported-app/

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity implements OnItemSelectedListener {

    private Spinner spinner1, spinner2;
    private Button btnSubmit;
    List<String> list;
    final String languageToLoad[] = {"en", "hi", "fr", "ja", "de"};
    int item =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       onStartCreate();

    }

    private void onStartCreate() {
        // Spinner element
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        // Spinner click listener
        spinner2.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        list = new ArrayList<String>();
        list.add("English");
        list.add("हिन्दी");
        list.add("français");
        list.add("日本語");
        list.add("Deutsch");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner2.setAdapter(dataAdapter);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale(languageToLoad[item]);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                // Toast.makeText(MainActivity.this, "Locale - " + languageToLoad[spinner2.getSelectedItemPosition()].toString() + spinner2.getSelectedItemPosition(), Toast.LENGTH_LONG).show();
                setContentView(R.layout.activity_main);
                onStartCreate();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
       // String item = parent.getItemAtPosition(position).toString();
        item = parent.getSelectedItemPosition();
        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
