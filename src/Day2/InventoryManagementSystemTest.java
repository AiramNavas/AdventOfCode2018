package Day2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class InventoryManagementSystemTest {

    @Test
    public void TestingInventoryManagementSystemTests(){
        InventoryManagementSystem ims = new InventoryManagementSystem();
        AppearancesIMS app = ims.getAppearancesSolution("abcdef");
        Assert.assertEquals(false, app.getTwice());
        Assert.assertEquals(false, app.getThreeTimes());

        ims = new InventoryManagementSystem();
        app = ims.getAppearancesSolution("bababc");
        Assert.assertEquals(true, app.getTwice());
        Assert.assertEquals(true, app.getThreeTimes());

        ims = new InventoryManagementSystem();
        app = ims.getAppearancesSolution("abbcde");
        Assert.assertEquals(true, app.getTwice());
        Assert.assertEquals(false, app.getThreeTimes());

        ims = new InventoryManagementSystem();
        app = ims.getAppearancesSolution("abcccd");
        Assert.assertEquals(false, app.getTwice());
        Assert.assertEquals(true, app.getThreeTimes());

        ims = new InventoryManagementSystem();
        app = ims.getAppearancesSolution("aabcdd");
        Assert.assertEquals(true, app.getTwice());
        Assert.assertEquals(false, app.getThreeTimes());

        ims = new InventoryManagementSystem();
        app = ims.getAppearancesSolution("abcdee");
        Assert.assertEquals(true, app.getTwice());
        Assert.assertEquals(false, app.getThreeTimes());

        ims = new InventoryManagementSystem();
        app = ims.getAppearancesSolution("ababab");
        Assert.assertEquals(false, app.getTwice());
        Assert.assertEquals(true, app.getThreeTimes());
    }

    @Test
    public void TestingInventoryManagementSystemTestsSolution(){
        ArrayList<String> list = new ArrayList<>(Arrays.asList("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"));
        InventoryManagementSystem ims = new InventoryManagementSystem();

        Assert.assertEquals(Integer.valueOf(12), ims.getSolution(list));
    }

    @Test
    public void TestingInventoryManagementSystemTestsSecondPart(){
        ArrayList<String> list = new ArrayList<>(Arrays.asList("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz"));
        InventoryManagementSystem ims = new InventoryManagementSystem();

        Assert.assertEquals("fgij", ims.getSolutionPartTwo(list));
    }
}