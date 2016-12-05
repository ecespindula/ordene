package go.erick.ordene;

import java.util.ArrayList;

/**
 * Created by erick on 25/11/16.
 */

public class InsertionSort {
    private int[] vet;
    private ArrayList<Trocado> trocados = new ArrayList<>();

    public InsertionSort(int[] vet) {
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
        for (int i = 0; i < vet.length; i++)
        {
            int a = vet[i];
            for (int j = i - 1; j >= 0 && vet[j] > a; j--)
            {
                vet[j + 1] = vet[j];
                vet[j] = a;
                Trocado tro=new Trocado(j,j+1);
                trocados.add(tro);
            }
        }
    }
}
