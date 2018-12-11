package Day6;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class ChronalCoordinates {

    Grid grid;
    Hashtable<Integer, Integer> areas;
    ArrayList<Point> points;

    public ChronalCoordinates(ArrayList<String> list) {
        setPoints(new ArrayList<>());
        for (int i = 0; i < list.size(); i++) {
            String[] point = list.get(i).replace(" ", "").split(",");
            getPoints().add(new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1])));
        }
        Integer size = getBiggest(getPoints());
        setGrid(new Grid(size, size));
        setAreas(new Hashtable<>());
        for (int i = 0; i < getPoints().size(); i++) {
            getGrid().set(getPoints().get(i).x, getPoints().get(i).y, i);
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
        int minorDistance;
        Integer pointID = 0;
        int check;
        Boolean equalDistances = false;
        for (int i = 0; i < getGrid().getSizeX(); i++){
            for (int j = 0; j < getGrid().getSizeY(); j++){
                minorDistance = Integer.MAX_VALUE;
                for (int k = 0; k < getPoints().size(); k++){
                    check = (new PointM(i, j)).manhattanDistanceTo(getPoints().get(k));
                    if (check < minorDistance) {
                        minorDistance = check;
                        pointID = k;
                        equalDistances = false;
                    } else if (check == minorDistance) {
                        equalDistances = true;
                    }
                }
                if(!equalDistances && getGrid().get(i, j) == null){
                    getGrid().set(i, j, pointID);
                    getAreas().put(pointID, getAreas().get(pointID) + 1);
                }
                else {
                    getGrid().set(i, j, -1);
                }
                equalDistances = false;
            }
        }
    }

    public Integer getAreaSecondPart(Integer cap){
        int check = 0;
        int sum = 0;
        for (int i = 0; i < getGrid().getSizeX(); i++){
            for (int j = 0; j < getGrid().getSizeY(); j++){
                for (int k = 0; k < getPoints().size(); k++){
                    check = (new PointM(i, j)).manhattanDistanceTo(getPoints().get(k));
                    sum += check;
                }
                if(sum < cap){
                    getGrid().get(i, j).setRegion(true);
                }
                sum = 0;
            }
        }

        Integer counter = 0;
        for (int i = 0; i < getGrid().getSizeX(); i++){
            for (int j = 0; j < getGrid().getSizeY(); j++){
                if(getGrid().get(i, j).getRegion())
                    counter++;
            }
        }
        return counter;
    }

    private Boolean isInfinity(Integer pointID){
        for (int i = 0; i < getGrid().getSizeX(); i++){
            for (int j = 0; j < getGrid().getSizeY(); j++){
                if(((i > 0 && i < getGrid().getSizeX() - 1) && (j == 0 || j == getGrid().getSizeY() - 1))
                        || (i == 0)
                        || (i == getGrid().getSizeX() - 1))
                    if(pointID == getGrid().get(i, j).getID())
                        return true;
            }
        }
        return false;
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

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
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
