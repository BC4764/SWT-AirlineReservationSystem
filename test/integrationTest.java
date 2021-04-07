import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.Test;

public class integrationTest {


  // Stub as input is injected into methods of both classes
  // Incremental - Top - Down Approach
  // passes communication testing
  // fails input validation testing
  @Test
  void testTicketReportAndTicket() throws ClassNotFoundException {
    ticketreport ticketreportOb = new ticketreport();
    ticket ticketOb = new ticket();

    /* START BOOK TICKET */
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

    DefaultTableModel Df;

    // Predefined inputs
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
    /* END BOOK TICKET */

    //load data into ticket report
    ticketreportOb.LoadData();

    // initialize ticket report table
    JTable ticketReportTab = (JTable) TestUtils.getChildNamed(ticketreportOb, "ticketReportTab");

    // get model of table
    DefaultTableModel DfTwo = (DefaultTableModel) ticketReportTab.getModel();

    // Check if the most recently booked ticket has been successfully added
    assertEquals(ticketID, DfTwo.getValueAt(DfTwo.getRowCount() - 1, 0));
    assertEquals(flightNo.getText(), DfTwo.getValueAt(DfTwo.getRowCount() - 1, 1));
    assertEquals(customerID.getText(), DfTwo.getValueAt(DfTwo.getRowCount() - 1, 2));

    // hold row count to see if new entry is added.
    int prevRowCount = DfTwo.getRowCount();

    // Test input validation
    customerID.setText("");
    searchCust.doClick();
    bookTicket.doClick();
    ticketreportOb.LoadData();

    // Fails as ticket can be booked without a customer
    assertEquals(DfTwo.getRowCount(), prevRowCount);
  }
}
