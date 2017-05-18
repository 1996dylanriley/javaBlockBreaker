package BlockBreaker;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	//sets up application window.
        JFrame frame;
        String gamerTag = "";
        frame = new JFrame("BlockBreaker");
        
        //creates instance of game
        Menu menu = new Menu();
        GamePlay gamePlay = new GamePlay();
        
        //sets up the window containers with chosen layout
        JPanel containerPanel = new JPanel();
        CardLayout layout = new CardLayout();

        containerPanel.setLayout(layout);
        containerPanel.add(menu, "1");
        containerPanel.add(gamePlay, "2");
        layout.show(containerPanel, "1");

        frame.setBounds(10,10,700,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(containerPanel);
        
        //This infinate loop ensures that the menu is always open when the form hasn't been validated
        while(true){
        	gamerTag = menu.getGamerTag();
        	if(!menu.formSubmitted()){
        		layout.show(containerPanel, "1");
        	}
        	
        	else{
        		gamePlay.gamerTag = gamerTag;
    	        layout.show(containerPanel, "2");
    	        gamePlay.requestFocus();
        	}
        	
	        
        }
    }
}


