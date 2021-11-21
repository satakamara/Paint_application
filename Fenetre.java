import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Iterator;

class Fenetre extends JFrame implements ActionListener{
	
	private Dessin dessin;
	
	public Fenetre(String titre){
		super(titre);
		
		//Création de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(0,200);
		setSize(1000,500);
		
		//Création du panneau
		Container contentPane = getContentPane();
		
		//Création du menu et des raccourcis (code réorganisé en fonction des différents onglets)
		JMenuBar m = new JMenuBar();
		//
		JMenu fichiers = new JMenu("Fichiers");
		//
		JMenuItem nouveau = new JMenuItem("Nouveau");
		fichiers.add(nouveau);
		nouveau.addActionListener(this);
		nouveau.setAccelerator(KeyStroke.getKeyStroke('N',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
		//
		JMenuItem ouvrir = new JMenuItem("Ouvrir");
		fichiers.add(ouvrir);
		ouvrir.addActionListener(this);
		ouvrir.setAccelerator(KeyStroke.getKeyStroke('O',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
		//
		JMenuItem enregistrer = new JMenuItem("Enregistrer");
		fichiers.add(enregistrer);
		enregistrer.addActionListener(this);
		enregistrer.setAccelerator(KeyStroke.getKeyStroke('S',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
		//
		fichiers.addSeparator();
		//
		JMenuItem quitter = new JMenuItem("Quitter") ;
		fichiers.add(quitter);
		quitter.addActionListener(this);
		quitter.setAccelerator(KeyStroke.getKeyStroke('Q',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
		//
		JMenuItem importer = new JMenuItem("Importer") ;
		fichiers.add(importer);
		importer.addActionListener(this);
		importer.setAccelerator(KeyStroke.getKeyStroke('I',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
		//
        JMenuItem exporter = new JMenuItem("Exporter") ;
        fichiers.add(exporter);
        exporter.addActionListener(this);
        exporter.setAccelerator(KeyStroke.getKeyStroke('E',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
        //
        JMenuItem exportertxt = new JMenuItem("Exporter en txt") ;
        fichiers.add(exportertxt);
        exportertxt.addActionListener(this);
        exportertxt.setAccelerator(KeyStroke.getKeyStroke('J',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
        //
        JMenuItem importertxt = new JMenuItem("Importer en txt") ;
        fichiers.add(importertxt);
        importertxt.addActionListener(this);
        importertxt.setAccelerator(KeyStroke.getKeyStroke('K',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(),false));
        //
		m.add(fichiers);
		//
		JMenu apropos = new JMenu("A propos");
		apropos.add(new JMenuItem("Auteurs"));
		m.add(apropos);
		setJMenuBar(m);
		
		//Création de la zone de texte au centre puis de la zone de dessin
		contentPane.add(new JTextArea(),"Center");
		dessin = new Dessin();
		contentPane.add(dessin, "Center");
		
		//Création des boutons
		JPanel panneaux = new JPanel();
		JPanel panneauCouleur = new JPanel();
		JPanel panneauOutil = new JPanel();
		panneaux.setLayout(new GridLayout(1,2));
		panneauCouleur.setLayout(new GridLayout(2,4));
		panneauOutil.setLayout(new GridLayout(2,2));
		panneaux.add(panneauCouleur);
		panneaux.add(panneauOutil);
		//
		JButton noir = new JButton("Noir");
		noir.setBackground(Color.black);
		panneauCouleur.add(noir);
		noir.addActionListener(this);
		//
		JButton rouge = new JButton("Rouge");
		rouge.setBackground(Color.red);
		panneauCouleur.add(rouge);
		rouge.addActionListener(this);
		//
		JButton vert = new JButton("Vert");
		vert.setBackground(Color.green);
		panneauCouleur.add(vert);
		vert.addActionListener(this);
		//
		JButton bleu = new JButton("Bleu");
		bleu.setBackground(Color.blue);
		panneauCouleur.add(bleu);
		bleu.addActionListener(this);
		//
		JButton jaune = new JButton("Jaune");
		jaune.setBackground(Color.yellow);
		panneauCouleur.add(jaune);
		jaune.addActionListener(this);
		//
		JButton rose = new JButton("Rose");
		rose.setBackground(Color.pink);
		panneauCouleur.add(rose);
		rose.addActionListener(this);
		//
		JButton magenta = new JButton("Magenta");
		magenta.setBackground(Color.magenta);
		panneauCouleur.add(magenta);
		magenta.addActionListener(this);
		//
		JButton orange = new JButton("Orange");
		orange.setBackground(Color.orange);
		panneauCouleur.add(orange);
		orange.addActionListener(this);
		//
		JButton ellipse = new JButton("Ellipse");
		panneauOutil.add(ellipse);
		ellipse.addActionListener(this);
		//
		JButton cercle = new JButton("Cercle");
		panneauOutil.add(cercle);
		cercle.addActionListener(this);
		//
		JButton carre = new JButton("Carre");
		panneauOutil.add(carre);
		carre.addActionListener(this);
		//
		JButton rectangle = new JButton("Rectangle");
		panneauOutil.add(rectangle);
		rectangle.addActionListener(this);
        //
		contentPane.add(panneaux, "South");

		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Rectangle")) {
			dessin.changementFigure("Rectangle");
			System.out.println("Tu as appuye sur " + cmd);
		}
		else if(cmd.equals("Cercle")) {
			System.out.println("Tu as appuye sur " + cmd);
			dessin.changementFigure("Cercle");
		}
		else if(cmd.equals("Carre")) {
			System.out.println("Tu as appuye sur " + cmd);
			dessin.changementFigure("Carre");
		}
		else if(cmd.equals("Ellipse")) {
			System.out.println("Tu as appuye sur " + cmd);
			dessin.changementFigure("Ellipse");
		}
		else if(cmd.equals("Rouge")) {
			System.out.println("Tu as appuye sur " + cmd);
			dessin.changementCouleur(Color.red);
		}
		else if(cmd.equals("Noir")) {
			System.out.println("Tu as appuye sur " + cmd);
			dessin.changementCouleur(Color.black);
		}
		else if(cmd.equals("Magenta")) {
			System.out.println("Tu as appuye sur " + cmd);
			dessin.changementCouleur(Color.magenta);
		}
		else if(cmd.equals("Jaune")) {
			System.out.println("Tu as appuye sur " + cmd);
			dessin.changementCouleur(Color.yellow);
		}
		else if(cmd.equals("Bleu")) {
			System.out.println("Tu as appuye sur " + cmd);
			dessin.changementCouleur(Color.blue);
		}
		else if(cmd.equals("Vert")) {
			System.out.println("Tu as appuye sur " + cmd);
			dessin.changementCouleur(Color.green);
		}
		else if(cmd.equals("Rose")) {
			System.out.println("Tu as appuye sur " + cmd);
			dessin.changementCouleur(Color.pink);
		}
		else if(cmd.equals("Orange")) {
			System.out.println("Tu as appuye sur " + cmd);
			dessin.changementCouleur(Color.orange);
			//Ces System.out permettent de vérifier le changement de la
			//couleur et de la figure
			//System.out.println(dessin.c);
			//System.out.println(dessin.nomFigure);
		} 
		else if(cmd.equals("Auteurs")){ 
			JOptionPane Author = new JOptionPane();
			Author.showMessageDialog(this, "Developpe par Sata KAMARA", "Auteurs", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(cmd.equals("Quitter")) {
			System.exit(0);
		}
		else if(cmd.equals("Nouveau")){
			dessin.getliste().clear();
			repaint();
		}
		else if(cmd.equals("Exporter")){
			try{
				FileOutputStream fos = new FileOutputStream("Dessin.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(dessin);
				oos.close();
			}
			catch(Exception except){
				System.out.println(except.toString());
			}
		}
		else if(cmd.equals("Importer")){
			try{
				Dessin dessin2 = new Dessin();
				FileInputStream fis = new FileInputStream("Dessin.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				dessin2 = (Dessin) ois.readObject();
				dessin.liste = dessin2.liste;
				ois.close();
				repaint();
			}
			catch(Exception except2){
				System.out.println(except2.toString());
			}
		}
		else {
			System.err.println(cmd);
		}
	}
}


