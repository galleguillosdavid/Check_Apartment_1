package com.example.checkapartment1.Model;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.checkapartment1.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etn, etp;
    private String popup;
    private Button botonA;
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etn = findViewById(R.id.etE);
        etp = findViewById(R.id.etP);
        botonA = findViewById(R.id.boton1);

    }
    public void login(View view){
        //almaceno lo que el usuario escribe en el campo de la vista
        String email=etn.getText().toString();
        String pass=etp.getText().toString();


        if (contador>2){
        botonA.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Contraseña incorrecta, Reinicia la aplicación", Toast.LENGTH_SHORT).show();
        }else {
            botonA.setVisibility(View.VISIBLE);
            Toast.makeText(this, (contador+1) + "° intento", Toast.LENGTH_SHORT).show();
        }
        contador ++;
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
            contador=0;
            intentP(view);
        }

    }
public void intentP(View view){
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
}
}