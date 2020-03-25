package openx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class UserJSON {
	public void main(String[] args) {
		try {
			String url = "https://jsonplaceholder.typicode.com/users";
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
			setPostsArray(response.toString());
			JSONArray arrayJson = new JSONArray(response.toString());
			JSONObject objJson = new JSONObject(arrayJson.get(0).toString());
			System.out.print(objJson.get("name"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setPostsArray(String string) {

	}
}
