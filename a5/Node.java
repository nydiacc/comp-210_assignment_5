package a5;

import java.util.List;

public interface Node {

     String getName();

     List<Edge> getCollection();

     boolean edgePresent(String dest);

     int getInDegree();

     int incInDegree();

     int decInDegree();

     void addEdge(Edge idx);

     boolean deleteEdge(String dest);

}

