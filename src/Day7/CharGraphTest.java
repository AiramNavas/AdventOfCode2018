package Day7;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CharGraphTest {

    public ArrayList<String> linkList = new ArrayList<>(Arrays.asList(
            "Step C must be finished before step A can begin.",
            "Step C must be finished before step F can begin.",
            "Step A must be finished before step B can begin.",
            "Step A must be finished before step D can begin.",
            "Step B must be finished before step E can begin.",
            "Step D must be finished before step E can begin.",
            "Step F must be finished before step E can begin."
    ));

    public ArrayList<String> linkList2 = new ArrayList<>(Arrays.asList(
            "Step A must be finished before step C can begin.",
            "Step B must be finished before step E can begin.",
            "Step C must be finished before step E can begin.",
            "Step C must be finished before step G can begin.",
            "Step C must be finished before step D can begin.",
            "Step E must be finished before step D can begin.",
            "Step D must be finished before step G can begin.",
            "Step D must be finished before step F can begin.",
            "Step F must be finished before step H can begin."
    ));

    public SecondPartTable spectedSolutionSecondPart = new SecondPartTable(
            2,
            new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("0", "C", ".", "")),
                new ArrayList<>(Arrays.asList("1", "C", ".", "")),
                new ArrayList<>(Arrays.asList("2", "C", ".", "")),
                new ArrayList<>(Arrays.asList("3", "A", "F", "C")),
                new ArrayList<>(Arrays.asList("4", "B", "F", "CA")),
                new ArrayList<>(Arrays.asList("5", "B", "F", "CA")),
                new ArrayList<>(Arrays.asList("6", "D", "F", "CAB")),
                new ArrayList<>(Arrays.asList("7", "D", "F", "CAB")),
                new ArrayList<>(Arrays.asList("8", "D", "F", "CAB")),
                new ArrayList<>(Arrays.asList("9", "D", ".", "CABF")),
                new ArrayList<>(Arrays.asList("10", "E", ".", "CABFD")),
                new ArrayList<>(Arrays.asList("11", "E", ".", "CABFD")),
                new ArrayList<>(Arrays.asList("12", "E", ".", "CABFD")),
                new ArrayList<>(Arrays.asList("13", "E", ".", "CABFD")),
                new ArrayList<>(Arrays.asList("14", "E", ".", "CABFD")),
                new ArrayList<>(Arrays.asList("15", ".", ".", "CABFDE"))
            ))
    );

    @Test
    public void CreatingGraphNull(){
        CharGraph g = new CharGraph();

        Assert.assertEquals(new ArrayList<>(), g.getPossibleInitialNodes());
        Assert.assertEquals(new ArrayList<>(), g.getNodes());
    }

    @Test
    public void CreatingBasicGraphFromInitialNode(){
        CharNode n1 = new CharNode('A');
        CharNode n2 = new CharNode('B');
        CharNode n3 = new CharNode('C');

        n1.addNext(n2);
        n2.addNext(n3);

        CharGraph g = new CharGraph(n1);

        Assert.assertEquals(Character.valueOf('A'), g.getNodes().get(g.getNodeToStart()).getValue());
        Assert.assertEquals(Character.valueOf('A'), g.getNodes().get(0).getValue());
        Assert.assertEquals(Character.valueOf('B'), g.getNodes().get(1).getValue());
        Assert.assertEquals(Character.valueOf('C'), g.getNodes().get(2).getValue());
    }

    @Test
    public void CreatingGraphFromStringList(){
        CharGraph g = new CharGraph();

        g.generateGraph(linkList);

        Assert.assertEquals(6, g.getNodes().size());
        Assert.assertEquals(Character.valueOf('C'), g.getNodes().get(g.getNodeToStart()).getValue());
        Assert.assertEquals(0, g.getNodes().get(g.getNodeToStart()).getPrevNodes().size());
        Assert.assertEquals(2, g.getNodes().get(g.getNodeToStart()).getNextNodes().size());
    }

    @Test
    public void GetSolutionGraphFirstPart(){
        CharGraph g = new CharGraph();

        g.generateGraph(linkList);

        Assert.assertEquals("CABDFE", g.getSolutionFirstPart());
    }

    @Test
    public void GetSolutionGraphFirstPart2(){
        CharGraph g = new CharGraph();

        g.generateGraph(linkList2);

        Assert.assertEquals("ABCEDFGH", g.getSolutionFirstPart());
    }

    /* TESTING THE SECOND PART */
    @Test
    public void TestingPrintTable(){
        CharGraph g = new CharGraph();

        g.generateGraph(linkList, 0, spectedSolutionSecondPart.getnWorkers(), spectedSolutionSecondPart.getTable());

        Assert.assertEquals(spectedSolutionSecondPart.print(), g.getTable().print());
    }

    @Test
    public void GetSolutionGraphSecondPart(){
        CharGraph g = new CharGraph();

        g.generateGraph(linkList, 0, 2, new ArrayList<>());
        System.out.println(g.getSolutionSecondPart());
        System.out.println(g.getTable().print());

        Assert.assertEquals(spectedSolutionSecondPart.print(), g.getTable().print());
    }
}