import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartile{
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        //0
        graph[0].add(new Edge(0, 1));

        // 1-vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        // 2-vertex
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 4));

        // 3-vertex
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

        // 4-vertex
        graph[4].add(new Edge(4, 2));
    }




public static boolean isBirpartite(ArrayList<Edge>[] graph){
    int[] col = new int[graph.length];
    for(int i=0; i<col.length; i++){
        col[i] = -1;
    }

    Queue<Integer> q = new LinkedList<>();

    for(int i=0; i<graph.length; i++){
        if(col[i] == -1){
            q.add(i);
            col[i] = 0; //yellow

            while(!q.isEmpty()){
                int curr = q.remove();
                for(int j=0; j<graph[curr].size(); j++){
                    Edge e = graph[curr].get(j);
                    if(col[e.dest] == -1){
                        //if my color is 0 put neighbor color 1 otherwise 0
                        int nextCol = col[curr] == 0 ? 1: 0;
                        col[e.dest] = nextCol;
                        q.add(e.dest);
                    } else if(col[e.dest] == col[curr]){
                        return false;
                    }
                }
            }
        }
    }

    return true;
}

    public static void main(String args[]){

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBirpartite(graph));

    }
}
