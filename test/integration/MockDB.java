package integration;

import main.searchCustomer;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.Customer;
import utils.DB;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockDB {

  private DB mockDatabase;
  private main.searchCustomer searchCustomer;
  private PreparedStatement preparedStatement;
/**This test creates a mock Database with predefined
 * information already in place and then tests to see
 * if it still allows a customer input to go through with the
 * wrong inputs in the wrong locations
 * */
  @Before
  public void setUp() {
    mockDatabase = mock(DB.class);
    searchCustomer = new searchCustomer();
  }

  @Test
  public void testMockCustomer() throws SQLException {
    Customer customer = new Customer("CS001", "Carol", "Bado", "3545433", "2342", "Uk",
        "1999-12-15", "Female", "3238984545");

    when(mockDatabase.initializeDatabase()).thenReturn(true);
    when(mockDatabase.setSQLQuery("")).thenReturn(preparedStatement);
    when(mockDatabase.executePreparedStatementUpdate(preparedStatement)).thenReturn(1);

    searchCustomer.MockCustomer(customer);
  }
}
