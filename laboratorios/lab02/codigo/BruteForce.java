import java.util.ArrayList;

/**
 * Solution of the first exercise
 *
 * @author María Sofía uribe
 * @author Isabel Graciano
 * @version 22/02/2018
 */
public class BruteForce {


    /**
     * Method who calls previous methods
     * @param g complete directed graph
     * @param src source node
     * @return  cost of the lower loop cost
     */
    private static int Calc( Digraph g, int src) {
        // if the start node is a children, we ignore it
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
        int  mincost =  CalcPath(g,c,src);// currently, min is the first path
        int sol []= new int[]{mincost};
        permutaciones(c,new int []{},sol,g,src); // does every permutation, calculate costs , return solution
        return sol[0];
    }


    /**
     * This method calculates the cost of the loop(initial vertex = final vertex) going through every vertex once
     * @param g complete directed graph
     * @param path 
     * @param src source vertex
     * @return  cost of the loop
     */
    private static int CalcPath( Digraph g,  int [] path , int src) {
        int cost = g.getWeight(src,path[0]) + g.getWeight(path[path.length-1],src);
        for (int i =0 ; i < path.length - 1; i++)
            cost += g.getWeight(path[i],path[i+1]);
        return cost;
    }

     /**
     * This method calculates every permutation of the paths and calculates the lower cost
     * @param notvisited array of non visited nodes 
     * @param visited array of visited nodes 
     * @param mincost aarray with every minimum cost
     * @param g graph 
     * @param v vertex
     */
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
     * This method returns an array without the element in the position b
     * @param a array in which we will remove the element 
     * @param b position where is the int we will remove
     * @return array without the int in the position k
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
     * This method adds an int at the end of an array
     * @param a array in which we will add an int
     * @param k an int we will add
     * @return array with an int 'k' int he last position
     */
    private static int[] add(int a[],int k) {
        return concat(a, new int[] {k});
    }

    /**
     * This method concatenates the elements of two arrays
     * @param arr1 first array to concatenate
     * @param arr2 second array to concatenate
     * @return array with the elements of both arrays
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
