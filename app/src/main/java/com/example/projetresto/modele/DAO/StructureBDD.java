package com.example.projetresto.modele.DAO;

public class StructureBDD {

    // Structure de la table resto contenant l'id, le nom et la ville du restaurant

    public static final String TABLE_resto = "tresto";

    public static final String COL_ID_RESTO = "_id";

    public static final String COL_NOM_RESTO = "nomR";

    public static final String COL_VILLE_RESTO = "villeR";


    public static final String TABLE_detail = "tdetail";

    public static final String COL_ID_DETAIL = "_id";

    public static final String COL_ADRESSE_DETAIL = "adresseResto";

    public static final String COL_TYPE_DETAIL = "typeResto";

    public static final String COL_RESTO_DETAIL = "restoDetail";


}
