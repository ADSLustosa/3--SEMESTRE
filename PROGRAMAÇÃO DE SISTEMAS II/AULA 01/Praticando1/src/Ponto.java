public class Ponto extends TestaPonto{

    private int x,y;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "Ponto{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public boolean equals(Object obj) {
        Object p1 = x;
        Object p2 = y;
        if (p1 == p2)
            return true;
        else
            return false;
    }

    
    public double distancia(Ponto p) {
        int dx = p.x - this.x;
        int dy = p.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
            
        }
    }

