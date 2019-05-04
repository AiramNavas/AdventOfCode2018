package Day7;

import java.util.ArrayList;
import java.util.Arrays;

public class SecondPartTable {
    private final ArrayList<String> head = new ArrayList<>(Arrays.asList(
            "Seconds",
            "Done"
    ));

    private ArrayList<ArrayList<String>> table;

    public Integer nWorkers;

    public SecondPartTable(){
        setTable(new ArrayList<>());
        setnWorkers(0);
    }

    public SecondPartTable(Integer nW, ArrayList<ArrayList<String>> table){
        setnWorkers(nW);
        setTable(new ArrayList<>());
        for (int i = 0; i < table.size(); i++){
            getTable().add(table.get(i));
        }
    }

    public SecondPartTable(SecondPartTable table){
        setnWorkers(table.getnWorkers());

        setTable(new ArrayList<>());
        for (int i = 0; i < table.getTable().size(); i++){
            ArrayList<String> aux = new ArrayList<>(table.getTable().get(i));
            getTable().add(aux);
        }
    }

    public String print(){
        String tableStr = "";

        tableStr += getHead().get(0) + "\t\t";

        for (int i = 0; i < getnWorkers(); i++)
            tableStr += "Worker " + (i + 1) + "\t";

        tableStr += getHead().get(1) + "\n";

        for (int i = 0; i < getTable().size(); i++) {
            for (int j = 0; j < getTable().get(i).size(); j++) {
                if(j != 3)
                    tableStr += "\t" + getTable().get(i).get(j) + "\t\t";
                else
                    tableStr += getTable().get(i).get(j);
            }
            tableStr += "\n";
        }

        return tableStr;
    }

    public ArrayList<String> getHead() {
        return head;
    }

    public ArrayList<ArrayList<String>> getTable() {
        return table;
    }

    public void setTable(ArrayList<ArrayList<String>> table) {
        this.table = table;
    }

    public Integer getnWorkers() {
        return nWorkers;
    }

    public void setnWorkers(Integer nWorkers) {
        this.nWorkers = nWorkers;
    }
}
