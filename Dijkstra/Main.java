import utile.Dijkstra;
import utile.Graph;
import utile.Structura;

import java.io.FileNotFoundException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Graph g = new Graph("graph.txt");
        Dijkstra dj = new Dijkstra(g, 13);
        for (int i = 1; i <= 13; i++) {
            System.out.println(dj.getPathFrom(i));
        }
    }
}
