package com.example.projetresto.controleur;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetresto.R;
import com.example.projetresto.modele.DAO.DAOResto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReservationActivity extends AppCompatActivity {

    String heure ="";

    String date2 = "";
    String nomR = "";
    String nomP = "";
    String nombreP = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        Button btnEnregistrer = findViewById(R.id.buttonEnregistrerReservation);
        Button btnquitter = findViewById(R.id.buttonQuitterReservation);

        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonEnregistrerReservation:
                        //code correspondant au clic sur le bouton enregistrer
                       // if (TextUtils.isDigitsOnly(nombreP) && !nomP.isEmpty() && !nomR.isEmpty() && !date.isEmpty() && !heure.isEmpty()) {
                            envoyerDonneesResumeSaisieTemp();


                        //} else {
                            // Si la chaîne de caractères ne contient pas que des chiffres, affichez un message d'erreur ou effectuez une autre action appropriée
                            //Toast.makeText(getApplicationContext(), "Erreur : veuillez rentrez les informations dans tous les champs", Toast.LENGTH_SHORT).show();
                       // }

                        break;

                    case R.id.buttonQuitterReservation:
                        finish();
                        break;
                }
            }
        };

        btnEnregistrer.setOnClickListener(ecouteur);
        btnquitter.setOnClickListener(ecouteur);


        //gestion de la liste déroulante des Resto
        Spinner spinnerAfficheResto2 = (Spinner) findViewById(R.id.spinnerSaisieResto2);
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
            ArrayAdapter<String> dataAdapterR = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lesResto);
            dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //on affecte ce modèle (adapter) à notre liste déroulante
            spinnerAfficheResto2.setAdapter(dataAdapterR);

        }


        List<String> spinnerList = new ArrayList<>();
        spinnerList.add("11h30");
        spinnerList.add("12h00");
        spinnerList.add("12h30");
        spinnerList.add("13h00");
        spinnerList.add("13h30");
        spinnerList.add("14h00");
        spinnerList.add("19h00");
        spinnerList.add("19h30");
        spinnerList.add("20h00");
        spinnerList.add("20h30");
        spinnerList.add("21h00");
        spinnerList.add("21h30");
        spinnerList.add("22h00");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerList);
        Spinner spinner = findViewById(R.id.spinnerHeureRes);
        spinner.setAdapter(adapter);


    }


    private void envoyerDonneesResumeSaisieTemp(){
        Intent i = new Intent(ReservationActivity.this, ValidationReservationActivity.class);


        Spinner spinner = findViewById(R.id.spinnerHeureRes);
        //récupère l'heure selectionnée
        heure = spinner.getSelectedItem().toString();
        i.putExtra("EXTRA_HEURE", heure);


        //récupère la date selectionnée
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView2);
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            // Utiliser la date sélectionnée
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, dayOfMonth);
            Date date1 = calendar.getTime();
            // Faire quelque chose avec la date sélectionnée
            date2 = date1.toString();
        });
        i.putExtra("EXTRA_DATE", date2);

        Spinner spinnerAfficheResto2 = (Spinner) findViewById(R.id.spinnerSaisieResto2);
        //récupère le nom du restorant
        nomR = spinnerAfficheResto2.getSelectedItem().toString();
        i.putExtra("EXTRA_Nom_resto", nomR);

        EditText editTextP = (EditText) findViewById(R.id.editTexNomReservation);
        //récupère le nom de la personne
        nomP = editTextP.getText().toString(); // Cette méthode renvoie la chaîne de caractères saisie dans l'EditText.
        i.putExtra("EXTRA_Nom_personne", nomP);

        EditText editTextNombreP = (EditText) findViewById(R.id.editTexNbPersonne);
        //récupère le nombre de personne
        nombreP = editTextNombreP.getText().toString();
        i.putExtra("EXTRA_Nombre_personne", nombreP);

        startActivity(i);
    }
}