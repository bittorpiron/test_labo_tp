
package org.equipe21.projetsession;

import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ConvertisseurJsonEnStatistiques {
    
    static Validateur validateurDonnees;
    private JSONObject donneesJsonSource = null;
    
    
    ConvertisseurJsonEnStatistiques(JSONObject donneesJsonSource) {
        validateurDonnees = new Validateur();
        this.donneesJsonSource = donneesJsonSource;
    }
    
    
    public Statistiques construireStatistique()
            throws ErreurValeurFichierEntreeException,
                   ChampDonneesManquantFichierEntreeException,
                   FichierStatistiqueEndommageException {

        validerChampsExistants(donneesJsonSource);
        validerDonneesPartieGenerale(donneesJsonSource);
        
        return new Statistiques(donneesJsonSource.getInt("nb_reclamations_valide_traitees"),
                                donneesJsonSource.getInt("nb_reclamations_rejetees"),
                                trouverListeNbSoinsDeclares(donneesJsonSource.getJSONObject("nb_soins_declares")));
    }

    
    private void validerDonneesPartieGenerale(JSONObject donneesJsonSource)
                    throws FichierStatistiqueEndommageException {

        if (!validateurDonnees.validerStringEnIntegerPositif(donneesJsonSource.getString("nb_reclamations_valide_traitees"))) {
            throw new FichierStatistiqueEndommageException(donneesJsonSource.getString("nb_reclamations_valide_traitees"));
        }
        
        if (!validateurDonnees.validerStringEnIntegerPositif(donneesJsonSource.getString("nb_reclamations_rejetees"))) {
            throw new FichierStatistiqueEndommageException(donneesJsonSource.getString("nb_reclamations_rejetees"));
        }
    }
    
    
    private void validerChampsExistants(JSONObject donneesJsonSource)
            throws ChampDonneesManquantFichierEntreeException {

        if (!donneesJsonSource.containsKey("nb_reclamations_valide_traitees")) {
            throw new ChampDonneesManquantFichierEntreeException("nb_reclamations_valide_traitees");
        }

        if (!donneesJsonSource.containsKey("nb_reclamations_rejetees")) {
            throw new ChampDonneesManquantFichierEntreeException("nb_reclamations_rejetees");
        }

        if (!donneesJsonSource.containsKey("nb_soins_declares")) {
            throw new ChampDonneesManquantFichierEntreeException("nb_soins_declares");
        }
    }

    
    // La structure de données générée en sortie est de format Map<Nom_du_type_de_soin, Nombre_soins_déclarés>
    Map<String, Integer> trouverListeNbSoinsDeclares(JSONObject jsonDonneesNbSoinsDeclares)
            throws ErreurValeurFichierEntreeException,
                   ChampDonneesManquantFichierEntreeException {
        
        Map<String, Integer> listeNbSoinsDeclares = new HashMap<>();
        JSONArray cles = jsonDonneesNbSoinsDeclares.names();
        
        for (int i = 0; i < cles.size(); i++) {
            String prochaineCleJson = cles.getString(i);
            listeNbSoinsDeclares.put(prochaineCleJson,
                                     Integer.parseInt(jsonDonneesNbSoinsDeclares.getString(prochaineCleJson)));
        }

        return listeNbSoinsDeclares;
    }
}