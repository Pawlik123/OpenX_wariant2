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

		List<String> nonUniqueTitles = howManyPostsAreSimilar(postslist);
		System.out.println(nonUniqueTitles);

		List<String> usersLocation = whatLocationUsers(userlist);
		System.out.println(usersLocation);
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

	/**
	 * Metoda sprawdza czy tytu³y postów s¹ unikalne i zwraca listê tytu³ów
	 * które nie s¹
	 * 
	 * @param postsList
	 * @return
	 */
	public static List<String> howManyPostsAreSimilar(JSONArray postsList) {
		JSONObject postsObj;
		// return postsList;
		List<String> listOfPost = new ArrayList<String>();
		for (int z = 0; z < postsList.length(); z++) {
			postsObj = (JSONObject) postsList.get(z);
			String title = postsObj.getString("title");
			for (int r = 0; r < postsList.length(); r++) {
				if (r != z) {
					postsObj = (JSONObject) postsList.get(r);
					String q = postsObj.getString("title");
					if (title.equals(q)) {
						listOfPost.add(title);
					}
				}
			}
		}
		return listOfPost;
	}

	/**
	 * Metoda zwraca listê u¿ytkowników,którzy mieszkaj¹ najbli¿ej
	 * @param usersList
	 * @return
	 */
	public static List<String> whatLocationUsers(JSONArray usersList) {
		JSONObject usersObj;
		List<String> listOfUsers = new ArrayList<String>();
		for (int q = 0; q < usersList.length(); q++) {
			usersObj = (JSONObject) usersList.getJSONObject(q).getJSONObject("address").getJSONObject("geo");
			double x = usersObj.getDouble("lat");
			double y = usersObj.getDouble("lng");

			double i = 0;
			int count = 0;
			double dystans = 0;
			int user = 0;
			for (int u = 0; u < usersList.length(); u++) {
				if (q != u) {
					usersObj = (JSONObject) usersList.getJSONObject(u).getJSONObject("address").getJSONObject("geo");
					double z = usersObj.getDouble("lat") - x;
					double w = usersObj.getDouble("lng") - y;
					if(count == 0) {
						dystans = Math.sqrt((Math.pow(z, 2) * Math.pow(w, 2)));
					}
					i = Math.sqrt((Math.pow(z, 2) * Math.pow(w, 2)));
					if (dystans >= i) {
						dystans = i;
						user = u;
					}
					count++;
				}
			}
			JSONObject userObj = (JSONObject) usersList.get(q);
			String firstUser = userObj.getString("username");
			userObj = (JSONObject) usersList.get(user);
			String secondUser = userObj.getString("username");
			listOfUsers.add("User: " + firstUser + " life close to user: " + secondUser);
		}
		return listOfUsers;
	}
}
