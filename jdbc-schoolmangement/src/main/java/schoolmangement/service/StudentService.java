package schoolmangement.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entity.Student;

public class StudentService {
	private static String url = "jdbc:postgresql://localhost:5432/School";
	private static String user = "postgres";
	private static String password = "123";
	private static Connection connection;
	private static Scanner sc = new Scanner(System.in);
	static {
		System.out.println("executed!!!");
		try {
			Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int save()
	{
		int res=0;
		System.out.println("enter id");
		int id=sc.nextInt();
		System.out.println("enter name");
		String name=sc.next();
		System.out.println("enter age");
		int age=sc.nextInt();
		
		String sql="INSERT into student values (?,?,?)";
		try {
			PreparedStatement pstm=connection.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setInt(3, age); 
			
			res=pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
		
		
	}
	
	public int update() {
		int res=0;
		System.out.println("enter age ");
		int age=sc.nextInt();
		int id=sc.nextInt();
		String sql="UPDATE student set age=? where id=?";
		try {
			PreparedStatement pstm =connection.prepareStatement(sql);
			pstm.setInt(1, age);
			pstm.setInt(2, id);
			res=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public List<Student> fetchall()
	{
		List<Student> list=new ArrayList<Student>();
		String sql="SELECT * from student";
		try {
			Statement stm = connection.createStatement();
			ResultSet resultSet = stm.executeQuery(sql);
			while (resultSet.next()) {
				
				list.add(new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
	public void exit() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete() 
	{
		int res=0;
		System.out.println("enter id to delete!!");
		int id=sc.nextInt();
		
		String sql="DELETE from student where id-?";
		
		try {
			PreparedStatement pstm =connection.prepareStatement(sql);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
