package openx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;

public class UserJSON {

	private static JSONArray array;

	public void setUserArray() {
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
			array = new JSONArray(response.toString());
			// JSONArray arrayJson = new JSONArray(response.toString());
			// JSONObject objJson = new JSONObject(arrayJson.get(1).toString());
			// System.out.print(objJson.get("email"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JSONArray getUsersArray() {
		return array;
	}
}
