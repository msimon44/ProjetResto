package com.example.projetresto.modele.metier;

public class resto {


    protected String nomR;
    protected String villeR;
    protected String typeResto;
    protected String adresseResto;

    public resto(String nomR, String villeR, String typeResto, String adresseResto) {
        this.nomR = nomR;
        this.villeR = villeR;
        this.typeResto = typeResto;
        this.adresseResto = adresseResto;
    }

    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public String getVilleR() {
        return villeR;
    }

    public void setVilleR(String villeR) {
        this.villeR = villeR;
    }

    public String getTypeResto() {
        return typeResto;
    }

    public void setTypeResto(String typeResto) {
        this.typeResto = typeResto;
    }

    public String getAdresseResto() {
        return adresseResto;
    }

    public void setAdresseResto(String adresseResto) {
        this.adresseResto = adresseResto;
    }

    @Override
    public String toString() {
        return "resto{" +
                "nomR='" + nomR + '\'' +
                ", villeR='" + villeR + '\'' +
                ", typeResto='" + typeResto + '\'' +
                ", adresseResto='" + adresseResto + '\'' +
                '}';
    }
}



