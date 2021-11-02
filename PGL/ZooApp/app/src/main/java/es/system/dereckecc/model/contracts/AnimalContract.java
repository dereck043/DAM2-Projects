package es.system.dereckecc.model.contracts;

import android.provider.BaseColumns;

public class AnimalContract {
    public static abstract class AnimalEntry implements BaseColumns {
        public static final String TABLE_NAME ="animal";
        public static final String IDANIMAL = "id_animal";
        public static final String IDESPECIE = "id_especie";
        public static final String SEXO = "sexo";
        public static final String PAIS = "pais";
        public static final String CONTINENTE = "peligro_extincion";
        public static final String ANIONACIMIENTO = "nacimiento";
    }
}
