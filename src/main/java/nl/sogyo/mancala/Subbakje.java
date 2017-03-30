package nl.sogyo.mancala;

public class Subbakje extends Bakje{
	
	public Subbakje() {
		inhoud = 4;
		buurman = new Subbakje(5, 2);
	}
	
	public Subbakje(int subbakjeCounter, int kalahaCounter) {
		inhoud = 4;
		if (subbakjeCounter > 1) {
			buurman = new Subbakje(subbakjeCounter - 1, kalahaCounter);
		} else {
			buurman = new Kalaha(kalahaCounter - 1);
		}
	}
	
	public Subbakje(int inhoud, boolean zelfInhoudBepalen) {
		this.inhoud = inhoud;
		buurman = new Subbakje(5, 2);
	}
	
	/*public Subbakje(boolean gelimiteerdBuurmannenMakenNaKalaha, int counter) {
		inhoud = 4;
		if (counter > 0) {
			buurman = new Subbakje(true, counter - 1);
		} else {
			buurman = new Kalaha();
		}
	}*/
	
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
