import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JLabel;
import org.junit.jupiter.api.Test;

class ticketTest {

  @Test
  void autoID() {
    ticket ticketOb;
    javax.swing.JLabel inputTest;
    String expResult;

    ticketOb = new ticket();
    ticketOb.setVisible(true);

    inputTest = (JLabel)TestUtils.getChildNamed(ticketOb, "ticketNo");

    expResult = "TO004";
    assertEquals(expResult, inputTest.getText());
  }
}