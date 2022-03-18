package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private Button btnRegistro;
    private EditText textEmail;
    private EditText textPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        bindUi();

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = textEmail.getText().toString();
                String password = textPassword.getText().toString();
                if (login(email, password)) {
                    goToMain();
                }
            }
        });
    }
        // Por probar

    private void bindUi() {
        textEmail = (EditText) findViewById(R.id.editText);
        textPassword = (EditText) findViewById(R.id.editText2);
        btnRegistro = (Button) findViewById(R.id.button);

    }

    private boolean login (String email, String password){
        if (!isValidaEmail(email)){
            Toast.makeText(this,"Email is not valid, please try again", Toast.LENGTH_LONG).show();
            return false;
        } else if (!isValidaPassword(password)){
            Toast.makeText(this,"Password is not valid, 4 characteres or more, please try again", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return  true;
        }
    }

    private boolean isValidaEmail(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private boolean isValidaPassword(String password){
        return password.length() > 4;
    }

    private void goToMain(){
        Intent intent = new Intent(Registro.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
