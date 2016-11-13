package homePowerSaver;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*Wrapper for using the Nest Thermostat API*/
public class NestWrapper {
	private int temp;
	private String accessToken;
	
	public NestWrapper(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public void enablePowerSave() {
		
	}
}
