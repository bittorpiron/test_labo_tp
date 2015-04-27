/*
 * @Copyright Victor Piron Mardones.
 */
package org.equipe21.projetsession;

public final class ContratAssuranceTypeB extends ContratAssurance {

    public ContratAssuranceTypeB() {
        super();
        remplirTableIndemnites();
    }

    
    //Pour chaque Soin, ajouter le pourcentage applicable et le montant maximal
    @Override
    void remplirTableIndemnites() {
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(0), 50, "40.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(100), 50, "50.00$"));  
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(150), 0, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(175), 75, "0.00$"));                   
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(200), 100, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(300), 50, "0.00$"));  
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(400), 0, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(500), 50, "50.00$"));    
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(600), 100, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(700), 70, "0.00$"));  
    }    
    
}
