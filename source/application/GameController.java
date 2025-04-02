// Connects user input with game mechanics.

package application;

public class GameController {
	public static boolean gameStarted;
	public static int ballsLeft = 3;
	
	//Block array variables
	private static int blockCols = 6;
	private static int blockRows = 5;
	
	public static void MissedBall() {
		GameController.ballsLeft--;
		GameController.gameStarted = false;
		if(GameController.ballsLeft <= 0)
		{
			RestartGame();
		}
	}
	
	public static void RestartGame() 
	{
		ScoreManager.SetScore(0);
		GameController.ballsLeft = 3;
		Brick.spawnBricks(blockCols, blockRows);
	}
}