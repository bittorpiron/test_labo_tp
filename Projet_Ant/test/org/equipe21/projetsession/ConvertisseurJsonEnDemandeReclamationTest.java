
package org.equipe21.projetsession;

import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConvertisseurJsonEnDemandeReclamationTest {
    
    private LectureFichierJson lectFichierJson;
    static final String DONNEES_BRUTES_TEST_CONTENU_VALIDE = "{" +
                            "    \"dossier\": \"A100323\"," +
                            "    \"mois\": \"2015-01\"," +
                            "    \"reclamations\": [" +
                            "        {" +
                            "            \"soin\": 100," +
                            "            \"date\": \"2015-01-11\"," +
                            "            \"montant\": \"234.00$\"" +
                            "        }," +
                            "        {" +
                            "            \"soin\": 200," +
                            "            \"date\": \"2015-01-13\"," +
                            "            \"montant\": \"90.00$\"" +
                            "        }," +
                            "        {" +
                            "            \"soin\": 334," +
                            "            \"date\": \"2015-01-23\"," +
                            "            \"montant\": \"125.00$\"" +
                            "        }" +
                            "    ]" +
                            "}";
    
    static final String DONNEES_BRUTES_TEST_ERREUR_CONTENU_JSON = "{" +
                            " \"dossier\": \"A100323\"," +
                            " \"mois\": \"2015-01\"," +
                            " \"reclamations\": [" +
                            " {" +
                            " \"soin\": 100," +
                            " \"date\": \"2015-01-11\"," +
                            " \"montant\": \"234.00$\"" +
                            " }," +
                            " {" +
                            " \"soin\": 200," +
                            " \"date\": \"2015-01-13\"," +
                            " \"montant\": \"90.00$\"" +
                            " }," +
                            " {" +
                            " \"soin\": 334," +
                            " \"date\": \"2015-01-23\"," +
                            " \"montant\": \"125.00$\"" +
                            " }";
    
    static final String DONNEES_BRUTES_TEST_ERREUR_CHAMP_MANQUANT1 = "{" +
                            "    \"dossier\": \"A100323\"," +
                            "    \"reclamations\": [" +
                            "        {" +
                            "            \"soin\": 100," +
                            "            \"date\": \"2015-01-11\"," +
                            "            \"montant\": \"234.00$\"" +
                            "        }," +
                            "        {" +
                            "            \"soin\": 200," +
                            "            \"date\": \"2015-01-13\"," +
                            "            \"montant\": \"90.00$\"" +
                            "        }," +
                            "        {" +
                            "            \"soin\": 334," +
                            "            \"date\": \"2015-01-23\"," +
                            "            \"montant\": \"125.00$\"" +
                            "        }" +
                            "    ]" +
                            "}";
    
    static final String DONNEES_BRUTES_TEST_ERREUR_CHAMP_MANQUANT2 = "{" +
                            "    \"dossier\": \"A100323\"," +
                            "    \"mois\": \"2015-01\"" +
                            "}";
    
    static final String DONNEES_BRUTES_TEST_ERREUR_RECLAMATION_DIFFERENT_DEMANDE = "{" +
                            "    \"dossier\": \"A100323\"," +
                            "    \"mois\": \"2015-01\"," +
                            "    \"reclamations\": [" +
                            "        {" +
                            "            \"soin\": 100," +
                            "            \"date\": \"2015-01-11\"," +
                            "            \"montant\": \"234.00$\"" +
                            "        }," +
                            "        {" +
                            "            \"soin\": 200," +
                            "            \"date\": \"2015-02-13\"," +
                            "            \"montant\": \"90.00$\"" +
                            "        }," +
                            "        {" +
                            "            \"soin\": 334," +
                            "            \"date\": \"2015-01-23\"," +
                            "            \"montant\": \"125.00$\"" +
                            "        }" +
                            "    ]" +
                            "}";
    
    static final String DONNEES_BRUTES_TEST_ERREUR_NUMERO_SOIN = "{" +
                            "    \"dossier\": \"A100323\"," +
                            "    \"mois\": \"2015-01\"," +
                            "    \"reclamations\": [" +
                            "        {" +
                            "            \"soin\": 15500," +
                            "            \"date\": \"2015-01-11\"," +
                            "            \"montant\": \"234.00$\"" +
                            "        }," +
                            "        {" +
                            "            \"soin\": 200," +
                            "            \"date\": \"2015-01-13\"," +
                            "            \"montant\": \"90.00$\"" +
                            "        }," +
                            "        {" +
                            "            \"soin\": 334," +
                            "            \"date\": \"2015-01-23\"," +
                            "            \"montant\": \"125.00$\"" +
                            "        }" +
                            "    ]" +
                            "}";
    
    static final String DONNEES_BRUTES_TEST_ERREUR_FORMAT_MONTANT = "{" +
                            "    \"dossier\": \"A100323\"," +
                            "    \"mois\": \"2015-01\"," +
                            "    \"reclamations\": [" +
                            "        {" +
                            "            \"soin\": 100," +
                            "            \"date\": \"2015-01-11\"," +
                            "            \"montant\": \"234.00\"" +
                            "        }," +
                            "        {" +
                            "            \"soin\": 200," +
                            "            \"date\": \"2015-02-13\"," +
                            "            \"montant\": \"90.00$\"" +
                            "        }," +
                            "        {" +
                            "            \"soin\": 334," +
                            "            \"date\": \"2015-01-23\"," +
                            "            \"montant\": \"125.00$\"" +
                            "        }" +
                            "    ]" +
                            "}";
    
    static final String DONNEES_BRUTES_TEST_ERREUR_DOSSIER_CONTRAT = "{" +
                            "    \"dossier\": \"Z100323\"," +
                            "    \"mois\": \"2015-01\"," +
                            "    \"reclamations\": [" +
                            "        {" +
                            "            \"soin\": 100," +
                            "            \"date\": \"2015-01-11\"," +
                            "            \"montant\": \"234.00\"" +
                            "        }," +
                            "        {" +
                            "            \"soin\": 200," +
                            "            \"date\": \"2015-02-13\"," +
                            "            \"montant\": \"90.00$\"" +
                            "        }," +
                            "        {" +
                            "            \"soin\": 334," +
                            "            \"date\": \"2015-01-23\"," +
                            "            \"montant\": \"125.00$\"" +
                            "        }" +
                            "    ]" +
                            "}";
    
    static final String DONNEES_BRUTES_TEST_ERREUR_DOSSIER_NUMERO_CLIENT = "{" +
                            "    \"dossier\": \"A100323231\"," +
                            "    \"mois\": \"2015-01\"," +
                            "    \"reclamations\": [" +
                            "        {" +
                            "            \"soin\": 100," +
                            "            \"date\": \"2015-01-11\"," +
                            "            \"montant\": \"234.00\"" +
                            "        }," +
                            "        {" +
                            "            \"soin\": 200," +
                            "            \"date\": \"2015-02-13\"," +
                            "            \"montant\": \"90.00$\"" +
                            "        }," +
                            "        {" +
                            "            \"soin\": 334," +
                            "            \"date\": \"2015-01-23\"," +
                            "            \"montant\": \"125.00$\"" +
                            "        }" +
                            "    ]" +
                            "}";

    
    @Before
    public void setUp() {
        lectFichierJson = new LectureFichierJson();
    }


    @After
    public void tearDown() {

    }
    
    
    @Test
    public void testConstruireDemandeReclamation() {
    }

    
    @Test
    public void testValiderChampsExistantsPartieGenerale() {
    }

    
    @Test
    public void testValiderDonneesPartieGenerale() {
    }

    
    @Test
    public void testConvertirArrayJsonEnListeReclamation() {
    }

    
    @Test
    public void testConvertirDonneeJsonEnReclamation() {
    }

    
    @Test
    public void testValiderChampsExistantsPartieReclamation() {
    }

    
    @Test
    public void testValiderDonneesPartieReclamation() {
    }

    
    @Test
    public void testConvertirMontantStringEnDouble() {
    }
    
    
    // Cas 1: Aucune donnée
    @Test
    public void testAucuneDonnee() {
        boolean succes = true;
        
        lectFichierJson.setDonneesBrute("");
        try {
            JSONObject donneesJson = (JSONObject) lectFichierJson.getObjetSortie();
            ConvertisseurJsonEnDemandeReclamation conv = new ConvertisseurJsonEnDemandeReclamation(donneesJson);
            DemandeReclamation demandeRecl = conv.construireDemandeReclamation();
        } catch (ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException e) {
            succes = false;
        }
        
        assertFalse(succes);
    }
    
    
    // Cas 2: Données avec contenu valide (ressources/testFichierValide.json)
    @Test
    public void testDonneesAvecContenuValide() {
        boolean succes = true;

        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_CONTENU_VALIDE);
        try {
            JSONObject donneesJson = (JSONObject) lectFichierJson.getObjetSortie();
            ConvertisseurJsonEnDemandeReclamation conv = new ConvertisseurJsonEnDemandeReclamation(donneesJson);
            DemandeReclamation demandeRecl = conv.construireDemandeReclamation();
        } catch (ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException e) {
            succes = false;
        }
        
        assertTrue(succes);
    }

    
    // Cas 3: Données avec contenu partiellement valide (format JSON invalide) (ressources/testFormatJsonInvalide.json)
    @Test
    public void testDonneesInvalidesFormatJson() {
        boolean succes = true;
        
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_CONTENU_JSON);
        try {
            JSONObject donneesJson = (JSONObject) lectFichierJson.getObjetSortie();
            ConvertisseurJsonEnDemandeReclamation conv = new ConvertisseurJsonEnDemandeReclamation(donneesJson);
            DemandeReclamation demandeRecl = conv.construireDemandeReclamation();
        } catch (ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException e) {
            succes = false;
        }
        
        assertFalse(succes);
    }

    
    // Cas 4: Données avec contenu partiellement valide (champ manquant)
    @Test
    public void testDonneesInvalidesChampManquant1() {
        boolean succes = true;
        
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_CHAMP_MANQUANT1);
        try {
            JSONObject donneesJson = (JSONObject) lectFichierJson.getObjetSortie();
            ConvertisseurJsonEnDemandeReclamation conv = new ConvertisseurJsonEnDemandeReclamation(donneesJson);
            DemandeReclamation demandeRecl = conv.construireDemandeReclamation();
        } catch (ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException e) {
            succes = false;
        }
        
        assertFalse(succes);
    }
    
    
    // Cas 5: Données avec contenu partiellement valide (champ manquant)
    @Test
    public void testDonneesInvalidesChampManquant2() {
        boolean succes = true;
        
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_CHAMP_MANQUANT2);
        try {
            JSONObject donneesJson = (JSONObject) lectFichierJson.getObjetSortie();
            ConvertisseurJsonEnDemandeReclamation conv = new ConvertisseurJsonEnDemandeReclamation(donneesJson);
            DemandeReclamation demandeRecl = conv.construireDemandeReclamation();
        } catch (ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException e) {
            succes = false;
        }
        
        assertFalse(succes);
    }
    
    
    // Cas 6: Données avec contenu partiellement valide (mois de réclamation différent à celui de la demande)
    @Test
    public void testDonneesInvalidesMoisReclamationDifferentDeLaDemande() {
        boolean succes = true;
        
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_RECLAMATION_DIFFERENT_DEMANDE);
        try {
            JSONObject donneesJson = (JSONObject) lectFichierJson.getObjetSortie();
            ConvertisseurJsonEnDemandeReclamation conv = new ConvertisseurJsonEnDemandeReclamation(donneesJson);
            DemandeReclamation demandeRecl = conv.construireDemandeReclamation();
        } catch (ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException e) {
            succes = false;
        }
        
        assertFalse(succes);
    }
    
    
    // Cas 7: Données avec contenu partiellement valide (numéro de soin incorrect)
    @Test
    public void testDonneesInvalidesNumeroSoin() {
        boolean succes = true;
        
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_NUMERO_SOIN);
        try {
            JSONObject donneesJson = (JSONObject) lectFichierJson.getObjetSortie();
            ConvertisseurJsonEnDemandeReclamation conv = new ConvertisseurJsonEnDemandeReclamation(donneesJson);
            DemandeReclamation demandeRecl = conv.construireDemandeReclamation();
        } catch (ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException e) {
            succes = false;
        }
        
        assertFalse(succes);
    }
    
    
    // Cas 8: Données avec contenu partiellement valide (montant formaté incorrectement)
    @Test
    public void testDonneesInvalidesFormatMontant() {
        boolean succes = true;
        
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_FORMAT_MONTANT);
        try {
            JSONObject donneesJson = (JSONObject) lectFichierJson.getObjetSortie();
            ConvertisseurJsonEnDemandeReclamation conv = new ConvertisseurJsonEnDemandeReclamation(donneesJson);
            DemandeReclamation demandeRecl = conv.construireDemandeReclamation();
        } catch (ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException e) {
            succes = false;
        }
        
        assertFalse(succes);
    }
    
    
    // Cas 9: Données avec contenu partiellement valide (dossier contenant contrat invalide)
    @Test
    public void testDonneesInvalidesDossierAvecContratInvalide() {
        boolean succes = true;
        
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_DOSSIER_CONTRAT);
        try {
            JSONObject donneesJson = (JSONObject) lectFichierJson.getObjetSortie();
            ConvertisseurJsonEnDemandeReclamation conv = new ConvertisseurJsonEnDemandeReclamation(donneesJson);
            DemandeReclamation demandeRecl = conv.construireDemandeReclamation();
        } catch (ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException e) {
            succes = false;
        }
        
        assertFalse(succes);
    }
    
    
    // Cas 10: Données avec contenu partiellement valide (dossier contenant numéro de client invalide)
    @Test
    public void testDonneesInvalidesDossierAvecNumeroClientInvalide() {
        boolean succes = true;
        
        lectFichierJson.setDonneesBrute(DONNEES_BRUTES_TEST_ERREUR_DOSSIER_NUMERO_CLIENT);
        try {
            JSONObject donneesJson = (JSONObject) lectFichierJson.getObjetSortie();
            ConvertisseurJsonEnDemandeReclamation conv = new ConvertisseurJsonEnDemandeReclamation(donneesJson);
            DemandeReclamation demandeRecl = conv.construireDemandeReclamation();
        } catch (ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException e) {
            succes = false;
        }
        
        assertFalse(succes);
    }
}