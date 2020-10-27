package dev.lucasliet.androidfirebase;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatViewHolder extends RecyclerView.ViewHolder {
    TextView dataNomeTextView;
    TextView mensagemTextView;

    public ChatViewHolder(@NonNull View root) {
        super(root);
        dataNomeTextView = root.findViewById(R.id.dataNomeTextView);
        mensagemTextView = root.findViewById(R.id.mensagemTextView);
    }
}
