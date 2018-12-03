import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class ReadFrequencysTest {

    @Test
    public void TestingReadFrequency(){
        ReadFrequencys reader = new ReadFrequencys();
        ArrayList<Integer> list = reader.readFrequencys("inputFrequencys.txt");
        Assert.assertEquals(Integer.valueOf(3), list.get(0));
        Assert.assertEquals(Integer.valueOf(-1), list.get(2));
    }

}