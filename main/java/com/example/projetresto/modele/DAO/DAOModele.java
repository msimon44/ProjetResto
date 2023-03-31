package com.example.projetresto.modele.DAO;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DAOModele {
    static final int VERSION_BDD = 4;
    private static final String NOM_BDD = "bddRestoV5.db";

    protected final CreateBdd tableCourante;
    protected final Context context;
    public static SQLiteDatabase db;

    public DAOModele(Context context) {
        this.context = context;
        tableCourante = new CreateBdd(context, NOM_BDD, null, VERSION_BDD);
    }

    public DAOModele open() {
        db = tableCourante.getWritableDatabase();
        return this;
    }

    public DAOModele close() {
        db.close();
        return null;
    }
}


