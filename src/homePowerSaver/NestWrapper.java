package homePowerSaver;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/*Wrapper for using the Nest Thermostat API*/
public class NestWrapper {
	private int temp;
	private String accessToken;
	
	public NestWrapper(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public void enablePowerSave() throws IOException {
		//get current thermostat info
		Response info = getInfo();
		
		String data = "{\"target_temperature_f\":" + 65 + "}";
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType,data);
		Request request = new Request.Builder()
				.url("https://api.home.nest.com/oauth2/access_token")
				.addHeader("Authorization", "Bearer " + accessToken)
				.put(body)
				.build();
	}
	
	private Response getInfo() throws IOException {
		//TODO: Incomplete
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url("https://developer-api.nest.com/structures")
				.addHeader("Authorization","Bearer " + accessToken)
				.get()
				.build();
		Response response = client.newCall(request).execute();
		String response_str = response.body().string();
		return null;
	}
}
