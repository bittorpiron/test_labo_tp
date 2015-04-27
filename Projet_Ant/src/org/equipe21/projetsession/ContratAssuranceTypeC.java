/*
 * @Copyright Victor Piron Mardones.
 */
package org.equipe21.projetsession;

public final class ContratAssuranceTypeC extends ContratAssurance {

    public ContratAssuranceTypeC() {
        super();
        remplirTableIndemnites();
    }

    
    //Pour chaque Soin, ajouter le pourcentage applicable et le montant maximal
    @Override
    void remplirTableIndemnites() {
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(0), 90, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(100), 95, "0.00$"));  
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(150), 85, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(175), 90, "0.00$"));                    
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(200), 90, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(300), 90, "0.00$"));  
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(400), 90, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(500), 90, "0.00$"));    
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(600), 75, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(700), 90, "0.00$"));  
    }    
    
}
