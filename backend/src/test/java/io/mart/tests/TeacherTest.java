package io.mart.tests;

import io.mart.checker.TeacherChecker;
import io.mart.executor.TeacherExecutor;
import io.mart.model.Teacher;
import io.mart.provider.TeacherProvider;
import org.testng.annotations.Test;

public class TeacherTest {
	
	TeacherProvider teacherProvider = new TeacherProvider();
	TeacherChecker teacherChecker = new TeacherChecker();
	TeacherExecutor teacherExecutor = new TeacherExecutor();
	
	
	@Test
	public void canCreateTeacher() {
		
		// Arrange
		String name = "ExplicitName";
		Teacher teacher = teacherProvider.buildDefaultTeacher()
				.setFirstName(name);
		
		// Act
		Teacher createdTeacher = teacherExecutor.create(teacher);
		
		// Assert
		teacherChecker.hasName(createdTeacher, name);
	}
}
