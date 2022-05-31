import java.util.*;

class Graph {
    public int[] arr;
    public boolean cycl = false;
    private LinkedList<Vertice> adjLists[];

    Graph(int verticesCount) {
        adjLists = new LinkedList[verticesCount];
        arr = new int[verticesCount];
        for (int i = 0; i < verticesCount; i++)
            adjLists[i] = new LinkedList();
    }

    void addEdge(int src, Vertice dest) {
        adjLists[src].add(dest);
    }

    public Vertice getFirst() { return adjLists[0].getFirst();}

    //public int getNumberOfFirst() {return adjLists[0].getFirst().number;}

    public ArrayList<Vertice> incNodes(Vertice node) {
        ArrayList<Vertice> arr = new ArrayList<>();
        for (Vertice vertice: adjLists[node.numOfVertex]){
            arr.add(vertice);
        }
        return  arr;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "adjLists=" + Arrays.toString(adjLists) +
                '}';
    }
}



