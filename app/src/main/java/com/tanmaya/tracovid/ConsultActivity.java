package com.tanmaya.tracovid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ConsultActivity extends AppCompatActivity {
    Button NavHome,NavDiag,NavIns,NavCB;
    private DatabaseReference myDatabase;
            EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        NavCB=findViewById(R.id.button8);
        NavIns=findViewById(R.id.button11);
        NavDiag=findViewById(R.id.button10);
        NavHome=findViewById(R.id.button7);
        NavDiag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultActivity.this,SymptomLogger.class);
                startActivity(intent);
                finish();
            }
        });
        NavCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultActivity.this,ChatBotActivity.class);
                startActivity(intent);
                finish();
            }
        });
        NavIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultActivity.this,InsureActivity.class);
                startActivity(intent);
                finish();
            }
        });
        NavHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        myDatabase = FirebaseDatabase.getInstance().getReference("Message");

        final TextView myText = findViewById(R.id.textbox);
        myDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                myText.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                myText.setText("CANCELLED");

            }
        });
    }
    public void sendMessage(View view){
        myEditText = findViewById(R.id.editText);

        myDatabase.child(Long.toString(System.currentTimeMillis())).setValue(myEditText.getText().toString());
        myEditText.setText("\n");
    }

    }
