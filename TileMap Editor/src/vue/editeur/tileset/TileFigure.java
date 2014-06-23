package vue.editeur.tileset;

import java.awt.image.BufferedImage;

import modele.map.TileModele;

public class TileFigure {

	private TileModele modele;
	private BufferedImage image;
	
	public TileFigure(TileModele modele, BufferedImage image) {
		this.modele = modele;
		this.image = image;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public String toString() {
		return "Tile n° : " + modele.getCoordonnees() + " image : " + image;
	}

	public TileModele getModele() {
		return modele;
	}
	
	
	
	
	
	
}
