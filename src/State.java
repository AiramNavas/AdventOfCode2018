public class State {

    String actualState;

    public State(){
        setActualState("awake");
    }

    public String getActualState() {
        return actualState;
    }

    public void setActualState(String actualState) {
        if(actualState.equals("asleep") || actualState.equals("wakes"))
            this.actualState = actualState;
        else
            throw new IllegalArgumentException();
    }
}
