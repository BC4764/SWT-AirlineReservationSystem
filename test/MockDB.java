import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;

public class MockDB {

  private DB mockDatabase;
  private searchCustomer searchCustomer;
  private PreparedStatement preparedStatement;

  @Before
  public void setUp() {
    mockDatabase = mock(DB.class);
    searchCustomer = new searchCustomer();
  }

  @Test
  public void testUpdateCustomer() throws SQLException {
    Customer customer = new Customer("CS001", "John", "Alex", "34232222", "3443", "Uk",
        "1996-06-01", "Male", "1234567890");

    when(mockDatabase.initializeDatabase()).thenReturn(true);
    when(mockDatabase.setSQLQuery("")).thenReturn(preparedStatement);
    when(mockDatabase.executePreparedStatementUpdate(preparedStatement)).thenReturn(1);

    searchCustomer.updateCustomer(customer);
  }
}
