package io.mart.tests.properties;

import io.mart.checker.TeacherChecker;
import io.mart.executor.TeacherExecutor;
import io.mart.executor.with.properties.TeacherExecutorWithProperties;
import io.mart.model.Teacher;
import io.mart.provider.TeacherProvider;
import org.testng.annotations.Test;

public class TeacherTest {
	
	TeacherProvider teacherProvider = new TeacherProvider();
	TeacherChecker teacherChecker = new TeacherChecker();
	TeacherExecutorWithProperties teacherExecutor = new TeacherExecutorWithProperties();
	
	
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
