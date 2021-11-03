package es.system.dereckecc.model.interface1;

import java.sql.Date;

public interface IAnimal {
    int getId();

    int getIdEspecie();

    void setIdEspecie(int idZoo);

    String getSexo();

    void setSexo(String sexo);

    String getPais();

    void setPais(String pais);

    String getContinente();

    void setContinente(String continente);

    int getNacimiento();

    void setNacimiento(int nacimiento);
}
