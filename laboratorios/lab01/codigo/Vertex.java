package Ejercicio1;

import javafx.util.Pair;
import java.util.LinkedList;

/**
 * Class that represents a vertex or node in the graph
 * @author María Sofía Uribe
 * @author Isabel Graciano
 */
public class Vertex {

    private String name;
    private int ID;
    double coordX,coordY;
    LinkedList<Pair<Integer,Edge>> succesors;

    public Vertex(int ID, double coordX, double coordY,String name) {
        this.ID = ID;
        this.name = name;
        this.coordX = coordX;
        this.coordY = coordY;
        this.succesors= new LinkedList<Pair<Integer,Edge>>();

    }

    public int  getID() {
        return ID;
    }

    public void setID(int  ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public LinkedList<Pair<Integer, Edge>> getSuccesors() {
        return succesors;
    }

    public void addSuccesor(int IDVertex,Edge e){
        succesors.add(new Pair<>(IDVertex,e));
    }

    public void printSuccesors(){
        System.out.print(ID+"->");
        for (Pair p: succesors){
            System.out.print(p.getKey()+"->");
        }
        System.out.println();
    }

}
