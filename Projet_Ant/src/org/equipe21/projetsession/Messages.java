package org.equipe21.projetsession;

public interface Messages {
   static final String NOMBRE_ARGUMENTS_INVALIDE = "Le nombre d'arguments passé en ligne de commande est inadéquat.";
   static final String ARGUMENT_INVALIDE = "L'argument passé en ligne de commande est inadéquat.";
   static final String ECHEC_OUVERTURE_FICHIER = "Échec lors de l'ouverture du fichier source.";
   static final String ECHEC_ECRITURE_FICHIER = "Échec lors de l'écriture du fichier destination.";
   static final String ECHEC_CONVERSION_JSON = "Imposible de convertir les données en objet JSON.";
   static final String LETTRE_TYPE_CONTRAT_INVALIDE = "Le dossier ne débute pas avec une lettre de contrat valide.";
   static final String CLIENT_INVALIDE = "Le dossier ne comporte pas un numéro client valide.";
   static final String FORMAT_MOIS_INVALIDE = "Le mois ne respecte pas le format AAAA-MM.";
   static final String FORMAT_DATE_INVALIDE = "Date non de format yyyy-MM-dd : ";
   static final String CONCORDANCE_DATE_MOIS_INVALIDE = "Date de réclamation ne correspondant pas au mois de la demande : ";
   static final String NUMERO_SOIN_INVALIDE = "Numéro de soin inconnu : ";
   static final String FORMAT_MONTANT_INVALIDE = "Format du montant invalide : ";
   static final String ERREUR_FICHIER_ENTREE = "Le fichier d'entrée comporte au moins une erreur dans son contenu. ";
   static final String ERREUR_CHAMP_INCOMPLET = "Le fichier d'entrée est incomplet. Champ manquant : ";
   static final String ERREUR_FICHIER_STATISTIQUES = "Le fichier comportant les statistiques est endommagé.";
   static final String ERREUR_DONNEES_INVALIDES = "Données invalides";
   static final String ERREUR_ECRITURE_STATISTIQUES = "Erreur lors de l'écriture du fichier de statistiques.";
   
   static final String CONFIRMATION_REINITIALISATION = "Êtes-vous certain de vouloir réinitialiser les statistiques ? ([O,o] pour confirmer) : ";
   static final String MISE_A_ZERO_REUSSIE = "Mise à zéro des statistiques réussie.";
}
