import Common.ReadStringList;
import Day5.AlchemicalReduction;
import Day6.ChronalCoordinates;

import java.util.Hashtable;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ReadStringList reader = new ReadStringList();
        ChronalCoordinates cc = new ChronalCoordinates(reader.readFile("inputChronalCoordinates.txt"));
        cc.solve();
        System.out.println(cc.getLargestArea());
        System.out.println(cc.getAreaSecondPart());

//        long startTime = System.currentTimeMillis();
//
//        long stopTime = System.currentTimeMillis();
//        System.out.println(stopTime - startTime);
    }
}
