package homePowerSaver;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;

public class PowerSpeechlet implements Speechlet {
	
	@Override
	public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
		// TODO Auto-generated method stub

	}

	@Override
	public SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {
		String greeting = "Welcome to Home Power Saver. You can say a command such as turn on power saver mode";
		String rePrompt = "For instructions on what you can say, please say, please say help me";
		return newAskResponse(greeting,rePrompt);
	}

	@Override
	public SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {
		Intent intent = request.getIntent();
		String intentName = null;
		if (intent != null) {
			intentName = intent.getName();
		}
		
		if (intentName.equals("PowerSave")) {
			return processIntent(intent);
		}
		
		
		
		return null;
	}

	@Override
	public void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {
		// TODO Auto-generated method stub

	}
	
	
	private SpeechletResponse processIntent(Intent intent) {
		Slot stateSlot = intent.getSlot("LIST_OF_STATES");
		if (stateSlot != null && stateSlot.getValue() != null) {
			String value = stateSlot.getValue();
			return togglePowerSave(value,intent);
		}
		else {
			return getHelp();
		}
	}
	
	private SpeechletResponse togglePowerSave(String value, Intent intent) {
		
		return null;
	}

	private SpeechletResponse getHelp() {
		String response = "Say whether you want to turn power saving on or off";
		String reprompt = "Do you want to turn power saving on or off";
		return newAskResponse(response,reprompt);
	}

	private SpeechletResponse newAskResponse(String greeting, String repromptStr) {
		PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
		outputSpeech.setText(greeting);
		
		PlainTextOutputSpeech repromptSpeech = new PlainTextOutputSpeech();
		repromptSpeech.setText(repromptStr);
		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech(repromptSpeech);
		
		return SpeechletResponse.newAskResponse(outputSpeech, reprompt);
	}

}
