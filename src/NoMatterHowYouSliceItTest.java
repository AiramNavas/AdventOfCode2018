import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class NoMatterHowYouSliceItTest {

    @Test
    public void TestingProblemExample(){
        ArrayList<String> lines = new ArrayList<>(Arrays.asList("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2"));
        NoMatterHowYouSliceIt nmhyst = new NoMatterHowYouSliceIt(8);
        Assert.assertEquals(Integer.valueOf(4), nmhyst.getSolution(lines));
    }
}