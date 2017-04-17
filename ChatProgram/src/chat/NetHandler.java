package chat;

import java.beans.FeatureDescriptor;

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

	public String getMessages(){
		try {
			return serverCommunicatorObject.sendGet("message");
		} catch (Exception e){
			e.printStackTrace();
		}
			return "";
	}
	
	public String getFelhasznaloNev() {
		return this.belepettFelhasznalo.userName;
	}
}
