package com.tanmaya.tracovid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Member;

import static android.R.layout.simple_list_item_1;

public class SymptomLogger extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    FirebaseDatabase database;
    DatabaseReference ref;
    private EditText patientName,symptomname;
    Button submit,NavHome,NavCB,NavIns;
    SeekBar seek_bar;
    TextView tv1;
    Spinner mySpinner,Spinner2;
    ArrayAdapter<String> myAdapter,Adapter2,Adapter3;
    String hapLevel;
    String record,breathe;
    String getPatName,getSymptomName;
    int maxid = 0;
    Symptom symptom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_logger);
        submit=findViewById(R.id.submit);
        NavHome=findViewById(R.id.button7);
        NavCB=findViewById(R.id.button8);
        NavIns=findViewById(R.id.button11);
        patientName=findViewById(R.id.pat_name);
        symptomname=findViewById(R.id.sym_name);
        symptom = new Symptom();
        ref = database.getInstance().getReference().child("Symptom");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    maxid = (int) dataSnapshot.getChildrenCount();

                }
                else
                {
                    ///
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        NavCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SymptomLogger.this,ChatBotActivity.class);
                startActivity(intent);
                finish();
            }
        });
        NavIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SymptomLogger.this,InsureActivity.class);
                startActivity(intent);
                finish();
            }
        });
        NavHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SymptomLogger.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPatName=patientName.getText().toString();
                getSymptomName=symptomname.getText().toString();
                symptom.setName(getPatName);
                symptom.setSymptoms(getSymptomName);
                symptom.setWelness(hapLevel);
                symptom.setTemp(record);
                symptom.setba(breathe);
                ref.child(String.valueOf(maxid+1)).setValue(symptom);
                Intent intent = new Intent(SymptomLogger.this,SucessActivity.class);
                startActivity(intent);
                finish();
            }
        });


        seekBar();
        mySpinner=findViewById(R.id.spinner1);

        myAdapter= new ArrayAdapter<String>(SymptomLogger.this, simple_list_item_1,getResources().getStringArray(R.array.temps));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);
        record=mySpinner.getSelectedItem().toString();

        Spinner2=findViewById(R.id.spinner2);

        Adapter2= new ArrayAdapter<String>(SymptomLogger.this, simple_list_item_1,getResources().getStringArray(R.array.Ability));

        Adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner2.setAdapter(Adapter2);
        breathe=Spinner2.getSelectedItem().toString();


    }
    public void seekBar(){
        seek_bar = findViewById(R.id.seekBar);
        tv1=findViewById(R.id.textView1);


        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int progress_value;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value=progress;
                        hapLevel=hapLevel.valueOf(progress);
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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //record=parent.getItemAtPosition(position).toString();
    }

   // public void onItemSelected1(AdapterView<?> parent, View view, int position, long id) {
     //   breathe=parent.getItemAtPosition(position).toString();
    //}

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}