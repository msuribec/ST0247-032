

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Solution to the online exercise
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
     * This method reads a file "reinas.txt" and calls methods that can solve the board
     */
    public static void  read(){
        final String Filename = "reinas.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(Filename));
           

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
     * This is an aux method which calls the previous method
     *
     * @param  n number of queens
     * @return number of solutions
     */
    public static void nReinas(int n,ArrayList<Pair<Integer,Integer>> huecos) {
        int [] nsol = new int[]{0};
        nReinas( new int[n],0,n,nsol,huecos);
        System.out.println(nsol[0]);
    }



    /**
     * This method creates solutions to the problem
     * @param  c column
     * @param  n number of queens
     */
    private static void nReinas(int[] board, int c, int n,int[] nsol,ArrayList<Pair<Integer,Integer>> huecos){
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
     * This method verifies if is possible to put a queen in the column 'c' given a board
     * @param  c column
     * @param  board 
     * @return true if it is possible, false if it is not
     */
    public static boolean ValidMoveInColumn(int[] board, int c,ArrayList<Pair<Integer,Integer>> huecos){
        for(int i=0; i<c; i++){
            if(board[i]==board[c] || Math.abs(board[i]-board[c]) == (c-i))return false;
            for (Pair<Integer,Integer> p : huecos)
                if ((int)p.key == board[c] && (int)p.value == c)
                    return false;
                    
                
        }
        return true;
    }


     /**
     * This method prints the board
     *
     * @param tablero board of queens
     * @param n number of queens
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
