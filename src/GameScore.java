import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class GameScore {
	
	private String url;
	
	private JSONObject jsonObject;
	
	private JSONArray data;
	
	public GameScore(String url)  {
		
		this.url = url;
		
		try {
			FileReader read = new FileReader(url);
			JSONParser parser = new JSONParser();
			
			jsonObject = (JSONObject) parser.parse(read);
			data = (JSONArray) jsonObject.get("userScores");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public String[] getNames() {
		
		String[] names = new String [data.size()];
		
		for(int i = 0; i < data.size(); i++) {
			
			JSONObject user = (JSONObject) data.get(i);
			names[i] = String.valueOf(user.get("name"));
			
		}
		
		
		return names;
		
	}
	
	public int getScore(String name) {
		
		for(int i = 0; i < data.size(); i++) {
			
			JSONObject user = (JSONObject) data.get(i);
			
			if (String.valueOf(user.get("name")).equals(name)) {
				
				String score = String.valueOf("score");
				return Integer.parseInt(score);
				
			}
			
		}
		
		return 0;
		
	}
	
	/*private void readJson() {
		
		try {
			JSONParser parser = new JSONParser();
			JSONArray brickList;
			JSONObject brick;
			JSONObject coord;

			Object object;
			object = parser.parse(new FileReader("Bricks.json"));
			
			JSONObject jsonObject = (JSONObject) object;
			brickList = (JSONArray) jsonObject.get("bricks");
			for (int i = 0; i < brickList.size(); i++) {
				
				brick = (JSONObject) brickList.get(i);
				coord = (JSONObject) brick.get("coords");
				long x = (long) coord.get("x");
				long y = (long) coord.get("y");
				
				String color = (String) brick.get("color");
				
				 * JSON Structure
				 * {"bricks":[
				 * 				{
				 * 					"coords": {
				 * 								"x": 0,
				 * 								"y": 0	
				 * 					},
				 * 					"color": "blau"
				 * 				},
				 *  			{
				 * 					"coords": {
				 * 								"x": 20,
				 * 								"y": 40	
				 * 					},
				 * 					"color": "vermell"
				 * 				},
				 * 				{
				 * 					"coords": {
				 * 								"x": 20,
				 * 								"y": 20	
				 * 					},
				 * 					"color": "blau"
				 * 				},
				 * }
				 * 
				 * 
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}*/

}
