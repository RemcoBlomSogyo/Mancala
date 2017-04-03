package nl.sogyo.mancala;

public class Subbakje extends Bakje{
	
	public Subbakje() {
		inhoud = 4;
		buurman = new Subbakje(5, 2, this);
		eigenaar = 1;
	}
	
	public Subbakje(int subbakjeCounter, int kalahaCounter, Subbakje eersteBakje) {
		inhoud = 4;
		if (kalahaCounter == 2) {
			eigenaar = 1;
		} else {
			eigenaar = 2;
		}
		
		if (subbakjeCounter > 1) {
			buurman = new Subbakje(subbakjeCounter - 1, kalahaCounter, eersteBakje);
		} else {
			buurman = new Kalaha(kalahaCounter - 1, eersteBakje);
		}
	}
	
	public Subbakje(int inhoud, boolean zelfInhoudBepalen) {
		this.inhoud = inhoud;
		buurman = new Subbakje(5, 2, this);
		eigenaar = 1;
	}
	
	public void startBeurt() {
		int hand = haalLeeg();
		int eigenaarHand = getEigenaar();
		buurman.geefDoor(hand, eigenaarHand);
	}
	
	private int haalLeeg() {
		int hand = inhoud;
		inhoud = 0;
		return hand;
	}
}
