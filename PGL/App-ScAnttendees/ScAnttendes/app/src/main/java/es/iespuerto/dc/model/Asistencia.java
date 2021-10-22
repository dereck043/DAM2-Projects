package es.iespuerto.dc.model;

import java.util.Date;

public class Asistencia implements IAsistencia{
    private int idAsistencia, idColaborador, idAlumno;
    private Date fecha;
    private String tipoAsistencia;

    public Asistencia(int idColaborador, int idAlumno, Date fecha, String tipoAsistencia) {
        this.idColaborador = idColaborador;
        this.idAlumno = idAlumno;
        this.fecha = fecha;
        this.tipoAsistencia = tipoAsistencia;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoAsistencia() {
        return tipoAsistencia;
    }

    public void setTipoAsistencia(String tipoAsistencia) {
        this.tipoAsistencia = tipoAsistencia;
    }
}
