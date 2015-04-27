package org.equipe21.projetsession;

/*
 *   Les instances de cette classe gardent, pour chaque catégorie de soin,
 *   l'instance du soin plus les données de pourcentage et montant maximal
 *   selon le type de contrat.
 */
public class Indemnite {

    private Soin soin;
    private Integer pourcentage;
    private Dollar montantMaximal;

    public Indemnite(Soin soin, Integer pourcentage, String montant) {
        this.soin = soin;
        this.pourcentage = pourcentage;
        this.montantMaximal = new Dollar(montant);
    }

    
    public Soin getSoin() {
        return soin;
    }


    public void setSoin(Soin soin) {
        this.soin = soin;
    }


    public Integer getPourcentage() {
        return pourcentage;
    }


    public void setPorcentage(Integer pourcentage) {
        this.pourcentage = pourcentage;
    }


    public Dollar getMontantMaximal() {
        return montantMaximal;
    }


    public void setMontantMaximal(Dollar montant) {
        this.montantMaximal = montant;
    }


}
