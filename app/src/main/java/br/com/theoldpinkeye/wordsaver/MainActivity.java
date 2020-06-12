package br.com.theoldpinkeye.wordsaver;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.theoldpinkeye.wordsaver.view.WordListAdapter;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // atrelar o Recyclerview com o adapter
    RecyclerView recyclerView = findViewById(R.id.recyclerview);
    final WordListAdapter adapter = new WordListAdapter(this);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

  }
}