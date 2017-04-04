package nl.sogyo.mancala;

public class Kalaha extends Bakje{
	
	public Kalaha(int kalahaCounter, Subbakje eersteBakje, Speler eigenaar) {
		inhoud = 0;
		this.eigenaar = eigenaar;
		
		if (kalahaCounter > 0) {
			buurman = new Subbakje(6, kalahaCounter, eersteBakje, new Speler(false));
		} else {
			buurman = eersteBakje;
		}
	}
	
	public void geefDoor(int hand, Speler eigenaarHand) {
		if (eigenaar == eigenaarHand) {
			voegSteenToe();
			if (hand > 1) {
				buurman.geefDoor(hand - 1, eigenaarHand);
			}
		} else {
			buurman.geefDoor(hand, eigenaarHand);
		}
	}
		
	public void steelInhoudOverbuurman(int hand, Speler eigenaarHand, int stappen, boolean kalahaGevonden, boolean inhoudGestolen) {
		if (!inhoudGestolen) {
			this.inhoud++;
			buurman.steelInhoudOverbuurman(0, eigenaarHand, stappen - 1, true, inhoudGestolen);
		} else if (eigenaarHand == this.getEigenaar()) {
			inhoud += hand;
			//this.getEigenaar().wisselBeurt();
			//this.getBuurman().getEigenaar().wisselBeurt();
		} else {
			buurman.steelInhoudOverbuurman(hand, eigenaarHand, stappen, kalahaGevonden, inhoudGestolen);
		}
	}
	
	public void geefKalaha(int hand) {
		inhoud += hand;
	}
}