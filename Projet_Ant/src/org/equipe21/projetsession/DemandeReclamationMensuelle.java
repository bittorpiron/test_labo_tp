package org.equipe21.projetsession;

import java.util.ArrayList;

public class DemandeReclamationMensuelle extends DemandeReclamation {
    
    
    DemandeReclamationMensuelle(String mois, String dossier, ArrayList<Reclamation> reclamations) {
        this.codeClient = dossier.substring(1);
        this.mois = mois;
        this.typeContrat = String.valueOf(dossier.charAt(0));
        this.reclamations = reclamations;
    }

    
    public void ajouterReclamation(Reclamation reclamation) {
        reclamations.add(reclamation);
    }

    
    @Override
    public ReponseRemboursement traiterDemande() {        
        return new ReponseRemboursementMensuelle(codeClient, mois, typeContrat, reclamations);
    }
    
}