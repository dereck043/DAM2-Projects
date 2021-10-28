package es.system.dereckecc.model;

import android.content.ContentValues;

import java.sql.Date;

public class Animal implements IAnimal {
    int id, idZoo;
    String sexo, pais, continente;
    Date nacimiento;

    public Animal(int idZoo, String sexo, String pais, String continente, Date nacimiento) {
        this.idZoo = idZoo;
        this.sexo = sexo;
        this.pais = pais;
        this.continente = continente;
        this.nacimiento = nacimiento;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getIdZoo() {
        return idZoo;
    }

    @Override
    public void setIdZoo(int idZoo) {
        this.idZoo = idZoo;
    }

    @Override
    public String getSexo() {
        return sexo;
    }

    @Override
    public void setSexo(String sexo) {
        this.sexo = sexo;
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
    public String getContinente() {
        return continente;
    }

    @Override
    public void setContinente(String continente) {
        this.continente = continente;
    }

    @Override
    public Date getNacimiento() {
        return nacimiento;
    }

    @Override
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public ContentValues toContentValues() {
        return null;
    }
}
