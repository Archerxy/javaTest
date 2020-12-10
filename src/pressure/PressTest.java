package pressure;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;

public class PressTest {
	class Task implements Runnable {
		@Override
		public void run() {
			
		}
	}
	
	public static void post(String urlStr, Map<String,String> param) {
		HttpPost hp = new HttpPost(urlStr);
		EntityBuilder eb = EntityBuilder.create();
	}
	
	public static void get() {
		
	}
	
	public static String jsonStringify(Map<String,String> param) {
		StringBuilder sb = new StringBuilder("{");
		for(String k: param.keySet()) {
			sb.append("\""+k+"\":"+"\""+param.get(k)+"\",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("}");
		return sb.toString();
	}
}
