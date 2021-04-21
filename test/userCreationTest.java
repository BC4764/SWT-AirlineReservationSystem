import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.jupiter.api.Test;

import javax.swing.JLabel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class userCreationTest {
    Connection con;
    Statement statement;
    ResultSet rs;

    @Test
    void autoID() {
        userCreation userOb;
        javax.swing.JLabel inputTest;
        String expResult = null;

        userOb = new userCreation();
        userOb.setVisible(true);

        inputTest = (JLabel) TestUtils.getChildNamed(userOb, "userID");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select MAX(id) from user");
            rs.next();
            rs.getString("MAX(id)");
            if(rs.getString("MAX(id)") == null)
            {
                expResult = "UO001";
            }
            else
            {
                long id = Long.parseLong(rs.getString("MAX(id)").substring(2,rs.getString("MAX(id)").length()));
                id++;
                expResult = "UO" + String.format("%03d", id);


            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertEquals(expResult, inputTest.getText());

    }

    @Test
    void initComponents() {

        String username;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
            statement = con.createStatement();
            rs = statement.executeQuery("select firstname from user");
            while (rs.next()) {
                if(rs == null) {
                    System.out.println("Firstname: " + rs.getString("firstname"));
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(userCreation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    void testUserCreation() {
        userCreation userCreation = new userCreation();
        JButton insertUser = (JButton)TestUtils.getChildNamed(userCreation, "insertUser");
        JTextField firstName = (JTextField)TestUtils.getChildNamed(userCreation, "firstName");
        JTextField lastName = (JTextField)TestUtils.getChildNamed(userCreation, "lastName");
        JTextField userName = (JTextField)TestUtils.getChildNamed(userCreation, "userName");
        JPasswordField passWord = (JPasswordField)TestUtils.getChildNamed(userCreation, "passWord");

        String validFirst = "firstname";
        String validLast = "lastname";
        String validUsername = "username";
        String validPassword = "password";

        String invalidFirst = "";
        String invalidLast = "";
        String invalidUser = "";
        String invalidPass = "";

        // Test Case 1 - Should fail

        // Test Case 2 - Should fail
        // Test Case 3 - Should fail
        // Test Case 4 - Should fail
        // Test Case 5 - Should fail


    }

}