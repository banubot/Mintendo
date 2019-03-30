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
		Image roomba = new Image("file:roomba.png");

		stage.setTitle("Mintendo");
		BorderPane borderPane = new BorderPane();
	  	stage.setScene(new Scene(borderPane, 900, 900));
		Circle circ = new Circle(50);
	    circ.setFill(new ImagePattern(roomba, 0, 0, 1, 1, true));
		circ.setLayoutX(200);
		circ.setLayoutY(200);
		borderPane.getChildren().add(circ);
		boolean isRotating = false;
	
		borderPane.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {	
			public void handle (MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY) {
					System.out.println("RIGHT");
					circ.setRotate(circ.getRotate() + 20);
				} else {
					System.out.println("LEFT");
					circ.setRotate(circ.getRotate() - 20);
				}
				
			}	
		});
		stage.show();
	}
}
