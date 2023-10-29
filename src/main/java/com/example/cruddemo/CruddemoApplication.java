package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDao;
import com.example.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner->{
			createStudentDao(studentDao);
			findStudentById(studentDao, 1);
			findAll(studentDao);
			updateStudent(studentDao);
			deleteStudent(studentDao);
			deleteAllStudents(studentDao);
		};
	}

	private void deleteAllStudents(StudentDao studentDao) {
		int rowsNumbers = studentDao.deleteAll();
		System.out.println("Deleted row count" + rowsNumbers);
	}

	private void updateStudent(StudentDao studentDao) {
		Student studentTemp =studentDao.findStudentById(2);
		showStudent(studentDao.findAll());
		studentTemp.setName("Dave");
		studentDao.update(studentTemp);
		showStudent(studentDao.findAll());
	}

	private void findAll(StudentDao studentDao) {
		showStudent(studentDao.findAll());
	}

	private void findStudentById(StudentDao studentDao, int i) {
		System.out.println(studentDao.findStudentById(i));
	}


	private void deleteStudent(StudentDao studentDao) {
		showStudent(studentDao.findAll());
	}

	private void createStudentDao(StudentDao studentDao) {

		Student student = new Student("student_name","student_surname","student_email");

		studentDao.save(student);

		System.out.println("new student id:" + student.getId());
	}

	private void showStudent(List<Student> studentsTemp){
		for(Student student : studentsTemp){
			System.out.println(student);
		}
	}
}
