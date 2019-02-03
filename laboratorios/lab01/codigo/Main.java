package Ejercicio1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Class that reads the file, creates the graph and prints it.
 * @author María Sofía Uribe
 * @author Isabel Graciano
 */
public class Main {

    private HashMap<Integer,Vertex> Map = new HashMap<>();

    /**
     * method that reads the file and creates the grpah.
     */
    public  void  read(){
        final String Filename = "datos.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(Filename));
            String thisLine = br.readLine();
            thisLine=br.readLine();//saltar la primera linea

            while (thisLine != null && !thisLine.contains("Arco")){ // while !EOF
                String [] cadenaParticionada = thisLine.split(" ");
                String name = "";
                if ((cadenaParticionada.length >= 4)) {
                    //Leer el resto de palabras que forman el nombre
                    for (int i =3; i<cadenaParticionada.length;i++) name += " "+cadenaParticionada[i];
                }
                int IDVertex = (int)Double.parseDouble(cadenaParticionada[0]);
                double coordX = Double.parseDouble(cadenaParticionada[1]);
                double coordY=  Double.parseDouble(cadenaParticionada[2]);

                Map.put(IDVertex,new Vertex(IDVertex,coordX,coordY,name));
                thisLine = br.readLine();
            }
            thisLine=br.readLine();//saltar la linea de arcos
            while (thisLine != null ){ // while !EOF
                String [] cadenaParticionada = thisLine.split(" ");
                int IDsource = (int)Double.parseDouble(cadenaParticionada[0]);
                int IDdestination= (int)Double.parseDouble(cadenaParticionada[1]);
                double distance =  Double.parseDouble(cadenaParticionada[2]);
                String name = "";
                if ((cadenaParticionada.length >= 4)) {
                    //Leer el resto de palabras que forman el nombre
                    for (int i =3; i<cadenaParticionada.length;i++) name += " "+cadenaParticionada[i];
                }
                Vertex v = Map.get(IDsource);
                v.addSuccesor(IDdestination,new Edge(IDsource,IDdestination,distance,name));
                thisLine = br.readLine();
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
     * method that prints the graph.
     */
    public void printMap() {
        Iterator it = Map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry element = (Map.Entry) it.next();
            Map.get(element .getKey()).printSuccesors();
        }

    }


    public static void main(String[]args){
        Main r = new Main();
        r.read();
        r.printMap();
    }
}
