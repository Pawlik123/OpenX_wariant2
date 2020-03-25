package openx;

import org.json.JSONArray;
import org.json.JSONObject;

public class OpenX {
	public static void main(String[] args) {
		ParaseJSON user=new ParaseJSON("https://jsonplaceholder.typicode.com/users");
		ParaseJSON posts=new ParaseJSON("https://jsonplaceholder.typicode.com/posts");
	
		JSONArray userlist = user.getJSONArray();
		JSONObject userObj = new JSONObject(userlist.get(2).toString());
		System.out.println(userObj.get("email"));

		JSONArray postslist = posts.getJSONArray();
		JSONObject postsObj = new JSONObject(postslist.get(2).toString());
		System.out.println(postsObj.get("body"));
	}


}
