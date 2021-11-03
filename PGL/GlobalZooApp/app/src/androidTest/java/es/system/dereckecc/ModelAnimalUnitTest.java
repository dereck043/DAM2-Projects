package es.system.dereckecc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.util.List;

import es.system.dereckecc.model.contracts.AnimalContract;
import es.system.dereckecc.model.helpers.AnimalDbHelper;
import es.system.dereckecc.vo.Animal;
import es.system.dereckecc.vo.Zoo;

public class ModelAnimalUnitTest extends CommonUtilsTest{

    @Test
    public void findAnimalTest(){
        Animal animalFind = animalDbHelper.getById(String.valueOf(animal.getId()));
        assertNotNull("El Zoo encontrado es null", animalFind);
        assertEquals("El objeto almacenado y encontrado no son iguales",animalFind, animal);
    }
    @Test
    public void findAnimalsTest(){
        List<Animal> animales = animalDbHelper.getAll();
        assertNotNull("El numero de usuarios encontrado es menor de 1", animales.size() < 1);
        assertEquals("El objeto almacenado y encontrado no son iguales",animales.get(0), animal);
    }
}
