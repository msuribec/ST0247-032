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
     * Metodo auxiliar para llamar el metodo hayCaminoDFS posterior
     * @param g grafo dado
     * @param v vertices
     * @param w vertice
     * @param visited arreglo de booleanos que guarda true
     *                si el nodo ha sido visitado, false de lo contrario
     * @return true si hay camino, false de lo contrario
     */
    private static boolean hayCaminoDFS(Digraph g, int v, int w, boolean[] visited) {
        visited[v] = true;
        if (v == w) return true;
        else {
            ArrayList<Integer> children = g.getSuccessors(v);
            for(Integer child : children)
                if (!visited[child] && hayCaminoDFS(g, child, w, visited)) return true;
            return false;
        }
    }

    /**
     * Metodo que recorre el grafo por medio de dfs teniendo en cuenta que
     * se quiere encontrar el de menor costo
     * @param g grafo dado
     * @param inicio nodo desde el cual empieza el recorrido
     * @param fin nodo donde termina el recorrido
     * @return cual es el costo que tiene ir desde inicio a fin
     */
    public static int costoMinimo(Digraph g, int inicio, int fin,boolean [] visitados) {
        visitados[inicio] = true;
        int costoMinimo = Integer.MAX_VALUE;
        int costoCamino = 0;
        if (inicio == fin) return 0;
        else {
            ArrayList<Integer> hijos = g.getSuccessors(inicio);
            for (Integer hijo : hijos) {
                if (!visitados[hijo]) {
                    costoCamino = g.getWeight(inicio, hijo) + costoMinimo(g, hijo, fin, new boolean [g.size()]);
                    if (costoCamino<= costoMinimo) costoMinimo=costoCamino;
                }
            }
            return costoMinimo;
        }
    }

    /**
     * Metodo auxiliar que llama al metodo recorrido posterior
     * con cada uno de los vertices
     * @param g grafo dado
     * @return cual es el costo que tiene
     */
    public static int recorrido(Digraph g,int src,int to) {
        boolean[] visited = new boolean[g.size()];
        return costoMinimo(g,src,to,visited);
    }


    


    public static void main(String[]args){
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

        System.out.println(recorrido(g1,0,5));
    }
}
