import java.util.Arrays;
import java.util.ArrayList;



/**Solución del taller 4
 * Los tests para esta clase se encuentran en la clase NewTests.java
 * @author María Sofía Uribe
 * @author Isabel graciano
 */
public class Taller4 {

    /**
     * Metodo auxiliar para llamar el metodo hayCaminoDFS posterior
     * @param g grafo dado
     * @param v vertices
     * @param w vertice
     * @return true si hay camino, false de lo contrario
     */

    public static boolean hayCaminoDFS(Digraph g, int v, int w) {
        boolean[] visited = new boolean[g.size()];
        return hayCaminoDFS(g, v, w, visited);
    }

    /**
     * Metodo que recorre el grafo por medio de dfs
     * @param g grafo dado
     * @param v vertices
     * @param w vertice
     * @param visitados ayuda a tener un conteo acerca de que nodos han sido
     * o no visitados
     * @return true si hay camino, false de lo contrario
     */
    private static boolean hayCaminoDFS(Digraph g, int v, int w, boolean[] visitados) {
        visitados[v] = true;
        if (v == w) return true;
        else {
            ArrayList<Integer> hijos = g.getSuccessors(v);
            for(Integer h: hijos)
                if (!visitados[h] && hayCaminoDFS(g,h, w, visitados)) return true;
            return false;
        }
    }

    /**
     * Metodo auxiliar que llama al metodo costoMinimo posterior
     * @param g grafo dado
     * @param inicio nodo desde el cual empieza el recorrido
     * @param fin nodo donde termina el recorrido
     * @return cual es el costo que tiene
     */
    public static int costoMinimo(Digraph g,int inicio,int fin) {

        boolean[] visitados = new boolean[g.size()];
        return costoMinimo(g,inicio,fin,visitados);
    }



    /**
     * Metodo que recorre el grafo por medio de dfs teniendo en cuenta que
     * se quiere encontrar el de menor costo
     * @param g grafo dado
     * @param inicio nodo desde el cual empieza el recorrido
     * @param fin nodo donde termina el recorrido
     * @param visitados arreglo donde se guarda true si un nodo ha sido visitado
     * @return cual es el costo que tiene ir desde inicio a fin
     */
    public static int costoMinimo(Digraph g, int inicio, int fin,boolean [] visitados) {
        visitados[inicio]=true;
        int costoMinimo = Integer.MAX_VALUE - 10000;//Evitar que la suma siguiente lance un error
        int costoCamino = 0;
        if (inicio == fin) {
            visitados[inicio]=false;
            return costoCamino;
        }
        ArrayList<Integer> hijos = g.getSuccessors(inicio);
        for (Integer hijo : hijos) {
            if (!visitados[hijo]) {
                costoCamino = g.getWeight(inicio, hijo) + costoMinimo(g, hijo, fin, visitados);
                visitados[hijo] = false;//permitir backtracking , ver test g3 en clase New Tests
                if (costoCamino < costoMinimo) costoMinimo = costoCamino;
            }
        }

        return costoMinimo;
    }



    /**
     * Metodo auxiliar que llama al metodo recorrido posterior
     * con cada uno de los vertices
     * @param g grafo dado
     * @return cual es el costo que tiene
     */
    public static int recorrido(Digraph g,int k) {
        int[] visited = new int[1];
        visited[0] = k;
        int[] notVisited = new int[g.size()-1];

        int [] tmp =new int[g.size()];
        int z =0;
        for (int i = 0; i < tmp.length; i++){
            tmp[i]=i;
            if (i == k){
                z=i;
            }
        }

        notVisited = removeAt(tmp,z);


        return recorrido(g, visited, notVisited, 0,k);
    }

    /**
     * Metodo que recorre todo el grafo con la intencion de buscar un
     * camino que represente el menor costo pasando por todos los vertices exactamente
     * una vez y vuelva al nodo inicial
     * @param g grafo dado
     * @param visitados arreglo de nodos visitados
     * @param noVisitados arreglo de nodos aun no visitados
     * @param cost costo del recorrido
     * @param k nodo donde inicia
     * @return cual es el costo que tiene
     */
    private static int recorrido(Digraph g, int[] visitados, int[] noVisitados, int cost,int k ) {
        if (noVisitados.length == 0) return cost + g.getWeight(visitados[g.size() - 1], k);
        int mincost = Integer.MAX_VALUE ;
        for (int i = 0; i < noVisitados.length; i++) {//inicio -> fin para cada vértice no visitado
            int inicio = visitados[visitados.length - 1];//obtener el último de los visitados
            int fin = noVisitados[i];//obtener el siguiente de los no visitados
            int dist = recorrido(g,add(visitados,fin),removeAt(noVisitados,i),cost + g.getWeight(inicio, fin),k);
            if (dist < mincost) mincost = dist;
        }
        return mincost;
    }

    /**
     * Metodo que remueve el elemento de un arreglo según la posición dada
     * @param a arreglo al que se le removerá el elemento
     * @param k posición en la cual se quiere remover el arreglo
     * @return arreglo sin el elemento de la posición k
     */
    private static int[] removeAt(int a[],int k) {
        return concat(Arrays.copyOfRange(a, 0, k),Arrays.copyOfRange(a, k + 1, a.length));
    }

    /**
     * Metodo que añade un entero al final de un arreglo
     * @param a arreglo al que se le añadirá el entero
     * @param k entero a añadir
     * @return arreglo con el entero k en la última posición
     */
    private static int[] add(int a[],int k) {
        return concat(a, new int[] {k});
    }


    /**
     * Metodo que concatena los elementos de dos arreglos
     * @param arr1 primer arreglo a concatenar (sus elementos irán primero)
     * @param arr2 segundo arreglo a concatenar
     * @return arreglo con los elementos de arr1 y arr2
     */
    private static int[] concat(int[] arr1, int[] arr2){
        int length = arr1.length + arr2.length;
        int[] r = new int[length];
        System.arraycopy(arr1,0,r,0,arr1.length);
        System.arraycopy(arr2,0,r,arr1.length,arr2.length);
        return r;
    }




}
