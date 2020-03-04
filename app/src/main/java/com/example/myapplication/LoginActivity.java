package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText mail;
    private EditText password;
    private Button login;
    private TextView info;
    private int counter=10;






    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail=(EditText)findViewById(R.id.etmail);
        password=(EditText)findViewById(R.id.etpassword);
        login=(Button)findViewById(R.id.button);
        info=(TextView)findViewById(R.id.info);
        //Toast toast= Toast.makeText(getApplicationContext(),"yarabb",Toast.LENGTH_SHORT);
        //toast.show();
        info.setText("Number of attempts remaining:10");
        login.setEnabled(true);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.setEnabled(true);
                login.setText("yessss");
                validate(mail.getText().toString(),password.getText().toString());
            }
        });
    }
    public void validate (String mail,String pass){


        if ((mail!=null)&& (pass!=null)){
            login.setText("validate");
            Toast toast= Toast.makeText(getApplicationContext(),"vaidate",Toast.LENGTH_SHORT);
            toast.show();
            Intent intent=new Intent(LoginActivity.this,ListActivity.class);
            startActivity(intent);
        }
        else{
            counter--;
            info.setText("Number of attempts remaining:"+String.valueOf(counter));
            if (counter==0){
                login.setEnabled(false);
            }

        }

    }
}
