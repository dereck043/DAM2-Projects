package es.iespuerto.dc.model;

import java.util.Date;

public class Alumno implements IAlumno{
    private int idAlumno, idTutor, idTipoMensaje, telefono, codigoPostal;
    private String nombre, apellido, nombreUsuario, clave, email, direccion, curso, dni;
    private Date fechaNacimiento;
    private boolean notificacionActivada;

    public Alumno(int idTutor, int idTipoMensaje, int telefono, int codigoPostal, String nombre, String apellido, String nombreUsuario, String clave, String email, String direccion, String curso, String dni, Date fechaNacimiento, boolean notificacionActivada) {
        this.idTutor = idTutor;
        this.idTipoMensaje = idTipoMensaje;
        this.telefono = telefono;
        this.codigoPostal = codigoPostal;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.email = email;
        this.direccion = direccion;
        this.curso = curso;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.notificacionActivada = notificacionActivada;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public int getIdTipoMensaje() {
        return idTipoMensaje;
    }

    public void setIdTipoMensaje(int idTipoMensaje) {
        this.idTipoMensaje = idTipoMensaje;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getNombreUsuario() { return nombreUsuario; }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isNotificacionActivada() {
        return notificacionActivada;
    }

    public void setNotificacionActivada(boolean notificacionActivada) {
        this.notificacionActivada = notificacionActivada;
    }
}
