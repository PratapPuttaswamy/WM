
import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
/**
 * This program demonstrates how to establish database connection to Microsoft
 * SQL Server.
 * @author www.codejava.net
 *
 */
public class JdbcSQLServerConnection {

	public static void main(String[] args) throws ClassNotFoundException {

		java.sql.Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3307/mydb";
			String user = "root";
			String pass = "root";
			conn = DriverManager.getConnection(dbURL, user, pass);
			if (conn != null) {
				/*DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());*/
				System.out.println("good");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}