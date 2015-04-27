package org.equipe21.projetsession;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import net.sf.json.JSONObject;

public final class ReclamationAssurance {
    
    static final String OPTION_LIRE_STATISTIQUES = "-S";
    static final String OPTION_INITIALISER_STATISTIQUES = "-SR";
    static final String NOM_FICHIER_STATISTIQUES = "stats.json";
    static final String ENCODAGE_FICHIERS =  "UTF-8";
    static final char CONFIRMATION = 'O';

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void main(String[] args) throws IOException {
        new ReclamationAssurance(args);
    }

    
    ReclamationAssurance(String[] args) throws IOException {
        if (args.length == 1) {
            traiterOptions(args);
        } else if (args.length == 2) {
            validerFichiersParametresEntree(args);
        } else {
            System.out.println(Messages.NOMBRE_ARGUMENTS_INVALIDE);
        }
    }

    
    private void traiterOptions(String[] args) throws IOException {
        
        if (args[0].compareTo(OPTION_LIRE_STATISTIQUES) == 0) {
            System.out.println(recupererStatistiques());
        } else if(args[0].compareTo(OPTION_INITIALISER_STATISTIQUES) == 0) {
            traiterOptionResetStatistiques();
        }else{
            System.out.println(Messages.ARGUMENT_INVALIDE);
        }
    }

    
    private void traiterOptionResetStatistiques() throws IOException {
        if (demanderConfirmation(System.in)) {
            EcritureFichierJsonStatistiques ecrFichierJsonStats = new EcritureFichierJsonStatistiques(new Statistiques());
            ecrFichierJsonStats.ecrireFichier(NOM_FICHIER_STATISTIQUES);
            System.out.println(Messages.MISE_A_ZERO_REUSSIE);
        }
    }

    
    private Statistiques recupererStatistiques() {
        LectureFichierJson lectFichierJson = new LectureFichierJson();
        lectFichierJson.lireFichier(NOM_FICHIER_STATISTIQUES, ENCODAGE_FICHIERS);
        try {
            ConvertisseurJsonEnStatistiques conv = new ConvertisseurJsonEnStatistiques((JSONObject) lectFichierJson.getObjetSortie());
            return conv.construireStatistique();
        } catch (FichierStatistiqueEndommageException | ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException ex) {
            return new Statistiques();
        }
    }
    
    
    private void validerFichiersParametresEntree(String[] args) {
        LectureFichier  lecteurDeFichierEntree = new LectureFichierJson();
        
        if (lecteurDeFichierEntree.lireFichier(args[0], ENCODAGE_FICHIERS)) {            
            if (!traiterFichiersParametresEntree(lecteurDeFichierEntree, args[1])){
                System.out.println(Messages.ECHEC_ECRITURE_FICHIER); 
            }
        } else {
            System.out.println(Messages.ECHEC_OUVERTURE_FICHIER);
        }            
    }
     
    
    boolean traiterFichiersParametresEntree(LectureFichier lecteurDeFichierEntree, String nomFichierSortie) {      

        try {
            JSONObject donneesJson = (JSONObject) lecteurDeFichierEntree.getObjetSortie();
            ConvertisseurJsonEnDemandeReclamation conv = new ConvertisseurJsonEnDemandeReclamation(donneesJson);
            DemandeReclamation demandeEnCours = conv.construireDemandeReclamation();
            ReponseRemboursement reponseCourant = demandeEnCours.traiterDemande();
            return produireFichierSortie(nomFichierSortie, reponseCourant);
        } catch (ChampDonneesManquantFichierEntreeException | ErreurValeurFichierEntreeException ex) {
            return produireFichierSortieErreur(nomFichierSortie, ex.getMessage());
        }
        
    }
        
    
    boolean produireFichierSortie(String nomFichierSortie, ReponseRemboursement reponseCourant) {                    
        try {
            if ((new EcritureFichierJson(reponseCourant)).ecrireFichier(nomFichierSortie)){
                return miseAJourStatistiques(reponseCourant);
            }else{
                return miseAJourStatistiquesErreur();
            }    
        } catch (IOException ex) {
            return miseAJourStatistiquesErreur();
        }
    }
    

    private boolean miseAJourStatistiques(ReponseRemboursement reponseCourant) {
        Statistiques stats = recupererStatistiques();
        for (Soin soinDeclare : reponseCourant.getListeDesSoins().getListeDeSoins()){
            if ( soinDeclare.getNbrTraitements()> 0 ){
                stats.incrementerNbCategorieSoinDeclare(soinDeclare.getCategorie(), soinDeclare.getNbrTraitements());
            }
        }
        stats.incrementerNbReclamationsValidesTraitees();
        ecrireFichierStatistiques(stats);        
        return true;
    }
    

    private void ecrireFichierStatistiques(Statistiques stats) {
        try {
            new EcritureFichierJsonStatistiques(stats).ecrireFichier(NOM_FICHIER_STATISTIQUES);
        } catch (IOException ex) {
            System.out.println(Messages.ERREUR_ECRITURE_STATISTIQUES); 
        }
    }
    
    
    private boolean miseAJourStatistiquesErreur() {
         Statistiques stats = recupererStatistiques();
         stats.incrementerNbReclamationsRejetees();
         ecrireFichierStatistiques(stats);  
         return false;
    }
    
    
    protected boolean produireFichierSortieErreur(String nomFichierSortie, String messageErreur) {
      
        try {
            miseAJourStatistiquesErreur();
            return (new EcritureFichierJson(messageErreur)).ecrireFichier(nomFichierSortie);
            
        } catch (IOException ex) {
            return false;
        }
        
    }
    

    protected static boolean demanderConfirmation(InputStream source) throws IOException {
        Scanner sc = new Scanner(source);
        System.out.print(Messages.CONFIRMATION_REINITIALISATION);
        String reponse = sc.nextLine();
        return reponse.toUpperCase().charAt(0) == CONFIRMATION;        
    }
}
