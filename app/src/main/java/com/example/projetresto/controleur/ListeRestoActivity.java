package com.example.projetresto.controleur;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetresto.R;
import com.example.projetresto.modele.DAO.DAOResto;
import com.example.projetresto.modele.DAO.StructureBDD;

public class ListeRestoActivity  extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        ListView listViewInfoResto = findViewById(R.id.listViewInfosResto);

        DAOResto restoBdd = new DAOResto(this);
        restoBdd.open();

        Cursor c = restoBdd.getAll();

        String[] restoCol = new String[]{StructureBDD.COL_NOM_RESTO, StructureBDD.COL_VILLE_RESTO};

        int[] listeId = new int[]{R.id.textViewNomResto, R.id.textViewVille};

        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this,R.layout.activity_liste, c, restoCol, listeId, 0 );

        listViewInfoResto.setAdapter(dataAdapter);







    }




}
