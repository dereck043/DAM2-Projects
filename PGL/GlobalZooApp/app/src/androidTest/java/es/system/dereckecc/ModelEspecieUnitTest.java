package es.system.dereckecc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import es.system.dereckecc.vo.Especie;
import es.system.dereckecc.vo.Zoo;

public class ModelEspecieUnitTest extends CommonUtilsTest{

    @Before
    public void setUp(){
        especie = new Especie(1,"jirafa", "jirafaCientifica", "jirafoides", 0);
    }

    @Test
    public void findEspecieTest(){
        especieDbHelper.save(especie);
        Especie especieFind = especieDbHelper.getById(especie.getId());
        System.out.println("ESPECIE: "+especieFind);
        System.out.println("ESPECIE2: "+especie);
        assertEquals("El objeto almacenado y encontrado no son iguales",especieFind, especie);
    }
    @Test
    public void findEspeciesTest(){
        especieDbHelper.save(especie);
        List<Especie> especies = especieDbHelper.getAll();
        assertNotNull("El numero de especies es menor 0", especies.size() < 1);
        assertEquals("El objeto almacenado y encontrado no son iguales",especies.get(0), especie);
    }

    @Test
    public void deleteEspecieTest(){
        especieDbHelper.save(especie);
        int idEliminado = especie.getId();
        especieDbHelper.delete(idEliminado);
        assertEquals("El objeto sigue almacenado", especieDbHelper.getById(idEliminado), null);
    }

    @After
    public void cleanRecordsPerTest(){
        especieDbHelper.onUpgrade(especieDbHelper.getWritableDatabase(), 1, 2);
    }

}
