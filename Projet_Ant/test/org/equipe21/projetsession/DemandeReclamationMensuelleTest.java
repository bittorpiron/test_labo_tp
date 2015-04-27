package org.equipe21.projetsession;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DemandeReclamationMensuelleTest {
    
    DemandeReclamationMensuelle demandeReclamationMensuelle;
    
    public DemandeReclamationMensuelleTest() {
    }
    

    @BeforeClass
    public static void setUpClass() {
    }
    

    @AfterClass
    public static void tearDownClass() {
    }
    

    @Before
    public void setUp() {
        demandeReclamationMensuelle = new DemandeReclamationMensuelle("mois", "A2345", new ArrayList<>());
    }
    

    @After
    public void tearDown() {
    }


    @Test
    public void testAjouterReclamation() {
        Reclamation testReclamation = new Reclamation(100, "uneDate", "55.55$");
        demandeReclamationMensuelle.ajouterReclamation(testReclamation);
        assertEquals(testReclamation, demandeReclamationMensuelle.getReclamations().get(0));
    }    


    @Test
    public void testTraiterDemande() {
        Reclamation testReclamation = new Reclamation(100, "uneDate", "55.55$");
        demandeReclamationMensuelle.ajouterReclamation(testReclamation);
        ReponseRemboursement result = demandeReclamationMensuelle.traiterDemande();
        assertEquals(new Dollar("19.44$"), result.montantTotalRemboursements);
    }

}
