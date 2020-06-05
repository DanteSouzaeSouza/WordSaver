package br.com.theoldpinkeye.wordsaver.controller;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import br.com.theoldpinkeye.wordsaver.model.Word;
import java.util.List;

// o Dao é quem validará nossos SQLs para o Room
@Dao // informando ao Room que essa interface é o nosso Dao do projeto
public interface WordDao {

  // método que faz a inserção de dados na tabela
  @Insert(onConflict = OnConflictStrategy.IGNORE) // se houver conflito, ignore a inserção da palavra
  void insert(Word word);

  // método que apagará todos os dados da tabela
  @Query("DELETE FROM word_table") // chama uma query que deleta os dados
  void deleteAll();

  // método que trará do banco a lista com todas as palavras em ordem crescente
  @Query("SELECT * FROM word_table ORDER BY word ASC")
  LiveData<List<Word>> getAlphabetizedWords(); // essa lista precisa ser atualizada de forma constante e automática
}

