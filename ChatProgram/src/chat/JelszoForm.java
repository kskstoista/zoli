package chat;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.server.LoaderHandler;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JelszoForm extends JDialog {

	JTextField felhasznaloNev;
	JTextField jelszo;
	JButton belepes;

	public JelszoForm(Frame parent, NetHandler loginHalo) {
		super(parent, "Login", true);

		setLayout(new FlowLayout());

		setSize(300, 150);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		jelszo = new JTextField("Jelszo", 10);
		felhasznaloNev = new JTextField("Felhasználó Név", 10);
		belepes = new JButton("Belépés");
		
		
		
		felhasznaloNev.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (felhasznaloNev.getText().length() == 0) {
					felhasznaloNev.setText("Felhasználó Név");
				}
			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				felhasznaloNev.setText("");
			}
		});

		jelszo.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (jelszo.getText().equals("")) {
					jelszo.setText("Jelszó");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				jelszo.setText("");
			}
		});

		/*belepes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (loginHalo.belepes(felhasznaloNev.getText(), jelszo.getText())){
					belepes.setText("kilépes" );
				}
				
				//dispose();
			}
		});
*/
		belepes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loginHalo.regisztracio(felhasznaloNev.getText(), jelszo.getText());
				
				dispose();
			}
		});
		
		add(belepes);
		//add(belepes);
		add(felhasznaloNev);
		add(jelszo);

		setVisible(true);

	}
}
