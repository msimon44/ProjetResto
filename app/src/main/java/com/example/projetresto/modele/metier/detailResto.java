package com.example.projetresto.modele.metier;

public class detailResto {


    protected String typeResto;
    protected String adresseResto;
    protected resto restoDetail;

    public detailResto(String typeResto, String adresseResto, resto restoDetail) {
        this.typeResto = typeResto;
        this.adresseResto = adresseResto;
        this.restoDetail = restoDetail;
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


    public resto getRestoDetail() {
        return restoDetail;
    }

    public void setRestoDetail(resto restoDetail) {
        this.restoDetail = restoDetail;
    }



    @Override
    public String toString() {
        return "detail{" +
                "type='" + typeResto + '\'' +
        ", adresse=" + adresseResto +
                ", detailResto=" + restoDetail +
                '}';
    }


}