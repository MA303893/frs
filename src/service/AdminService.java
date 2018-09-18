package service;

import dao.FlightDAO;
import model.FlightBean;

import java.io.InvalidClassException;
import java.util.ArrayList;

public class AdminService implements Administrator {
    @Override
    public boolean addFlight(FlightBean flightBean) {
        FlightDAO dao = new FlightDAO();
        try {
            return dao.create(flightBean);
        } catch (InvalidClassException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean modifyFlight(FlightBean flightBean) {
        FlightDAO dao = new FlightDAO();
        try {
            return dao.update(flightBean);
        } catch (InvalidClassException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeFlight(int id) {
        FlightDAO dao = new FlightDAO();
        return dao.deleteById(id);
    }

    @Override
    public int removeFlights(ArrayList<Integer> flightID) {
        return 0;
    }


    @Override
    public FlightBean viewByFlightId(int flightId) {
        FlightDAO dao = new FlightDAO();
        return (FlightBean) dao.findByID(flightId);
    }

    @Override
    public ArrayList<FlightBean> viewByAllFlights() {
        FlightDAO dao = new FlightDAO();
        ArrayList<FlightBean> flights = new ArrayList();
        dao.findAll().forEach(o -> {
            flights.add((FlightBean) o);
        });
        return flights;
    }
}
