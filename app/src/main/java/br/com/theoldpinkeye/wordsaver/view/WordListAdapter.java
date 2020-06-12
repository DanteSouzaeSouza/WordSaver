package br.com.theoldpinkeye.wordsaver.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import br.com.theoldpinkeye.wordsaver.R;
import br.com.theoldpinkeye.wordsaver.model.Word;
import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
  // criando variáveis internas
  private final LayoutInflater mInflater;
  private List<Word> mWords;

  // método construtor
  public WordListAdapter(Context context) {
    mInflater = LayoutInflater.from(context);
  }

  @Override // informando ao recyclerview qual layout usar para os itens
  public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
    return new WordViewHolder(itemView);
  }

  @Override // depois que o layout está conectado ao RecyclerView, conecta os dados da lista com os elementos da tela
  public void onBindViewHolder(WordViewHolder holder, int position) {
    if (mWords != null) {
      Word current = mWords.get(position);
      holder.wordItemView.setText(current.getWord());
    } else {
      holder.wordItemView.setText("Sem palavras na lista");
    }
  }

  // método que atualiza a lista de itens
  void setWords(List<Word> words) {
    mWords = words;
    notifyDataSetChanged();
  }

  @Override // faz a contagem de quantos itens há no adapter
  public int getItemCount() {
    return (mWords != null) ? mWords.size() : 0;
  }

  // Essa subclasse atribui os itens do layout aos valores java (Binding)
  class WordViewHolder extends RecyclerView.ViewHolder {
    private final TextView wordItemView;
    public WordViewHolder(View itemView) {
      super(itemView);
      wordItemView = itemView.findViewById(R.id.textView);
    }
  }
}
