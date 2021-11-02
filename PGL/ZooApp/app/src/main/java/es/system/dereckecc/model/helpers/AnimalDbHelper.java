package es.system.dereckecc.model.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.system.dereckecc.vo.Animal;
import es.system.dereckecc.vo.Zoo;
import es.system.dereckecc.model.contracts.AnimalContract;

public class AnimalDbHelper extends ComunDbHelper{
    public AnimalDbHelper(Context context) {
        super(context);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + AnimalContract.AnimalEntry.TABLE_NAME + " ("
                + AnimalContract.AnimalEntry.IDANIMAL + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + AnimalContract.AnimalEntry.IDESPECIE + "INTEGER NOT NULL, "
                + AnimalContract.AnimalEntry.SEXO + "TEXT NOT NULL, "
                + AnimalContract.AnimalEntry.CONTINENTE + " TEXT NOT NULL,"
                + AnimalContract.AnimalEntry.ANIONACIMIENTO + " INTEGER NOT NULL,"
                + AnimalContract.AnimalEntry.PAIS + "TEXT NOT NULL)"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public long save(Animal animal) {
        return super.save(AnimalContract.AnimalEntry.TABLE_NAME,
                animal.toContentValues());
    }

    public List<Animal> getAll() {
        List<Animal> animales = null;
        Cursor cursor = null;

        try {
            cursor = super.getAll(AnimalContract.AnimalEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                animales = new ArrayList<>();
                do {
                    @SuppressLint("Range") int idespecie = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.IDESPECIE));
                    @SuppressLint("Range") String sexo = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.SEXO));
                    @SuppressLint("Range") String continente = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.CONTINENTE));
                    @SuppressLint("Range") int anionacimiento = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.ANIONACIMIENTO));
                    @SuppressLint("Range") String pais = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.PAIS));
                    Animal animal = new Animal( idespecie, sexo, pais, continente, anionacimiento);
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

    public Animal getById(String id) {
        Animal animal = null;
        Cursor cursor = null;
        try {
            cursor = super.getAll(AnimalContract.AnimalEntry.TABLE_NAME,
                    null,
                    AnimalContract.AnimalEntry.IDESPECIE + " = ?",
                    new String[]{id},
                    null,
                    null,
                    null);

            if(cursor.moveToFirst()){
                @SuppressLint("Range") int idespecie = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.IDESPECIE));
                @SuppressLint("Range") String sexo = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.SEXO));
                @SuppressLint("Range") String continente = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.CONTINENTE));
                @SuppressLint("Range") int anionacimiento = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.ANIONACIMIENTO));
                @SuppressLint("Range") String pais = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.PAIS));
                animal = new Animal( idespecie, sexo, pais, continente, anionacimiento);
            }
        } catch (Exception exception) {
            // TODO: Se debe de implementar el trato de las exception
        }finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return animal;
    }

    public int delete(String id) {
        return super.delete(AnimalContract.AnimalEntry.TABLE_NAME,
                AnimalContract.AnimalEntry._ID + " = ?",
                new String[]{id});
    }

    public int update(Zoo zoo, String id) {
        return super.update(AnimalContract.AnimalEntry.TABLE_NAME,
                zoo.toContentValues(),
                AnimalContract.AnimalEntry._ID + " = ?",
                new String[]{id});
    }

}
