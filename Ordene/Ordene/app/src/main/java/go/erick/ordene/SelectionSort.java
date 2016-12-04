package go.erick.ordene;

import java.util.ArrayList;

/**
 * Created by erick on 25/11/16.
 */

public class SelectionSort {
    private int[] vet;
    private ArrayList<Trocado> trocados = new ArrayList<>();

    public SelectionSort(int[] vet) {
        this.vet = vet;
    }

    public int[] getVet() {
        return vet;
    }

    public void setVet(int[] vet) {
        this.vet = vet;
    }

    public ArrayList<Trocado> getTrocados() {
        return trocados;
    }

    public void setTrocados(ArrayList<Trocado> trocados) {
        this.trocados = trocados;
    }

    public void sort(){
        int menor;
        int indiceMenor;
        for (int i = 0; i < vet.length - 1; i++) {
            // antes de comparar, considera-se menor o valor atual do loop
            menor = vet[i];
            indiceMenor = i;

            // compara com os outros valores do vetor
            for (int j = i + 1; j < vet.length; j++){
                if (vet[j] < menor){
                    menor = vet[j];
                    indiceMenor = j;
                }
            }

            // troca os valores menor e maior
            vet[indiceMenor] = vet[i];
            vet[i] = menor;
            Trocado tro=new Trocado(i,indiceMenor);
            trocados.add(tro);
        }
    }
}
