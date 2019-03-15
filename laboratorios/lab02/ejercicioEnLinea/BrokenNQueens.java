import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solucion al ejercicio en linea
 *
 * @author María Sofía uribe
 * @author Isabel Graciano
 * Adapted from introcs to CS from princeton lectures Book
 * @version 22/02/2018
 */
public class BrokenNQueens {

    public static void main(String [] args){
        read();
    }

     /**
     * Metodo que lee de un archivo "reinas.txt" y llama a los métodos que resuleven el tablero
     */
    public static void  read(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("reinas.txt"));
           

            ArrayList<Pair<Integer,Integer>> holes = new ArrayList<>();

            String thisLine = br.readLine();
            int num = Integer.parseInt(thisLine);
            while(num != 0 ){
                thisLine = br.readLine();
                while(thisLine.charAt(0) =='*' ||  thisLine.charAt(0) =='.') {
                    for(int i = 0; i< num; i++){ 
                        for(int j = 0; j < num; j++)
                            if(thisLine.charAt(j) == '*') holes.add(Pair.makePair(i,j));
                        thisLine = br.readLine();
                        
                    }
                }
                System.out.print("La solución con "+ num + " reinas es: ");
                int n = num;
                int [] board =  new int[n];
                for (int i = 0; i < n; i++)
                    board[i] = i;
                perm(board, new boolean[2*n], new boolean[2*n] , n, holes );
                num = Integer.parseInt(thisLine);
            }


        }
        catch(IOException ioe) {
            System.out.println("Hubo un error en la lectura de datos");
            ioe.printStackTrace();
        }
        finally {
            try { br.close();}
            catch (IOException e) {e.printStackTrace(); }
        }
    }
    /**
     * Metodo que intercambia dos elementos de un arreglo
     * @param a arreglo
     * @param i posición del primer elemento
     * @param j posición del segundo elemento
     */
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * El método verifica si el tablero es valido según los "huecos" que tenga
     * @param  board tablero
     * @param  huecos lista de parejas que representan las casillas que no se pueden ocupar
     * @return true if it is possible, false if it is not
     */
    public static boolean ValidBoard(int[] board , ArrayList<Pair<Integer,Integer>> huecos){
        for(int i=0; i< board.length; i++){
            for (Pair<Integer,Integer> p : huecos){
                if ( p.value == board[i] && p.key == i)
                    return false;
            }
        }
        return true;
    }



    /**
     * Método que encuentra todas las posibles ubicaciones de las reinas y decide cuales son las correctas según los huecos del tablero y
     * verificando que las reinas no se ataquen
     * @param  board tablero
     * @param  visitedD1 arreglo de booleanos que indica si la diagonal 1 está  ocupada
     * @param  visitedD2 arreglo de booleanos que indica si la diagonal 2 está  ocupada
     * @param  c columna actual
     * @param  holes lista de huecos del tablero
     */
    public static void perm(int[] board, boolean[] visitedD1, boolean[] visitedD2, int c, ArrayList holes) {
        int n = board.length;

        if (c == 0 ) imprimirTablero(board,board.length);


        for (int i = 0; i < c; i++) {

            swap(board, i, c-1);

            int j = c-1;

            if (ValidBoard(board,holes)&&!visitedD1[j+ board[j]] && !visitedD2[n+j-board[j]] ) {
                visitedD1[j + board[j]] = true;
                visitedD2[n+ j - board[j]] = true;
                perm(board, visitedD1, visitedD2, c-1, holes);


                visitedD1[j + board[j]] = false;
                visitedD2[n + j - board[j]] = false;
            }
            swap(board, i, c-1);
        }
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