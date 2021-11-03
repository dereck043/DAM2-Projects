package es.system.dereckecc.model.contracts;

import android.provider.BaseColumns;

public class ZooContract {
    public static abstract class ZooEntry implements BaseColumns {
        public static final String TABLE_NAME ="zoo";
        public static final String IDZOO = "id_zoo";
        public static final String NOMBRE = "nombre";
        public static final String PAIS = "pais";
        public static final String CIUDAD = "ciudad";
        public static final String DIMENSIONES = "dimensiones";
        public static final String PRESUPUESTOANUAL = "presupuesto_anual";
    }
}
