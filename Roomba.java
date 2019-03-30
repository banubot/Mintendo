import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

//First level of our game
public class Roomba implements GameState {
	boolean isRotating = false;

	Game game;
	Timer timer;
	
	public Roomba(Game thegame) {
		game = thegame;	
	}

	@Override
	public void roomba(Stage stage, BorderPane borderPane) {
		
		Image roomba = new Image("file:roomba.png");
		
		Circle circ = new Circle(50);
	    circ.setFill(new ImagePattern(roomba, 0, 0, 1, 1, true));
		circ.setLayoutX(200);
		circ.setLayoutY(200);
		borderPane.getChildren().add(circ);
		
		borderPane.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {	
			public void handle (MouseEvent event) {

				timer = new Timer(75, new ActionListener() {
					@Override
	                public void actionPerformed(ActionEvent e) {
						
						//TODO: Fix bug where pressing both RMB and LMB at the same time causes non-stop spin
						if (event.getButton() == MouseButton.PRIMARY && !(event.getButton() == MouseButton.SECONDARY))
							circ.setRotate(circ.getRotate() - 20);
						else if (event.getButton() == MouseButton.SECONDARY && !(event.getButton() == MouseButton.PRIMARY))
							circ.setRotate(circ.getRotate() + 20);
	                }
	            });
	            timer.start();
			}
		});
		
		borderPane.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {	
			public void handle (MouseEvent event) {
				if (timer != null) {
	                timer.stop();
	            }
			}
		});
	}
	
}
