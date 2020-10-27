package dev.lucasliet.androidfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {
    private List<Mensagem> mensagens;
    private Context context;

    public ChatAdapter(List<Mensagem> mensagens, Context context) {
        this.mensagens = mensagens;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        Mensagem mensagem = mensagens.get(position);
        holder.mensagemTextView.setText(mensagem.getTexto());
        holder.dataNomeTextView.setText(context.getString(
                R.string.data_nome,
                DateHelper.format(mensagem.getData()),
                mensagem.getUsuario()
        ));
    }

    @Override
    public int getItemCount() {
        return mensagens.size();
    }
}
