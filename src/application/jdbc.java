package application;
import java.sql.*;

//import javafx.application.Application;
//import javafx.stage.Stage;
public class jdbc {

	public static void main(String args[]) {
		try {
			System.out.println("Inserting records");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql: //localhost:3306/javaproject","root","1234");
			Statement stmt = con.createStatement();
			String p="Goutam";
			int k=9,flag=0;
			ResultSet rs=stmt.executeQuery("select rollno from Customer where name=" + "'" + p + "'");
//			ResultSet rs1=stmt.executeQuery("select rollno from Customer where name=" + "'" + p + "'");
			System.out.println("I have reached after resukt set initialization");
			while(rs.next())
			{
				System.out.println("correct roll no:"+rs.getInt(1) + " user rollno:"+k);
				if(rs.getInt(1)==k)
				{
					System.out.println("Login!!");
					flag=1;
				}
			}
			System.out.println("I have reached after resukt set while loop");
			
			
			if(flag==0) 
				System.out.println("wrong rollno");
		}
		catch(Exception e) {
			 System.out.println("Error detected "+e);
		}
	}

}