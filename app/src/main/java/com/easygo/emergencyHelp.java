package com.easygo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class emergencyHelp extends AppCompatActivity {

    private Spinner spinner;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency_help);

        spinner=(Spinner)findViewById(R.id.spinner);
        button=(Button)findViewById(R.id.button);

        addItemOnSinner();
        addListenerOnSpinnerItemSelection();
        addListenerOnButton();

    }
    private void addListenerOnButton() {
        spinner=(Spinner)findViewById(R.id.spinner);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //changes for gps activity
                //update database
                Intent intent=new Intent(emergencyHelp.this,Response.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

    }

    private void addItemOnSinner() {
        spinner=(Spinner)findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("MEDICAL HELP");
        list.add("WHEELCHAIR ASSISTANCE");
        list.add("FIRE EXIT");
        list.add("OTHER");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }
    public void addListenerOnSpinnerItemSelection() {
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
