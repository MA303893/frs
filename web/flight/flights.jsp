<%@ page import="service.AdminService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.FlightBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lulu|Flights</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
            integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/assets/js/flights.js" type="text/javascript"></script>
</head>
<body>
<div class="jumbotron">
    <h1 class="display-4">Welcome to Lulu Airlines!</h1>
    <hr class="my-4">
    <p class="lead">This is a demo flight reservation system for Lulu Airlines.</p>
</div>
<div class="container">
    <h3> Flights </h3>
    <table class="table table-striped">
        <thead class="thead-light">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Seating Capacity</th>
            <th scope="col">Reservation Capacity</th>
            <th scope="col">Options</th>
        </tr>
        </thead>
        <tbody>
        <%
            AdminService service = new AdminService();
            ArrayList<FlightBean> flights = service.viewByAllFlights();
            String alert = (String) session.getAttribute("alert");
            if (alert != null) {

        %>
        <div class="alert alert-info" role="alert" id="alertBox">
            <div>
                <%=alert%>
                <div style="float: right">
                    <a href="#" id="closeAlert"><i class="fas fa-times"></i></a>
                </div>
            </div>
        </div>
        <%
            }
            for (FlightBean flight : flights) {
                String viewLink = "/flights/view?id=" + flight.getFlightID();
        %>
        <tr>
            <th scope="row"><%=flight.getFlightID()%>
            </th>
            <td><%=flight.getFlightName()%>
            </td>
            <td><%=flight.getSeatingCapacity()%>
            </td>
            <td><%=flight.getReservationCapacity()%>
            </td>
            <td><a href='<%=viewLink%>'>View</a></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <a class="btn btn-primary" href="/flights/new">Add Flight</a>
</div>
</body>
</html>
