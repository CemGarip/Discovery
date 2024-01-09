package com.getir.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class Resources {
	private static final Gson gson = new Gson();

	private static JsonObject credentials;

	private static String fileContents(String fileName){
		final String name = "test_data/" + fileName;
		final InputStream is = Resources.class.getClassLoader().getResourceAsStream(name);
		Scanner reader = new Scanner(is).useDelimiter("\\A");
		return reader.next();
	}
	public static JsonObject credentials(){
		if(Objects.isNull(credentials))
			credentials = gson.fromJson(fileContents("credentials.json"), JsonObject.class);
		return credentials;
	}
}