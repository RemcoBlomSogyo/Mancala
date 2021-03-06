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
	
	public Bakje getBuurman(int n) {
		if (n == 1) {
			return buurman;
		} else {
			return buurman.getBuurman(n - 1);
		}
	}
	
	public Speler getEigenaar() {
		return eigenaar;
	}
	
	// voeg een steentje toe aan de inhoud van het bakje
	public void voegSteenToe() {
		inhoud++;
	}
	
	/*
		controleer of de bakjes van de speler leeg zijn
	 */
	public boolean checkBakjesLeeg(Speler speler) {
		Bakje currentBakje = this;
		while (currentBakje.getEigenaar() == speler) {
			currentBakje = currentBakje.getBuurman();
		}
		while (currentBakje.getEigenaar() != speler) {
			currentBakje = currentBakje.getBuurman();
		}	
		for (int i = 0; i < 6; i++) {
			if (currentBakje.getInhoud() != 0) {
				return false;
			}
			currentBakje = currentBakje.getBuurman();
		}
		return true;
	}

	public abstract void geefDoor(int hand, Speler eigenaarHand);

	public abstract void geefKalaha(int hand);
}
