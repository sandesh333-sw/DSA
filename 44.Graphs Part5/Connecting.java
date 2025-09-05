import java.util.PriorityQueue;

public class Connecting implements Comparable<Connecting.Edge>{
    static class Edge{
        int dest;
        int cost;
        public Edge(int d, int cost){
            this.dest = d;
            this.cost = cost;  // Fix the parameter name
        }

        @Override
        public int compareTo(Edge e2){
            return this.cost - e2.cost;  // Correct comparison logic
        }
    }

    public static int connectCities(int[][] cities){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[cities.length];

        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.remove();
            if(!vis[curr.dest]){
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for(int i=0; i<cities[curr.dest].length; i++){
                    if(cities[curr.dest][i] != 0 && !vis[i]){
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }

        return finalCost;
    }

    public static void main(String args[]){
        int[][] cities = {
            {0, 10, 0, 0, 0},
            {10, 0, 5, 0, 0},
            {0, 5, 0, 15, 0},
            {0, 0, 15, 0, 20},
            {0, 0, 0, 20, 0}
        };

        int cost = connectCities(cities);
        System.out.println("Minimum cost to connect all cities: " + cost);
    }
}
