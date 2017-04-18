package chat;

import java.beans.FeatureDescriptor;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.google.gson.Gson;

public class NetHandler {

	private UserKezelo mento;

	private HttpConnection serverCommunicatorObject;

	User belepettFelhasznalo;

	public NetHandler() {
		mento = new UserKezelo();
		serverCommunicatorObject = new HttpConnection();
	}

	public boolean belepes(String userNev, String jelszo) {
		belepettFelhasznalo = new User(userNev, jelszo);
		return true;

	}

	public boolean regisztracio(String userNev, String jelszo) {
		User felhasznalo = new User(userNev, jelszo);
		mento.mentes(felhasznalo);
		try {
			serverCommunicatorObject.sendPost("user/", felhasznalo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		belepettFelhasznalo = new User(userNev, jelszo);

		return true;
	}

	public void sendMessage(String message) {
		try {
			serverCommunicatorObject.sendPost("message/new", new UserMessage(belepettFelhasznalo, message));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getMessages() {
		try {
			return messageFeldolgozo(serverCommunicatorObject.sendGet("message"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getFelhasznaloNev() {
		return this.belepettFelhasznalo.userName;
	}

	public String messageFeldolgozo(String uzik) {
		String visszateroUzik = "";
		Gson gson = new Gson();
		ReceivedMessages msg = gson.fromJson(uzik, ReceivedMessages.class);
        
		if (msg.errorCode == -1) {
			for (MessageObject m : msg.messages) {
				visszateroUzik = visszateroUzik + m.sender + " : " + m.message + "\n";
			}
		} else {

			visszateroUzik = "Server Error";
		}
		return visszateroUzik;
	}

}
