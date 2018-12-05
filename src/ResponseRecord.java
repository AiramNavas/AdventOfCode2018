import org.joda.time.DateTime;

import java.util.*;

public class ResponseRecord {

    private Map<DateTime, String> inputs;
    private ArrayList<TableLineRR> table;
    private Hashtable<Integer, Integer> guardsSleepTime;
    private Integer iterator;

    public ResponseRecord(){
        setInputs(new TreeMap<>());
        setTable(new ArrayList<>());
        setGuardsSleepTime(new Hashtable<>());
        iterator = 0;
    }

    public void readList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++){
            AddInput(list.get(i));
        }

        iterator = 0;
        Character[] auxTableLine = new Character[60];
        Integer actualGuardID = Integer.parseInt(getInputs().entrySet().iterator().next().getValue().substring(7));
        if(!getGuardsSleepTime().containsKey(Integer.parseInt(getInputs().entrySet().iterator().next().getValue().substring(7))))
            getGuardsSleepTime().put(actualGuardID, 0);

        for (Map.Entry<DateTime, String> entry : getInputs().entrySet()) {
            if(entry.getValue().substring(0, 5).equals("Guard")){
                if(auxTableLine[0] != null) {
                    UpdateTable(60, "falls", auxTableLine);
                    getTable().add(new TableLineRR(actualGuardID, auxTableLine));
                    actualGuardID = Integer.parseInt(entry.getValue().substring(7));
                    if(!getGuardsSleepTime().containsKey(Integer.parseInt(entry.getValue().substring(7))))
                        getGuardsSleepTime().put(actualGuardID, 0);
                    auxTableLine = new Character[60];
                    iterator = 0;
                }

            }
            else{
                if(entry.getValue().substring(0, 5).equals("wakes")){
                    if(getGuardsSleepTime().containsKey(actualGuardID)) {
                        getGuardsSleepTime().put(actualGuardID, (getGuardsSleepTime().get(actualGuardID) + (entry.getKey().getMinuteOfHour() - iterator)));
                    }

                }
                UpdateTable(entry.getKey().getMinuteOfHour(), entry.getValue(), auxTableLine);
            }
        }

        UpdateTable(60, "falls", auxTableLine);
        getTable().add(new TableLineRR(actualGuardID, auxTableLine));
        iterator = 0;
    }

    public Integer getSolution() {
        Integer guardIF = getSleepyGuard();
        return guardIF * getMostCommonMinute(guardIF);
    }

    public Character getNewState(String state){
        if(state.substring(0, 5).equals("falls"))
            return '.';
        return '#';
    }

    private void UpdateTable(Integer minute, String state, Character[] auxTableLine) {
        for (int i = iterator; i < minute; i++){
            auxTableLine[i] = getNewState(state);
        }
        iterator = minute;
    }

    private void AddInput(String s) {
        s = s.replace("[", "");
        s = s.replace("]", "");
        String[] parts = s.split(" ");
        String date = parts[0] + "T" + parts[1];

        getInputs().put(new DateTime(date), parts[2] + " " + parts[3]);
    }

    public Integer getSleepyGuard() {
        Integer guard = getGuardsSleepTime().entrySet().iterator().next().getKey();
        Integer major = getGuardsSleepTime().entrySet().iterator().next().getValue();
        for (Map.Entry<Integer, Integer> entry : getGuardsSleepTime().entrySet()) {
            if(major < entry.getValue()) {
                guard = entry.getKey();
                major = entry.getValue();
            }
        }
        return guard;
    }

    public Integer getMostCommonMinute(Integer sleepyGuard) {
        Integer minuteMostCommon = 0;
        Integer auxMinuteAccumulator = 0;
        Integer minuteToCheck = 0;
        Integer accumulator = 0;
        while(minuteToCheck < 60) {
            for (int i = 0; i < getTable().size(); i++) {
                if (getTable().get(i).getID().equals(sleepyGuard)) {
                    if (getTable().get(i).getLine()[minuteToCheck].equals('#')) {
                        auxMinuteAccumulator++;
                    }
                }
            }
            if(accumulator < auxMinuteAccumulator) {
                accumulator = auxMinuteAccumulator;
                minuteMostCommon = minuteToCheck;
            }
            auxMinuteAccumulator = 0;
            minuteToCheck++;
        }

        return minuteMostCommon;
    }

    public Map<DateTime, String> getInputs() {
        return inputs;
    }

    public void setInputs(Map<DateTime, String> inputs) {
        this.inputs = inputs;
    }

    public ArrayList<TableLineRR> getTable() {
        return table;
    }

    public void setTable(ArrayList<TableLineRR> table) {
        this.table = table;
    }

    public Hashtable<Integer, Integer> getGuardsSleepTime() {
        return guardsSleepTime;
    }

    public void setGuardsSleepTime(Hashtable<Integer, Integer> guardsSleepTime) {
        this.guardsSleepTime = guardsSleepTime;
    }
}
