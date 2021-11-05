package es.system.dereckecc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import es.system.dereckecc.activity.PantallaAnimal;
import es.system.dereckecc.activity.PantallaZoo;

public class PantallaPrincipal extends AppCompatActivity {

    Button cambioPantallaZoos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
    }

    public void cambioPantallaZoo(View view) {
        Intent zooPantalla = new Intent(PantallaPrincipal.this,
                PantallaZoo.class);
        startActivity(zooPantalla);
    }

    public void cambioPantallaAnimales(View view) {
        Intent animalPantalla = new Intent(PantallaPrincipal.this,
                PantallaAnimal.class);
        startActivity(animalPantalla);
    }

}