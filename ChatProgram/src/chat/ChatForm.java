package chat;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.Area;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Scrollable;

public class ChatForm extends JFrame {

	JLabel szereplokLabel;
	JTextField szoveg, kijelzo;
	JButton send, hi, wow, whatsup, miauu, thanks, refresh;
	JTextArea mezo;
	JTextArea szereplok;
	NetHandler halo;
	JLabel label;
	UserKezelo belepettFelhasznalo;

	public ChatForm() {
		super(" Chat");
		halo = new NetHandler();

		new JelszoForm(this, halo);

		setLayout(new FlowLayout());

		szereplokLabel = new JLabel("Online vannak: ");
		szoveg = new JTextField(30);
		mezo = new JTextArea("Chat mezõ");
		mezo = new JTextArea(30, 55);
		JScrollPane scrollPane = new JScrollPane(mezo);

		szereplok = new JTextArea(50, 27);
		szereplok = new JTextArea(halo.getFelhasznaloNev());

		label = new JLabel("belépve mint: " + halo.getFelhasznaloNev());

		send = new JButton("Send");
		hi = new JButton("Hi");
		wow = new JButton("WoW");
		whatsup = new JButton("What's Up");
		miauu = new JButton("miauu");
		thanks = new JButton("Thanks");
		refresh = new JButton("Refresh");

		hi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mezo.append("Hi" + "\n");
				halo.sendMessage("Hi");
			}
		});

		wow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mezo.append("Wow" + "\n");
				halo.sendMessage("Wow");
			}
		});

		whatsup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mezo.append("What's Up?" + "\n");
				halo.sendMessage("What's up?");
			}
		});

		miauu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mezo.append("miauu" + "\n");
				halo.sendMessage("miau" + "\n");
			}
		});

		thanks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mezo.append("Thanks" + "\n"); // a fenti mezõbe irás, késöbb
												// majd nem kell
				halo.sendMessage("Thanks");
			}
		});

		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				halo.sendMessage(szoveg.getText());

			}
		});

		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mezo.append(halo.getMessages() + "\n");
			}
		});

		/*
		 * szoveg.addFocusListener(new FocusListener() {
		 * 
		 * @Override public void focusLost(FocusEvent e) { // TODO
		 * Auto-generated method stub
		 * 
		 * }
		 * 
		 * @Override public void focusGained(FocusEvent e) { // TODO
		 * Auto-generated method stub szoveg.setText("");
		 * 
		 * } });
		 * 
		 * 
		 */
		add(szereplokLabel);
		add(szereplok);
		add(scrollPane);
		add(hi);
		add(wow);
		add(whatsup);
		add(miauu);
		add(thanks);
		add(szoveg);
		add(send);
		add(refresh); // tempi
		add(label);

		setSize(640, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args) {
		new ChatForm();

	}

}
