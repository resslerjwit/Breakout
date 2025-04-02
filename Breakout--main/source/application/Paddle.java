// Controls players paddle movement and input

package application;

public class Paddle {
	public static double playerOneXPos = 0;
	public static double playerOneYPos = Main.height - 45;
	
	public static final int PLAYER_HEIGHT = 15;
	public static final int PLAYER_WIDTH = 115;
	
	//player movement
	public static void alignPlayer()
	{
		playerOneXPos = (playerOneXPos >= Main.width - PLAYER_WIDTH) ? Main.width - PLAYER_WIDTH : playerOneXPos;
	}
	
	public static void InfluanceBall()
	{
		//get velocity, current pos - last pos, then apply some part of that to the ball's x speed
	}
}