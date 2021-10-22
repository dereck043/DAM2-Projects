package es.iespuerto.dc.model;

import java.util.Date;

public interface IAlumno {
    int getIdAlumno();
    int getIdTutor();
    void setIdTutor(int idTutor);
    int getIdTipoMensaje();
    void setIdTipoMensaje(int idTipoMensaje);
    int getTelefono();
    void setTelefono(int telefono);
    int getCodigoPostal();
    void setCodigoPostal(int codigoPostal);
    String getNombre();
    void setNombre(String nombre);
    String getApellido();
    void setApellido(String apellido);
    String getNombreUsuario();
    void setNombreUsuario(String nombreUsuario);
    String getClave();
    void setClave(String clave);
    String getEmail();
    void setEmail(String email);
    String getDireccion();
    void setDireccion(String direccion);
    String getCurso();
    void setCurso(String curso);
    String getDni();
    void setDni(String dni);
    Date getFechaNacimiento();
    void setFechaNacimiento(Date fechaNacimiento);
    boolean isNotificacionActivada();
    void setNotificacionActivada(boolean notificacionActivada);

}
