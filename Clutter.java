import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Clutter extends Circle {

	Point2D location;
	int size, centeredx, centeredy, width, height;
	boolean proportional;
	boolean pickedup;
	
	public Clutter(){
		super(5);
		
		pickedup = false;
		size = 5;
		centeredx = 0;
		centeredy = 0;
		proportional = true;
		
		width= (int) (Math.random() * (3 - 1)) + 1;
		height = (int) (Math.random() * (3 - 1)) + 1;
		
		int randx = (int) (Math.random() * (850 - 50)) + 50;
		int randy = (int) (Math.random() * (850 - 50)) + 50;
		
		this.location = new Point2D(randx, randy);
		
		Image clutter = new Image("file:clutter.jpg");
	    this.setFill(new ImagePattern(clutter, centeredx, centeredy, width, height, proportional));
		this.setLayoutX(location.getX());
		this.setLayoutY(location.getY());
		
	}
	
	public Clutter(int size_, int centeredx_, int centeredy_, int width_, int height_, boolean proportional_, int locx_, int locy_, Point2D vel_){
		super(size_);
		
		size = size_;
		centeredx = centeredx_;
		centeredy = centeredy_;
		width = width_;
		height = height_;
		proportional = proportional_;
		this.location = new Point2D(locx_, locy_);
		
		Image clutter = new Image("file:clutter.png");
	    this.setFill(new ImagePattern(clutter, centeredx, centeredy, width, height, proportional));
		this.setLayoutX(locx_);
		this.setLayoutY(locy_);
		
	}
	
	public Point2D getLoc(){
		return location;
	}
	public void setLoc(Point2D loc){
		location = loc;
	}
	
	public boolean inCircle(double centerx, double centery, double radius)
	{
		double cx = (centerx - location.getX());
		double cy = (centery - location.getY());
		double square_dist = (cx*cx) + (cy*cy);
		
		
		
		if (square_dist <= (radius*radius))
		{
			pickedup = true;
			return true;
		}
		else
			return false;
	}
}
