import java.lang.Math;
import javax.swing.*;
import java.awt.*;

public class Ellipse extends Figure{
	protected int grand_axe;
	protected int petit_axe;
	
	public Ellipse(int ga, int pa, Color c){
		super(new Point(ga,pa), c);
		//this.grand_axe = ga;
		//this.petit_axe = pa;
	}
	
	public Ellipse(Point a, Color couleur){
	    	 super(a, couleur);
	}
	
	public void setBoundingBox(int hauteurBB, int largeurBB){
		this.grand_axe = hauteurBB;
		this.petit_axe = largeurBB;
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval(this.origine.getX(), this.origine.getY(), this.petit_axe, this.grand_axe);
	}
	
	public double getPerimetre(){
		return 2*Math.PI* Math.sqrt((Math.pow(this.grand_axe,2)+Math.pow(this.petit_axe,2))/2);
	}
	
	public double getSurface(){
		return ((Math.PI*this.grand_axe*this.petit_axe)/4);
	}
	
	public int getGrandAxe(){
		return this.grand_axe;
	}

	public int getPetitAxe(){
		return this.petit_axe;
	}
	
	public void setGrandAxe(int ga){
		this.grand_axe = ga;
	}
	
	public void setPetitAxe(int pa){
		this.petit_axe = pa;
	}
}
