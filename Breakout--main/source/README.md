# Breakout-
Computer Science 2 Final Project 

Jack Ressler (Play/Replay Button, Win/Lose Condition)
Main Responsibilities:
Implement Play and Replay buttons.
Handle game start, restart, and end conditions (win/loss).
Ensure proper UI updates when the game is paused or over.
Files Needed:
Main.java (for initializing UI elements)
Game.java (for triggering game states)
GameUI.java (for Play/Replay buttons and win/lose screens)
ScoreManager.java (for tracking win/loss conditions)

Tucker Sampson (Block Destruction, Paddle Movement)
Main Responsibilities:
Implement paddle movement based on user input.
Handle brick destruction logic when hit by the ball.
Files Needed:
Paddle.java (for player-controlled paddle movement)
GameController.java (to handle input events)
Brick.java (for modifying brick states)
CollisionHandler.java (to check when bricks should be destroyed)

Jason Mansour (Collision)
Main Responsibilities:
Implement collision detection between ball, bricks, paddle, and walls.
Ensure proper physics behavior on impact.
Files Needed:
CollisionHandler.java (core file for collision logic)
Ball.java (to adjust ball direction based on collisions)
Paddle.java (to handle ball bouncing off the paddle)
Brick.java (to detect and remove destroyed bricks)

Josh Allen (Ball Bouncing, Ball Physics)
Main Responsibilities:
Implement ball movement and velocity updates.
Ensure correct bouncing mechanics off walls, paddle, and bricks.
Files Needed:
Ball.java (for movement logic)
CollisionHandler.java (for detecting and responding to collisions)
Game.java (to update ball state every frame)

Everyone (GitHub Repository, Integration)
Shared Responsibilities:
Maintain version control.
Ensure smooth integration of all components.
Fix merge conflicts if needed.
Files All Members Need to Access:
Main.java (initial setup)
Game.java (central game loop and interactions)
GameController.java (connects UI, input, and logic)
GameUI.java (graphical interface)
ScoreManager.java (tracks and updates scores)
