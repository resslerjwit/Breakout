package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	
	//variable
	public static final int width = 550;
	public static final int height = 800;
	
	public static double ballY, ballX;
	
	public Canvas canvas = null;
		
	public void start(Stage stage) throws Exception {
		stage.setTitle("B R E A K - O U T");
		//background size
		canvas = new Canvas(width, height);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		//JavaFX Timeline = free form animation defined by KeyFrames and their duration 
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
		//number of cycles in animation INDEFINITE = repeat indefinitely
		tl.setCycleCount(Timeline.INDEFINITE);
		
		//mouse control (move and click)
		canvas.setOnMouseMoved(e ->  Paddle.playerOneXPos  = e.getX());
		canvas.setOnMouseClicked(e ->  GameController.gameStarted = true);
		stage.setScene(new Scene(new StackPane(canvas)));
		stage.show();
		GameController.RestartGame();
		tl.play();
	}

	private void run(GraphicsContext gc) {
		//set graphics
		//set background color
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width, height);
		
		//set text
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font(25));
		
		if(GameController.gameStarted) {
			//set ball movement
			Ball.Move();
			
			gc.fillOval(Ball.ballXPos, Ball.ballYPos, Ball.BALL_R, Ball.BALL_R);
			
		} else {
			//set the start text
			gc.setStroke(Color.WHITE);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.strokeText("Click", width / 2, height / 2);
			
			Ball.Reset();
		}
		
		//This does the ball collision with the walls, and restarts the game if you miss the ball
		CollisionHandler.DoBallWallCollision();
		
		//This is for the ball and paddle collision
		Paddle.alignPlayer(); 
		//Checks for and runs collision event
		CollisionHandler.DoBallPadCollision();
		Brick.DoBricksCollision();
		
		//draw score
		gc.fillText("Score: " + ScoreManager.GetScore() + "", 50, height - 10);
		//draw balls left
		gc.fillText("Balls left: " + GameController.ballsLeft + "", width - 65, height - 10);
		//draws player
		gc.fillRect(Paddle.playerOneXPos, Paddle.playerOneYPos, Paddle.PLAYER_WIDTH, Paddle.PLAYER_HEIGHT);
		
		//draws bricks
		for(int i = 0; i < Brick.brickPos.length; i++)
		{
			gc.fillRect(Brick.brickPos[i][0], Brick.brickPos[i][1], Brick.BRICK_WIDTH, Brick.BRICK_HEIGHT);
		}
	}
	
		// start the application
		public static void main(String[] args) {
			launch(args);
		}
}