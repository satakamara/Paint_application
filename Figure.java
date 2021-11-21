import javax.swing.*;
import java.awt.*;
import java.io.*;

public abstract class Figure extends JPanel implements Serializable{
	
	protected Point origine;
	protected Color c;
	
	public Figure(Point p, Color co){
		this.origine = p;
		this.c = co;
	}
	/**
	* @return perimetre de la figure
	*/
	public abstract double getPerimetre();
	/**
	* @return surface de la figure
	*/
	public abstract double getSurface(); 
	
	public abstract void setBoundingBox(int hauteurBB, int largeurBB);
	
	public abstract void draw(Graphics g);
	
	/*public String toString(){
		return p.getX()+" "+p.getY();
	}*/
}

