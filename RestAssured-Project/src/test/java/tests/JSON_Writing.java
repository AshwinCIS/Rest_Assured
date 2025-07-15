package tests;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSON_Writing {

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JSONObject jsonobject = new JSONObject();
		
		
		jsonobject.put("Name", "Dinoboy");
		jsonobject.put("Age", 24);
		
		//Adding as an array
		JSONArray jsonarray = new JSONArray();
		jsonarray.add("API tester");
		jsonarray.add("CI/CD");
		
		jsonobject.put("Skills", jsonarray);
		
		
		FileWriter file = new FileWriter("datafile.json");
		file.write(jsonobject.toJSONString());
		file.close();
		
		
		
		
	}

}
