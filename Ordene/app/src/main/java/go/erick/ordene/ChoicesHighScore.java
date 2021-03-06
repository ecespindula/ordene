package go.erick.ordene;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoicesHighScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
        Button bubble = (Button) findViewById (R.id.bubble);
        Button insertion = (Button) findViewById (R.id.insertion);
        Button selection = (Button) findViewById (R.id.selection);
        Button quick = (Button) findViewById (R.id.quick);
        Button heap = (Button) findViewById (R.id.heap);
        Button voltar = (Button) findViewById (R.id.voltar);

        //mp = MediaPlayer.create(Choices.this, R.raw.click);

        bubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mp.start();
                Intent intent = new Intent(ChoicesHighScore.this, BubbleHighScores.class);
                startActivity(intent);
            }
        });

        insertion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mp.start();
                Intent intent = new Intent(ChoicesHighScore.this, InsertionHighScores.class);
                startActivity(intent);
            }
        });

        selection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mp.start();
                Intent intent = new Intent(ChoicesHighScore.this, SelectionHighScores.class);
                startActivity(intent);
            }
        });

        quick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mp.start();
                Intent intent = new Intent(ChoicesHighScore.this, QuickHighScores.class);
                startActivity(intent);
            }
        });

        heap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mp.start();
                Intent intent = new Intent(ChoicesHighScore.this, HeapHighScores.class);
                startActivity(intent);
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mp.start();
                Intent intent = new Intent(ChoicesHighScore.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ChoicesHighScore.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
