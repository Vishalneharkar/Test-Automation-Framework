package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constant.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility 
{
	public static Environment readJSON(Env env) 
	{
		Gson gson =new Gson();
		File jsonFile = new File(System.getProperty("user.dir")+"\\Config\\config.json");
		FileReader filereader = null;
		try {
			filereader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config=gson.fromJson(filereader, Config.class);
		Environment environment=config.getEnvironments().get("QA");
		return environment;
	}

}
