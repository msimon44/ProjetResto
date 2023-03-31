package com.example.projetresto.controleur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projetresto.R;
import com.example.projetresto.modele.DAO.DAOReservation;

import com.example.projetresto.modele.DAO.DAOResto;
import com.example.projetresto.modele.metier.reservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidationReservationActivity extends AppCompatActivity {

    String heure ="";
    String date = "";
    String nomR = "";
    String nomP = "";
    String nombreP = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validationreservation);

        //on va récupérer les quatre valeurs provenant de SaisieTempActivity
        Intent i = getIntent();
        if (i != null) {
            date = i.getStringExtra("EXTRA_DATE");
            nomR = i.getStringExtra("EXTRA_Nom_resto");
            heure = i.getStringExtra("EXTRA_HEURE");
            nomP = i.getStringExtra("EXTRA_Nom_personne");
            nombreP = i.getStringExtra("EXTRA_Nombre_personne");
        }

        TextView textdate = findViewById(R.id.editTextDate);
        textdate.setText(date);

        TextView textNomR = findViewById(R.id.editTextNomResto);
        textNomR.setText(nomR);

        TextView textHeure = findViewById(R.id.editTextHeure);
        textHeure.setText(heure);

        TextView textNbPersonne = findViewById(R.id.editTextNombreP);
        textNbPersonne.setText(nombreP);

        TextView textNomP = findViewById(R.id.editTextNomR);
        textNomP.setText(nomP);

        //programmation des deux boutons valider et annuler
        Button btnValider = findViewById(R.id.buttonValider);
        Button btnAnnuler = findViewById(R.id.buttonAnnuler);
        DAOReservation reservation = new DAOReservation(this);
        reservation.open();

        View.OnClickListener ecouteur = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonValider:
                        //code correspondant à l'enregistrement dans la table treleve
                        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        reservation uneReservation;
                        uneReservation = new reservation(nomR, nomP, date, heure, nombreP);
                        reservation.insererReservation(uneReservation);
                        Intent i= new Intent(ValidationReservationActivity.this,MainActivity.class);
                        startActivity(i);
                        break;

                    case R.id.buttonAnnuler:
                        finish();
                        break;
                }
            }

        };
        //on affecte au bouton l'écouteur
        btnValider.setOnClickListener(ecouteur);
        btnAnnuler.setOnClickListener(ecouteur);


    }


}