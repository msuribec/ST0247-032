import java.util.Arrays;

/**
 * Clase en la cual se implementan los metodos del Taller 8
 * @author Isabel Graciano y María Sofía U
 * Adapted from https://algs4.cs.princeton.edu/22mergesort/Merge.java.html
 * */
class Taller8 {

    /**
     * Metodo auxiliar que llama al método posterior,
     * une dos subarreglos de un conjunto de elementos
     * @param arr un arreglo con elementos
     * @param l  posición donde comienza el primer subarreglo
     * @param m  posición donde termina el primer subarreglo
     * @param r posición donde termina el segundo subarreglo
     */
    private static void merge(int arr[], int l, int m, int r) {

        int L[] = new int [m - l + 1];
        int R[] = new int [r-m];

        for (int i=0; i< L.length; ++i)
            L[i] = arr[l + i];

        for (int j=0; j< R.length; ++j)
            R[j] = arr[m + 1 + j];

        merge(arr,L,R,l);

    }

    /**
     * Metodo que une dos subarreglos de un conjunto de elementos
     * @param arr un arreglo con elementos
     * @param La  subarreglo de la izquierda
     * @param Ra  subarreglo de la derecha
     * @param l  indice donde comienza el primer subarreglo
     */
    private static void merge(int arr[], int La[] , int Ra[], int l) {
        int i = 0, j = 0;

        while (i < La.length && j < Ra.length) {
            if (La[i] <= Ra[j])
                arr[l++] = La[i++];
            else
                arr[l++] = Ra[j++];
        }

        while (i < La.length)
            arr[l++] = La[i++];

        while (j < Ra.length)
            arr[l++] = Ra[j++];

    }

    /**
     * Metodo que pretende implementar el funcionamiento del algoritmo MergeSort
     * de un conjunto o subconjunto de elementos
     * @param arr un arreglo con elementos
     * @param l posción (izquierda)desde donde se ordena
     * @param r posción (derecha) hasta  donde se ordena
     */
    private static void mergesort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergesort(arr, l, m);
            mergesort(arr , m+1, r);
            merge(arr, l, m, r);
        }
    }
    /**
     * Metodo que pretende implementar el funcionamiento del algoritmo MergeSort
     * de un conjunto de elementos
     * @param arr un arreglo con elementos
     * para mas informacion ver
     * @see <a href="https://www.youtube.com/watch?v=JSceec-wEyw">
     *
     */
    public static void  mergesort(int arr[]) {
        mergesort(arr, 0, arr.length-1);
    }


    /**
     * Metodo auxiliar que llama al método posterior
     * @param a un arreglo con elementos
     */
    public static void quicksort(int[] a) {
        quickSort(a,0,a.length-1);
    }

    /**
     * Metodo que pretende implementar el funcionamiento del algoritmo MergeSort
     * de un conjunto de elementos
     * @param a un arreglo con elementos
     *
     * para mas informacion ver
     * @see <a href="https://www.youtube.com/watch?v=PgBzjlCcFvc">
     *
     */
    public static void quickSort(int a[], int l, int r) {
        if (l < r) {
            int index = findIndex(a, l, r);
            quickSort(a,l, index-1);
            quickSort(a,index+1, r);
        }
    }

    /**
     * Metodo que toma el último elemento como indice y cambia todos los elementos menores a una posición antes de este elemento
     * y posiciona los elementos mayores después de ese índice
     * @param arr un arreglo de elementos
     * @param l indice inicial del subconjunto que se quiere particionar
     * @param r indice final del subconjunto que se quiere partcionar
     * @return el índice donde se parte el conjunto de números
     */
    private  static int findIndex(int arr[], int l, int r) {
        int index = arr[r] ;
        int i = l-1;
        for (int j = l; j < r; j++) {
            if (arr[j] <= index) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;

        return i+1;
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
        mergesort(arr);
        System.out.println(Arrays.toString(arr));

        int arr2 [] = {17,0,1,89,100,84,2,4,7};
        System.out.println(Arrays.toString(arr2));
        quicksort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}