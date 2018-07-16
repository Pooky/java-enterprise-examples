package org.examples.jasper;

import java.io.File;

public class FileUtils {

	public static boolean checkFileExists(String path){
		
		File file = new File(path);
		return file.exists();
		
	}
	
	
	public static boolean checkDirectory(String path){
		
		File file = new File(path);
		return file.isDirectory();
		
	}
	
}
