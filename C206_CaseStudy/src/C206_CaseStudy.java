
public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	private static final String SID_PATTERN = "[0-9]{8}";
	private static final String MOBILE_PATTERN = "[89][0-9]{7}";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("19001234", "Bob", "3A", "Tom", "95421234"));
		studentList.add(new Student("19005678", "Ben", "3C", "Harry", "95425678"));
		
		int option = 0;

		while (option != 5) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all students
				C206_CaseStudy.viewAllStudent(studentList);

			} else if (option == 2) {
				// Add a new student
				Student s = inputStudent();
				C206_CaseStudy.addStudent(studentList, s);
				
			} else if (option == 3) {
				// Delete an existing student
				C206_CaseStudy.deleteStudent(studentList);
				
			} else if (option == 4) {
				// Update existing student details
				C206_CaseStudy.updateStudent(studentList);
			}
			
		}
	}
	
	public static void menu() {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("STUDENTS");
		System.out.println("1. View Student Details");
		System.out.println("2. Add New Student");
		System.out.println("3. Delete Existing Student");
		System.out.println("4. Update Existing Student");
		System.out.println("5. Quit");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	//================================= Option 1 View students (CRUD- Read) =================================
	public static void viewAllStudent(ArrayList<Student> studentList) {
		C206_CaseStudy.setHeader("VIEW ALL STUDENT DETAILS");
		String output = String.format("%-10s %-10s %-10s %-15s %-20s\n", "STUDENT ID", "NAME",
				"CLASS", "PARENTS NAME","PARENTS NUMBER");
		output += retrieveAllStudent(studentList);
		System.out.println(output);
	}
		
	public static String retrieveAllStudent(ArrayList<Student> studentList) {
		// TODO Auto-generated method stub
		String output = "";
			
		for (int i = 0; i < studentList.size(); i++) {
			output += String.format("%-10s %-10s %-10s %-15s %-20s\n", studentList.get(i).getsID(), 
					studentList.get(i).getsName(),
					studentList.get(i).getsClass(), studentList.get(i).getpName(), studentList.get(i).getpNumber());
		}
		return output;
			
	}

	//================================= Option 2 Add a student (CRUD - Create) =================================
	public static Student inputStudent() {
		String sID = Helper.readStringRegEx("Enter Student ID > ", SID_PATTERN);
		String sName = Helper.readString("Enter Student Name > ");
		String sClass = Helper.readString("Enter Student Class > ");
		String pName = Helper.readString("Enter Parent Name > ");
		String pNumber = Helper.readStringRegEx("Enter Parent Number > ", MOBILE_PATTERN);
		Student s = new Student(sID, sName, sClass, pName, pNumber);
		return s;
	}
	public static void addStudent(ArrayList<Student> studentList, Student s) {
		studentList.add(s);
		System.out.println("Student added");
		
	}
	
	//================================= Option 3 Delete a student (CRUD - Delete) =================================
	public static void deleteStudent(ArrayList<Student> studentList) { 
		String sID = Helper.readStringRegEx("Enter Student ID", SID_PATTERN);
		for(int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getsID().equals(sID)) {
				studentList.remove(i);
				System.out.println("Student deleted");
			}
			else {
				System.out.println("Failed to delete");
			}
		}
		
		
	}
	
	//================================= Option 4 Update a student (CRUD - Update) =================================
	public static void updateStudent(ArrayList<Student> studentList) {
		String sID = Helper.readStringRegEx("Enter Student ID", SID_PATTERN);
		for(int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getsID().equals(sID)) {
				String uClass = Helper.readString("Enter " + studentList.get(i).getsName() + " Updated Class > ");
				String uPNum = Helper.readStringRegEx("Enter updated " + studentList.get(i).getsName() 
						+ "  Parent Number > ", MOBILE_PATTERN);
				studentList.get(i).setsClass(uClass);
				studentList.get(i).setpNumber(uPNum);
				System.out.println("Student details updated");
			}
			else {
				System.out.println("Failed to update");
			}
		}
	}

	}

}
