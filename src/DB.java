import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {

  private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DB_URL = "jdbc:mysql://localhost/airline";

  private static final String USER = "root";
  private static final String PASS = "";

  Connection conn;

  public boolean initializeDatabase() {
    try {
      Class.forName(JDBC_DRIVER);

      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      return true;

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public PreparedStatement setSQLQuery(String sql) throws SQLException {
    return conn.prepareStatement(sql);
  }

  public int executePreparedStatementUpdate(PreparedStatement preparedStatement) throws SQLException {
    return preparedStatement.executeUpdate();
  }

  public void executePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
    preparedStatement.execute();
  }
}