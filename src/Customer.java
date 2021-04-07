import java.util.ArrayList;

public class Customer {

  private String firstName;
  private String lastName;
  private String id;
  private String nic;
  private String passport;
  private String address;
  private String dob;
  private String gender;
  private String contact;

  private ArrayList<Flight> flights;

  public Customer(
      String firstName,
      String lastName,
      String id,
      String nic,
      String passport,
      String address,
      String dob,
      String gender,
      String contact) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
    this.nic = nic;
    this.passport = passport;
    this.address = address;
    this.dob = dob;
    this.gender = gender;
    this.contact = contact;
  }

  int sumFlightCosts() {
    int sum = 0;
    for (Flight flight : flights) {
      sum += Integer.parseInt(flight.flightPrice);
    }
    return sum;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNic() {
    return nic;
  }

  public void setNic(String nic) {
    this.nic = nic;
  }

  public String getPassport() {
    return passport;
  }

  public void setPassport(String passport) {
    this.passport = passport;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public void addFlight(Flight flight) {
    flights.add(flight);
  }

  public ArrayList<Flight> getFlight() {
    return flights;
  }
}