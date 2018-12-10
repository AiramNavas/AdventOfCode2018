package Day5;

public class AlchemicalReduction {

    private String inputString;
    private Integer iteratorI;

    public AlchemicalReduction(String s){
        setInputString(s);
        setIteratorI(0);
    }

    public String getSolution(){
        setIteratorI(0);
        while(nextAvailable()){
            if(checkPair(getIteratorI(), getIteratorI() + 1)){
                deletePair(getIteratorI(), getIteratorI() + 1);
            }
            else {
                setIteratorI(getIteratorI() + 1);
            }
        }
        return getInputString();
    }

    public Boolean nextAvailable(){
        return getInputString().length() > getIteratorI() + 1 && getIteratorI() >= 0;
    }

    public void deletePair(int i, int j) {
        setInputString(getInputString().substring(0, i) + getInputString().substring(j + 1));
        if(i > 0)
            setIteratorI(i - 1);
        else
            setIteratorI(0);
    }

    public boolean checkPair(int i, int j) {
        return Character.toUpperCase(getInputString().charAt(i)) == Character.toUpperCase(getInputString().charAt(j))
                && Character.isUpperCase(getInputString().charAt(i)) != Character.isUpperCase(getInputString().charAt(j));
    }

    public String getNewStringWithout(char c) {
        String newString = "";
        for (int i = 0; i < getInputString().length(); i++){
            if (Character.toLowerCase(getInputString().charAt(i)) != c)
                newString += getInputString().charAt(i);
        }
        return newString;
    }

    public String getSecondSolution() {
        String result = "";
        Integer best = Integer.MAX_VALUE;
        char c = 'a';
        String inputS = getInputString();
        for (int i = 0; i < 26; i++){
            setInputString(inputS);
            setInputString(getNewStringWithout(c++));
            getSolution();

            if(getInputString().length() < best) {
                best = getInputString().length();
                result = getInputString();
            }
        }
        return result;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public Integer getIteratorI() {
        return iteratorI;
    }

    public void setIteratorI(Integer iteratorI) {
        this.iteratorI = iteratorI;
    }
}
