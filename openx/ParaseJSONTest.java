package openx;

import static org.junit.Assert.*;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;

public class ParaseJSONTest {

	@Test
	public void checkTheUsersListNotNull() {
		ParaseJSON users = new ParaseJSON("https://jsonplaceholder.typicode.com/users");
		JSONArray lista = users.getJSONArray();
		Assert.assertNotNull(lista);
	}

	@Test
	public void checkThePostsListNotNull() {
		ParaseJSON posts = new ParaseJSON("https://jsonplaceholder.typicode.com/posts");
		JSONArray lista = posts.getJSONArray();
		Assert.assertNotNull(lista);
	}

}
