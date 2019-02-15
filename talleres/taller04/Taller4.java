import java.util.Arrays;
import java.util.ArrayList;


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
        int costoMinimo = Integer.MAX_VALUE -10000;
        int costoCamino = 0;
        if (inicio == fin) return costoCamino;
        ArrayList<Integer> hijos = g.getSuccessors(inicio);
        for (Integer hijo : hijos) {
            if (!visitados[hijo]) {
                visitados[hijo]=true;
                costoCamino = g.getWeight(inicio, hijo) + costoMinimo(g, hijo, fin, visitados);
                if (costoCamino < costoMinimo) costoMinimo = costoCamino;
            }
        }
        return costoMinimo;
    }



    public static int recorrido(Digraph g) {
        int[] visited = new int[1];
        visited[0] = 0;
        int[] notVisited = new int[g.size()-1];
        for (int i = 0; i < notVisited.length; i++)
            notVisited[i] = i + 1;
        return recorrido(g, visited, notVisited, 0);
    }

    private static int recorrido(Digraph g, int[] visitados, int[] notVisited, int cost) {
        if (notVisited.length == 0) return cost + g.getWeight(visitados[g.size() - 1], 0);
        int mincost = Integer.MAX_VALUE -10000;
        for (int i = 0; i < notVisited.length; i++) {//inicio -> fin para cada vértice no visitado
            int inicio = visitados[visitados.length - 1];//obtener el último de los visitados
            int fin = notVisited[i];//obtener el siguiente de los no visitados
            int dist = g.getWeight(inicio, fin)+recorrido(g,add(visitados,fin),removeAt(notVisited,i),cost);
            if (dist < mincost) mincost = dist;
        }
        return mincost;
    }

    private static int[] removeAt(int a[],int k) {
        return concat(Arrays.copyOfRange(a, 0, k),Arrays.copyOfRange(a, k + 1, a.length));
    }

    private static int[] add(int a[],int k) {
        return concat(a, new int[] {k});
    }


    private static int[] concat(int[] arr1, int[] arr2){
        int length = arr1.length + arr2.length;
        int[] r = new int[length];
        System.arraycopy(arr1,0,r,0,arr1.length);
        System.arraycopy(arr2,0,r,arr1.length,arr2.length);
        return r;
    }




    public static void main(String[] args) {



        //PRUEBAS GRAFO MINIMO COSTO DEL RECORRIDO (u,v)


        DigraphAL g1 = new DigraphAL(6);
        g1.addArc(4, 5, 2);
        g1.addArc(0, 1, 1);
        g1.addArc(0, 2, 10);
        g1.addArc(0, 3, 5);
        g1.addArc(1, 2, 1);
        g1.addArc(1, 5, 15);
        g1.addArc(2, 5, 4);
        g1.addArc(3, 4, 3);
        g1.addArc(0, 5, 7);

        System.out.println(costoMinimo(g1,0,5));


        //PRUEBAS GRAFO MINIMO COSTO DEL RECORRIDO (u,v) en un grafo con retroceso

        DigraphAL g = new DigraphAL(8);
        g.addArc(1, 5, 10);
        g.addArc(0, 1, 20);
        g.addArc(4, 1, 50);
        g.addArc(4, 6, 30);

        g.addArc(0, 6, 90);
        g.addArc(6, 0, 20);
        g.addArc(0, 3, 80);
        g.addArc(5, 3, 40);
        g.addArc(3, 6, 20);

        g.addArc(5, 2, 10);
        g.addArc(2, 5, 50);
        g.addArc(3, 2, 10);
        g.addArc(2, 3, 10);
        g.addArc(2, 7, 20);


        System.out.println(costoMinimo(g,0,5));


        //PRUEBAS Hay camino (u,v) en un grafo
        System.out.println(hayCaminoDFS(g,0,5));
        System.out.println(hayCaminoDFS(g,7,1));



        //PRUEBAS Ciclo con menos costo
        DigraphAL g2 = new DigraphAL(4);
        g2.addArc(0, 1, 7);
        g2.addArc(0, 2, 15);
        g2.addArc(0, 3, 6);

        g2.addArc(1, 0, 2);
        g2.addArc(1, 2, 7);
        g2.addArc(1, 3, 3);

        g2.addArc(2, 0, 9);
        g2.addArc(2, 1, 6);
        g2.addArc(2, 3, 12);

        g2.addArc(3, 0, 10);
        g2.addArc(3, 1, 4);
        g2.addArc(3, 2, 8);



        System.out.println(recorrido(g2));

    }

}
