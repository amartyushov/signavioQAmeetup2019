package io.mart.tests.allure.features;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import io.mart.checker.with.allure.features.TeacherCheckerWithAllure;
import io.mart.executor.with.allure.features.TeacherExecutorWithAllure;
import io.mart.model.Teacher;
import io.mart.provider.with.allure.features.TeacherProviderWithAllure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TeacherWithAllureTest {
	
	TeacherProviderWithAllure teacherProvider = new TeacherProviderWithAllure();
	TeacherCheckerWithAllure teacherChecker = new TeacherCheckerWithAllure();
	TeacherExecutorWithAllure teacherExecutor = new TeacherExecutorWithAllure();
	
	
	@BeforeClass(description = "Create initial teachers")
	public void setUp() {
		teacherExecutor.deleteAll();
		
		Teacher teacher1 = teacherProvider.buildDefaultTeacher().setFirstName("Alex");
		Teacher teacher2 = teacherProvider.buildDefaultTeacher().setFirstName("David");
		teacherExecutor.create(teacher1);
		teacherExecutor.create(teacher2);
	}
	
	
	@Test(description = "Check all first names of teachers")
	@Description("Test gets all teachers and verifies first names of returned teachers")
	@Severity(SeverityLevel.BLOCKER)
	@Issue("DEFECT-123")
	public void getAllTeachers_returnCorrectList() {

		// Act
		List<Teacher> all = teacherExecutor.all();

		// Assert
		teacherChecker.listContainsTeachersWithFirstNames(all, "Alex", "David");
	}
	
	@AfterClass
	public void createAllureEnvironmentFile() throws IOException {
		
		Path path = Paths.get("build/allure-results", "environment.properties");
		File file = path.toFile();
		file.getParentFile().mkdir();
		file.createNewFile();

		Files.write(path, "enviroment=staging".getBytes());
	}
}
