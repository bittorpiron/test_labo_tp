package org.equipe21.projetsession;

/*
 * Classe qui contient toute la logique de manipulation monétaire.
 */
public class Dollar {
    
    private int totalCents;
    
    public Dollar() {
        totalCents = 0;
    }
    
    
    public Dollar(String montant) {
        //Enlever les caractères non numériques d'un montant déjà validé "xxx.xx$"
        totalCents = Integer.parseInt(montant.replaceAll("[. , $]", ""));
    }
    
    
    public Dollar(double montant) {
        totalCents = (int) (montant * 100);
    }

    
    public Dollar(int cents) {
        totalCents = cents;
    }
    
    
    public Double dollarToDouble() {
        return Double.parseDouble(getDollars() + "." + getCents());
    }
    
    
    public int doubleToCents(double montant) {
        return (int) (montant * 100);
    }
    
    
    public int getTotalCents() {
        return totalCents;
    }
    
    
    public int getDollars() {
        return totalCents/100;
    }
    
    
    public int getCents() {
        return totalCents%100;
    }
    
    
    public Dollar getPourcentage(int pourcentage) {
        return new Dollar( pourcentage * totalCents / 100);
    }

    
    public void setTotalCents(int montant) {
        totalCents = montant;
    }
    
    
    public void setTotalCents(double montant) {
        totalCents = (int) (montant * 100);
    }
    
    
    public static Dollar additionDollars(Dollar montant1, Dollar montant2) {
        return new Dollar(montant1.getTotalCents() + montant2.getTotalCents());
    }
    
    
    public void addition(double montant) {
        totalCents = getTotalCents() + doubleToCents(montant);
    }
    
    
    public void addition(Dollar montant) {
        totalCents = getTotalCents() + montant.getTotalCents();
    }
    
    
    public static Dollar soubstractionDollars(Dollar montant1, Dollar montant2) {
        return new Dollar(montant1.getTotalCents() - montant2.getTotalCents());
    }
    
    
    public void soustraction(double montant) {
        totalCents = getTotalCents() - doubleToCents(montant);
    }
    
    
    public void soustraction(Dollar montant) {
        totalCents = getTotalCents() - montant.getTotalCents();
    }    
    
    
    public Dollar multiplicationDollars(Dollar montant1, Dollar montant2) {
        return new Dollar(montant1.getTotalCents() * montant2.getTotalCents());
    }
    
    
    public void multiplication(int montant) {
        totalCents = getTotalCents() * montant;
    }
    
    
    public void multiplication(Dollar montant) {
        totalCents =(getTotalCents() * montant.getTotalCents())/100;
    }    
 
    
    public Dollar divisionDollars(Dollar montant1, Dollar montant2) {
        return new Dollar(montant1.getTotalCents() / montant2.getTotalCents());
    }
    
    
    public void division(int montant) {
        totalCents = getTotalCents() / montant;
    }
    
    
    public void division(Dollar montant) {
        totalCents = (getTotalCents() * 100) / montant.getTotalCents();
    }
    
    
    public boolean estEgal(Dollar montant) {
        return getTotalCents() == montant.getTotalCents();
    }
    
    
    public boolean estPlusPetit(Dollar montant) {
        return getTotalCents() < montant.getTotalCents();
    }
    
    
    public boolean estPlusPetitOuEgal(Dollar montant) {
        return getTotalCents() <= montant.getTotalCents();
    }
    
    
    public boolean estPlusGrand(Dollar montant) {
        return getTotalCents() > montant.getTotalCents();
    }
    
    
    public boolean estPlusGrandOuEgal(Dollar montant) {
        return getTotalCents() >= montant.getTotalCents();
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }


    @Override
    public boolean equals(Object autreObjet) {
        if (autreObjet == null) {
            return false;
        }
        if (getClass() != autreObjet.getClass()) {
            return false;
        }
        final Dollar autreDollar = (Dollar) autreObjet;
        return this.totalCents == autreDollar.totalCents;
    }    
    
    
    @Override
    public String toString() {
        int cents = getCents();
        String chaineDollar = getDollars() + ".";
        if (cents < 10){
            chaineDollar += "0";
        }
        return chaineDollar + getCents() + "$";
    }

}
