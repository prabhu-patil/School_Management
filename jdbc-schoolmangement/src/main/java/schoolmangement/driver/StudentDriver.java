package schoolmangement.driver;

import java.util.List;
import java.util.Scanner;
import entity.Student;
import schoolmangement.service.StudentService;

public class StudentDriver {
	public static void main(String[] args) {
		StudentService service = new StudentService();
		boolean flag = true;
		System.out.println("WELCOME TO SCHOOL MANAGEMENT");
		while (flag) {
			System.out.println("WELCOME to Student Menu");
			System.out.println("Enter 1 to add student data");
			System.out.println("Enter 2 to update student data");
			System.out.println("Enter 3 to fetch student data");
			System.out.println("Enter 4 to delete student data");
			System.out.println("Enter 5 to close student Menu");

			Scanner sc = new Scanner(System.in);
			System.out.println("enter your choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				int res = service.save();
				if (res != 0) {
					System.out.println("data saved!!");
				}
				break;
			case 2:
				int res1 = service.update();
				if (res1 != 0) {
					System.out.println("data updated");
				}
				break;
			case 3:
				List<Student> list = service.fetchall();
				if (list != null) {
					for (Student student : list) {
						System.out.println(student);
					}
				}
				break;
			case 4:

				break;
			case 5:
				service.exit();
				flag = false;
				break;
			default:
				System.out.println("Invalid input try Again!!!!");
				break;
			}

		}

	}
}
