package gui;

import main.Main;

import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class mainGuiTests extends AssertJSwingJUnitTestCase {
  private FrameFixture window;

  @BeforeEach
  @Override
  protected void onSetUp() {
    Main main = new Main();
    window = new FrameFixture(main);
    window.show();
  }

  @Test
  void customerTab() {
    window.menuItem("custTab").click().requireVisible();
    window.cleanUp();
  }

  @Test
  void addCustomerOpenSuccess() {
    window.menuItem("custTab").click().requireVisible();
    window.menuItem("addCust").click().requireVisible();
    window.cleanUp();
  }

  @Test
  void searchCustomerOpenSuccess() {
    window.menuItem("custTab").click().requireVisible();
    window.menuItem("search").click().requireVisible();
    window.cleanUp();
  }

  @Test
  void ticketTab() {
    window.menuItem("ticketTab").click().requireVisible();
    window.cleanUp();
  }

  @Test
  void bookTicketOpenSuccess() {
    window.menuItem("ticketTab").click().requireVisible();
    window.menuItem("book").click().requireVisible();
    window.cleanUp();
  }
  @Test
  void ticketReportOpenSuccess() {
    window.menuItem("ticketTab").click().requireVisible();
    window.menuItem("report").click().requireVisible();
    window.cleanUp();
  }

  @Test
  void flightTab() {
    window.menuItem("flightTab").click().requireVisible();
    window.cleanUp();
  }

  @Test
  void addFlightOpenSuccess() {
    window.menuItem("flightTab").click().requireVisible();
    window.menuItem("addFlight").click().requireVisible();
    window.cleanUp();
  }

  @Test
  void userTab() {
    window.menuItem("userTab").click().requireVisible();
    window.cleanUp();
  }

  @Test
  void userCreationOpenSuccess() {
    window.menuItem("userTab").click().requireVisible();
    window.menuItem("user").click().requireVisible();
    window.cleanUp();
  }


}
