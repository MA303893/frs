create table IF NOT EXISTS flights(
  flightID integer primary key AUTOINCREMENT,
  flightName varchar NOT NULL,
  seatingCapacity integer,
  seatingCapacity integer
);

INSERT INTO flights (flightName, seatingCapacity, reservationCapacity)
VALUES ('ThirdFlight', 100, 120);

select * from flights;

delete from flights;