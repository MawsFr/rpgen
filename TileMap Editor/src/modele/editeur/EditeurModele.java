package modele.editeur;

import modele.map.MapModele;

public class EditeurModele {
	
	private TileSetModele tileSet;
	private MapModele currentMap;
	
	public EditeurModele() {
		this.tileSet = new TileSetModele();
		this.currentMap = new MapModele(this, 30, 30);
		
	}

	public TileSetModele getTileSet() {
		return tileSet;
	}

	public MapModele getCurrentMap() {
		return currentMap;
	}

	public void setCurrentMap(MapModele currentMap) {
		this.currentMap = currentMap;
	}
	
	


}
