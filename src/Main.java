import Common.ReadStringList;
import Day7.CharGraph;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

// inputTSOIP.txt

        ReadStringList reader = new ReadStringList();
        CharGraph graph = new CharGraph();
        graph.generateGraph(reader.readFile("inputTSOIP.txt"), 60, 5, new ArrayList<>());
        System.out.println(graph.getSolutionSecondPart());

//        long startTime = System.currentTimeMillis();
//
//        long stopTime = System.currentTimeMillis();
//        System.out.println(stopTime - startTime);
    }
}
