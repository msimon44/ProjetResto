package com.example.projetresto.modele.DAO;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

    public class DAOModele {
        static final int VERSION_BDD = 1;
        private static final String NOM_BDD = "bddRestoTempv1.db";

        protected final CreateBDD tableCourante;
        protected final Context context;
        protected static SQLiteDatabase db;

        public DAOModele(Context context) {
            this.context = context;
            tableCourante = new CreateBDD(context, NOM_BDD, null, VERSION_BDD);
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
