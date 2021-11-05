package es.system.dereckecc.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.system.dereckecc.PantallaPrincipal;
import es.system.dereckecc.R;

public class PantallaAnimal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_animal);
    }

    public void cambioPantallaAnterior(View view) {
        Intent anteriorPantalla = new Intent(PantallaAnimal.this,
                PantallaPrincipal.class);
        startActivity(anteriorPantalla);
    }
}