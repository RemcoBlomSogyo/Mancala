package nl.sogyo.mancala;

public class Speler {
	
	private boolean beurt;
	
	public Speler(boolean beurt) {
		this.beurt = beurt;
	}
	
	public void wisselBeurt() {
		if (beurt) {
			this.beurt = false;
		} else {
			this.beurt = true;
		}
	}
}
