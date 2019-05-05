

import java.util.Scanner;


/**
 *
 * @author ljpalaciom
 */
public class EjercicioEnlinea {

    public static void read () {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair<Integer, Integer>[] coordenadas;

        int xmundo = sc.nextInt();
        int ymundo = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            Pair<Integer, Integer> posicionInicial = new Pair<>(num1,num2);

            int numDesechos = sc.nextInt();

            DigraphAM grafo = new DigraphAM(numDesechos + 1);

            coordenadas = new Pair[numDesechos + 1];
            coordenadas[0] = posicionInicial;

            for (int j = 1; j <= numDesechos; j++) {
                int numa = sc.nextInt();
                int numb = sc.nextInt();
                coordenadas[j] = new Pair(numa,numb);
            }

            for (int k = 0; k <= numDesechos; k++) {
                for (int j = 0; j <= numDesechos; j++) {
                    if (k == j) {
                        continue;
                    }
                    grafo.addArc(k, j,
                            Math.abs(coordenadas[k].first - coordenadas[j].first)
                                    + Math.abs(coordenadas[k].second - coordenadas[j].second)
                    );
                }
            }
            System.out.println("The shortest path has length " + codLab5.heldKarp(grafo));
        }

    }

    public static void main(String[] args) {
        read();

    }
}
