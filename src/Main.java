public class Main {

    public static void main(String[] args) {
        ReadInventoryManagementSystem reader = new ReadInventoryManagementSystem();
        InventoryManagementSystem ism = new InventoryManagementSystem();


        long startTime = System.currentTimeMillis();

        System.out.println(ism.getSolutionPartTwo(reader.readMatrixISM("inputInventoryManagementSystem.txt")));

        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime);
    }
}
