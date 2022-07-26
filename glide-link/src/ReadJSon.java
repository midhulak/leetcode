import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSon {
//	{
//		"firstName" : "midhula",
//		"lastName: "kadiyala","
//				"address":[
//				           {
//				        	   "street" : "robin",
//				        	   "city" : "fremont",
//				        	   "state" : "CA"
//				           }
//				           {
//				        	   "street" : "manet",
//				        	   "city" : "sunnyvale",
//				        	   "state" : "CA"
//				           }
//				           
//				           ]
//	}

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
			org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();
			
			JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("/Users/midhula.kadiyala/Desktop/sample.json"));
		
			//JSONArray jsonArray = (JSONArray) jsonObject.get("");
			
			Iterator<JSONObject> iterator = jsonArray.iterator();
			
			while(iterator.hasNext()) {
				JSONObject obj = iterator.next();
				System.out.println(obj.get("COUNTRY"));
				
			}
		
}
}