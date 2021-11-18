package es.system.dereckecc.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import es.system.dereckecc.PantallaPrincipal;
import es.system.dereckecc.R;
import es.system.dereckecc.model.helpers.ZooDbHelper;
import es.system.dereckecc.view.CustomAdapter;
import es.system.dereckecc.vo.Zoo;

public class PantallaZoo extends AppCompatActivity {

    RecyclerView recyclerView;

    ZooDbHelper zHelper;
    ArrayList<String> nombre, pais, ciudad, id, dimensiones, presupuestoAnual;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_zoo2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerViewID);

        zHelper = new ZooDbHelper(PantallaZoo.this);

        nombre = new ArrayList<>();
        pais = new ArrayList<>();
        ciudad = new ArrayList<>();
        id = new ArrayList<>();

       displayData();

        customAdapter = new CustomAdapter(PantallaZoo.this, nombre, pais, id);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(PantallaZoo.this));
    }

    public void displayData(){
        List<Zoo> zoos = zHelper.getAll();
        if(zoos.size()==0){
            Toast.makeText(this, "No Hay Zoos.", Toast.LENGTH_SHORT).show();
        }else{
            for (Zoo unzoo : zoos) {
                id.add(String.valueOf(unzoo.getId()));
                nombre.add(unzoo.getNombre());
                pais.add(unzoo.getPais());
            }
        }
    }


    public void cambioPantallaAnterior(View view) {
        Intent anteriorPantalla = new Intent(PantallaZoo.this,
                PantallaPrincipal.class);
        startActivity(anteriorPantalla);
    }

    public void cambioPantallaAddZoo(View view){
        setContentView(R.layout.activity_pantalla_add_zoo);
    }

    public void guardarZoo(View view){
        EditText nombreET = (EditText) findViewById(R.id.editTextNombreZoo);
        String nombre = nombreET.getText().toString();
        EditText paisET = (EditText) findViewById(R.id.editTextPaisZoo);
        String pais = paisET.getText().toString();
        EditText ciudadET = (EditText) findViewById(R.id.editTextCiudadZoo);
        String ciudad = ciudadET.getText().toString();
        EditText dimensionesET = (EditText) findViewById(R.id.editDimensionesZoo);
        String dimensiones = dimensionesET.getText().toString();
        EditText presupuestoET = (EditText) findViewById(R.id.editPresupuestoZoo);
        String presupuesto = presupuestoET.getText().toString();

        Zoo nuevoZoo = new Zoo(nombre, pais, ciudad, Integer.parseInt(dimensiones),Integer.parseInt(presupuesto));
        long afectado = zHelper.save(nuevoZoo);

        if(afectado>0){
            Toast.makeText(this, "Guardado!", Toast.LENGTH_SHORT).show();
            Intent zooPantalla = new Intent(PantallaZoo.this,
                    PantallaZoo.class);
            startActivity(zooPantalla);
        }else{
            Toast.makeText(this, "Algo falló ):", Toast.LENGTH_SHORT).show();
        }
    }




}