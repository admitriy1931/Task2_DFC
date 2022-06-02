
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        var data = args[0];
        var result = args[1];
        BufferedReader reader = new BufferedReader(new FileReader(data));
        String line;
        List<String> lines = new ArrayList();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        String [] linesAsArray = lines.toArray(new String[lines.size()]);
        var verticesCount = Integer.parseInt(linesAsArray[0]);
        Graph graph = new Graph(verticesCount);
        for (int i = 1; i < verticesCount + 1; i++){
            var a = linesAsArray[i].split(" ");
            var len = a.length;
            for (int j = 0; j < len - 1; j++){
                graph.addEdge(i - 1, new Vertice(Integer.parseInt(a[j]) - 1,i - 1));
            }
        }
        FileWriter writter = new FileWriter(result);
        var cycle = HasCycle(graph, verticesCount);
        if (cycle.size() != 0){
            writter.append("N" + "\n");
            for (int i = 0; i<cycle.size();i++){
                writter.append(cycle.get(i) + 1 + "\n");
            }
        }
        else{
            writter.append("A");
        }
        writter.flush();
    }

    public static ArrayList<Integer> HasCycle(Graph graph, int verticesCount){
        var endList = new ArrayList<Integer>();
        var visited = new ArrayList<Integer>();
        var finished = new HashSet<Integer>();
        var stack = new MyStack(100);
        stack.push(graph.getFirst());
        int arr[] = new int[verticesCount];
        arr[graph.getFirst().numOfVertex] = -1;
        while (stack.isEmpty() == false){
            var node = stack.pop();
            visited.add(node.numOfVertex);
            for (Vertice e: graph.incNodes(node)) {
                if(visited.contains(e.numOfVertex) == false){
                    arr[e.numOfVertex] = node.numOfVertex;
                    stack.push(e);
                }
                 //&& finished.contains(e.numOfVertex) == false
                //e.numOfVertex != arr[node.numOfVertex]
                if(visited.contains(e.numOfVertex) && e.numOfVertex != arr[node.numOfVertex]){
                    endList.add(e.numOfVertex);
                    for (int v = node.numOfVertex; v!= e.numOfVertex; v = arr[v]){
                        endList.add(v);
                    }
                    Collections.sort(endList);
                    return endList;
                }
                finished.add(node.numOfVertex);
            }
        }
        return endList;
    }
}
