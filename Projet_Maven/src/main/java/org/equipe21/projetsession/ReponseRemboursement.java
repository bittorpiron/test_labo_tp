package org.equipe21.projetsession;

import java.util.ArrayList;

public abstract class ReponseRemboursement {
    
    protected String codeClient;
    protected String mois;
    protected String typeContrat;
    protected ArrayList<Reclamation> remboursements;
    protected ContratAssurance contrat;
    protected Dollar montantTotalRemboursements = new Dollar(0.00);
   
   
    public ArrayList<Reclamation> getRemboursements() {
        return remboursements;
    }

    
    public void setRemboursements(ArrayList<Reclamation> remboursements) {
        this.remboursements = remboursements;
    }
    
    
    public Dollar getMontantTotalRemboursements() {
        return montantTotalRemboursements;
    }
    

    public void setMontantTotalRemboursements(Dollar montantTotalRemboursements) {
        this.montantTotalRemboursements = montantTotalRemboursements;
    }
    
    
    public void ajouterMontantAuTotalRemboursements(Dollar montantIndividuelRemboursements) {
        montantTotalRemboursements.addition(montantIndividuelRemboursements);
    }
    
    
    public void chargerDonneesContrat() {
        switch (typeContrat) {
            case "A":
                contrat = new ContratAssuranceTypeA();
                break;
            case "B":
                contrat = new ContratAssuranceTypeB();
                break;
            case "C":
                contrat = new ContratAssuranceTypeC();
                break;
            case "D":
                contrat = new ContratAssuranceTypeD();
                break;
            case "E":
                contrat = new ContratAssuranceTypeE();
                break;
        }
    }
    
    
    abstract void traiterDemande();
    
    abstract ListeDeSoins getListeDesSoins();  
}
