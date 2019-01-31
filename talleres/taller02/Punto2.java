import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solución del ejercicio 2 del taller 2
 * 
 * @author (María Sofía Uribe / Isabel Graciano) 
 * @version (2019)
 */

class Main{

  public static void permutations(String str,ArrayList<String>list){
      permutationsAux("", str,list);
    }
    
    public static void permutationsAux(String pre, String pos,ArrayList<String>list){
        if(pos.isEmpty()) {
            list.add(pre);
            System.out.println(AdvancedEncryptionStandard.desencriptarArchivo(pre));
        }
        else{
            for(int i=0; i<pos.length(); i++ ){
                permutationsAux(pre+pos.charAt(i),pos.substring(0,i)+pos.substring(i+1),list);
            }
        }
    }




public static void main(String[]args){
  
  ArrayList <String> lista = new ArrayList<>();

  //Imprimir resultados
  System.out.println("Resultados de las permutaciones");
  permutations("abcd",lista);
  for (int i =0;i< lista.size();i++) 
  System.out.println(lista.get(i));


  
  
}


}