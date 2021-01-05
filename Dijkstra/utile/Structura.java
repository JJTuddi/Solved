package utile;

import java.util.Comparator;

public class Structura implements Comparable<Structura>, Comparator<Structura> {
    private int current, parent;
    private double distance;

    public Structura(int current, int parent, double distance) {
        this.current = current;
        this.parent = parent;
        this.distance = distance;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    @Override
    public int compareTo(Structura o) {
        if (this.distance > o.distance) {
            return 1;
        } else if (this.distance == o.distance) {
            if (this.parent > o.parent) {
                return 1;
            } else if(this.parent == o.parent) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    @Override
    public int compare(Structura o1, Structura o2) {
        return o1.compareTo(o2);
    }

    @Override
    public String toString() {
        return "<" + (char)('A' + parent) + ", " + distance + ">";
    }

    @Override
    public boolean equals(Object obj) {
        return this.compareTo((Structura) obj) == 0;
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(current);
    }
}
