import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class RoombaObject extends Circle{

	Point2D velocity;
	Point2D location;
	int size, centeredx, centeredy, width, height;
	boolean proportional;
	
	public RoombaObject(){
		super(50);
		
		size = 50;
		centeredx = 0;
		centeredy = 0;
		width = 1;
		height = 1;
		proportional = true;
		this.velocity = new Point2D(0, -1);
		this.location = new Point2D(200, 200);
		
		Image roomba = new Image("file:roomba.png");
	    this.setFill(new ImagePattern(roomba, centeredx, centeredy, width, height, proportional));
		this.setLayoutX(location.getX());
		this.setLayoutY(location.getY());
		
	}
	
	public RoombaObject(int size_, int centeredx_, int centeredy_, int width_, int height_, boolean proportional_, int locx_, int locy_, Point2D vel_){
		super(size_);
		
		size = size_;
		centeredx = centeredx_;
		centeredy = centeredy_;
		width = width_;
		height = height_;
		proportional = proportional_;
		this.velocity = vel_;
		this.location = new Point2D(locx_, locy_);
		
		Image roomba = new Image("file:roomba.png");
	    this.setFill(new ImagePattern(roomba, centeredx, centeredy, width, height, proportional));
		this.setLayoutX(locx_);
		this.setLayoutY(locy_);
		
	}
	
	public void mouseRight()
	{
		this.setRotate(this.getRotate() - 10);
		this.setVelocity(new Point2D(Math.cos(Math.toRadians(this.getRotate()-90)), Math.sin(Math.toRadians(this.getRotate()-90))));
	}
	public void mouseLeft()
	{
		this.setRotate(this.getRotate() + 10);
		this.setVelocity(new Point2D(Math.cos(Math.toRadians(this.getRotate()-90)), Math.sin(Math.toRadians(this.getRotate()-90))));
	}
	
	public void update() {
        this.setTranslateX(this.getTranslateX() + velocity.getX());
        this.setTranslateY(this.getTranslateY() + velocity.getY());
        
        this.setLoc(new Point2D(this.getTranslateX(), this.getTranslateY()));
    }
	
	public Point2D getVelocity(){
		return velocity;
	}
	public void setVelocity(Point2D vel){
		velocity = vel;
	}
	
	public Point2D getLoc(){
		return location;
	}
	public void setLoc(Point2D loc){
		location = loc;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
}
