import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.stage.*;
import sun.audio.*;
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

		ContinuousAudioDataStream loop = null;
		AudioPlayer MGP = music();
		MGP.start(loop);

		BorderPane layout1 = mainMenuLayout(game, stage);
		Scene mainMenu = new Scene(layout1, 900, 900);

		stage.setScene(mainMenu);
		stage.setTitle("Dukkha");
		stage.show();
	}

	private BorderPane mainMenuLayout(Game game, Stage stage) {
		BorderPane borderPane = new BorderPane();
		// stage.setScene(new Scene(borderPane, 900, 900));
		game.roomba(stage, borderPane);

		Label label1 = new Label("Welcome to the main menu!");
		Button button1 = new Button("Start");
		button1.setOnAction(e -> stage.setScene(new Scene(borderPane, 900, 900)));

		// Set backgound image
		Image titleScene = new Image("MinTendoMainMenu.png");
		BackgroundImage backgroundimage = new BackgroundImage(titleScene, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundimage);

		// Set up button layout
		VBox mainTab = new VBox();
		mainTab.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		mainTab.getChildren().addAll(label1, button1);
		mainTab.setMaxSize(100, 100);

		BorderPane layout1 = new BorderPane();
		layout1.setBackground(background);
		layout1.setCenter(mainTab);
		return layout1;
	}

	private AudioPlayer music() {
		AudioPlayer MGP = AudioPlayer.player;
		AudioStream BGM;
		AudioData MD;

		try {

			// BGM = new AudioStream(new FileInputStream("testAudio.wav"));
			BGM = new AudioStream(new FileInputStream("mintendoMusic.wav"));
			// MD = BGM.getData();
			AudioPlayer.player.start(BGM);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MGP;
	}
}
