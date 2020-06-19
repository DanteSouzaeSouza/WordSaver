package br.com.theoldpinkeye.wordsaver;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.theoldpinkeye.wordsaver.model.Word;
import br.com.theoldpinkeye.wordsaver.view.WordListAdapter;
import br.com.theoldpinkeye.wordsaver.view.WordViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;


public class MainActivity extends AppCompatActivity {

  public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
  private WordViewModel mWordViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // instanciando o ViewModel atrelando-o a esta activity
    mWordViewModel = new ViewModelProvider(this).get(WordViewModel.class);




    // atrelar o Recyclerview com o adapter
    RecyclerView recyclerView = findViewById(R.id.recyclerview);
    final WordListAdapter adapter = new WordListAdapter(this);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    // atualizando lista de palavras no adapter
    mWordViewModel.getAllWords().observe(this, adapter::setWords);

    // declarando o botão flutuante e adicionando a ele um ClickListener
    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(v -> {
      // Criando intent para iniciar a activity que permite inserção de nova palavra, espernando
      // uma resposta como resultado
      Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
      startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
    });
  }

  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    // conferindo se a transação entre actrivities foi bem sucedida
    if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
      // capturando a palavra a inserir no banco
      Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
      // mandando o viewmodel inserir a palavra no banco
      mWordViewModel.insert(word);
    } else {

      // caso não haja palavra a salvar:
      Toast.makeText(getApplicationContext(), R.string.empty_not_saved, Toast.LENGTH_LONG).show();
    }

  }
}