package org.equipe21.projetsession;

import java.util.ArrayList;
import java.util.List;

/*
 * Liste des soins admissibles définis dans le contrat en cours d'utilisation
 */
public class ListeDeSoins {

    private List<Soin> listeDeSoins = new ArrayList<>();

    public ListeDeSoins() {

        this.listeDeSoins.add(new Soin(0, "Massothérapie", "0.00$"));
        this.listeDeSoins.add(new Soin(100, "Ostéopathie", "250.00$"));
        this.listeDeSoins.add(new Soin(150, "Kinésithérapie", "0.00$"));
        this.listeDeSoins.add(new Soin(175, "Médecin généraliste privé", "200.00$"));
        this.listeDeSoins.add(new Soin(200, "Psychologie individuelle", "250.00$"));
        this.listeDeSoins.add(new Soin(300, "Soins dentaires", "0.00$", true));
        this.listeDeSoins.add(new Soin(400, "Naturopathie, acuponcture", "0.00$"));
        this.listeDeSoins.add(new Soin(500, "Chiropratie", "150.00$"));
        this.listeDeSoins.add(new Soin(600, "Physiothérapie", "300.00$"));
        this.listeDeSoins.add(new Soin(700, "Orthophonie, ergothérapie", "0.00$"));

    }


    public List<Soin> getListeDeSoins() {
        return listeDeSoins;
    }


    public void setListeDeSoins(List<Soin> listeDeSoins) {
        this.listeDeSoins = listeDeSoins;
    }


    public Soin getSoinSelonCategorie(String categorie) {
        int indexListeSoins = 0;
        for (Soin soinAdmisible : listeDeSoins) {
            if (soinAdmisible.getCategorie().contentEquals(categorie)) {
                return listeDeSoins.get(indexListeSoins);
            }
            indexListeSoins++;
        }
        return null;
    }


    public Soin getSoinParNumero(Integer numeroSoin) {
        int indexListeSoins = 0;
        for (Soin soinAdmisible : listeDeSoins) {
            if (soinAdmisible.getNumeros().contains(numeroSoin)) {
                return listeDeSoins.get(indexListeSoins);
            }
            indexListeSoins++;
        }
        return null;
    }


    public boolean isSoinAdmisible(Integer numeroSoin) {

        for (Soin soinAdmisible : listeDeSoins) {
            if (soinAdmisible.getNumeros().contains(numeroSoin)) {
                return true;
            }
        }
        return false;
    }


}
