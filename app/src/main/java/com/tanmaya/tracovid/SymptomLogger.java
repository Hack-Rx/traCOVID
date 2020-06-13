package com.tanmaya.tracovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.layout.simple_list_item_1;

public class SymptomLogger extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private EditText doctorID;
    private EditText patientName;
    Button submit;
    SeekBar seek_bar;
    TextView tv1;
    Spinner mySpinner,Spinner2,Spinner3;
    ArrayAdapter<String> myAdapter,Adapter2,Adapter3;
    int hapLevel=0;
    String record;
    String getDocID;
    String getPatName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_logger);
        submit=(Button)findViewById(R.id.submit);
        patientName=findViewById(R.id.pat_name);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPatName=patientName.getText().toString();
                TextView patName=(TextView)findViewById(R.id.disp_pat_name);
                TextView happiness=(TextView)findViewById(R.id.happiness);
                TextView temp=(TextView)findViewById(R.id.temp);
                happiness.setText("Wellness Level: "+hapLevel+"%");
                temp.setText("Temperature: "+record);
                patName.setText("Patient Name: "+getPatName);
            }
        });


        seekBar();
        mySpinner=(Spinner)findViewById(R.id.spinner1);

        myAdapter= new ArrayAdapter<String>(SymptomLogger.this, simple_list_item_1,getResources().getStringArray(R.array.temps));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        Spinner2=(Spinner)findViewById(R.id.spinner2);

        Adapter2= new ArrayAdapter<String>(SymptomLogger.this, simple_list_item_1,getResources().getStringArray(R.array.Ability));

        Adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner2.setAdapter(Adapter2);
        //Spinner2.setOnItemSelectedListener(this);

        //Spinner3=(Spinner)findViewById(R.id.spinner3);

        //Adapter3= new ArrayAdapter<String>(SymptomLogger.this, simple_list_item_1,getResources().getStringArray(R.array.disease));

        //Adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Spinner3.setAdapter(Adapter3);

        //Spinner3.setOnItemSelectedListener(this);
    }
    public void seekBar(){
        seek_bar = (SeekBar)findViewById(R.id.seekBar);
        tv1=(TextView)findViewById(R.id.textView1);


        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int progress_value;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value=progress;
                        hapLevel=progress;
                        tv1.setText("Happiness : "+progress+"%");
                        Toast.makeText(SymptomLogger.this,"SeekBar in progress",Toast.LENGTH_LONG);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(SymptomLogger.this,"SeekBar in Tracking",Toast.LENGTH_LONG);

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        tv1.setText("Wellness : "+progress_value+"%");
                        Toast.makeText(SymptomLogger.this,"SeekBar in Stopped",Toast.LENGTH_LONG);
                    }
                }
        );

    }

    public void pressed(View view) {
        TextView happiness=(TextView)findViewById(R.id.happiness);
        TextView temp=(TextView)findViewById(R.id.temp);
        happiness.setText("Wellness Level: "+hapLevel+"%");
        temp.setText("Temperature: "+record);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        record=parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}