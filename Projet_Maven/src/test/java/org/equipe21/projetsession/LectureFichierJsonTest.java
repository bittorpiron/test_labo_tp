
package org.equipe21.projetsession;

import net.sf.json.JSONObject;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class LectureFichierJsonTest {
    
    private LectureFichierJson lectFichierJson;
    
    
    @Before
    public void setUp() throws Exception {
        lectFichierJson = new LectureFichierJson();
    }

    
    @After
    public void tearDown() throws Exception {
    }
    
    
    // Cas 1: Fichier inexistant
    @Test
    @Ignore
    public void testLireFichierInexistant() {
        assertFalse(lectFichierJson.lireFichier("testFichierInexistant.json", "UTF-8"));
    }
    
    
    // Cas 2: Fichier vide
    @Test
    @Ignore
    public void testLireFichierVide() {
        assertTrue(lectFichierJson.lireFichier("ressources/testFichierVide.json", "UTF-8"));
    }
    
    
    // Cas 3: Fichier avec contenu valide
    @Test
    @Ignore
    public void testLireFichierAvecContenuValide() {
        boolean succes = lectFichierJson.lireFichier("ressources/testFichierValide.json", "UTF-8");
        
        if (succes) {
            try {
                JSONObject donneesJson = (JSONObject) lectFichierJson.getObjetSortie();
                ConvertisseurJsonEnDemandeReclamation conv = new ConvertisseurJsonEnDemandeReclamation(donneesJson);
                DemandeReclamation demandeRecl = conv.construireDemandeReclamation();
            } catch (ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException e) {
                succes = false;
            }
        }
        
        assertTrue(succes);
    }
    
    
    // Cas 4: Fichier avec contenu partiellement valide (format JSON invalide)
    @Test
    @Ignore
    public void testLireFichierInvalideFormatJson() {
        boolean succes = lectFichierJson.lireFichier("ressources/testFormatJsonInvalide.json", "UTF-8");
        
        if (succes) {
            try {
                JSONObject donneesJson = (JSONObject) lectFichierJson.getObjetSortie();
                ConvertisseurJsonEnDemandeReclamation conv = new ConvertisseurJsonEnDemandeReclamation(donneesJson);
                DemandeReclamation demandeRecl = conv.construireDemandeReclamation();
            } catch (ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException e) {
                succes = false;
            }
        }
        
        assertFalse(succes);
    }
}