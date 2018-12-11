package Day6;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

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
    public void TestingGridSize(){
        ChronalCoordinates cc = new ChronalCoordinates(points);

        Assert.assertEquals(10, cc.getGrid().length);
        Assert.assertEquals(10, cc.getGrid()[0].length);
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

        Assert.assertEquals(Integer.valueOf(16), cc.getAreaSecondPart());
    }
}