package io.mart.checker.with.allure.features;

import java.util.List;

import io.mart.model.Teacher;
import io.qameta.allure.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class TeacherCheckerWithAllure {
	
	@Step("Check teacher has name: {0}")
	public void hasName(Teacher createdTeacher, String name) {
		assertThat(createdTeacher.getFirstName())
				.as("Check firstName of teacher")
				.isEqualTo(name);
	}
	
	@Step("Check teachers have only provided first names: {0}")
	public void listContainsTeachersWithFirstNames(List<Teacher> all, String... firstNames) {
		assertThat(all).extracting("firstName").containsExactly(firstNames);
	}
}
