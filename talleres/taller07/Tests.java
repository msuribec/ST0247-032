import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Prueba la implementacion de los metodos en la clase Taller5.
 *
 * Ejecute esta clase para hacerse una idea de si su implementacion de los
 * ejercicios propuestos en el Taller de Clase #5 son correctos.
 *
 * @author Mateo Agudelo
 */
public class Tests {

    public static void main(String[] args) {

        System.out.println("Dijkstra-> " + convert(testDijkstra()));
        System.out.println("Prim-> " + convert(testPrim()));
    }

    static boolean testDijkstra() {
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

        if (!Arrays.equals(Taller7.dijkstra(g,0), new int[] { 0, 20, 40, 50,Integer.MAX_VALUE , 30, 70, 60 }))
            return false;
        return true;

    }

    static boolean testPrim() {
        DigraphAM g = new DigraphAM(5);

        g.addBothArcs(0,0,0);
        g.addBothArcs(1,1,0);
        g.addBothArcs(2,2,0);
        g.addBothArcs(3,3,0);
        g.addBothArcs(4,4,0);

        g.addBothArcs(0,1,2);
        g.addBothArcs(0,2,0);
        g.addBothArcs(0,3,6);
        g.addBothArcs(0,4,0);


        g.addBothArcs(2,1,3);
        g.addBothArcs(3,1,8);
        g.addBothArcs(4,1,5);
        g.addBothArcs(3,2,0);
        g.addBothArcs(4,2,7);
        g.addBothArcs(4,3,9);



        if (Taller7.prim(g)!= 16) return false;


        DigraphAL g1 = new DigraphAL(5);
        g1.addBothArcs(0,1,4);
        g1.addBothArcs(0,2,4);
        g1.addBothArcs(0,3,6);
        g1.addBothArcs(0,4,6);

        g1.addBothArcs(1,2,2);

        g1.addBothArcs(2,3,8);
        g1.addBothArcs(3,4,9);


        if (Taller7.prim(g1)!= 18) return false;

        return true;

    }



    static String convert(boolean b) {
        return b ? "correcta" : "incorrecta";
    }

}