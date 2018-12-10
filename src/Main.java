import Common.ReadStringList;
import Day5.AlchemicalReduction;

public class Main {

    public static void main(String[] args) {
        ReadStringList reader = new ReadStringList();
        reader.readFile("inputAlchemicalReduction.txt");

        AlchemicalReduction ar = new AlchemicalReduction(reader.getList().get(0));

        System.out.println(ar.getSecondSolution().length());

//        long startTime = System.currentTimeMillis();
//
//        long stopTime = System.currentTimeMillis();
//        System.out.println(stopTime - startTime);
    }
}
