package br.com.theoldpinkeye.wordsaver;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class NewWordActivity extends AppCompatActivity {

  private EditText mEditWordView;

  public static final String EXTRA_REPLY = "br.com.theoldpinkeye.wordsaver.REPLY";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_word);


    // binding:
    mEditWordView = findViewById(R.id.edit_word);
    final Button button = findViewById(R.id.button_save);

    // adicionando onClickListener ao botão
    button.setOnClickListener(v -> {
      Intent replyIntent = new Intent();
      // se não houver palavra digitada:
      if (TextUtils.isEmpty(mEditWordView.getText())){
        // informar pelo intent que foi cancelada a inserção da palavra no banco
        setResult(RESULT_CANCELED, replyIntent);
      } else {
        // caso haja palavra digitada, adicione ela ao intent com a tag da constante EXTRA_REPLY
        String word = mEditWordView.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY, word);
        setResult(RESULT_OK, replyIntent);
      }
      // finaliza activity
      finish();
    });
  }
}