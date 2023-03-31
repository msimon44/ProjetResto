package com.example.projetresto.controleur;

import static com.example.projetresto.modele.DAO.DAOModele.db;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_EMAIL_UTILISATEUR;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_MDP_UTILISATEUR;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_NOM_UTILISATEUR;
import static com.example.projetresto.modele.DAO.StructureBDD.TABLE_utilisateur;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetresto.R;
import com.example.projetresto.modele.DAO.DAOUtilisateur;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class InscriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        EditText nomEditText;
        EditText emailEditText;
        EditText mdpEditText;


        Button envoyer_button = findViewById(R.id.envoyer_bouton);
        nomEditText = findViewById(R.id.nom_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        mdpEditText = findViewById(R.id.mdp_edit_text);
        DAOUtilisateur restoBdd = new DAOUtilisateur(this);
        restoBdd.open();


        envoyer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = nomEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String mdp = mdpEditText.getText().toString();

                if(nom.isEmpty() && email.isEmpty() && mdp.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Auncun champ n'a été informé", Toast.LENGTH_LONG).show();

                } else if (nom.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Le champ Nom n'a pas été informé", Toast.LENGTH_LONG).show();

                } else if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Le champ Email n'a pas été informé", Toast.LENGTH_LONG).show();

                } else if (mdp.length() < 8 && !Pattern.compile("[^a-zA-Z0-9]").matcher(mdp).find() ) {
                    Toast.makeText(getApplicationContext(), "Le Mot de passe n'est pas conforme", Toast.LENGTH_LONG).show();

                } else if (mdp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Le champ Mot de passe n'a pas été informé", Toast.LENGTH_LONG).show();

                } else if (nom.isEmpty() || email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Le champ nom ou email n'a pas été informé", Toast.LENGTH_LONG).show();

                }else if (!email.contains("@")){
                    Toast.makeText(getApplicationContext(), "L'email n'est pas correcte", Toast.LENGTH_LONG).show();

                }else{
                    ContentValues values = new ContentValues();
                    //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
                    values.put(COL_NOM_UTILISATEUR, nom);
                    values.put(COL_EMAIL_UTILISATEUR, email);
                    values.put(COL_MDP_UTILISATEUR,mdp);
                    //on insère l'objet dans la BDD via le ContentValues
                    db.insert(TABLE_utilisateur, null, values);
                    Intent monIntent = new Intent(InscriptionActivity.this, MainActivity.class);
                    startActivity(monIntent);
                }}

        });

    }}