package es.iespuerto.dc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD

public class MainActivityPaginaPrincipal extends AppCompatActivity {

=======
import android.view.View;
import android.widget.Button;

public class MainActivityPaginaPrincipal extends AppCompatActivity {
    Button buttonGoToLogin;
>>>>>>> cdca2c6cfb02954726d7610741e44544b0a892ab
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pagina_principal);
<<<<<<< HEAD
=======
        buttonGoToLogin = (Button) findViewById(R.id.buttonGoToLogin);
        buttonGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
            }
        });
>>>>>>> cdca2c6cfb02954726d7610741e44544b0a892ab
    }
}