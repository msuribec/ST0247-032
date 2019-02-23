import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Solucion al ejercicio en linea
 *
 * @author María Sofía uribe
 * @author Isabel Graciano
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
        final String Filename = "reinas.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(Filename));
           

            ArrayList<Pair> holes = new ArrayList<>();

            String thisLine = br.readLine();
            int num = Integer.parseInt(thisLine);
            while(num != 0 ){
                thisLine = br.readLine();
                while(thisLine.charAt(0) =='*' ||  thisLine.charAt(0) =='.') {
                    for(int i = 0; i< num; i++){ 
                        for(int j = 0; j < num; j++)
                            if(thisLine.charAt(j) == '*') holes.add(new Pair(i,j));
                        thisLine = br.readLine();
                        
                    }
                }
                System.out.print("La solución con "+ num + " reinas es: ");
                nReinas(num,holes);
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
     * Metodo auxiliar para llamar el metodo posterior
     *
     * @param  n numero de reinas
     * @return numero de soluciones
     */
    public static void nReinas(int n,ArrayList<Pair> huecos) {
        int [] nsol = new int[]{0};
        nReinas( new int[n],0,n,nsol,huecos);
        System.out.println(nsol[0]);
    }



    /**
     * Metodo genera las soluciones del problema
     * @param  c columna
     * @param  n numero de reinas
     */
    private static void nReinas(int[] board, int c, int n,int[] nsol,ArrayList<Pair> huecos){
        if(c==n){
            nsol[0]++;
        }else{
            for(int r=0; r<n; r++){
                board[c] = r;
                if(ValidMoveInColumn(board,c,huecos))
                    nReinas(board,c+1,n,nsol,huecos);
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
    public static boolean ValidMoveInColumn(int[] board, int c,ArrayList<Pair> huecos){
        for(int i=0; i<c; i++){
            if(board[i]==board[c] || Math.abs(board[i]-board[c]) == (c-i))return false;
            for (Pair p : huecos)
                if ((int)p.getKey() == board[c] && (int)p.getValue() == c)
                    return false;
                    
                
        }
        return true;
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
