package nl.sogyo.mancala;

import org.junit.Assert;
import org.junit.Test;

public class MancalaTest {
    
    @Test
    public void bakjeBijStartBeurtWordtNul() {
    	Subbakje bakje = new Subbakje();
    	bakje.startBeurt();
        Assert.assertEquals(0, bakje.getInhoud());
    }
   
    @Test
    public void geefHandDoorEnVoegSteentjeToeAanBuurmanDieVijfWordt() {
    	Subbakje bakje = new Subbakje();
    	bakje.startBeurt();
    	Assert.assertEquals(5, bakje.getBuurman().getInhoud());
    }
    
    @Test
    public void geefHandDoorTotHandLeegIsLaatsteSubbakjeIsVijf() {
    	Subbakje bakje = new Subbakje();
    	bakje.startBeurt();
    	Assert.assertEquals(5, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    @Test
    public void geefHandDoorTotHandLeegIsBuurmanLaatsteSubbakjeIsVier() {
    	Subbakje bakje = new Subbakje();
    	bakje.startBeurt();
    	Assert.assertEquals(4, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    /*@Test
    public void bakjeBijStartBeurtIsVijfBuurmanLaatsteBakjeIsKalahaInhoudIsNul() {
    	Subbakje bakje = new Subbakje();
    	bakje.startBeurt();
    	Assert.assertEquals(0, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }*/
}
