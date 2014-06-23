package vue.editeur.map;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import vue.editeur.menu.MenuPrincipal;
import vue.editeur.tileset.TileSetFigure;
import vue.editeur.tileset.TileSetFrame;
import modele.editeur.EditeurModele;
import modele.editeur.TileSetModele;

public class MapFrame extends JFrame {
	
	private EditeurModele modele;
	private TileSetFrame fenetreTileSet;
	private MapFigure mapPanel;
	
	public MapFrame() {
		super("TileMap Editor");
		this.modele = new EditeurModele();
		this.setJMenuBar(new MenuPrincipal());
		
		this.fenetreTileSet = new TileSetFrame(this);
		modele.getTileSet().setPathFile("main.png");
		
		this.mapPanel = new MapFigure(this);
		this.setContentPane(mapPanel);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	
	public EditeurModele getModele() {
		return modele;
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new MapFrame();				
			}
		});
		
	}



	public TileSetFrame getFenetreTileSet() {
		return fenetreTileSet;
	}
	
	

}
