package es.system.dereckecc.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.system.dereckecc.R;
import es.system.dereckecc.activity.PantallaZoo;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ZooViewHolder> {

    private Context context;
    private ArrayList nombre, pais, ciudad, id, dimensiones, presupuestoAnual;

    public CustomAdapter(Context context,
                         ArrayList nombre,
                         ArrayList pais,
                         ArrayList ciudad,
                         ArrayList id,
                         ArrayList dimensiones,
                         ArrayList presupuestoAnual){
        this.context = context;
        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
        this.id = id;
        this.dimensiones = dimensiones;
        this.presupuestoAnual = presupuestoAnual;

    }

    public CustomAdapter(Context context, ArrayList nombre, ArrayList pais, ArrayList id){
        this.context = context;
        this.nombre = nombre;
        this.pais = pais;
        this.id = id;

    }

    @NonNull
    @Override
    public ZooViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_pantalla_zoo, parent, false);
        return new ZooViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZooViewHolder holder, int position) {
        holder.id_txt.setText(String.valueOf(id.get(position)));
        holder.nombre_txt.setText(String.valueOf(nombre.get(position)));
        holder.pais_txt.setText(String.valueOf(pais.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class ZooViewHolder extends RecyclerView.ViewHolder {

        TextView nombre_txt, pais_txt, ciudad_txt, id_txt, dimensiones_txt, presupuestoAnual_txt;

        public ZooViewHolder(@NonNull View itemView) {
            super(itemView);
            id_txt = itemView.findViewById(R.id.id_txt);
            nombre_txt = itemView.findViewById(R.id.nombre_txt);
            pais_txt = itemView.findViewById(R.id.pais_txt);
        }
    }
}
