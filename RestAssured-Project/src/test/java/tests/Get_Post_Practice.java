package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

@SuppressWarnings("unused")
public class Get_Post_Practice {
	@Test
	public void get() {
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			body("data[2].first_name", equalTo("Tobias"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void post() {
		baseURI = "https://reqres.in/api";
		
		HashMap<String, Object> map = new HashMap<>();
		JSONObject request = new JSONObject();
		
		request.put("name", "Ashwin");
		request.put("job", "IT");
		
		given().
			body(request.toJSONString())
			.header("x-api-key","reqres-free-v1").
		when().
			post("/users").
		then().
			statusCode(201);
		
	}
	

}
