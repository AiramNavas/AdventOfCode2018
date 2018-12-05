public class Guard {

    private State state;

    public Guard(){
        setState(new State());
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
