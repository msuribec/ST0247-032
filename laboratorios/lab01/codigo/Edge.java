package Ejercicio1;


/**
 * Class that represents an edge or arc in the graph
 * @author María Sofía Uribe
 * @author Isabel Graciano
 */
public class Edge {
    private double distance;
    int IDsource,IDdestination;
    String name;


    public Edge(int IDsource, int IDdestination, double distance, String name) {
        this.distance = distance;
        this.IDsource = IDsource;
        this.IDdestination = IDdestination;
        this.name = name;
    }

    public int getIdVertex1(){
        return IDsource;
    }

    public int getIdVertex2(){
        return IDdestination;
    }

    public double getDistance(){
        return distance;
    }

    public String getName(){
        return name;
    }
    
    public void setIdVertex1(int IDV1){
        this.IDsource= IDV1;
    }

    public void setIdVertex2(int IDV2){
        this.IDdestination= IDV2;
    }

    public void setDisance(double distance){
        this.distance= distance;
    }

    public void setName(String name){
        this.name= name;
    }

}

