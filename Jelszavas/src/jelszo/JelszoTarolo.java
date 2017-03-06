package jelszo;

import java.util.HashMap;
import java.util.Map;

import javax.naming.ldap.HasControls;

public class JelszoTarolo implements HozzaferesMento {

	private static JelszoTarolo jelszotarolo;
	private HashMap<String, Hozzaferes> hozzaferesek;

	private JelszoTarolo() {
		hozzaferesek = new HashMap<>();
		
	}

	public static JelszoTarolo peldany() {
		if (jelszotarolo == null) {
			jelszotarolo = new JelszoTarolo();

		}
		return jelszotarolo;
	}

	@Override
	public void hozzaferesMentese(Hozzaferes h) throws SikertelenMentersException {
		
		hozzaferesek.put(h.weboldal, h);
		System.out.println(hozzaferesek.size() + "hoz�f�r�s van");
	}
	
	public Hozzaferes hozzaferesEleres(String weboldal) {
		return hozzaferesek.get(weboldal);
	}
}
