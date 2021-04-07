import org.junit.Before;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockDB {
  private DB mockDatabase;
  private searchCustomer searchCustomer;
  private PreparedStatement preparedStatement;

  @Before
  public void setUp(){
    mockDatabase = mock(DB.class);
    searchCustomer = new searchCustomer();
  }

  @Test
  public void testUpdateCustomer() throws SQLException {
    Customer customer = new Customer("CS001", "Carol", "Bado-Cortes", "6969696", "6969", "Uk",
        "1996-06-01", "Female", "4206969696");

    when(mockDatabase.initializeDatabase()).thenReturn(true);
    when(mockDatabase.setSQLQuery("")).thenReturn(preparedStatement);
    when(mockDatabase.executePreparedStatementUpdate(preparedStatement)).thenReturn(1);

    searchCustomer.updateCustomer(customer);
  }
}