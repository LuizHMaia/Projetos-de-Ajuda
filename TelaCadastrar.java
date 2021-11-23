package com.example.cadastrousuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TelaCadastrar extends AppCompatActivity implements View.OnClickListener {

    //atributos e instancias de Firebase
    private FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");
    FirebaseUser usuarioId;

    //Atributos
    private Button btnCadastrar;
    private Button btnCancelar;
    private EditText nome;
    private EditText email;
    private EditText senha;
    private EditText confSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar);

        btnCadastrar = findViewById(R.id.btnCadastrar1);
        btnCancelar = findViewById(R.id.btnCancelar);

        mAuth = FirebaseAuth.getInstance();

        nome = findViewById(R.id.edtNome);
        email = findViewById(R.id.edtEmail);
        senha = findViewById(R.id.edtSenha);
        confSenha = findViewById(R.id.edtConfirmeSenha);

        btnCadastrar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

    }

    @Override
    public void onClick(View evento) {
        if (evento.getId()==R.id.btnCadastrar1){
            if (email.getText().toString()!=null && senha.getText().toString()!=null){
                if (senha.getText().toString().equals(confSenha.getText().toString())){
                    if (senha.getText().length()>5){
                        Log.d("Login","senha!");
                        criarUsuario(nome.getText().toString(),email.getText().toString(),senha.getText().toString());
                    }else{
                        Toast.makeText(TelaCadastrar.this, "Senha deve conter minimo de 6 caracteres..", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(TelaCadastrar.this, "Senha não confere..", Toast.LENGTH_SHORT).show();
                }

            }
            Toast.makeText(TelaCadastrar.this, "Email ou senha vazia..", Toast.LENGTH_SHORT).show();
        }else if (evento.getId()==R.id.btnCancelar){
            nome.setText("");
            email.setText("");
            senha.setText("");
            confSenha.setText("");
        }


    }

    private void criarUsuario(String nome, String email, String password){
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(TelaCadastrar.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.d("Login","Usuario criado com sucesso!");
                    FirebaseUser usuarioId = mAuth.getCurrentUser();
                    Usuario usuario = new Usuario(nome,email);
                    gravarNome(usuarioId.getUid(),usuario);
                    entrar();
                }else {
                    Log.d("Login","Falha ao criar usuario!");
                    Toast.makeText(TelaCadastrar.this, "Falha na autenticação...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void entrar() {
        Intent intent = new Intent(this, TelaDentro.class);
        startActivity(intent);
    }

    private void gravarNome(String uid, Usuario usuario) {
        myRef.child(uid).setValue(usuario);
    }
}