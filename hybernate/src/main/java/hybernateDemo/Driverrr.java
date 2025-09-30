package hybernateDemo;

import java.util.Scanner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driverrr {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("girish");
	private static EntityManager manager = factory.createEntityManager();
	private static EntityTransaction transaction = manager.getTransaction();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean exit = false;

		while (!exit) {
			System.out.println("\n===== MENU =====");
			System.out.println("1. Insert Data");
			System.out.println("2. Fetch Data");
			System.out.println("3. Update Data");
			System.out.println("4. Delete Data");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				insertData();
				break;

			case 2:
				fetchData();
				break;

			case 3:
				updateData();
				break;

			case 4:
				deleteData();
				break;

			case 5:
				exit = true;
				break;

			default:
				System.out.println("Invalid choice! Try again.");
			}
		}
 
		manager.close();
		factory.close();
		sc.close();
		System.out.println("Application Closed.");
	}

	// CREATE
	public static void insertData() {
		System.out.println("Insert (1) Student or (2) Teacher?");
		int type = sc.nextInt();

		if (type == 1) {
			System.out.print("Enter Student ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Student Name: ");
			String name = sc.nextLine();
			System.out.print("Enter Student Age: ");
			int age = sc.nextInt();
			System.out.print("Enter Student Marks: ");
			int marks = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Student City: ");
			String city = sc.nextLine();

			Student student = new Student();
			student.setId(id);
			student.setName(name);
			student.setAge(age);
			student.setMarks(marks);
			student.setCity(city);

			transaction.begin();
			manager.persist(student);
			transaction.commit();
			System.out.println("✅ Student inserted successfully!");

		} else if (type == 2) {
			System.out.print("Enter Teacher ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Teacher Name: ");
			String name = sc.nextLine();
			System.out.print("Enter Teacher Age: ");
			int age = sc.nextInt();
			System.out.print("Enter Teacher Marks: ");
			int marks = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Teacher City: ");
			String city = sc.nextLine();

			Teacher teacher = new Teacher();
			teacher.setId(id);
			teacher.setName(name);
			teacher.setAge(age);
			teacher.setMarks(marks);
			teacher.setCity(city);

			transaction.begin();
			manager.persist(teacher);
			transaction.commit();
			System.out.println("✅ Teacher inserted successfully!");
		} else {
			System.out.println("❌ Invalid type selected.");
		}
	}

	// READ
	public static void fetchData() {
		System.out.println("Fetch (1) Student or (2) Teacher?");
		int type = sc.nextInt();

		System.out.print("Enter ID: ");
		int id = sc.nextInt();

		if (type == 1) {
			Student st = manager.find(Student.class, id);
			if (st != null) {
				System.out.println("Student Found → Name: " + st.getName() + ", Age: " + st.getAge() + ",Marks:"
						+ st.getMarks() + ",City:" + st.getCity());
			} else {
				System.out.println("❌ Student not found.");
			}
		} else if (type == 2) {
			Teacher th = manager.find(Teacher.class, id);
			if (th != null) {
				System.out.println("Teacher Found → Name: " + th.getName() + ", Age: " + th.getAge() + ",Marks:"
						+ th.getMarks() + ",City:" + th.getCity());
			} else {
				System.out.println("❌ Teacher not found.");
			}
		} else {
			System.out.println("❌ Invalid type selected.");
		}
	}

	// UPDATE
	public static void updateData() {
		System.out.println("Update (1) Student or (2) Teacher?");
		int type = sc.nextInt();

		System.out.print("Enter ID: ");
		int id = sc.nextInt();

		if (type == 1) {
			Student st = manager.find(Student.class, id);
			if (st != null) {
				sc.nextLine();
				System.out.print("Enter New Name: ");
				String newName = sc.nextLine();
				System.out.print("Enter New Age: ");
				int newAge = sc.nextInt();
				System.out.print("Enter New Marks: ");
				int newMarks = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter New City: ");
				String newCity = sc.nextLine();

				transaction.begin();
				st.setName(newName);
				st.setAge(newAge);
				st.setMarks(newMarks);
				st.setCity(newCity);
				manager.merge(st);
				transaction.commit();

				System.out.println("✅ Student updated successfully!");
			} else {
				System.out.println("❌ Student not found.");
			}
		} else if (type == 2) {
			Teacher th = manager.find(Teacher.class, id);
			if (th != null) {
				sc.nextLine();
				System.out.print("Enter New Name: ");
				String newName = sc.nextLine();
				System.out.print("Enter New Age: ");
				int newAge = sc.nextInt();
				System.out.print("Enter New Marks: ");
				int newMarks = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter New City: ");
				String newCity = sc.nextLine();

				transaction.begin();
				th.setName(newName);
				th.setAge(newAge);
				th.setMarks(newMarks);
				th.setCity(newCity);
				manager.merge(th);
				transaction.commit();

				System.out.println("✅ Teacher updated successfully!");
			} else {
				System.out.println("❌ Teacher not found.");
			}
		} else {
			System.out.println("❌ Invalid type selected.");
		}
	}

	// DELETE
	public static void deleteData() {
		System.out.println("Delete (1) Student or (2) Teacher?");
		int type = sc.nextInt();

		System.out.print("Enter ID: ");
		int id = sc.nextInt();

		if (type == 1) {
			Student st = manager.find(Student.class, id);
			if (st != null) {
				transaction.begin();
				manager.remove(st);
				transaction.commit();
				System.out.println("✅ Student deleted successfully!");
			} else {
				System.out.println("❌ Student not found.");
			}
		} else if (type == 2) {
			Teacher th = manager.find(Teacher.class, id);
			if (th != null) {
				transaction.begin();
				manager.remove(th);
				transaction.commit();
				System.out.println("✅ Teacher deleted successfully!");
			} else {
				System.out.println("❌ Teacher not found.");
			}
		} else {
			System.out.println("❌ Invalid type selected.");
		}
	}
}
