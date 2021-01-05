package utile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


public class Dijkstra {
    private static final int inf = 1 << 30;
    private PriorityQueue<Structura> pq;
    private ArrayList<Structura> solutie;
    private int start;

    private void initializeQueue(Graph g, int start){
        pq = new PriorityQueue<>();
        for (int i = 0; i <= g.getNoVertices(); i++) {
            pq.add(new Structura(i, -1, inf));
        }
        pq.remove(new Structura(start, -1, inf));
        pq.add(new Structura(start, -1, 0));
    }

    private void initalizareSolutie(Graph g, int start) {
        solutie = new ArrayList<>();
        for (int i = 0; i <= g.getNoVertices(); i++) {
            solutie.add(new Structura(i, -1, inf));
        }
        solutie.get(start).setParent(start);
        solutie.get(start).setDistance(0);
    }

    private void relaxare(Edge e) {
        Structura u = solutie.get(e.getTo());
        if (solutie.get(e.getTo()).getDistance() > e.getCost() + solutie.get(e.getFrom()).getDistance()) {
            pq.remove(solutie.get(e.getTo()));
            solutie.get(e.getTo()).setDistance(e.getCost() + solutie.get(e.getFrom()).getDistance());
            solutie.get(e.getTo()).setParent(e.getFrom());
            pq.add(solutie.get(e.getTo()));
        }
    }

    public Dijkstra(Graph g, int start) {
        this.start = start;
        initializeQueue(g, start);
        initalizareSolutie(g, start);

        while(!pq.isEmpty()) {
            Structura u = pq.peek();
            pq.remove();
            for (Edge e: g.getAdjList().get(u.getCurrent())) {
                relaxare(e);
            }
        }
    }

    public String getPathFrom(int vertix) {
        String result = "\t";
        System.out.println("Costul distantei este: " + solutie.get(vertix).getDistance() + ", iar drumul este: ");
        while(solutie.get(vertix).getCurrent() != start) {
            result += (char)('A' + solutie.get(vertix).getCurrent() - 1) + "-> ";
            vertix = solutie.get(vertix).getParent();
        }
        result += (char)('A' + solutie.get(vertix).getCurrent() - 1) + "\n";
        return result;
    }
}
