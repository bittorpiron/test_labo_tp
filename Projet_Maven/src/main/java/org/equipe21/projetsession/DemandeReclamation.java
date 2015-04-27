package org.equipe21.projetsession;

import java.util.ArrayList;

public abstract class DemandeReclamation {

    protected String codeClient;
    protected String mois;
    protected String typeContrat;
    protected ArrayList<Reclamation> reclamations;


    public ArrayList<Reclamation> getReclamations() {
        return reclamations;
    }


    public String getCodeClient() {
        return codeClient;
    }


    public String getMois() {
        return mois;
    }


    abstract ReponseRemboursement traiterDemande();

}
