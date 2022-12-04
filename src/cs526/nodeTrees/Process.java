package cs526.nodeTrees;

public class Process {

    private int process_id;
    private int priority;
    private int Duration;
    private int Arrival_Time;

    public Process() {
    }

    public Process(int process_id, int priority, int duration, int arrival_Time) {
        this.process_id = process_id;
        this.priority = priority;
        Duration = duration;
        Arrival_Time = arrival_Time;
    }

    public int getProcess_id() {
        return process_id;
    }

    public int getPriority() {
        return priority;
    }

    public int getDuration() {
        return Duration;
    }

    public int getArrival_Time() {
        return Arrival_Time;
    }

    public void setProcess_id(int process_id) {
        this.process_id = process_id;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public void setArrival_Time(int arrival_Time) {
        Arrival_Time = arrival_Time;
    }
    @Override
    public String toString() {
        return "Id = " + process_id +", priority = " + priority + ", duration = " + Duration +
                ", arrival time = " + Arrival_Time + " ";
    }

}

