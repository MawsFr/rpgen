package modele.map;

public class TileModele {
	
	public static final int WIDTH = 16;
	public static final int HEIGHT = 16;
	
	private Coordonnees value;
	
	public TileModele(Coordonnees value) {
		this.value = value;
	}

	public Coordonnees getCoordonnees() {
		return value;
	}

	public void setCoordonnees(Coordonnees value) {
		this.value = value;
	}
	
	
}
