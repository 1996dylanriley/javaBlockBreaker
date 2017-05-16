package BlockBreaker;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame;
		
		String gamerTag = "";
		
		frame = new JFrame("BlockBreaker");
		
		Menu menu = new Menu();
		GamePlay gamePlay = new GamePlay();
			
		CardLayout cl = new CardLayout();
		
			JPanel containerPanel = new JPanel();
			containerPanel.setLayout(cl);
			containerPanel.add(menu, "1");
			containerPanel.add(gamePlay, "2");
			cl.show(containerPanel, "1");
			
			frame.setBounds(10,10,700,600);
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			frame.add(containerPanel);
			while(menu.formSubmitted()){
				gamerTag = menu.getGamerTag();

			}
			
			cl.show(containerPanel, "2");
			
			
	}

}
