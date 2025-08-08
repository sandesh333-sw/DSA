public class BellMan{
    public static void bellman(ArrayList<Edge>[] graph, int src){
        int[] dist = new int[graph.length];
        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;

        for(int i=0; i<V-1; i++){
            for(int j=0; j<graph.length; j++){
                for(int k=0; k<graph[j].size(); k++){
                    Edge e = graph[j].get(i);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        
                    }
                }
            }
        }
    }
}