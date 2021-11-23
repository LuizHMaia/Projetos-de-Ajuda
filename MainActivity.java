package com.estacio.minhabiblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCadastrar;
    private Button btnPesquisar;
    private RadioGroup rdgPesquisarPor;
    private EditText edtPesquisar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnPesquisar = findViewById(R.id.btnPesquisar);
        rdgPesquisarPor = findViewById(R.id.rdgPesquisarPor);
        edtPesquisar = findViewById(R.id.edtPesquisar);

        btnPesquisar.setOnClickListener(this);
        btnCadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View evento) {
        Intent it = null;
        switch (evento.getId()){
            case R.id.btnCadastrar:
                it= new Intent(this,TelaCadastro.class);
                break;
            case R.id.btnPesquisar:
                it = new Intent(this,TelaPesquisar.class);
                it.putExtra("tipo",rdgPesquisarPor.getCheckedRadioButtonId());
                it.putExtra("chave",edtPesquisar.getText().toString());
                break;
        }

        if(it!=null){
            startActivity(it);
        }
    }
}