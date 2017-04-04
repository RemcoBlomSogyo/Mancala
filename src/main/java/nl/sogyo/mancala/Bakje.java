package nl.sogyo.mancala;

// super class voor subbakje en kalaha
public abstract class Bakje {

	protected int inhoud;
	protected Bakje buurman;
	protected Speler eigenaar;
	
	public int getInhoud() {
		return inhoud;
	}
	
	public Bakje getBuurman() {
		return buurman;
	}
	
	public Speler getEigenaar() {
		return eigenaar;
	}
	
	// voeg een steentje toe aan de inhoud van het bakje
	public void voegSteenToe() {
		inhoud++;
	}
	
	public abstract void geefDoor(int hand, Speler eigenaarHand);

	public abstract void geefKalaha(int hand);
}
