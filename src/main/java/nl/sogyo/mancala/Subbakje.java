package nl.sogyo.mancala;

public class Subbakje extends Bakje{
	
	public Subbakje() {
		inhoud = 4;
		buurman = new Subbakje(5);
	}
	
	private Subbakje(int counter) {
		inhoud = 4;
		if (counter > 1) {
			buurman = new Subbakje(counter - 1);
		} else {
			buurman = new Kalaha();
		}
	}
	
	public Subbakje(int inhoud, boolean zelfInhoudBepalen) {
		this.inhoud = inhoud;
		buurman = new Subbakje(5);
	}
	
	public Subbakje(boolean gelimiteerdBuurmannenMakenNaKalaha, int counter) {
		inhoud = 4;
		if (counter > 0) {
			buurman = new Subbakje(true, counter - 1);
		}
	}
	
	public void startBeurt() {
		int hand = haalLeeg();
		buurman.geefDoor(hand);
	}
	
	private int haalLeeg() {
		int hand = inhoud;
		inhoud = 0;
		return hand;
	}
}
