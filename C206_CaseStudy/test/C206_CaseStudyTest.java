import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Student s1;
	private Student s2;
	
	private ArrayList<Student> studentList;

	@Before
	public void setUp() throws Exception {
		s1 = new Student("19001234", "Bob", "3A", "Tom", "95421234");
		s2 = new Student("19005678", "Ben", "3C", "Harry", "95425678");
		
		studentList = new ArrayList<Student>();
	}
	
	@Test
	public void testAddStudent() {
		// Student list is not null, so that can add a new item
		assertNotNull("Test if there is valid Student arraylist to add to", studentList);
				
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addStudent(studentList, s1);		
		assertEquals("Test if that Student arraylist size is 1?", 1, studentList.size());
		
		//The student just added is as same as the first student of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", s1, studentList.get(0));
				
		//Add another student. test The size of the list is 2?
		C206_CaseStudy.addStudent(studentList, s2);
		assertEquals("Test that Student arraylist size is 2?", 2, studentList.size());
	}
	
	@Test
	public void testRetrieveAllStudent() {
		// Test if Student list is not null but empty, so that can add a new Student
		assertNotNull("Test if there is valid Camcorder arraylist to add to", studentList);
				
		//test if the list of Students retrieved from the C206_CaseStudy is empty
		String allStudent = C206_CaseStudy.retrieveAllStudent(studentList);
		String testOutput = "";
		assertEquals("Check that ViewAllStudentlist", testOutput, allStudent);
				
		//Given an empty list, after adding 2 students, test if the size of the list is 2
		C206_CaseStudy.addStudent(studentList, s1);
		C206_CaseStudy.addStudent(studentList, s2);
		assertEquals("Test if that Student arraylist size is 2?", 2, studentList.size());
				
		//test if the expected output string same as the list of Student retrieved from the C206_CaseStudy
		allStudent = C206_CaseStudy.retrieveAllStudent(studentList);

		testOutput = String.format("%-10s %-10s %-10s %-15s %-20s\n","19001234", "Bob", "3A", "Tom", "95421234");
		testOutput += String.format("%-10s %-10s %-10s %-15s %-20s\n","19005678", "Ben", "3C", "Harry", "95425678");
			
		assertEquals("Check that ViewAllStudentlist", testOutput, allStudent);
	}
	
	@Test
	public void testDeleteStudent() {
		//Test that the Student arraylist is not null so that can add a new Student.
		assertNotNull("Test that the Student arraylist is not null: ", studentList);
		  
		//Test that the size of the Student arraylist is 1 after adding a Student.
		C206_CaseStudy.addStudent(studentList, s1);		
		assertEquals("Test if the Student arrayList size is 1?", 1, studentList.size());
		
		//Test that the size of the Student arraylist is 2 after adding a Student.
		C206_CaseStudy.addStudent(studentList, s2);		
		assertEquals("Test if the Student arrayList size is 2?", 2, studentList.size());
		  
		//Test that the size of the Student arraylist is 1 after deleting 1 Student.
		C206_CaseStudy.deleteStudent(studentList);
		assertEquals("Test if the Student arrayList size is 1?", 1, studentList.size());
		
		//Test that the size of the Student arraylist is 0 after deleting 1 Student.
		C206_CaseStudy.deleteStudent(studentList);
		assertEquals("Test if the Student arrayList size is 0?", 0, studentList.size());
	}
	
	@Test 
	public void testUpdateStudent() {
		//Test that the Student arraylist is not null so that can add a new Student.
		assertNotNull("Test that the Student arraylist is not null: ", studentList);
		
		//Test that the size of the Student arraylist is 1 after adding a Student.
		C206_CaseStudy.addStudent(studentList, s1);		
		assertEquals("Test if the Student arrayList size is 1?", 1, studentList.size());
		
		// Test that the Student details can be updated properly.
		C206_CaseStudy.updateStudent(studentList);
	}

	@After
	public void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		studentList = null;
	}
}

