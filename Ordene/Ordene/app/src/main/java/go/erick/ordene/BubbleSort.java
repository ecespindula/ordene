package go.erick.ordene;

import java.util.ArrayList;

/**
 * Created by erick on 25/11/16.
 */

public class BubbleSort {
    private int[] vet;
    private ArrayList <Trocado> trocados = new ArrayList<>();

    public BubbleSort(int[] vet){
        this.vet=vet;

    }

    public void sort(){
        boolean troca = true;
        int aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < vet.length - 1; i++) {
                if (vet[i] > vet[i + 1]) {
                    Trocado tro=new Trocado(i,i+1);
                    trocados.add(tro);
                    aux = vet[i];
                    vet[i] = vet[i + 1];
                    vet[i + 1] = aux;
                    troca = true;
                }
            }
        }
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
}
