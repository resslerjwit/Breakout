// File for collision physics and controls between objects 

package application;

public class CollisionHandler  {
	
	public static void DoBallPadCollision() 
	{
		//increase the speed after the ball hits the player
		if((Ball.ballXPos < Paddle.playerOneXPos + Paddle.PLAYER_WIDTH && Ball.ballXPos >= Paddle.playerOneXPos) && 
				(Ball.ballYPos >= Paddle.playerOneYPos - Paddle.PLAYER_HEIGHT && Ball.ballYPos <= Paddle.playerOneYPos)) {
			Ball.ballYSpeed += (0.2 * Math.signum(Ball.ballYSpeed));
			Ball.ballXSpeed += (0.2 * Math.signum(Ball.ballXSpeed));
			Ball.ballYSpeed = -Math.abs(Ball.ballYSpeed);
		}
	}
	
	public static void DoBallWallCollision()
	{
		//makes sure the ball stays in the canvas
		if(Ball.ballYPos < 0) Ball.ballYSpeed *=-1;
		if(Ball.ballXPos < 0 || Ball.ballXPos >= Main.width-18) Ball.ballXSpeed *=-1;
				
		//if you miss the ball, stops the game
		if(Ball.ballYPos > Main.height)
		{
			GameController.MissedBall();
		}
	}
	
	public static Boolean DoBallBrickCollision(double brickPosX, double brickPosY, int brickWidth, int brickHeight) 
	{
		//increase the speed after the ball hits the player
		if((Ball.ballXPos < brickPosX + brickWidth && Ball.ballXPos >= brickPosX) &&
				((Ball.ballYPos <= brickPosY + brickHeight) && Ball.ballYPos >= brickPosY - brickHeight)) {
			Ball.ballYSpeed *= -1;
			ScoreManager.score++;
			return true;
		}
		else return false;
	}
}