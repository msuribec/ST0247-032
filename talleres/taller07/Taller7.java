

import java.util.*;

public class Taller7 {

    private  static int vMinDist(Digraph g, boolean [] visitados ,int[] tabla){
        int min = Integer.MAX_VALUE;
        int minIndex = -1 ;
        for (int i = 0; i < g.size; i++) {
            if (tabla[i] <= min && !visitados[i]){
                min = tabla[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void actualizar(Digraph g ,int v, int [] tabla){
        if(tabla[v] != Integer.MAX_VALUE){
            ArrayList<Integer> adyacentes = g.getSuccessors(v);
            int peso = tabla[v];
            for (Integer u: adyacentes){
                int w =  g.getWeight(v,u);
                if (v != u &&  w !=Integer.MAX_VALUE && (w+peso) < tabla[u])
                    tabla[u]= w+peso;

            }
        }

    }

    private static void initialize(int [] distances  , int v, boolean [] visited){
        Arrays.fill(distances,Integer.MAX_VALUE);
        Arrays.fill(visited,false);
        distances[v] = 0;

    }

    public static int[] dijkstra(Digraph g, int v){
        int[] tabla = new int [g.size];
        boolean[] visitados = new boolean[g.size()];
        initialize(tabla,v,visitados);
        int actual = v;
        for (int i = 0; i < g.size() -1 ; i++) {
            actual = vMinDist(g, visitados, tabla);
            visitados[actual] = true;
            actualizar(g, actual, tabla);
        }
        return tabla;
    }

    public static int prim(Digraph graph) {
        int parent[] = new int[graph.size];
        int distances[] = new int [graph.size];
        boolean visited[] = new boolean[graph.size];
        initialize(distances,0,visited);
        parent[0] = -1;

        for (int i = 0; i < graph.size-1; i++) {
            int v = vMinDist(graph,visited,distances);
            visited[v] = true;
            for (Integer u : graph.getSuccessors(v)){
                int w =graph.getWeight(v,u);
                if (w!=0 && !visited[u] && w < distances[u]) {
                    parent[u] = v;
                    distances[u] = w;
                }
            }
        }
        int cost = 0;
        for (int i = 1; i < graph.size; i++){
            cost += graph.getWeight(i,parent[i]);
        }
        return cost;
    }



}