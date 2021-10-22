package es.iespuerto.dc.model.contract;

import android.provider.BaseColumns;

public class TutorContract {
    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME ="Tutor";
        public static final String IDTUTOR = "id_tutor";
        public static final String TELEFONO = "telefono";
        public static final String CODIGOPOSTAL = "codigoPostal";
        public static final String NOMBRE = "nombre";
        public static final String APELLIDO = "apellido";
        public static final String EMAIL = "email";
        public static final String DIRECCION = "direccion";
        public static final String DNI = "dni";
    }
}
