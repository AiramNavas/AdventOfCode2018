package Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadStringList {

    private ArrayList<String> list;

    public ReadStringList(){
        setList(new ArrayList<>());
    }

    public ArrayList<String> readFile(String fileName){
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            file = new File(fileName);
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String line;
            while((line=br.readLine())!=null) {
                getList().add(line);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }

        return getList();
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }
}
