package com.example.myfirebase;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    Button create;
    EditText email,password;
    ProgressDialog dialog;
    private FirebaseAuth myAut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        create=findViewById(R.id.btn_create);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        myAut=FirebaseAuth.getInstance();
        dialog=new ProgressDialog(this);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=email.getText().toString();
                String pswd = password.getText().toString();
                addAccount(mail.trim(),pswd.trim());
            }
        });
    }
    boolean emptyCheck(String mail, String password)
    {
        if(mail.isEmpty() && password.isEmpty()) return  true;
        else  return  false;
    }
    void addAccount(String mail, String password)
    {
        if(emptyCheck(mail,password)==true)
        {
            myAut.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    Toast.makeText(getBaseContext(), "Successful", Toast.LENGTH_SHORT).show();
                }
            });

        }
        else             Toast.makeText(getBaseContext(), "required field", Toast.LENGTH_SHORT).show();

    }

}
