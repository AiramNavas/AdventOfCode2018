package Day6;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ChronalCoordinatesTest {

    public ArrayList<String> points = new ArrayList<>(
            Arrays.asList(
                    "1, 1",
                    "6, 1",
                    "3, 8",
                    "4, 3",
                    "5, 5",
                    "9, 8"
            ));

    @Test
    public void TestingCells(){
        Cell cell = new Cell();

        cell.setID(2);
        cell.setIsPoint(true);

        Assert.assertEquals(2, cell.getID());
        Assert.assertEquals(true, cell.isPoint());
    }

    @Test
    public void SizeValuesGrid(){
        Grid grid = new Grid(5, 6);

        Assert.assertEquals(5, grid.getSizeX());
        Assert.assertEquals(6, grid.getSizeY());
    }

    @Test
    public void AddElementsAndCheckWhatContains(){
        Grid grid = new Grid(5, 5);

        grid.set(1, 2, 7);

        Assert.assertEquals(7, grid.get(1, 2).getID());
    }

    @Test
    public void DifferenceBetweenPoints(){
        PointM point1 = new PointM(4, 5);
        PointM point2 = new PointM(5, 6);

        Assert.assertEquals(2, point1.manhattanDistanceTo(point2));
    }

    @Test
    public void TestingGridSize(){
        ChronalCoordinates cc = new ChronalCoordinates(points);

        Assert.assertEquals(10, cc.getGrid().getSizeX());
        Assert.assertEquals(10, cc.getGrid().getSizeY());
    }

    @Test
    public void TestingExampleDay6(){
        ChronalCoordinates cc = new ChronalCoordinates(points);

        cc.solve();

        Assert.assertEquals(Integer.valueOf(17), cc.getLargestArea());
    }

    @Test
    public void TestingExampleSecondPartDay6(){
        ChronalCoordinates cc = new ChronalCoordinates(points);

        cc.solve();

        Assert.assertEquals(Integer.valueOf(16), cc.getAreaSecondPart(32));
    }
}