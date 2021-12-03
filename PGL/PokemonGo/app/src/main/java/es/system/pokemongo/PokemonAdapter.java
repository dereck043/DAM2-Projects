package es.system.pokemongo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuView;

import java.util.ArrayList;

import es.system.pokemongo.api.Pokemon;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

    ArrayList<Pokemon> pokemons;

    public PokemonAdapter(@NonNull Context context, int resource, ArrayList<Pokemon> pokemons) {
        super(context, resource);
        this.pokemons = pokemons;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int index = position;
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_item_list, parent, false);
        }
        TextView viewById = convertView.findViewById(R.id.item_list);
        viewById.setText(pokemons.get(position).getName());
        return convertView;
    }
}
