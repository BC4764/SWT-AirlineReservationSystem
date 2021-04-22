package integration;

import main.addflight;
import main.userCreation;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class userCreationIntergration {
    @Mock
    userCreation userCreationMock;

    void userCreation() {
    }

    @Test
    public void jButton1ActionPerformed() {
        Connection con;
        PreparedStatement pst;

        userCreation testfirstname = (userCreation) Mockito.mock(userCreation.class);
        userCreation testlastname = (userCreation) Mockito.mock(userCreation.class);
        userCreation testpassword = (userCreation) Mockito.mock(userCreation.class);
        userCreation testusername = (userCreation) Mockito.mock(userCreation.class);
        userCreation testuserID = (userCreation) Mockito.mock(userCreation.class);

        testuserID.setText("UO008");
        testfirstname.setText("Jose");
        testlastname.setText("Rivera");
        testpassword.setText("Tailes");
        testusername.setText("1234");


        String firstname = testfirstname.getText();
        String lastname = testlastname.getText();
        String password = testpassword.getText();
        String username = testusername.getText();
        String id = testuserID.getText();
        System.out.println(id);
        System.out.println(firstname);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
            pst = con.prepareStatement("insert into user(id,firstname,lastname,username,password)values(?,?,?,?,?)");

            pst.setString(1, id);
            pst.setString(2, firstname);
            pst.setString(3, lastname);
            pst.setString(4, username);
            pst.setString(5, password);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "utils.User Created.........");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(addflight.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}