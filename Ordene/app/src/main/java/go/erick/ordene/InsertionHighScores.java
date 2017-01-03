package go.erick.ordene;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.widget.TextView;

public class InsertionHighScores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion_high_scores);

        TextView scoreView = (TextView)findViewById(R.id.high_scores_list);
        SharedPreferences scorePrefs = getSharedPreferences(InsertionActivity.GAME_PREFS, 0);
        String[] savedScores = scorePrefs.getString("highScores", "").split("\\|");
        StringBuilder scoreBuild = new StringBuilder("");
        for(String score : savedScores){
            scoreBuild.append(score+"\n");
        }
        scoreView.setText(scoreBuild.toString());
    }
}
