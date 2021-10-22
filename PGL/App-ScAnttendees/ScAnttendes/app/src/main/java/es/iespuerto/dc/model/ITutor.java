package es.iespuerto.dc.model;

public interface ITutor {
    int getIdTutor();
    int getTelefono();
    void setTelefono(int telefono);
    int getCodigoPostal();
    void setCodigoPostal(int codigoPostal);
    String getNombre();
    void setNombre(String nombre);
    String getApellido();
    void setApellido(String apellido);
    String getEmail();
    void setEmail(String email);
    String getDireccion();
    void setDireccion(String direccion);
    String getDni();
    void setDni(String dni);
}
