package com.example.projetresto.controleur;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetresto.R;
import com.example.projetresto.modele.DAO.DAOResto;
import com.example.projetresto.modele.metier.resto;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            DAOResto restoBdd = new DAOResto(this);
            restoBdd.open();
            if (restoBdd.getAll().getCount() == 0) {
                //si la bdd est vide on remplit la table lac et la table releve avec des exemples
                remplirTableResto();
            }


        }

        private void remplirTableResto() {
            DAOResto restoBdd = new DAOResto(this);
            restoBdd.open();

            resto resto1 = new resto(1, "L'entrepote", "Bordeaux");
            resto resto2 = new resto(2, "Le bar du charcutier", "Bordeaux");
            resto resto3 = new resto(3, "Sapporo", "Bordeaux");
            resto resto4 = new resto(4, "Cidrerie du fronton", "Arbonne");
            resto resto5 = new resto(5, "Agadir", "Bayonne");
            resto resto6 = new resto(6, "Le Bistrot Sainte Cluque", "Bayonne");
            resto resto7 = new resto(7, "La petite auberge", "Bayonne");
            resto resto8 = new resto(8, "La table de POTTOKA", "Bayonne");
            resto resto9 = new resto(9, "La Rotisserie du Roy Léon", "Bayonne");
            resto resto10 = new resto(10, "Bar du Marché", "Bayonne");
            //on ouvre la base de données

            //on insère tous les lacs
            DAOResto.insererResto(resto1);
            DAOResto.insererResto(resto2);
            DAOResto.insererResto(resto3);
            DAOResto.insererResto(resto4);
            DAOResto.insererResto(resto5);
            DAOResto.insererResto(resto6);
            DAOResto.insererResto(resto7);
            DAOResto.insererResto(resto8);
            DAOResto.insererResto(resto9);
            DAOResto.insererResto(resto10);
            //le curseur pour afficher ensuite le nombre de Lac dans la base
            Cursor c = restoBdd.getAll();
            Toast.makeText(getApplicationContext(), "nombre de restaurants dans la bdd : " + c.getCount(), Toast.LENGTH_LONG).show();
            restoBdd.close();
        }
    }

