
package org.equipe21.projetsession;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import net.sf.json.JSONObject;

/*
 * Classe responsable de l'écriture du fichier statistiques
 */
public class EcritureFichierJsonStatistiques implements EcritureFichier {
    
    private final String donneesBrutes;
    
    
    public EcritureFichierJsonStatistiques(Statistiques stats) {
        donneesBrutes = construireStatistiquesJSON(stats);
    }
    
    
    @Override
    public boolean ecrireFichier(String cheminAcces) throws IOException {
        Writer fichierSortie = new BufferedWriter(new OutputStreamWriter(
         new FileOutputStream(cheminAcces), "UTF-8"));
     
        try {
            ecrireLesDonnees(new WriterWrapper(fichierSortie));
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    
    
    protected void ecrireLesDonnees(WriterWrapper fichier) throws IOException {
        fichier.write(donneesBrutes);
        fichier.flush();
        fichier.close();
    }
    
    
    private String construireStatistiquesJSON(Statistiques stats) {
        JSONObject objetJSON = new JSONObject();
        objetJSON.put("nb_reclamations_valide_traitees", stats.getNbReclamationsValidesTraitees());
        objetJSON.put("nb_reclamations_rejetees", stats.getNbReclamationsRejetees());
        objetJSON.put("nb_soins_declares", construireListeNbSoinsDeclaresJSON(stats));
        return objetJSON.toString(4);
    }
    
    
    private JSONObject construireListeNbSoinsDeclaresJSON(Statistiques stats) {
        JSONObject listeNbSoinsDeclaresJSON = new JSONObject();
        
        // Map de format <Nom_type_de_soin, Nombre_soins_déclarés>
        Map<String, Integer> listeNbSoinsDeclares = stats.getListeNbSoinsDeclares();
        
        for (Map.Entry<String, Integer> entry : listeNbSoinsDeclares.entrySet()) {
            listeNbSoinsDeclaresJSON.put(entry.getKey(), entry.getValue());
        }

        return listeNbSoinsDeclaresJSON;
    }
}
