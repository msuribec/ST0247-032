

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShortestPathRecovery {

    private static void dfsRecoveryPath (){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Digraph g = new DigraphAL(n + 1);

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g.addArc(a, b, c);
        }

        dfsBacktrack(g, 1,n);
    }


    private static void dfsBacktrack(Digraph g, int src, int end) {
        int [] dist = new int[g.size()];
        Arrays.fill(dist,Integer.MAX_VALUE);
        ArrayList <Integer> recorrido = new ArrayList<>();
        dist[src] =0;
        recorrido.add(src);

        ArrayList<Integer> sol = new ArrayList<>();
        System.out.println(dfsPath(g,src,end,dist,recorrido,sol));
        System.out.print(dist[end]);


    }


    private  static ArrayList dfsPath(Digraph g, int v, int end, int[] dist, ArrayList<Integer> recorrido,ArrayList<Integer> sol  ) {

        ArrayList<Integer> adyacentes = g.getSuccessors(v);

        if (v == end && !recorrido.isEmpty()) {
            sol = new ArrayList<>(recorrido);
            return sol;
        }

        for (Integer u : adyacentes) {
            int w = g.getWeight(v, u) + dist[v];
            if (dist[u] > w) {
                dist[u] = w;
                recorrido.add(u);
                sol = dfsPath(g, u, end, dist, recorrido,sol);
                recorrido.remove(u);
            }
        }

        return sol;
    }

    public static void main(String[] args) {
        dfsRecoveryPath();

    }

}