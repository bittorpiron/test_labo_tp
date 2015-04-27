
package org.equipe21.projetsession;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Validateur {
    
    ListeDeSoins listeSoinsAdmisibles;
    
    public Validateur() {
        
        listeSoinsAdmisibles = new ListeDeSoins();
        
    }


    public boolean validerLettreContrat(char lettreContrat) {
        return lettreContrat > '@' && lettreContrat < 'F';
    }

        
    public boolean validerClient(String codeClient) {
        int nombreChiffre = codeClient.length();
        if (nombreChiffre == 6) {
            for (int i = 0; i < nombreChiffre; i++) {
                if (codeClient.charAt(i) < '0' || codeClient.charAt(i) > '9') {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    
    public boolean validerMois(String mois) {
        if (mois.length() == 7) {
            return validerDate(mois, "yyyy-MM");
        }
        return false;
    }

    
    public boolean validerDate(String date) {
        if (date != null && date.length() == 10) {
            return validerDate(date, "yyyy-MM-dd");
        }
        return false;
    }

    
    public boolean validerDate(String dateAValider, String formatDeDate) {

        if (dateAValider == null) {
            return false;
        }

        SimpleDateFormat formatDate = new SimpleDateFormat(formatDeDate);
        formatDate.setLenient(false);

        return estUneDateValide(formatDate, dateAValider);

    }

    
    private boolean estUneDateValide(SimpleDateFormat formatDate, String dateAValider) {

        try {
            formatDate.parse(dateAValider);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }

    public boolean validerDateAppartientMois(String mois, String date) {
        return date.contains(mois);
    }
 
    
    public boolean validerNumeroSoin(int numeroSoin) {
        
        
        return listeSoinsAdmisibles.isSoinAdmisible(numeroSoin);
        
    }

    
    public boolean validerMontantString(String montant) {
        int nombreDeCaracteres = montant.length();
        //0.00$ mimimun
        if (nombreDeCaracteres > 4) {            
            return validerCaracteresMontantString(nombreDeCaracteres, montant);
        }else{
            return false;
        }
    }

    
    private boolean validerCaracteresMontantString(int nombreDeCaracteres, String montant) {
        for (int i = 0; i < nombreDeCaracteres; i++) {
            
            if (pasDeSigneDollar(i, nombreDeCaracteres, montant) ||
                pasDeSeparateurValide(i, nombreDeCaracteres, montant) || 
                pasChiffres(i, nombreDeCaracteres, montant)) {
                return false;
            }
            
        }
        return true;
    }
   

    private static boolean pasChiffres(int i, int n, String montant) {
        return i != n - 1 && i != n - 4 && (montant.charAt(i) > '9' || montant.charAt(i) < '0');
    }
    

    private static boolean pasDeSeparateurValide(int i, int n, String montant) {
        return i == n - 4 && (montant.charAt(i) != '.' && montant.charAt(i) != ',');
    }

    
    private static boolean pasDeSigneDollar(int i, int n, String montant) {
        return i == n - 1 && montant.charAt(i) != '$';
    }
    
    
    public boolean validerStringEnIntegerPositif(String nombre) {        
        try {
          return Integer.parseInt(nombre)>=0;  
        } catch (Exception e) {
          return false;
        }
    }
}
