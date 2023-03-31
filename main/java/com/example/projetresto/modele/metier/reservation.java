package com.example.projetresto.modele.metier;

import java.util.Date;

public class reservation {
    protected String nomResto;
    protected String nomUtil;
    protected String dateR;
    protected String heureR;
    protected String nbPers;


    public reservation(String nomResto, String nomUtil, String dateR, String heureR, String nbPers) {
        this.nomResto = nomResto;
        this.nomUtil = nomUtil;
        this.dateR = dateR;
        this.heureR = heureR;
        this.nbPers = nbPers;
    }

    public String getNomResto() {
        return nomResto;
    }

    public void setNomResto(String nomResto) {
        this.nomResto = nomResto;
    }

    public String getNomUtil() {
        return nomUtil;
    }

    public void setNomUtil(String nomUtil) {
        this.nomUtil = nomUtil;
    }

    public String getDateR() {
        return dateR;
    }

    public void setDateR(String dateR) {
        this.dateR = dateR;
    }

    public String getHeureR() {
        return heureR;
    }

    public void setHeureR(String heureR) {
        this.heureR = heureR;
    }

    public String getNbPers() {
        return nbPers;
    }

    public void setNbPers(String nbPers) {
        this.nbPers = nbPers;
    }



}
