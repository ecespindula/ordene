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

public class SelectionActivity extends AppCompatActivity {
    CountDownTimer cTimer = null;
    MediaPlayer mp, victory, defeat;
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

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

        mp = MediaPlayer.create(SelectionActivity.this, R.raw.click);
        victory = MediaPlayer.create(SelectionActivity.this, R.raw.victory);
        defeat = MediaPlayer.create(SelectionActivity.this, R.raw.defeat);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-4577339383482486/3527210657");

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

        final SelectionSort selection = new SelectionSort(lista);
        selection.sort();
        int i;
        for(i = 0; i < selection.getTrocados().size();i++) {
            System.out.println(selection.getTrocados().get(i).getTrocado1()+" "+selection.getTrocados().get(i).getTrocado2());
        }
        startTimer(timer, 40000);

        dica.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(limiteDica[0] >0) {
                    limiteDica[0]--;
                    mp.start();
                    switch (selection.getTrocados().get(0).getTrocado1()) {
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

                    switch (selection.getTrocados().get(0).getTrocado2()) {
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
                int cor, cor2;
                button0.setBackgroundResource(R.color.Red);
                //button0.setClickable(false);
                if(troca.insere(0)){
                    String texto = (String) button0.getText();
                    int bot = troca.getTroca1();
                    if(selection.getTrocados().get(0).getTrocado1()!=0 && selection.getTrocados().get(0).getTrocado2() !=0){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(selection.getTrocados().get(0).getTrocado1() != bot && selection.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                    if(selection.getTrocados().get(0).getTrocado2() != 0){
                        cor2 = R.color.Green;
                        cor= R.color.LightBlue;
                    }else{
                        cor2 = R.color.LightBlue;
                        cor= R.color.Green;
                    }
                    if(selection.getTrocados().get(0).getTrocado1()==selection.getTrocados().get(0).getTrocado2()){
                        cor = R.color.Green;
                        cor2 = R.color.Green;
                    }
                    selection.getTrocados().remove(0);
                    switch (bot){
                        case 1: button0.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(cor);
                            button1.setClickable(true);
                            break;
                        case 2: button0.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(cor);
                            button2.setClickable(true);
                            break;
                        case 3: button0.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(cor);
                            button3.setClickable(true);
                            break;
                        case 4: button0.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(cor);
                            button4.setClickable(true);
                            break;
                        case 5: button0.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(cor);
                            button5.setClickable(true);
                            break;
                        case 6: button0.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(cor);
                            button6.setClickable(true);
                            break;
                        case 7: button0.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(cor);
                            button7.setClickable(true);
                            break;
                        case 8: button0.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(cor);
                            button8.setClickable(true);
                            break;
                        case 9: button0.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(cor);
                            button9.setClickable(true);
                            break;
                    }
                    button0.setBackgroundResource(cor2);
                    button0.setClickable(true);
                    troca.reseta();
                    if(selection.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                int cor, cor2;
                button1.setBackgroundResource(R.color.Red);
                //button1.setClickable(false);
                if(troca.insere(1)){
                    String texto = (String) button1.getText();
                    int bot = troca.getTroca1();
                    if(selection.getTrocados().get(0).getTrocado1()!=1 && selection.getTrocados().get(0).getTrocado2() !=1){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();

                    }else if(selection.getTrocados().get(0).getTrocado1() != bot && selection.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                    if(selection.getTrocados().get(0).getTrocado2() != 1){
                        cor2 = R.color.Green;
                        cor= R.color.LightBlue;
                    }else{
                        cor2 = R.color.LightBlue;
                        cor= R.color.Green;
                    }
                    if(selection.getTrocados().get(0).getTrocado1()==selection.getTrocados().get(0).getTrocado2()){
                        cor = R.color.Green;
                        cor2 = R.color.Green;
                    }
                    selection.getTrocados().remove(0);
                    switch (bot){
                        case 0: button1.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 2: button1.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(cor);
                            button2.setClickable(true);
                            break;
                        case 3: button1.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(cor);
                            button3.setClickable(true);
                            break;
                        case 4: button1.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(cor);
                            button4.setClickable(true);
                            break;
                        case 5: button1.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(cor);
                            button5.setClickable(true);
                            break;
                        case 6: button1.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(cor);
                            button6.setClickable(true);
                            break;
                        case 7: button1.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(cor);
                            button7.setClickable(true);
                            break;
                        case 8: button1.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(cor);
                            button8.setClickable(true);
                            break;
                        case 9: button1.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(cor);
                            button9.setClickable(true);
                            break;
                    }
                    button1.setBackgroundResource(cor2);
                    button1.setClickable(true);
                    troca.reseta();
                    if(selection.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                int cor, cor2;
                //button2.setClickable(false);
                if(troca.insere(2)){
                    String texto = (String) button2.getText();
                    int bot = troca.getTroca1();
                    if(selection.getTrocados().get(0).getTrocado1()!=2 && selection.getTrocados().get(0).getTrocado2() !=2){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(selection.getTrocados().get(0).getTrocado1() != bot && selection.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                    if(selection.getTrocados().get(0).getTrocado2() != 2){
                        cor2 = R.color.Green;
                        cor= R.color.LightBlue;
                    }else{
                        cor2 = R.color.LightBlue;
                        cor= R.color.Green;
                    }
                    if(selection.getTrocados().get(0).getTrocado1()==selection.getTrocados().get(0).getTrocado2()){
                        cor = R.color.Green;
                        cor2 = R.color.Green;
                    }
                    selection.getTrocados().remove(0);
                    switch (bot){
                        case 0: button2.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button2.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(cor);
                            button1.setClickable(true);
                            break;
                        case 3: button2.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(cor);
                            button3.setClickable(true);
                            break;
                        case 4: button2.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(cor);
                            button4.setClickable(true);
                            break;
                        case 5: button2.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(cor);
                            button5.setClickable(true);
                            break;
                        case 6: button2.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(cor);
                            button6.setClickable(true);
                            break;
                        case 7: button2.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(cor);
                            button7.setClickable(true);
                            break;
                        case 8: button2.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(cor);
                            button8.setClickable(true);
                            break;
                        case 9: button2.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(cor);
                            button9.setClickable(true);
                            break;
                    }
                    button2.setBackgroundResource(cor2);
                    button2.setClickable(true);
                    troca.reseta();
                    if(selection.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                int cor, cor2;
                //button3.setClickable(false);
                if(troca.insere(3)){
                    String texto = (String) button3.getText();
                    int bot = troca.getTroca1();
                    if(selection.getTrocados().get(0).getTrocado1()!=3 && selection.getTrocados().get(0).getTrocado2() !=3){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(selection.getTrocados().get(0).getTrocado1() != bot && selection.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                    if(selection.getTrocados().get(0).getTrocado2() != 3){
                        cor2 = R.color.Green;
                        cor= R.color.LightBlue;
                    }else{
                        cor2 = R.color.LightBlue;
                        cor= R.color.Green;
                    }
                    if(selection.getTrocados().get(0).getTrocado1()==selection.getTrocados().get(0).getTrocado2()){
                        cor = R.color.Green;
                        cor2 = R.color.Green;
                    }
                    selection.getTrocados().remove(0);
                    switch (bot){
                        case 0: button3.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button3.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(cor);
                            button1.setClickable(true);
                            break;
                        case 2: button3.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(cor);
                            button2.setClickable(true);
                            break;
                        case 4: button3.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(cor);
                            button4.setClickable(true);
                            break;
                        case 5: button3.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(cor);
                            button5.setClickable(true);
                            break;
                        case 6: button3.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(cor);
                            button6.setClickable(true);
                            break;
                        case 7: button3.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(cor);
                            button7.setClickable(true);
                            break;
                        case 8: button3.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(cor);
                            button8.setClickable(true);
                            break;
                        case 9: button3.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(cor);
                            button9.setClickable(true);
                            break;
                    }
                    button3.setBackgroundResource(cor2);
                    button3.setClickable(true);
                    troca.reseta();
                    if(selection.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                int cor, cor2;
               // button4.setClickable(false);
                if(troca.insere(4)){
                    String texto = (String) button4.getText();
                    int bot = troca.getTroca1();
                    if(selection.getTrocados().get(0).getTrocado1()!=4 && selection.getTrocados().get(0).getTrocado2() !=4){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(selection.getTrocados().get(0).getTrocado1() != bot && selection.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                    if(selection.getTrocados().get(0).getTrocado2() != 4){
                        cor2 = R.color.Green;
                        cor= R.color.LightBlue;
                    }else{
                        cor2 = R.color.LightBlue;
                        cor= R.color.Green;
                    }
                    if(selection.getTrocados().get(0).getTrocado1()==selection.getTrocados().get(0).getTrocado2()){
                        cor = R.color.Green;
                        cor2 = R.color.Green;
                    }
                    selection.getTrocados().remove(0);
                    switch (bot){
                        case 0: button4.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button4.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(cor);
                            button1.setClickable(true);
                            break;
                        case 3: button4.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(cor);
                            button3.setClickable(true);
                            break;
                        case 2: button4.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(cor);
                            button2.setClickable(true);
                            break;
                        case 5: button4.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(cor);
                            button5.setClickable(true);
                            break;
                        case 6: button4.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(cor);
                            button6.setClickable(true);
                            break;
                        case 7: button4.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(cor);
                            button7.setClickable(true);
                            break;
                        case 8: button4.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(cor);
                            button8.setClickable(true);
                            break;
                        case 9: button4.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(cor);
                            button9.setClickable(true);
                            break;
                    }
                    button4.setBackgroundResource(cor2);
                    button4.setClickable(true);
                    troca.reseta();
                    if(selection.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                int cor, cor2;
                //button5.setClickable(false);
                if(troca.insere(5)){
                    String texto = (String) button5.getText();
                    int bot = troca.getTroca1();
                    if(selection.getTrocados().get(0).getTrocado1()!=5 && selection.getTrocados().get(0).getTrocado2() !=5){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(selection.getTrocados().get(0).getTrocado1() != bot && selection.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                    if(selection.getTrocados().get(0).getTrocado2() != 5){
                        cor2 = R.color.Green;
                        cor= R.color.LightBlue;
                    }else{
                        cor2 = R.color.LightBlue;
                        cor= R.color.Green;
                    }
                    if(selection.getTrocados().get(0).getTrocado1()==selection.getTrocados().get(0).getTrocado2()){
                        cor = R.color.Green;
                        cor2 = R.color.Green;
                    }
                    selection.getTrocados().remove(0);
                    switch (bot){
                        case 0: button5.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button5.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(cor);
                            button1.setClickable(true);
                            break;
                        case 3: button5.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(cor);
                            button3.setClickable(true);
                            break;
                        case 4: button5.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(cor);
                            button4.setClickable(true);
                            break;
                        case 2: button5.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(cor);
                            button2.setClickable(true);
                            break;
                        case 6: button5.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(cor);
                            button6.setClickable(true);
                            break;
                        case 7: button5.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(cor);
                            button7.setClickable(true);
                            break;
                        case 8: button5.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(cor);
                            button8.setClickable(true);
                            break;
                        case 9: button5.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(cor);
                            button9.setClickable(true);
                            break;
                    }
                    button5.setBackgroundResource(cor2);
                    button5.setClickable(true);
                    troca.reseta();
                    if(selection.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                int cor,cor2;
                //button6.setClickable(false);
                if(troca.insere(6)){
                    String texto = (String) button6.getText();
                    int bot = troca.getTroca1();
                    if(selection.getTrocados().get(0).getTrocado1()!=6 && selection.getTrocados().get(0).getTrocado2() !=6){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(selection.getTrocados().get(0).getTrocado1() != bot && selection.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                    if(selection.getTrocados().get(0).getTrocado2() != 6){
                        cor2 = R.color.Green;
                        cor= R.color.LightBlue;
                    }else{
                        cor2 = R.color.LightBlue;
                        cor= R.color.Green;
                    }
                    if(selection.getTrocados().get(0).getTrocado1()==selection.getTrocados().get(0).getTrocado2()){
                        cor = R.color.Green;
                        cor2 = R.color.Green;
                    }
                    selection.getTrocados().remove(0);
                    switch (bot){
                        case 0: button6.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button6.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(cor);
                            button1.setClickable(true);
                            break;
                        case 3: button6.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(cor);
                            button3.setClickable(true);
                            break;
                        case 4: button6.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(cor);
                            button4.setClickable(true);
                            break;
                        case 5: button6.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(cor);
                            button5.setClickable(true);
                            break;
                        case 2: button6.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(cor);
                            button2.setClickable(true);
                            break;
                        case 7: button6.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(cor);
                            button7.setClickable(true);
                            break;
                        case 8: button6.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(cor);
                            button8.setClickable(true);
                            break;
                        case 9: button6.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(cor);
                            button9.setClickable(true);
                            break;
                    }
                    button6.setBackgroundResource(cor2);
                    button6.setClickable(true);
                    troca.reseta();
                    if(selection.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                int cor,cor2;
                //button7.setClickable(false);
                if(troca.insere(7)){
                    String texto = (String) button7.getText();
                    int bot = troca.getTroca1();
                    if(selection.getTrocados().get(0).getTrocado1()!=7 && selection.getTrocados().get(0).getTrocado2() !=7){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(selection.getTrocados().get(0).getTrocado1() != bot && selection.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                    if(selection.getTrocados().get(0).getTrocado2() != 7){
                        cor2= R.color.Green;
                        cor= R.color.LightBlue;
                    }else{
                        cor2 = R.color.LightBlue;
                        cor= R.color.Green;
                    }
                    if(selection.getTrocados().get(0).getTrocado1()==selection.getTrocados().get(0).getTrocado2()){
                        cor = R.color.Green;
                        cor2 = R.color.Green;
                    }
                    selection.getTrocados().remove(0);
                    switch (bot){
                        case 0: button7.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button7.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(cor);
                            button1.setClickable(true);
                            break;
                        case 3: button7.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(cor);
                            button3.setClickable(true);
                            break;
                        case 4: button7.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(cor);
                            button4.setClickable(true);
                            break;
                        case 5: button7.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(cor);
                            button5.setClickable(true);
                            break;
                        case 6: button7.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(cor);
                            button6.setClickable(true);
                            break;
                        case 2: button7.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(cor);
                            button2.setClickable(true);
                            break;
                        case 8: button7.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(cor);
                            button8.setClickable(true);
                            break;
                        case 9: button7.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(cor);
                            button9.setClickable(true);
                            break;
                    }
                    button7.setBackgroundResource(cor2);
                    button7.setClickable(true);
                    troca.reseta();
                    if(selection.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                int cor, cor2;
                //button8.setClickable(false);
                if(troca.insere(8)){
                    String texto = (String) button8.getText();
                    int bot = troca.getTroca1();
                    if(selection.getTrocados().get(0).getTrocado1()!=8 && selection.getTrocados().get(0).getTrocado2() !=8){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(selection.getTrocados().get(0).getTrocado1() != bot && selection.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                    if(selection.getTrocados().get(0).getTrocado2() != 8){
                        cor2= R.color.Green;
                        cor= R.color.LightBlue;
                    }else{
                        cor2 = R.color.LightBlue;
                        cor= R.color.Green;
                    }
                    if(selection.getTrocados().get(0).getTrocado1()==selection.getTrocados().get(0).getTrocado2()){
                        cor = R.color.Green;
                        cor2 = R.color.Green;
                    }
                    selection.getTrocados().remove(0);
                    switch (bot){
                        case 0: button8.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button8.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(cor);
                            button1.setClickable(true);
                            break;
                        case 3: button8.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(cor);
                            button3.setClickable(true);
                            break;
                        case 4: button8.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(cor);
                            button4.setClickable(true);
                            break;
                        case 5: button8.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(cor);
                            button5.setClickable(true);
                            break;
                        case 6: button8.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(cor);
                            button6.setClickable(true);
                            break;
                        case 7: button8.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(cor);
                            button7.setClickable(true);
                            break;
                        case 2: button8.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(cor);
                            button2.setClickable(true);
                            break;
                        case 9: button8.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(cor);
                            button9.setClickable(true);
                            break;
                    }
                    button8.setBackgroundResource(cor2);
                    button8.setClickable(true);
                    troca.reseta();
                    if(selection.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                int cor,cor2;
                //button9.setClickable(false);
                if(troca.insere(9)){
                    String texto = (String) button9.getText();
                    int bot = troca.getTroca1();
                    if(selection.getTrocados().get(0).getTrocado1()!=9 && selection.getTrocados().get(0).getTrocado2() !=9){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mInterstitialAd.show();
                                    }
                                }).create().show();
                    }else if(selection.getTrocados().get(0).getTrocado1() != bot && selection.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
                    if(selection.getTrocados().get(0).getTrocado2() != 9){
                        cor2= R.color.Green;
                        cor= R.color.LightBlue;
                    }else{
                        cor2 = R.color.LightBlue;
                        cor= R.color.Green;
                    }
                    if(selection.getTrocados().get(0).getTrocado1()==selection.getTrocados().get(0).getTrocado2()){
                        cor = R.color.Green;
                        cor2 = R.color.Green;
                    }
                    selection.getTrocados().remove(0);
                    switch (bot){
                        case 0: button9.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button9.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(cor);
                            button1.setClickable(true);
                            break;
                        case 3: button9.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(cor);
                            button3.setClickable(true);
                            break;
                        case 4: button9.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(cor);
                            button4.setClickable(true);
                            break;
                        case 5: button9.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(cor);
                            button5.setClickable(true);
                            break;
                        case 6: button9.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(cor);
                            button6.setClickable(true);
                            break;
                        case 7: button9.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(cor);
                            button7.setClickable(true);
                            break;
                        case 8: button9.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(cor);
                            button8.setClickable(true);
                            break;
                        case 2: button9.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(cor);
                            button2.setClickable(true);
                            break;
                    }
                    button9.setBackgroundResource(cor2);
                    button9.setClickable(true);
                    troca.reseta();
                    if(selection.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(SelectionActivity.this)
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
        Intent intent = new Intent(SelectionActivity.this, Choices.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    //start timer function
    void startTimer(final TextView mTextField, int time) {
        cTimer = new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished) {
                mTextField.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                // mTextField.setText("TIMEOUT!");
                new AlertDialog.Builder(SelectionActivity.this)
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
