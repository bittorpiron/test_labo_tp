
package org.equipe21.projetsession;

import static org.equipe21.projetsession.Messages.ERREUR_CHAMP_INCOMPLET;
import static org.equipe21.projetsession.Messages.ERREUR_FICHIER_STATISTIQUES;

class ErreurValeurFichierEntreeException extends Exception {
    public ErreurValeurFichierEntreeException(String Message) {
        super(Message);
    }
}


class ChampDonneesManquantFichierEntreeException extends Exception {
    public ChampDonneesManquantFichierEntreeException(String nomDuChamp) {
        super(ERREUR_CHAMP_INCOMPLET + nomDuChamp);
    }
}


class FichierStatistiqueEndommageException extends Exception {
    public FichierStatistiqueEndommageException(String valeur) {
        super(ERREUR_FICHIER_STATISTIQUES + valeur);
    }
}