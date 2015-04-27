
package org.equipe21.projetsession;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Statistiques {
    
    private int nbReclamationsValidesTraitees = 0;
    private int nbReclamationsRejetees = 0;
    
    // Map de format <Nom_type_de_soin, Nombre_soins_déclarés>
    private Map<String, Integer> nbSoinsDeclares = new HashMap<>();
    
    
    Statistiques() {
    }
    
    
    // Map de format <Nom_type_de_soin, Nombre_soins_déclarés>
    Statistiques(int nbReclamationsValidesTraitees, int nbReclamationsRejetees, Map<String, Integer> nbSoinsDeclares) {
        this.nbReclamationsValidesTraitees = nbReclamationsValidesTraitees;
        this.nbReclamationsRejetees = nbReclamationsRejetees;
        this.nbSoinsDeclares = nbSoinsDeclares;
    }
    
    
    public int getNbReclamationsValidesTraitees() {
        return nbReclamationsValidesTraitees;
    }
    
    
    public void incrementerNbReclamationsValidesTraitees() {
        nbReclamationsValidesTraitees++;
    }
    
    
    public int getNbReclamationsRejetees() {
        return nbReclamationsRejetees;
    }
    
    
    public void incrementerNbReclamationsRejetees() {
        nbReclamationsRejetees++;
    }
    
    
    public int getNbCategorieSoinDeclare(String categorieSoin) {
        if (nbSoinsDeclares.containsKey(categorieSoin)) {
            return nbSoinsDeclares.get(categorieSoin);
        }
        else {
            return 0;
        }
    }
    
    
    public void incrementerNbCategorieSoinDeclare(String categorieSoin) {
        incrementerNbCategorieSoinDeclare(categorieSoin, 1);
    }
    
    
    public void incrementerNbCategorieSoinDeclare(String categorieSoin, int nbrIncrements) {
        if (nbSoinsDeclares.containsKey(categorieSoin)) {
            nbSoinsDeclares.put(categorieSoin, nbSoinsDeclares.get(categorieSoin) + nbrIncrements);
        }
        else {
            nbSoinsDeclares.put(categorieSoin, nbrIncrements);
        }
    }
    
    
    // Map de format <Nom_type_de_soin, Nombre_soins_déclarés>
    public Map<String, Integer> getListeNbSoinsDeclares(){ 
        return nbSoinsDeclares;
    }
    
    
    @Override
    public String toString() {
        String contenuAffichageStatistiques =
                "Nombre de réclamations valides traitées = " + String.valueOf(nbReclamationsValidesTraitees) +
                "\nNombre de réclamations rejetées = " + String.valueOf(nbReclamationsRejetees);
        
        // Map de format <Nom_type_de_soin, Nombre_soins_déclarés>
        for (Entry<String, Integer> prochainSoin : nbSoinsDeclares.entrySet()) {
            contenuAffichageStatistiques +=
                    "\nNombre de soins déclarés pour \"" + prochainSoin.getKey() + "\" = " +
                    String.valueOf(prochainSoin.getValue());
        }
        
        return contenuAffichageStatistiques;
    }
}