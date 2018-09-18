package service;

import model.FlightBean;

import java.util.ArrayList;

public interface Administrator {
    boolean addFlight(FlightBean flightBean);

    boolean modifyFlight(FlightBean flightBean);

    boolean removeFlight(int id);

    int removeFlights(ArrayList<Integer> flightID);

    FlightBean viewByFlightId(int flightId);

    ArrayList<FlightBean> viewByAllFlights();
}
