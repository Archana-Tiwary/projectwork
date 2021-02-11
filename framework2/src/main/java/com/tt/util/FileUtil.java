package com.tt.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
	
	public static String getFileName(String filePath)
	{
		String output = "";
		File f = new File(filePath);
		output = f.getName();
		
		return output;
	}
	
	public static String getAbsolutePath(String filePath)
	{
		String output = "";
		File f = new File(filePath);
		output = f.getAbsolutePath();
		
		return output;
	}
	
	public static boolean exists(String filePath)
	{
		return (new File(filePath)).exists();
	}
	
	public static void createFolder(String filePath) {
		try {
			Files.createDirectories(Paths.get(filePath));
		}
		catch(Exception e){
			
		}
	}
	
	public static void createTextFile(String path, String fileName)
	{
		try
		{
			String fullFilePath = path+fileName+".txt";
			File f=new File(fullFilePath);
			if(!f.exists() && f.createNewFile())
			{
				System.out.println("File\""+ fullFilePath+"\"is created successfully ");
			}
			else if(f.exists())
			{
				System.out.println("File already exists");
			}
			else
			{
				System.out.println("File was not created");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void writeFile(String filePath, String content)
	{
		try
		{
			FileWriter fw = new FileWriter(filePath);
			fw.write(content);
			fw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void appendFile(String filePath, String content)
	{
		try
		{
			if(!exists(filePath))
			{
				System.out.println("File does not exist, cannot append it");
				return;
			}
			else {
				FileWriter fw = new FileWriter(filePath, true);
				fw.append("\n");
				fw.append(DateUtil.getCurrentDate("dd-MMM-yyyy HH-mm-ss")+":"+content);
				/*BufferedWriter bw = new BufferedWriter(fw);
				bw.newLine();
				bw.append(content);
				bw.close();*/
				fw.close();
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	public static void main (String args[])
	{
		System.out.println(FileUtil.getFileName("C:\\selenium\\DemoReporter.html"));
		System.out.println(FileUtil.getAbsolutePath("C:\\selenium\\DemoReporter.html"));
		System.out.println(FileUtil.exists("C:\\selenium\\DemoReporter.html"));
		FileUtil.createFolder("C:\\selenium\\FolderScreenshots");
		FileUtil.createTextFile("C:\\selenium\\FolderScreenshots\\","log");
		//FileUtil.writeFile("C:\\selenium\\FolderScreenshots\\log.txt","I am Writing");
		FileUtil.appendFile("C:\\selenium\\FolderScreenshots\\log.txt","in a notebook");
	}

	public static void copyFile(File source, File file) {
		// TODO Auto-generated method stub
		
	}

	

}
