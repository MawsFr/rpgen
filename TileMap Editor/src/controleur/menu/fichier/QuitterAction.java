package controleur.menu.fichier;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class QuitterAction extends AbstractAction {
	
	public QuitterAction() {
		this.putValue(NAME, "Quitter");
	}
	
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
