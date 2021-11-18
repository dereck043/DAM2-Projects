package es.system.dereckecc.vo;

import android.content.ContentValues;

import java.util.Objects;

import es.system.dereckecc.model.interface1.IZoo;
import es.system.dereckecc.model.contracts.ZooContract;

public class Zoo implements IZoo {
    String nombre, pais, ciudad;
    int id, dimensiones, presupuestoAnual;

    public Zoo() {
    }
    public Zoo(String nombre, String pais, String ciudad, int dimensiones, int presupuestoAnual) {
        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
        this.dimensiones = dimensiones;
        this.presupuestoAnual = presupuestoAnual;
    }
    public Zoo(int id, String nombre, String pais, String ciudad, int dimensiones, int presupuestoAnual) {
        this.id = id;
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
    public void setId(int id) {
        this.id = id;
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
        //values.put(ZooContract.ZooEntry.IDZOO, id);
        values.put(ZooContract.ZooEntry.NOMBRE, nombre);
        values.put(ZooContract.ZooEntry.PAIS, pais);
        values.put(ZooContract.ZooEntry.CIUDAD, ciudad);
        values.put(ZooContract.ZooEntry.DIMENSIONES, dimensiones);
        values.put(ZooContract.ZooEntry.PRESUPUESTOANUAL, presupuestoAnual);
        return values;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zoo zoo = (Zoo) o;
        return Objects.equals(nombre, zoo.nombre)
                && Objects.equals(ciudad, zoo.ciudad)
                && Objects.equals(pais, zoo.pais)
                && Objects.equals(dimensiones, zoo.dimensiones)
                && Objects.equals(presupuestoAnual, zoo.presupuestoAnual);
    }
}
