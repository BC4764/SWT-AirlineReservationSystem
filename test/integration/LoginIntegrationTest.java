package integration;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Login;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class LoginTestIntegration {
  @Mock
  Login LoginMock;

  LoginTestIntegration() {
  }

  /**
   *This test is used to create a mock class of the login class and testing to see
   * if the login operates as it should.
   */
  @Test
  public void jButton1ActionPerformed() {
    Connection con;
    PreparedStatement pst;

    Login testUsername = (Login)Mockito.mock(Login.class);
    Login testPassword = (Login)Mockito.mock(Login.class);
    testUsername.setText("rjumar");
    testPassword.setText("123");
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
