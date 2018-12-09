package Day2;

public class AppearancesIMS {

    private Boolean twice;
    private Boolean threeTimes;

    public AppearancesIMS(){
        setTwice(false);
        setThreeTimes(false);
    }

    public Boolean getTwice() {
        return twice;
    }

    public void setTwice(Boolean twice) {
        this.twice = twice;
    }

    public Boolean getThreeTimes() {
        return threeTimes;
    }

    public void setThreeTimes(Boolean threeTimes) {
        this.threeTimes = threeTimes;
    }
}
