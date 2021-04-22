package unit;

import static org.junit.jupiter.api.Assertions.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JTextField;
import main.searchCustomer;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

class searchCustomerTest {

  Connection con;
  PreparedStatement pst;

  // Positive Testing for searching utils.Customer
  // Test currently fails due to issues related to the image on the page.
  @Test
  void testSearchCustomer () {
    searchCustomer searchCustomer = new searchCustomer();
    JTextField customerID;
    JButton searchCust;
    JLabel photoLabel;

    searchCustomer.setVisible(true);

    customerID = (JTextField) TestUtils.getChildNamed(searchCustomer, "customerID");
    searchCust = (JButton)TestUtils.getChildNamed(searchCustomer, "searchCust");
    photoLabel = (JLabel)TestUtils.getChildNamed(searchCustomer, "photoLabel");

    photoLabel.setIcon(null);

    customerID.setText("CS001"); // john Alex
    assertDoesNotThrow(() -> searchCust.doClick());
  }

  @Test
  void testSearchInvalidCustomer () {
    searchCustomer searchCustomer = new searchCustomer();
    JTextField customerID;
    JButton searchCust;
    JLabel photoLabel;

    searchCustomer.setVisible(true);

    customerID = (JTextField)TestUtils.getChildNamed(searchCustomer, "customerID");
    searchCust = (JButton)TestUtils.getChildNamed(searchCustomer, "searchCust");
    photoLabel = (JLabel)TestUtils.getChildNamed(searchCustomer, "photoLabel");

    photoLabel.setIcon(null);

    customerID.setText("Invalid"); // Invalid
    assertDoesNotThrow(() -> searchCust.doClick());
  }

  // Positive Testing for updating utils.Customer
  // Test currently fails due to issues related to the image on the page.
  @Test
  void testUpdateCustomer() throws ClassNotFoundException {
    searchCustomer searchCustomer = new searchCustomer();
    JTextField customerID;
    JButton searchCust;
    JButton updateCust;
    JTextField passportID;
    String testResult  = "0";
    String expResult;
    String testString = "4751231314";
    String originalPID;

    searchCustomer.setVisible(true);

    customerID = (JTextField)TestUtils.getChildNamed(searchCustomer, "customerID");
    searchCust = (JButton)TestUtils.getChildNamed(searchCustomer, "searchCust");
    passportID = (JTextField)TestUtils.getChildNamed(searchCustomer, "passportID");
    updateCust = (JButton)TestUtils.getChildNamed(searchCustomer, "updateCust");

    customerID.setText("CS002"); // Jim Jones - passport id: 433
    searchCust.doClick(); // Click search button

    originalPID = passportID.getText();

    // update passport text
    passportID.setText(testString);
    expResult = testString;

    updateCust.doClick(); // Click update button

    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
      pst = con.prepareStatement("select * from customer where id = ?");
      pst.setString(1, customerID.getText());
      ResultSet rs = pst.executeQuery();

      String passport = rs.getString("passport");

      testResult = passport;

    } catch (SQLException ex) {
      Logger.getLogger(searchCustomer.class.getName()).log(Level.SEVERE, null, ex);
    }

    assertEquals(expResult, testResult);

    // Return initial values after test
    passportID.setText(originalPID);
    updateCust.doClick();
  }
}
