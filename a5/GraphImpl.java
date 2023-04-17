package a5;

import java.util.*;

public class GraphImpl implements Graph {
    Map<String, Node> nodes; //Do not delete.  Use this field to store your nodes.
    // key: name of node. value: a5.Node object associated with name
    int numEdges;

    public GraphImpl() {
        nodes = new HashMap<>();
        numEdges = 0;
    }

    @Override
    public boolean addNode(String label) {
        if (nodes.containsKey(label)) {
            return false;
        }
        Node temp = new NodeImpl(label);
        nodes.put(label, temp);
        return true;
    }

    @Override
    public boolean addEdge(String src, String dest, double weight) {
        if (weight < 0) {
            return false;
        }
        if (!(nodes.containsKey(src)) || !(nodes.containsKey(dest))) {
            return false;
        }
        Node one = nodes.get(src);
        Node two = nodes.get(dest);
        Edge idx = new EdgeImpl(one, two, weight);
        if (one.edgePresent(dest)) {
            return false;
        }
        one.addEdge(idx);
        two.incInDegree();
        numEdges++;
        return true;
    }

    @Override
    public boolean deleteNode(String name) {

        if (!(nodes.containsKey(name))) {
            return false;
        }
        for (Node temp : nodes.values()) {
            for (Edge idx : temp.getCollection()) {
                if (idx.getDest().getName().equals(name)) {
                    deleteEdge(idx.getSrc().getName(), idx.getDest().getName());
                }
            }
        }
        nodes.remove(name);
        return true;
    }

    @Override
    public boolean deleteEdge(String src, String dest) {
        if (!nodes.containsKey(src) || !nodes.containsKey(dest)) {
            return false;
        }
        Node one = nodes.get(src);
        Node two = nodes.get(dest);

        if (one.deleteEdge(dest)) {
            numEdges--;
            two.decInDegree();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int numNodes() {
        return nodes.size();  //Dummy return value.  Remove when you implement!
    }

    @Override
    public int numEdges() {
        return numEdges;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public Stack<String> topoSort() {
        Stack<String> stack = new Stack<String>();
        Set<String> seen = new HashSet<String>();
        while (seen.size() < numNodes()) {
            Node nextNode = findNext(seen);
            if (nextNode == null) {
                return stack;
            }
            seen.add(nextNode.getName());
            stack.push(nextNode.getName());
            for (Edge idx : nextNode.getCollection()) {
                idx.getDest().decInDegree();

            }
        }
        return stack;
    }
    @Override
    public Node findNext(Set<String> seen) {
        Node temp = null;
        for (Map.Entry<String,Node> entry : nodes.entrySet()) {
            if (entry.getValue().getInDegree() == 0 && !seen.contains(entry.getKey())) {
                if (entry.getValue().getCollection().size() == 0) {
                    temp = entry.getValue();
                } else {
                    return entry.getValue();
                }
            }
        }
        return temp;
    }
}
