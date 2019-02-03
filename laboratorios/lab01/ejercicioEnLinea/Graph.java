package Ejercicio2;
import java.util.LinkedList;
import java.util.ArrayList;
/**
 * Class that creates an undirected graph and determines if it is bipartite using DFS,
 * given a number of nodes and the edges connecting them.
 *
 * Adapted from https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 * @author María Sofía Uribe
 * @author Isabel Graciano
 */

class Graph {

    public ArrayList<LinkedList<Integer>> adjecency;
    boolean[] visited,color;

    /**
     * Constructor, creates the undirected graph given a number of nodes .
     * @param nodes number of nodes of the graph
     */
    public Graph(int nodes) {
        adjecency = new ArrayList<>();
        for (int i = 0; i < nodes; i++) adjecency.add(new LinkedList<Integer>());
        visited = new boolean[nodes];
        color = new boolean[nodes];
        color[0] = true;
        color[0] = false;
    }


    /**
     * Sets the arcs of the graph (undirected).
     * @param arcs List of arcs connecting the nodes of the graph
     */
    public void setAdjecency(LinkedList<Arc> arcs) {
        for (Arc a : arcs){
            int to = a.Source;
            int from = a.Destination;
            adjecency.get(to).add(from);
            adjecency.get(from).add(to);
        }
    }


    /**
     * Auxiliary method that determines if the graph is bipartite and prints the result
     * @param sourceVertex vertex where the DFS algorithm will start
     */
    public void isBipartite(int sourceVertex){
        System.out.print("THE GRAPH IS ");
        System.out.println(DFS_Search(sourceVertex)? "BICOLORABLE":"NOT BICOLORABLE");
    }


    /**
     * Method that performs a DFS search of the graph and returns whether is bipartite or not
     * @param node node where the search is being performed
     * @return true if the graph is bipartite , false otherwise
     */
    public  boolean DFS_Search(int node) {

        LinkedList<Integer> list = adjecency.get(node);
        for (int nextNode : list) {
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                color[nextNode] = !color[node];
                if (!DFS_Search(nextNode)) return false;
            }
            else if (color[node] == color[nextNode]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList<Arc> arcs= new LinkedList<>();
        arcs.add(new Arc(0,1));
        arcs.add(new Arc(1,2));
        arcs.add(new Arc(2,0));


        Graph g = new Graph(3);
        g.setAdjecency(arcs);
        g.isBipartite(0);

        LinkedList<Arc> arcs2= new LinkedList<>();
        arcs2.add(new Arc(0,1));
        arcs2.add(new Arc(1,2));

        Graph g2 = new Graph(3);
        g2.setAdjecency(arcs2);
        g2.isBipartite(0);

        LinkedList<Arc> arcs3= new LinkedList<>();
        arcs3.add(new Arc(0,1));
        arcs3.add(new Arc(0,2));
        arcs3.add(new Arc(0,3));
        arcs3.add(new Arc(0,4));
        arcs3.add(new Arc(0,5));
        arcs3.add(new Arc(0,6));
        arcs3.add(new Arc(0,7));
        arcs3.add(new Arc(0,8));


        Graph g3 = new Graph(3);
        g3.setAdjecency(arcs2);
        g3.isBipartite(0);

    }

}
