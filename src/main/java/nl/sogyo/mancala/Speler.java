package nl.sogyo.mancala;

public class Speler {
	
	private boolean beurt;
	
	public Speler(boolean beurt) {
		this.beurt = beurt;
	}
	
	public boolean getBeurt() {
		return beurt;
	}
	
	// verwijder of voeg de beurt toe van de speler
	public void wisselBeurt() {
		if (beurt) {
			this.beurt = false;
		} else {
			this.beurt = true;
		}
	}
}
