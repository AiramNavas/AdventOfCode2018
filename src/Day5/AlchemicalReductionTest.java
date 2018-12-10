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
        AlchemicalReduction ar1 = new AlchemicalReduction(INPUT);
        AlchemicalReduction ar2 = new AlchemicalReduction("aA");
        AlchemicalReduction ar3 = new AlchemicalReduction("cbaAB");

        Assert.assertEquals("dabCBAcaDA", ar1.getSolution());
        Assert.assertEquals("", ar2.getSolution());
        Assert.assertEquals("c", ar3.getSolution());
    }

    @Test
    public void TestingSecondPartDay5(){
        AlchemicalReduction ar1 = new AlchemicalReduction("dabAcCaCBAcCcaDA");
        AlchemicalReduction ar2 = new AlchemicalReduction("dabAcCaCBAcCcaDA");
        AlchemicalReduction ar3 = new AlchemicalReduction("dabAcCaCBAcCcaDA");
        AlchemicalReduction ar4 = new AlchemicalReduction("dabAcCaCBAcCcaDA");

        Assert.assertEquals("dbcCCBcCcD", ar1.getNewStringWithout('a'));
        Assert.assertEquals("daAcCaCAcCcaDA", ar2.getNewStringWithout('b'));
        Assert.assertEquals("dabAaBAaDA", ar3.getNewStringWithout('c'));
        Assert.assertEquals("abAcCaCBAcCcaA", ar4.getNewStringWithout('d'));
    }

    @Test
    public void TestingGetSolutionSecondPartDay5(){
        AlchemicalReduction ar1 = new AlchemicalReduction("dabAcCaCBAcCcaDA");
        ar1 = new AlchemicalReduction(ar1.getNewStringWithout('a'));

        AlchemicalReduction ar2 = new AlchemicalReduction("dabAcCaCBAcCcaDA");
        ar2 = new AlchemicalReduction(ar2.getNewStringWithout('b'));

        AlchemicalReduction ar3 = new AlchemicalReduction("dabAcCaCBAcCcaDA");
        ar3 = new AlchemicalReduction(ar3.getNewStringWithout('c'));

        AlchemicalReduction ar4 = new AlchemicalReduction("dabAcCaCBAcCcaDA");
        ar4 = new AlchemicalReduction(ar4.getNewStringWithout('d'));

        Assert.assertEquals("dbCBcD", ar1.getSolution());
        Assert.assertEquals("daCAcaDA", ar2.getSolution());
        Assert.assertEquals("daDA", ar3.getSolution());
        Assert.assertEquals("abCBAc", ar4.getSolution());
    }

    @Test
    public void TestingFinalSolutionSecondPartDay5(){
        AlchemicalReduction ar1 = new AlchemicalReduction("dabAcCaCBAcCcaDA");

        String result = ar1.getSecondSolution();

        Assert.assertEquals("daDA", result);
        Assert.assertEquals(Integer.valueOf(4), Integer.valueOf(result.length()));
    }
}