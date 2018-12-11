import Common.ReadStringList;
import Day6.ChronalCoordinates;

public class Main {

    public static void main(String[] args) {

        ReadStringList reader = new ReadStringList();
        ChronalCoordinates cc = new ChronalCoordinates(reader.readFile("inputChronalCoordinates.txt"));
        cc.solve();
        System.out.println(cc.getLargestArea());
        System.out.println(cc.getAreaSecondPart(10000));

//        long startTime = System.currentTimeMillis();
//
//        long stopTime = System.currentTimeMillis();
//        System.out.println(stopTime - startTime);
    }
}
