
package org.equipe21.projetsession;

import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import static org.equipe21.projetsession.Messages.CLIENT_INVALIDE;
import static org.equipe21.projetsession.Messages.CONCORDANCE_DATE_MOIS_INVALIDE;
import static org.equipe21.projetsession.Messages.ERREUR_FICHIER_ENTREE;
import static org.equipe21.projetsession.Messages.FORMAT_DATE_INVALIDE;
import static org.equipe21.projetsession.Messages.FORMAT_MOIS_INVALIDE;
import static org.equipe21.projetsession.Messages.FORMAT_MONTANT_INVALIDE;
import static org.equipe21.projetsession.Messages.LETTRE_TYPE_CONTRAT_INVALIDE;
import static org.equipe21.projetsession.Messages.NUMERO_SOIN_INVALIDE;

public class ConvertisseurJsonEnDemandeReclamation {

    static Validateur validateurDonnees;
    private JSONObject donneesJsonSource = null;
    
    
    ConvertisseurJsonEnDemandeReclamation(JSONObject donneesJsonSource) {
        validateurDonnees = new Validateur();
        this.donneesJsonSource = donneesJsonSource;
    }
    
    
    public DemandeReclamation construireDemandeReclamation()
            throws ErreurValeurFichierEntreeException,
                   ChampDonneesManquantFichierEntreeException {

        validerChampsExistantsPartieGenerale(donneesJsonSource);
        validerDonneesPartieGenerale(donneesJsonSource);

        return new DemandeReclamationMensuelle(donneesJsonSource.getString("mois"),
                                               donneesJsonSource.getString("dossier"),
                                               convertirArrayJsonEnListeReclamation(donneesJsonSource));
    }

    
    private void validerChampsExistantsPartieGenerale(JSONObject donneesJsonSource)
            throws ChampDonneesManquantFichierEntreeException {

        if (!donneesJsonSource.containsKey("mois")) {
            throw new ChampDonneesManquantFichierEntreeException("mois");
        }

        if (!donneesJsonSource.containsKey("dossier")) {
            throw new ChampDonneesManquantFichierEntreeException("dossier");
        }

        if (!donneesJsonSource.containsKey("reclamations")) {
            throw new ChampDonneesManquantFichierEntreeException("reclamations");
        }

    }
    

    private void validerDonneesPartieGenerale(JSONObject donneesJsonSource)
            throws ChampDonneesManquantFichierEntreeException,
                   ErreurValeurFichierEntreeException {

        if (!validateurDonnees.validerMois(donneesJsonSource.getString("mois"))) {
            throw new ErreurValeurFichierEntreeException(ERREUR_FICHIER_ENTREE + FORMAT_MOIS_INVALIDE);
        }

        if (!validateurDonnees.validerLettreContrat(donneesJsonSource.getString("dossier").charAt(0))) {
            throw new ErreurValeurFichierEntreeException(ERREUR_FICHIER_ENTREE + LETTRE_TYPE_CONTRAT_INVALIDE);
        }

        if (!validateurDonnees.validerClient(donneesJsonSource.getString("dossier").substring(1))) {
            throw new ErreurValeurFichierEntreeException(ERREUR_FICHIER_ENTREE + CLIENT_INVALIDE);
        }
    }

    
    private ArrayList<Reclamation> convertirArrayJsonEnListeReclamation(JSONObject donneesJsonSource)
            throws ErreurValeurFichierEntreeException,
                   ChampDonneesManquantFichierEntreeException {

        ArrayList<Reclamation> reclamations = new ArrayList<>();

        for (int i = 0; i < donneesJsonSource.getJSONArray("reclamations").size(); i++) {
            convertirDonneeJsonEnReclamation(donneesJsonSource, i, reclamations);
        }

        return reclamations;
    }

    
    private void convertirDonneeJsonEnReclamation(JSONObject donneesJsonSource, int index, ArrayList<Reclamation> reclamations)
            throws ErreurValeurFichierEntreeException,
                   ChampDonneesManquantFichierEntreeException {
        
        JSONArray joReclamations = donneesJsonSource.getJSONArray("reclamations");
        JSONObject joProchaineReclamation = joReclamations.getJSONObject(index);

        validerChampsExistantsPartieReclamation(joProchaineReclamation);
        validerDonneesPartieReclamation(donneesJsonSource, joProchaineReclamation);
        
        reclamations.add(new Reclamation(joProchaineReclamation.getInt("soin"),
                        joProchaineReclamation.getString("date"),
                        joProchaineReclamation.getString("montant")));
    }

    
    private void validerChampsExistantsPartieReclamation(JSONObject jsonObjectReclamation)
            throws ChampDonneesManquantFichierEntreeException {

        if (!jsonObjectReclamation.containsKey("soin")) {
            throw new ChampDonneesManquantFichierEntreeException("soin");
        }

        if (!jsonObjectReclamation.containsKey("date")) {
            throw new ChampDonneesManquantFichierEntreeException("date");
        }

        if (!jsonObjectReclamation.containsKey("montant")) {
            throw new ChampDonneesManquantFichierEntreeException("montant");
        }
    }
    

    private void validerDonneesPartieReclamation(JSONObject jsonObjetSource, JSONObject jsonObjetReclamation)
            throws ChampDonneesManquantFichierEntreeException,
                   ErreurValeurFichierEntreeException {

        if (!validateurDonnees.validerNumeroSoin(jsonObjetReclamation.getInt("soin"))) {
            throw new ErreurValeurFichierEntreeException(ERREUR_FICHIER_ENTREE + NUMERO_SOIN_INVALIDE +
                                                         jsonObjetReclamation.getInt("soin"));
        }

        if (!validateurDonnees.validerMontantString(jsonObjetReclamation.getString("montant"))) {
            throw new ErreurValeurFichierEntreeException(ERREUR_FICHIER_ENTREE + FORMAT_MONTANT_INVALIDE +
                                                         jsonObjetReclamation.getString("montant"));
        }

        validerChampsDate(jsonObjetSource, jsonObjetReclamation);
    }

    
    private void validerChampsDate(JSONObject jsonObjetSource, JSONObject jsonObjetReclamation)
            throws ErreurValeurFichierEntreeException {

        if (!validateurDonnees.validerDate(jsonObjetReclamation.getString("date"))) {
            throw new ErreurValeurFichierEntreeException(ERREUR_FICHIER_ENTREE + FORMAT_DATE_INVALIDE +
                                                         jsonObjetReclamation.getString("date"));
        }

        if (!validateurDonnees.validerDateAppartientMois(jsonObjetSource.getString("mois"), jsonObjetReclamation.getString("date"))) {
            throw new ErreurValeurFichierEntreeException(ERREUR_FICHIER_ENTREE + CONCORDANCE_DATE_MOIS_INVALIDE +
                                                         jsonObjetReclamation.getString("date"));
        }
    }
    
}