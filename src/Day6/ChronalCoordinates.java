package Day6;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class ChronalCoordinates {

    Integer[][] grid;
    Hashtable<Integer, Integer> areas;
    ArrayList<Point> points;

    public ChronalCoordinates(ArrayList<String> list) {
        setPoints(new ArrayList<>());
        for (int i = 0; i < list.size(); i++) {
            String[] point = list.get(i).replace(" ", "").split(",");
            getPoints().add(new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1])));
        }
        Integer size = getBiggest(getPoints());
        setGrid(new Integer[size][size]);
        setAreas(new Hashtable<>());
        for (int i = 0; i < getPoints().size(); i++) {
            getGrid()[getPoints().get(i).x][getPoints().get(i).y] = i;
            getAreas().put(i, 1);
        }
    }

    private Integer getBiggest(ArrayList<Point> points) {
        Integer biggest = 0;
        for (int i = 0; i < points.size(); i++){
            if(biggest < points.get(i).x)
                biggest = points.get(i).x;
            if(biggest < points.get(i).y)
                biggest = points.get(i).y;
        }
        return biggest + 1;
    }

    public void solve() {
        Double sum = new Double(0);

        Double minorDistance;
        Integer pointID = 0;
        Double check;
        Boolean equalDistances = false;
        for (int i = 0; i < getGrid().length; i++){
            for (int j = 0; j < getGrid()[i].length; j++){
                minorDistance = Double.MAX_VALUE;
                //if(getGrid()[i][j] == null) {
                    for (int k = 0; k < getPoints().size(); k++){
                        check = distanceTo(new Point(i, j), getPoints().get(k));
                        sum += check; // sum
                        if (check < minorDistance) {
                            minorDistance = check;
                            pointID = k;
                            equalDistances = false;
                        } else if (check.equals(minorDistance)) {
                            equalDistances = true;
                        }
                    }
                    if(!equalDistances && getGrid()[i][j] == null){
                        getGrid()[i][j] = pointID;
                        getAreas().put(pointID, getAreas().get(pointID) + 1);
                    }
                    else {
                        getGrid()[i][j] = -1;
                    }
                    equalDistances = false;
                //}
                // sum
                if(sum < 10000){
                    getGrid()[i][j] = -2;
                }
                sum = 0.0;
            }
        }
//        for (int i = 0; i < getGrid().length; i++){
//            for (int j = 0; j < getGrid()[i].length; j++){
//                if(getPoints().contains(new Point(i, j)))
//                    System.out.print("(" + getGrid()[i][j] + ")\t");
//                else
//                    System.out.print(getGrid()[i][j] + "\t");
//            }
//            System.out.println();
//        }
    }

    public Integer getAreaSecondPart(){
        Integer sum = 0;
        for (int i = 0; i < getGrid().length; i++){
            for (int j = 0; j < getGrid()[i].length; j++){
                if(getGrid()[i][j] == -2)
                    sum++;
            }
        }
        return sum;
    }

    private Boolean isInfinity(Integer pointID){
        for (int i = 0; i < getGrid().length; i++){
            for (int j = 0; j < getGrid()[i].length; j++){
                if(((i > 0 && i < getGrid().length - 1) && (j == 0 || j == getGrid().length - 1))
                        || (i == 0)
                        || (i == getGrid().length - 1))
                    if(pointID == getGrid()[i][j])
                        return true;
            }
        }
        return false;
    }

    private Double distanceTo(Point point, Point point1) {
        return new Double(Math.abs(point1.x - point.x) + Math.abs(point1.y - point.y));
    }

    public Integer getLargestArea() {
        Integer majorArea = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : getAreas().entrySet()) {
            if(entry.getValue() > majorArea && !isInfinity(entry.getKey())) {
                majorArea = entry.getValue();
            }
        }
        return majorArea;
    }

    public Integer[][] getGrid() {
        return grid;
    }

    public void setGrid(Integer[][] grid) {
        this.grid = grid;
    }

    public Hashtable<Integer, Integer> getAreas() {
        return areas;
    }

    public void setAreas(Hashtable<Integer, Integer> areas) {
        this.areas = areas;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
}
