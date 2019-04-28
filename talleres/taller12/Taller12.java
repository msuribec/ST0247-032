import java.util.Random;

/**
 * Clase en la cual se implementan los metodos del Taller 12
 *
 * @author Isabel graciano, María Sofía Uribe
 */

public class Taller12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        imprimirTablero(HillClimb(4),4);
    }

    static class Queen<F, S> {

        public final F row;
        public final S col;

        public Queen(F row, S col) {
            this.row = row;
            this.col = col;
        }

    }

    public static int[] HillClimb(int n) {
        int[] tablero = new int[n];
        int heuristica =Integer.MAX_VALUE;
        Queen temp = new Queen(Integer.MAX_VALUE, tablero.clone());

        while (heuristica!= 0){
            tablero = generateBoard(n);
            for (int i = 0; i < n; i++) {
                int start = tablero[i];
                for (int j = 0; j < n; j++) {
                    tablero[i] = j;
                    heuristica = reinasAtacandose(tablero);
                    if (heuristica == 0) return tablero;
                    if ((int) temp.row > heuristica) temp = new Queen(heuristica, tablero.clone());
                    tablero[i] = start;
                }
                for (int j = 0; j < tablero.length; j++) {
                    tablero[j] = ((int[]) temp.col)[j];
                }
            }
        }
        return tablero;
    }

    /**
     * Este metodo obtiene el numero de reinas que se atacan en el tablero
     */
    public static int reinasAtacandose(int[] tablero) {
        int cont = 0;
        for (int i = 0; i < tablero.length - 1; ++i) {
            for (int j = i + 1; j < tablero.length; j++) {
                if (i==j||tablero[i]== tablero[j]||Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j)){
                    cont++;
                }
            }
        }
        return cont;
    }

    /**
     * Este metodo genera un tablero de n reinas y las ubica en posiciones aleatorias
     */
    public static int[] generateBoard(int n) {
        int [] startBoard = new int[n];
        Random rndm = new Random();
        for(int i=0; i<n; i++){
            startBoard[i] = rndm.nextInt(n);
        }
        return startBoard;
    }

    /**
     * Metodo que imprime el tablero de reinas
     *
     * @param tablero tablero de reinas
     * @param n numero de reinas
     */
    public static void imprimirTablero(int[] tablero,int n) {
        System.out.print("  ");
        for (int i = 0; i < n; ++i) System.out.print(i + " ");
        System.out.print("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + " ");
            for (int j = 0; j < n; ++j) System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }

}