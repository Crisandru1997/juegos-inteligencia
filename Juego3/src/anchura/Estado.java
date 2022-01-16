package anchura;

public class Estado{
    
    public int x, y;
    public String mov;
    public Estado pred;

    public Estado(int x, int y, String mov, Estado pred) {
        this.x = x;
        this.y = y;
        this.mov = mov;
        this.pred = pred;
    }

    @Override
    public String toString() {
        return " [ ESTADO ( x="+x+"; y="+y+"; mov="+mov+" ) ]\n";
    }
    
    @Override
    public boolean equals(Object x) {
        Estado e=(Estado)x;
        return this.x == e.x && this.y == e.y;
    }
}
