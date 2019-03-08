

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

    public static int[] dijkstra(Digraph g, int v){
        int[] tabla = new int [g.size];
        Arrays.fill(tabla,Integer.MAX_VALUE);
        tabla[v] = 0;
        int actual = v;
        boolean[] visitados = new boolean[g.size()];
        for (int i = 0; i < g.size() -1 ; i++) {
            actual = vMinDist(g, visitados, tabla);
            visitados[actual] = true;
            actualizar(g, actual, tabla);
        }
        return tabla;
    }

    public static void pruebaDijkstra(){
        DigraphAL g = new DigraphAL(8);
        g.addArc(0,1,20);
        g.addArc(0,3,80);
        g.addArc(0,6,90);

        g.addArc(1,5,10);

        g.addArc(2,7,20);
        g.addArc(2,5,50);
        g.addArc(2,3,10);

        g.addArc(3,2,10);
        g.addArc(3,6,20);

        g.addArc(4,1,50);
        g.addArc(4,6,30);

        g.addArc(5,2,10);
        g.addArc(5,3,40);

        g.addArc(6,0,20);

        System.out.println(Arrays.toString(Taller7.dijkstra(g, 0) ));

    }


    public static void main(String [] args ){
      pruebaDijkstra();
    }
}
