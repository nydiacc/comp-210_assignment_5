package a5;

import java.util.ArrayList;
import java.util.List;

public class NodeImpl implements Node {



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
    @Override
    public List<Edge> getCollection() {
        return this.edgeCollection;
    }
    @Override
    public boolean edgePresent(String dest) {
        for (Edge idx : edgeCollection) {
            if (idx.getDest().getName().equals(dest)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int getInDegree() {
        return this.inDegree;
    }
    @Override
    public int incInDegree() {
        return inDegree++;
    }
    @Override
    public int decInDegree() {
        return inDegree--;
    }
    @Override
    public void addEdge(Edge idx) {
        edgeCollection.add(idx);
    }
    @Override
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