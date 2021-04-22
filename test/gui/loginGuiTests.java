package gui;

import java.awt.Container;
import javax.swing.JDesktopPane;
import main.Login;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.Containers;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class loginGuiTests extends AssertJSwingJUnitTestCase {
  private FrameFixture window;
  JDesktopPane pane;

  @BeforeEach
  @Override
  protected void onSetUp() {
    Login test = GuiActionRunner.execute(Login::new);
    Container container = test.getContentPane();
    pane = new JDesktopPane();
    pane.add(container);
    test.setVisible(true);

    window = new FrameFixture(Containers.frameFor(container));
    window.show();
  }

  @Test
  void checkValidLogin() {
    window.textBox("txtuser").setText("john");
    window.textBox("txtpass").setText("123");
    window.button("login").click();
    window.cleanUp();

  }

  @Test
  void checkTextLogin() {
    window.label("userLabel").requireText("UserName");
    window.label("passLabel").requireText("Password");
    window.button("login").requireText("Login");
    window.cleanUp();
  }


}
