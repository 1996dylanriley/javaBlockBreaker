package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import BlockBreaker.GamePlay;

public class Tests {

	@Test
	public void GameOverWhenBallGoesBelowPaddel() {
		GamePlay gp = new GamePlay(true,1000,1000,1000,10);
		
		assertEquals(true,gp.isGameOver());
	}
	
	@Test
	public void GameOverWhenThereAreNoMoreBricks() {
		GamePlay gp = new GamePlay(true,1,1,1,0);
		
		assertEquals(true,gp.isGameOver());
	}
	
	@Test
	public void DoesBallBounceWhenHitsBorder() {
		GamePlay gp = new GamePlay(true,300,-1,1,5);
		int defaultXDir = -1;
		gp.bounceOffBorder();
		
		assertNotEquals(defaultXDir,gp.getBallDir()[0]);
	}
	
	@Test
	public void DoesBallBounceWhenHitsBrick() {
		GamePlay gp = new GamePlay(true,300,90,90,21);
		int defaultXDir = -1;
		int defaultYDir = -2;
		int[] defaultDirection = new int[]{defaultXDir,defaultYDir};
		gp.checkForBrickCollision();
		
		assertNotEquals(defaultDirection,gp.getBallDir());
	}
	
	@Test
	public void DoesScoreIncrement() {
		GamePlay gp = new GamePlay(true,300,90,90,21);
		int defaultXDir = -1;
		int defaultYDir = -2;
		int[] defaultDirection = new int[]{defaultXDir,defaultYDir};
		int defaultScore = 0;
		
		gp.checkForBrickCollision();
		
		int scoreAfterCollsion = gp.getScore();
		
		assertNotEquals(defaultScore, scoreAfterCollsion);
		assertEquals(5,  scoreAfterCollsion);
	}
	
	

}
