import static org.junit.jupiter.api.Assertions.*;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.Test;

public class performanceTests {

  // Performance test to see if ticketReport page loads data in less than a second.
  @Test
  void perfTicketReport() {
    ticketreport tr = new ticketreport();
    long start;
    long end;
    boolean meetsGoal = false;

    start = System.nanoTime();
    tr.LoadData();
    end = System.nanoTime();

    if (end - start <= 1000000000L) {
      meetsGoal = true;
    }

    assertTrue(meetsGoal);
  }

  // Performance test to see if a ticket is booked into the database in less than 3 seconds.
  @Test
  void perfBookTicket() {
    long start;
    long end;
    boolean meetsGoal = false;

    ticket ticketOb = new ticket();
    JLabel ticketNo;
    JButton searchFlight;
    JButton searchCust;
    JButton bookTicket;
    JComboBox<String> flightDepart;
    JComboBox<String> flightSource;
    JTable flightTable;
    JTextField customerID;

    JLabel flightNo;
    JLabel flightName;
    JLabel flightDept;
    JTextField flightPrice;
    JSpinner flightSeats;

    DefaultTableModel Df;

    String[] sources = new String[]{"India", "Srilanka", "Uk", "Usa", "Canada", "China"};
    String[] departs = new String[]{"India\t", "Srilanka", "Uk", "Usa", "Canada", "China"};

    ticketOb.setVisible(true);

    customerID = (JTextField) TestUtils.getChildNamed(ticketOb, "customerID");
    searchFlight = (JButton) TestUtils.getChildNamed(ticketOb, "searchTicket");
    searchCust = (JButton) TestUtils.getChildNamed(ticketOb, "searchCust");
    bookTicket = (JButton) TestUtils.getChildNamed(ticketOb, "bookTicket");
    flightDepart = (JComboBox<String>) TestUtils.getChildNamed(ticketOb, "flightDepart");
    flightSource = (JComboBox<String>) TestUtils.getChildNamed(ticketOb, "flightSource");
    flightTable = (JTable) TestUtils.getChildNamed(ticketOb, "flightTable");
    flightNo = (JLabel) TestUtils.getChildNamed(ticketOb, "flightNo");
    flightName = (JLabel) TestUtils.getChildNamed(ticketOb, "flightName");
    flightDept = (JLabel) TestUtils.getChildNamed(ticketOb, "flightDept");
    flightPrice = (JTextField) TestUtils.getChildNamed(ticketOb, "ticketPrice");
    flightSeats = (JSpinner) TestUtils.getChildNamed(ticketOb, "ticketSeats");

    // Set customer
    customerID.setText("CS001");
    searchCust.doClick();

    // Set flight
    flightSource.setSelectedItem(sources[0]); // India
    flightDepart.setSelectedItem(departs[2]); // UK
    searchFlight.doClick();

    // Set Seats
    Df = (DefaultTableModel) flightTable.getModel();
    flightNo.setText(Df.getValueAt(0, 0).toString());
    flightName.setText(Df.getValueAt(0, 1).toString());
    flightDept.setText(Df.getValueAt(0, 5).toString());
    flightPrice.setText(Df.getValueAt(0, 7).toString());
    flightSeats.setValue(2);

    start = System.nanoTime();
    bookTicket.doClick(); // book ticket
    end = System.nanoTime();

    if (end - start <= 3000000000L) {
      meetsGoal = true;
    }

    assertTrue(meetsGoal);
  }

  // Performance test to see if a user is added to database in less than 2 seconds.
  @Test
  void perfUserCreation() {
    long start;
    long end;
    boolean meetsGoal = false;

    userCreation userOb = new userCreation();
    JTextField firstName;
    JTextField lastName;
    JTextField userName;
    JPasswordField password;
    JButton createUser;

    userOb.setVisible(true);

    firstName = (JTextField) TestUtils.getChildNamed(userOb, "firstName");
    lastName = (JTextField) TestUtils.getChildNamed(userOb, "lastName");
    userName = (JTextField) TestUtils.getChildNamed(userOb, "userName");
    password = (JPasswordField) TestUtils.getChildNamed(userOb, "passWord");
    createUser = (JButton) TestUtils.getChildNamed(userOb, "createUser");

    firstName.setText("Jose");
    lastName.setText("Rivera");
    userName.setText("Tailes");
    password.setText("1234");

    start = System.nanoTime();
    createUser.doClick();
    end = System.nanoTime();

    if (end - start <= 2000000000L) {
      meetsGoal = true;
    }

    assertTrue(meetsGoal);
  }

  // Performance test to ensure addCustomer window opens in less than a second
  @Test
  void perfClickAddCust() {
    Main main = new Main();
    JMenuItem addCust = (JMenuItem) TestUtils.getChildNamed(main, "addCust");
    long start;
    long end;
    boolean meetsGoal = false;

    start = System.nanoTime();
    addCust.doClick();
    end = System.nanoTime();

    if (end - start <= 1000000000L) {
      meetsGoal = true;
    }

    assertTrue(meetsGoal);
  }

  // Performance test to ensure searchCustomer window opens in less than a second
  @Test
  void perfClickSearchCust() {
    Main main = new Main();
    JMenuItem searchCust = (JMenuItem) TestUtils.getChildNamed(main, "search");
    long start;
    long end;
    boolean meetsGoal = false;


    start = System.nanoTime();
    searchCust.doClick();
    end = System.nanoTime();

    if (end - start <= 1000000000L) {
      meetsGoal = true;
    }

    assertTrue(meetsGoal);
  }

  // Performance test to ensure bookTicket window opens in less than a second
  @Test
  void perfClickBookTick() {
    Main main = new Main();
    JMenuItem book = (JMenuItem) TestUtils.getChildNamed(main, "book");
    long start;
    long end;
    boolean meetsGoal = false;

    start = System.nanoTime();
    book.doClick();
    end = System.nanoTime();

    if (end - start <= 1000000000L) {
      meetsGoal = true;
    }

    assertTrue(meetsGoal);
  }

  // Performance test to ensure addFlight window opens in less than a second
  @Test
  void perfClickAddFlight() {
    Main main = new Main();
    JMenuItem addFli = (JMenuItem) TestUtils.getChildNamed(main, "addFlight");
    long start;
    long end;
    boolean meetsGoal = false;

    start = System.nanoTime();
    addFli.doClick();
    end = System.nanoTime();

    if (end - start <= 1000000000L) {
      meetsGoal = true;
    }

    assertTrue(meetsGoal);
  }

  // Performance test to ensure userCreation window opens in less than a second
  @Test
  void perfClickUserCreate() {
    Main main = new Main();
    JMenuItem user = (JMenuItem) TestUtils.getChildNamed(main, "user");
    long start;
    long end;
    boolean meetsGoal = false;

    start = System.nanoTime();
    user.doClick();
    end = System.nanoTime();

    if (end - start <= 1000000000L) {
      meetsGoal = true;
    }

    assertTrue(meetsGoal);
  }

  // Performance test to ensure ticketReport window opens in less than a second
  @Test
  void perfClickReport() {
    Main main = new Main();
    JMenuItem report = (JMenuItem) TestUtils.getChildNamed(main, "report");
    long start;
    long end;
    boolean meetsGoal = false;

    start = System.nanoTime();
    report.doClick();
    end = System.nanoTime();

    if (end - start <= 1000000000L) {
      meetsGoal = true;
    }

    assertTrue(meetsGoal);
  }

  // Performance test to ensure a flight is added to database less than two seconds
  @Test
  void perfAddFlight() {
    addflight af = new addflight();
    String[] sources = new String[]{"India", "Srilanka", "Uk", "Usa", "Canada", "China"};
    String[] departs = new String[]{"India\t", "Srilanka", "Uk", "Usa", "Canada", "China"};

    JButton addButton = (JButton) TestUtils.getChildNamed(af, "add");
    JTextField flightName = (JTextField) TestUtils.getChildNamed(af,"flightName");
    JComboBox<String> locSource = (JComboBox<String>) TestUtils.getChildNamed(af,"locSource");
    JComboBox<String> locDepart = (JComboBox<String>) TestUtils.getChildNamed(af,"locDepart");
    JDateChooser flightDate = (JDateChooser) TestUtils.getChildNamed(af, "flightDate");
    JTextField departTime = (JTextField) TestUtils.getChildNamed(af, "departTime");
    JTextField arrivalTime = (JTextField) TestUtils.getChildNamed(af, "arrivalTime");
    JTextField flightCost = (JTextField) TestUtils.getChildNamed(af, "flightCost");

    flightName.setText("TestName");
    flightDate.setDate(new Date());
    locSource.setSelectedItem(sources[0]); // India
    locDepart.setSelectedItem(departs[1]); // Srilanka
    departTime.setText("8:00");
    arrivalTime.setText("10:00");
    flightCost.setText("1000");

    long start;
    long end;
    boolean meetsGoal = false;

    start = System.nanoTime();
    addButton.doClick();
    end = System.nanoTime();

    if (end - start <= 2000000000L) {
      meetsGoal = true;
    }

    assertTrue(meetsGoal);
  }

}
