package com.getir.utils.objects;

import com.google.gson.JsonElement;
import com.getir.utils.Resources;
import org.junit.Assert;

public class User {


	public final String email;

	public final String password;
	public final String keyword;

	public User(String keyword){
		this.keyword = keyword;
		JsonElement user = Resources.credentials().get(keyword);
		if(user.isJsonNull())
			Assert.fail("User not found with keyword "+ keyword);
		this.email = user.getAsJsonObject().get("email").getAsString();
		this.password = user.getAsJsonObject().get("password").getAsString();
	}

}
