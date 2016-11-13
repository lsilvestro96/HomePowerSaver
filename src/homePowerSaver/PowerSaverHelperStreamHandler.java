package homePowerSaver;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

public final class PowerSaverHelperStreamHandler extends SpeechletRequestStreamHandler {
	private static final Set<String> supportedAppIds;
	static {
		supportedAppIds = new HashSet<String>();
		//TODO add app ids
	}
	public PowerSaverHelperStreamHandler() {
		super(new PowerSpeechlet(), supportedAppIds);
	}
	
}
