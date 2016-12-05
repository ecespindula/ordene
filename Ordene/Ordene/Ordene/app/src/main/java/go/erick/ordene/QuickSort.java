package go.erick.ordene;

import java.util.ArrayList;

/**
 * Created by erick on 25/11/16.
 */

public class QuickSort {
    private int[] vet;
    private int inicio, fim;
    private ArrayList<Trocado> trocados = new ArrayList<>();

    public QuickSort(int[] vet, int inicio, int fim) {
        this.vet = vet;
        this.inicio=inicio;
        this.fim=fim;
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
        if (inicio < fim) {
            int posicaoPivo = separar(vet, inicio, fim);
            QuickSort a = new QuickSort(vet, inicio, posicaoPivo - 1);
            a.sort();
            trocados.addAll(a.getTrocados());
            QuickSort b =new QuickSort(vet, posicaoPivo + 1, fim);
            b.sort();
            trocados.addAll(b.getTrocados());
        }
    }

    private int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo)
                i++;
            else if (pivo < vetor[f])
                f--;
            else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                Trocado tro=new Trocado(i,f);
                trocados.add(tro);
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        Trocado tro=new Trocado(inicio,f);
        trocados.add(tro);
        return f;
    }
}
