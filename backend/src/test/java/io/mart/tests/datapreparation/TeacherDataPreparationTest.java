package io.mart.tests.datapreparation;

import java.util.List;

import io.mart.checker.TeacherChecker;
import io.mart.executor.TeacherExecutor;
import io.mart.model.Teacher;
import io.mart.provider.TeacherProvider;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeacherDataPreparationTest {
	
	TeacherProvider teacherProvider = new TeacherProvider();
	TeacherChecker teacherChecker = new TeacherChecker();
	TeacherExecutor teacherExecutor = new TeacherExecutor();
	
	
	@BeforeClass
	public void setUp() {
		teacherExecutor.deleteAll();
		
		Teacher teacher1 = teacherProvider.buildDefaultTeacher().setFirstName("Alex");
		Teacher teacher2 = teacherProvider.buildDefaultTeacher().setFirstName("David");
		teacherExecutor.create(teacher1);
		teacherExecutor.create(teacher2);
	}
	
	
	@Test
	public void getAllTeachers_returnCorrectList() {
		
		// Act
		List<Teacher> all = teacherExecutor.all();
		
		// Assert
		teacherChecker.listContainsTeachersWithFirstNames(all, "Alex", "David");
	}
}
