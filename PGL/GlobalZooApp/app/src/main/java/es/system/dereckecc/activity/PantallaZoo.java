package es.system.dereckecc.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.system.dereckecc.PantallaPrincipal;
import es.system.dereckecc.R;

public class PantallaZoo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_zoo);
    }

    public void cambioPantallaAnterior(View view) {
        Intent anteriorPantalla = new Intent(PantallaZoo.this,
                PantallaPrincipal.class);
        startActivity(anteriorPantalla);
    }

    public void cambioPantallaAnimales(View view) {
        Intent animalPantalla = new Intent(PantallaZoo.this,
                PantallaAnimal.class);
        startActivity(animalPantalla);
    }


}