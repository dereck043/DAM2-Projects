package es.iespuerto.dc.model.contract;

import android.provider.BaseColumns;

public class UsuarioContract {
    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME ="Tutor";
        public static final String IDUSUARIO = "id_usuario";
        public static final String IDINSTITUCION = "id_institucion";
        public static final String TELEFONO = "telefono";
        public static final String NOMBRE = "nombre";
        public static final String NOMBREUSUARIO = "nombreUsuario";
        public static final String APELLIDO = "apellido";
        public static final String EMAIL = "email";
        public static final String CLAVE = "clave";
        public static final String DNI = "DNI";
    }
}
