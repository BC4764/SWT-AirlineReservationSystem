import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

import javax.swing.JLabel;
import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

class userCreationTest {
    Connection con;
    Statement statement;
    ResultSet rs;
    PreparedStatement pst;

    @Test
    void autoID() {
        userCreation userOb;
        javax.swing.JLabel inputTest;
        String expResult;

        userOb = new userCreation();
        userOb.setVisible(true);

        inputTest = (JLabel) TestUtils.getChildNamed(userOb, "userID");

        expResult = "UO009";
        assertNotEquals(expResult, inputTest.getText());

    }

    @Test
    void initComponents() {


        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
            statement = con.createStatement();
            rs = statement.executeQuery("select firstname from user");
            while (rs.next()) {
                if (rs == null) {
                    System.out.println("Firstname: " + rs.getString("firstname"));
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(userCreation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    void validUserCreation() {
        userCreation userOb = new userCreation();
        JTextField firstName;
        JTextField lastName;
        JTextField userName;
        JPasswordField password;
        JLabel userID;
        JButton createUser;
        String tempUserID;

        userOb.setVisible(true);

        firstName = (JTextField) TestUtils.getChildNamed(userOb, "firstName");
        lastName = (JTextField) TestUtils.getChildNamed(userOb, "lastName");
        userName = (JTextField) TestUtils.getChildNamed(userOb, "userName");
        password = (JPasswordField) TestUtils.getChildNamed(userOb, "passWord");
        createUser = (JButton) TestUtils.getChildNamed(userOb, "createUser");
        userID = (JLabel) TestUtils.getChildNamed(userOb, "userID");

        firstName.setText("Jose");
        lastName.setText("Rivera");
        userName.setText("Tailes");
        password.setText("1234");

        createUser.doClick();

        // Save userID
        tempUserID = userID.getText();
        System.out.println(tempUserID);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
            pst = con.prepareStatement("select * from user where id = ?");
            pst.setString(1, tempUserID);
            ResultSet rs = pst.executeQuery();
            rs.next();

            String pulledFirstName = rs.getString("firstname");
            String pulledLastName = rs.getString("lastname");
            String pulledUserName = rs.getString("username");
            String pulledPassWord = rs.getString("password");

            assertEquals(firstName.getText(),pulledFirstName);
            assertEquals(lastName.getText(),pulledLastName);
            assertEquals(userName.getText(),pulledUserName);
            assertEquals(password,pulledPassWord);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

}