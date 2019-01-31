import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solución del ejercicio 1 del taller 2
 * 
 * @author (María Sofía Uribe / Isabel Graciano) 
 * @version (2019)
 */

class Punto1{
 
  public static void combinations(String cadena,ArrayList<String>list){
    combinationsAux("",cadena,list);
  }
  
  public static void combinationsAux(String pre, String pos,ArrayList<String>list){
  if (pos.isEmpty()) list.add(pre);
  else{
    combinationsAux(pre,pos.substring(1),list);
    combinationsAux(pre+pos.charAt(0),pos.substring(1),list);
  }
}

public static void main(String[]args){
  
  ArrayList <String> lista = new ArrayList<>();

  combinations("abc",lista);

  System.out.println("Resultados de las Combinaciones");
  for (int i =0;i< lista.size();i++) 
  System.out.println(lista.get(i));
  
}


}