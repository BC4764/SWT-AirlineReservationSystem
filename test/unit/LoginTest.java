package unit;

import static org.junit.jupiter.api.Assertions.*;


import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.Login;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

class LoginTest {

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