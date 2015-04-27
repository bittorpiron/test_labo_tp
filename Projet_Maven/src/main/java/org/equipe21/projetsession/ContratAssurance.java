package org.equipe21.projetsession;

import java.util.HashMap;
import java.util.Map;

/*
 * Classe chargée du calcul des montants à rembourser selon le type de contrat.
 */
public abstract class ContratAssurance {

    protected final Map<Integer, Indemnite> indemnites;
    protected final ListeDeSoins soinsAdmisibles;

    public ContratAssurance() {
        this.indemnites = new HashMap<>();
        this.soinsAdmisibles = new ListeDeSoins();
    }


    abstract void remplirTableIndemnites();

    
    public ListeDeSoins getSoinsAdmisibles() {
        return soinsAdmisibles;
    }

    
    Reclamation traiterUneReclamation(Reclamation reclamation) {
        
        int numeroSoin = reclamation.getNumeroSoin();
        Soin soin = soinsAdmisibles.getSoinParNumero(numeroSoin);
        
        int pourcentageApplicable = indemnites.get(numeroSoin).getPourcentage();
        Dollar montantMaxRemboursable = indemnites.get(numeroSoin).getMontantMaximal();
        
        Dollar montantRemboursable =  reclamation.getMontantReclamation().getPourcentage(pourcentageApplicable);
        Dollar montantRemboursement = calculerMontantRemboursable(montantRemboursable, montantMaxRemboursable);
  
        reclamation.setMontantRemboursement(soin.calculerMontantMensuel(montantRemboursement));
        
        return reclamation;
    }


    protected Dollar calculerMontantRemboursable(Dollar montantRemboursable, Dollar montantMaxRemboursable) {

        if (montantMaxRemboursable.estEgal(new Dollar(0.00)) || montantRemboursable.estPlusPetitOuEgal(montantMaxRemboursable)) {
            return montantRemboursable;
        } else {
            return montantMaxRemboursable;
        } 
    }


    protected void ajouterIndemnites(Indemnite nouvelleIndemnite) {

        for (Integer numeroSoin : nouvelleIndemnite.getSoin().getNumeros()) {
            indemnites.put(numeroSoin, nouvelleIndemnite);
        }
    }


}
