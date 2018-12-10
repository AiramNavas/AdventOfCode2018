package Day5;

import org.junit.Assert;
import org.junit.Test;

public class AlchemicalReductionTest {

    public String INPUT = "dabAcCaCBAcCcaDA";

    @Test
    public void TestingString(){
        AlchemicalReduction ar = new AlchemicalReduction(INPUT);

        Assert.assertEquals("dabAcCaCBAcCcaDA", ar.getInputString());
    }

    @Test
    public void TestingSimpleDeletePair(){
        AlchemicalReduction ar = new AlchemicalReduction("aA");

        ar.deletePair(0, 1);

        Assert.assertEquals("", ar.getInputString());
    }

    @Test
    public void TestingComplexDeletePair(){
        AlchemicalReduction ar = new AlchemicalReduction("cbaADa");

        ar.deletePair(2, 3);

        Assert.assertEquals("cbDa", ar.getInputString());
    }

    @Test
    public void TestingSimpleCheckPair(){
        AlchemicalReduction ar1 = new AlchemicalReduction("aA");
        AlchemicalReduction ar2 = new AlchemicalReduction("Aa");
        AlchemicalReduction ar3 = new AlchemicalReduction("aB");
        AlchemicalReduction ar4 = new AlchemicalReduction("aa");
        AlchemicalReduction ar5 = new AlchemicalReduction("AA");
        AlchemicalReduction ar6 = new AlchemicalReduction("AB");
        AlchemicalReduction ar7 = new AlchemicalReduction("bb");

        Assert.assertEquals(true, ar1.checkPair(0, 1));
        Assert.assertEquals(true, ar2.checkPair(0, 1));
        Assert.assertEquals(false, ar3.checkPair(0, 1));
        Assert.assertEquals(false, ar3.checkPair(0, 1));
        Assert.assertEquals(false, ar4.checkPair(0, 1));
        Assert.assertEquals(false, ar5.checkPair(0, 1));
        Assert.assertEquals(false, ar6.checkPair(0, 1));
        Assert.assertEquals(false, ar7.checkPair(0, 1));
    }

    @Test
    public void TestingDay5Example(){
        AlchemicalReduction ar = new AlchemicalReduction(INPUT);

        Assert.assertEquals("dabCBAcaDA", ar.getSolution());

        AlchemicalReduction ar2 = new AlchemicalReduction("aA");

        Assert.assertEquals("", ar2.getSolution());

        AlchemicalReduction ar3 = new AlchemicalReduction("cbaAB");

        Assert.assertEquals("c", ar3.getSolution());
    }
}