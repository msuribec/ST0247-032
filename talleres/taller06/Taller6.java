
/**
 * Clase en la cual se implementan los metodos del Taller 6
 *
 * @author Isabel Graciano , María Sofía Uribe
 */
public class Taller6 {

    /**
     * Metodo que dado un entero n y un conjunto de denominciones de dinero
     * busque la manera optima de dar el cambio
     * @param n cantidad a devolver
     * @param denominaciones conjunto de denominaciones de dinero (monedas, billetes)
     * @return un conjunto de unidades por denominacion
     */
    public static int[] cambioGreedy(int n, int[] denominaciones) {
        int respuesta [] = new int[denominaciones.length], suma =0, goal =n;
        boolean b= false;
        for (int i = 0; i < denominaciones.length; i++){
            int denom =denominaciones[i];
            int cantidad = n /denom;
            respuesta[i] = cantidad;
            suma += cantidad * denominaciones[i];
            n = n % denominaciones[i];
            b = b || cantidad > 0;

        }
        if (b && suma ==goal) return respuesta;
        return null;
    }



    /**
     * Metodo que recorre todo el grafo con la intencion de buscar un
     * camino que represente el menor costo pasando por todos los vertices exactamente
     * una vez y vuelva al nodo inicial
     * @param g grafo dado
     * @return cual es el costo que tiene
     */
    public static int recorrido(Digraph g) {
        int cont=0, v =0, cost =0, i=0;
        boolean [] visited = new boolean[g.size];
        while (cont < g.size){
            visited[v]=true;
            int menor = Integer.MAX_VALUE;
            for (int u : g.getSuccessors(v)){
                if ( u!=v && !visited[u]){
                    int peso =g.getWeight(v,u);
                    if (peso < menor){
                        menor = peso;
                        i = u;
                    }
                }
            }
            if (menor !=Integer.MAX_VALUE) cost += menor;
            v = i;
            cont ++;
        }
        return cost+g.getWeight(v,0);
    }







}