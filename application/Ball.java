// File defines ball behavior such as movement and bouncing 

package application;

import java.util.Random;

public class Ball{
	
	public static final double BALL_R = 18;
	public static double ballYSpeed = 3;
	public static double ballXSpeed = 3;
	public static double ballXPos = Main.width / 2;
	public static double ballYPos = Main.height / 2;
	
	public static void Move()
	{
		ballXPos+=ballXSpeed;
		ballYPos+=ballYSpeed;
	}
	
	public static void Reset()
	{
		//reset the ball start position 
		SpawnBall(Main.width / 2, Main.height / 2);

		//reset the ball speed and the direction
		Ball.ballXSpeed = new Random().nextInt(2) == 0 ? 3: -3;
		Ball.ballYSpeed = 3;
	}
	
	public static void SpawnBall(double x, double y)
	{
		Ball.ballXPos = x;
		Ball.ballYPos = y;
	}
}