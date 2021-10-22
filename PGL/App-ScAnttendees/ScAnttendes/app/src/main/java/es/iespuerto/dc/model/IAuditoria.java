package es.iespuerto.dc.model;

public interface IAuditoria {
    int getIdAuditoria();
    void setIdAuditoria(int idAuditoria);
    String getAccion();
    void setAccion(String accion);
    String getDescripcion();
    void setDescripcion(String descripcion);
    String getTabla();
    void setTabla(String tabla);
    String getUsuario();
    void setUsuario(String usuario);
    String getFecha();
    void setFecha(String fecha);
}
