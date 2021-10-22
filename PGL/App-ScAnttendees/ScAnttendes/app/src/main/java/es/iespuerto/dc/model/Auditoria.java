package es.iespuerto.dc.model;

public class Auditoria implements IAuditoria{
    private int idAuditoria;
    private String accion, descripcion, tabla, usuario;
    private String fecha;

    public Auditoria(int idAuditoria, String accion, String descripcion, String tabla, String usuario, String fecha) {
        this.idAuditoria = idAuditoria;
        this.accion = accion;
        this.descripcion = descripcion;
        this.tabla = tabla;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public int getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(int idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
