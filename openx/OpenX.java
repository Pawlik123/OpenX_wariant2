package openx;

import org.json.JSONArray;
import org.json.JSONObject;

public class OpenX {
	public static void main(String[] args) {
		UserJSON user = new UserJSON();
		user.setUserArray();
		JSONArray userlist = user.getUsersArray();
		JSONObject userObj = new JSONObject(userlist.get(2).toString());
		System.out.println(userObj.get("email"));

		PostsJSON posts = new PostsJSON();
		posts.setPostsArray();
		JSONArray postslist = posts.getPostsArray();
		JSONObject postsObj = new JSONObject(postslist.get(0).toString());
		System.out.println(postsObj.get("body"));

	}

}
