package dev.lucasliet.androidfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText loginEditText;
    private EditText senhaEditText;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEditText = findViewById(R.id.LoginEditText);
        senhaEditText = findViewById(R.id.SenhaEditText);
        auth = FirebaseAuth.getInstance();
    }

    public void irParaCadastro(View view) {
        startActivity(new Intent(this, NovoUsuarioActivity.class));
    }

    public void fazerLogin(View view){
        String email = loginEditText.getEditableText().toString();
        String senha = senhaEditText.getEditableText().toString();

        auth.signInWithEmailAndPassword(email, senha)
            .addOnSuccessListener( authResult -> {
                startActivity(new Intent(this, ChatActivity.class));
            })
            .addOnFailureListener( e -> {
                Toast.makeText(this, "Deu ruim irmão, logou não", Toast.LENGTH_SHORT).show();
            });
    }
}