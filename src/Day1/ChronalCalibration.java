package Day1;

import java.util.ArrayList;
import java.util.Hashtable;

public class ChronalCalibration {

    Hashtable<Integer, Integer> hashtable;

    public  ChronalCalibration(){
        setHashtable(new Hashtable<>());
        getHashtable().put(0, 1);
    }

    public Integer getSolution(ArrayList<Integer> list) {
        Integer solution = 0;
        for (int i = 0; i < list.size(); i++){
            solution += list.get(i);
        }
        return solution;
    }

    public Integer getTwiceSolution(ArrayList<Integer> list, Integer s) {
        for (int i = 0; i < list.size(); i++){
            s += list.get(i);
            if(!getHashtable().containsKey(s))
                getHashtable().put(s, 1);
            else
                return s;
        }
        return getTwiceSolution(list, s);
    }

    public Hashtable<Integer, Integer> getHashtable() {
        return hashtable;
    }

    public void setHashtable(Hashtable<Integer, Integer> hashtable) {
        this.hashtable = hashtable;
    }
}
