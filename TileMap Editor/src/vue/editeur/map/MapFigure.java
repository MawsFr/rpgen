package vue.editeur.map;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import vue.editeur.tileset.TileFigure;
import vue.editeur.tileset.TileSetFigure;
import modele.editeur.TileSetModele;
import modele.map.Coordonnees;
import modele.map.MapModele;
import modele.map.TileModele;

public class MapFigure extends JPanel implements Observer {

	private TileSetFigure tileSet;
	private MapModele mapModele;
	private MapFrame editeur;

	public MapFigure(MapFrame editeur) {
		this.editeur = editeur;
		this.tileSet = editeur.getFenetreTileSet().getTileSet();
		this.mapModele = editeur.getModele().getCurrentMap();
		this.mapModele.addObserver(this);
		
		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(mouseListener);

		this.setPreferredSize(new Dimension(mapModele.getWIDTH()*TileModele.WIDTH, mapModele.getHEIGHT()*TileModele.HEIGHT));
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		for(int i = 0; i < mapModele.getWIDTH(); i++) {
			for(int j = 0; j < mapModele.getHEIGHT(); j++) {
				TileModele tile = mapModele.getTile(i, j);
				Coordonnees c = tile.getCoordonnees();
				int x = c.getX();
				int y = c.getY();
				TileFigure figure = tileSet.getTiles()[x][y];
				g.drawImage(figure.getImage(), i*TileModele.WIDTH, j*TileModele.HEIGHT, TileModele.WIDTH, TileModele.HEIGHT, null);
			}
		}
	}
	
	
	public void update(Observable arg0, Object arg1) {
		repaint();
		
	}
	
	
	
	public MapModele getModele() {
		return this.mapModele;
	}
	
	private MouseAdapter mouseListener = new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
			int x = e.getPoint().x / TileModele.WIDTH;
			int y = e.getPoint().y / TileModele.HEIGHT;
			
			System.out.println("Cliqué à :" + x + " " + y);
			mapModele.setTile(tileSet.getTileSetModele().getCurrentTile(), x, y);
		}
		
		public void mouseDragged(MouseEvent e) {
			//TODO : Optimisation : on retient les ancienne coordonnées et si elle on changé la on repaint !
			mousePressed(e);
		}
	};
}
