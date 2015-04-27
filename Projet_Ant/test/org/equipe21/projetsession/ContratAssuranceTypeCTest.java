/*
 * @Copyright Victor Piron Mardones.
 */
package org.equipe21.projetsession;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContratAssuranceTypeCTest {

    ContratAssurance instance = new ContratAssuranceTypeC();

    
    public ContratAssuranceTypeCTest() {
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
        assertTrue(instance.indemnites.get(0).getPourcentage() == 90);
        assertEquals(instance.indemnites.get(0).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin100() {
        assertTrue(instance.indemnites.get(100).getPourcentage() == 95);
        assertEquals(instance.indemnites.get(100).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin150() {
        assertTrue(instance.indemnites.get(150).getPourcentage() == 85);
        assertEquals(instance.indemnites.get(150).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin175() {
        assertTrue(instance.indemnites.get(175).getPourcentage() == 90);
        assertEquals(instance.indemnites.get(175).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin200() {
        assertTrue(instance.indemnites.get(200).getPourcentage() == 90);
        assertEquals(instance.indemnites.get(200).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin300() {
        assertTrue(instance.indemnites.get(300).getPourcentage() == 90);
        assertEquals(instance.indemnites.get(300).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin350() {
        assertTrue(instance.indemnites.get(350).getPourcentage() == 90);
        assertEquals(instance.indemnites.get(350).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin399() {
        assertTrue(instance.indemnites.get(399).getPourcentage() == 90);
        assertEquals(instance.indemnites.get(390).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin400() {
        assertTrue(instance.indemnites.get(400).getPourcentage() == 90);
        assertEquals(instance.indemnites.get(400).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin500() {
        assertTrue(instance.indemnites.get(500).getPourcentage() == 90);
        assertEquals(instance.indemnites.get(500).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin600() {
        assertTrue(instance.indemnites.get(600).getPourcentage() == 75);
        assertEquals(instance.indemnites.get(600).getMontantMaximal(), new Dollar(0.00));
    }
    

    @Test
    public void testRemplirTableIndemnitesSoin700() {
        assertTrue(instance.indemnites.get(700).getPourcentage() == 90);
        assertEquals(instance.indemnites.get(700).getMontantMaximal(), new Dollar(0.00));
    }
    
}
