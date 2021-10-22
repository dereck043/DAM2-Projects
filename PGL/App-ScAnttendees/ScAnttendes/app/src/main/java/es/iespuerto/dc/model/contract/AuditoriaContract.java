package es.iespuerto.dc.model.contract;

import android.provider.BaseColumns;

public class AuditoriaContract {
    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME ="Auditoria";
        public static final String IDAUDITORIA = "id_auditoria";
        public static final String ACCION = "accion";
        public static final String DESCRIPCION = "descripcion";
        public static final String TABLA = "tabla";
        public static final String USUARIO = "usuario";
        public static final String FECHA = "fecha";
    }
}
