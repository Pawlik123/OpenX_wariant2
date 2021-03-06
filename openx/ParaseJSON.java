package openx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.UnknownHostException;

import org.json.JSONArray;

public class ParaseJSON {

	private JSONArray array;

	/**
	 * Wysyla zapytanie GEt do strony internetowej nastepnie tworzy liste typu
	 * JSONArray.
	 * 
	 * @param url
	 */
	public ParaseJSON(String url) {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Zwraca JSONowa liste.
	 * 
	 * @return
	 */
	public JSONArray getJSONArray() {
		return this.array;
	}
}
