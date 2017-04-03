package nl.sogyo.mancala;

public abstract class Bakje {

	protected int inhoud;
	protected Bakje buurman;
	protected int eigenaar;
	
	public int getInhoud() {
		return inhoud;
	}
	
	public Bakje getBuurman() {
		return buurman;
	}
	
	public int getEigenaar() {
		return eigenaar;
	}
	
	public void voegSteenToe() {
		inhoud++;
	}
	
	public void geefDoor(int hand, int eigenaarHand) {
		if (!(this instanceof Kalaha) || eigenaar == eigenaarHand) {
			voegSteenToe();
			if (hand > 1) {
				buurman.geefDoor(hand - 1, eigenaarHand);
			}
		} else {
			buurman.geefDoor(hand, eigenaarHand);
		}

	}
}
