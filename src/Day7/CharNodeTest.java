package Day7;
import org.junit.Assert;
import org.junit.Test;

public class CharNodeTest {

    @Test
    public void CreatingNodesWhenNull(){
        CharNode cn = new CharNode();

        Assert.assertEquals(null, cn.getValue());
        Assert.assertEquals(0, cn.getNextNodes().size());
    }

    @Test
    public void CreatingNodesWhenValueD(){
        CharNode cn = new CharNode();

        cn.setValue('D');

        Assert.assertEquals(Character.valueOf('D'), cn.getValue());
    }

    @Test
    public void CopyNodesWhenValueD(){
        CharNode cn1 = new CharNode();

        cn1.setValue('D');
        CharNode cn2 = new CharNode(cn1);

        Assert.assertEquals(Character.valueOf('D'), cn2.getValue());
    }

    @Test
    public void AddingTwoNextNodes(){
        CharNode cn = new CharNode();
        CharNode ch1 = new CharNode();
        CharNode ch2 = new CharNode();

        cn.setValue('A');
        ch1.setValue('B');
        ch2.setValue('C');

        cn.addNext(ch1);
        cn.addNext(ch2);

        Assert.assertEquals(2, cn.getNextNodes().size());
        Assert.assertEquals(Character.valueOf('B'), cn.getNext(0).getValue());
        Assert.assertEquals(Character.valueOf('C'), cn.getNext(1).getValue());
        Assert.assertEquals(Character.valueOf('A'), ch1.getPrev(0).getValue());
        Assert.assertEquals(Character.valueOf('A'), ch2.getPrev(0).getValue());
    }

}