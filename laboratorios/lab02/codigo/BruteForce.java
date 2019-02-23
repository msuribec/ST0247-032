import java.util.ArrayList;

/**
 * Solucion al primer punto del lab2
 *
 * @author María Sofía uribe
 * @author Isabel Graciano
 * @version 22/02/2018
 */
public class BruteForce {


    private static int Calc( Digraph g, int src) {
        ArrayList<Integer> children = g.getSuccessors(src);
        int [] c;

        if (children.contains(src))c = new int[children.size()-1];
        else c = new int[children.size()];

        int z=0;
        for (int i =0 ; i < children.size(); i++){
            int temp = children.get(i);
            if (temp != src ){
                c[z]=temp;
                z++;
            }
        }
        int  mincost =  CalcPath(g,c,src);
        int sol []= new int[]{mincost};
        permutaciones(c,new int []{},sol,g,src);
        return sol[0];
    }


    private static int CalcPath( Digraph g,  int [] path , int src) {
        int cost = g.getWeight(src,path[0]) + g.getWeight(path[path.length-1],src);
        for (int i =0 ; i < path.length - 1; i++)
            cost += g.getWeight(path[i],path[i+1]);
        return cost;
    }

// a > no visitados
    // resp son los visitados
    private static void permutaciones(int[] notvisited, int [] visited, int [] minCost, Digraph g, int v) {
        if (notvisited.length == 0){
            int cost = CalcPath(g,visited,v);
            if (cost < minCost[0]) minCost[0] = cost;
        }
        else
            for (int j = 0; j < notvisited.length; j++)
                permutaciones(except(notvisited,j),add(visited,notvisited[j]),minCost,g,v);
    }


    /**
     * Metodo que devuelve un arreglo sin el elemento de la posición b
     * @param a arreglo al que se quitará el elemento
     * @param b posición del entero a quitar
     * @return arreglo sin el entero en la posición k
     */
    private static int[] except (int[] a, int b){
        int [] nuevo = new int[a.length-1];
        int z=0;
        for (int i =0 ; i < a.length; i++){
            if (i != b){
                nuevo[z]= a[i];
                z++;
            }
        }
        return nuevo;
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
        int[] r = new int[arr1.length + arr2.length];
        System.arraycopy(arr1,0,r,0,arr1.length);
        System.arraycopy(arr2,0,r,arr1.length,arr2.length);
        return r;
    }




    public static void main(String [] args){

        DigraphAL g2 = new DigraphAL(4);
        g2.addArc(0, 0, 0);
        g2.addArc(0, 1, 7);
        g2.addArc(0, 2, 15);
        g2.addArc(0, 3, 6);
        g2.addArc(1, 0, 2);
        g2.addArc(1, 1, 0);
        g2.addArc(1, 2, 7);
        g2.addArc(1, 3, 3);
        g2.addArc(2, 0, 9);
        g2.addArc(2, 1, 6);
        g2.addArc(2, 2, 0);
        g2.addArc(2, 3, 12);
        g2.addArc(3, 0, 10);
        g2.addArc(3, 1, 4);
        g2.addArc(3, 2, 8);
        g2.addArc(3, 3, 0);

        System.out.println(Calc(g2,1));

    }


}
