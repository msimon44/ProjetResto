package com.example.projetresto.modele.DAO;

import static com.example.projetresto.modele.DAO.StructureBDD.COL_ID_RESTO;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_NOM_RESTO;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_VILLE_RESTO;
import static com.example.projetresto.modele.DAO.StructureBDD.TABLE_resto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


    public class CreateBdd extends SQLiteOpenHelper {

        //requête de création de la table tlac
        private static final String CREATE_TABLERESTO = "CREATE TABLE " + TABLE_resto + " ("+ COL_ID_RESTO +" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_NOM_RESTO + " TEXT NOT NULL, " + COL_VILLE_RESTO + " TEXT NOT NULL);";
        //requête de création de la table treleve

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

        }

        // appelée si la version de la base a changé
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //On peut supprimer la table et la recréer
            db.execSQL("DROP TABLE " + TABLE_resto + ";");
            onCreate(db);
        }
    }



