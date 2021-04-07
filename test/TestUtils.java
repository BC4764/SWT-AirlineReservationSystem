import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import javax.swing.JMenu;

public class TestUtils {

  // Set counter
  static int counter;

  // Gets child component based on name
  public static Component getChildNamed(Component parent, String name) {
    // Check name
    if (name.equals(parent.getName())) { return parent; }

    // Check if it is a container
    if (parent instanceof Container) {
      Component[] children = (parent instanceof JMenu) ?
          ((JMenu)parent).getMenuComponents() :
          ((Container)parent).getComponents();

      // Loop through all components with that name and set child
      for (int i = 0; i < children.length; ++i) {
        Component child = getChildNamed(children[i], name);
        if (child != null) { return child; }
      }
    }
    return null;
  }

  // Check child component based on index
  public static Component getChildIndexed(Component parent, String name, int index) {
    counter = 0;

    // Check if component is part of the window
    if (parent instanceof Window) {
      Component[] children = ((Window)parent).getOwnedWindows();

      // Loop through and get index of that child
      for (int i = 0; i < children.length; ++i) {
        if (children[i] instanceof Window &&
          !((Window) children[i]).isActive()) {continue;}
        Component child = getChildIndexedInternal(
            children[i], name, index);
        // if there is a child return it
        if (child != null) { return child; }
        }
      }
    return null;
    }

    // Helps check child component based on internal count
  public static Component getChildIndexedInternal(Component parent, String name, int index) {
    // Use name and index to ge the internal indexed component
    if (parent.getClass().toString().endsWith(name)) {
      if (counter == index) { return parent; }
      ++counter;
    }

    // Check if it is a container
    if (parent instanceof Container) {
      Component[] children = (parent instanceof JMenu) ?
          ((JMenu)parent).getMenuComponents() :
          ((Container)parent).getComponents();

      // Loop through for child index and return child if not null
      for (int i = 0; i < children.length; ++i) {
        Component child = getChildIndexedInternal(
            children[i], name, index);
        if (child != null) { return child; }
      }
    }

    return null;
  }
}
