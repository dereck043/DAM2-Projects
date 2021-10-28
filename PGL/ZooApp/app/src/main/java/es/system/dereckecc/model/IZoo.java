package es.system.dereckecc.model;

public interface IZoo {
    String getNombre();

    void setNombre(String nombre);

    String getPais();

    void setPais(String pais);

    String getCiudad();

    void setCiudad(String ciudad);

    int getId();

    int getDimensiones();

    void setDimensiones(int dimensiones);

    int getPresupuestoAnual();

    void setPresupuestoAnual(int presupuestoAnual);
}
