package org.equipe21.projetsession;

public class Reclamation {
    private int numeroSoin;
    private String date;
    private Dollar montantReclamation;
    private Dollar montantRemboursement = new Dollar();
    

    public Reclamation() {
        this.montantReclamation = new Dollar();        
        this.numeroSoin = 0;
    }
    

    public Reclamation(int numeroSoin, String date, String montant) {
        this.numeroSoin = numeroSoin;
        this.date = date;
        this.montantReclamation = new Dollar(montant);
    }
    

    public int getNumeroSoin() {
        return numeroSoin;
    }
    

    public void setNumeroSoin(int numeroSoin) {
        this.numeroSoin = numeroSoin;
    }
    

    public String getDate() {
        return date;
    }
    

    public void setDate(String date) {
        this.date = date;
    }
    

    public Dollar getMontantReclamation() {
        return montantReclamation;
    }

    
    public void setMontantReclamation(Dollar montant) {
        this.montantReclamation = montant;
    }
    
    
    public Dollar getMontantRemboursement() {
        return montantRemboursement;
    }

    
    public void setMontantRemboursement(Dollar montant) {
        this.montantRemboursement = montant;
    }
    
}
