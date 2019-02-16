

/**
 * Prueba la implementacion de los metodos en la clase Taller4.
 *
 * Ejecute esta clase para hacerse una idea de si su implementacion de los
 * ejercicios propuestos en el Taller de Clase #4 son correctos.
 *
 * @author Mateo Agudelo
 */
public class NewTests{

    public static void main(String[] args) {
        System.out.println("Recorrido (TSP) -> " + convert(testRecorrido()));
        System.out.println("Camino con costo minimo -> " + convert(testCostoMinimo()));
    }

    static boolean testRecorrido() {

        DigraphAL g1 = new DigraphAL(5);

        g1.addArc(0, 1, 2);
        g1.addArc(0, 2, 2);
        g1.addArc(0, 3, 1);
        g1.addArc(0, 4, 4);

        g1.addArc(1, 0, 2);
        g1.addArc(1, 2, 3);
        g1.addArc(1, 3, 2);
        g1.addArc(1, 4, 3);

        g1.addArc(2, 0, 2);
        g1.addArc(2, 1, 3);
        g1.addArc(2, 3, 2);
        g1.addArc(2, 4, 2);

        g1.addArc(3, 0, 1);
        g1.addArc(3, 1, 2);
        g1.addArc(3, 2, 2);
        g1.addArc(3, 4, 4);

        g1.addArc(4, 0, 4);
        g1.addArc(4, 1, 3);
        g1.addArc(4, 2, 2);
        g1.addArc(4, 3, 4);


        if (Taller4.recorrido(g1,0) != 10)
            return false;

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
        if (Taller4.recorrido(g2,0) != 22)
            return false;

        return true;
    }

    static boolean testCostoMinimo() {

        DigraphAL g = new DigraphAL(8);
        g.addArc(1, 5, 10);
        g.addArc(0, 1, 20);
        g.addArc(4, 1, 50);
        g.addArc(4, 6, 30);

        g.addArc(0, 6, 90);
        g.addArc(6, 0, 20);
        g.addArc(0, 3, 80);
        g.addArc(5, 3, 40);
        g.addArc(3, 6, 20);

        g.addArc(5, 2, 10);
        g.addArc(2, 5, 50);
        g.addArc(3, 2, 10);
        g.addArc(2, 3, 10);
        g.addArc(2, 7, 20);

        if (Taller4.costoMinimo(g,0,5) !=30)
            return false;

        DigraphAL g1 = new DigraphAL(6);
        g1.addArc(4, 5, 2);
        g1.addArc(0, 1, 1);
        g1.addArc(0, 2, 10);
        g1.addArc(0, 3, 5);
        g1.addArc(1, 2, 1);
        g1.addArc(1, 5, 15);
        g1.addArc(2, 5, 4);
        g1.addArc(3, 4, 3);
        g1.addArc(0, 5, 7);

        if (Taller4.costoMinimo(g1,0,5) !=6)
            return false;

        DigraphAL g2 = new DigraphAL(4);
        g2.addArc(0, 1, 10);
        g2.addArc(0, 2, 3);
        g2.addArc(0, 3, 20);
        g2.addArc(1, 3, 7);
        g2.addArc(2, 3, 6);
        if (Taller4.costoMinimo(g2,0,3) !=9 )
            return false;

        DigraphAL g3 = new DigraphAL(4);
        g3.addArc(0, 1, 3);
        g3.addArc(0, 2, 1);
        g3.addArc(2, 1, 1);
        g3.addArc(1, 3, 1);
        g3.addArc(2, 3, 10);
        if (Taller4.costoMinimo(g3,0,3) !=3 )
            return false;

        return true;
    }

    static String convert(boolean b) {
        return b ? "correcta" : "incorrecta";
    }

}
