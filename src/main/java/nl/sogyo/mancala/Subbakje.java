package nl.sogyo.mancala;

public class Subbakje extends Bakje{
	
	public Subbakje() {
		inhoud = 4;
		eigenaar = new Speler(1);
		buurman = new Subbakje(5, 2, this, eigenaar);
	}
	
	public Subbakje(int subbakjeCounter, int kalahaCounter, Subbakje eersteBakje, Speler eigenaar) {
		inhoud = 4;
		this.eigenaar = eigenaar; 
		
		if (subbakjeCounter > 1) {
			buurman = new Subbakje(subbakjeCounter - 1, kalahaCounter, eersteBakje, eigenaar);
		} else {
			buurman = new Kalaha(kalahaCounter - 1, eersteBakje, eigenaar);
		}
	}
	
	public Subbakje(int inhoud, boolean zelfInhoudBepalen) {
		this.inhoud = inhoud;
		eigenaar = new Speler(1);
		buurman = new Subbakje(5, 2, this, eigenaar);
	}
	
	public void startBeurt() {
		int hand = haalLeeg();
		Speler eigenaarHand = getEigenaar();
		buurman.geefDoor(hand, eigenaarHand);
	}
	
	public void startBeurt(int bakje) {
		if (bakje != 1) {
			buurman.startBeurt(bakje - 1);
		}
		int hand = haalLeeg();
		Speler eigenaarHand = getEigenaar();
		buurman.geefDoor(hand, eigenaarHand);
	}
	
	public int haalLeeg() {
		int hand = inhoud;
		inhoud = 0;
		return hand;
	}
	
	public void geefDoor(int hand, Speler eigenaarHand) {
		voegSteenToe();
		if (hand > 1) {
			buurman.geefDoor(hand - 1, eigenaarHand);
		} else if (eigenaarHand == this.getEigenaar() && this.inhoud == 1) {
			steelInhoudOverbuurman(this.haalLeeg(), this.eigenaar, 0, false, false);
		}
	}
	
	public void steelInhoudOverbuurman(int hand, Speler eigenaarHand, int stappen, boolean kalahaGevonden, boolean inhoudGestolen) {
		if (!kalahaGevonden) {
			buurman.steelInhoudOverbuurman(hand, eigenaarHand, stappen + 1, kalahaGevonden, inhoudGestolen);
		} else if (inhoudGestolen) {
			buurman.steelInhoudOverbuurman(hand, eigenaarHand, stappen, kalahaGevonden, inhoudGestolen);
		} else {
			if (stappen != 0) {
				buurman.steelInhoudOverbuurman(hand, eigenaarHand, stappen - 1, kalahaGevonden, inhoudGestolen);
			} else {
				hand = this.haalLeeg();
				buurman.steelInhoudOverbuurman(hand, eigenaarHand, stappen, kalahaGevonden, true);
			}
		}
	}
}
