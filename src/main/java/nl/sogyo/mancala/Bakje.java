package nl.sogyo.mancala;

public abstract class Bakje {

	protected int inhoud;
	protected Bakje buurman;
	
	public int getInhoud() {
		return inhoud;
	}
	
	public Bakje getBuurman() {
		return buurman;
	}
	
	public void voegSteenToe() {
		inhoud++;
	}
	
	public void geefDoor(int hand) {
		voegSteenToe();
		if (hand > 1) {
			buurman.geefDoor(hand - 1);
		}
	}
}
