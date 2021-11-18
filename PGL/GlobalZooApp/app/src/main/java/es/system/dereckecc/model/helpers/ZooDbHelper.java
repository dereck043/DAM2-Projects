package es.system.dereckecc.model.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.system.dereckecc.vo.Zoo;
import es.system.dereckecc.model.contracts.ZooContract;

public class ZooDbHelper extends ComunDbHelper {
    public ZooDbHelper(Context context) {
        super(context);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + ZooContract.ZooEntry.TABLE_NAME + " ( "
                + ZooContract.ZooEntry.IDZOO + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + ZooContract.ZooEntry.NOMBRE + " TEXT NOT NULL , "
                + ZooContract.ZooEntry.PAIS + " TEXT NOT NULL , "
                + ZooContract.ZooEntry.CIUDAD + " TEXT NOT NULL , "
                + ZooContract.ZooEntry.DIMENSIONES + " INTEGER NOT NULL , "
                + ZooContract.ZooEntry.PRESUPUESTOANUAL + " INTEGER NOT NULL ) "
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ZooContract.ZooEntry.TABLE_NAME );
        onCreate(sqLiteDatabase);
    }

    public long save(Zoo zoo) {
        return super.save(ZooContract.ZooEntry.TABLE_NAME,
                zoo.toContentValues());
    }

    public List<Zoo> getAll() {
        List<Zoo> zoo = null;
        Cursor cursor = null;

        try {
            cursor = super.getAll(ZooContract.ZooEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                zoo = new ArrayList<>();
                do {
                    @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(ZooContract.ZooEntry.IDZOO));
                    @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.NOMBRE));
                    @SuppressLint("Range") int dimensiones = cursor.getInt(cursor.getColumnIndex(ZooContract.ZooEntry.DIMENSIONES));
                    @SuppressLint("Range") String ciudad = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.CIUDAD));
                    @SuppressLint("Range") String pais = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.PAIS));
                    @SuppressLint("Range") int presupuestoAnual = cursor.getInt(cursor.getColumnIndex(ZooContract.ZooEntry.PRESUPUESTOANUAL));
                    Zoo zooEntries = new Zoo( id, nombre, pais, ciudad, dimensiones, presupuestoAnual);
                    zoo.add(zooEntries);
                } while (cursor.moveToNext());
                return zoo;
            }
        } catch (Exception exception) {}

        finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return Collections.emptyList();

    }

    /**
     *
     * @param id
     * @return
     */
    public Zoo getById(int id) {
        Zoo zoo = null;
        Cursor cursor = null;
        try {
            cursor = super.getAll(ZooContract.ZooEntry.TABLE_NAME,
                    null,
                    ZooContract.ZooEntry.IDZOO + " = ?",
                    new String[]{id+""},
                    null,
                    null,
                    null);

            if(cursor.moveToFirst()){
                @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.NOMBRE));
                @SuppressLint("Range") int dimensiones = cursor.getInt(cursor.getColumnIndex(ZooContract.ZooEntry.DIMENSIONES));
                @SuppressLint("Range") String ciudad = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.CIUDAD));
                @SuppressLint("Range") String pais = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.PAIS));
                @SuppressLint("Range") int presupuestoAnual = cursor.getInt(cursor.getColumnIndex(ZooContract.ZooEntry.PRESUPUESTOANUAL));
                zoo = new Zoo( nombre, pais, ciudad, dimensiones, presupuestoAnual);
            }
        } catch (Exception exception) {
            // TODO: Se debe de implementar el trato de las exception
        }finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return zoo;
    }


    public int delete(int id) {
        return super.delete(ZooContract.ZooEntry.TABLE_NAME,
                ZooContract.ZooEntry.IDZOO + " = ?",
                new String[]{id+""});
    }

    public int update(Zoo zoo, int id) {
        return super.update(ZooContract.ZooEntry.TABLE_NAME,
                zoo.toContentValues(),
                ZooContract.ZooEntry.IDZOO + " = ?",
                new String[]{id+""});
    }

}
