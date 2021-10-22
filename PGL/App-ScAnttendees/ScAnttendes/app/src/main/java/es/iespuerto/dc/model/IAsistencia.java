package es.iespuerto.dc.model;

import java.util.Date;

public interface IAsistencia {
    int getIdAsistencia();
    int getIdColaborador();
    void setIdColaborador(int idColaborador);
    int getIdAlumno();
    void setIdAlumno(int idAlumno);
    Date getFecha();
    void setFecha(Date fecha);
    String getTipoAsistencia();
    void setTipoAsistencia(String tipoAsistencia);
}
