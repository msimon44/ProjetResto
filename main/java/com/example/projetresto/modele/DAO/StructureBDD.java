package com.example.projetresto.modele.DAO;

import java.util.Date;

public class StructureBDD {

    // Structure de la table resto contenant l'id, le nom et la ville du restaurant

    public static final String TABLE_resto = "tresto";

    public static final String COL_ID_RESTO = "_id";

    public static final String COL_NOM_RESTO = "nomR";

    public static final String COL_VILLE_RESTO = "villeR";

    public static final String COL_ADRESSE_DETAIL = "adresseResto";

    public static final String COL_TYPE_DETAIL = "typeResto";

    //Structure de la table Utilisateur
    public static final String TABLE_utilisateur = "tutilisateur";

    public static final String COL_ID_UTILISATEUR = "_id";

    public static final String COL_NOM_UTILISATEUR = "nomUtilisateur";

    public static final String COL_EMAIL_UTILISATEUR = "emailUtilisateur";

    public static final String COL_MDP_UTILISATEUR = "mdpUtilisateur";

    //Structure de la table Réservation
    public static final String TABLE_reservation = "treservation";

    public static final String COL_ID_RESERVATION = "_id";

    public static final String COL_RESTO_RESERVATION = "nomResto";

    public static final String COL_UTIL_RESERVATION = "nomUtil";

    public static final String COL_DATE_RESERVATION = "dateR";

    public static final String COL_HEURE_RESERVATION = "heureR";

    public static final String COL_NBPERS_RESERVATION = "nbPers";

}
