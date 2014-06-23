package modele.editeur;

import java.util.Observable;

import javax.swing.ImageIcon;

import modele.map.Coordonnees;
import modele.map.TileModele;

public class TileSetModele extends Observable {
	
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;

	
	private String pathFile;
	private TileModele[][] tileSet;
	
	private TileModele currentTile;
	
	public TileSetModele() {
		this.tileSet = new TileModele[WIDTH][HEIGHT];
		this.currentTile = new TileModele(new Coordonnees(0, 0));
		init();
		
	}
	
	private void init() {
		for(int i = 0; i < WIDTH; i++) {
			for(int j = 0; j < HEIGHT; j++) {
				this.tileSet[i][j] = new TileModele(new Coordonnees(i, j));
			}
		}
		
	}
	
	public TileModele getTile(int x, int y) {
		if(x < 0 || x >= TileSetModele.WIDTH || y < 0 || y >= TileSetModele.HEIGHT) {
			return null;
		}
		return this.tileSet[x][y];
	}
	
	
	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
		setChanged();
		notifyObservers();
		
	}
	
	public void setCurrentTile(int x, int y) {
		if(x < 0 || x >= TileSetModele.WIDTH || y < 0 || y >= TileSetModele.HEIGHT) {
			return;
		}
		
		this.currentTile.getCoordonnees().setX(x);
		this.currentTile.getCoordonnees().setY(y);
		
		System.out.println("current tile [" + currentTile.getCoordonnees().getX() + "," + currentTile.getCoordonnees().getY()+ "]");
		
	}
	
	public TileModele getCurrentTile() {
		System.out.println(currentTile);
		return this.tileSet[currentTile.getCoordonnees().getX()][currentTile.getCoordonnees().getY()];
		
		
	}
}
