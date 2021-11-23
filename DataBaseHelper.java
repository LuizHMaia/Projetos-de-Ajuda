package com.estacio.minhabiblioteca;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class DataBaseHelper  extends SQLiteOpenHelper {

    //Atributos
    private static  final  String DATABASE_NAME = "catalogo";
    private static final int DATABASE_VERSION =3;
    private final  String CREATE_TABLE_CATALOGO =
            "CREATE TABLE catalogo(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "titulo text," +
            "autor text," +
            "ano INTEGER);";

    public DataBaseHelper(Context contexto){
        super(contexto,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CATALOGO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS catalogo");
        onCreate(sqLiteDatabase);
    }

    public  long inserir(ContentValues cv){
        SQLiteDatabase db = this.getWritableDatabase();
        long id = db.insert("catalogo",null,cv);
        return  id;
    }

    public List<ContentValues> pesquisarPorTitulo(String titulo){
        String sql = "SELECT * FROM catalogo WHERE titulo lik ?";

        String vetor[] = new String[]{"%",titulo+"%"};
        return  pesquisar(sql,vetor);
    }

    private List<ContentValues> pesquisar(String sql, String[] vetor) {
        return null;
    }
}
