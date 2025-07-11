package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constant.Env;

public class PropertiesUtil
{
	public static String readProperty(Env env,String propertyName) 
	{
	System.out.println(System.getProperty("user.dir"));
    File prpFile= new File(System.getProperty("user.dir")+"\\Config\\"+env+".properties");
    FileReader fileReader = null;
    Properties properties=new Properties();
	try {
		fileReader = new FileReader(prpFile);
		properties.load(fileReader);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    String value=properties.getProperty(propertyName.toUpperCase());
    return value;
	}
}