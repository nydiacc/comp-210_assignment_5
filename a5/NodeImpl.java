package a5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NodeImpl implements Node {

    /* You will include the method signatures (return type, name, and arg types) for any node methods you
    need in this file. */

    /*Hint: Make sure you update the Node interface in Node.java when you add a new method implementation
    in NodeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

    /*Also, any node fields you want to add for the object should go in this file.  */

    private String name;
    private List<Edge> edgeCollection;
    private int inDegree;
    public NodeImpl(String name) {
        this.name = name;
        this.edgeCollection = new ArrayList<>();
        this.inDegree = 0;
    }
    @Override
    public String getName() {
        return this.name;
    }
    public List<Edge> getCollection() {

        return this.edgeCollection;
    }
    public boolean edgePresent(String dest) {
        for (Edge e : edgeCollection) {
            if (e.getDest().getName().equals(dest)) {
                return true;
            }
        }
        return false;
    }
    public int getInDegree() {
        return this.inDegree;
    }
    public int incInDegree() {
        return inDegree++;
    }
    public int decInDegree() {
        return inDegree--;
    }
    public void addEdge(Edge idx) {
        edgeCollection.add(idx);
    }
    public boolean deleteEdge(String dest) {
        if (edgePresent(dest)) {
            for (Edge idx : edgeCollection) {
                if (idx.getDest().getName().equals(dest)) {
                    edgeCollection.remove(idx);
                    return true;
                }
            }
        }
        return false;
    }
}
