import java.util.ArrayList;

public class NoMatterHowYouSliceIt {

    private SquareInches square;
    private Integer counter;

    public NoMatterHowYouSliceIt(Integer size){
        setSquare(new SquareInches(size));
        setCounter(0);
    }

    public Integer getSolution(ArrayList<String> lines) {
        for (int i = 0; i < lines.size(); i++)
            getAndAddDataRectangle(lines.get(i));

        return getCounter();
    }

    public void getAndAddDataRectangle(String line){
        String[] parts = line.split(" ");
        String id = parts[0].substring(1);
        String[] position = parts[2].split(",");
        Integer i = Integer.parseInt(position[0]);
        Integer j = Integer.parseInt(position[1].substring(0, position[1].length() - 1));
        String[] sizes = parts[3].split("x");
        Integer sizeA = Integer.parseInt(sizes[0]);
        Integer sizeB = Integer.parseInt(sizes[1]);

        addRectangle(id, i, j, sizeA, sizeB);
    }

    public void addRectangle(String id, Integer i, Integer j, Integer sizeA, Integer sizeB){
        for (int k = i; k < sizeA + i; k++){
            for (int l = j; l < sizeB + j; l++){
                if (getSquare().getPosition(k, l) == null){
                    getSquare().setPosition(k, l, id);
                }
                else if (getSquare().getPosition(k, l) != "X"){
                    getSquare().setPosition(k, l, "X");
                    setCounter(getCounter() + 1);
                }
            }
        }
    }

    public SquareInches getSquare() {
        return square;
    }

    public void setSquare(SquareInches square) {
        this.square = square;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }
}
