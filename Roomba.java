import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.Timer;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//First level of our game
public class Roomba implements GameState {
	boolean isRotating = false;

	Game game;
	Timer timer;
	boolean rotating;
	
	public Roomba(Game thegame) {
		game = thegame;
		rotating = false;
	}

	@Override
	public void roomba(Stage stage, BorderPane borderPane) {
		
		RoombaObject player = new RoombaObject(50, 0, 0, 1, 1, true, 200, 200, new Point2D(0, -1));
		borderPane.getChildren().add(player);
		
		Rectangle rectangle = new Rectangle(75, 50, 300, 25);
		rectangle.setFill(Paint.valueOf("#000000"));
		borderPane.getChildren().add(rectangle);
		
		
		LinkedList<Trail> trails = new LinkedList<Trail>();
		AnimationTimer animTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if(!rotating)
            	{
            		player.update();
            		
            		//TODO: Add a trail opacity
            		
            		Trail trail = new Trail(player.getLoc().getX(), player.getLoc().getY()+200, player.getRadius()-20, player);
            		borderPane.getChildren().add(0, trail);
            		trails.add(trail);
            	}
            	if(trails.size() > 400)
            	{
            		borderPane.getChildren().remove(trails.get(0));
            		trails.remove(0);
            	}
            	for (Trail prevTrail : trails)
            			prevTrail.update();
            	
            	//TODO: Add battery life and bare minimum meters to update each tick
            }
        };
        animTimer.start();
        
		borderPane.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {	
			public void handle (MouseEvent event) {
				timer = new Timer(75, new ActionListener() {
					@Override
	                public void actionPerformed(ActionEvent e) {
						
						rotating = true;
						//TODO: Fix bug where pressing both RMB and LMB at the same time causes non-stop spin
						if (event.getButton() == MouseButton.PRIMARY && !(event.getButton() == MouseButton.SECONDARY))
							player.mouseRight();
						else if (event.getButton() == MouseButton.SECONDARY && !(event.getButton() == MouseButton.PRIMARY))
							player.mouseLeft();
	                }
	            });
	            timer.start();
			}
		});
		
		borderPane.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {	
			public void handle (MouseEvent event) {
				if (timer != null) {
	                timer.stop();
	                rotating = false;
	            }
			}
		});
	}
	
}
