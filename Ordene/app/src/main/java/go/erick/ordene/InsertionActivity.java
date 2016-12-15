package go.erick.ordene;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;

public class InsertionActivity extends AppCompatActivity {
    CountDownTimer cTimer = null;
    MediaPlayer mp, defeat, victory;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion);


        final Troca troca = new Troca();
        int[] lista = new int[10];
        final int[] limiteDica = {3};
        final Button button0 = (Button) findViewById (R.id.button0);
        final Button button1 = (Button) findViewById (R.id.button1);
        final Button button2 = (Button) findViewById (R.id.button2);
        final Button button3 = (Button) findViewById (R.id.button3);
        final Button button4 = (Button) findViewById (R.id.button4);
        final Button button5 = (Button) findViewById (R.id.button5);
        final Button button6 = (Button) findViewById (R.id.button6);
        final Button button7 = (Button) findViewById (R.id.button7);
        final Button button8 = (Button) findViewById (R.id.button8);
        final Button button9 = (Button) findViewById (R.id.button9);
        final TextView timer = (TextView) findViewById(R.id.textTimer);
        final ImageView dica =  (ImageView) findViewById(R.id.dica);

        mp = MediaPlayer.create(InsertionActivity.this, R.raw.click);
        victory = MediaPlayer.create(InsertionActivity.this, R.raw.victory);
        defeat = MediaPlayer.create(InsertionActivity.this, R.raw.defeat);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-4577339383482486/2050477450");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                Intent returnBtn = new Intent(getApplicationContext(),
                        MainActivity.class);

                startActivity(returnBtn);
            }
        });

        Random gerador = new Random();
        int numero = gerador.nextInt(100);
        button0.setText(Integer.toString(numero));
        lista[0] = numero;
        numero = gerador.nextInt(100);
        button1.setText(Integer.toString(numero));
        lista[1] = numero;
        numero = gerador.nextInt(100);
        button2.setText(Integer.toString(numero));
        lista[2] = numero;
        numero = gerador.nextInt(100);
        button3.setText(Integer.toString(numero));
        lista[3] = numero;
        numero = gerador.nextInt(100);
        button4.setText(Integer.toString(numero));
        lista[4] = numero;
        numero = gerador.nextInt(100);
        button5.setText(Integer.toString(numero));
        lista[5] = numero;
        numero = gerador.nextInt(100);
        button6.setText(Integer.toString(numero));
        lista[6] = numero;
        numero = gerador.nextInt(100);
        button7.setText(Integer.toString(numero));
        lista[7] = numero;
        numero = gerador.nextInt(100);
        button8.setText(Integer.toString(numero));
        lista[8] = numero;
        numero = gerador.nextInt(100);
        button9.setText(Integer.toString(numero));
        lista[9] = numero;

        final InsertionSort insertion = new InsertionSort(lista);
        insertion.sort();

        checaCerto(insertion, 0, button0);
        checaCerto(insertion, 1, button1);
        checaCerto(insertion, 2, button2);
        checaCerto(insertion, 3, button3);
        checaCerto(insertion, 4, button4);
        checaCerto(insertion, 5, button5);
        checaCerto(insertion, 6, button6);
        checaCerto(insertion, 7, button7);
        checaCerto(insertion, 8, button8);
        checaCerto(insertion, 9, button9);
        startTimer(timer, 40000);

        dica.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(limiteDica[0] >0) {
                    limiteDica[0]--;
                    mp.start();
                    switch (insertion.getTrocados().get(0).getTrocado1()) {
                        case 0:
                            if (troca.getTroca1() != 0)
                                button0.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 1:
                            if (troca.getTroca1() != 1)
                                button1.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 2:
                            if (troca.getTroca1() != 2)
                                button2.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 3:
                            if (troca.getTroca1() != 3)
                                button3.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 4:
                            if (troca.getTroca1() != 4)
                                button4.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 5:
                            if (troca.getTroca1() != 5)
                                button5.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 6:
                            if (troca.getTroca1() != 6)
                                button6.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 7:
                            if (troca.getTroca1() != 7)
                                button7.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 8:
                            if (troca.getTroca1() != 8)
                                button8.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 9:
                            if (troca.getTroca1() != 9)
                                button9.setBackgroundResource(R.color.colorAccent);
                            break;
                    }

                    switch (insertion.getTrocados().get(0).getTrocado2()) {
                        case 0:
                            if (troca.getTroca1() != 0)
                                button0.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 1:
                            if (troca.getTroca1() != 1)
                                button1.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 2:
                            if (troca.getTroca1() != 2)
                                button2.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 3:
                            if (troca.getTroca1() != 3)
                                button3.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 4:
                            if (troca.getTroca1() != 4)
                                button4.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 5:
                            if (troca.getTroca1() != 5)
                                button5.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 6:
                            if (troca.getTroca1() != 6)
                                button6.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 7:
                            if (troca.getTroca1() != 7)
                                button7.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 8:
                            if (troca.getTroca1() != 8)
                                button8.setBackgroundResource(R.color.colorAccent);
                            break;
                        case 9:
                            if (troca.getTroca1() != 9)
                                button9.setBackgroundResource(R.color.colorAccent);
                            break;
                    }
                    if(limiteDica[0] == 0) {
                        dica.setImageResource(R.drawable.sajuda);
                        dica.setClickable(false);
                    }
                }
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                button0.setBackgroundResource(R.color.Red);
                button0.setClickable(false);
                if(troca.insere(0)){
                    String texto = (String) button0.getText();
                    int bot = troca.getTroca1();
                    if(insertion.getTrocados().get(0).getTrocado1()!=0 && insertion.getTrocados().get(0).getTrocado2() !=0){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(insertion.getTrocados().get(0).getTrocado1() != bot && insertion.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                    insertion.getTrocados().remove(0);
                    switch (bot){
                        case 1: button0.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(insertion, 1, button1);
                            button1.setClickable(true);
                            break;
                        case 2: button0.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(insertion, 2, button2);
                            button2.setClickable(true);
                            break;
                        case 3: button0.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(insertion, 3, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button0.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(insertion, 4, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button0.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(insertion, 5, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button0.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(insertion, 6, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button0.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(insertion, 7, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button0.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(insertion, 8, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button0.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(insertion, 9, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(insertion, 0, button0);
                    button0.setClickable(true);
                    troca.reseta();
                    if(insertion.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                button1.setBackgroundResource(R.color.Red);
                button1.setClickable(false);
                if(troca.insere(1)){
                    String texto = (String) button1.getText();
                    int bot = troca.getTroca1();
                    if(insertion.getTrocados().get(0).getTrocado1()!=1 && insertion.getTrocados().get(0).getTrocado2() !=1){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();

                    }else if(insertion.getTrocados().get(0).getTrocado1() != bot && insertion.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();

                    }
                    insertion.getTrocados().remove(0);
                    switch (bot){
                        case 0: button1.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(insertion, 0, button0);
                            button0.setClickable(true);
                            break;
                        case 2: button1.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(insertion, 2, button2);
                            button2.setClickable(true);
                            break;
                        case 3: button1.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(insertion, 3, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button1.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(insertion, 4, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button1.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(insertion, 5, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button1.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(insertion, 6, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button1.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(insertion, 7, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button1.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(insertion, 8, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button1.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(insertion, 9, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(insertion, 1, button1);
                    button1.setClickable(true);
                    troca.reseta();
                    if(insertion.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                button2.setBackgroundResource(R.color.Red);
                button2.setClickable(false);
                if(troca.insere(2)){
                    String texto = (String) button2.getText();
                    int bot = troca.getTroca1();
                    if(insertion.getTrocados().get(0).getTrocado1()!=2 && insertion.getTrocados().get(0).getTrocado2() !=2){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(insertion.getTrocados().get(0).getTrocado1() != bot && insertion.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                    insertion.getTrocados().remove(0);
                    switch (bot){
                        case 0: button2.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(insertion, 0, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button2.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(insertion, 1, button1);
                            button1.setClickable(true);
                            break;
                        case 3: button2.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(insertion, bot, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button2.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(insertion, bot, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button2.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(insertion, bot, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button2.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(insertion, bot, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button2.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(insertion, bot, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button2.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(insertion, bot, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button2.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(insertion, bot, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(insertion, 2, button2);
                    button2.setClickable(true);
                    troca.reseta();
                    if(insertion.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                button3.setBackgroundResource(R.color.Red);
                button3.setClickable(false);
                if(troca.insere(3)){
                    String texto = (String) button3.getText();
                    int bot = troca.getTroca1();
                    if(insertion.getTrocados().get(0).getTrocado1()!=3 && insertion.getTrocados().get(0).getTrocado2() !=3){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(insertion.getTrocados().get(0).getTrocado1() != bot && insertion.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                    insertion.getTrocados().remove(0);
                    switch (bot){
                        case 0: button3.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(insertion, bot, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button3.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(insertion, bot, button1);
                            button1.setClickable(true);
                            break;
                        case 2: button3.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(insertion, bot, button2);
                            button2.setClickable(true);
                            break;
                        case 4: button3.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(insertion, bot, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button3.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(insertion, bot, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button3.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(insertion, bot, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button3.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(insertion, bot, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button3.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(insertion, bot, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button3.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(insertion, bot, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(insertion, 3, button3);
                    button3.setClickable(true);
                    troca.reseta();
                    if(insertion.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                button4.setBackgroundResource(R.color.Red);
                button4.setClickable(false);
                if(troca.insere(4)){
                    String texto = (String) button4.getText();
                    int bot = troca.getTroca1();
                    if(insertion.getTrocados().get(0).getTrocado1()!=4 && insertion.getTrocados().get(0).getTrocado2() !=4){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(insertion.getTrocados().get(0).getTrocado1() != bot && insertion.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                    insertion.getTrocados().remove(0);
                    switch (bot){
                        case 0: button4.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(insertion, bot, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button4.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(insertion, bot, button1);
                            button1.setClickable(true);
                            break;
                        case 3: button4.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(insertion, bot, button3);
                            button3.setClickable(true);
                            break;
                        case 2: button4.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(insertion, bot, button2);
                            button2.setClickable(true);
                            break;
                        case 5: button4.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(insertion, bot, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button4.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(insertion, bot, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button4.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(insertion, bot, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button4.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(insertion, bot, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button4.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(insertion, bot, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(insertion, 4, button4);
                    button4.setClickable(true);
                    troca.reseta();
                    if(insertion.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                button5.setBackgroundResource(R.color.Red);
                button5.setClickable(false);
                if(troca.insere(5)){
                    String texto = (String) button5.getText();
                    int bot = troca.getTroca1();
                    if(insertion.getTrocados().get(0).getTrocado1()!=5 && insertion.getTrocados().get(0).getTrocado2() !=5){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(insertion.getTrocados().get(0).getTrocado1() != bot && insertion.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                    insertion.getTrocados().remove(0);
                    switch (bot){
                        case 0: button5.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(insertion, bot, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button5.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(insertion, bot, button1);
                            button1.setClickable(true);
                            break;
                        case 3: button5.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(insertion, bot, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button5.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(insertion, bot, button4);
                            button4.setClickable(true);
                            break;
                        case 2: button5.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(insertion, bot, button2);
                            button2.setClickable(true);
                            break;
                        case 6: button5.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(insertion, bot, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button5.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(insertion, bot, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button5.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(insertion, bot, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button5.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(insertion, bot, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(insertion, 5, button5);
                    button5.setClickable(true);
                    troca.reseta();
                    if(insertion.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                button6.setBackgroundResource(R.color.Red);
                button6.setClickable(false);
                if(troca.insere(6)){
                    String texto = (String) button6.getText();
                    int bot = troca.getTroca1();
                    if(insertion.getTrocados().get(0).getTrocado1()!=6 && insertion.getTrocados().get(0).getTrocado2() !=6){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(insertion.getTrocados().get(0).getTrocado1() != bot && insertion.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                    insertion.getTrocados().remove(0);
                    switch (bot){
                        case 0: button6.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(insertion, bot, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button6.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(insertion, bot, button1);
                            button1.setClickable(true);
                            break;
                        case 3: button6.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(insertion, bot, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button6.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(insertion, bot, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button6.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(insertion, bot, button5);
                            button5.setClickable(true);
                            break;
                        case 2: button6.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(insertion, bot, button2);
                            button2.setClickable(true);
                            break;
                        case 7: button6.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(insertion, bot, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button6.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(insertion, bot, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button6.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(insertion, bot, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(insertion, 6, button6);
                    button6.setClickable(true);
                    troca.reseta();
                    if(insertion.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                button7.setBackgroundResource(R.color.Red);
                button7.setClickable(false);
                if(troca.insere(7)){
                    String texto = (String) button7.getText();
                    int bot = troca.getTroca1();
                    if(insertion.getTrocados().get(0).getTrocado1()!=7 && insertion.getTrocados().get(0).getTrocado2() !=7){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(insertion.getTrocados().get(0).getTrocado1() != bot && insertion.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                    insertion.getTrocados().remove(0);
                    switch (bot){
                        case 0: button7.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(insertion, bot, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button7.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(insertion, bot, button1);
                            button1.setClickable(true);
                            break;
                        case 3: button7.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(insertion, bot, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button7.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(insertion, bot, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button7.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(insertion, bot, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button7.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(insertion, bot, button6);
                            button6.setClickable(true);
                            break;
                        case 2: button7.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(insertion, bot, button2);
                            button2.setClickable(true);
                            break;
                        case 8: button7.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(insertion, bot, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button7.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(insertion, bot, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(insertion, 7, button7);
                    button7.setClickable(true);
                    troca.reseta();
                    if(insertion.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                button8.setBackgroundResource(R.color.Red);
                button8.setClickable(false);
                if(troca.insere(8)){
                    String texto = (String) button8.getText();
                    int bot = troca.getTroca1();
                    if(insertion.getTrocados().get(0).getTrocado1()!=8 && insertion.getTrocados().get(0).getTrocado2() !=8){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(insertion.getTrocados().get(0).getTrocado1() != bot && insertion.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                    insertion.getTrocados().remove(0);
                    switch (bot){
                        case 0: button8.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(insertion, bot, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button8.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(insertion, bot, button1);
                            button1.setClickable(true);
                            break;
                        case 3: button8.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(insertion, bot, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button8.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(insertion, bot, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button8.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(insertion, bot, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button8.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(insertion, bot, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button8.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(insertion, bot, button7);
                            button7.setClickable(true);
                            break;
                        case 2: button8.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(insertion, bot, button2);
                            button2.setClickable(true);
                            break;
                        case 9: button8.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(insertion, bot, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(insertion, 8, button8);
                    button8.setClickable(true);
                    troca.reseta();
                    if(insertion.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                button9.setBackgroundResource(R.color.Red);
                button9.setClickable(false);
                if(troca.insere(9)){
                    String texto = (String) button9.getText();
                    int bot = troca.getTroca1();
                    if(insertion.getTrocados().get(0).getTrocado1()!=9 && insertion.getTrocados().get(0).getTrocado2() !=9){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(insertion.getTrocados().get(0).getTrocado1() != bot && insertion.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                    insertion.getTrocados().remove(0);
                    switch (bot){
                        case 0: button9.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(insertion, bot, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button9.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(insertion, bot, button1);
                            button1.setClickable(true);
                            break;
                        case 3: button9.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(insertion, bot, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button9.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(insertion, bot, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button9.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(insertion, bot, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button9.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(insertion, bot, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button9.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(insertion, bot, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button9.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(insertion, bot, button8);
                            button8.setClickable(true);
                            break;
                        case 2: button9.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(insertion, bot, button2);
                            button2.setClickable(true);
                            break;
                    }
                    checaCerto(insertion, 9, button9);
                    button9.setClickable(true);
                    troca.reseta();
                    if(insertion.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(InsertionActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }
                }



            }
        });


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(InsertionActivity.this, Choices.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void checaCerto(InsertionSort insertion, int id, Button button){
        boolean flag = false;
        if(insertion.getVet()[id] == Integer.parseInt((String)button.getText())){
            for(int i = 0; i< insertion.getTrocados().size()-1; i++){
                if(insertion.getTrocados().get(i).getTrocado1() == id || insertion.getTrocados().get(i).getTrocado2() == id){
                    flag=true;
                }
            }
            if(!flag){
                button.setBackgroundResource(R.color.Green);
            }else {
                button.setBackgroundResource(R.color.LightBlue);
            }
        }else{
            button.setBackgroundResource(R.color.LightBlue);
        }
    }

    //start timer function
    void startTimer(final TextView mTextField, int time) {
        cTimer = new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished) {
                mTextField.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                // mTextField.setText("TIMEOUT!");
                new AlertDialog.Builder(InsertionActivity.this)
                        .setTitle("GAME OVER")
                        .setMessage("Acabou o tempo!")
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mInterstitialAd.show();
                            }
                        }).create().show();


            }
        };
        cTimer.start();
    }

            void cancelTimer() {
                if(cTimer!=null)
                    cTimer.cancel();
            }

            private void requestNewInterstitial() {
                AdRequest adRequest = new AdRequest.Builder()
                        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                        .build();

                mInterstitialAd.loadAd(adRequest);
            }


}
