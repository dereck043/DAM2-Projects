package es.iespuerto.dc.model;

import android.content.ContentValues;

import es.iespuerto.dc.controller.gestorUsuariosController;
import es.iespuerto.dc.model.contract.InstitucionContract;

public class Institucion implements IInstitucion {
    gestorUsuariosController commonContUsers;
    private int idInstitucion;
    private int codigoPostal;
    private int telefono;
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

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(InstitucionContract.UserEntry.CODIGOPOSTAL, codigoPostal);
        values.put(InstitucionContract.UserEntry.TELEFONO, telefono);
        values.put(InstitucionContract.UserEntry.NOMBRE, nombre);
        values.put(InstitucionContract.UserEntry.NOMBREUSUARIO, nombreUsuario);
        values.put(InstitucionContract.UserEntry.DIRECCION, direccion);
        values.put(InstitucionContract.UserEntry.CLAVE, clave);
        return values;
    }

}
