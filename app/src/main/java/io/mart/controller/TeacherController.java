package io.mart.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.mart.model.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
	
	private Map<Integer, Teacher> teachers = new HashMap<>();

	@PostMapping(path = "/teacher")
	public @ResponseBody
	Teacher create(@RequestBody Teacher teacher) {
		teachers.put(teacher.getId(), teacher);
		return teacher;
	}
	
	@GetMapping(path = "/teacher/{id}")
	public @ResponseBody Teacher get(@PathVariable Integer id) {
		return teachers.get(id);
	}
	
	
	@GetMapping(path = "/teacher")
	public @ResponseBody List<Teacher> getAll() {
		return new ArrayList<>(teachers.values());
	}
	
}
