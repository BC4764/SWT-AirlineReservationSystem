import static org.junit.jupiter.api.Assertions.*;

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
        String expResult;

        userOb = new userCreation();
        userOb.setVisible(true);

        inputTest = (JLabel) TestUtils.getChildNamed(userOb, "userID");

        expResult = "UO009";
        assertEquals(expResult, inputTest.getText());


    }

    @Test
    void initComponents() {
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

}