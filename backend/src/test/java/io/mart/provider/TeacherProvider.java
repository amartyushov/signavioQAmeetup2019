package io.mart.provider;

import java.util.Map;
import java.util.Random;

import io.mart.model.Teacher;

public class TeacherProvider {
	int id = 1;
	
	public Teacher buildDefaultTeacher() {
		Teacher teacher = new Teacher();
		int randomInt = new Random().nextInt(70);
		
		teacher.setId(id++);
		teacher.setAge(randomInt);
		teacher.setFirstName("first_name");
		teacher.setLastName("last_name");
		teacher.setSpeciality("Math");
		return teacher;
	}
	
	
}
