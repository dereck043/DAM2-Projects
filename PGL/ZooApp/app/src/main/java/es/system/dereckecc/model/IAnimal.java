package es.system.dereckecc.model;

import java.sql.Date;

public interface IAnimal {
    int getId();

    int getIdZoo();

    void setIdZoo(int idZoo);

    String getSexo();

    void setSexo(String sexo);

    String getPais();

    void setPais(String pais);

    String getContinente();

    void setContinente(String continente);

    Date getNacimiento();

    void setNacimiento(Date nacimiento);
}
