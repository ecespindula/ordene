package go.erick.ordene;

import java.util.ArrayList;

/**
 * Created by erick on 02/12/16.
 */

public class HeapSort {
    private int[] vet;
    private ArrayList<Trocado> trocados = new ArrayList<>();
    private static int N;

    public HeapSort(int[] vet) {
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

    /* Sort Function */
    public void sort()
    {
        heapify(vet);
        for (int i = N; i > 0; i--)
        {
            swap(vet,0, i);
            trocados.get(trocados.size()-1).setFlagFim(true);
            N = N-1;
            maxheap(vet, 0);
        }
    }
    /* Function to build a heap */
    public void heapify(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);
    }
    /* Function to swap largest element in heap */
    public void maxheap(int arr[], int i)
    {
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])
            max = right;

        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }
    /* Function to swap two numbers in an array */
    public void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        Trocado tro = new Trocado(i,j);
        trocados.add(tro);
    }

}
