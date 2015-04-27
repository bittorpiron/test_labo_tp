/*
 * @Copyright Victor Piron Mardones.
 */
package org.equipe21.projetsession;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReponseRemboursementTest {

    ReponseRemboursement remboursementMensuelleB;

    public ReponseRemboursementTest() {
    }


    @BeforeClass
    public static void setUpClass() {
    }


    @AfterClass
    public static void tearDownClass() {
    }


    @Before
    public void setUp() {
        remboursementMensuelleB = new ReponseRemboursementImpl("B");
    }


    @After
    public void tearDown() {
    }


    @Test
    public void testGetMontantTotalRemboursements() {
        Dollar expResult = new Dollar(101.01);
        Dollar result = remboursementMensuelleB.getMontantTotalRemboursements();
        assertEquals(expResult, result);
    }


    @Test
    public void testSetMontantTotalRemboursements() {
        Dollar montantTotalRemboursements = new Dollar(99.99);
        remboursementMensuelleB.setMontantTotalRemboursements(montantTotalRemboursements);
        Dollar result = remboursementMensuelleB.getMontantTotalRemboursements();
        assertEquals(montantTotalRemboursements, result);
    }


    @Test
    public void testAjouterMontantAuTotalRemboursements() {
        Dollar montantRemboursement = new Dollar(20.45);
        Dollar resultatFinale = Dollar.additionDollars(remboursementMensuelleB.getMontantTotalRemboursements(), montantRemboursement);

        remboursementMensuelleB.ajouterMontantAuTotalRemboursements(montantRemboursement);
        Dollar resultat = remboursementMensuelleB.getMontantTotalRemboursements();
        assertEquals(resultatFinale, resultat);
    }


    @Test
    public void testChargerIndemnites() {

        remboursementMensuelleB.chargerDonneesContrat();

        assertTrue(remboursementMensuelleB.contrat.indemnites.get(100).getPourcentage() == 50);
        assertEquals(remboursementMensuelleB.contrat.indemnites.get(100).getMontantMaximal(), new Dollar(50.00));
    }


    @Test
    public void testChargerIndemnitesEchec() {

        ReponseRemboursement remboursementMensuelleA = new ReponseRemboursementImpl("A");
        remboursementMensuelleA.chargerDonneesContrat();

        assertFalse(remboursementMensuelleA.contrat.indemnites.get(100).getPourcentage() == 50);
        assertFalse(remboursementMensuelleA.contrat.indemnites.get(100).getMontantMaximal().equals(new Dollar(50.00)));
    }


    @Test
    public void testTraiterDemandeContratA() {

        ReponseRemboursement remboursementA = new ReponseRemboursementMensuelle(null, null, "A", new ArrayList<>());
        remboursementA.remboursements.add(new Reclamation(100, "", "200.00$"));

        remboursementA.traiterDemande();
        assertTrue(remboursementA.remboursements.get(0).getMontantRemboursement().getTotalCents() == 7000);
    }


    @Test
    public void testTraiterDemandeContratB() {

        ReponseRemboursement remboursementB = new ReponseRemboursementMensuelle(null, null, "B", new ArrayList<>());
        remboursementB.remboursements.add(new Reclamation(100, "", "200.00$"));

        remboursementB.traiterDemande();
        assertTrue(remboursementB.remboursements.get(0).getMontantRemboursement().getTotalCents() == 5000);

    }


    @Test
    public void testTraiterDemandeContratC() {

        ReponseRemboursement remboursementC = new ReponseRemboursementMensuelle(null, null, "C", new ArrayList<>());
        remboursementC.remboursements.add(new Reclamation(100, "", "200.00$"));

        remboursementC.traiterDemande();
        assertFalse(remboursementC.remboursements.get(0).getMontantRemboursement().getTotalCents() == 18000);

    }


    @Test
    public void testTraiterDemandeContratD() {

        ReponseRemboursement remboursementD = new ReponseRemboursementMensuelle(null, null, "D", new ArrayList<>());
        remboursementD.remboursements.add(new Reclamation(100, "", "200.00$"));

        remboursementD.traiterDemande();
        assertTrue(remboursementD.remboursements.get(0).getMontantRemboursement().getTotalCents() == 7500);

    }


    @Test
    public void testTraiterDemandeContratE() {

        ReponseRemboursement remboursementE = new ReponseRemboursementMensuelle(null, null, "E", new ArrayList<>());
        remboursementE.remboursements.add(new Reclamation(100, "", "200.00$"));

        remboursementE.traiterDemande();
        assertTrue(remboursementE.remboursements.get(0).getMontantRemboursement().getTotalCents() == 5000);

    }


    public class ReponseRemboursementImpl extends ReponseRemboursement {

        public ReponseRemboursementImpl(String typeContrat) {

            this.codeClient = "";
            this.mois = "";
            this.typeContrat = typeContrat;
            this.remboursements = new ArrayList<>();
            this.montantTotalRemboursements = new Dollar("101.01$");

        }


        @Override
        public void traiterDemande() {

        }


        @Override
        public ListeDeSoins getListeDesSoins() {
            return null;
        }


    }

}
