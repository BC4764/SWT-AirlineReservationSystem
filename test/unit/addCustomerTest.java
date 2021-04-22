package unit;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import main.addCustomer;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

import static org.junit.jupiter.api.Assertions.*;

class addCustomerTest {

  addCustomer ac = new addCustomer();
  Connection con;

  @Test
  void autoID() {
    JLabel inputTest;
    String expResult = null;

    ac.setVisible(true);

    inputTest = (JLabel) TestUtils.getChildNamed(ac, "custId");

    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
      Statement s = con.createStatement();
      ResultSet rs = s.executeQuery("select MAX(id) from customer");
      rs.next();
      rs.getString("MAX(id)");
      if (rs.getString("MAX(id)") == null) {
        expResult = "CS001";
      } else {
        long id = Long
            .parseLong(rs.getString("MAX(id)").substring(2, rs.getString("MAX(id)").length()));
        id++;
        expResult = "CS" + String.format("%03d", id);


      }

    } catch (ClassNotFoundException ex) {
      Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
    }

    assertEquals(expResult, inputTest.getText());
  }

  @Test
  void successCancel() {
    JButton cancelButton = (JButton) TestUtils.getChildNamed(ac, "cancel");

    assertDoesNotThrow(() -> cancelButton.doClick());
  }

  @Test
  void findImage() {
    JButton findButton = (JButton) TestUtils.getChildNamed(ac, "findPhoto");

    assertDoesNotThrow(() -> findButton.doClick());
  }

  @Test
  void addSuccessMale() {
    JButton addButton = (JButton) TestUtils.getChildNamed(ac, "add");
    JButton findButton = (JButton) TestUtils.getChildNamed(ac, "findPhoto");
    JRadioButton r1 = (JRadioButton) TestUtils.getChildNamed(ac, "maleButton");
    JTextArea address = (JTextArea) TestUtils.getChildNamed(ac, "address");
    JTextField contact = (JTextField) TestUtils.getChildNamed(ac, "contact");
    JTextField first = (JTextField) TestUtils.getChildNamed(ac,"first");
    JTextField last = (JTextField) TestUtils.getChildNamed(ac,  "last");
    JTextField nic = (JTextField) TestUtils.getChildNamed(ac, "nic");
    JTextField passport = (JTextField) TestUtils.getChildNamed(ac, "passport");
    JDateChooser dob = (JDateChooser) TestUtils.getChildNamed(ac, "dob");

    r1.doClick();
    address.setText("address");
    contact.setText("contact");
    first.setText("first");
    last.setText("last");
    nic.setText("nic");
    passport.setText("passport");

    assertDoesNotThrow(() -> addButton.doClick());

  }

  @Test
  void addSuccessFemale() {
    JButton addButton = (JButton) TestUtils.getChildNamed(ac, "add");
    JButton findButton = (JButton) TestUtils.getChildNamed(ac, "findPhoto");
    JRadioButton r2 = (JRadioButton) TestUtils.getChildNamed(ac, "femaleButton");
    JTextArea address = (JTextArea) TestUtils.getChildNamed(ac, "address");
    JTextField contact = (JTextField) TestUtils.getChildNamed(ac, "contact");
    JTextField first = (JTextField) TestUtils.getChildNamed(ac,"first");
    JTextField last = (JTextField) TestUtils.getChildNamed(ac,  "last");
    JTextField nic = (JTextField) TestUtils.getChildNamed(ac, "nic");
    JTextField passport = (JTextField) TestUtils.getChildNamed(ac, "passport");
    JDateChooser dob = (JDateChooser) TestUtils.getChildNamed(ac, "dob");

    r2.doClick();
    address.setText("address");
    contact.setText("contact");
    first.setText("first");
    last.setText("last");
    nic.setText("nic");
    passport.setText("passport");

    assertDoesNotThrow(() -> addButton.doClick());

  }

}