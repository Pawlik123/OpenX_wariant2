package openx;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class OpenX {
	public static void main(String[] args) {
		ParaseJSON user = new ParaseJSON("https://jsonplaceholder.typicode.com/users");
		ParaseJSON posts = new ParaseJSON("https://jsonplaceholder.typicode.com/posts");

		JSONArray userlist = user.getJSONArray();
		JSONArray postslist = posts.getJSONArray();
		
		List<String> listOfPost = howManyPostsWriteUsers(userlist, postslist);
		System.out.println(listOfPost);
	}

	/**
	 * Metoda ta oblicza ile postów napisali userzy i zwraca listê Stringów
	 * 
	 * @param userlist
	 * @param postsList
	 * @return
	 */
	public static List<String> howManyPostsWriteUsers(JSONArray userlist, JSONArray postsList) {
		JSONObject userObj;
		int userSize = userlist.length();
		int postsSize = postsList.length();

		List<String> listOfPost = new ArrayList<String>();
		for (int j = 1; j <= userSize; j++) {
			int count = 0;
			userObj = (JSONObject) userlist.get(j - 1);
			String h = userObj.getString("username");
			for (int a = 0; a < postsSize; a++) {
				userObj = (JSONObject) postsList.get(a);
				int q = userObj.getInt("userId");
				if (q == j) {
					count++;
				}
			}
			listOfPost.add(h + " have " + count + " posts");
		}
		return listOfPost;
	}
}
