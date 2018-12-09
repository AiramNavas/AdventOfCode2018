package Day4;

import java.util.ArrayList;

public class TableLineRR {

    private Integer ID;
    private Character[] line;

    public TableLineRR(){}

    public TableLineRR(Integer id, Character[] c){
        setID(id);
        setLine(c);
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Character[] getLine() {
        return line;
    }

    public void setLine(Character[] line) {
        this.line = line;
    }
}
