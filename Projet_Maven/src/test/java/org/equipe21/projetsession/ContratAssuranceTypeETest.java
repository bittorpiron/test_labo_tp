package org.equipe21.projetsession;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContratAssuranceTypeETest {

    ContratAssurance instance = new ContratAssuranceTypeE();

    
    public ContratAssuranceTypeETest() {
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
    public void testRemplirTableIndemnitesSoin0() {
        assertTrue(instance.indemnites.get(0).getPourcentage() == 15);
        assertEquals(instance.indemnites.get(0).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin100() {
        assertTrue(instance.indemnites.get(100).getPourcentage() == 25);
        assertEquals(instance.indemnites.get(100).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin150() {
        assertTrue(instance.indemnites.get(150).getPourcentage() == 15);
        assertEquals(instance.indemnites.get(150).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin175() {
        assertTrue(instance.indemnites.get(175).getPourcentage() == 25);
        assertEquals(instance.indemnites.get(175).getMontantMaximal(), new Dollar(20.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin200() {
        assertTrue(instance.indemnites.get(200).getPourcentage() == 12);
        assertEquals(instance.indemnites.get(200).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin300() {
        assertTrue(instance.indemnites.get(300).getPourcentage() == 60);
        assertEquals(instance.indemnites.get(300).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin350() {
        assertTrue(instance.indemnites.get(350).getPourcentage() == 60);
        assertEquals(instance.indemnites.get(350).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin399() {
        assertTrue(instance.indemnites.get(399).getPourcentage() == 60);
        assertEquals(instance.indemnites.get(399).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin400() {
        assertTrue(instance.indemnites.get(400).getPourcentage() == 25);
        assertEquals(instance.indemnites.get(400).getMontantMaximal(), new Dollar(15.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin500() {
        assertTrue(instance.indemnites.get(500).getPourcentage() == 30);
        assertEquals(instance.indemnites.get(500).getMontantMaximal(), new Dollar(20.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin600() {
        assertTrue(instance.indemnites.get(600).getPourcentage() == 15);
        assertEquals(instance.indemnites.get(600).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin700() {
        assertTrue(instance.indemnites.get(700).getPourcentage() == 22);
        assertEquals(instance.indemnites.get(700).getMontantMaximal(), new Dollar(0.00));
    }
    
}
