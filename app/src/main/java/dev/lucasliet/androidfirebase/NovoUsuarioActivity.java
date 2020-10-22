package dev.lucasliet.androidfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class NovoUsuarioActivity extends AppCompatActivity {

    private EditText loginNovoUsuarioEditText;
    private EditText senhaNovoUsuarioEditText;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);

        loginNovoUsuarioEditText = findViewById(R.id.LoginNovoUsuarioEditText);
        senhaNovoUsuarioEditText = findViewById(R.id.SenhaNovoUsuarioEditText);

        auth = FirebaseAuth.getInstance();

    }

    public void criarNovoUsuario(View view) {
        String email = loginNovoUsuarioEditText.getEditableText().toString();
        String senha = senhaNovoUsuarioEditText.getEditableText().toString();

        auth.createUserWithEmailAndPassword(email, senha)
                .addOnSuccessListener( authResult -> {
                    Toast.makeText(this, authResult.getUser().getEmail(), Toast.LENGTH_SHORT).show();
                    finish();
                })
                .addOnFailureListener(e -> e.printStackTrace());

    }
}