package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@SuppressWarnings("unused")
public class API_Practice {
	
	@Test
	public void test1() {
		
	// Response response = RestAssured.get("https://reqres.in/api/users?page=2");
	// We can remove the 'RestAssured' class by making the import static.
		
		Response response = get("https://reqres.in/api/users?page=2");
		
	
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());

		Assert.assertEquals(response.getStatusCode(), 200);		
	}
	
	@Test
	public void test2() {
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
		and().
			body("data[1].id", equalTo(8));
		
	}
	
	@Test
	public void test3() {
		
		given().
			get("/users?page=2").
		then().
			body("data[1].id", equalTo(8));
		
	}
}
