import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import javax.swing.JLabel;

class userCreationTest {

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
    void initComponents(){
      userCreation userOb;
      javax.swing.JLabel inputTest;
      String expResult;

      userOb = new userCreation();
      userOb.setVisible(true);

      inputTest = (JLabel) TestUtils.getChildNamed(userOb, "userID");

      expResult = "UO008";
      assertEquals(expResult, inputTest.getText());
    }
}