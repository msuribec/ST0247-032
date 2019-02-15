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

    /**
     * Metodo auxiliar que llama al metodo costoMinimo posterior
     * @param g grafo dado
     * @param src nodo desde el cual empieza el recorrido
     * @param to nodo donde termina el recorrido
     * @return cual es el costo que tiene
     */
    public static int costoMinimo(Digraph g,int src,int to) {
        boolean[] visited = new boolean[g.size()];
        return costoMinimo(g,src,to,visited);
    }


    public static void main(String[]args){
        
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
        
        
        
    }
}
