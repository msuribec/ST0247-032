import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller 5
 *
 * @author María Sofía Uribe, Isabel graciano
 */
public class Taller5 {


    /**
     * Metodo que dado un grafo y un numero m, se asigna un color
     * a cada nodo, de manera que dos nodos adyacentes no poseean el mismo color
     * @param g grafo dado
     * @param m numero de colores
     * @return true si es posible, false de lo contrario
     */
    public static boolean mColoring(Digraph g, int m) {
        if (!mColoring(g, 0, new int[g.size], 3))
            return false;
        return true;
    }

    /**
     * Metodo que dado un grafo y un vertice v, intenta asignar un color
     * al nodo, de manera que dos nodos adyacentes no poseean el mismo color
     * @param g grafo dado
     * @param m numero de colores
     * @param v vertice
     * @param colors conjunto de colores
     * @return true si es posible, false de lo contrario
     */
    private static boolean mColoring(Digraph g, int v, int[] colors, int m) {
        if (g.size  == v) return true;
        for (int clr = 1; clr <= m; clr++) {
            if (isSafe(g,v, colors, clr)) {
                colors[v] = clr;
                if (mColoring(g, v+1, colors, m)) return true;
                colors[v] = 0;
            }
        }
        return false;
    }
    

    /**
     * Metodo que dado un grafo y un vertice v, intenta asignar un color colors en la
     * posicion c al nodo v, de manera que dos nodos adyacentes no poseean el mismo color
     * @param g grafo dado
     * @param c indice de colores
     * @param v vertice
     * @param colors conjunto de colores
     * @return true si es posible, false de lo contrario
     */
    private static boolean isSafe(Digraph g, int v, int[] colors, int c) {
        ArrayList<Integer> sucesoresDeV = g.getSuccessors(v);
        for (Integer sucesor  : sucesoresDeV){
            if (colors[sucesor] == c) return false;
        }
        return true;
    }



}
