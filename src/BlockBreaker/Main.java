package BlockBreaker;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame obj = new JFrame();
		
		boolean MenuOpen = true;
		if(MenuOpen){
			Menu menu = new Menu();
			obj.add(menu);
			
		}
		else{
			GamePlay gamePlay = new GamePlay();
			obj.add(gamePlay);
		}
		
		obj.setBounds(10,10,700,600);
		obj.setTitle("BlockBreaker");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(obj.EXIT_ON_CLOSE);
		
		
		

	}

}
