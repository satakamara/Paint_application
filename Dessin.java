import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

class Dessin extends JPanel implements MouseMotionListener, MouseListener, Serializable{
	
	protected ArrayList<Figure> liste;
	Color c;
	String nomFigure;
	int x;
	int y;
	private int X;
	private int Y;


	public Dessin(){
		super();
		c = Color.blue;
		nomFigure = "Rectangle";
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		liste = new ArrayList<Figure>(); 
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.white);
		g.setColor(Color.red);
		g.fillRect(175,40,100,50);
		for(Figure f : liste){
			f.draw(g);
		}
	}

	public void changementCouleur(Color c){
		this.c = c;
	}
	
	public void changementFigure(String nomFigure){
		this.nomFigure = nomFigure;
	}
	
	public ArrayList<Figure> getliste(){
		return liste;
	}
	
	public void setliste(ArrayList<Figure> liste){
		this.liste = liste;
	}
	
	public void mouseDragged(MouseEvent e){
		int dX = e.getX()-X ;
		int dY = e.getY()-Y ;  
		liste.get(liste.size()-1).setBoundingBox(dX,dY);
		repaint();
		//System.out.println("J'ai bougé en étant appuyé");
	}
	
	public void mouseMoved(MouseEvent e){
	}
	
	public void mouseClicked(MouseEvent e){
	}
	
	public void mouseEntered(MouseEvent e){
	}
	
	public void mouseExited(MouseEvent e){
	}
	
	public void mousePressed(MouseEvent e){
		X = e.getX();
		Y = e.getY();
		if(nomFigure.equals("Rectangle")){ 
			liste.add(new Rectangle(X,Y,c));
		}
		else if(nomFigure.equals("Carre")){ 
			liste.add(new Carre(X,Y,c));
		}
		else if(nomFigure.equals("Ellipse")){ 
			liste.add(new Ellipse(X,Y,c));
		}
		else if(nomFigure.equals("Cercle")){ 
			liste.add(new Cercle(X,Y,c)); 
		}
		//System.out.println("J'ai appuye");
	}
	
	public void mouseReleased(MouseEvent e){
		X = e.getX();
		Y = e.getY();  
		int dX = e.getX()-X ;
		int dY = e.getY()-Y ; 
		repaint();
		//System.out.println("J'ai relache");
	}
	
	public void exporter() {
		try {
  			FileOutputStream fos = new FileOutputStream("Dessin.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(liste);
			oos.close();
		}
		catch(Exception err) {
			err.printStackTrace();
			System.out.println("Export failed");
		}
	}

	public void importer() {
		try {
			FileInputStream fis = new FileInputStream("Dessin.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			liste = (ArrayList<Figure>) ois.readObject();
			repaint();			
			ois.close();
		}
		catch(Exception err) {
			err.printStackTrace();
			System.out.println("Import failed");
		}
	}
}






