import Common.ReadStringList;
import Day4.ResponseRecord;

public class Main {

    public static void main(String[] args) {

        ReadStringList reader = new ReadStringList();
        ResponseRecord rr = new ResponseRecord();
        rr.readList(reader.readFile("inputReposeRecord.txt"));
        System.out.println(rr.getMostFrequentlyAsleepGuard());
        System.out.println(rr.getSolution());


//        long startTime = System.currentTimeMillis();
//
//        long stopTime = System.currentTimeMillis();
//        System.out.println(stopTime - startTime);
    }
}
