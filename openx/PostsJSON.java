package openx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

public class PostsJSON {

	private static JSONArray arrayJson;

	public void setPostsArray() {
		try {
			String url = "https://jsonplaceholder.typicode.com/posts";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			arrayJson = new JSONArray(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JSONArray getPostsArray() {
		return arrayJson;
	}
}
