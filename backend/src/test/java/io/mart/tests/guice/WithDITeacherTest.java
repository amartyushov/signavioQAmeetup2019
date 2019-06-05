package io.mart.tests.guice;

import com.google.inject.Inject;
import io.mart.checker.TeacherChecker;
import io.mart.executor.TeacherExecutor;
import io.mart.executor.with.guice.TeacherExecutorWithDI;
import io.mart.guice.CustomGuiceModule;
import io.mart.model.Teacher;
import io.mart.provider.TeacherProvider;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice(modules = { CustomGuiceModule.class })
public class WithDITeacherTest {
	
	@Inject
	TeacherProvider teacherProvider;
	
	@Inject
	TeacherChecker teacherChecker;
	
	@Inject
	TeacherExecutorWithDI teacherExecutor;
	
	
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
