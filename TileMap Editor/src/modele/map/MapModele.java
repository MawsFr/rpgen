package modele.map;

import java.util.Observable;

import modele.editeur.EditeurModele;

public class MapModele extends Observable {

	private int WIDTH;
	private int HEIGHT;
	
	private EditeurModele editeur;
	private TileModele[][] map;
	
	public MapModele(EditeurModele editeurModele, int width, int height) {
		this.editeur = editeurModele;
		this.WIDTH = width;
		this.HEIGHT = height;
		this.map = new TileModele[WIDTH][HEIGHT];
		init();
	}
	
	private void init() {
		for(int i = 0; i < WIDTH; i++) {
			for(int j = 0; j < HEIGHT; j++) {
				map[i][j] = editeur.getTileSet().getTile(i % 10, j%10);
			}
		}
	}
	
	public void setTile(TileModele tile, int x, int y) {
		if(x < 0 || x >= this.WIDTH || y < 0 || y >= this.HEIGHT) {
			return;
		}
		
		this.map[x][y] = tile;
		setChanged();
		notifyObservers();
	}
	
	public TileModele getTile(int x, int y) {
		if(x < 0 || x >= this.WIDTH || y < 0 || y >= this.HEIGHT) {
			return null;
		}
		return this.map[x][y];
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}
	
	
}
