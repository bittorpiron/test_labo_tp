/*
 * @Copyright Victor Piron Mardones.
 */
package org.equipe21.projetsession;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ContratAssuranceTest {
   
    ContratAssurance instanceTest = new ContratAssuranceTestImpl();

    public ContratAssuranceTest() {
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
    public void testTraiterUneReclamation() {
        instanceTest.remplirTableIndemnites();        
        Reclamation reclamation = instanceTest.traiterUneReclamation(new Reclamation(200, null, "500.00$"));
        assertTrue(reclamation.getMontantRemboursement().getTotalCents() == 10000);
    }

    
    @Test
    public void testCalculerMontantARembourser_PasDeMax() {

        Dollar maxRemboursable = new Dollar(0.00);        
        Dollar  remboursement = new Dollar(300.00);       
        assertTrue(instanceTest.calculerMontantRemboursable( remboursement, maxRemboursable).getTotalCents() == 30000);
    }
    
    
    @Test
    public void testCalculerMontantARembourser_Limite() {

        Dollar maxRemboursable = new Dollar(100.00);        
        Dollar remboursement = new Dollar(100.00);   
        assertTrue(instanceTest.calculerMontantRemboursable( remboursement, maxRemboursable).getTotalCents() == 10000);
    }
    

    @Test
    public void testCalculerMontantARembourser_DepasseLimite() {

        Dollar maxRemboursable = new Dollar(100.00);        
        Dollar remboursement = new Dollar(300.00);        
        assertTrue( instanceTest.calculerMontantRemboursable( remboursement, maxRemboursable).getTotalCents() == 10000);
    }
    
    
    @Test
    public void testCalculerMontantARembourser_NeDepassePAS() {

        Dollar maxRemboursable = new Dollar(100.00);        
        Dollar remboursement = new Dollar(30.00);        
        assertTrue(instanceTest.calculerMontantRemboursable( remboursement, maxRemboursable).getTotalCents() == 3000);
    }
    
    
    public class ContratAssuranceTestImpl extends ContratAssurance {

        @Override
        public void remplirTableIndemnites() {
            indemnites.put(200, new Indemnite(new Soin(200, "", "255.50$"), 25, "100.00$"));
        }
    }    
    
}
