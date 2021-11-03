package es.system.dereckecc.vo;

import android.content.ContentValues;

import es.system.dereckecc.model.interface1.IEspecie;
import es.system.dereckecc.model.contracts.EspecieContract;

public class Especie implements IEspecie {
    String nombreVulgar, nombreCientifico, familia;
    int id;
    boolean peligroExtincion;

    public Especie(String nombreVulgar, String nombreCientifico, String familia, boolean peligroExtincion) {
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
    public boolean isPeligroExtincion() {
        return peligroExtincion;
    }

    @Override
    public void setPeligroExtincion(boolean peligroExtincion) {
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
}
