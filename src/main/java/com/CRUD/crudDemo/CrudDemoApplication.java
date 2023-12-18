package com.CRUD.crudDemo;

import com.CRUD.crudDemo.dao.StudentDAO;
import com.CRUD.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//getQueriedStudents(studentDAO);
			//getQueriedStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students:");
		int count = studentDAO.deleteAll();
		System.out.println("No of rows deleted: "+count);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 5;
		System.out.println("Student deleted");
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student by id
		int myId = 1;
		System.out.println("Getting student by id: "+myId);
		Student myStudent = studentDAO.findById(myId);
		//setting the first name
		System.out.println("Setting first name of:"+myStudent);
		myStudent.setFirstName("Montu");
		//update
		studentDAO.update(myStudent);
		//Display
		System.out.println("Updated student is: "+myStudent);
	}

	private void getQueriedStudentsByLastName(StudentDAO studentDAO) {
		//get list of students
		List<Student> list = studentDAO.findByLastName("Singh");
		//display the result
		for(Student s:list){
			System.out.println(s);
		}
	}

	private void getQueriedStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> list = studentDAO.findAll();
		//display the list
		for(Student s:list){
			System.out.println(s);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		//Create a student
		System.out.println("Creating a student....");
		Student temp = new Student("Pravin","Singh","pravin254@gmail.com");
		//Save the student
		System.out.println("Saving the student...");
		studentDAO.save(temp);
		//Display id of the saved student
		int theId = temp.getId();
		System.out.println("The id of saved student: "+theId);
		//Retrieve the student from the id:primary Key
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent = studentDAO.findById(theId);
		//Display the found student
		System.out.println("The found student: "+myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating multiple student objects...");
		Student temp1 = new Student("Vipin","Chaudhary","chaudharyvipin760@gmail.com");
		Student temp2 = new Student("Aayush","Nag","aayushnag84@gmail.com");
		Student temp3 = new Student("Somesh","Ravi","ravi065@gmail.com");
		System.out.println("Saving the students....");
		studentDAO.save(temp1);
		studentDAO.save(temp2);
		studentDAO.save(temp3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//Create a student
		System.out.println("Creating...");
		Student temp = new Student("Somesh","Bhattacharya","somesh065@gmail.com");
		//Save the student
		System.out.println("Saving...");
		studentDAO.save(temp);
		//Display the student Id
		System.out.println("The id generated: "+temp.getId());
	}

}
