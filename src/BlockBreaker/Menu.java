package BlockBreaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JPanel implements KeyListener, ActionListener{
	private JButton button;
	private JTextField input;
	
		public Menu() {
			setLayout(null);
			button = new JButton("Start!");
			input = new JTextField("",30);
			button.setBounds(400, 170, 90, 30);
			input.setBounds(300, 170, 90, 30);
			add(input);
			add(button);
		}
		
		public void paint(Graphics g){
			//Background
			g.setColor(Color.black);
			g.fillRect(1, 1, 692, 592);
			
			
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 35));
			g.drawString("Welcome! Enter your GamerTag.", 90,150);
			
			g.dispose();
		}

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
