package Day7;

import java.io.CharArrayReader;
import java.util.ArrayList;

public class CharGraph {
    private ArrayList<Integer> possibleInitialNodes;
    private ArrayList<CharNode> nodes;
    private ArrayList<CharNode> nodesToCheck;
    private String solution;
    private SecondPartTable table;
    private ArrayList<Worker> availableWorkers;
    private Integer seconds;

    public CharGraph(){
        setNodes(new ArrayList<>());
        setNodesToCheck(new ArrayList<>());
        setPossibleInitialNodes(new ArrayList<>());
        setAvailableWorkers(new ArrayList<>());
        setTable(new SecondPartTable());
    }

    public CharGraph(CharNode n){
        setNodes(new ArrayList<>());
        getNodes().add(n);
        addNodes(n);
        setPossibleInitialNodes(new ArrayList<>());
        generatePossibleInitialNodes();
        setAvailableWorkers(new ArrayList<>());
        setTable(new SecondPartTable());
    }

    public void generateGraph(ArrayList<String> linkList){
        String[] auxLine;
        for (int i = 0; i < linkList.size(); i++){
            auxLine = linkList.get(i).split(" ");
            Integer from = createIfNotExist(auxLine[1].charAt(0));
            Integer to = createIfNotExist(auxLine[7].charAt(0));
            generateLink(from, to);
        }

        generatePossibleInitialNodes();
    }

    public void generateGraph(ArrayList<String> linkList, Integer seconds, Integer nWorkers, ArrayList<ArrayList<String>> table){
        generateGraph(linkList);
        setAvailableWorkers(new ArrayList<>());
        setSeconds(seconds);
        for (int i = 0; i < nWorkers; i++)
            getAvailableWorkers().add(new Worker());
        setTable(new SecondPartTable(nWorkers, table));
    }

    public void generatePossibleInitialNodes(){
        for (int i = 0; i < getNodes().size(); i++){
            if (getNodes().get(i).getPrevNodes().size() == 0)
                getPossibleInitialNodes().add(i);
        }
    }

    public void generateLink(Integer i, Integer j){
        getNodes().get(i).addNext(getNodes().get(j));
    }

    public Integer createIfNotExist(Character v) {
        Integer i;
        if ((i = exist(v)) == -1){
            getNodes().add(new CharNode(v));
            return getNodes().size() - 1;
        }
        else
            return i;
    }

    public Integer exist(Character v){
        for (int i = 0; i < getNodes().size(); i++){
            if (getNodes().get(i).getValue().equals(v)) {
                return i;
            }
        }
        return -1;
    }

    public void addNodes(CharNode n){
        for (int i = 0; i < n.getNextNodes().size(); i++) {
            getNodes().add(n.getNext(i));
            if(n.getNext(i).getNextNodes().size() > 0)
                addNodes(n.getNext(i));
        }
    }

    public Integer getNodeToStart(){
        Integer nodeToStart = -1;

        if(getPossibleInitialNodes().size() > 0) {
            Character charToCheck = getNodes().get(getPossibleInitialNodes().get(0)).getValue();
            nodeToStart = getPossibleInitialNodes().get(0);
            for (int i = 0; i < getPossibleInitialNodes().size(); i++) {
                if (charToCheck > getNodes().get(getPossibleInitialNodes().get(i)).getValue()) {
                    charToCheck = getNodes().get(getPossibleInitialNodes().get(i)).getValue();
                    nodeToStart = getPossibleInitialNodes().get(i);
                }
            }

            for (int i = 0; i < getPossibleInitialNodes().size(); i++)
                if(i != nodeToStart)
                    getNodesToCheck().add(getNodes().get(getPossibleInitialNodes().get(i)));
        }
        return nodeToStart;
    }

    public String getSolutionFirstPart() {
        Integer nodeToStart = getNodeToStart();
        solution = "";
        solution += getNodes().get(nodeToStart).getValue();

        for (int i = 0; i < getNodes().get(nodeToStart).getNextNodes().size(); i++)
            getNodesToCheck().add(getNodes().get(nodeToStart).getNextNodes().get(i));

        while (!getNodesToCheck().isEmpty()) {
            solution += getFirstAlphabetically(1);
        }

        return solution;
    }

    public String getSolutionSecondPart() {
        Integer nodeToStart = getNodeToStart();
        solution = "";
        //Character characterNode = getNodes().get(nodeToStart).getValue();

        getNodesToCheck().add(getNodes().get(nodeToStart));
        for (int i = 0; i < getNodes().get(nodeToStart).getNextNodes().size(); i++)
            getNodesToCheck().add(getNodes().get(nodeToStart).getNextNodes().get(i));


        ArrayList<ArrayList<String>> auxTable = new ArrayList<>();
        int i = 0;
        while(!getNodesToCheck().isEmpty()){
            workOneSecond();

            ArrayList<String> aux = new ArrayList<>();
            // Seconds
            aux.add(String.valueOf(i));

            assignTask();

            for (int j = 0; j < getAvailableWorkers().size(); j++){
                aux.add(String.valueOf(getAvailableWorkers().get(j).getTask()));
            }

            aux.add(solution);
            auxTable.add(aux);

            i++;
        }

        setTable(new SecondPartTable(getAvailableWorkers().size(), auxTable));

        return solution + " - " + getTable().getTable().get(getTable().getTable().size() - 1).get(0) + " seconds.";
    }

    public void workOneSecond(){
        for (int i = 0; i < getAvailableWorkers().size(); i++){
            if (getAvailableWorkers().get(i).getAvailable().equals(false)){
                getAvailableWorkers().get(i).setTempTask(getAvailableWorkers().get(i).getTempTask() - 1);
                if (getAvailableWorkers().get(i).getTempTask().equals(0)) {
                    getAvailableWorkers().get(i).setAvailable(true);
                    solution += getAvailableWorkers().get(i).getTask();
                    updateList(getAvailableWorkers().get(i).getTask());
                    getAvailableWorkers().get(i).setTask('.');
                }
            }
        }
    }

    public void assignTask(){
        Character c;
        while(areWorkersAvailable() && (c = getFirstAlphabetically(2)) != null) {
            for (int j = 0; j < getAvailableWorkers().size(); j++) {
                if (getAvailableWorkers().get(j).getAvailable()) {
                    getAvailableWorkers().get(j).setAvailable(false);
                    getAvailableWorkers().get(j).setTask(c);
                    setBusyNode(c);
                    getAvailableWorkers().get(j).setTempTask(Integer.valueOf(c) - (64) + getSeconds());
                    break;
                }
            }
        }
    }

    public boolean areWorkersAvailable(){
        for (int i = 0; i < getAvailableWorkers().size(); i++)
            if (getAvailableWorkers().get(i).getAvailable())
                return true;
        return false;
    }

    public void setBusyNode(Character c){
        for (int i = 0; i < getNodesToCheck().size(); i++){
            if(getNodesToCheck().get(i).getValue().equals(c)){
                getNodesToCheck().get(i).setBusy(true);
            }
        }
    }

    public Character getFirstAlphabetically(Integer mode){
        Character charToReturn = null;
        for (int i = 0; i < getNodesToCheck().size(); i++){
            if (nodeIsReady(getNodesToCheck().get(i)) && charToReturn == null && !getNodesToCheck().get(i).getBusy())
                charToReturn = getNodesToCheck().get(i).getValue();
            else if(nodeIsReady(getNodesToCheck().get(i)) && charToReturn != null && !getNodesToCheck().get(i).getBusy()){
                if (charToReturn > getNodesToCheck().get(i).getValue())
                    charToReturn = getNodesToCheck().get(i).getValue();
            }
        }

        if(charToReturn != null && mode == 1)
            updateList(charToReturn);

        return charToReturn;
    }

    public boolean nodeIsReady(CharNode n){
        for (int i = 0; i < n.getPrevNodes().size(); i++)
            if(!solution.contains(String.valueOf(n.getPrevNodes().get(i).getValue())))
                return false;
        return true;
    }

    public void updateList(Character v){
        Boolean found = false;
        int i = 0;
        while (!found && i < getNodesToCheck().size()){
            if (getNodesToCheck().get(i).getValue().equals(v)){
                for (int j = 0; j < getNodesToCheck().get(i).getNextNodes().size(); j++)
                    if(!isInNodesToCheck(getNodesToCheck().get(i).getNextNodes().get(j).getValue())
                            && !solution.contains(getNodesToCheck().get(i).getNextNodes().get(j).getValue().toString()))
                        getNodesToCheck().add(getNodesToCheck().get(i).getNextNodes().get(j));
                getNodesToCheck().remove(i);
                found = true;
            }
            i++;
        }
    }

    public Boolean isInNodesToCheck(Character v){
        for (int i = 0; i < getNodesToCheck().size(); i++){
            if (getNodesToCheck().get(i).getValue().equals(v))
                return true;
        }
        return false;
    }

    public ArrayList<CharNode> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<CharNode> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<CharNode> getNodesToCheck() {
        return nodesToCheck;
    }

    public void setNodesToCheck(ArrayList<CharNode> nodesToCheck) {
        this.nodesToCheck = nodesToCheck;
    }

    public ArrayList<Integer> getPossibleInitialNodes() {
        return possibleInitialNodes;
    }

    public void setPossibleInitialNodes(ArrayList<Integer> possibleInitialNodes) {
        this.possibleInitialNodes = possibleInitialNodes;
    }

    public SecondPartTable getTable() {
        return table;
    }

    public void setTable(SecondPartTable table) {
        this.table = table;
    }

    public ArrayList<Worker> getAvailableWorkers() {
        return availableWorkers;
    }

    public void setAvailableWorkers(ArrayList<Worker> availableWorkers) {
        this.availableWorkers = availableWorkers;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }
}
