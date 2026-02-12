package BusReservationProject;
/*
 * this class is responsible for the bus information, getters, setters and methods
 */
public class Bus {
    private int Bus_No;
    private boolean isAC;
    private int capacity;
    private String from;
    private String to;

    public Bus(int Bus_No,boolean isAC,int capacity, String from, String to) {
        this.Bus_No = Bus_No;
        this.isAC = isAC;
        this.capacity = capacity;
        this.from = from;
        this.to = to;
    }

    public int getBus_No() {
        return Bus_No;
    }
    public void setBus_No(int bus_No) {
        Bus_No = bus_No;
    }

    public boolean isAC() {
        return isAC;
    }
    public void setAC(boolean AC) {
        isAC = AC;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }

    public void display(){
        System.out.println("Bus No. "+ Bus_No + " and has AC? " + isAC +
                " then it's capacity is " + capacity + " from: " + from + " to: " + to);
    }
}

