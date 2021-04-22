package utils;

public class Flight {

  String flightNumber;
  String flightName;
  String flightSource;
  String flightDeparture;
  String flightDate;
  String flightDepartureTime;
  String flightArrivalTime;
  String flightPrice;

  public Flight(
      String flightNumber,
      String flightName,
      String flightSource,
      String flightDeparture,
      String flightDate,
      String flightDepartureTime,
      String flightArrivalTime,
      String flightPrice) {
    this.flightNumber = flightNumber;
    this.flightName = flightName;
    this.flightSource = flightSource;
    this.flightDeparture = flightDeparture;
    this.flightDate = flightDate;
    this.flightDepartureTime = flightDepartureTime;
    this.flightArrivalTime = flightArrivalTime;
    this.flightPrice = flightPrice;
  }

  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getFlightName() {
    return flightName;
  }

  public void setFlightName(String flightName) {
    this.flightName = flightName;
  }

  public String getFlightSource() {
    return flightSource;
  }

  public void setFlightSource(String flightSource) {
    this.flightSource = flightSource;
  }

  public String getFlightDeparture() {
    return flightDeparture;
  }

  public void setFlightDeparture(String flightDeparture) {
    this.flightDeparture = flightDeparture;
  }

  public String getFlightDate() {
    return flightDate;
  }

  public void setFlightDate(String flightDate) {
    this.flightDate = flightDate;
  }

  public String getFlightDepartureTime() {
    return flightDepartureTime;
  }

  public void setFlightDepartureTime(String flightDepartureTime) {
    this.flightDepartureTime = flightDepartureTime;
  }

  public String getFlightArrivalTime() {
    return flightArrivalTime;
  }

  public void setFlightArrivalTime(String flightArrivalTime) {
    this.flightArrivalTime = flightArrivalTime;
  }

  public String getFlightPrice() {
    return flightPrice;
  }

  public void setFlightPrice(String flightPrice) {
    this.flightPrice = flightPrice;
  }
}