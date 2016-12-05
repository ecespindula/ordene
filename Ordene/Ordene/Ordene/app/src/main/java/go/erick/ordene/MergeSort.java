package go.erick.ordene;

import java.util.ArrayList;

/**
 * Created by erick on 01/12/16.
 */

public class MergeSort {
    private int[] vet;
    private int posicaoInicio, posicaoFim;
    private ArrayList<Trocado> trocados = new ArrayList<>();

    public MergeSort(int[] vet, int posicaoInicio, int posicaoFim) {
        this.vet = vet;
        this.posicaoInicio = posicaoInicio;
        this.posicaoFim = posicaoFim;
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
        int i, j, k, metadeTamanho;
        int[] vetorTemp;

        if(posicaoInicio == posicaoFim) return;

        // ordenacao recursiva das duas metades
        metadeTamanho = (posicaoInicio + posicaoFim ) / 2;
        MergeSort a = new MergeSort(vet, posicaoInicio, metadeTamanho);
        a.sort();
        if(!a.getTrocados().isEmpty()){
            trocados.addAll(a.getTrocados());
        }
        MergeSort b = new MergeSort(vet, metadeTamanho + 1, posicaoFim);
        b.sort();
        if(!a.getTrocados().isEmpty()){
            trocados.addAll(b.getTrocados());
        }

        // intercalacao no vetor temporario t
        i = posicaoInicio;
        j = metadeTamanho + 1;
        k = 0;
        vetorTemp = new int[Integer.SIZE * (posicaoFim - posicaoInicio + 1)];
        while(i < metadeTamanho + 1 || j  < posicaoFim + 1) {
            if (i == metadeTamanho + 1 ) { // i passou do final da primeira metade, pegar v[j]
                vetorTemp[k] = vet[j];
                j++;
                k++;
            }
            else {
                if (j == posicaoFim + 1) { // j passou do final da segunda metade, pegar v[i]
                    vetorTemp[k] = vet[i];
                    i++;
                    k++;
                }
                else {
                    if (vet[i] < vet[j]) {
                        vetorTemp[k] = vet[i];
                        i++;
                        k++;
                    }
                    else {
                        vetorTemp[k] = vet[j];
                        if(posicaoInicio == 0 && posicaoFim == 9){
                            Trocado tro=new Trocado(k,j);
                            trocados.add(tro);
                        }else {
                            Trocado tro = new Trocado(i, j);
                            trocados.add(tro);
                        }
                        j++;
                        k++;
                    }
                }
            }

        }
        // copia vetor intercalado para o vetor original
        for(i = posicaoInicio; i <= posicaoFim; i++) {

            vet[i] = vetorTemp[i - posicaoInicio];

            System.out.println();

        }

    }
}
