package es.iespuerto.dc.model.contract;

import android.provider.BaseColumns;

import java.util.Date;

public class AsistenciaContract {
    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME ="Asistencia";
        public static final String IDASISTENCIA = "id_asistencia";
        public static final String IDCOLABORADOR = "id_Colaborador";
        public static final String IDALUMNO = "id_alumno";
        public static final String FECHA = "fecha";
        public static final String TIPOASISTENCIA = "tipo_asistencia";
    }
}
