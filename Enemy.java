package gamecore;

import java.awt.Graphics;

import display.Animation;

public class Enemy extends Character  {
	protected int locX;
	protected int locY;
	protected int Px;
	protected int dx;
	protected int dy;
	private final static int GRAVITY = 1;
	public boolean runningRight;
	public boolean runningLeft;
	public boolean standRight;
	public boolean standLeft;
	private Animation animRight;
	private Animation animLeft;

	public Enemy(int x,int y,GameWorldManager gameWorld) {
;
		runningRight =false;
		runningLeft =false;
		standRight =true;
		standLeft =false;
		dx=5;
		dy=0;
		
	}
	public void update(){
		if (dx>0) {
			runningRight = true;
			runningLeft = false;
		}
		else if (dx<0){
			runningRight = true;
			runningLeft = false;
		}
		locX += dx;
		dy += GRAVITY;
		locY += dy;
		if (runningRight)
			animRight.loopIms();	
		
		else if (runningLeft)
		    animLeft.loopIms();	
		
		/*if (GameWorldManager.worldCollisionVertical(enemy))
		    dy = 0;*/
		
		if (GameWorldManager.worldCollisionHorizontal(enemy))
			dx = -dx;
		
	}
	/*public void draw(Graphics g) {
		int locX,locY;
		locX = getX() - GameWorldManager.getOffsetX();
		locY = getY() - GameWorldManager.getOffsetY();
		if (runningRight) 
			animRight.draw(g,locX,locY);
		else if (runningLeft) 
			animLeft.draw(g,locX,locY);
		else if (standRight) 
		    animRight.draw(g,locX,locY);
		else if (standLeft)
			animLeft.draw(g,locX,locY);
 	}*/
	
	

}
