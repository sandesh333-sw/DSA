import java.util.*;

class Edge {
    int src, dest, wt;

    public Edge(int s, int d, int w) {
        this.src = s;
        this.dest = d;
        this.wt = w;
    }
}

public class Prims {

    static class Pair implements Comparable<Pair> {
        int v, cost;

        public Pair(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // ascending
        }
    }

    public static void prims(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for(int i=0; i<graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("Total MST cost: " + finalCost);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        // undirected edges
        graph[0].add(new Edge(0, 1, 2));
        graph[1].add(new Edge(1, 0, 2));

        graph[0].add(new Edge(0, 3, 6));
        graph[3].add(new Edge(3, 0, 6));

        graph[1].add(new Edge(1, 2, 3));
        graph[2].add(new Edge(2, 1, 3));

        graph[1].add(new Edge(1, 3, 8));
        graph[3].add(new Edge(3, 1, 8));

        graph[2].add(new Edge(2, 3, 5));
        graph[3].add(new Edge(3, 2, 5));

        prims(graph); // should output MST cost = 10
    }
}
