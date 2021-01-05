package utile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Graph {
    private int nV;
    private ArrayList<ArrayList<Edge>> adjList;
    public Graph(String fileName) throws FileNotFoundException{
        String path = "D:\\Users\\Tuddi\\Desktop\\Proiect\\Dijkstra\\src\\";
        File file = new File(path + fileName);
        Scanner scan = new Scanner(file).useLocale(Locale.US);

        nV = scan.nextInt();
        adjList = new ArrayList<>();
        for (int i = 0; i <= nV; i++) {
            adjList.add(new ArrayList<>());
        }
        int nE = scan.nextInt();
        for (int i = 0; i < nE; i++) {
            Edge e = new Edge(scan.nextInt(), scan.nextInt(), scan.nextDouble());
            adjList.get(e.getFrom()).add(e);

            // Daca graful este neorientat
            Edge ne = new Edge(e.getTo(), e.getFrom(), e.getCost());
            adjList.get(ne.getFrom()).add(ne);
        }
    }

    protected ArrayList<ArrayList<Edge>> getAdjList() {
        return adjList;
    }

    protected int getNoVertices() {
        return nV;
    }

}
