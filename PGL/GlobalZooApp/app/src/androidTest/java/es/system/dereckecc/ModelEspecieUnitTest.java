package es.system.dereckecc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.util.List;

import es.system.dereckecc.vo.Especie;
import es.system.dereckecc.vo.Zoo;

public class ModelEspecieUnitTest extends CommonUtilsTest{

    @Test
    public void findEspecieTest(){
        Zoo zooFind = zoosDbHelper.getById(zoo.getId());
        assertNotNull("El Zoo encontrado es null", zooFind);
        assertEquals("El objeto almacenado y encontrado no son iguales",zooFind, zoo);
    }
    @Test
    public void findEspeciesTest(){
        List<Especie> especies = especieDbHelper.getAll();
        assertNotNull("El numero de usuarios encontrado es menor de 1", especies.size() < 1);
        assertEquals("El objeto almacenado y encontrado no son iguales",especies.get(0), especie);
    }
}
