import Common.ReadStringList;
import Day7.CharGraph;

public class Main {

    public static void main(String[] args) {

// inputTSOIP.txt

        ReadStringList reader = new ReadStringList();
        CharGraph graph = new CharGraph();
        graph.generateGraph(reader.readFile("inputTSOIP.txt"));
        System.out.println(graph.getSolutionFP() + "\n" + graph.getSolutionFP().length());

//        long startTime = System.currentTimeMillis();
//
//        long stopTime = System.currentTimeMillis();
//        System.out.println(stopTime - startTime);
    }
}
