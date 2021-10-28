package es.system.dereckecc.model.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.system.dereckecc.model.Animal;
import es.system.dereckecc.model.Zoo;
import es.system.dereckecc.model.contracts.AnimalContract;
import es.system.dereckecc.model.contracts.ZooContract;

public class AnimalDbHelper extends ComunDbHelper{
    public AnimalDbHelper(Context context) {
        super(context);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + AnimalContract.UserEntry.TABLE_NAME + " ("
                + AnimalContract.UserEntry.IDANIMAL + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + AnimalContract.UserEntry.IDZOO + "INTEGER NOT NULL, "
                + AnimalContract.UserEntry.SEXO + "TEXT NOT NULL, "
                + AnimalContract.UserEntry.CONTINENTE + " TEXT NOT NULL,"
                + AnimalContract.UserEntry.NACIMIENTO + " DATE NOT NULL,"
                + AnimalContract.UserEntry.PAIS + "TEXT NOT NULL)"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public long save(Animal animal) {
        return super.save(AnimalContract.UserEntry.TABLE_NAME,
                animal.toContentValues());
    }

    public List<Animal> getAll() {
        List<Animal> animales = null;
        Cursor cursor = null;

        try {
            cursor = super.getAll(AnimalContract.UserEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                animales = new ArrayList<>();
                do {
                    @SuppressLint("Range") int idzoo = cursor.getInt(cursor.getColumnIndex(AnimalContract.UserEntry.IDZOO));
                    @SuppressLint("Range") String sexo = cursor.getString(cursor.getColumnIndex(AnimalContract.UserEntry.SEXO));
                    @SuppressLint("Range") String continente = cursor.getString(cursor.getColumnIndex(AnimalContract.UserEntry.CONTINENTE));
                    @SuppressLint("Range") Date nacimiento = new Date(cursor.getLong(cursor.getColumnIndex(AnimalContract.UserEntry.NACIMIENTO)));
                    @SuppressLint("Range") String pais = cursor.getString(cursor.getColumnIndex(AnimalContract.UserEntry.PAIS));
                    Animal animal = new Animal( idzoo, sexo, pais, continente, nacimiento);
                    animales.add(animal);
                } while (cursor.moveToNext());
                return animales;
            }
        } catch (Exception exception) {}

        finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return Collections.emptyList();

    }
}
