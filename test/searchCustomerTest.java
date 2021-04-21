//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class searchCustomerTest {
  Connection con;
  PreparedStatement pst;

  searchCustomerTest() {
  }

  @Test
  void testSearchCustomer() {
    searchCustomer searchCustomer = new searchCustomer();
    searchCustomer.setVisible(true);
    JTextField customerID = (JTextField)TestUtils.getChildNamed(searchCustomer, "customerID");
    JButton searchCust = (JButton)TestUtils.getChildNamed(searchCustomer, "searchCust");
    JTextField passportID = (JTextField)TestUtils.getChildNamed(searchCustomer, "passportID");
    JLabel photoLabel = (JLabel)TestUtils.getChildNamed(searchCustomer, "photoLabel");
    searchCustomer.remove(photoLabel);
    customerID.setText("CS001");
    searchCust.doClick();
    String testResult = passportID.getText();
    String expResult = "3443";
    Assertions.assertEquals(expResult, testResult);
  }

  @Test
  void testUpdateCustomer() throws ClassNotFoundException {
    searchCustomer searchCustomer = new searchCustomer();
    String testResult = "0";
    String testString = "4751231314";
    searchCustomer.setVisible(true);
    JTextField customerID = (JTextField)TestUtils.getChildNamed(searchCustomer, "customerID");
    JButton searchCust = (JButton)TestUtils.getChildNamed(searchCustomer, "searchCust");
    JTextField passportID = (JTextField)TestUtils.getChildNamed(searchCustomer, "passportID");
    JButton updateCust = (JButton)TestUtils.getChildNamed(searchCustomer, "updateCust");
    customerID.setText("CS002");
    searchCust.doClick();
    String originalPID = passportID.getText();
    passportID.setText(testString);
    updateCust.doClick();

    try {
      Class.forName("com.mysql.jdbc.Driver");
      this.con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
      this.pst = this.con.prepareStatement("select * from customer where id = ?");
      this.pst.setString(1, customerID.getText());
      ResultSet rs = this.pst.executeQuery();
      String passport = rs.getString("passport");
      testResult = passport;
    } catch (SQLException var12) {
      Logger.getLogger(searchCustomer.class.getName()).log(Level.SEVERE, (String)null, var12);
    }

    Assertions.assertEquals(testString, testResult);
    passportID.setText(originalPID);
    updateCust.doClick();
  }
}
