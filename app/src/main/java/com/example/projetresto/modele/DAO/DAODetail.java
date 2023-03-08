package com.example.projetresto.modele.DAO;

import static com.example.projetresto.modele.DAO.StructureBDD.COL_ADRESSE_DETAIL;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_ID_RESTO;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_NOM_RESTO;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_RESTO_DETAIL;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_TYPE_DETAIL;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_VILLE_RESTO;
import static com.example.projetresto.modele.DAO.StructureBDD.TABLE_detail;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.projetresto.modele.metier.detailResto;
import com.example.projetresto.modele.metier.resto;

public class DAODetail extends DAOModele {


    public DAODetail(Context context) {
        super(context);
    }
    public static long insererDetail(detailResto unDetail) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_TYPE_DETAIL, unDetail.getTypeResto());
        values.put(COL_ADRESSE_DETAIL, unDetail.getAdresseResto());
        values.put(COL_RESTO_DETAIL, unDetail.getRestoDetail().getNomR());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_detail, null, values);
    }



    public static Cursor getAllByResto(String unResto){
        //problème avec les dates sans 0 devant 3/10 ne marche pas 03/10 fonctionne
        String $sql = "SELECT * FROM tdetail WHERE restoDetail='"+unResto+"'";
        return db.rawQuery($sql,null);

    }

    public static detailResto cursorToDetail(Cursor c) { //Cette méthode permet de convertir un cursor en un lac
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;
        //Sinon
        c.moveToFirst(); //on se place sur le premier élément
        detailResto unDetail = new detailResto(null, null, null); //On créé un lac
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        unDetail.setTypeResto(c.getString(1));
        unDetail.setAdresseResto(c.getString(2));
        unDetail.setRestoDetail(DAOResto.getRestoByNom(c.getString(3)));


        c.close(); //On ferme le cursor
        return unDetail; //On retourne le détail

    }
    public static Cursor getAll() {
        return db.rawQuery("SELECT * FROM tdetail ORDER BY restoDetail", null);
    }

}
