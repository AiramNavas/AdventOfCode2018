package Day6;

import java.awt.*;

public class PointM extends Point {

    public PointM(int x, int y){
        super(x, y);
    }

    public int manhattanDistanceTo(Point p){
        return Math.abs(p.x - this.x) + Math.abs(p.y - this.y);
    }
}
