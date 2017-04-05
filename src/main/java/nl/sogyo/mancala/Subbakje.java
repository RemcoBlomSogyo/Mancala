package nl.sogyo.mancala;

public class Subbakje extends Bakje{
	
	/*
		constructor eerste subbakje
	*/
	public Subbakje() {
		inhoud = 4;
		eigenaar = new Speler(true);
		buurman = new Subbakje(5, 2, this, eigenaar);
	}
	
	/*
		constructor voor de rest van subbakjes
	*/
	public Subbakje(int subbakjeCounter, int kalahaCounter, Subbakje eersteBakje, Speler eigenaar) {
		inhoud = 4;
		this.eigenaar = eigenaar; 
		
		if (subbakjeCounter > 1) {
			buurman = new Subbakje(subbakjeCounter - 1, kalahaCounter, eersteBakje, eigenaar);
		} else {
			buurman = new Kalaha(kalahaCounter - 1, eersteBakje, eigenaar);
		}
	}
	
	/*
		constructor eerste subbakje waarbij inhoud variabel is
	*/
	public Subbakje(int inhoud, boolean zelfInhoudBepalen) {
		this.inhoud = inhoud;
		eigenaar = new Speler(true);
		buurman = new Subbakje(5, 2, this, eigenaar);
	}
	
	/*
		start de beurt op dit bakje - haal bakje leeg en geef door
	*/
	public void startBeurt() {
		
		// sla de eerste subbakjes en kalaha over als het niet de beurt is van de eerste speler
		if (!this.getEigenaar().getBeurt()) {
			if (buurman instanceof Subbakje) {
				Subbakje subBuurman = (Subbakje) buurman;
				subBuurman.startBeurt();
			} else {
				Subbakje buurmanVanKalaha = (Subbakje) buurman.getBuurman();
				buurmanVanKalaha.startBeurt();
			}
			
		// als het juiste bakje is gevonden en het bakje is niet leeg, haal het bakje leeg en geef de steentjes door
		} else if (inhoud != 0) {
			int hand = this.haalLeeg();
			Speler eigenaarHand = this.getEigenaar();
			buurman.geefDoor(hand, eigenaarHand);
		}
	}
	
	/*
		start de beurt op een bakje - nummer argument is nummer bakje
	*/
	public void startBeurt(int bakje) {
		
		// sla de eerste subbakjes en kalaha over als het niet de beurt is van de eerste speler
		if (!this.getEigenaar().getBeurt()) {
			if (buurman instanceof Subbakje) {
				Subbakje subBuurman = (Subbakje) buurman;
				subBuurman.startBeurt(bakje);
			} else {
				Subbakje buurmanVanKalaha = (Subbakje) buurman.getBuurman();
				buurmanVanKalaha.startBeurt(bakje);
			}
		
		// als speler van het bakje aan de beurt is, ga dan naar het juiste bakje om de beurt te starten
		} else if (bakje != 1) {
			Subbakje subBuurman = (Subbakje) buurman;
			subBuurman.startBeurt(bakje - 1);
			
		// als het juiste bakje is gevonden en het bakje is niet leeg, haal het bakje leeg en geef de steentjes door
		} else if (inhoud != 0) {
			int hand = this.haalLeeg();
			Speler eigenaarHand = this.getEigenaar();
			buurman.geefDoor(hand, eigenaarHand);
		}
	}
	
	/*
		haal bakje leeg en return de inhoud
	*/
	public int haalLeeg() {
		int hand = inhoud;
		inhoud = 0;
		return hand;
	}
	
	/*
	 * haal bakje een aantal steentjes uit bakje - alleen voor testen
	 */
	public int haalLeeg(int steentjes) {
		int hand = steentjes;
		inhoud -= steentjes;
		return hand;
	}
	
	/*
		doorgeven van de hand aan buurman, bij ontvangst doe een steentje in bakje
	*/
	public void geefDoor(int hand, Speler eigenaarHand) {
		voegSteenToe();
		
		// geef hand aan buurman door als de hand nog steentjes heeft
		if (hand > 1) {
			buurman.geefDoor(hand - 1, eigenaarHand);
		
		// als de hand geen steentjes meer heeft om door te geven en het bakje was leeg en van de eigen speler, steel dan de steentjes van de overbuurman
		} else if (eigenaarHand == this.getEigenaar() && this.inhoud == 1) {
			Subbakje overbuurman = (Subbakje) getOverbuurman();
			hand = overbuurman.haalLeeg();
			hand += this.haalLeeg();
			this.geefKalaha(hand);
			
		// de beurt is voorbij en moet gewisseld worden. De speler die aan de beurt was wordt sowieso op false gezet.
		} else {
			eigenaarHand.wisselBeurt();
			
			// of de andere speler op true gaat, hangt af of zijn bakjes nog gevuld zijn
			// controleer of einde bakje eigen bakje is
			if (this.getEigenaar() == eigenaarHand) {
				if (!checkBakjesLeeg(this.getOverbuurman().getEigenaar())) {
					this.getOverbuurman().getEigenaar().wisselBeurt();
				}
			// anders is einde bakje het bakje van tegenstander
			} else {
				if (!checkBakjesLeeg(this.getEigenaar())) {
					this.getEigenaar().wisselBeurt();
				}
			}
		}
	}
	
	/*
	 	geef de hand door richting kalaha - als buurman subbakje is geef de hand door
	*/
	public void geefKalaha(int hand) {
		buurman.geefKalaha(hand);
	}
	
	/*
		krijg het overbuurman-subbakje van dit subbakje
	*/
	public Bakje getOverbuurman() {
		int stappen = 0;
		Bakje currentBakje = this;
		Speler eigenaar = this.getEigenaar();
		
		// loop eerst alle eigen bakjes af en tel elke stap op
		while (currentBakje.getBuurman().getEigenaar() == eigenaar) {
			currentBakje = currentBakje.getBuurman();
			stappen++;
		}
		
		// loop daarna alle bakjes van de tegenstander af en haal telkens een stap eraf
		while (stappen != 0) {
			currentBakje = currentBakje.getBuurman();
			stappen--;
		}
		
		// als stappen weer op 0 staat, return het bakje
		return currentBakje;
	}
}
