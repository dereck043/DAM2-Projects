/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author dereck
 */
public class tarea implements Serializable{
    
    String nombre;
    Date fecha;
    String realizado;

    public tarea(String nombre, Date fecha, String realizado) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.realizado = realizado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRealizado() {
        return realizado;
    }

    public void setRealizado(String realizado) {
        this.realizado = realizado;
    }
    
    
}
