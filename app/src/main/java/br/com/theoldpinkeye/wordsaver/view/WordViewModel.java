package br.com.theoldpinkeye.wordsaver.view;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import br.com.theoldpinkeye.wordsaver.controller.WordRepo;
import br.com.theoldpinkeye.wordsaver.model.Word;
import java.util.List;

// esse model cria a visualização dos dados da classe Word
public class WordViewModel extends AndroidViewModel {

  // Criando uma variável da classe WordRepo para receber os dados do repositório
  private WordRepo mRepository;

  // Criando uma variável do LiveData pra receber a lista de palavras do repositório
  LiveData<List<Word>> mAllWords;

  // método construtor dessa classe
  public WordViewModel(Application application) {
    super(application);
    // dizendo para o android que estamos instanciando um novo WordRepo
    mRepository = new WordRepo(application);
    // passando a lista de palavras do WordRepo para a lista de dentro dessa classe
    mAllWords = mRepository.getAllWords();
  }

  // receberá alista de palavras do repository
  public LiveData<List<Word>> getAllWords() { return mAllWords; }

  // invocar o método insert do Repository
  public void insert(Word word){ mRepository.insert(word);}

}
