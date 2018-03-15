package com.utililties;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
	public static String createResultFolder()
	{
		String path = "";
		String crntdir = System.getProperty("user.dir");
		
		Date date = new Date();
		SimpleDateFormat sdm = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(sdm.format(date));
		System.out.println(crntdir);
		
		File f = new File (crntdir+"\\Results\\"+sdm.format(date));
		
		if(!f.exists())
		{
			f.mkdirs();
			path = crntdir+"\\Results\\"+sdm.format(date);
		}else
		{
			path = crntdir+"\\Results\\"+sdm.format(date);
		}
		return path;
	}
	
}
