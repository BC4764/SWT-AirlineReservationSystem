package unit;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.addCustomer;
import main.userCreation;
import org.junit.jupiter.api.Test;

import javax.swing.JLabel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.TestUtils;

class userCreationTest {
    Connection con;
    PreparedStatement pst;

    @Test
    void autoID() {
        userCreation userOb;
        javax.swing.JLabel inputTest;
        String expResult = null;

        userOb = new userCreation();
        userOb.setVisible(true);

        inputTest = (JLabel) TestUtils.getChildNamed(userOb, "userID");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select MAX(id) from user");
            rs.next();
            rs.getString("MAX(id)");
            if (rs.getString("MAX(id)") == null) {
                expResult = "UO001";
            } else {
                long id = Long.parseLong(rs.getString("MAX(id)").substring(2, rs.getString("MAX(id)").length()));
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

            assertEquals(firstName.getText(), pulledFirstName);
            assertEquals(lastName.getText(), pulledLastName);
            assertEquals(userName.getText(), pulledUserName);
            assertEquals(password.getText(), pulledPassWord);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

    @Test
    void cancelButtonTest() {

        userCreation userOb = new userCreation();

        JButton cancel = (JButton) TestUtils.getChildNamed(userOb, "cancel");

        cancel.doClick();

    }


}