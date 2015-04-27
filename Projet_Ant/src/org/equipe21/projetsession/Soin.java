package org.equipe21.projetsession;

import java.util.ArrayList;
import java.util.List;
/*
 *   Les instances de cette classe gardent l'information de chaque categorie
 *   de soin ainsi que les comptages par exécution (totalActuel, nbrTraitements)  
 */

public class Soin {

    private List<Integer> numeros = new ArrayList<>();
    private String categorie = "";
    private Dollar maximumMensuel;
    private boolean centaine = false;
    private Dollar totalActuel = new Dollar(0.00);
    private Integer nbrTraitements = 0;

    public Soin(Integer numero, String categorie, String maximumMensuel) {
        this.numeros.add(numero);
        this.categorie = categorie;
        this.maximumMensuel = new Dollar(maximumMensuel);
    }


    public Soin(Integer numero, String categorie, String maximumMensuel, Boolean touteLaCentaine) {
        for (int i = numero; i < numero + 100; i++) {
            this.numeros.add(i);
        }
        this.categorie = categorie;
        this.maximumMensuel = new Dollar(maximumMensuel);
    }


    public List<Integer> getNumeros() {
        return numeros;
    }


    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }


    public String getCategorie() {
        return categorie;
    }


    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }


    public Dollar getMaximumMensuel() {
        return maximumMensuel;
    }


    public void setMaximumMensuel(Dollar maximumMensuel) {
        this.maximumMensuel = maximumMensuel;
    }


    public boolean isCentaine() {
        return centaine;
    }


    public void setCentaine(boolean centaine) {
        this.centaine = centaine;
    }


    public Dollar getTotalActuel() {
        return totalActuel;
    }


    public void setTotalActuel(Dollar totalActuel) {
        this.totalActuel = totalActuel;
    }


    public Integer getNbrTraitements() {
        return nbrTraitements;
    }


    public void setNbrTraitements(Integer nbrTraitements) {
        this.nbrTraitements = nbrTraitements;
    }


    public Dollar calculerMontantMensuel(Dollar nouveauMontant) {

        nbrTraitements++;
        if ((maximumMensuel.getTotalCents() > 0)
                && (Dollar.additionDollars(totalActuel, nouveauMontant).estPlusGrand(maximumMensuel))) {

            nouveauMontant = Dollar.soubstractionDollars(maximumMensuel, totalActuel);
            totalActuel = maximumMensuel;
        } else {
            totalActuel.addition(nouveauMontant);
        }
        return nouveauMontant;
    }


}
