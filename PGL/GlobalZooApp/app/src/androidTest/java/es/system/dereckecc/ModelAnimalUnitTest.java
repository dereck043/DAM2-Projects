package es.system.dereckecc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import es.system.dereckecc.model.contracts.AnimalContract;
import es.system.dereckecc.model.helpers.AnimalDbHelper;
import es.system.dereckecc.vo.Animal;
import es.system.dereckecc.vo.Especie;
import es.system.dereckecc.vo.Zoo;

public class ModelAnimalUnitTest extends CommonUtilsTest{

    @Before
    public void setUp(){
        animal = new Animal(1,1, "macho", "Finlandia", "Europa", 1800);
    }

    @Test
    public void findAnimalTest(){
        animalDbHelper.save(animal);
        Animal animalFind = animalDbHelper.getById(animal.getId());
        assertNotNull("El Animal encontrado es null", animalFind);
        assertEquals("El objeto almacenado y encontrado no son iguales",animalFind, animal);
    }
    @Test
    public void findAnimalsTest(){
        animalDbHelper.save(animal);
        List<Animal> animales = animalDbHelper.getAll();
        assertNotNull("El numero de animales encontrado es 0", animales.size() < 1);
        assertEquals("El objeto almacenado y encontrado no son iguales",animales.get(0), animal);
    }

    @Test
    public void deleteAnimalTest(){
        animalDbHelper.save(animal);
        int idEliminado = animal.getId();
        animalDbHelper.delete(idEliminado);
        assertEquals("El objeto sigue almacenado", animalDbHelper.getById(idEliminado), null);
    }

    @After
    public void cleanRecordsPerTest(){
        animalDbHelper.onUpgrade(animalDbHelper.getWritableDatabase(), 1, 2);
    }
}
