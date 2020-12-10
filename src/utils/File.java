package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class File {
	public static List<String> readFile(String path) throws FileNotFoundException, IOException {
    	BufferedReader br = null;
    	List<String> lines = new ArrayList<>();
    	try(FileInputStream fis = new FileInputStream(path)){
    		br = new BufferedReader(new InputStreamReader(fis));
        	String s = null;
        	while((s = br.readLine()) != null) {
        		lines.add(s);
        	}
    	}
    	return lines;
	}
}
