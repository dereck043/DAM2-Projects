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
import es.system.dereckecc.model.Especie;
import es.system.dereckecc.model.contracts.AnimalContract;
import es.system.dereckecc.model.contracts.EspecieContract;

public class EspecieDbHelper extends ComunDbHelper{
    public EspecieDbHelper(Context context) {
        super(context);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + EspecieContract.UserEntry.TABLE_NAME + " ("
                + EspecieContract.UserEntry.IDESPECIE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + EspecieContract.UserEntry.NOMBREVULGAR + "TEXT NOT NULL, "
                + EspecieContract.UserEntry.NOMBRECIENTIFICO + "TEXT NOT NULL, "
                + EspecieContract.UserEntry.FAMILIA + " TEXT NOT NULL,"
                + EspecieContract.UserEntry.PELIGROEXTINCION + " BOOLEAN NOT NULL)"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public long save(Especie especie) {
        return super.save(EspecieContract.UserEntry.TABLE_NAME,
                especie.toContentValues());
    }

    public List<Especie> getAll() {
        List<Especie> especies = null;
        Cursor cursor = null;

        try {
            cursor = super.getAll(EspecieContract.UserEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                especies = new ArrayList<>();
                do {
                    @SuppressLint("Range") String nombreVulgar = cursor.getString(cursor.getColumnIndex(EspecieContract.UserEntry.NOMBREVULGAR));
                    @SuppressLint("Range") String nombreCientifico = cursor.getString(cursor.getColumnIndex(EspecieContract.UserEntry.NOMBRECIENTIFICO));
                    @SuppressLint("Range") String familia = cursor.getString(cursor.getColumnIndex(EspecieContract.UserEntry.FAMILIA));
                    @SuppressLint("Range") boolean peligroExtincion = (cursor.getInt(cursor.getColumnIndex(EspecieContract.UserEntry.PELIGROEXTINCION))>0);
                    Especie especie = new Especie( nombreVulgar, nombreCientifico, familia, peligroExtincion);
                    especies.add(especie);
                } while (cursor.moveToNext());
                return especies;
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
