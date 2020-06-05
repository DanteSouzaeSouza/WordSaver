package br.com.theoldpinkeye.wordsaver.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// dizendo para o Room que essa classe deve ser salva em uma tabela
@Entity(tableName = "word_table")
public class Word {

  // Criamos variável para receber uma palavra
  @PrimaryKey // esse campo será chave primária da tabela
  @NonNull // não aceita valor nulo
  @ColumnInfo(name = "word") // dizendo para o Room que esse dado será salvo na coluna word da tabela
  private String mWord;

  // geramos o método construtor onde a String não pode ser nula
  public Word(@NonNull String mWord) {
    this.mWord = mWord;
  }

  // criamos o método get
  public String getmWord() {
    return mWord;
  }

}
