import java.util.*;

public class NearByCars {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distSq = x * x + y * y;
        }

        @Override
        public int compareTo(Point p) {
            return this.distSq - p.distSq; // min-heap based on distance squared
        }
    }

    public static void main(String[] args) {
        int[][] pts = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < pts.length; i++) {
            int x = pts[i][0];
            int y = pts[i][1];
            Point pt = new Point(x, y);
            pq.offer(pt);
        }

        // Print k nearest points
        System.out.println("Nearest " + k + " cars to origin:");
        for (int i = 0; i < k; i++) {
            Point p = pq.poll();
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
    }
}
