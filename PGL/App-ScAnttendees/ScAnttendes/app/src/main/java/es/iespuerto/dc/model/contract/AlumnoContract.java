package es.iespuerto.dc.model.contract;
import android.provider.BaseColumns;

import java.util.Date;

public class AlumnoContract {
    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME ="Alumno";
        public static final String IDALUMNO = "id_alumno";
        public static final String IDTUTOR = "descripcion";
        public static final String IDTIPOMENSAJE = "descripcion";
        public static final String TELEFONO = "telefono";
        public static final String CODIGOPOSTAL = "codigo_postal";
        public static final String NOMBRE = "nombre";
        public static final String APELLIDO = "apellido";
        public static final String NOMBREUSUARIO = "nombre_usuario";
        public static final String CLAVE = "clave";
        public static final String EMAIL = "email";
        public static final String DIRECCION = "direccion";
        public static final String CURSO = "curso";
        public static final String DNI = "dni";
        public static final String FECHANACIMIENTO = "fecha_nacimiento";
        public static final String NOTIFICACIONACTIVADA = "notificacion_activada";
    }
}
