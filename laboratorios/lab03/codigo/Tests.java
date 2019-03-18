
/**
 * Prueba la implementacion de los metodos en la clase ShortestDFS
 *
 * @author María Sofía Uribe
  @author Isabel Graciano
 */
public class Tests {

    public static void main(String[] args) {

        System.out.println("ShortestPathDFS-> " + convert(spathDFS()));

    }

    static boolean spathDFS() {
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

        if (ShortestDFS.Dfs(g,0,0)!=0)return false;
        if (ShortestDFS.Dfs(g,0,1)!=20)return false;
        if (ShortestDFS.Dfs(g,0,2)!=40)return false;
        if (ShortestDFS.Dfs(g,0,3)!=50)return false;
        if (ShortestDFS.Dfs(g,0,4)!=Integer.MAX_VALUE) return false;
        if (ShortestDFS.Dfs(g,0,5)!=30)return false;
        if (ShortestDFS.Dfs(g,0,6)!=70)return false;
        if (ShortestDFS.Dfs(g,0,7)!=60)return false;


        return true;

    }



    static String convert(boolean b) {
        return b ? "correcta" : "incorrecta";
    }

}
