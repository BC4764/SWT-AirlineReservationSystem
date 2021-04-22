package unit;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JMenuItem;
import main.Main;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

/**
 * @author Benjamin Cano
 */

class MainTest {

  Main main = new Main();

  @Test
  void mainTest(){
    main.main(null);
  }

  @Test
  void clickAddCust() {
    JMenuItem addCust = (JMenuItem) TestUtils.getChildNamed(main, "addCust");

    assertDoesNotThrow(() -> addCust.doClick());
  }

  @Test
  void clickSearchCust() {
    JMenuItem searchCust = (JMenuItem) TestUtils.getChildNamed(main, "search");

    assertDoesNotThrow(() -> searchCust.doClick());
  }

  @Test
  void clickBookTick() {
    JMenuItem book = (JMenuItem) TestUtils.getChildNamed(main, "book");

    assertDoesNotThrow(() -> book.doClick());
  }

  @Test
  void clickAddFlight() {
    JMenuItem addFli = (JMenuItem) TestUtils.getChildNamed(main, "addFlight");

    assertDoesNotThrow(() -> addFli.doClick());
  }

  @Test
  void clickUserCreate() {
    JMenuItem user = (JMenuItem) TestUtils.getChildNamed(main, "user");

    assertDoesNotThrow(() -> user.doClick());
  }

  @Test
  void clickReport() {
    JMenuItem report = (JMenuItem) TestUtils.getChildNamed(main, "report");

    assertDoesNotThrow(() -> report.doClick());
  }
}