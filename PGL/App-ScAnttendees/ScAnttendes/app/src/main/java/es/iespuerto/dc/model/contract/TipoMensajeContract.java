package es.iespuerto.dc.model.contract;

import android.provider.BaseColumns;

public class TipoMensajeContract {
    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME ="TipoMensaje";
        public static final String IDTIPOMENSAJE = "id_tipoMensaje";
        public static final String DESCRIPCION = "descripcion";
    }
}
