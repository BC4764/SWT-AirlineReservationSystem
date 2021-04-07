import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class LoginTest {

  @Test
  void jButton1ActionPerformed() {
    Connection con;
    PreparedStatement pst;

    Login loginTest;
    JTextField testUsername;
    JPasswordField testPassword;
    String expResult;

    loginTest = new Login();

    testUsername = (JTextField) TestUtils.getChildNamed(loginTest, "txtuser");
    testPassword = (JPasswordField) TestUtils.getChildNamed(loginTest, "txtpass");
    testUsername.setText("rjumar");
    testPassword.setText("invalid");

    String username = testUsername.getText();
    String password = testPassword.getText();
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");

      pst = con.prepareStatement("select * from user where username = ? and password = ?");
      pst.setString(1, username);
      pst.setString(2, password);

      ResultSet rs;
      rs = pst.executeQuery();
      assertFalse(rs.next());
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  }