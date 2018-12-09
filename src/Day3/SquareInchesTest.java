package Day3;

import org.junit.Assert;
import org.junit.Test;

public class SquareInchesTest {

    @Test
    public void TestingSquareInches(){
        SquareInches square = new SquareInches(8);

        square.setPosition(3, 4, ".");

        Assert.assertEquals(".", square.getSquare()[3][4]);
        Assert.assertEquals(null, square.getPosition(3, 5));
    }
}