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
    	Assert.assertEquals(5, bakje.getBuurman(4).getInhoud());
    }
    
    @Test
    public void geefHandDoorTotHandLeegIsBuurmanLaatsteSubbakjeIsVier() {
    	Subbakje bakje = new Subbakje();
    	bakje.startBeurt();
    	Assert.assertEquals(4, bakje.getBuurman(5).getInhoud());
    }
    
    @Test
    public void geefHandDoorTotHandLeegIsBuurmanVanBuurmanLaatsteBakjeIsKalahaInhoudIsNul() {
    	Subbakje bakje = new Subbakje();
    	bakje.startBeurt();
    	Assert.assertEquals(0, bakje.getBuurman(6).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudZesGeefHandDoorTotHandLeegIsInhoudKalahaIsEen() {
    	Subbakje bakje = new Subbakje(new int[]{6, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
    	bakje.startBeurt();
    	Assert.assertEquals(1, bakje.getBuurman(6).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudZesGeefHandDoorTotHandLeegIsInhoudBuurmanVanKalahaIsVier() {
    	Subbakje bakje = new Subbakje(new int[]{6, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
    	bakje.startBeurt();
    	Assert.assertEquals(4, bakje.getBuurman(7).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudZevenGeefHandDoorTotHandLeegIsInhoudBuurmanVanKalahaIsVijf() {
    	Subbakje bakje = new Subbakje(new int[]{7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
    	bakje.startBeurt();
    	Assert.assertEquals(5, bakje.getBuurman(7).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudZevenGeefHandDoorTotHandLeegIsInhoudBuurmanVanBuurmanVanKalahaIsVier() {
    	Subbakje bakje = new Subbakje(new int[]{7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
    	bakje.startBeurt();
    	Assert.assertEquals(4, bakje.getBuurman(8).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudElfGeefHandDoorTotHandLeegIsInhoudBuurmanVanLaatsteBakjeIsVier() {
    	Subbakje bakje = new Subbakje(new int[]{11, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
    	bakje.startBeurt();
    	Assert.assertEquals(4, bakje.getBuurman(12).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudTwaalfGeefHandDoorTotHandLeegIsBuurmanVanLaatsteBakjeIsKalahaIsInhoudNul() {
    	Subbakje bakje = new Subbakje(new int[]{12, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
    	bakje.startBeurt();
    	Assert.assertEquals(0, bakje.getBuurman(13).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudDertienGeefHandDoorTotHandLeegIsInhoudVanKalahaIsNulWantKalahaIsVanTegenstander() {
    	Subbakje bakje = new Subbakje(new int[]{13, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
    	bakje.startBeurt();
    	Assert.assertEquals(0, bakje.getBuurman(13).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudDertienGeefHandDoorTotHandLeegIsBuurmanVanKalahaIsEersteBakjeInhoudBakjeBuurmanVanEerstBakjeIsVijf() {
    	Subbakje bakje = new Subbakje(new int[]{13, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
    	bakje.startBeurt();
    	Assert.assertEquals(5, bakje.getBuurman(15).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudDertienGeefHandDoorTotHandLeegTweedeKalahaIsNul() {
    	Subbakje bakje = new Subbakje(new int[]{13, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
    	bakje.startBeurt();
    	Assert.assertEquals(0, bakje.getBuurman(13).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudEenBuurmanIsNulSteelSteentjesVanOverBuurmanKalahaIsVijf() {
    	Subbakje bakje = new Subbakje(new int[]{1, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
    	bakje.startBeurt();
    	Assert.assertEquals(5, bakje.getBuurman(6).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudEenBuurmanIsNulSteelSteentjesVanOverBuurmanOverbuurmanIsNul() {
    	Subbakje bakje = new Subbakje(new int[]{1, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
    	bakje.startBeurt();
    	Assert.assertEquals(0, bakje.getBuurman(11).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudDertienGeefHandDoorTotHandLeegIsKalahaIsZevenWantSteentjeEindigtInLeegBakje() {
    	Subbakje bakje = new Subbakje(new int[]{13, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
    	bakje.startBeurt();
    	Assert.assertEquals(7, bakje.getBuurman(6).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsDerdeBakjeInhoudIsVierLaatsteBakjeIsKalahaInhoudIsEen() {
    	Subbakje derdeBakje = (Subbakje) new Subbakje().getBuurman(2);
    	derdeBakje.startBeurt();
    	Assert.assertEquals(1, derdeBakje.getBuurman(4).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsTweedeBakjeInhoudIsVierBeurtGaatNaarAndereSpeler() {
    	Subbakje tweedeBakje = (Subbakje) new Subbakje().getBuurman();
    	tweedeBakje.startBeurt();
    	Assert.assertTrue(tweedeBakje.getBuurman(6).getEigenaar().getBeurt());
    }
    
    @Test
    public void bakjeStartBeurtIsDerdeBakjeInhoudIsVierBeurtBlijftBijSpeler() {
    	Subbakje derdeBakje = (Subbakje) new Subbakje().getBuurman(2);
    	derdeBakje.startBeurt();
    	Assert.assertTrue(derdeBakje.getEigenaar().getBeurt());
    }
    
    @Test
    public void bakjeStartBeurtIsTweedeBakjeBakjesAndereSpelerZijnLeegVoorWisselbeurtEindigtSpel() {
    	Subbakje tweedeBakje = (Subbakje) new Subbakje(new int[]{4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0}).getBuurman();
    	tweedeBakje.startBeurt();
    	Assert.assertFalse(tweedeBakje.getBuurman(6).getEigenaar().getBeurt());
    }
    
    @Test
    public void bakjeStartBeurtIsZesdeBakjeSpelerIsNogEenKeerMaarAlleBakjesZijnLeegSpelIsVoorbij() {
    	Subbakje zesdeBakje = (Subbakje) new Subbakje(new int[]{0, 0, 0, 0, 0, 1, 4, 4, 4, 4, 4, 4}).getBuurman(5);
    	zesdeBakje.startBeurt();
    	Assert.assertFalse(zesdeBakje.getEigenaar().getBeurt());
    }
    
    @Test
    public void bakjeStartbeurtIsEersteBakjeMaarBakjeIsLeegSpelerHoudtDeBeurt() {
    	Subbakje bakje = new Subbakje(new int[]{0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4});
    	bakje.startBeurt();
    	Assert.assertTrue(bakje.getEigenaar().getBeurt());
    }
}
