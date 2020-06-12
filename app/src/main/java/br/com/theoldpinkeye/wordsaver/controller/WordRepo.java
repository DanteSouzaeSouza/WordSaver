package br.com.theoldpinkeye.wordsaver.controller;

import android.app.Application;
import androidx.lifecycle.LiveData;
import br.com.theoldpinkeye.wordsaver.model.Word;
import java.util.List;

// Essa classe é responsável pela conexão entre dados e banco de dados, seja local ou remoto
public class WordRepo {
  // aqui temos os dados que serão usados
  // para gestão das informações necessária à execução do app
  private WordDao mWordDao;
  private LiveData<List<Word>> mAllWords;

  // Método construtor dessa classe
  public WordRepo(Application application) {
    WordRoomDb db = WordRoomDb.getDatabase(application);
    mWordDao = db.wordDao();
    mAllWords = mWordDao.getAlphabetizedWords();
  }

  // populando a lista de palavras com auxilio do Dao
  public LiveData<List<Word>> getAllWords(){
    return mAllWords;
  }

  // implementando o método insert com ajuda da instância da base de dados
  public void insert(Word word){
    WordRoomDb.dbWriteExecutor.execute(() -> mWordDao.insert(word));
  }

}
