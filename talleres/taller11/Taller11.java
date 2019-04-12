
/**
 * Clase en la cual se implementan los metodos del Taller 11
 *
 * Resuelve el problema de , dado un grafo completo, hallar el costo mínimo del recorrido que pasa por
 * todos los vértices exactamente una vez y vuelve al nodo inicial utilizando programación dinámica
 *
 * @author María Sofía Uribe , Isabel graciano
 */
public class Taller11 {

    /**
     * Método auxiliar que inicializa las matrices de costos y padres y llama al método posterior que resuelve el problema de TSP
     * usando programación dinámica
     * @param grafo grafo dado
     * @return  costo mínimo del recorrido que pasa por
     * todos los vértices exactamente una vez y vuelve al nodo inicial.
     */

    public static int heldKarp(Digraph grafo) {
        int n = grafo.size();
        int np = (int) Math.pow(2, n);
        int costos [][] = new int[n][np];
        int padres [][] = new int[n][np];

        for (int i = 0; i < n; i++) {// inicializar las matrices de costos y padres con -1 y añadir costos de los arcos que existan en el grafo
            for (int j = 0; j < np; j++) {
                padres[i][j] = -1;
                if (j ==0) costos[i][0] = grafo.getWeight(i,0);//añadir costos de arcos existentes
                else costos[i][j] = -1;

            }
        }
        return tsp(grafo, 0, np - 2,costos,padres);
    }

    /**
     * Método que calcula el costo mínimo del recorrido que pasa por
     * todos los vértices exactamente una vez y vuelve al nodo inicial
     * @param grafo grafo dado
     * @param dest vértice destino (el vértice fuente es siempre 0)
     * @param visit conjunto de vértices por los que se pasa para llegar de 0 al destino (en una máscara) , es un binario
     * @param costos matriz que guarda el costo de ir del nodo 0 al nodo destino pasando por el conjunto de vértices visit
     * @param padres matriz que guarda el predecesor al nodo actual
     *
     */
    private static int tsp( Digraph grafo, int dest, int visit ,int costos[][], int padres[][]) {
        int result = -1;
        int n = grafo.size();
        if (costos[dest][visit] != -1)
            return costos[dest][visit]; // retornar el resultado si ya ha sido asignado (diferente del valor inicial de -1)

        else {
            for (int i = 0; i < n; i++) {

                int regla = (int)Math.pow(2, n) - (int) Math.pow(2, i)  - 1;//regla para la máscara
                int conjunto = visit & regla;

                if (conjunto != visit) {
                    int temp = grafo.getWeight(dest,i)+
                            tsp(grafo,i, conjunto,costos,padres);
                    if (result == -1 || result > temp) {// si no se ha asignado el valor o se puede mejorar
                        result = temp;
                        padres[dest][visit] = i;
                    }
                }
            }
            costos[dest][visit] = result;
            return result;
        }
    }

}

