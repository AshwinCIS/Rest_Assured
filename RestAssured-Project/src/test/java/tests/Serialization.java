package tests;

import static io.restassured.RestAssured.*;
import java.util.*;
import org.testng.annotations.*;


public class Serialization {
	
	@Test
	public void serialization() {
		
		Map<String, Object> data = new HashMap<>();
		List<String> listdata = new ArrayList<>();
		
		
		data.put("Name", "Dinoboy");
		data.put("YOE", "3");
		listdata.add("Manual");
		listdata.add("Automation");
		
		data.put("Skills", listdata);
		
		baseURI = "https://reqres.in/api";
		
		given()
			.header("Content-Type","application/json")
			.header("x-api-key","reqres-free-v1")
			.body(data).
		when()
			.post("/users").
		then()
			.log()
			.all();
		
		
		
		
	}
}
