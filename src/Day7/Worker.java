package Day7;

public class Worker {
    private Character task;
    private Integer tempTask;
    private Boolean available;

    public Worker(){
        setTask('.');
        setTempTask(0);
        setAvailable(true);
    }

    public Character getTask() {
        return task;
    }

    public void setTask(Character task) {
        this.task = task;
    }

    public Integer getTempTask() {
        return tempTask;
    }

    public void setTempTask(Integer tempTask) {
        this.tempTask = tempTask;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
