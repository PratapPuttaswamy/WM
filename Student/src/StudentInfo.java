import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class StudentInfo {

	public static void main(String args[]){
		 
		Connection con=null;
		try{
			con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentInfo","root","root");
			
		/*Statement student= (Statement) con.createStatement();
		ResultSet r=student.executeQuery("Select * from S1");
		while(r.next())
			r.getString(1);
		con.close();*/
			if (con!=null)
		{
				Statement student= (Statement) con.createStatement();
				ResultSet r=student.executeQuery("Select Studentname,Studentage from S1");
				while(r.next())
					r.getString(1);
				/*student = r.getString("Studentname");
                student = r.getString("Studentage");
				con.close();
			*/	
			System.out.println("succesful");
		}}
		catch(Exception e)
		{
			System.out.println("eror");
		}
		
		}
	
	
}
