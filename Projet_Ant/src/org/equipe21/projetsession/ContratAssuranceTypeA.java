/*
 * @Copyright Victor Piron Mardones.
 */
package org.equipe21.projetsession;

public final class ContratAssuranceTypeA extends ContratAssurance  {
    
    public ContratAssuranceTypeA() {
        super();
        remplirTableIndemnites();
    }
    
    
    //Pour chaque Soin, ajouter le pourcentage applicable et le montant maximal     
    @Override
    void remplirTableIndemnites() {  
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(0), 25, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(100), 35, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(150), 0, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(175), 50, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(200), 25, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(300), 0, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(400), 0, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(500), 25, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(600), 40, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(700),  0, "0.00$"));
    }    
    
}
