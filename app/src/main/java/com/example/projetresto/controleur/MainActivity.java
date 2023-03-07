package com.example.projetresto.controleur;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetresto.R;
import com.example.projetresto.modele.DAO.DAODetail;
import com.example.projetresto.modele.metier.detailResto;

import com.example.projetresto.modele.DAO.DAOResto;
import com.example.projetresto.modele.metier.resto;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            DAOResto restoBdd = new DAOResto(this);
            restoBdd.open();
            if (DAOResto.getAll().getCount() == 0) {
                //si la bdd est vide on remplit la table lac et la table releve avec des exemples
                remplirTableResto();
            }


            Button btnListeResto = findViewById(R.id.button2);

            View.OnClickListener ecouteur = new View.OnClickListener() {
                //on implémente la méthode onclick
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.button2:
                            //code correspondant au clic sur le bouton enregistrer
                            Intent intent1 = new Intent(MainActivity.this, ListeRestoActivity.class);
                            startActivity(intent1);
                            break;
                    }
                }

            };

            btnListeResto.setOnClickListener(ecouteur);
        }

        private void remplirTableResto() {
            DAOResto restoBdd = new DAOResto(this);
            restoBdd.open();

            resto resto1 = new resto("L'entrepote", "Bordeaux");
            resto resto2 = new resto("Le bar du charcutier", "Bordeaux");
            resto resto3 = new resto("Sapporo", "Bordeaux");
            resto resto4 = new resto("Cidrerie du fronton", "Arbonne");
            resto resto5 = new resto("Agadir", "Bayonne");
            resto resto6 = new resto("Le Bistrot Sainte Cluque", "Bayonne");
            resto resto7 = new resto("La petite auberge", "Bayonne");
            resto resto8 = new resto("La table de POTTOKA", "Bayonne");
            resto resto9 = new resto("La Rotisserie du Roy Léon", "Bayonne");
            resto resto10 = new resto("Bar du Marché", "Bayonne");
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
            Cursor c = DAOResto.getAll();
            Toast.makeText(getApplicationContext(), "nombre de restaurants dans la bdd : " + c.getCount(), Toast.LENGTH_LONG).show();
            restoBdd.close();
        }

    }

