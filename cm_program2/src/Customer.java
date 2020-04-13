import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {

//	public static void main(String[] args) {
//		createTable();
//		createCustomer("Danny","dan@a.com","010-1111-1111","Male","abcd...");
//		ArrayList<String> list = getCustomers();
//		for(String item: list) {
//			System.out.println(item);
//		}
//		createCustomer("lily","lily@a.com","010-2222-2222","Female","First Customer");
//		list = getCustomers();
//		for(String item:list) {
//			System.out.println(item);
//		}
//	}

	public static String[][] getCustomers(){
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select name, email, phone, gender, note FROM customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("name"),
						results.getString("email"),
						results.getString("phone"),
						results.getString("gender"),
						results.getString("note"),
					});
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;	
		}
		 
	}
	
	public static void createCustomer(String name, String email, String phone, String gender, String note) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+"INSERT INTO customer"
					+"(name, email, phone, gender, note) "
					+"VALUE "
					+"('"+name+"','"+email+"','"+phone+"','"+gender+"','"+note+"')");
			//('name','email','phone','gender','note')
			insert.executeUpdate();
			System.out.println("데이터 저장 완료");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+"customer(id int NOT NULL AUTO_INCREMENT,"
					+"name varChar(255),"
					+"email varChar(255),"
					+"phone varChar(255),"
					+"gender varChar(255),"
					+"note varChar(255),"
					+"PRIMARY KEY(id))");
			create.execute();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("테이블 생성!");
		}
	}
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12332557";
			String user = "sql12332557";
			String pass ="nyaKsls3Dz";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("연결 성공!");
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
