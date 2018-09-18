<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%@ page import="model.FlightBean" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>Lulu|Flights</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="jumbotron">
    <h1 class="display-4">Welcome to Lulu Airlines!</h1>
    <hr class="my-4">
    <p class="lead">This is a demo flight reservation system for Lulu Airlines.</p>
</div>
<div class="container">
    <h3> Edit Flight </h3>
    <%
        FlightBean flight = (FlightBean) request.getAttribute("flight");
        String alert = (String) request.getAttribute("alert");
        if (alert != null) {
    %>
    <div class="alert alert-info" role="alert">
        <%=alert%>
    </div>
    <%
        }
        if (flight != null) {
    %>
    <form action="/flights/edit" method="post">
        <div class="form-group row">
            <label for="flightName" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <input required type="text" class="form-control" id="flightName" name="flightName" placeholder="Flight Name"
                       value='<%=flight.getFlightName()%>'>
            </div>
        </div>
        <div class="form-group row">
            <label for="seatingCapacity" class="col-sm-2 col-form-label">Seating Capacity</label>
            <div class="col-sm-10">
                <input  required type="number" class="form-control" id="seatingCapacity" name="seatingCapacity"
                       placeholder="Flight Seating Capacity"
                       value='<%=flight.getSeatingCapacity()%>'>
            </div>
        </div>
        <div class="form-group row">
            <label for="reservationCapacity" class="col-sm-2 col-form-label">Reservation Capacity</label>
            <div class="col-sm-10">
                <input required type="number" class="form-control" id="reservationCapacity" name="reservationCapacity"
                       placeholder="Flight Reservation Capacity" value='<%=flight.getReservationCapacity()%>'>
            </div>
        </div>
        <input type="hidden" name="id" value='<%=flight.getFlightID()%>'/>
        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Update</button>
            </div>
        </div>
    </form>
    <div class="btn-group" role="group">
        <a class="btn btn-secondary" href='/flights/view?id=<%=flight.getFlightID()%>'>View</a>
        <a class="btn btn-secondary" href='/flights/delete?id=<%=flight.getFlightID()%>'>Delete</a>
    </div>
    <%
        }
    %>
    <a class="btn btn-primary" href="/flight/flights.jsp">All Flights</a>
</div>

</body>
</html>
