package com.getir.utils.objects;

import com.google.gson.JsonElement;
import com.getir.utils.Resources;
import org.junit.Assert;

public class User {


	public final String telephone;

	public final String activationCode;

	public final String keyword;

	public User(String keyword){
		this.keyword = keyword;
		JsonElement user = Resources.credentials().get(keyword);
		if(user.isJsonNull())
			Assert.fail("User not found with keyword "+ keyword);
		this.telephone = user.getAsJsonObject().get("telephone").getAsString();
		this.activationCode = user.getAsJsonObject().get("activationCode").getAsString();
	}

}
