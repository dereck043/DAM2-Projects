package es.system.dereckecc.model;

import android.content.ContentValues;

import es.system.dereckecc.model.contracts.ZooContract;

public class Zoo implements IZoo {
    String nombre, pais, ciudad;
    int id, dimensiones, presupuestoAnual;

    public Zoo(String nombre, String pais, String ciudad, int dimensiones, int presupuestoAnual) {
        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
        this.dimensiones = dimensiones;
        this.presupuestoAnual = presupuestoAnual;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getPais() {
        return pais;
    }

    @Override
    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String getCiudad() {
        return ciudad;
    }

    @Override
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getDimensiones() {
        return dimensiones;
    }

    @Override
    public void setDimensiones(int dimensiones) {
        this.dimensiones = dimensiones;
    }

    @Override
    public int getPresupuestoAnual() {
        return presupuestoAnual;
    }

    @Override
    public void setPresupuestoAnual(int presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ZooContract.UserEntry.CIUDAD, ciudad);
        values.put(ZooContract.UserEntry.PAIS, pais);
        values.put(ZooContract.UserEntry.NOMBRE, nombre);
        values.put(ZooContract.UserEntry.DIMENSIONES, dimensiones);
        values.put(ZooContract.UserEntry.PRESUPUESTOANUAL, presupuestoAnual);
        return values;
    }
}
