import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.util.*;
import javafx.geometry.Insets;
import java.io.*;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern; 
import javafx.scene.image.Image; 
import javafx.scene.input.MouseButton; 




public class Mintendo extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	
	public void start(Stage stage) {
		GameHandler handler = new GameHandler();
		Game game = new Game();
		GameState gameState;

		stage.setTitle("Dukkha");
		BorderPane borderPane = new BorderPane();
	  	stage.setScene(new Scene(borderPane, 900, 900));
		game.roomba(stage, borderPane);
		
		stage.show();
	}
}
