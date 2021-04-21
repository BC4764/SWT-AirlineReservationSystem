import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
  public void testMockCustomer() throws SQLException {
    Customer customer = new Customer("CS001", "Carol", "Bado", "3545433", "2342", "Uk",
        "1999-12-15", "Female", "3238984545");

    when(mockDatabase.initializeDatabase()).thenReturn(true);
    when(mockDatabase.setSQLQuery("")).thenReturn(preparedStatement);
    when(mockDatabase.executePreparedStatementUpdate(preparedStatement)).thenReturn(1);

    searchCustomer.MockCustomer(customer);
  }
}
