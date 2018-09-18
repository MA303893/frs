package model;

public class FlightBean {
    public static final String FLIGHTID = "flightID";
    public static final String FLIGHTNAME = "flightName";
    public static final String SEATINGCAPACITY = "seatingCapacity";
    public static final String RESERVECAPACITY = "reservationCapacity";

    private int flightID;
    private String flightName;
    private int seatingCapacity;
    private int reservationCapacity;

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public int getReservationCapacity() {
        return reservationCapacity;
    }

    public void setReservationCapacity(int reservationCapacity) {
        this.reservationCapacity = reservationCapacity;
    }
}
