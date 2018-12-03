import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ChronalCalibrationTest {

    @Test
    public void TestingChronalCalibrationSolution(){
        ChronalCalibration chronal = new ChronalCalibration();

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 1));
        Assert.assertEquals(Integer.valueOf(3), chronal.getSolution(list));

        list = new ArrayList<>(Arrays.asList(1, 1, -2));
        Assert.assertEquals(Integer.valueOf(0), chronal.getSolution(list));

        list = new ArrayList<>(Arrays.asList(-1, -2, -3));
        Assert.assertEquals(Integer.valueOf(-6), chronal.getSolution(list));
    }

    @Test
    public void TestingChronalCalibrationSolutionTwice(){
        ChronalCalibration chronal = new ChronalCalibration();

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, -1));
        Assert.assertEquals(Integer.valueOf(0), chronal.getTwiceSolution(list, 0));

        chronal = new ChronalCalibration();
        list = new ArrayList<>(Arrays.asList(+3, +3, +4, -2, -4));
        Assert.assertEquals(Integer.valueOf(10), chronal.getTwiceSolution(list, 0));

        chronal = new ChronalCalibration();
        list = new ArrayList<>(Arrays.asList(-6, +3, +8, +5, -6));
        Assert.assertEquals(Integer.valueOf(5), chronal.getTwiceSolution(list, 0));

        chronal = new ChronalCalibration();
        list = new ArrayList<>(Arrays.asList(+7, +7, -2, -7, -4));
        Assert.assertEquals(Integer.valueOf(14), chronal.getTwiceSolution(list, 0));
    }

}