package br.com.theoldpinkeye.wordsaver.controller;

import android.app.Application;
import androidx.lifecycle.LiveData;
import br.com.theoldpinkeye.wordsaver.model.Word;
import java.util.List;

class WordRepo {
  private WordDao mWordDao;
  private LiveData<List<Word>> mAllWords;

  WordRepo(Application application) {
    WordRoomDb db = WordRoomDb.getDatabase(application);
    mWordDao = db.wordDao();
    mAllWords = mWordDao.getAlphabetizedWords();
  }

  LiveData<List<Word>> getmAllWords(){
    return mAllWords;
  }

  void insert(Word word){
    WordRoomDb.dbWriteExecutor.execute(() -> mWordDao.insert(word));
  }

}
