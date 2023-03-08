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
import com.example.projetresto.modele.DAO.DAOResto;
import com.example.projetresto.modele.metier.detailResto;
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

            //on associe à un objet java de type Button, un widget repéré physiquement par son id
            Button btnListe = findViewById(R.id.buttonListe);
            Button btnContacter = findViewById(R.id.buttonContacter);
            Button btnConnecter = findViewById(R.id.buttonConnecter);
            //on va créer écouteur pour tous les boutons
            View.OnClickListener ecouteur = new View.OnClickListener() {
                //on implémente la méthode onclick
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.buttonListe:
                            //code correspondant au clic sur le bouton enregistrer
                            Intent intent1 = new Intent(MainActivity.this, ListeRestoActivity.class);
                            startActivity(intent1);
                            break;

                        case R.id.buttonContacter:
                            Intent intent2 = new Intent(MainActivity.this, NousContacterActivity.class);
                            startActivity(intent2);
                            break;
                        case R.id.buttonConnecter:
                            Intent intent3 = new Intent(MainActivity.this, SeConnecterActivity.class);
                            startActivity(intent3);


                            finish();
                            break;
                    }
                }

            };
            //on affecte au bouton l'écouteur
            btnListe.setOnClickListener(ecouteur);
            btnContacter.setOnClickListener(ecouteur);
            btnConnecter.setOnClickListener(ecouteur);



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
            Cursor c = restoBdd.getAll();
            Toast.makeText(getApplicationContext(), "nombre de restaurants dans la bdd : " + c.getCount(), Toast.LENGTH_LONG).show();
            restoBdd.close();
        }


        private void remplirTableDetailresto() {
            DAODetail detailBdd = new DAODetail(this);
            detailBdd.open();

            detailResto detail1 = new detailResto("sud ouest", "2 rue Maurice Ravel");
            detailResto detail2 = new detailResto("sud ouest", "30 rue Parlement Sainte-Catherine");
            detailResto detail3 = new detailResto("Orientale", "33 rue Saint Rémi");
            detailResto detail4 = new detailResto("sud ouest / sandwich / grillade", "Place du Fronton");
            detailResto detail5 = new detailResto("orientale", "3 Rue Sainte-Catherine");
            detailResto detail6 = new detailResto("viande", "9 Rue Hugues");
            detailResto detail7 = new detailResto("vegan", "15 rue des cordeliers");
            detailResto detail8 = new detailResto("grillade", "21 Quai Amiral Dubourdieu");
            detailResto detail9 = new detailResto("viande", "8 rue de coursic");
            detailResto detail10 = new detailResto("vegan", "39 Rue des Basques");
            //on ouvre la base de données

            //on insère tous les lacs
            DAODetail.insererDetail(detail1);
            DAODetail.insererDetail(detail2);
            DAODetail.insererDetail(detail3);
            DAODetail.insererDetail(detail4);
            DAODetail.insererDetail(detail5);
            DAODetail.insererDetail(detail6);
            DAODetail.insererDetail(detail7);
            DAODetail.insererDetail(detail8);
            DAODetail.insererDetail(detail9);
            DAODetail.insererDetail(detail10);
            //le curseur pour afficher ensuite le nombre de Lac dans la base
            Cursor c = detailBdd.getAll();
            Toast.makeText(getApplicationContext(), "nombre de restaurants dans la bdd : " + c.getCount(), Toast.LENGTH_LONG).show();
            detailBdd.close();
        }





    }

