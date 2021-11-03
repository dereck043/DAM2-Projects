package es.system.dereckecc.model.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.system.dereckecc.model.contracts.ZooContract;
import es.system.dereckecc.vo.Especie;
import es.system.dereckecc.model.contracts.EspecieContract;

public class EspecieDbHelper extends ComunDbHelper{
    public EspecieDbHelper(Context context) {
        super(context);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + EspecieContract.EspecieEntry.TABLE_NAME + " ( "
                + EspecieContract.EspecieEntry.IDESPECIE + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + EspecieContract.EspecieEntry.NOMBREVULGAR + " TEXT NOT NULL , "
                + EspecieContract.EspecieEntry.NOMBRECIENTIFICO + " TEXT NOT NULL , "
                + EspecieContract.EspecieEntry.FAMILIA + " TEXT NOT NULL , "
                + EspecieContract.EspecieEntry.PELIGROEXTINCION + " INT NOT NULL ) "
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EspecieContract.EspecieEntry.TABLE_NAME );
        onCreate(sqLiteDatabase);
    }

    public long save(Especie especie) {
        return super.save(EspecieContract.EspecieEntry.TABLE_NAME,
                especie.toContentValues());
    }

    public List<Especie> getAll() {
        List<Especie> especies = null;
        Cursor cursor = null;

        try {
            cursor = super.getAll(EspecieContract.EspecieEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                especies = new ArrayList<>();
                do {
                    @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(EspecieContract.EspecieEntry.IDESPECIE));
                    @SuppressLint("Range") String nombreVulgar = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.NOMBREVULGAR));
                    @SuppressLint("Range") String nombreCientifico = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.NOMBRECIENTIFICO));
                    @SuppressLint("Range") String familia = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.FAMILIA));
                    @SuppressLint("Range") int peligroExtincion = cursor.getInt(cursor.getColumnIndex(EspecieContract.EspecieEntry.PELIGROEXTINCION));
                    Especie especie = new Especie(id, nombreVulgar, nombreCientifico, familia, peligroExtincion);
                    especies.add(especie);
                } while (cursor.moveToNext());
                return especies;
            }
        } catch (Exception exception) {}

        finally {
            if (cursor!=null){
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            }
        }

        return Collections.emptyList();

    }

    public Especie getById(int id) {
        Especie especie = null;
        Cursor cursor = null;
        try {
            cursor = super.getAll(EspecieContract.EspecieEntry.TABLE_NAME,
                    null,
                    EspecieContract.EspecieEntry.IDESPECIE + " = ?",
                    new String[]{id+""},
                    null,
                    null,
                    null);

            if(cursor.moveToFirst()){
                @SuppressLint("Range") int idESpecie = cursor.getInt(cursor.getColumnIndex(EspecieContract.EspecieEntry.IDESPECIE));
                @SuppressLint("Range") String nombreVulgar = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.NOMBREVULGAR));
                @SuppressLint("Range") String nombreCientifico = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.NOMBRECIENTIFICO));
                @SuppressLint("Range") String familia = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.FAMILIA));
                @SuppressLint("Range") int peligroExtincion = cursor.getInt(cursor.getColumnIndex(EspecieContract.EspecieEntry.PELIGROEXTINCION));
                especie = new Especie( idESpecie, nombreVulgar, nombreCientifico, familia, peligroExtincion);
            }
        } catch (Exception exception) {
            // TODO: Se debe de implementar el trato de las exception
        }finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return especie;
    }

    public int delete(int id) {
        return super.delete(EspecieContract.EspecieEntry.TABLE_NAME,
                EspecieContract.EspecieEntry.IDESPECIE + " = ?",
                new String[]{id+""});
    }

    public int update(Especie especie, int id) {
        return super.update(EspecieContract.EspecieEntry.TABLE_NAME,
                especie.toContentValues(),
                EspecieContract.EspecieEntry.IDESPECIE + " = ?",
                new String[]{id+""});
    }

}
