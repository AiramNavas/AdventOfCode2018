import java.util.ArrayList;


public class NoMatterHowYouSliceIt {

    private SquareInches square;
    private Integer counter;
    private ArrayList<Claim> claims;

    public NoMatterHowYouSliceIt(Integer size){
        setSquare(new SquareInches(size));
        setCounter(0);
        setClaims(new ArrayList<>());
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
        Integer sizeX = Integer.parseInt(sizes[0]);
        Integer sizeY = Integer.parseInt(sizes[1]);

        getClaims().add(new Claim(id, i, j, sizeX, sizeY));

        addRectangle(id, i, j, sizeX, sizeY);
    }

    public void addRectangle(String id, Integer i, Integer j, Integer sizeX, Integer sizeY){
        for (int k = i; k < sizeX + i; k++){
            for (int l = j; l < sizeY + j; l++){
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

    public String getSecondPartSolution(){
        for (int i = 0; i < getClaims().size(); i++){
            if(claimIsFull(getClaims().get(i)))
                return getClaims().get(i).getID();
        }
        return "Every claims are overlap";
    }

    public Boolean claimIsFull(Claim c){
        for (int i = c.getInitialPosI(); i < c.getSizeX() + c.getInitialPosI(); i++){
            for (int j = c.getInitialPosJ(); j < c.getSizeY() + c.getInitialPosJ(); j++){
                if(getSquare().getPosition(i, j) == "X")
                    return false;
            }
        }
        return true;
    }

    public ArrayList<Claim> getClaims() {
        return claims;
    }

    public void setClaims(ArrayList<Claim> claims) {
        this.claims = claims;
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
