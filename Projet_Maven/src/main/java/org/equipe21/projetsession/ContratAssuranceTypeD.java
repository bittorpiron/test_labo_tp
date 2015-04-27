/*
 * @Copyright Victor Piron Mardones.
 */
package org.equipe21.projetsession;

public final class ContratAssuranceTypeD extends ContratAssurance {

    public ContratAssuranceTypeD() {
        super();
        remplirTableIndemnites();
    }

    
    //Pour chaque Soin, ajouter le pourcentage applicable et le montant maximal
    @Override
    void remplirTableIndemnites() {     
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(0), 100, "85.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(100), 100, "75.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(150), 100, "150.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(175), 95, "0.00$"));                    
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(200), 100, "100.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(300), 100, "0.00$"));  
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(400), 100, "65.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(500), 100, "0.00$"));    
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(600), 100, "100.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(700), 100, "90.00$"));  

    }    
}
