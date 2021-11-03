package es.system.dereckecc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import es.system.dereckecc.model.helpers.ZooDbHelper;
import es.system.dereckecc.vo.Zoo;

public class ModelZooUnitTest extends CommonUtilsTest{

    @Before
    public void setUp(){
        zoo = new Zoo(123, "zooDC", "afganistan", "St. Cruz", 879,900);
    }

    @Test
    public void findZooTest(){
        zoosDbHelper.save(zoo);
        Zoo zooFind = zoosDbHelper.getById(zoo.getId());
        assertNotNull("El Zoo encontrado es null", zooFind);
        assertEquals("El objeto almacenado y encontrado no son iguales",zooFind, zoo);
    }
    @Test
    public void findZoosTest(){
        zoosDbHelper.save(zoo);
        List<Zoo> zoos = zoosDbHelper.getAll();
        assertNotNull("El numero de Zoos encontrado es 0", zoos.size() < 1);
        assertEquals("El objeto almacenado y encontrado no son iguales",zoos.get(0), zoo);
    }

    @Test
    public void deleteZooTest(){
        zoosDbHelper.save(zoo);
        int idEliminado = zoo.getId();
        zoosDbHelper.delete(idEliminado);
        assertEquals("El objeto sigue almacenado", zoosDbHelper.getById(idEliminado), null);
    }

    @After
    public void cleanRecordsPerTest(){
        zoosDbHelper.onUpgrade(zoosDbHelper.getWritableDatabase(), 1, 2);
    }

}
