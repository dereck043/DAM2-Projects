package es.iespuerto.dc.model;

public class TipoMensaje implements ITipoMensaje{
    private int idTipoMensaje;
    private int descripcion;

    public TipoMensaje() {
    }

    public int getIdTipoMensaje() {
        return idTipoMensaje;
    }

    public int getDescripcion() {
        return descripcion;
    }
}
