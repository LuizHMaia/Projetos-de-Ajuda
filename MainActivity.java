package com.example.cadastrousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCadastrar;
    private Button btnEntrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnEntrar = findViewById(R.id.btnEntra);

        btnCadastrar.setOnClickListener(this);
        btnEntrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View evento) {
        if (evento.getId() == R.id.btnCadastrar){
            cadastrar();
        }else if (evento.getId() ==R.id.btnEntra){
            entrar();
        }

    }
    private void cadastrar(){
        Intent intent = new Intent(this, TelaCadastrar.class);
        startActivity(intent);
    }

    private void entrar(){
        Intent intent = new Intent(this, TelaEntrar.class);
        startActivity(intent);
    }
}