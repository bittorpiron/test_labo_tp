package org.equipe21.projetsession;

import java.util.ArrayList;

public final class ReponseRemboursementMensuelle extends ReponseRemboursement {

    
    public ReponseRemboursementMensuelle(String codeClient, String mois,
            String typeContrat, ArrayList<Reclamation> remboursements) {
        
        this.codeClient = codeClient;
        this.mois = mois;
        this.typeContrat = typeContrat;
        this.remboursements = remboursements;
                              
        chargerDonneesContrat();  
        traiterDemande();  
 
    }   
    
    
    @Override
    public void traiterDemande() {         
        for (Reclamation soin : remboursements) {
            contrat.traiterUneReclamation(soin);
            ajouterMontantAuTotalRemboursements(soin.getMontantRemboursement());
        }
    }   
    
    @Override    
    public ListeDeSoins getListeDesSoins(){        
        
            return contrat.getSoinsAdmisibles();
        
    }
    
}
