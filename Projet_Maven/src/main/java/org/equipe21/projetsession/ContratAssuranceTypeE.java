/*
 * @Copyright Victor Piron Mardones.
 */
package org.equipe21.projetsession;

public final class ContratAssuranceTypeE extends ContratAssurance {

    public ContratAssuranceTypeE() {
        super();    
        remplirTableIndemnites();
    }


    //Pour chaque Soin, ajouter le pourcentage applicable et le montant maximal
    @Override
    void remplirTableIndemnites() {        
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(0), 15, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(100), 25, "0.00$")); 
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(150), 15, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(175), 25, "20.00$"));                 
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(200), 12, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(300), 60, "0.00$"));  
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(400), 25, "15.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(500), 30, "20.00$"));    
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(600), 15, "0.00$"));
        ajouterIndemnites(new Indemnite(soinsAdmisibles.getSoinParNumero(700), 22, "0.00$"));  
                
    }  
    
}

