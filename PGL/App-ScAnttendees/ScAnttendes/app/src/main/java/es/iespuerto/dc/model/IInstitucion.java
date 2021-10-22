package es.iespuerto.dc.model;

public interface IInstitucion {
    int getIdInstitucion();
    int getCodigoPostal();
    void setCodigoPostal(int codigoPostal);
    int getTelefono();
    void setTelefono(int telefono);
    String getEmail();
    void setEmail(String email);
    String getNombre();
    void setNombre(String nombre);
    String getNombreUsuario();
    void setNombreUsuario(String nombreUsuario);
    String getDireccion();
    void setDireccion(String direccion);
    String getClave();
    void setClave(String clave);
}
