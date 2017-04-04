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
    
    @Test
    public void geefHandDoorTotHandLeegIsBuurmanVanBuurmanLaatsteBakjeIsKalahaInhoudIsNul() {
    	Subbakje bakje = new Subbakje();
    	bakje.startBeurt();
    	Assert.assertEquals(0, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudZesGeefHandDoorTotHandLeegIsInhoudKalahaIsEen() {
    	Subbakje bakje = new Subbakje(6, true);
    	bakje.startBeurt();
    	Assert.assertEquals(1, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudZesGeefHandDoorTotHandLeegIsInhoudBuurmanVanKalahaIsVier() {
    	Subbakje bakje = new Subbakje(6, true);
    	bakje.startBeurt();
    	Assert.assertEquals(4, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudZevenGeefHandDoorTotHandLeegIsInhoudBuurmanVanKalahaIsVijf() {
    	Subbakje bakje = new Subbakje(7, true);
    	bakje.startBeurt();
    	Assert.assertEquals(5, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudZevenGeefHandDoorTotHandLeegIsInhoudBuurmanVanBuurmanVanKalahaIsVier() {
    	Subbakje bakje = new Subbakje(7, true);
    	bakje.startBeurt();
    	Assert.assertEquals(4, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudElfGeefHandDoorTotHandLeegIsInhoudBuurmanVanLaatsteBakjeIsVier() {
    	Subbakje bakje = new Subbakje(11, true);
    	bakje.startBeurt();
    	Assert.assertEquals(4, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudTwaalfGeefHandDoorTotHandLeegIsBuurmanVanLaatsteBakjeIsKalahaIsInhoudNul() {
    	Subbakje bakje = new Subbakje(12, true);
    	bakje.startBeurt();
    	Assert.assertEquals(0, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudDertienGeefHandDoorTotHandLeegIsBuurmanVanKalahaIsEersteBakjeInhoudIsNulWantSteentjeEindigtInLeegBakje() {
    	Subbakje bakje = new Subbakje(13, true);
    	bakje.startBeurt();
    	Assert.assertEquals(0, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudDertienGeefHandDoorTotHandLeegIsBuurmanVanKalahaIsEersteBakjeInhoudBakjeBuurmanVanEerstBakjeIsVijf() {
    	Subbakje bakje = new Subbakje(13, true);
    	bakje.startBeurt();
    	Assert.assertEquals(5, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudDertienGeefHandDoorTotHandLeegTweedeKalahaIsNul() {
    	Subbakje bakje = new Subbakje(13, true);
    	bakje.startBeurt();
    	Assert.assertEquals(0, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudEenBuurmanIsNulSteelSteentjesVanOverBuurmanKalahaIsVier() {
    	Subbakje bakje = new Subbakje(1, true);
    	Subbakje buurman = (Subbakje) bakje.getBuurman();
    	buurman.haalLeeg();
    	bakje.startBeurt();
    	Assert.assertEquals(5, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudDertienGeefHandDoorTotHandLeegIsKalahaIsZevenWantSteentjeEindigtInLeegBakje() {
    	Subbakje bakje = new Subbakje(13, true);
    	bakje.startBeurt();
    	Assert.assertEquals(7, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsDerdeBakjeInhoudIsVierLaatsteBakjeIsKalahaInhoudIsEen() {
    	Subbakje bakje = new Subbakje();
    	bakje.startBeurt(3);
    	Assert.assertEquals(1, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }
    
    /*@Test
    public void bakjeStartBeurtIsTweedeBakjeInhoudIsVierWisselBeurtSpelerBakjeStartBeurtIsDerdeBakjeInhoudTweedeKalahaIsEen() {
    	Subbakje bakje = new Subbakje();
    	bakje.startBeurt(2);
    	bakje.getEigenaar().wisselBeurt();
    	bakje.startBeurt(3);
    	Assert.assertEquals(1, bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getInhoud());
    }*/
}
