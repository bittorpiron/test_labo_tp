/*
 * @Copyright Victor Piron Mardones.
 */
package org.equipe21.projetsession;

import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class EcritureFichierJsonTest {
    
    EcritureFichierJson ecritureInstanceDeTest;
    static final String DONNEES_BRUTES_TEST_CONSTRUIRE_REPONSE = "{\n" +
                "    \"dossier\": \"unNumeroDossier\",\n" +
                "    \"mois\": \"unMois\",\n" +
                "    \"remboursements\": [    {\n" +
                "        \"soin\": 100,\n" +
                "        \"date\": \"uneDate\",\n" +
                "        \"montant\": \"55.55$\"\n" +
                "    }],\n" +
                "    \"total\": \"156.56$\"\n" +
                "}";
    static final String DONNEES_BRUTES_INITIALISATION =  "{\n" +
                "    \"dossier\": \"\",\n" +
                "    \"mois\": \"\",\n" +
                "    \"remboursements\": [    {\n" +
                "        \"soin\": 100,\n" +
                "        \"date\": \"uneDate\",\n" +
                "        \"montant\": \"55.55$\"\n" +
                "    }],\n" +
                "    \"total\": \"101.01$\"\n" +
                "}";
    
    public EcritureFichierJsonTest() {
    }
    
    
    @BeforeClass
    public static void setUpClass() {        
        
    }
    
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    @Before
    public void setUp() {
        
        ecritureInstanceDeTest = new EcritureFichierJson();
        
    }
    
    
    @After
    public void tearDown() {
    }


    @Test
    public void testConstruireReponseJSON() {

        ReponseRemboursement reponse = new ReponseRemboursementImpl(); 
        
        JSONObject objetJSON = new JSONObject();
        objetJSON.put("dossier", "unNumeroDossier");
        objetJSON.put("mois", "unMois");
        objetJSON.put("remboursements", ecritureInstanceDeTest.construireListeRemboursementsJSON(reponse));
        objetJSON.put("total",  "156.56$");
       
        ecritureInstanceDeTest.construireReponseJSON(reponse);
        assertEquals(DONNEES_BRUTES_TEST_CONSTRUIRE_REPONSE, objetJSON.toString(4));
    }

    
    @Test
    public void testConstruireListeRemboursementsJSON() {  
        
        JSONObject jsonSoin = new JSONObject();
        jsonSoin.put("soin", 100);
        jsonSoin.put("date", "uneDate");
        jsonSoin.put("montant", "55.55$");
        
        ReponseRemboursement reponse = new ReponseRemboursementImpl();
        JSONArray result = ecritureInstanceDeTest.construireListeRemboursementsJSON(reponse);        
        assertTrue(result.contains(jsonSoin));
        
    }


    @Test
    public void testConstruireRemboursementJSON() {
        JSONObject soinJSON = new JSONObject();
        Reclamation soin = new Reclamation(100, "uneDate", "200.75$");
        ecritureInstanceDeTest.construireRemboursementJSON(soinJSON, soin);
        assertEquals("0.00$", soinJSON.getString("montant"));
        assertEquals("uneDate", soinJSON.getString("date"));
        assertEquals("100", soinJSON.getString("soin"));
    }
    
    
    @Test
    public void testConstruireReponseJSON_Message() {
        
        ecritureInstanceDeTest = new EcritureFichierJson("Ceci est un test");
        
        JSONObject message = new JSONObject();
        message.put("message","Ceci est un test");

        assertEquals(message.toString(), ecritureInstanceDeTest.donneesBrutes);
    }
    
    @Test
    public void testConstruireReponseJSON_Reponse() {
        
        ecritureInstanceDeTest = new EcritureFichierJson(new ReponseRemboursementImpl());

        assertEquals(DONNEES_BRUTES_INITIALISATION, ecritureInstanceDeTest.donneesBrutes);
    }
    
    //Implémentation pour des test
    public class ReponseRemboursementImpl extends ReponseRemboursement {

        public ReponseRemboursementImpl() {

            this.codeClient = "";
            this.mois = "";
            this.typeContrat = "";
            this.remboursements = new ArrayList<>();
            
            Reclamation reclamation = new Reclamation (100,"uneDate","55.55$");
            reclamation.setMontantRemboursement(new Dollar(55.55));
            this.remboursements.add(reclamation);            
            this.montantTotalRemboursements = new Dollar(101.01);

        }

        @Override
        public void traiterDemande() {

        }
        
        @Override    
        public ListeDeSoins getListeDesSoins(){        
            return null;
        }
    }
    
}
