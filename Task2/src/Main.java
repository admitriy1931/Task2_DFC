
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("data"));
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

        FileWriter writter = new FileWriter("result",false);
        var cycle = HasCycle(graph);
        if (cycle.size() != 0){
            writter.append("N" + "\n");
            for (int i = 0; i<cycle.size();i++){
                writter.append(cycle.get(i) + "\n");
            }
            writter.flush();
        }
        else{
            writter.append("A");
        }
    }

    public static ArrayList<Integer> HasCycle(Graph graph){
        var endList = new ArrayList<Integer>();
        var visited = new ArrayList<Integer>();
        var finished = new HashSet<Integer>();
        var stack = new MyStack(10);
        visited.add(graph.getFirst().numOfVertex);
        stack.push(graph.getFirst());
        int arr[] = new int[6];
        arr[graph.getFirst().numOfVertex] = -1;
        while (stack.isEmpty() == false){
            var node = stack.pop();
            for (Vertice e: graph.incNodes(node)) {
                if(visited.contains(e.numOfVertex) == false && finished.contains(e.numOfVertex) == false){
                    arr[e.numOfVertex] = node.numOfVertex;
                    stack.push(e);
                }
                else if(visited.contains(e.numOfVertex) && e.numOfVertex != arr[node.numOfVertex]){
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
