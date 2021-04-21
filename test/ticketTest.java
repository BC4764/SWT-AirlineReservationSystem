import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.Test;

class ticketTest {

  Connection con;
  PreparedStatement pst;

  @Test
  void autoID() {
    ticket ticketOb;
    JLabel inputTest;
    String expResult = null;

    ticketOb = new ticket();
    ticketOb.setVisible(true);

    inputTest = (JLabel) TestUtils.getChildNamed(ticketOb, "ticketNo");

    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
      Statement s = con.createStatement();
      ResultSet rs = s.executeQuery("select MAX(id) from ticket");
      rs.next();
      rs.getString("MAX(id)");
      if(rs.getString("MAX(id)") == null)
      {
        expResult = "TO001";
      }
      else
      {
        long id = Long.parseLong(rs.getString("MAX(id)").substring(2,rs.getString("MAX(id)").length()));
        id++;
        expResult = "TO" + String.format("%03d", id);


      }

    } catch (ClassNotFoundException ex) {
      Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
    }

    assertEquals(expResult, inputTest.getText());
  }

  // Positive Testing for searching a flight based on source and destination
  // Decision Table Testing - if these two flights are selected, then the result should be.
  @Test
  void testFlightSearch() {
    ticket ticketOb = new ticket();
    JButton buttonToClick;
    JComboBox<String> flightDepart;
    JComboBox<String> flightSource;
    JTable flightTable;
    String testResult;
    String expResult;

    String[] sources = new String[]{"India", "Srilanka", "Uk", "Usa", "Canada", "China"};
    String[] departs = new String[]{"India\t", "Srilanka", "Uk", "Usa", "Canada", "China"};

    ticketOb.setVisible(true);

    buttonToClick = (JButton) TestUtils.getChildNamed(ticketOb, "searchTicket");
    flightDepart = (JComboBox<String>) TestUtils.getChildNamed(ticketOb, "flightDepart");
    flightSource = (JComboBox<String>) TestUtils.getChildNamed(ticketOb, "flightSource");
    flightTable = (JTable) TestUtils.getChildNamed(ticketOb, "flightTable");
    DefaultTableModel Df = (DefaultTableModel) flightTable.getModel();

    flightSource.setSelectedItem(sources[0]); // India
    flightDepart.setSelectedItem(departs[2]); // UK
    buttonToClick.doClick();

    testResult = Df.getValueAt(0, 0).toString();
    expResult = "FO001";
    assertEquals(expResult, testResult);

    flightSource.setSelectedItem(sources[0]); // India
    flightDepart.setSelectedItem(departs[5]); // China
    buttonToClick.doClick();

    testResult = Df.getValueAt(0, 0).toString();
    expResult = "FO002";
    assertEquals(expResult, testResult);

    flightSource.setSelectedItem(sources[0]); // India
    flightDepart.setSelectedItem(departs[1]); // Srilanka
    buttonToClick.doClick();

    Df = (DefaultTableModel) flightTable.getModel();
    testResult = Df.getValueAt(0, 0).toString();
    expResult = "FO003";
    assertEquals(expResult, testResult);
  }

  @Test
    // Positive Testing for booking a ticket.
  public void testTicketBook() throws ClassNotFoundException {
    ticket ticketOb = new ticket();
    JLabel ticketNo;
    JButton searchFlight;
    JButton searchCust;
    JButton bookTicket;
    JComboBox<String> flightDepart;
    JComboBox<String> flightSource;
    JTable flightTable;
    JTextField customerID;

    String ticketID;
    JLabel flightNo;
    JLabel flightName;
    JLabel flightDept;
    JTextField flightPrice;
    JSpinner flightSeats;
    String testTicketResult;
    String expResult;

    DefaultTableModel Df;

    String[] sources = new String[]{"India", "Srilanka", "Uk", "Usa", "Canada", "China"};
    String[] departs = new String[]{"India\t", "Srilanka", "Uk", "Usa", "Canada", "China"};

    ticketOb.setVisible(true);

    ticketNo = (JLabel) TestUtils.getChildNamed(ticketOb, "ticketNo");
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

    // Save ticket ID
    ticketID = ticketNo.getText();

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

    bookTicket.doClick(); // book ticket

    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
      pst = con.prepareStatement("select * from ticket where id = ?");
      pst.setString(1, ticketID);
      ResultSet rs = pst.executeQuery();
      rs.next();

      String pulledFlight = rs.getString("flightid");
      String pulledCust = rs.getString("custid");
      String pulledPrice = rs.getString("price");

      assertEquals(flightNo.getText(), pulledFlight);
      assertEquals(customerID.getText(), pulledCust);
      assertEquals(flightPrice.getText(), pulledPrice);

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  @Test
  void invalidCust() {
    ticket ticketOb = new ticket();
    JButton searchCust;
    JTextField customerID;

    customerID = (JTextField) TestUtils.getChildNamed(ticketOb, "customerID");
    searchCust = (JButton) TestUtils.getChildNamed(ticketOb, "searchCust");


    // Set customer
    customerID.setText("invalid");
    assertDoesNotThrow(() -> searchCust.doClick());
  }
}