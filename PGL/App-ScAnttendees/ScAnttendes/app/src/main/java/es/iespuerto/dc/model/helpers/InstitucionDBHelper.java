package es.iespuerto.dc.model.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.iespuerto.dc.model.Institucion;
import es.iespuerto.dc.model.Usuario;
import es.iespuerto.dc.model.contract.InstitucionContract;

public class InstitucionDBHelper extends ComunDBHelper {
    public InstitucionDBHelper(Context context) {
        super(context);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + InstitucionContract.UserEntry.TABLE_NAME + " ("
                + InstitucionContract.UserEntry.IDINSTITUCION + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + InstitucionContract.UserEntry.CODIGOPOSTAL + "TEXT NOT NULL, "
                + InstitucionContract.UserEntry.TELEFONO + "INTEGER NOT NULL, "
                + InstitucionContract.UserEntry.CLAVE + " TEXT NOT NULL,"
                + InstitucionContract.UserEntry.NOMBRE + " TEXT NOT NULL,"
                + InstitucionContract.UserEntry.NOMBREUSUARIO + " TEXT NOT NULL,"
                + InstitucionContract.UserEntry.DIRECCION + " TEXT NOT NULL,"
                + InstitucionContract.UserEntry.CLAVE + " TEXT NOT NULL,"
                + "UNIQUE (" + InstitucionContract.UserEntry.EMAIL + "))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public long save(Institucion institucion) {
        return super.save(InstitucionContract.UserEntry.TABLE_NAME,
                institucion.toContentValues());
    }

    public List<Institucion> getAll() {
        List<Institucion> institucion = null;
        Cursor cursor = null;


        try {
            cursor = super.getAll(InstitucionContract.UserEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                institucion = new ArrayList<>();
                do {
                    @SuppressLint("Range") String codigoPostal = cursor.getString(cursor.getColumnIndex(InstitucionContract.UserEntry.CODIGOPOSTAL));
                    @SuppressLint("Range") String telefono = cursor.getString(cursor.getColumnIndex(InstitucionContract.UserEntry.TELEFONO));
                    @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(InstitucionContract.UserEntry.NOMBRE));
                    @SuppressLint("Range") String nombreUsuario = cursor.getString(cursor.getColumnIndex(InstitucionContract.UserEntry.NOMBREUSUARIO));
                    @SuppressLint("Range") String direccion = cursor.getString(cursor.getColumnIndex(InstitucionContract.UserEntry.DIRECCION));
                    @SuppressLint("Range") String clave = cursor.getString(cursor.getColumnIndex(InstitucionContract.UserEntry.CLAVE));
                    @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex(InstitucionContract.UserEntry.EMAIL));
                    Institucion user = new Institucion( Integer.parseInt(codigoPostal), Integer.parseInt(telefono), email, nombre, nombreUsuario, direccion, clave);
                    institucion.add(user);
                } while (cursor.moveToNext());
                return institucion;
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
