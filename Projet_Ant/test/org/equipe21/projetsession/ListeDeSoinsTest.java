package org.equipe21.projetsession;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ListeDeSoinsTest {
    
    
    public ListeDeSoinsTest() {
    }
    

    @BeforeClass
    public static void setUpClass() {
    }
    

    @AfterClass
    public static void tearDownClass() {
    }
    

    @Before
    public void setUp() {
    }
    

    @After
    public void tearDown() {
    }


    @Test
    public void testGetListeDeSoins() {
        ListeDeSoins instance = new ListeDeSoins();
        List<Soin> result = instance.getListeDeSoins();
        assertEquals(new Dollar("250.00$"), result.get(1).getMaximumMensuel());
        assertEquals(new Dollar("200.00$"), result.get(3).getMaximumMensuel());
        assertEquals(new Dollar("250.00$"), result.get(4).getMaximumMensuel());
        assertEquals(new Dollar("150.00$"), result.get(7).getMaximumMensuel());
        assertEquals(new Dollar("300.00$"), result.get(8).getMaximumMensuel());
    }


    @Test
    public void testGetSoinSelonCategorie() {
        String categorie = "Physiothérapie";
        ListeDeSoins instance = new ListeDeSoins();
        Soin result = instance.getSoinSelonCategorie(categorie);
        assertEquals(categorie, result.getCategorie());
    }


    @Test
    public void testGetSoinParNumero() {
        Integer numeroSoin = 303;
        ListeDeSoins instance = new ListeDeSoins();
        Soin result = instance.getSoinParNumero(numeroSoin);
        assertEquals(numeroSoin, result.getNumeros().get(3));
    }


    @Test
    public void testIsSoinAdmisible() {
        Integer numeroSoin = 200;
        ListeDeSoins instance = new ListeDeSoins();
        assertEquals(true, instance.isSoinAdmisible(numeroSoin));
    }
    
    
    @Test
    public void testIsSoinAdmisibleEchec() {
        Integer numeroSoin = 202;
        ListeDeSoins instance = new ListeDeSoins();
        assertEquals(false,  instance.isSoinAdmisible(numeroSoin));
    }

}
