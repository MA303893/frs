package dao;

import model.FlightBean;
import util.DBUtil;

import java.io.InvalidClassException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FlightDAO implements DAO {
    private PreparedStatement statement;
    private static Connection connection = DBUtil.getDBConnection();

    @Override
    public boolean create(Object o) throws InvalidClassException {
        FlightBean bean;
        raiseInvalidClassException(o);
        bean = (FlightBean) o;
        String createFlight = "INSERT INTO flights (flightName, seatingCapacity, reservationCapacity)\n" +
                "VALUES (?,?,?);";
        try {
            statement = connection.prepareStatement(createFlight);
            statement.setString(1, bean.getFlightName());
            statement.setInt(2, bean.getSeatingCapacity());
            statement.setInt(3, bean.getReservationCapacity());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int delete(ArrayList<Integer> l) {
        return 0;
    }

    @Override
    public boolean deleteById(int id) {
        String deleteFlight = "DELETE FROM flights\n" +
                "WHERE flightID = ?";
        try {
            statement = connection.prepareStatement(deleteFlight);
            statement.setInt(1, id);
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean update(Object o) throws InvalidClassException {
        FlightBean bean;
        raiseInvalidClassException(o);
        String updateFlight = String.format("UPDATE flights\n" +
                "SET %s = ?, %s = ?, %s = ?\n" +
                "WHERE %s = ?", FlightBean.FLIGHTNAME, FlightBean.SEATINGCAPACITY, FlightBean.RESERVECAPACITY, FlightBean.FLIGHTID);
        try {
            statement = connection.prepareStatement(updateFlight);
            bean = (FlightBean) o;
            statement.setString(1, bean.getFlightName());
            statement.setInt(2, bean.getSeatingCapacity());
            statement.setInt(3, bean.getReservationCapacity());
            statement.setInt(4, bean.getFlightID());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Object findByID(int id) {
        FlightBean flight = null;
        String getFlight = "SELECT * from flights where flightId = ? limit 1";
        try {
            statement = connection.prepareStatement(getFlight);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                flight = new FlightBean();
                flight.setFlightID(rs.getInt(FlightBean.FLIGHTID));
                flight.setFlightName(rs.getString(FlightBean.FLIGHTNAME));
                flight.setSeatingCapacity(rs.getInt(FlightBean.SEATINGCAPACITY));
                flight.setReservationCapacity(rs.getInt(FlightBean.RESERVECAPACITY));
            }
            return flight;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Object> findAll() {
        ArrayList<Object> flights;
        String getFlights = "SELECT * from flights";

        try {
            statement = connection.prepareStatement(getFlights);
            ResultSet rs = statement.executeQuery();
            flights = new ArrayList();
            while (rs.next()) {
                FlightBean flight = new FlightBean();
                flight.setFlightID(rs.getInt(FlightBean.FLIGHTID));
                flight.setFlightName(rs.getString(FlightBean.FLIGHTNAME));
                flight.setSeatingCapacity(rs.getInt(FlightBean.SEATINGCAPACITY));
                flight.setReservationCapacity(rs.getInt(FlightBean.RESERVECAPACITY));
                flights.add(flight);
            }
            return flights;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void raiseInvalidClassException(Object o) throws InvalidClassException {
        if (!(o instanceof FlightBean)) {
            throw new InvalidClassException("Expected 'FlightBean' class found '" + o.getClass().toString() + "'");
        }
    }
}
