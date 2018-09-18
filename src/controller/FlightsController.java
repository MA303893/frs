package controller;

import model.FlightBean;
import service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FlightsController")
public class FlightsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        AdminService service = new AdminService();
        switch (action) {
            case "/flights/edit":
                String id = request.getParameter("id");
                FlightBean flight = null;
                String alert = null;
                if (id != null) {
                    int flightId = Integer.parseInt(id);
                    flight = service.viewByFlightId(flightId);
                    if (flight != null) {
                        flight.setFlightName(request.getParameter("flightName"));
                        flight.setSeatingCapacity(Integer.parseInt(request.getParameter("seatingCapacity")));
                        flight.setReservationCapacity(Integer.parseInt(request.getParameter("reservationCapacity")));
                        if (service.modifyFlight(flight)) {
                            alert = "Flight Updated successfully!";
                        } else {
                            alert = "Flight not updated!";
                        }
                    } else {
                        alert = "Flight not found!";
                    }
                }
                request.setAttribute("flight", flight);
                request.setAttribute("alert", alert);
                request.getRequestDispatcher("/editFlight.jsp").forward(request, response);
                break;
            case "/flights/new":
                flight = new FlightBean();
                try {
                    flight.setFlightName(request.getParameter("flightName"));
                    flight.setSeatingCapacity(Integer.parseInt(request.getParameter("seatingCapacity")));
                    flight.setReservationCapacity(Integer.parseInt(request.getParameter("reservationCapacity")));
                } catch (Exception e) {
                    e.printStackTrace();
                    alert = "Error while creating the flight! All fields are required! Seating/Reservation Capacity can only be numeric!";
                    request.setAttribute("alert", alert);
                    request.getRequestDispatcher("/newFlight.jsp").forward(request, response);
                }
                if (service.addFlight(flight)) {
                    alert = "Flight created successfully!";

                } else {
                    alert = "Flight not created!";
                }
                request.setAttribute("alert", alert);
                request.getRequestDispatcher("/flight/flights.jsp").forward(request, response);
                break;
            default:
                response.sendRedirect("/flight/flights.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        AdminService service = new AdminService();
        String alert = null;
        switch (action) {
            case "/flights/view":
                String id = request.getParameter("id");
                FlightBean flight = null;
                if (id != null) {
                    int flightId = Integer.parseInt(id);
                    flight = service.viewByFlightId(flightId);
                }
                if (flight == null) {
                    alert = "Flight  not found!";
                }
                request.setAttribute("flight", flight);
                request.setAttribute("alert", alert);
                request.getRequestDispatcher("/flight/viewFlight.jsp").forward(request, response);
                break;
            case "/flights/edit":
                id = request.getParameter("id");
                flight = null;
                if (id != null) {
                    int flightId = Integer.parseInt(id);
                    flight = service.viewByFlightId(flightId);
                }
                if (flight == null) {
                    alert = "Flight not found!";
                }
                request.setAttribute("flight", flight);
                request.setAttribute("alert", alert);
                request.getRequestDispatcher("/flight/editFlight.jsp").forward(request, response);
                break;
            case "/flights/delete":
                id = request.getParameter("id");
                flight = null;
                Integer flightId = null;
                if (id != null) {
                    flightId = Integer.parseInt(id);
                    flight = service.viewByFlightId(flightId);
                }
                if (flight == null) {
                    alert = "Flight not found!";
                } else if (flightId != null && service.removeFlight(flightId)) {
                    alert = "Flight deleted successfully!";
                }
                request.getSession().setAttribute("alert", alert);
                response.sendRedirect("/flight/flights.jsp");
                break;
            case "/flights/new":
                request.getRequestDispatcher("/flight/newFlight.jsp").forward(request, response);
                break;
            default:
                response.sendRedirect("/flight/flights.jsp");
        }
    }
}
