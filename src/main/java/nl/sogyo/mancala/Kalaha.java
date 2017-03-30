package nl.sogyo.mancala;

public class Kalaha extends Bakje{
	
	public Kalaha(int kalahaCounter, Subbakje eersteBakje) {
		inhoud = 0;
		if (kalahaCounter > 0) {
			buurman = new Subbakje(6, kalahaCounter, eersteBakje);
		} else {
			buurman = eersteBakje;
		}
	}
}
