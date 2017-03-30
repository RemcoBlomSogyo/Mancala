package nl.sogyo.mancala;

public class Subbakje {
	
	private int inhoud;
	private Subbakje buurman;
	
	public Subbakje() {
		inhoud = 4;
		buurman = new Subbakje(5);
	}
	
	public Subbakje(int counter) {
		inhoud = 4;
		if (counter > 1) {
			buurman = new Subbakje(counter - 1);
		} /*else {
			buurman = new Kalaha();
		}*/
	}
	
	public int getInhoud() {
		return inhoud;
	}
	
	public Subbakje getBuurman() {
		return buurman;
	}
	
	public void startBeurt() {
		int hand = haalLeeg();
		buurman.geefDoor(hand);
	}
	
	public void voegSteenToe() {
		inhoud++;
	}
	
	private int haalLeeg() {
		int hand = inhoud;
		inhoud = 0;
		return hand;
	}
	
	public void geefDoor(int hand) {
		voegSteenToe();
		if (hand > 1) {
			buurman.geefDoor(hand - 1);
		}
	}
}
