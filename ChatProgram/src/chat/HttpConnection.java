package chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

public class HttpConnection {
	private final String USER_AGENT = "Chrome/5.0";
	private String url = "http://159.203.90.4:8080/codifychat/rest/";

	public static void main(String[] args) {
		HttpConnection http = new HttpConnection();
		System.out.println("Testing 1 - Send Http GET request");

		User u = new User("Zoli113","jelszo");
		System.out.println("\nTesting 2 - Send Http POST request");
		try{
		   http.sendPost("user/", u);
		}
		catch (Exception e) {
		System.out.println(e.toString());
		}
		//LEkerdezunk:
		try{
		   http.sendGet("message/");
		}
		catch (Exception e) {
			System.out.println(e.toString());
		} 
		
	}

	// HTTP GET request
	public String sendGet(String utvonal) throws Exception {
		URL obj = new URL(url + utvonal);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		String s = response.toString();
		// print result
		System.out.println(s);
		return s;
	}

	// HTTP POST request
	public String sendPost(String utvonal, Object objektum) throws Exception {
		URL obj = new URL(this.url + utvonal);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-type", "application/json");
		String urlParameters = "";
		if (objektum != null) {
			urlParameters = new Gson().toJson(objektum);
			System.out.println("Body: " + urlParameters);
		}
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
		int responseCode = con.getResponseCode();
		
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		if(responseCode == 404){ 		// hálózati hiba esetén nem fut tovább
			return "Error 404";
		}
				
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		String s = response.toString();
		System.out.println(s);
		return s;
	}
}