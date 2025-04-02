// Controls bricks and their properties 

package application;

public class Brick {
	
	public static final int bricks = 30; // this is the max amount of bricks
	
	public static double[][] brickPos = new double[bricks][2]; // [0] = x of the brick [1] = y of the brick
	
	public static final int BRICK_HEIGHT = 20;
	public static final int BRICK_WIDTH = 110;
	
	//Distance between bricks
	private static final double brickDistanceX = 1;
	private static final double brickDistanceY = 1;
	
	public static void spawnBricks(int colCount, int rowCount)
	{
		int brickNum = 0;
		for(int i = 0; i < colCount; i++)
		{
			for(int j = 0; j < rowCount; j++)
			{
				double yPos = ((brickDistanceY + BRICK_HEIGHT) * i) + brickDistanceY * 2;
				double xPos = (brickDistanceX + BRICK_WIDTH) * j;
				brickPos[brickNum][0] = xPos;
				brickPos[brickNum][1] = yPos;
				brickNum++;
			}
		}
	}
	
	public static void DoBricksCollision()
	{
		for(int i = 0; i < brickPos.length; i++)
		{
			Boolean hit = CollisionHandler.DoBallBrickCollision(brickPos[i][0], brickPos[i][1], BRICK_WIDTH, BRICK_HEIGHT);
			if(hit) brickPos[i][0] = -500; // pretends to destroy the brick
			
			if(ScoreManager.score >= bricks) GameController.RestartGame(); //Restarts game when out of bricks
		}
	}
}