package BlockBreaker;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.Timer;

public class Menu extends JPanel {
	String error = "";
	String gamerTag = "";
	Font f = new Font("serif", Font.BOLD, 25);
	JLabel errorMessage;
	JTextField textbox;
	JButton confirmButton;
	boolean submit = false;

	public Menu() {
		Container contentPane = this;

		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		
		errorMessage = new JLabel(error);
		errorMessage.setFont(f);
		Component label = new JLabel("Enter GamerTag");
		label.setFont(f);
		textbox = new JTextField(20);
		textbox.setFont(f);
		confirmButton = new JButton("Confirm");
		confirmButton.setPreferredSize(new Dimension(80, 36));
		
		
		contentPane.add(errorMessage);
		contentPane.add(label);
		contentPane.add(textbox);
		contentPane.add(confirmButton);
		
		
		layout.putConstraint(SpringLayout.WEST, errorMessage, 150, SpringLayout.WEST,
				contentPane);
		layout.putConstraint(SpringLayout.NORTH, errorMessage, 250, SpringLayout.NORTH,
				contentPane);
		layout.putConstraint(SpringLayout.WEST, label, 150, SpringLayout.WEST,
				contentPane);
		layout.putConstraint(SpringLayout.NORTH, label, 150, SpringLayout.NORTH,
				contentPane);
		layout.putConstraint(SpringLayout.NORTH, textbox, 200,
				SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, textbox, 150, SpringLayout.WEST,
				contentPane);
		layout.putConstraint(SpringLayout.WEST, confirmButton, 575, SpringLayout.WEST,
				contentPane);
		layout.putConstraint(SpringLayout.NORTH, confirmButton, 200, SpringLayout.NORTH,
				contentPane);

		
		
		confirmButton.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {  
				  gamerTag = textbox.getText();
				  if (gamerTag.length() < 6 || gamerTag.length() > 10) {
					  error = "Gamer tag must be between 6-10 characters";
						errorMessage.setText(error); 
					}
				  else {
					     submit = true;
					     confirmButton.getModel().setPressed(true);
				  }
				   
			  }
			});

	}
	
	public boolean formSubmitted(){
		return submit;
	}
	public String getGamerTag(){
		return gamerTag;
	}

	
}
