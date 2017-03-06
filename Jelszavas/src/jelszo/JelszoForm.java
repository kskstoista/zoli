package jelszo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JelszoForm extends JFrame {
	JTextField felhasznaloNev, weboldal, jelszo;
	JButton mentes;

	JButton keres;
	JTextField keresettOldal;
	JLabel info;
	
	public JelszoForm() {
		super("Jelszo adatbazis");

		setLayout(new FlowLayout());

		
		jelszo = new JTextField("jelszo", 8);
		felhasznaloNev = new JTextField("felhasznalo nev: ", 8);
		weboldal = new JTextField("weboldal", 12);
		mentes = new JButton("Mentes");
		
		keres = new JButton("Kereses");
		keresettOldal = new JTextField("keresett oldal");
		info = new JLabel();
		
		felhasznaloNev.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (felhasznaloNev.getText().length() == 0){ 	//felhasznaloNev.getText().equals("")
 					felhasznaloNev.setText("felhasznalo nev");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				felhasznaloNev.setText("");
				
			}
		});
		
		
		add(felhasznaloNev);
		add(jelszo);
		
		add(weboldal);
		add(mentes);
		
		add(keres);
		add(keresettOldal);
		add(info);
		
		mentes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// adatokm ment�se

				Hozzaferes h = new Hozzaferes(weboldal.getText(), jelszo.getText(), felhasznaloNev.getText());
				try {
					JelszoTarolo.peldany().hozzaferesMentese(h);
					
				} catch (SikertelenMentersException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				felhasznaloNev.setText("Felhasznalo Nev");
				jelszo.setText("Jelszo");
				weboldal.setText("Weboldal");

			}
		});

		keres.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Hozzaferes h = JelszoTarolo.peldany().hozzaferesEleres(keresettOldal.getText());
				if ( h == null) {
					info.setText("Nincs adat");
				}else { 
					info.setText(h.felhasznalonNev + " " + h.jelszo);
				}
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JelszoForm();
	}

}
