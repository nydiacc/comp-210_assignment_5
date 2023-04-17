package a5;

public class EdgeImpl implements Edge {

    private Node src;
    private Node dest;
    private double weight;


    public EdgeImpl(Node src, Node dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
        if (weight < 0) {
            this.weight = 0;
        }
    }

    @Override
    public Node getSrc() {
        return this.src;
    }
    @Override
    public Node getDest() {
        return this.dest;
    }
    @Override
    public double getWeight() {
        return this.weight;
    }
}
