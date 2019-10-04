package agentTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import objects.DataStorage;
import objects.Phone;

public class APICrawler {
	
	private String fonoApiToken = "b134ff2e4fc9a99924049a00f748e9b70932a8d06dd347f2";
	public void crawlApi(String device) throws JSONException, IOException {
		String USER_AGENT = "Mozilla/5.0";		
		String fonoURL = "https://fonoapi.freshpixl.com/v1/getlatest";

		String fonoPostParam = "token=" + fonoApiToken + "&limit=20&brand=" + device;
		DataStorage dataStorage = DataStorage.getSharedDataStorage();

		String url = "http://api.ipinfodb.com/v3/ip-city/?key=d64fcfdfacc213c7ddf4ef911dfe97b55e4696be3532bf8302876c09ebd06b&ip=74.125.45.100&format=json";
		
		URL obj = new URL(fonoURL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(fonoPostParam.getBytes());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
			con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		    //print in String
		    System.out.println(response.toString());
		    //Read JSON response and print
//		    dataStorage.getPhoneList().clear();
		    System.out.println("WKKKKKKKKKKKKK");
		    System.out.println(response.toString());
		    JSONArray myResponse = new JSONArray(response.toString());

		    for(int i = 0; i < myResponse.length(); i++) {
		    	JSONObject JSONphone = new JSONObject(myResponse.getJSONObject(i).toString());
	
		  		Phone phone = new Phone(JSONphone.getString("Brand"), 
		  				checkJSON(JSONphone,"DeviceName"), 
		  				checkJSON(JSONphone,"resolution"), 
		  				checkJSON(JSONphone,"price"), 
		  				checkJSON(JSONphone,"weight"), 
		  				checkJSON(JSONphone,"size"), 
		  				checkJSON(JSONphone,"type"), 
		  				checkJSON(JSONphone,"cpu"), 
		  				checkJSON(JSONphone,"internal"), 
		  				checkJSON(JSONphone,"battery_c"), 
		  				checkJSON(JSONphone,"primary_"), 
		  				checkJSON(JSONphone,"secondary"), 
		  				checkJSON(JSONphone,"card_slot"), 
		  				checkJSON(JSONphone,"internal"), 
		  				checkJSON(JSONphone,"nfc"),
		  				checkJSON(JSONphone,"dimensions")
		  				);
		    	dataStorage.getPhoneList().add(phone);
		    }
		} else {
			System.out.println("FAILED TO SCRAP PHONE FROM PHONO API");
		}
	}	
	
	public String checkJSON(JSONObject jsonPhone, String key) throws JSONException {
		if(jsonPhone.has(key)) {
			return jsonPhone.getString(key);
		}
		else {
			return "";
		}
	}
}
