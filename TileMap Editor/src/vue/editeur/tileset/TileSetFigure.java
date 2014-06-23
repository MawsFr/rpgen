package vue.editeur.tileset;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import modele.editeur.TileSetModele;
import modele.map.Coordonnees;
import modele.map.TileModele;
import sun.swing.SwingUtilities2;
import vue.editeur.map.MapFrame;

public class TileSetFigure extends JPanel implements Observer{

	private static int zoom = 2;
	private TileSetModele tileSetModele;
	private TileFigure[][] tiles;

	private MapFrame editeurFrame;

	public TileSetFigure(MapFrame editeurFrame) {
		this.editeurFrame = editeurFrame;
		this.tileSetModele = editeurFrame.getModele().getTileSet();
		this.tileSetModele.addObserver(this);
		this.tiles = new TileFigure[TileSetModele.WIDTH][TileSetModele.HEIGHT];

		this.addMouseListener(mouseListener);
//		this.addMouseWheelListener(mouseListener);
		
		this.setMinimumSize(new Dimension(TileSetFrame.WIDTH*zoom, TileSetFrame.HEIGHT*zoom));
		this.setPreferredSize(getMinimumSize());
		


	}

	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		for(int i = 0; i < TileSetModele.WIDTH; i++) {
			for(int j = 0; j < TileSetModele.HEIGHT; j++) {
				g.drawImage(this.tiles[i][j].getImage(), i*TileModele.WIDTH*zoom, j*TileModele.HEIGHT*zoom, TileModele.WIDTH*zoom, TileModele.HEIGHT*zoom, null);
			}
		}
		
		paintCurrentSelection(g2d);
		
	}
	
	private void paintCurrentSelection(Graphics2D g) {
		Coordonnees select = tileSetModele.getCurrentTile().getCoordonnees();
		int i = select.getX();
		int j = select.getY();
		
		
		g.setColor(Color.RED);
		g.setStroke(new BasicStroke(zoom));
		g.drawRect(i*TileModele.WIDTH*zoom, j*TileModele.HEIGHT*zoom, TileModele.WIDTH*zoom, TileModele.HEIGHT*zoom);
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(zoom/2));
		g.drawRect(i*TileModele.WIDTH*zoom, j*TileModele.HEIGHT*zoom, TileModele.WIDTH*zoom, TileModele.HEIGHT*zoom);
	}

	public TileSetModele getModele() {
		return this.tileSetModele;
	}

	
	public TileSetModele getTileSetModele() {
		return tileSetModele;
	}

	public TileFigure[][] getTiles() {
		return tiles;
	}

	public void update(Observable arg0, Object arg1) {

		File fichier = new File(tileSetModele.getPathFile());
		BufferedImage chipset = null;
		try {
			chipset = ImageIO.read(fichier);
			System.out.println("TileSet Loaded !");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(chipset != null) {
			for(int i = 0; i < TileSetModele.WIDTH; i++) {
				for(int j = 0; j < TileSetModele.HEIGHT; j++) {
					TileFigure tile = new TileFigure(this.tileSetModele.getTile(i, j), 
							chipset.getSubimage(i*TileModele.WIDTH, j*TileModele.HEIGHT, TileModele.WIDTH, TileModele.HEIGHT));
					
					this.tiles[i][j] = tile;
				}
			}
		}
		
		tileSetModele.setCurrentTile(0,0);
		repaint();
	}
	
	private MouseAdapter mouseListener = new MouseAdapter() {
		
		public void mousePressed(MouseEvent e) {
			int x = e.getPoint().x / TileModele.WIDTH / zoom;
			int y = e.getPoint().y / TileModele.HEIGHT / zoom;
			
			System.out.println("Cliqué à :" + x + " " + y);
			
			tileSetModele.setCurrentTile(x, y);
			
			repaint();
		}
		
//		public void mouseWheelMoved(MouseWheelEvent e) {
//			if(e.isControlDown()) {
//				if(e.getWheelRotation() <= 0) {
//					zoom -= 1;
//					
//				} else {
//					zoom += 1;
//				}
//				
//			}
//			
//			if(zoom < 1) {
//				zoom = 1;
//			}
//			
//			if(zoom > 10) {
//				zoom = 10;
//			}
//			
//			repaint();
//			ajustWindow();
//		}
	};

//	protected void ajustWindow() {
//		this.setMinimumSize(new Dimension(TileSetFrame.WIDTH*zoom, TileSetFrame.HEIGHT*zoom));
//		this.setPreferredSize(getMinimumSize());
//		editeurFrame.getFenetreTileSet().pack();
//	}


}
