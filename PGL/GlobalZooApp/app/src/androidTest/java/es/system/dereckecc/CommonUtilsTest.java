package es.system.dereckecc;

import static org.junit.Assert.fail;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;

import es.system.dereckecc.model.helpers.AnimalDbHelper;
import es.system.dereckecc.model.helpers.EspecieDbHelper;
import es.system.dereckecc.model.helpers.ZooDbHelper;
import es.system.dereckecc.vo.Animal;
import es.system.dereckecc.vo.Especie;
import es.system.dereckecc.vo.Zoo;

public class CommonUtilsTest {

    static Context appContext = null;

    static Zoo zoo = null;
    static Especie especie = null;
    static Animal animal = null;

    static ZooDbHelper zoosDbHelper;
    static EspecieDbHelper especieDbHelper;
    static AnimalDbHelper animalDbHelper;

    @Before
    public void beforeClass() {
        try {
            appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

            zoosDbHelper = new ZooDbHelper(appContext);
            zoo = new Zoo(123, "zooDC", "afganistan", "St. Cruz", 879,900);
            zoosDbHelper.save(zoo);

            especieDbHelper = new EspecieDbHelper(appContext);
            especie = new Especie("jirafa", "jirafaCientifica", "jirafoides", false);
            especieDbHelper.save(especie);

            animalDbHelper = new AnimalDbHelper(appContext);
            animal = new Animal(1, "macho", "Finlandia", "Europa", 1800);
            animalDbHelper.save(animal);

        }catch (Exception ex) {
            fail("Se ha producido un error creando el elemento:"+ex.getMessage());
        }
    }

}
