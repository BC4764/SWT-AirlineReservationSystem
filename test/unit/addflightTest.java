package unit;

import static org.junit.jupiter.api.Assertions.*;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import main.addCustomer;
import main.addflight;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

class addflightTest {

  Connection con;
  addflight af = new addflight();

  @Test
  void autoID() {
    JLabel inputTest;
    String expResult = null;

    af.setVisible(true);

    inputTest = (JLabel) TestUtils.getChildNamed(af, "flightId");

    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
      Statement s = con.createStatement();
      ResultSet rs = s.executeQuery("select MAX(id) from flight");
      rs.next();
      rs.getString("MAX(id)");
      if (rs.getString("MAX(id)") == null) {
        expResult = "FO001";
      } else {
        long id = Long
            .parseLong(rs.getString("MAX(id)").substring(2, rs.getString("MAX(id)").length()));
        id++;
        expResult = "FO" + String.format("%03d", id);


      }

    } catch (ClassNotFoundException ex) {
      Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
    }

    assertEquals(expResult, inputTest.getText());
  }

  @Test
  void successAdd() {
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

    assertDoesNotThrow(() -> addButton.doClick());
  }

  @Test
  void successCancel() {
    JButton cancelButton = (JButton) TestUtils.getChildNamed(af, "cancel");

    assertDoesNotThrow(() -> cancelButton.doClick());
  }
}
