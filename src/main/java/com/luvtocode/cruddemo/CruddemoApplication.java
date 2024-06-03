package com.luvtocode.cruddemo;

import com.luvtocode.cruddemo.dao.StudentDAO;
import com.luvtocode.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);

	}
	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){

		return runner-> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			queryForStudents(studentDAO);
		};
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get list of students
		List<Student> theStudent = studentDAO.findAll();
		//display list of students
		for (Student tempStudent : theStudent){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object

		System.out.println("creating new student object...");
		Student tempStudent =new Student("Daffy","Duck","daffy@99.com");
		//save the student
		System.out.println("save the student");
		studentDAO.save(tempStudent);
		//display id of the saved student
		int theId=tempStudent.getId();
		System.out.println("saved student .generated id" + theId);
		//retrieve student based on the id:primary key
		System.out.println("retrieving student with id " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("found the student "+ myStudent);


	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating multiple students object");
		Student tempStudent1 =new Student( "Chahak","Kothari","chahak@99.com");
		Student tempStudent2 =new Student( "ranu","porwal","@2000gmail.com");
		Student tempStudent3 =new Student( "pratyush","Kothari","pratyush7211.com");
		System.out.println(" saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

  // create  student object
		System.out.println("Creating new student object");
		Student tempStudent =new Student( "Chahak","Kothari","chahak@99.com");

		// save stduent
		System.out.println(" saving the student...");
		studentDAO.save(tempStudent);
		// dispaly id of the save student
		System.out.println("saved student generated id:" + tempStudent.getId());

	}

}
