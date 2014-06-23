package vue.editeur.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controleur.menu.fichier.QuitterAction;

public class MenuPrincipal extends JMenuBar{
	
	private JMenu menuFichier;
	private JMenuItem menuQuitter;
	
	public MenuPrincipal() {
		this.menuFichier = new JMenu("Fichier");
		this.menuQuitter = new JMenuItem(new QuitterAction());
		
		this.menuFichier.add(menuQuitter);
		this.add(menuFichier);
		
	}

}
