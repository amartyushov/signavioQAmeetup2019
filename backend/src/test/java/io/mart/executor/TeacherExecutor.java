package io.mart.executor;

import java.util.ArrayList;
import java.util.List;

import io.mart.model.Teacher;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_OK;

public class TeacherExecutor {
	
	private static final Logger log = LogManager.getLogger(TeacherExecutor.class);
	private static final String PATH = "/teacher";
	private static final String BASE_URI = "http://localhost:9191";
	private static final String ID = "id";
	
	
	public TeacherExecutor() {
		RestAssured.requestSpecification = new RequestSpecBuilder()
				.setBaseUri(BASE_URI)
				.setAccept(JSON)
				.setContentType(JSON)
   				.log(LogDetail.ALL)
				.build();
		
		RestAssured.responseSpecification = new ResponseSpecBuilder()
				.expectStatusCode(SC_OK)
				.build();
	}
	
	public Teacher get(Integer id){
		log.info("Get teacher with id: " + id);
		return RestAssured
				.given()
				.pathParam(ID, id)
				.get(PATH + "/{id}")
				.then()
				.extract().as(Teacher.class);
	}
	
	
	public Teacher create(Teacher teacher) {
		log.info("Create teacher: " + teacher);
		return RestAssured
				.given()
				.body(teacher)
				.post(PATH)
				.then()
				.extract()
				.as(Teacher.class);
	}
	
	public List<Teacher> all() {
		log.info("Get all teachers");
		return RestAssured
				.given()
				.get(PATH)
				.then()
				.extract()
				.body()
				// here's the magic
				.jsonPath().getList(".", Teacher.class);
	}
	
	public void delete(Integer id) {
		RestAssured.given()
				.pathParam(ID, id)
				.delete(PATH + "/{id}");
	}
	
	public void deleteAll() {
		all().stream().map(Teacher::getId).forEach(this::delete);
	}
}
