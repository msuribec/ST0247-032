import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solution of the first exercise
 *
 * @author María Sofía uribe
 * @author Isabel Graciano
 * @version 17/03/2018
 */
public class ShortestDFS {

    
    public static int  Dfs (Digraph g, int src ,int end){
        int [] dist = new int[g.size()];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] =0;
        Dfs(g,src,dist);
        System.out.print(Arrays.toString(dist));
        return dist[end];
    }

    private static  void Dfs (Digraph g, int src, int []dist){
        ArrayList<Integer> adyacentes = g.getSuccessors(src);

        for (Integer u: adyacentes){
            int w =  g.getWeight(src,u)+ dist[src];
            if (dist[u]> w){
                dist[u]= w;
                Dfs(g, u, dist);
            }
        }

    }


}
