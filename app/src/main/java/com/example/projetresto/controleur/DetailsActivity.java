package com.example.projetresto.controleur;


import static java.lang.String.valueOf;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.projetresto.R;
import com.example.projetresto.modele.DAO.DAOResto;
import com.example.projetresto.modele.metier.resto;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class DetailsActivity extends AppCompatActivity {

    String nomResto="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_details);


        //gestion de la liste déroulante des Resto
        Spinner spinnerAfficheResto = (Spinner) findViewById(R.id.spinnerSaisieResto);
        DAOResto restobdd = new DAOResto(this);
        //le curseur récupère tous les Resto
        Cursor c = DAOResto.getAll();
        //on ne garde dans une liste que les noms desResto
        ArrayList<String> lesResto = new ArrayList();
        //et chaque nom de Resto va être enregistré dans une arraylist
        if (c.moveToFirst()) {
            if (c.getCount() != 0) {
                while (!c.isAfterLast()) {
                    lesResto.add(c.getString(1)); //add the item
                    c.moveToNext();
                }
            }

            //on défini un modèle d'affichage
            ArrayAdapter<String> dataAdapterR = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,lesResto);
            dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //on affecte ce modèle (adapter) à notre liste déroulante
            spinnerAfficheResto.setAdapter(dataAdapterR);

            //on affiche le detail d'un resto
            spinnerAfficheResto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    // Integer numlac = Math.toIntExact(spinnerAfficheLac.getSelectedItemId());
                    nomResto = valueOf(spinnerAfficheResto.getSelectedItem());
                    //Remplissage des champs pour le détail d'un resto.
                    resto Resto =restobdd.getRestoByNom(nomResto);
                    TextView typeResto = findViewById(R.id.TypeResto);
                    typeResto.setText("le type du Resto est : "+valueOf(Resto.getTypeResto()));
                    TextView adresse = findViewById(R.id.AdrResto);
                    adresse.setText("la latitude est : "+valueOf(Resto.getAdresseResto()));
                    TextView ville = findViewById(R.id.VilleResto);
                    ville.setText("La ville du Resto est : "+valueOf(Resto.getAdresseResto()));
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }

            });
        }


    }



}
