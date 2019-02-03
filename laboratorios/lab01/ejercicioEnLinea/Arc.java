package Ejercicio2;

/**
 * Class that represents an arc in the graph
 * @author María Sofía Uribe
 * @author Isabel Graciano
 */
class Arc {

    int Source, Destination;

    public Arc(int source, int destination) {
        Source = source;
        Destination = destination;
    }

    public int getSource() {
        return Source;
    }

    public void setSource(int source) {
        Source = source;
    }

    public int getDestination() {
        return Destination;
    }

    public void setDestination(int destination) {
        Destination = destination;
    }
};

