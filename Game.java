import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Game {
	GameState roomba;
	GameState gameState;
	
	//Constructor to initialize original game state
	public Game()
	{
		roomba = new Roomba(this);
		gameState = roomba;
	}
	
	//Set the level
	void setGameState(GameState newGameState)
	{
		gameState = newGameState;
	}
	
	//Get the current level
	public GameState getGameState()
	{
		return gameState;
	}
	
	//Get the Roomba level (used for changing levels)
	public GameState getRoombaState()
	{
		return roomba;
	}
	
	public void roomba(Stage stage, BorderPane borderPane){
		gameState.roomba(stage, borderPane);
	}
}
