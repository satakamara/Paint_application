import javax.swing.*;
import java.awt.*;

public class Cercle extends Ellipse{
	protected int grand_axe;
	protected int petit_axe;
	
	public Cercle(int ga, int pa, Color c){
		super(new Point(ga,pa), c);
	}
	
	public Cercle(Point a, Color couleur){
	    	 super(a, couleur);
	}
	
	public void setBoundingBox(int hauteurBB, int largeurBB){
		this.grand_axe = hauteurBB;
		this.petit_axe = hauteurBB;
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval(this.origine.getX(), this.origine.getY(), this.petit_axe, this.grand_axe);
	}
	
	
	public int getGrandAxe(){
		return this.grand_axe;
	}
	
	public void setGrandAxe(int ga){
		this.grand_axe = ga;
	}
	
}

