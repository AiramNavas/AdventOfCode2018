package Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class InventoryManagementSystem {

    private String stringSolution;

    public InventoryManagementSystem(){
        setStringSolution("");
    }

    public AppearancesIMS getAppearancesSolution(String line) {
        Hashtable<Character, Integer> controller = new Hashtable<>();

        for (int i = 0; i < line.length(); i++){
            if(!controller.containsKey(line.charAt(i)))
                controller.put(line.charAt(i), 1);
            else
                controller.put(line.charAt(i), controller.get(line.charAt(i)) + 1);
        }
        return UpdateAppearances(controller);
    }

    private AppearancesIMS UpdateAppearances(Hashtable<Character, Integer> controller) {
        AppearancesIMS appController = new AppearancesIMS();
        Set<Character> keys = controller.keySet();
        for(Character key: keys){
            if(controller.get(key).equals(2))
                appController.setTwice(true);
            else if(controller.get(key).equals(3))
                appController.setThreeTimes(true);
        }
        return appController;
    }

    public Integer getSolution(ArrayList<String> list) {
        Integer twice = 0;
        Integer threeTimes = 0;
        for (int i = 0; i < list.size(); i++){
            if(getAppearancesSolution(list.get(i)).getTwice())
                twice++;
            if(getAppearancesSolution(list.get(i)).getThreeTimes())
                threeTimes++;
        }
        return twice * threeTimes;
    }

    public String getSolutionPartTwo(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                if(checkDifferences(list.get(i), list.get(j)))
                    return getStringSolution();
            }
        }
        return getStringSolution();
    }

    private boolean checkDifferences(String s1, String s2) {
        String newString = "";
        Integer counter = 0;
        for (int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)) {
                counter++;
                newString += s1.charAt(i);
            }
        }
        if(counter == s1.length() - 1){
            setStringSolution(newString);
            return true;
        }
        return false;
    }

    public String getStringSolution() {
        return stringSolution;
    }

    public void setStringSolution(String stringSolution) {
        this.stringSolution = stringSolution;
    }
}
