package com.tt.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class EnvProperties {

	public String filePath = "";
	public String env="";
	Properties p;
	String currentInstance="";
	
	public EnvProperties(String filePath)
	{
		this.filePath=filePath;
		p=new Properties();
		try
		{
		InputStream i = new FileInputStream(this.filePath);	
		p.load(i);
		i.close();
		currentInstance=getPropertyValue("run_on_instance");
		System.out.println("Scripts need to run on instance?:"+currentInstance);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String getPropertyValue(String propertyName)
	{
		return getPropertyValue(propertyName,currentInstance);
	}
	public String getPropertyValue(String propertyName,String prefix)
	{
		String r="";
		if(prefix!=null && !"".equals(prefix))
			propertyName=prefix+"_"+propertyName;
		r=p.getProperty(propertyName);
		System.out.println("Value of property["+propertyName+"]is-"+r);
		return r;
	}
	
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		this.env = env;
	}
	public Properties getP() {
		return p;
	}
	public void setP(Properties p) {
		this.p = p;
	}
	public String getCurrentInstance() {
		return currentInstance;
	}
	public void setCurrentInstance(String currentInstance) {
		this.currentInstance = currentInstance;
	}
	public static void main(String args[])
	{
		EnvProperties ep = new EnvProperties("C:\\selenium\\env2.Properties");
		String userName = ep.getPropertyValue("user_name");
		String userPassword = ep.getPropertyValue("user_password");
		String appUrl = ep.getPropertyValue("app_url");
	
	}
}
