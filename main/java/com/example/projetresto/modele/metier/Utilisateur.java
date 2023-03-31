package com.example.projetresto.modele.metier;

import android.database.sqlite.SQLiteDatabase;

public class Utilisateur {




    protected static String nomU;
    protected static String emailU;
    protected static String mdpU;

    public Utilisateur(String nomU, String emailU, String mdpU) {
        this.nomU = nomU;
        this.emailU = emailU;
        this.mdpU = mdpU;
    }




    public static String getNomU() {
        return nomU;
    }


    public void setNomU(String nomU) {
        this.nomU = nomU;
    }

    public static String getEmailU() {
        return emailU;
    }

    public void setEmailU(String emailU) {
        this.emailU = emailU;
    }


    public void setMdpU(String mdpU) {
        this.mdpU = mdpU;
    }

    public static String getMdpU() {
        return mdpU;
    }

    @Override
    public String toString() {
        return "utilisateur{" +
                "nomU='" + nomU + '\'' +
                ", emailU='" + emailU + '\'' +
                ", mdpU='" + mdpU + '\'' +

                '}';
    }
}