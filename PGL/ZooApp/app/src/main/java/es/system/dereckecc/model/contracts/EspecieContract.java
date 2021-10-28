package es.system.dereckecc.model.contracts;

import android.provider.BaseColumns;

public class EspecieContract {
    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME ="especie";
        public static final String IDESPECIE = "id_especie";
        public static final String NOMBREVULGAR = "nombre_vulgar";
        public static final String NOMBRECIENTIFICO = "nombre_cientifico";
        public static final String FAMILIA = "familia";
        public static final String PELIGROEXTINCION = "peligro_extincion";
    }
}
