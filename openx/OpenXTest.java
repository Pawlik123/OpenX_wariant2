package openx;

import static org.junit.Assert.*;

import java.util.List;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;

public class OpenXTest {

	@Test
	public void checkthePostsWriteUsersNotNull() {
		ParaseJSON users = new ParaseJSON("https://jsonplaceholder.typicode.com/users");
		ParaseJSON posts = new ParaseJSON("https://jsonplaceholder.typicode.com/posts");

		JSONArray userlist = users.getJSONArray();
		JSONArray postslist = posts.getJSONArray();

		OpenX a = new OpenX();
		a.howManyPostsWriteUsers(userlist, postslist);
		List<String> q = a.howManyPostsWriteUsers(userlist, postslist);
		Assert.assertNotNull(q);
	}
	@Test
	public void checkthePosthowManyPostsAreSimilarNotNull(){
		ParaseJSON users = new ParaseJSON("https://jsonplaceholder.typicode.com/users");
		ParaseJSON posts = new ParaseJSON("https://jsonplaceholder.typicode.com/posts");

		JSONArray userlist = users.getJSONArray();
		JSONArray postslist = posts.getJSONArray();
	
		OpenX b=new OpenX();
		b.howManyPostsAreSimilar(postslist);
		List<String> qq=b.howManyPostsAreSimilar(postslist);
		Assert.assertNotNull(qq);
	}	
	@Test
	public void checkthePostwhatLocationUsers(){
		ParaseJSON users = new ParaseJSON("https://jsonplaceholder.typicode.com/users");
		ParaseJSON posts = new ParaseJSON("https://jsonplaceholder.typicode.com/posts");

		JSONArray userlist = users.getJSONArray();
		JSONArray postslist = posts.getJSONArray();
		
		OpenX c=new OpenX();
		c.whatLocationUsers(userlist);
		List<String> qqq=c.whatLocationUsers(userlist);
		Assert.assertNotNull(qqq);
	}
}
