public class Main {

    public static void main(String[] args) {

        ReadNoMatterHowYouSliceIt reader = new ReadNoMatterHowYouSliceIt();
        NoMatterHowYouSliceIt nmhysi = new NoMatterHowYouSliceIt(1000);
        System.out.println(nmhysi.getSolution(reader.readNMHYST("inputNMHYST.txt")));

//        long startTime = System.currentTimeMillis();
//
//
//
//        long stopTime = System.currentTimeMillis();
//        System.out.println(stopTime - startTime);
    }
}
