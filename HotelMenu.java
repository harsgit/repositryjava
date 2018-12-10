import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

 

public class HotelMenu {
	boolean x;
	public boolean isX() {
		return x;
	}
	public void setX(boolean x) {
		this.x = x;
	}
	public static void main(String[] args) {
		
		int choice;
		String pName;
		int pPrice;
		
		HotelMenu m=new HotelMenu();
		ValidationClass v=new ValidationClass();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Choice");
		System.out.println("1.Insert");
		System.out.println("2.Display");
		System.out.println("3.Exit");
		choice=sc.nextInt();
		
		
		try
		{
		
					Class.forName("oracle.jdbc.driver.OracleDriver");

					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.219.34.3:1521:orcl", "trg711",
							"training711");
					
					Statement st = conn.createStatement();
					switch (choice) {
					case 1:
						
						
						
					
						
						
					PreparedStatement p=conn.prepareStatement("Insert into Hotelmenu values(?,?)");
					System.out.println("Enter product name");
					pName=sc.next();
				
					
					if(v.validatePname(pName)==true)
						p.setString(1,pName);
					else
					{
						System.out.println("Enter product name only in lowercase or upper case alphabets");
						pName=sc.next();	
				do	
				{
					
					while(v.validatePname(pName)==true)
					{
						p.setString(1,pName);
					}
					System.out.println("you have given invalid product name");
					System.exit(0);
					}while(v.validatePname(pName)==true);
					}
						
					System.out.println("Enter product price");
					 pPrice=sc.nextInt();
					 v.validatePrice(pPrice);
					p.setInt(2, pPrice);
					// else
					//	{
							System.out.println("Enter product name only in lowercase or upper case alphabets");
						//pName=sc.next();
						//if(m.isX()==true)
						//	p.setInt(2,pPrice);
						//}
					
					p.executeUpdate();
					System.out.println("Product detials inserted succesfully");
					break;
					case 2:
					ResultSet rs1 = st.executeQuery("SELECT * FROM HotelMenu");
					System.out.println("+--------------+-------------------+");
					System.out.println("|ProductName\t|productPrice|");
					System.out.println("+--------------+--------------------+");
					while(rs1.next())
					{
						
					System.out.println(rs1.getString(1)+"\t\t\t\t"+rs1.getInt(2));
					
					}	
					break;
					
					case 3:
						break;
					}	
			}
	
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	
}
