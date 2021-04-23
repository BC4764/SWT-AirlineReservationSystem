package unit;

import static org.junit.jupiter.api.Assertions.*;


import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.Login;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

class LoginTest {
/**test used to test when an invalid input is entered the login screen*/
  @Test
  void invalidLogin() {
    Login loginTest;
    JTextField testUsername;
    JPasswordField testPassword;
    JButton loginButton;

    loginTest = new Login();

    testUsername = (JTextField) TestUtils.getChildNamed(loginTest, "txtuser");
    testPassword = (JPasswordField) TestUtils.getChildNamed(loginTest, "txtpass");
    loginButton = (JButton) TestUtils.getChildNamed(loginTest, "login");

    testUsername.setText("rjumar");
    testPassword.setText("invalid");

    assertDoesNotThrow(() -> loginButton.doClick());
  }
/**test used when the login is left blank*/
  @Test
  void blankLogin() {
    Login loginTest;
    JTextField testUsername;
    JPasswordField testPassword;
    JButton loginButton;

    loginTest = new Login();

    testUsername = (JTextField) TestUtils.getChildNamed(loginTest, "txtuser");
    testPassword = (JPasswordField) TestUtils.getChildNamed(loginTest, "txtpass");
    loginButton = (JButton) TestUtils.getChildNamed(loginTest, "login");

    testUsername.setText("john");

    assertDoesNotThrow(() -> loginButton.doClick());
  }
/**test used for login with the correct inputs*/
  @Test
  void validLogin() {
    Login loginTest;
    JTextField testUsername;
    JPasswordField testPassword;
    JButton loginButton;

    loginTest = new Login();

    testUsername = (JTextField) TestUtils.getChildNamed(loginTest, "txtuser");
    testPassword = (JPasswordField) TestUtils.getChildNamed(loginTest, "txtpass");
    loginButton = (JButton) TestUtils.getChildNamed(loginTest, "login");

    testUsername.setText("john");
    testPassword.setText("123");

    assertDoesNotThrow(() -> loginButton.doClick());
  }
}