package Day6;

public class Grid {

    private Integer sizeX;
    private Integer sizeY;
    private Cell[][] grid;

    public Grid(Integer x, Integer y){
        setSizeX(x);
        setSizeY(y);
        setGrid(new Cell[x][y]);
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeX(Integer sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeY(Integer sizeY) {
        this.sizeY = sizeY;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }

    public void set(int i, int j, int v) {
        if(getGrid()[i][j] == null)
            getGrid()[i][j] = new Cell();
        getGrid()[i][j].setID(v);
    }

    public Cell get(int i, int j) {
        return getGrid()[i][j];
    }
}
