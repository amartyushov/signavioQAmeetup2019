package io.mart.checker;

import java.util.List;

import io.mart.model.Teacher;

import static org.assertj.core.api.Assertions.assertThat;

public class TeacherChecker {
	
	
	public void hasName(Teacher createdTeacher, String name) {
		assertThat(createdTeacher.getFirstName())
				.as("Check firstName of teacher")
				.isEqualTo(name);
	}
	
	
	public void listContainsTeachersWithFirstNames(List<Teacher> all, String... firstNames) {
		assertThat(all).extracting("firstName").containsExactly(firstNames);
	}
}
