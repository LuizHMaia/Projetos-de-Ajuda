package com.estacio.minhabiblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaCadastro extends AppCompatActivity implements View.OnClickListener {

    private Button btnSalvar;
    private Button btnVoltar;
    private EditText edtTitulo;
    private EditText edtAutor;
    private EditText edtAno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnVoltar = findViewById(R.id.btnVoltar);
        edtTitulo = findViewById(R.id.edtTitulo);
        edtAno = findViewById(R.id.edtAno);
        edtAutor = findViewById(R.id.edtAutor);

        btnVoltar.setOnClickListener(this);
        btnSalvar.setOnClickListener(this);
    }

    @Override
    public void onClick(View evento) {
        if(evento.getId()==R.id.btnVoltar){
            onBackPressed();
        }else if(evento.getId()==R.id.btnSalvar){
            ContentValues cv = new ContentValues();
            cv.put("titulo",edtTitulo.getText().toString());
            cv.put("autor",edtAutor.getText().toString());
            cv.put("ano",edtAno.getText().toString());

            //DataBaseHelper  dh = new DataBaseHelper(this);

        }
    }
}