package go.erick.ordene;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MergeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge);

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

        final MergeSort merge = new MergeSort(lista, 0, lista.length-1);
        merge.sort();
        int i;
        for(i = 0; i < merge.getTrocados().size();i++) {
            System.out.println(merge.getTrocados().get(i).getTrocado1()+" "+merge.getTrocados().get(i).getTrocado2());
        }

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button0.setBackgroundResource(R.color.Red);
                button0.setClickable(false);
                if(troca.insere(0)){
                    String texto = (String) button0.getText();
                    int bot = troca.getTroca1();
                    if(merge.getTrocados().get(0).getTrocado1()!=0 && merge.getTrocados().get(0).getTrocado2() !=0){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    }else if(merge.getTrocados().get(0).getTrocado1() != bot && merge.getTrocados().get(0).getTrocado2() != bot){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    merge.getTrocados().remove(0);
                    switch (bot){
                        case 1: button0.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(R.color.LightBlue);
                            button1.setClickable(true);
                            break;
                        case 2: button0.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(R.color.LightBlue);
                            button2.setClickable(true);
                            break;
                        case 3: button0.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(R.color.LightBlue);
                            button3.setClickable(true);
                            break;
                        case 4: button0.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(R.color.LightBlue);
                            button4.setClickable(true);
                            break;
                        case 5: button0.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(R.color.LightBlue);
                            button5.setClickable(true);
                            break;
                        case 6: button0.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(R.color.LightBlue);
                            button6.setClickable(true);
                            break;
                        case 7: button0.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(R.color.LightBlue);
                            button7.setClickable(true);
                            break;
                        case 8: button0.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(R.color.LightBlue);
                            button8.setClickable(true);
                            break;
                        case 9: button0.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(R.color.LightBlue);
                            button9.setClickable(true);
                            break;
                    }
                    button0.setBackgroundResource(R.color.LightBlue);
                    button0.setClickable(true);
                    troca.reseta();
                    if(merge.getTrocados().isEmpty()){
                        new AlertDialog.Builder(MergeActivity.this)
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
                button1.setBackgroundResource(R.color.Red);
                button1.setClickable(false);
                if(troca.insere(1)){
                    String texto = (String) button1.getText();
                    int bot = troca.getTroca1();
                    if(merge.getTrocados().get(0).getTrocado1()!=1 && merge.getTrocados().get(0).getTrocado2() !=1){
                        new AlertDialog.Builder(MergeActivity.this)
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

                    }else if(merge.getTrocados().get(0).getTrocado1() != bot && merge.getTrocados().get(0).getTrocado2() != bot){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    merge.getTrocados().remove(0);
                    switch (bot){
                        case 0: button1.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 2: button1.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(R.color.LightBlue);
                            button2.setClickable(true);
                            break;
                        case 3: button1.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(R.color.LightBlue);
                            button3.setClickable(true);
                            break;
                        case 4: button1.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(R.color.LightBlue);
                            button4.setClickable(true);
                            break;
                        case 5: button1.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(R.color.LightBlue);
                            button5.setClickable(true);
                            break;
                        case 6: button1.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(R.color.LightBlue);
                            button6.setClickable(true);
                            break;
                        case 7: button1.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(R.color.LightBlue);
                            button7.setClickable(true);
                            break;
                        case 8: button1.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(R.color.LightBlue);
                            button8.setClickable(true);
                            break;
                        case 9: button1.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(R.color.LightBlue);
                            button9.setClickable(true);
                            break;
                    }
                    button1.setBackgroundResource(R.color.LightBlue);
                    button1.setClickable(true);
                    troca.reseta();
                    if(merge.getTrocados().isEmpty()){
                        new AlertDialog.Builder(MergeActivity.this)
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
                button2.setBackgroundResource(R.color.Red);
                button2.setClickable(false);
                if(troca.insere(2)){
                    String texto = (String) button2.getText();
                    int bot = troca.getTroca1();
                    if(merge.getTrocados().get(0).getTrocado1()!=2 && merge.getTrocados().get(0).getTrocado2() !=2){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    }else if(merge.getTrocados().get(0).getTrocado1() != bot && merge.getTrocados().get(0).getTrocado2() != bot){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    merge.getTrocados().remove(0);
                    switch (bot){
                        case 0: button2.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button2.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(R.color.LightBlue);
                            button1.setClickable(true);
                            break;
                        case 3: button2.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(R.color.LightBlue);
                            button3.setClickable(true);
                            break;
                        case 4: button2.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(R.color.LightBlue);
                            button4.setClickable(true);
                            break;
                        case 5: button2.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(R.color.LightBlue);
                            button5.setClickable(true);
                            break;
                        case 6: button2.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(R.color.LightBlue);
                            button6.setClickable(true);
                            break;
                        case 7: button2.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(R.color.LightBlue);
                            button7.setClickable(true);
                            break;
                        case 8: button2.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(R.color.LightBlue);
                            button8.setClickable(true);
                            break;
                        case 9: button2.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(R.color.LightBlue);
                            button9.setClickable(true);
                            break;
                    }
                    button2.setBackgroundResource(R.color.LightBlue);
                    button2.setClickable(true);
                    troca.reseta();
                    if(merge.getTrocados().isEmpty()){
                        new AlertDialog.Builder(MergeActivity.this)
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
                button3.setBackgroundResource(R.color.Red);
                button3.setClickable(false);
                if(troca.insere(3)){
                    String texto = (String) button3.getText();
                    int bot = troca.getTroca1();
                    if(merge.getTrocados().get(0).getTrocado1()!=3 && merge.getTrocados().get(0).getTrocado2() !=3){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    }else if(merge.getTrocados().get(0).getTrocado1() != bot && merge.getTrocados().get(0).getTrocado2() != bot){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    merge.getTrocados().remove(0);
                    switch (bot){
                        case 0: button3.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button3.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(R.color.LightBlue);
                            button1.setClickable(true);
                            break;
                        case 2: button3.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(R.color.LightBlue);
                            button2.setClickable(true);
                            break;
                        case 4: button3.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(R.color.LightBlue);
                            button4.setClickable(true);
                            break;
                        case 5: button3.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(R.color.LightBlue);
                            button5.setClickable(true);
                            break;
                        case 6: button3.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(R.color.LightBlue);
                            button6.setClickable(true);
                            break;
                        case 7: button3.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(R.color.LightBlue);
                            button7.setClickable(true);
                            break;
                        case 8: button3.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(R.color.LightBlue);
                            button8.setClickable(true);
                            break;
                        case 9: button3.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(R.color.LightBlue);
                            button9.setClickable(true);
                            break;
                    }
                    button3.setBackgroundResource(R.color.LightBlue);
                    button3.setClickable(true);
                    troca.reseta();
                    if(merge.getTrocados().isEmpty()){
                        new AlertDialog.Builder(MergeActivity.this)
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
                button4.setBackgroundResource(R.color.Red);
                button4.setClickable(false);
                if(troca.insere(4)){
                    String texto = (String) button4.getText();
                    int bot = troca.getTroca1();
                    if(merge.getTrocados().get(0).getTrocado1()!=4 && merge.getTrocados().get(0).getTrocado2() !=4){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    }else if(merge.getTrocados().get(0).getTrocado1() != bot && merge.getTrocados().get(0).getTrocado2() != bot){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    merge.getTrocados().remove(0);
                    switch (bot){
                        case 0: button4.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button4.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(R.color.LightBlue);
                            button1.setClickable(true);
                            break;
                        case 3: button4.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(R.color.LightBlue);
                            button3.setClickable(true);
                            break;
                        case 2: button4.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(R.color.LightBlue);
                            button2.setClickable(true);
                            break;
                        case 5: button4.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(R.color.LightBlue);
                            button5.setClickable(true);
                            break;
                        case 6: button4.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(R.color.LightBlue);
                            button6.setClickable(true);
                            break;
                        case 7: button4.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(R.color.LightBlue);
                            button7.setClickable(true);
                            break;
                        case 8: button4.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(R.color.LightBlue);
                            button8.setClickable(true);
                            break;
                        case 9: button4.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(R.color.LightBlue);
                            button9.setClickable(true);
                            break;
                    }
                    button4.setBackgroundResource(R.color.LightBlue);
                    button4.setClickable(true);
                    troca.reseta();
                    if(merge.getTrocados().isEmpty()){
                        new AlertDialog.Builder(MergeActivity.this)
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
                button5.setBackgroundResource(R.color.Red);
                button5.setClickable(false);
                if(troca.insere(5)){
                    String texto = (String) button5.getText();
                    int bot = troca.getTroca1();
                    if(merge.getTrocados().get(0).getTrocado1()!=5 && merge.getTrocados().get(0).getTrocado2() !=5){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    }else if(merge.getTrocados().get(0).getTrocado1() != bot && merge.getTrocados().get(0).getTrocado2() != bot){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    merge.getTrocados().remove(0);
                    switch (bot){
                        case 0: button5.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button5.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(R.color.LightBlue);
                            button1.setClickable(true);
                            break;
                        case 3: button5.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(R.color.LightBlue);
                            button3.setClickable(true);
                            break;
                        case 4: button5.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(R.color.LightBlue);
                            button4.setClickable(true);
                            break;
                        case 2: button5.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(R.color.LightBlue);
                            button2.setClickable(true);
                            break;
                        case 6: button5.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(R.color.LightBlue);
                            button6.setClickable(true);
                            break;
                        case 7: button5.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(R.color.LightBlue);
                            button7.setClickable(true);
                            break;
                        case 8: button5.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(R.color.LightBlue);
                            button8.setClickable(true);
                            break;
                        case 9: button5.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(R.color.LightBlue);
                            button9.setClickable(true);
                            break;
                    }
                    button5.setBackgroundResource(R.color.LightBlue);
                    button5.setClickable(true);
                    troca.reseta();
                    if(merge.getTrocados().isEmpty()){
                        new AlertDialog.Builder(MergeActivity.this)
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
                button6.setBackgroundResource(R.color.Red);
                button6.setClickable(false);
                if(troca.insere(6)){
                    String texto = (String) button6.getText();
                    int bot = troca.getTroca1();
                    if(merge.getTrocados().get(0).getTrocado1()!=6 && merge.getTrocados().get(0).getTrocado2() !=6){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    }else if(merge.getTrocados().get(0).getTrocado1() != bot && merge.getTrocados().get(0).getTrocado2() != bot){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    merge.getTrocados().remove(0);
                    switch (bot){
                        case 0: button6.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button6.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(R.color.LightBlue);
                            button1.setClickable(true);
                            break;
                        case 3: button6.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(R.color.LightBlue);
                            button3.setClickable(true);
                            break;
                        case 4: button6.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(R.color.LightBlue);
                            button4.setClickable(true);
                            break;
                        case 5: button6.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(R.color.LightBlue);
                            button5.setClickable(true);
                            break;
                        case 2: button6.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(R.color.LightBlue);
                            button2.setClickable(true);
                            break;
                        case 7: button6.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(R.color.LightBlue);
                            button7.setClickable(true);
                            break;
                        case 8: button6.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(R.color.LightBlue);
                            button8.setClickable(true);
                            break;
                        case 9: button6.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(R.color.LightBlue);
                            button9.setClickable(true);
                            break;
                    }
                    button6.setBackgroundResource(R.color.LightBlue);
                    button6.setClickable(true);
                    troca.reseta();
                    if(merge.getTrocados().isEmpty()){
                        new AlertDialog.Builder(MergeActivity.this)
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
                button7.setBackgroundResource(R.color.Red);
                button7.setClickable(false);
                if(troca.insere(7)){
                    String texto = (String) button7.getText();
                    int bot = troca.getTroca1();
                    if(merge.getTrocados().get(0).getTrocado1()!=7 && merge.getTrocados().get(0).getTrocado2() !=7){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    }else if(merge.getTrocados().get(0).getTrocado1() != bot && merge.getTrocados().get(0).getTrocado2() != bot){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    merge.getTrocados().remove(0);
                    switch (bot){
                        case 0: button7.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button7.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(R.color.LightBlue);
                            button1.setClickable(true);
                            break;
                        case 3: button7.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(R.color.LightBlue);
                            button3.setClickable(true);
                            break;
                        case 4: button7.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(R.color.LightBlue);
                            button4.setClickable(true);
                            break;
                        case 5: button7.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(R.color.LightBlue);
                            button5.setClickable(true);
                            break;
                        case 6: button7.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(R.color.LightBlue);
                            button6.setClickable(true);
                            break;
                        case 2: button7.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(R.color.LightBlue);
                            button2.setClickable(true);
                            break;
                        case 8: button7.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(R.color.LightBlue);
                            button8.setClickable(true);
                            break;
                        case 9: button7.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(R.color.LightBlue);
                            button9.setClickable(true);
                            break;
                    }
                    button7.setBackgroundResource(R.color.LightBlue);
                    button7.setClickable(true);
                    troca.reseta();
                    if(merge.getTrocados().isEmpty()){
                        new AlertDialog.Builder(MergeActivity.this)
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
                button8.setBackgroundResource(R.color.Red);
                button8.setClickable(false);
                if(troca.insere(8)){
                    String texto = (String) button8.getText();
                    int bot = troca.getTroca1();
                    if(merge.getTrocados().get(0).getTrocado1()!=8 && merge.getTrocados().get(0).getTrocado2() !=8){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    }else if(merge.getTrocados().get(0).getTrocado1() != bot && merge.getTrocados().get(0).getTrocado2() != bot){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    merge.getTrocados().remove(0);
                    switch (bot){
                        case 0: button8.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button8.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(R.color.LightBlue);
                            button1.setClickable(true);
                            break;
                        case 3: button8.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(R.color.LightBlue);
                            button3.setClickable(true);
                            break;
                        case 4: button8.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(R.color.LightBlue);
                            button4.setClickable(true);
                            break;
                        case 5: button8.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(R.color.LightBlue);
                            button5.setClickable(true);
                            break;
                        case 6: button8.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(R.color.LightBlue);
                            button6.setClickable(true);
                            break;
                        case 7: button8.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(R.color.LightBlue);
                            button7.setClickable(true);
                            break;
                        case 2: button8.setText(button2.getText());
                            button2.setText(texto);
                            button2.setBackgroundResource(R.color.LightBlue);
                            button2.setClickable(true);
                            break;
                        case 9: button8.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(R.color.LightBlue);
                            button9.setClickable(true);
                            break;
                    }
                    button8.setBackgroundResource(R.color.LightBlue);
                    button8.setClickable(true);
                    troca.reseta();
                    if(merge.getTrocados().isEmpty()){
                        new AlertDialog.Builder(MergeActivity.this)
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
                button9.setBackgroundResource(R.color.Red);
                button9.setClickable(false);
                if(troca.insere(9)){
                    String texto = (String) button9.getText();
                    int bot = troca.getTroca1();
                    if(merge.getTrocados().get(0).getTrocado1()!=9 && merge.getTrocados().get(0).getTrocado2() !=9){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    }else if(merge.getTrocados().get(0).getTrocado1() != bot && merge.getTrocados().get(0).getTrocado2() != bot){
                        new AlertDialog.Builder(MergeActivity.this)
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
                    merge.getTrocados().remove(0);
                    switch (bot){
                        case 0: button9.setText(button0.getText());
                            button0.setText(texto);
                            button0.setBackgroundResource(R.color.LightBlue);
                            button0.setClickable(true);
                            break;
                        case 1: button9.setText(button1.getText());
                            button1.setText(texto);
                            button1.setBackgroundResource(R.color.LightBlue);
                            button1.setClickable(true);
                            break;
                        case 3: button9.setText(button3.getText());
                            button3.setText(texto);
                            button3.setBackgroundResource(R.color.LightBlue);
                            button3.setClickable(true);
                            break;
                        case 4: button9.setText(button4.getText());
                            button4.setText(texto);
                            button4.setBackgroundResource(R.color.LightBlue);
                            button4.setClickable(true);
                            break;
                        case 5: button9.setText(button5.getText());
                            button5.setText(texto);
                            button5.setBackgroundResource(R.color.LightBlue);
                            button5.setClickable(true);
                            break;
                        case 6: button9.setText(button6.getText());
                            button6.setText(texto);
                            button6.setBackgroundResource(R.color.LightBlue);
                            button6.setClickable(true);
                            break;
                        case 7: button9.setText(button7.getText());
                            button7.setText(texto);
                            button7.setBackgroundResource(R.color.LightBlue);
                            button7.setClickable(true);
                            break;
                        case 8: button9.setText(button8.getText());
                            button8.setText(texto);
                            button8.setBackgroundResource(R.color.LightBlue);
                            button8.setClickable(true);
                            break;
                        case 9: button9.setText(button9.getText());
                            button9.setText(texto);
                            button9.setBackgroundResource(R.color.LightBlue);
                            button9.setClickable(true);
                            break;
                    }
                    button9.setBackgroundResource(R.color.LightBlue);
                    button9.setClickable(true);
                    troca.reseta();
                    if(merge.getTrocados().isEmpty()){
                        new AlertDialog.Builder(MergeActivity.this)
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
        Intent intent = new Intent(MergeActivity.this, Choices.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
