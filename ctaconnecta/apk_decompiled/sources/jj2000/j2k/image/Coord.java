package jj2000.j2k.image;

/* loaded from: classes5.dex */
public class Coord {
    public int x;
    public int y;

    public Coord() {
    }

    public Coord(int i, int i2) {
        this.x = i;
        this.y = i2;
    }

    public Coord(Coord coord) {
        this.x = coord.x;
        this.y = coord.y;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
