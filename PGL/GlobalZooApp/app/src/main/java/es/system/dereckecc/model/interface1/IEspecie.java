package es.system.dereckecc.model.interface1;

public interface IEspecie {

    String getNombreVulgar();

    void setNombreVulgar(String nombreVulgar);

    String getNombreCientifico();

    void setNombreCientifico(String nombreCientifico);

    String getFamilia();

    void setFamilia(String familia);

    void setId(int id);

    int getId();

    int isPeligroExtincion();

    void setPeligroExtincion(int peligroExtincion);
}
