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
import android.widget.TextView;

import java.util.Random;

public class BubbleActivity extends AppCompatActivity {
    CountDownTimer cTimer = null;
    MediaPlayer mp, victory, defeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble);
        final Troca troca = new Troca();
        int[] lista = new int[10];
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
        mp = MediaPlayer.create(BubbleActivity.this, R.raw.click);
        victory = MediaPlayer.create(BubbleActivity.this, R.raw.victory);
        defeat = MediaPlayer.create(BubbleActivity.this, R.raw.defeat);

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

        final BubbleSort bubble = new BubbleSort(lista);
        bubble.sort();

        checaCerto(bubble, 0, button0);
        checaCerto(bubble, 1, button1);
        checaCerto(bubble, 2, button2);
        checaCerto(bubble, 3, button3);
        checaCerto(bubble, 4, button4);
        checaCerto(bubble, 5, button5);
        checaCerto(bubble, 6, button6);
        checaCerto(bubble, 7, button7);
        checaCerto(bubble, 8, button8);
        checaCerto(bubble, 9, button9);

        startTimer(timer);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                button0.setBackgroundResource(R.color.Red);
                button0.setClickable(false);
                if(troca.insere(0)){
                    String texto = (String) button0.getText();
                    int bot = troca.getTroca1();
                    if(bubble.getTrocados().get(0).getTrocado1()!=0 && bubble.getTrocados().get(0).getTrocado2() !=0){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }else if(bubble.getTrocados().get(0).getTrocado1() != bot && bubble.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }
                    bubble.getTrocados().remove(0);
                    switch (bot){
                        case 1: button0.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(bubble, 1, button1);
                            button1.setClickable(true);
                            break;
                        case 2: button0.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(bubble, 2, button2);
                            button2.setClickable(true);
                            break;
                        case 3: button0.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(bubble, 3, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button0.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(bubble, 4, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button0.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(bubble, 5, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button0.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(bubble, 6, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button0.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(bubble, 7, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button0.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(bubble, 8, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button0.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(bubble, 9, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(bubble, 0, button0);
                    button0.setClickable(true);
                    troca.reseta();
                    if(bubble.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                Choices.class);

                                        startActivity(returnBtn);
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
                    if(bubble.getTrocados().get(0).getTrocado1()!=1 && bubble.getTrocados().get(0).getTrocado2() !=1){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();

                    }else if(bubble.getTrocados().get(0).getTrocado1() != bot && bubble.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();

                    }
                    bubble.getTrocados().remove(0);
                    switch (bot){
                        case 0: button1.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(bubble, 0, button0);
                            button0.setClickable(true);
                            break;
                        case 2: button1.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(bubble, 2, button2);
                            button2.setClickable(true);
                            break;
                        case 3: button1.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(bubble, 3, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button1.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(bubble, 4, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button1.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(bubble, 5, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button1.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(bubble, 6, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button1.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(bubble, 7, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button1.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(bubble, 8, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button1.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(bubble, 9, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(bubble, 1, button1);
                    button1.setClickable(true);
                    troca.reseta();
                    if(bubble.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                Choices.class);

                                        startActivity(returnBtn);
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
                    if(bubble.getTrocados().get(0).getTrocado1()!=2 && bubble.getTrocados().get(0).getTrocado2() !=2){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }else if(bubble.getTrocados().get(0).getTrocado1() != bot && bubble.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }
                    bubble.getTrocados().remove(0);
                    switch (bot){
                        case 0: button2.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(bubble, 0, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button2.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(bubble, 1, button1);
                            button1.setClickable(true);
                            break;
                        case 3: button2.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(bubble, bot, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button2.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(bubble, bot, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button2.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(bubble, bot, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button2.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(bubble, bot, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button2.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(bubble, bot, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button2.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(bubble, bot, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button2.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(bubble, bot, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(bubble, 2, button2);
                    button2.setClickable(true);
                    troca.reseta();
                    if(bubble.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                Choices.class);

                                        startActivity(returnBtn);
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
                    if(bubble.getTrocados().get(0).getTrocado1()!=3 && bubble.getTrocados().get(0).getTrocado2() !=3){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }else if(bubble.getTrocados().get(0).getTrocado1() != bot && bubble.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }
                    bubble.getTrocados().remove(0);
                    switch (bot){
                        case 0: button3.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(bubble, bot, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button3.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(bubble, bot, button1);
                            button1.setClickable(true);
                            break;
                        case 2: button3.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(bubble, bot, button2);
                            button2.setClickable(true);
                            break;
                        case 4: button3.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(bubble, bot, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button3.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(bubble, bot, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button3.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(bubble, bot, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button3.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(bubble, bot, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button3.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(bubble, bot, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button3.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(bubble, bot, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(bubble, 3, button3);
                    button3.setClickable(true);
                    troca.reseta();
                    if(bubble.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                Choices.class);

                                        startActivity(returnBtn);
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
                    if(bubble.getTrocados().get(0).getTrocado1()!=4 && bubble.getTrocados().get(0).getTrocado2() !=4){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }else if(bubble.getTrocados().get(0).getTrocado1() != bot && bubble.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }
                    bubble.getTrocados().remove(0);
                    switch (bot){
                        case 0: button4.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(bubble, bot, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button4.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(bubble, bot, button1);
                            button1.setClickable(true);
                            break;
                        case 3: button4.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(bubble, bot, button3);
                            button3.setClickable(true);
                            break;
                        case 2: button4.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(bubble, bot, button2);
                            button2.setClickable(true);
                            break;
                        case 5: button4.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(bubble, bot, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button4.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(bubble, bot, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button4.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(bubble, bot, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button4.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(bubble, bot, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button4.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(bubble, bot, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(bubble, 4, button4);
                    button4.setClickable(true);
                    troca.reseta();
                    if(bubble.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                Choices.class);

                                        startActivity(returnBtn);
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
                    if(bubble.getTrocados().get(0).getTrocado1()!=5 && bubble.getTrocados().get(0).getTrocado2() !=5){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }else if(bubble.getTrocados().get(0).getTrocado1() != bot && bubble.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }
                    bubble.getTrocados().remove(0);
                    switch (bot){
                        case 0: button5.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(bubble, bot, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button5.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(bubble, bot, button1);
                            button1.setClickable(true);
                            break;
                        case 3: button5.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(bubble, bot, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button5.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(bubble, bot, button4);
                            button4.setClickable(true);
                            break;
                        case 2: button5.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(bubble, bot, button2);
                            button2.setClickable(true);
                            break;
                        case 6: button5.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(bubble, bot, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button5.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(bubble, bot, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button5.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(bubble, bot, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button5.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(bubble, bot, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(bubble, 5, button5);
                    button5.setClickable(true);
                    troca.reseta();
                    if(bubble.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                Choices.class);

                                        startActivity(returnBtn);
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
                    if(bubble.getTrocados().get(0).getTrocado1()!=6 && bubble.getTrocados().get(0).getTrocado2() !=6){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }else if(bubble.getTrocados().get(0).getTrocado1() != bot && bubble.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }
                    bubble.getTrocados().remove(0);
                    switch (bot){
                        case 0: button6.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(bubble, bot, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button6.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(bubble, bot, button1);
                            button1.setClickable(true);
                            break;
                        case 3: button6.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(bubble, bot, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button6.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(bubble, bot, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button6.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(bubble, bot, button5);
                            button5.setClickable(true);
                            break;
                        case 2: button6.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(bubble, bot, button2);
                            button2.setClickable(true);
                            break;
                        case 7: button6.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(bubble, bot, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button6.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(bubble, bot, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button6.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(bubble, bot, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(bubble, 6, button6);
                    button6.setClickable(true);
                    troca.reseta();
                    if(bubble.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                Choices.class);

                                        startActivity(returnBtn);
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
                    if(bubble.getTrocados().get(0).getTrocado1()!=7 && bubble.getTrocados().get(0).getTrocado2() !=7){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }else if(bubble.getTrocados().get(0).getTrocado1() != bot && bubble.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }
                    bubble.getTrocados().remove(0);
                    switch (bot){
                        case 0: button7.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(bubble, bot, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button7.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(bubble, bot, button1);
                            button1.setClickable(true);
                            break;
                        case 3: button7.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(bubble, bot, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button7.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(bubble, bot, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button7.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(bubble, bot, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button7.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(bubble, bot, button6);
                            button6.setClickable(true);
                            break;
                        case 2: button7.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(bubble, bot, button2);
                            button2.setClickable(true);
                            break;
                        case 8: button7.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(bubble, bot, button8);
                            button8.setClickable(true);
                            break;
                        case 9: button7.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(bubble, bot, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(bubble, 7, button7);
                    button7.setClickable(true);
                    troca.reseta();
                    if(bubble.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                Choices.class);

                                        startActivity(returnBtn);
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
                    if(bubble.getTrocados().get(0).getTrocado1()!=8 && bubble.getTrocados().get(0).getTrocado2() !=8){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }else if(bubble.getTrocados().get(0).getTrocado1() != bot && bubble.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }
                    bubble.getTrocados().remove(0);
                    switch (bot){
                        case 0: button8.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(bubble, bot, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button8.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(bubble, bot, button1);
                            button1.setClickable(true);
                            break;
                        case 3: button8.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(bubble, bot, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button8.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(bubble, bot, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button8.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(bubble, bot, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button8.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(bubble, bot, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button8.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(bubble, bot, button7);
                            button7.setClickable(true);
                            break;
                        case 2: button8.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(bubble, bot, button2);
                            button2.setClickable(true);
                            break;
                        case 9: button8.setText(button9.getText());
                            button9.setText(texto);
                            checaCerto(bubble, bot, button9);
                            button9.setClickable(true);
                            break;
                    }
                    checaCerto(bubble, 8, button8);
                    button8.setClickable(true);
                    troca.reseta();
                    if(bubble.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                Choices.class);

                                        startActivity(returnBtn);
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
                    if(bubble.getTrocados().get(0).getTrocado1()!=9 && bubble.getTrocados().get(0).getTrocado2() !=9){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }else if(bubble.getTrocados().get(0).getTrocado1() != bot && bubble.getTrocados().get(0).getTrocado2() != bot){
                        defeat.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("GAME OVER")
                                .setMessage("Voce errou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                MainActivity.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }
                    bubble.getTrocados().remove(0);
                    switch (bot){
                        case 0: button9.setText(button0.getText());
                            button0.setText(texto);
                            checaCerto(bubble, bot, button0);
                            button0.setClickable(true);
                            break;
                        case 1: button9.setText(button1.getText());
                            button1.setText(texto);
                            checaCerto(bubble, bot, button1);
                            button1.setClickable(true);
                            break;
                        case 3: button9.setText(button3.getText());
                            button3.setText(texto);
                            checaCerto(bubble, bot, button3);
                            button3.setClickable(true);
                            break;
                        case 4: button9.setText(button4.getText());
                            button4.setText(texto);
                            checaCerto(bubble, bot, button4);
                            button4.setClickable(true);
                            break;
                        case 5: button9.setText(button5.getText());
                            button5.setText(texto);
                            checaCerto(bubble, bot, button5);
                            button5.setClickable(true);
                            break;
                        case 6: button9.setText(button6.getText());
                            button6.setText(texto);
                            checaCerto(bubble, bot, button6);
                            button6.setClickable(true);
                            break;
                        case 7: button9.setText(button7.getText());
                            button7.setText(texto);
                            checaCerto(bubble, bot, button7);
                            button7.setClickable(true);
                            break;
                        case 8: button9.setText(button8.getText());
                            button8.setText(texto);
                            checaCerto(bubble, bot, button8);
                            button8.setClickable(true);
                            break;
                        case 2: button9.setText(button2.getText());
                            button2.setText(texto);
                            checaCerto(bubble, bot, button2);
                            button2.setClickable(true);
                            break;
                    }
                    checaCerto(bubble, 9, button9);
                    button9.setClickable(true);
                    troca.reseta();
                    if(bubble.getTrocados().isEmpty()){
                        victory.start();
                        cancelTimer();
                        new AlertDialog.Builder(BubbleActivity.this)
                                .setTitle("PARABENS")
                                .setMessage("Voce acertou o algoritmo")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent returnBtn = new Intent(getApplicationContext(),
                                                Choices.class);

                                        startActivity(returnBtn);
                                    }
                                }).create().show();
                    }
                }



            }
        });


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(BubbleActivity.this, Choices.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void checaCerto(BubbleSort bubble, int id, Button button){
        boolean flag = false;
        if(bubble.getVet()[id] == Integer.parseInt((String)button.getText())){
            for(int i = 0; i< bubble.getTrocados().size()-1; i++){
                if(bubble.getTrocados().get(i).getTrocado1() == id || bubble.getTrocados().get(i).getTrocado2() == id){
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
    void startTimer(final TextView mTextField) {
        cTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                mTextField.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                mTextField.setText("TIMEOUT!");
                new AlertDialog.Builder(BubbleActivity.this)
                        .setTitle("GAME OVER")
                        .setMessage("Acabou o tempo!")
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent returnBtn = new Intent(getApplicationContext(),
                                        MainActivity.class);

                                startActivity(returnBtn);
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

}
