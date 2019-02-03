package com.example.myfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText nametxt,surnametxt;
    Button save;
    RadioButton r1,r2;

    Model data;

    private DatabaseReference mdatabase;
    private FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nametxt=findViewById(R.id.name);
        surnametxt=findViewById(R.id.surname);
        save=findViewById(R.id.save);
        r1=findViewById(R.id.radiomale);
        r2=findViewById(R.id.radiofemale);

//        String uID=mauth.getUid();

        mauth=FirebaseAuth.getInstance();
        mdatabase= FirebaseDatabase.getInstance().getReference().child("NameList");//.child(uID);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nametxt.getText().toString().trim();
                String surname=surnametxt.getText().toString().trim();
                insertData(name,surname);
            }
        });


    }

    boolean emptyCheck(String name, String surname)
    {
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "Enter name!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(surname)) {
            Toast.makeText(getApplicationContext(), "Enter surname!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return  true;
    }
    String radiocheck(RadioButton r1, RadioButton r2)
    {
        if(r1.isChecked()) return  r1.getText().toString();
        else return r2.getText().toString();
    }
    void insertData(String name, String surname)
    {
        if(emptyCheck(name,surname))
        {
            String id=mdatabase.push().getKey();
            String date= DateFormat.getDateInstance().format(new Date(String.valueOf(Calendar.getInstance().getTime())));
            data=new Model(id,date,name,surname,radiocheck(r1,r2));
            mdatabase.child(id).setValue(data);
            Toast.makeText(getBaseContext(),"Succesful insert data!",Toast.LENGTH_SHORT).show();
            nametxt.setText("");
            surnametxt.setText("");
        }

    }
}
