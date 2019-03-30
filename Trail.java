import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Trail extends Circle {

	int timeExisting;
	public Trail(double x, double y, double radius, RoombaObject player) {
		super(x, y, radius);
		timeExisting = 0;
		this.setFill(Paint.valueOf("#b5f2e8"));
		
		this.setLayoutX(player.getLayoutX());
		this.setLayoutX(player.getLayoutY());
	}
	
	public void update(){
		timeExisting += 1;
		this.setOpacity(this.getOpacity() - 0.005);
	}

}
