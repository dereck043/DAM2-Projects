package es.system.dereckecc.model;

public interface IEspecie {
    String getNombreVulgar();

    void setNombreVulgar(String nombreVulgar);

    String getNombreCientifico();

    void setNombreCientifico(String nombreCientifico);

    String getFamilia();

    void setFamilia(String familia);

    int getId();

    boolean isPeligroExtincion();

    void setPeligroExtincion(boolean peligroExtincion);
}
