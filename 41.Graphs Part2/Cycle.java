import java.util.ArrayList;

public class Cycle {
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


    //detect cycle code
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, vis, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par){
        
    vis[curr] = true;

    for(Edge e : graph[curr]){
        if(!vis[e.dest]){
            if(detectCycleUtil(graph, vis, e.dest, curr)){
                return true;
            }
        } else if(e.dest != par){
            // The neighbor is visited AND not parent => back edge => cycle
            return true;
        }
    }

    return false;
}

    public static void main(String args[]){

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println(detectCycle(graph));
    }
}
