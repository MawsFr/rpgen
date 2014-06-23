package vue.editeur.tileset;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JDialog;

import modele.editeur.EditeurModele;
import modele.editeur.TileSetModele;
import modele.map.TileModele;
import vue.editeur.map.MapFrame;

public class TileSetFrame extends JDialog {
	
	public static final int WIDTH = TileSetModele.WIDTH * TileModele.WIDTH;
	public static final int HEIGHT = TileSetModele.HEIGHT * TileModele.HEIGHT;
	
	private TileSetFigure tileSet;
	
	public TileSetFrame(MapFrame editeurFrame) {
		super(editeurFrame, "TileSet");
		this.tileSet = new TileSetFigure(editeurFrame);
		this.setContentPane(tileSet);
		
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
		
		this.setLocation(100, 100);
		
	}
	
	public TileSetFigure getTileSet() {
		return tileSet;
	}
	
	

}
