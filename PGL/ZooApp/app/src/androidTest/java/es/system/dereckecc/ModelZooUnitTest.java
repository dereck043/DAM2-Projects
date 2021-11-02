package es.system.dereckecc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.util.List;

import es.system.dereckecc.vo.Zoo;

public class ModelZooUnitTest extends ComunUtilsTest{

    @Test
    public void findZooTest(){
        Zoo zooFind = zoosDbHelper.getById(String.valueOf(zoo.getId()));
        assertNotNull("El Zoo encontrado es null", zooFind);
        assertEquals("El objeto almacenado y encontrado no son iguales",zooFind, zoo);
    }
    @Test
    public void findZoosTest(){
        List<Zoo> zoos = zoosDbHelper.getAll();
        assertNotNull("El numero de usuarios encontrado es menor de 1", zoos.size() < 1);
        assertEquals("El objeto almacenado y encontrado no son iguales",zoos.get(0), zoo);
    }
}
