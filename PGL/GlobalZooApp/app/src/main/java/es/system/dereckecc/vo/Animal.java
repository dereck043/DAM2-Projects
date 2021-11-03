package es.system.dereckecc.vo;

import android.content.ContentValues;

import java.util.Objects;

import es.system.dereckecc.model.interface1.IAnimal;
import es.system.dereckecc.model.contracts.AnimalContract;

public class Animal implements IAnimal {
    int id, idEspecie, anionacimiento;
    String sexo, pais, continente;

    public Animal() {
    }

    public Animal(int idEspecie, String sexo, String pais, String continente, int anionacimiento) {
        this.idEspecie = idEspecie;
        this.sexo = sexo;
        this.pais = pais;
        this.continente = continente;
        this.anionacimiento = anionacimiento;
    }

    public Animal(int id, int idEspecie, String sexo, String pais, String continente, int anionacimiento) {
        this.id = id;
        this.idEspecie = idEspecie;
        this.sexo = sexo;
        this.pais = pais;
        this.continente = continente;
        this.anionacimiento = anionacimiento;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public int getIdEspecie() {
        return idEspecie;
    }

    @Override
    public void setIdEspecie(int idZoo) {
        this.idEspecie = idZoo;
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
    public int getNacimiento() {
        return anionacimiento;
    }

    @Override
    public void setNacimiento(int nacimiento) {
        this.anionacimiento = nacimiento;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(AnimalContract.AnimalEntry.IDESPECIE, idEspecie);
        values.put(AnimalContract.AnimalEntry.SEXO, sexo);
        values.put(AnimalContract.AnimalEntry.PAIS, pais);
        values.put(AnimalContract.AnimalEntry.CONTINENTE, continente);
        values.put(AnimalContract.AnimalEntry.ANIONACIMIENTO, anionacimiento);
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(idEspecie, animal.idEspecie)
                && Objects.equals(sexo, animal.sexo)
                && Objects.equals(pais, animal.pais)
                && Objects.equals(continente, animal.continente)
                && Objects.equals(anionacimiento, animal.anionacimiento);
    }
}
