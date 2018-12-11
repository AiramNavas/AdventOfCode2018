package Day6;

public class Cell {

    private Integer ID;
    private Boolean isPoint;
    private Boolean region;

    public Cell(){
        setIsPoint(false);
        setRegion(false);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setIsPoint(boolean isPoint) {
        this.isPoint = isPoint;
    }

    public int getID() {
        return ID;
    }

    public boolean isPoint() {
        return isPoint;
    }

    public Boolean getRegion() {
        return region;
    }

    public void setRegion(Boolean region) {
        this.region = region;
    }
}
