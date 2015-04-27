package org.equipe21.projetsession;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * Classe responsable de l'écriture du fichier réponse à l'utilisateur
 */
public class EcritureFichierJson implements EcritureFichier {

    protected final String donneesBrutes;

    
    public EcritureFichierJson() {
        JSONObject objetJSON = new JSONObject();
        objetJSON.put("message", Messages.ERREUR_DONNEES_INVALIDES);
        this.donneesBrutes = objetJSON.toString();
    }
    
    
    public EcritureFichierJson(String message) {
        JSONObject objetJSON = new JSONObject();
        objetJSON.put("message", message);
        this.donneesBrutes = objetJSON.toString();
    }
    
    
    public EcritureFichierJson(ReponseRemboursement reponse) {
        donneesBrutes = construireReponseJSON(reponse);
    }
    
        
    @Override
    public boolean ecrireFichier(String cheminAcces) throws IOException {
        Writer out = new BufferedWriter(new OutputStreamWriter(
         new FileOutputStream(cheminAcces), "UTF-8"));
     
        try {
            ecrireLesDonnees(new WriterWrapper(out));
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    
    
    private void ecrireLesDonnees(WriterWrapper file) throws IOException {
        file.write(donneesBrutes);
        file.flush();
        file.close();
    }

    
    protected final String construireReponseJSON(ReponseRemboursement reponse) {
        JSONObject objetJSON = new JSONObject();
        objetJSON.put("dossier", reponse.typeContrat + reponse.codeClient);
        objetJSON.put("mois", reponse.mois);
        objetJSON.put("remboursements", construireListeRemboursementsJSON(reponse));
        objetJSON.put("total", reponse.getMontantTotalRemboursements().toString());
        return objetJSON.toString(4);
    }

    
    protected JSONArray construireListeRemboursementsJSON(ReponseRemboursement reponse) {
        JSONArray listeDeSoinsJSON = new JSONArray();
        JSONObject soinJSON;
        for (Reclamation remboursement : reponse.remboursements) {
            soinJSON = new JSONObject();
            construireRemboursementJSON(soinJSON, remboursement);
            listeDeSoinsJSON.add(soinJSON);            
        }
        return listeDeSoinsJSON;
    }

    
    protected void construireRemboursementJSON(JSONObject jsonSoin, Reclamation soin) {
        jsonSoin.put("soin", soin.getNumeroSoin());
        jsonSoin.put("date", soin.getDate());
        jsonSoin.put("montant", soin.getMontantRemboursement().toString());
    }
    
}
