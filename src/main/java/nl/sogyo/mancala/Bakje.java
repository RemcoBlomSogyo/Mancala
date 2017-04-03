package nl.sogyo.mancala;

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
	
	public void voegSteenToe() {
		inhoud++;
	}
	
	public abstract void geefDoor(int hand, Speler eigenaarHand); /*{
		if (!(this instanceof Kalaha) || eigenaar == eigenaarHand) {
			voegSteenToe();
			if (hand > 1) {
				buurman.geefDoor(hand - 1, eigenaarHand);
			} else if (eigenaarHand == this.getEigenaar() && this.inhoud == 1 && (this instanceof Subbakje)) {
				steelInhoudOverbuurman();
			}
		} else {
			buurman.geefDoor(hand, eigenaarHand);
		}

	}*/
	public abstract void steelInhoudOverbuurman(int hand, Speler eigenaarHand, int stappen, boolean kalahaGevonden, boolean inhoudGestolen);
}
