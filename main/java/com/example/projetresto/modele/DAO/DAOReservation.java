
package com.example.projetresto.modele.DAO;



import static com.example.projetresto.modele.DAO.StructureBDD.COL_DATE_RESERVATION;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_HEURE_RESERVATION;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_NBPERS_RESERVATION;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_RESTO_RESERVATION;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_UTIL_RESERVATION;
import static com.example.projetresto.modele.DAO.StructureBDD.TABLE_reservation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.projetresto.modele.metier.reservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DAOReservation extends DAOModele{

    public DAOReservation(Context context) {super(context);}

    public static long insererReservation(reservation uneReservation) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();

        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)

        values.put(COL_RESTO_RESERVATION, uneReservation.getNomResto());
        values.put(COL_UTIL_RESERVATION, uneReservation.getNomUtil());
        values.put(COL_DATE_RESERVATION, uneReservation.getDateR());
        values.put(COL_HEURE_RESERVATION, uneReservation.getHeureR());
        values.put(COL_NBPERS_RESERVATION, uneReservation.getNbPers());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_reservation, null, values);
    }

    public static reservation cursorToReservation(Cursor c) { //Cette méthode permet de convertir un cursor en un lac
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;
        //Sinon
        c.moveToFirst(); //on se place sur le premier élément
        reservation uneReservation = new reservation(null, null, null  , null , null); //On créé un lac



        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        uneReservation.setNomResto(c.getString(1));
        uneReservation.setNomUtil(c.getString(2));
        uneReservation.setDateR((c.getString(3)));
        uneReservation.setHeureR(c.getString(4));
        uneReservation.setNbPers(c.getString(5));
        c.close(); //On ferme le cursor
        return uneReservation; //On retourne la reservation

    }

    public static Cursor getAll() {
        return db.rawQuery("SELECT * FROM treservation ORDER BY nomResto", null);
    }
}
