
package org.equipe21.projetsession;

import java.io.IOException;
import net.sf.json.JSONObject;
import org.equipe21.FileReader.FileReader;

/*
 * Classe responsable de la lecture d'un fichier JSON de format valide
 */
public class LectureFichierJson implements LectureFichier, Messages {

    private String donneesBrutes = null;
    
    
    LectureFichierJson() {
    }

    
    void setDonneesBrute(String donnees) {
        donneesBrutes = donnees;
    }
    
    
    @Override
    public boolean lireFichier(String cheminAcces, String encodage) {
        try {
            donneesBrutes = FileReader.loadFileIntoString(cheminAcces, encodage);
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    
    @Override
    public Object getObjetSortie()
            throws ErreurValeurFichierEntreeException {
        
        JSONObject objetSortie = null;
        
        try {
            objetSortie = JSONObject.fromObject(donneesBrutes);
        } catch (net.sf.json.JSONException e) {
            throw new ErreurValeurFichierEntreeException(ERREUR_FICHIER_ENTREE + ECHEC_CONVERSION_JSON);
        }
        
        return (Object) objetSortie;
    }
}