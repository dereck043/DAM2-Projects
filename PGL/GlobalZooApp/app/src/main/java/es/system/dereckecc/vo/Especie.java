package es.system.dereckecc.vo;

import android.content.ContentValues;

import java.util.Objects;

import es.system.dereckecc.model.interface1.IEspecie;
import es.system.dereckecc.model.contracts.EspecieContract;

public class Especie implements IEspecie {
    String nombreVulgar, nombreCientifico, familia;
    int id, peligroExtincion;

    public Especie() {
    }

    public Especie(String nombreVulgar, String nombreCientifico, String familia, int peligroExtincion) {
        this.nombreVulgar = nombreVulgar;
        this.nombreCientifico = nombreCientifico;
        this.familia = familia;
        this.peligroExtincion = peligroExtincion;
    }

    public Especie(int id, String nombreVulgar, String nombreCientifico, String familia, int peligroExtincion) {
        this.id = id;
        this.nombreVulgar = nombreVulgar;
        this.nombreCientifico = nombreCientifico;
        this.familia = familia;
        this.peligroExtincion = peligroExtincion;
    }

    @Override
    public String getNombreVulgar() {
        return nombreVulgar;
    }

    @Override
    public void setNombreVulgar(String nombreVulgar) {
        this.nombreVulgar = nombreVulgar;
    }

    @Override
    public String getNombreCientifico() {
        return nombreCientifico;
    }

    @Override
    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    @Override
    public String getFamilia() {
        return familia;
    }

    @Override
    public void setFamilia(String familia) {
        this.familia = familia;
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
    public int isPeligroExtincion() {
        return peligroExtincion;
    }

    @Override
    public void setPeligroExtincion(int peligroExtincion) {
        this.peligroExtincion = peligroExtincion;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(EspecieContract.EspecieEntry.NOMBREVULGAR, nombreVulgar);
        values.put(EspecieContract.EspecieEntry.NOMBRECIENTIFICO, nombreCientifico);
        values.put(EspecieContract.EspecieEntry.FAMILIA, familia);
        values.put(EspecieContract.EspecieEntry.PELIGROEXTINCION, peligroExtincion);
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especie especie = (Especie) o;
        return Objects.equals(nombreVulgar, especie.nombreVulgar)
                && Objects.equals(nombreCientifico, especie.nombreCientifico)
                && Objects.equals(familia, especie.familia)
                && Objects.equals(peligroExtincion, especie.peligroExtincion);
    }
}
