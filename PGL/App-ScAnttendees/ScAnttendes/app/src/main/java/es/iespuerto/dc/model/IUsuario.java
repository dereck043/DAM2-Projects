package es.iespuerto.dc.model;

public interface IUsuario {
    int getIdUsuario();
    int getIdInstitucion();
    void setIdInstitucion(int idInstitucion);
    public int getTelefono();
    void setTelefono(int telefono);
    String getNombre();
    void setNombre(String nombre);
    String getNombreUsuario();
    void setNombreUsuario(String nombreUsuario);
    String getApellido();
    void setApellido(String apellido);
    String getEmail();
    public void setEmail(String email);
    String getClave();
    void setClave(String clave);
    String getDNI();
    void setDNI(String DNI);
}
