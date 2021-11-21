import javax.swing.*;
import java.awt.*;
import java.io.*;

class Point implements Serializable{
	
	private int x;
	private int y;

/**
* Construit un point de coordonnees (a, b)
*
* @param a abscisse du point
* @param b ordonnée du point
*/
	public Point(int a, int b){
		this.x = a;
		this.y = b;
	}
/**
* Construit un point de coordonnees (0, 0)
*/
	public Point(){
		this.x = 0;
		this.y = 0;
	}
/**
* retourne l'abscisse du point
*/
	public int getX(){
		return this.x;
	}
/**
* retourne l'ordonnee du point
*/
	public int getY(){
		return this.y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
}
