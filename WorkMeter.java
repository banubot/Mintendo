import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class WorkMeter extends Rectangle {

	int width, height, x, y;
	int score;
	public WorkMeter(int x_, int y_, int width_, int height_)
	{
		super(x_, y_, width_, height_);
		this.setFill(Color.RED);
		score = 5;
		width = width_;
		height = height_;
		x = x_;
		y = y_;
	}
	
	public void update()
	{
		double rand = Math.random();
		if(width > 5 && rand<0.1)
		{
			this.setWidth(width - 0.001);
			width -= 0.001;
			score -= 0.001;
		}
	}
	
	public void addWork(int work)
	{
		this.setWidth(width+work);
		width += work;
		score += work;
	}
}
