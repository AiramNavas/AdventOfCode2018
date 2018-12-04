public class Claim {

    String ID;
    Integer initialPosI;
    Integer initialPosJ;
    Integer sizeX;
    Integer sizeY;

    public Claim(){

    }

    public Claim(String id, Integer initialPosI, Integer initialPosJ, Integer sizeX, Integer sizeY){
        setID(id);
        setInitialPosI(initialPosI);
        setInitialPosJ(initialPosJ);
        setSizeX(sizeX);
        setSizeY(sizeY);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Integer getInitialPosI() {
        return initialPosI;
    }

    public void setInitialPosI(Integer initialPosI) {
        this.initialPosI = initialPosI;
    }

    public Integer getInitialPosJ() {
        return initialPosJ;
    }

    public void setInitialPosJ(Integer initialPosJ) {
        this.initialPosJ = initialPosJ;
    }

    public Integer getSizeX() {
        return sizeX;
    }

    public void setSizeX(Integer sizeX) {
        this.sizeX = sizeX;
    }

    public Integer getSizeY() {
        return sizeY;
    }

    public void setSizeY(Integer sizeY) {
        this.sizeY = sizeY;
    }
}
