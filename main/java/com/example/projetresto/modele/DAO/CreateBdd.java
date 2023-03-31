package com.example.projetresto.modele.DAO;

import static com.example.projetresto.modele.DAO.StructureBDD.COL_ADRESSE_DETAIL;

import static com.example.projetresto.modele.DAO.StructureBDD.COL_DATE_RESERVATION;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_HEURE_RESERVATION;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_ID_RESERVATION;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_ID_RESTO;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_NBPERS_RESERVATION;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_NOM_RESTO;

import static com.example.projetresto.modele.DAO.StructureBDD.COL_RESTO_RESERVATION;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_TYPE_DETAIL;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_UTIL_RESERVATION;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_VILLE_RESTO;

import static com.example.projetresto.modele.DAO.StructureBDD.TABLE_reservation;
import static com.example.projetresto.modele.DAO.StructureBDD.TABLE_resto;
import static com.example.projetresto.modele.DAO.StructureBDD.TABLE_utilisateur;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_NOM_UTILISATEUR;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_ID_UTILISATEUR;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_EMAIL_UTILISATEUR;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_MDP_UTILISATEUR;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CreateBdd extends SQLiteOpenHelper {

    //requête de création de la table tlac
    private static final String CREATE_TABLERESTO = "CREATE TABLE " + TABLE_resto + " ("+ COL_ID_RESTO +" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_NOM_RESTO + " TEXT NOT NULL, " + COL_VILLE_RESTO + " TEXT NOT NULL, " + COL_ADRESSE_DETAIL + " TEXT NOT NULL, " + COL_TYPE_DETAIL + " TEXT NOT NULL);";
    //requête de création de la table treleve
    private static final String CREATE_TABLEUTILISATEUR = "CREATE TABLE " + TABLE_utilisateur + "("+ COL_ID_UTILISATEUR +" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_EMAIL_UTILISATEUR + " TEXT NOT NULL, " + COL_NOM_UTILISATEUR + " TEXT NOT NULL, " + COL_MDP_UTILISATEUR + " TEXT NOT NULL);";
    //requête de création de la table treleve
    private static final String CREATE_TABLERESERVATION = "CREATE TABLE " + TABLE_reservation + "("+ COL_ID_RESERVATION +" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_RESTO_RESERVATION + " TEXT NOT NULL, " + COL_DATE_RESERVATION + " TEXT NOT NULL, " + COL_HEURE_RESERVATION + " TEXT NOT NULL, " + COL_NBPERS_RESERVATION + " TEXT NOT NULL, " + COL_UTIL_RESERVATION + " TEXT NOT NULL);";
    //constructeur paramétré
    public CreateBdd(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //méthodes d'instance permettant la gestion de l'objet

    @Override
    public void onCreate(SQLiteDatabase db) {
        //appelée lorsqu’aucune base n’existe et que la classe utilitaire doit en créer une
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_TABLERESTO);
        db.execSQL(CREATE_TABLEUTILISATEUR);
        db.execSQL(CREATE_TABLERESERVATION);


    }

    // appelée si la version de la base a changé
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut supprimer la table et la recréer
        db.execSQL("DROP TABLE " + TABLE_resto + ";");
        db.execSQL("DROP TABLE " + TABLE_utilisateur + ";");
        db.execSQL("DROP TABLE " + TABLE_reservation + ";");
        onCreate(db);
    }
}