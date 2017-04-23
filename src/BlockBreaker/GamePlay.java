package BlockBreaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

	private boolean play = false;
	private int score = 0;
	
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 310;
	
	private int ballPosX = 120;
	private int ballPosY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	public boolean win = false;
	
	public int[] getBallPos(){
		return new int[]{ballPosX,ballPosY};
	}
	public int[] getBallDir(){
		return new int[]{ballXdir,ballYdir};
	}
	public int getScore(){
		return score;
	}
	
	private MapGenerator map;
	public GamePlay(){
		
		map = new MapGenerator(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
	}
	public GamePlay(boolean customPos, int playerx,int ballx, int bally, int brickCount ){
		if(customPos){
			playerX = playerx;
			ballPosX = ballx;
			ballPosY = bally;
			totalBricks = brickCount;
		}
		map = new MapGenerator(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
	}
	
	public void paint(Graphics g){
		//Background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		//draw map
		map.draw((Graphics2D)g);
		
		//border
		g.setColor(Color.yellow);
		g.fillRect(0,0,3,592);
		g.fillRect(0,0,692,3);
		g.fillRect(691,0,3,592);
		
		//score
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString(""+score, 590, 30);
		
		
		//paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		//ball
		g.setColor(Color.yellow);
		g.fillOval(ballPosX, ballPosY, 20, 20);
		
		if(isGameOver()){
			play = false;
			ballXdir = 0;
			
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 25));
			String message = win == true? "Win!":"Loose!";
			g.drawString("Game Over, You " + message, 190,300);
			
			g.setFont(new Font("serif", Font.BOLD, 40));
			g.drawString("Press Enter To Restart", 190,350);
			
		}
		
		g.dispose();
	}
	
	public boolean isGameOver(){
		if(totalBricks == 0){
			win = true;
			return true;
			}
		if(ballPosY > 570){
			win = false;
			return true;
		}
		return false;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		timer.start();
		if(play){
			if(new Rectangle(ballPosX,ballPosY,20,20).intersects(new Rectangle(playerX, 550,100,8))){
				ballYdir = -ballYdir;
			}
			
			checkForBrickCollision();
			
			ballPosX += ballXdir;
			ballPosY += ballYdir;
			
		}
		repaint();
		bounceOffBorder();
	}
	
	public void bounceOffBorder(){
		if(ballPosX < 0){
			ballXdir = -ballXdir;
		}
		if(ballPosY < 0){
			ballYdir = -ballYdir;
		}
		if(ballPosX > 670){
			ballXdir = -ballXdir;
		}
	}
	
	public void checkForBrickCollision(){
		A:for(int i = 0; i < map.map.length; i++){
			for(int j = 0; j < map.map[0].length; j++){
				if(map.map[i][j] > 0){
					int brickX = j*map.brickWidth+80;
					int brickY = i * map.brickHeight+50;
					int brickWidth = map.brickWidth;
					int brickHeight = map.brickHeight;
					
					Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
					Rectangle ballRect = new Rectangle(ballPosX, ballPosY,20,20);
					Rectangle brickRect = rect;
					
					if(ballRect.intersects(brickRect)){
						map.setBrickValue(0, i, j);
						totalBricks--;
						score += 5;
						
						if(ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width){
							ballXdir = -ballXdir;
						}else{
							ballYdir = -ballYdir;
						}
						break A;
					}
				}
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(playerX >= 600){
				playerX = 600;
			}else{
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(playerX <= 0){
				playerX = 0;
			}else{
				moveLeft();
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			if(!play){
				play = true;
				score = 0;
				ballPosX = 120;
				ballPosY = 350;
				ballYdir = -2;
				ballXdir = -1;
				playerX = 310;
				totalBricks = 21;
				map = new MapGenerator(3, 7);
				repaint();
			}
		}
		
	}
	
	public void moveRight(){
		play = true;
		playerX += 20;
	}
	public void moveLeft(){
		play = true;
		playerX -= 20;
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
