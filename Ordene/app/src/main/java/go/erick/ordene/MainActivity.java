package go.erick.ordene;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity {
    //MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Button iniciar = (Button) findViewById (R.id.bubble);
        Button sair = (Button) findViewById (R.id.sair);
        Button inst = (Button) findViewById(R.id.inst);
        //mp = MediaPlayer.create(MainActivity.this, R.raw.click);

        iniciar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //mp.start();
                Intent intent = new Intent(MainActivity.this, Choices.class);
                startActivity(intent);
            }
        });

        sair.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //mp.start();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        inst.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //mp.start();
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                startActivity(intent);
            }
        });



    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}
