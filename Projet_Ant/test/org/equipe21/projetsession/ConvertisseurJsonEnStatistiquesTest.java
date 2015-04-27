
package org.equipe21.projetsession;

import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConvertisseurJsonEnStatistiquesTest {
    
    static final String DONNEES_BRUTES_TEST_CONTENU_JSON_VALIDE = "{\n" +
                            "    \"nb_reclamations_valide_traitees\": 22,\n" +
                            "    \"nb_reclamations_rejetees\": 33,\n" +
                            "    \"nb_soins_declares\": {\n" +
                            "			\"Osthéopathie\" : 50,\n" +
                            "			\"Médecin généraliste privé\" : 30,\n" +
                            "			\"Psychologie individuelle\" : 40,\n" +
                            "			\"Chiropratie\" : 70,\n" +
                            "			\"Soins dentaires\" : 10\n" +
                            "    }\n" +
                            "}";
    
    static final String DONNEES_BRUTES_TEST_ERREUR_FORMAT_JSON = "{\n" +
                            "    \"nb_reclamations_valide_traitees\": 22,\n" +
                            "    \"nb_reclamations_rejetees\": 33,\n" +
                            "    \"nb_soins_declares\": {\n" +
                            "			\"Osthéopathie\" : 50,\n" +
                            "			\"Médecin généraliste privé\" : 30,\n" +
                            "			\"Psychologie individuelle\" : 40,\n" +
                            "			\"Chiropratie\" : 70,\n" +
                            "			\"Soins dentaires\" : 10\n" +
                            "    }\n";
        
    static final String DONNEES_BRUTES_TEST_ERREUR_CHAMP_MANQUANT1 = "{\n" +
                            "    \"nb_reclamations_rejetees\": 33,\n" +
                            "    \"nb_soins_declares\": {\n" +
                            "			\"Osthéopathie\" : 50,\n" +
                            "			\"Médecin généraliste privé\" : 30,\n" +
                            "			\"Psychologie individuelle\" : 40,\n" +
                            "			\"Chiropratie\" : 70,\n" +
                            "			\"Soins dentaires\" : 10\n" +
                            "    }\n" +
                            "}";
    
    static final String DONNEES_BRUTES_TEST_ERREUR_CHAMP_MANQUANT2 = "{\n" +
                            "    \"nb_reclamations_valide_traitees\": 22,\n" +
                            "    \"nb_soins_declares\": {\n" +
                            "			\"Osthéopathie\" : 50,\n" +
                            "			\"Médecin généraliste privé\" : 30,\n" +
                            "			\"Psychologie individuelle\" : 40,\n" +
                            "			\"Chiropratie\" : 70,\n" +
                            "			\"Soins dentaires\" : 10\n" +
                            "    }\n" +
                            "}";
    
    static final String DONNEES_BRUTES_TEST_ERREUR_CHAMP_MANQUANT3 = "{\n" +
                            "    \"nb_reclamations_valide_traitees\": 22,\n" +
                            "    \"nb_reclamations_rejetees\": 33\n" +
                            "}";
        
    static final String DONNEES_BRUTES_TEST_ERREUR_FORMAT_VALEUR1 = "{\n" +
                            "    \"nb_reclamations_valide_traitees\": 2e2,\n" +
                            "    \"nb_reclamations_rejetees\": 33,\n" +
                            "    \"nb_soins_declares\": {\n" +
                            "			\"Osthéopathie\" : 50,\n" +
                            "			\"Médecin généraliste privé\" : 30,\n" +
                            "			\"Psychologie individuelle\" : 40,\n" +
                            "			\"Chiropratie\" : 70,\n" +
                            "			\"Soins dentaires\" : 10\n" +
                            "    }\n" +
                            "}";
        
    static final String DONNEES_BRUTES_TEST_ERREUR_FORMAT_VALEUR2 = "{\n" +
                            "    \"nb_reclamations_valide_traitees\": 22,\n" +
                            "    \"nb_reclamations_rejetees\": 3e3,\n" +
                            "    \"nb_soins_declares\": {\n" +
                            "			\"Osthéopathie\" : 50,\n" +
                            "			\"Médecin généraliste privé\" : 30,\n" +
                            "			\"Psychologie individuelle\" : 40,\n" +
                            "			\"Chiropratie\" : 70,\n" +
                            "			\"Soins dentaires\" : 10\n" +
                            "    }\n" +
                            "}";
            
    static final String DONNEES_BRUTES_TEST_ERREUR_FORMAT_VALEUR3 = "{\n" +
                            "    \"nb_reclamations_valide_traitees\": 22,\n" +
                            "    \"nb_reclamations_rejetees\": 33,\n" +
                            "    \"nb_soins_declares\": {\n" +
                            "			\"Osthéopathie\" : 50,\n" +
                            "			\"Médecin généraliste privé\" : 3e0,\n" +
                            "			\"Psychologie individuelle\" : 40,\n" +
                            "			\"Chiropratie\" : 70,\n" +
                            "			\"Soins dentaires\" : 10\n" +
                            "    }\n" +
                            "}";
    
    
    @Before
    public void setUp() {
    }
    
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testValiderJsonValide() throws Exception {
        boolean valide = true;
        LectureFichierJson lectFichierJson = new LectureFichierJson();
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_CONTENU_JSON_VALIDE);
        try {
            ConvertisseurJsonEnStatistiques conv = new ConvertisseurJsonEnStatistiques((JSONObject) lectFichierJson.getObjetSortie());
            conv.construireStatistique();
        } catch (ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException ex) {
            valide = false;
        }
        assertTrue(valide);
    }
    
    
    @Test(expected = ErreurValeurFichierEntreeException.class)
    public void testValiderJsonIncomplet() throws Exception {
        LectureFichierJson lectFichierJson = new LectureFichierJson();
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_FORMAT_JSON);
        ConvertisseurJsonEnStatistiques conv = new ConvertisseurJsonEnStatistiques((JSONObject) lectFichierJson.getObjetSortie());
        conv.construireStatistique();
    }

    
    @Test(expected = ChampDonneesManquantFichierEntreeException.class)
    public void testValiderErreurChampsManquant1() throws Exception {
        LectureFichierJson lectFichierJson = new LectureFichierJson();
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_CHAMP_MANQUANT1);
        ConvertisseurJsonEnStatistiques conv = new ConvertisseurJsonEnStatistiques((JSONObject) lectFichierJson.getObjetSortie());
        conv.construireStatistique();
    }
    

    @Test(expected = ChampDonneesManquantFichierEntreeException.class)
    public void testValiderErreurChampsManquants2() throws Exception {
        LectureFichierJson lectFichierJson = new LectureFichierJson();
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_CHAMP_MANQUANT2);
        ConvertisseurJsonEnStatistiques conv = new ConvertisseurJsonEnStatistiques((JSONObject) lectFichierJson.getObjetSortie());
        conv.construireStatistique();
    }
    

    @Test(expected = ChampDonneesManquantFichierEntreeException.class)
    public void testValiderErreurChampsManquants3() throws Exception {
        LectureFichierJson lectFichierJson = new LectureFichierJson();
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_CHAMP_MANQUANT3);
        ConvertisseurJsonEnStatistiques conv = new ConvertisseurJsonEnStatistiques((JSONObject) lectFichierJson.getObjetSortie());
        conv.construireStatistique();
    }
    
    
    @Test(expected = FichierStatistiqueEndommageException.class)
    public void testValiderErreurFormatValeur1() throws Exception {
        LectureFichierJson lectFichierJson = new LectureFichierJson();
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_FORMAT_VALEUR1);
        ConvertisseurJsonEnStatistiques conv = new ConvertisseurJsonEnStatistiques((JSONObject) lectFichierJson.getObjetSortie());
        conv.construireStatistique();
    }
    
    
    @Test(expected = FichierStatistiqueEndommageException.class)
    public void testValiderErreurFormatValeur2() throws Exception {
        LectureFichierJson lectFichierJson = new LectureFichierJson();
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_FORMAT_VALEUR2);
        ConvertisseurJsonEnStatistiques conv = new ConvertisseurJsonEnStatistiques((JSONObject) lectFichierJson.getObjetSortie());
        conv.construireStatistique();
    }
    
    
    @Test(expected = NumberFormatException.class)
    public void testValiderErreurFormatValeur3() throws Exception {
        LectureFichierJson lectFichierJson = new LectureFichierJson();
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_FORMAT_VALEUR3);
        ConvertisseurJsonEnStatistiques conv = new ConvertisseurJsonEnStatistiques((JSONObject) lectFichierJson.getObjetSortie());
        conv.construireStatistique();
    }
}