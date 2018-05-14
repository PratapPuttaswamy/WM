
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
 
public class ExampleCRUD_JDBCOperations {
    
    public static void main(String[] args) throws SQLException {
 
        String url ="jdbc:mysql://localhost:3306/TestDatabase"; //update connection string
        
        String user = "root";//add your db user id here
        String password = "root";//add your db password here
        
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Successfully connected");
        
        //insert employee record into database
        Statement stmt = conn.createStatement();
        int rows = stmt.executeUpdate("insert into employee(age,name) values(23,'James') ,(33,'Shanes'),(47,'pankaj')");
        System.out.println("Rows inserted = "+ rows);
        
        PreparedStatement stmt1=conn.prepareStatement("insert into Employee values(?,?)");  
        stmt1.setString(1,"name");//1 specifies the first parameter in the query  
        stmt1.setString(2,"Ratan");
        System.out.println("Rows prepared = "+ rows);
        
        //update employee record
        rows= stmt1.executeUpdate("Update employee set age=31 where name='James'");
        System.out.println("Rows updated = "+ rows);
        
        //read employee records
        ResultSet rs = stmt1.executeQuery("Select * from employee");
        while(rs.next()){
            System.out.println("Emp Id : " + rs.getInt("id") + ", Name : " + rs.getString("name") + ", Age : " + rs.getInt("age"));
        }
        
        //delete employee record
        rows = stmt1.executeUpdate("delete from employee where name = 'James'");
        System.out.println("Rows deleted = "+ rows);
    }
    
 
}