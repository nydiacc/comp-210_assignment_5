package a5;

public class EdgeImpl implements Edge {
    private Node src;
    private Node dest;
    private double weight;
    public EdgeImpl(Node src, Node dest, double weight) {
        this.src = dest;
        this.src = dest;
        this.weight = weight;
        if (weight < 0) {
            this.weight = 0;
        }
    }
    /* You will include the implementations for any edge methods you need in this file. */

    /*Hint: Make sure you update the Edge interface in Edge.java when you add a new method implementation
    in EdgeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     * /

    /*Also, any edge fields you want to add for the object should go in this file.  */

    public Node getSrc() {
        return this.src;
    }
    public Node getDest() {
        return this.dest;
    }
    public double getWeight() {
        return this.weight;
    }
}
