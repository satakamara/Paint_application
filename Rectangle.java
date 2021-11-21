import javax.swing.*;
import java.awt.*;

public class Rectangle extends Figure{
	protected int largeur;
	protected int longueur;
	
	public Rectangle(int a, int b, Color c){
		super(new Point(a,b), c);
	}
	
	public Rectangle(Point a, Color couleur){
	    	 super(a, couleur);
	}
	
	public void setBoundingBox(int hauteurBB, int largeurBB){
		this.longueur = hauteurBB;
		this.largeur = largeurBB;
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(this.origine.getX(), this.origine.getY(), this.longueur, this.largeur);
	}
	
	public double getPerimetre(){
		return 2*(this.longueur+this.largeur);
	}
	
	public double getSurface(){
		return (this.largeur*this.longueur);
	}
	
	public int getLargeur(){
		return this.largeur;
	}

	public int getLongueur(){
		return this.longueur;
	}
	
	public void setLargeur(int l){
		this.largeur = l;
	}
	
	public void setLongueur(int L){
		this.longueur = L;
	}
	
	public String toString(){
		String a = "+";
		for(int j=1; j<= this.largeur;j++){
			a = a+"--";
		}
		a = a+"+";
		for (int i=1;i<=this.longueur;i++){
			a = a+"\n";
			a = a+"|";
			for(int j=1; j<= this.largeur;j++){
				a = a+"  ";
			}
			a = a+"|";
		}
		a=a+"\n";
		a=a+"+";
		for(int j=1; j<= this.largeur;j++){
			a = a+"--";
		}
		a = a+"+";
		return a;
	}
}
