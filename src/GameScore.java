import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
		} catch (org.json.simple.parser.ParseException e) {
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
			
			if (String.valueOf(user.get("name")).equalsIgnoreCase(name)) {
				
				String score = String.valueOf(user.get("score"));
				return Integer.parseInt(score);
				
			}
			
		}
		
		return -1;
		
	}
	
	public JSONObject getUser(String userName) {
		
		for (int i = 0; i < data.size(); i++) {
			
			JSONObject user = (JSONObject) data.get(i);
			
			if (String.valueOf(user.get("name")).equalsIgnoreCase(userName)) {
				
				return user;
				
			}
			
		}
		
		return null;
		
	}
	
	@SuppressWarnings("unchecked")
	public void saveScore(String userName, int score) {
		
		JSONObject user = getUser(userName);
		
		if (user == null) {
			
			user= new JSONObject();
			
			user.put("name", userName);
			user.put("score", score);
			
			data.add(user);
			
		} else {
			
			user.put("score", score);
			
		}
		
		try {
			
			FileWriter writer = new FileWriter(url);
			writer.write(jsonObject.toJSONString());
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
