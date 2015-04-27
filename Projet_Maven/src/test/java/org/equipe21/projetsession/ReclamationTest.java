/*
 * @Copyright Victor Piron Mardones.
 */
package org.equipe21.projetsession;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReclamationTest {
    
    Reclamation reclamationDeTest = new Reclamation(100,"28-02-2014", "200.00$");

    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    
    @Before
    public void setUp() throws Exception {        
    }
    

    @After
    public void tearDown() throws Exception {
    }
    

    @Test
    public void testGetNombreSoin() {
        int expResult = 100;
        int result = reclamationDeTest.getNumeroSoin();
        assertTrue(expResult==result);
    }

    
    @Test
    public void testSetNombreSoin() {
        int expResult = 200;
        reclamationDeTest.setNumeroSoin(200);
        int result = reclamationDeTest.getNumeroSoin();
        assertTrue(expResult==result);
    }

    
    @Test
    public void testGetDate() {
        String expResult = "28-02-2014";
        String result = reclamationDeTest.getDate();
        assertTrue(expResult.equals(result));
    }

    
    @Test
    public void testSetDate() {
        String date = "31-02-2014";
        reclamationDeTest.setDate(date);
        String result = reclamationDeTest.getDate();
        assertTrue(date.equals(result));
    }

    
    @Test
    public void testGetMontantReclamation() {
        Dollar expResult = new Dollar(200.00);
        Dollar result = reclamationDeTest.getMontantReclamation();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetMontantReclamation() {
        Dollar montant = new Dollar(10.0);
        reclamationDeTest.setMontantReclamation(montant);
        Dollar result = reclamationDeTest.getMontantReclamation();
        assertEquals(montant, result);
    }

    
    @Test
    public void testGetMontantRemboursement() {
        Dollar expResult = new Dollar(0.0);
        Dollar result = reclamationDeTest.getMontantRemboursement();
        assertEquals(expResult, result);
    }


    @Test
    public void testSetMontantRemboursement() {
        Dollar montant = new Dollar(30.0);
        reclamationDeTest.setMontantRemboursement(montant);
        Dollar result = reclamationDeTest.getMontantRemboursement();
        assertEquals(montant, result);
    }
    
}
