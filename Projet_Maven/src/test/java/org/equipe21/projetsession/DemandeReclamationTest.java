/*
 * @Copyright Victor Piron Mardones.
 */
package org.equipe21.projetsession;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DemandeReclamationTest {

    DemandeReclamation demandeReclamationTest;

    
    public DemandeReclamationTest() {
    }

    
    @BeforeClass
    public static void setUpClass() {
    }

    
    @AfterClass
    public static void tearDownClass() {
    }
    

    @Before
    public void setUp() {

        demandeReclamationTest = new DemandeReclamationImpl();
    }
    

    @After
    public void tearDown() {
    }

    
    @Test
    public void testGetReclamations() {
        assertEquals("uneDate", demandeReclamationTest.getReclamations().get(0).getDate());
        assertEquals(100, demandeReclamationTest.getReclamations().get(0).getNumeroSoin(), 0.00);
        assertEquals(5555, demandeReclamationTest.getReclamations().get(0).getMontantReclamation().getTotalCents(), 0.00);
    }
    

    @Test
    public void testGetCodeClient() {
        assertEquals("monCode", demandeReclamationTest.getCodeClient());
    }
    

    @Test
    public void testGetMois() {
        assertEquals("unMois", demandeReclamationTest.getMois());
    }
    

    @Test
    public void testTraiterDemande() {
        ReponseRemboursement result = demandeReclamationTest.traiterDemande();
        assertEquals(2777, result.getMontantTotalRemboursements().getTotalCents(), 0.00);
    }
    

    //Implementation pour des test
    public class DemandeReclamationImpl extends DemandeReclamation {

        public DemandeReclamationImpl() {

            this.codeClient = "monCode";
            this.mois = "unMois";
            this.typeContrat = "B";
            this.reclamations = new ArrayList<>();
            this.reclamations.add(new Reclamation(100, "uneDate", "55.55$"));

        }

        @Override
        public ReponseRemboursement traiterDemande() {
            return new ReponseRemboursementMensuelle(this.codeClient,
                    this.mois, this.typeContrat, this.reclamations);
        }

    }

}
