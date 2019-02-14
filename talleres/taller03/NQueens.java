
package taller3;
/**
 * Solución 1er Ejercicio
 * @author María Sofía Uribe
 * @author  Isabel Graciano
 *
 * @version (2019)
 */
public class NQueens {

   

    /**
     * Metodo auxiliar para llamar el metodo posterior
     *
     * @param  n numero de reinas
     * @return numero de soluciones
     */
    public static void nReinas(int n) {
      int [] nsol = new int[1];
      nsol[0]=0;
      nReinas( new int[n],0,n,nsol);
      System.out.println(nsol[0]);
    }


    
    /**
     * Metodo genera las soluciones del problema
     * @param  c columna
     * @param  n numero de reinas
     */
    private static void nReinas(int[] board, int c, int n,int[] nsol){
        if(c==n){
            imprimirTablero(board,n);
            nsol[0]++;
        }else{
            for(int r=0; r<n; r++){
                board[c] = r;
                if(ValidMoveInColumn(board,c)) nReinas(board,c+1,n,nsol);
            }
        }
    }


    /**
     * Metodo que verifica si es posible poner la reina en la columna c
     * dado un tablero
     * @param  c columna
     * @param  board el tablero
     * @return true si es posible, false de lo contrario
     */
    public static boolean ValidMoveInColumn(int[] board, int c){
        for(int i=0; i<c; i++){
            if(board[i]==board[c] || Math.abs(board[i]-board[c]) == (c-i))return false;
        }
        return true;
    }


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


    public static void main(String[]args){
        nReinas(4);
    }

}
