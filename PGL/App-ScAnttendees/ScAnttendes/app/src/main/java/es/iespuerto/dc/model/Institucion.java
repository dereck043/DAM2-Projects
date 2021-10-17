package es.iespuerto.dc.model;

import es.iespuerto.dc.controller.gestorUsuariosController;

public class Institucion {
    gestorUsuariosController commonContUsers;
    private int idInstitucion, codigoPostal, telefono;
    private String email, nombre, nombreUsuario, direccion, clave;

    public Institucion(int codigoPostal, int telefono, String email, String nombre, String nombreUsuario, String direccion, String clave) {
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
        this.email = email;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.direccion = direccion;
        this.clave = clave;
    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
