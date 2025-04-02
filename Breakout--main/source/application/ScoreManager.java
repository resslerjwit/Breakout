// Manages game score and levels

package application;

public class ScoreManager {
	
	public static int score = 0;
	
	public static void addScore(int addValue)
	{
		score += addValue;
	}
	
	public static  void SetScore(int newScore)
	{
		score = newScore;
	}
	
	public static int GetScore() 
	{
		return score;
	}
}