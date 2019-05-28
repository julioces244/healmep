package com.tecsup.apaza.healmepaciente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.et_email);
        password = (EditText) findViewById(R.id.et_password);
    }

    public void goregister(View view){
        Intent intent = new Intent(LoginActivity.this,
                RegisterActivity.class);
        startActivity(intent);
    }

    public void gomainview(View view){


        String user  = email.getText().toString();
        String pass = password.getText().toString();

        if (user.equals("julio.apaza@tecsup.edu.pe")){
            Intent intent = new Intent(LoginActivity.this,
                    MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_SHORT).show();
        }

        
    }
}
