import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javax.swing.JLabel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class userCreationTest {
    Connection con;
    Statement statement;
    PreparedStatement pst;

    @Test
    void autoID() {
        userCreation userOb;
        javax.swing.JLabel inputTest;
        String expResult;

        userOb = new userCreation();
        userOb.setVisible(true);

        inputTest = (JLabel) TestUtils.getChildNamed(userOb, "userID");

        expResult = "UO008";
        assertEquals(expResult, inputTest.getText());


    }

    @Test
    void initComponents() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select MAX(firstname) from user");
            rs.next();
            System.out.println("Firstname: " + rs.getString("MAX(firstname)"));


        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(addflight.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}