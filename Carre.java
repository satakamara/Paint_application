import javax.swing.*;
import java.awt.*;

public class Carre extends Rectangle{
	protected int largeur;
	protected int longueur;
	
	public Carre(int a, int b, Color c){
		super(new Point(a,b), c);
	}
	
	public Carre(Point a, Color couleur){
	    	 super(a, couleur);
	}
	
	public void setBoundingBox(int hauteurBB, int largeurBB){
		this.longueur = hauteurBB;
		this.largeur = hauteurBB;
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(this.origine.getX(), this.origine.getY(), this.longueur, this.largeur);
	}
	
	public int getLargeur(){
		return this.largeur;
	}
	
	public void setLargeur(int l){
		this.largeur = l;
	}
	
}


