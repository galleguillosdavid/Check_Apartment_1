package com.example.checkapartment1.Model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.checkapartment1.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etn, etp;
    private String popup;
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etn = findViewById(R.id.etE);
        etp = findViewById(R.id.etP);

    }
    public void login(View view){
        //almaceno lo que el usuario escribe en el campo de la vista
        String email=etn.getText().toString();
        String pass=etp.getText().toString();
        contador ++;

        if (contador>3){

        }

        if(email.length() == 0){
            popup="Corrige lo siguiente:\nEscribe un email";
            Toast.makeText(this,popup, Toast.LENGTH_LONG).show();

        }
        if(pass.length()==0){
            popup=popup + "\nEscribe una contraseña";
            Toast.makeText(this,popup, Toast.LENGTH_LONG).show();
            popup="";

        }
        if(email.length()!=0 && pass.equals("1")){
            Toast.makeText(this,"Bienvenido denuevo "+ email, Toast.LENGTH_LONG).show();
            intentP(view);
        }

    }
public void intentP(View view){
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
}
}