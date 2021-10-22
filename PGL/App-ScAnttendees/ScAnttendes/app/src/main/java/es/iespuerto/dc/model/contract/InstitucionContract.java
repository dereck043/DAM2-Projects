package es.iespuerto.dc.model.contract;

import android.provider.BaseColumns;

public class InstitucionContract {
    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME ="Institucion";
        public static final String IDINSTITUCION = "id_institucion";
        public static final String CODIGOPOSTAL = "codigo_postal";
        public static final String TELEFONO = "telefono";
        public static final String EMAIL = "email";
        public static final String NOMBRE = "nombre";
        public static final String NOMBREUSUARIO = "nombre_usuario";
        public static final String DIRECCION = "direccion";
        public static final String CLAVE = "clave";
    }
}
