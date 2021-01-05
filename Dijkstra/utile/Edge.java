package utile;

public class Edge implements Comparable<Edge> {
    private int from, to;
    private double cost;

    public Edge(int from, int to, double cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int getTo() {
        return to;
    }

    public double getCost() {
        return cost;
    }

    public int getFrom() {
        return from;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.cost > o.cost) {
            return 1;
        } else if (this.cost == o.cost) {
            if (this.from > o.from) {
                return 1;
            } else if (this.from == o.from) {
                if (this.to >= o.to) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "(" + from + ", " + to + ", " + cost + ")";
    }
}
