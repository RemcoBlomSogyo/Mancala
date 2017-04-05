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
    	Subbakje bakje = new Subbakje(6, true);
    	bakje.startBeurt();
    	Assert.assertEquals(1, bakje.getBuurman(6).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudZesGeefHandDoorTotHandLeegIsInhoudBuurmanVanKalahaIsVier() {
    	Subbakje bakje = new Subbakje(6, true);
    	bakje.startBeurt();
    	Assert.assertEquals(4, bakje.getBuurman(7).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudZevenGeefHandDoorTotHandLeegIsInhoudBuurmanVanKalahaIsVijf() {
    	Subbakje bakje = new Subbakje(7, true);
    	bakje.startBeurt();
    	Assert.assertEquals(5, bakje.getBuurman(7).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudZevenGeefHandDoorTotHandLeegIsInhoudBuurmanVanBuurmanVanKalahaIsVier() {
    	Subbakje bakje = new Subbakje(7, true);
    	bakje.startBeurt();
    	Assert.assertEquals(4, bakje.getBuurman(8).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudElfGeefHandDoorTotHandLeegIsInhoudBuurmanVanLaatsteBakjeIsVier() {
    	Subbakje bakje = new Subbakje(11, true);
    	bakje.startBeurt();
    	Assert.assertEquals(4, bakje.getBuurman(12).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudTwaalfGeefHandDoorTotHandLeegIsBuurmanVanLaatsteBakjeIsKalahaIsInhoudNul() {
    	Subbakje bakje = new Subbakje(12, true);
    	bakje.startBeurt();
    	Assert.assertEquals(0, bakje.getBuurman(13).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudDertienGeefHandDoorTotHandLeegIsBuurmanVanKalahaIsEersteBakjeInhoudIsNulWantSteentjeEindigtInLeegBakje() {
    	Subbakje bakje = new Subbakje(13, true);
    	bakje.startBeurt();
    	Assert.assertEquals(0, bakje.getBuurman(14).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudDertienGeefHandDoorTotHandLeegIsBuurmanVanKalahaIsEersteBakjeInhoudBakjeBuurmanVanEerstBakjeIsVijf() {
    	Subbakje bakje = new Subbakje(13, true);
    	bakje.startBeurt();
    	Assert.assertEquals(5, bakje.getBuurman(15).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudDertienGeefHandDoorTotHandLeegTweedeKalahaIsNul() {
    	Subbakje bakje = new Subbakje(13, true);
    	bakje.startBeurt();
    	Assert.assertEquals(0, bakje.getBuurman(13).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudEenBuurmanIsNulSteelSteentjesVanOverBuurmanKalahaIsVijf() {
    	Subbakje bakje = new Subbakje(1, true);
    	Subbakje buurman = (Subbakje) bakje.getBuurman();
    	buurman.haalLeeg();
    	bakje.startBeurt();
    	Assert.assertEquals(5, bakje.getBuurman(6).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudEenBuurmanIsNulSteelSteentjesVanOverBuurmanOverbuurmanIsNul() {
    	Subbakje bakje = new Subbakje(1, true);
    	Subbakje buurman = (Subbakje) bakje.getBuurman();
    	buurman.haalLeeg();
    	bakje.startBeurt();
    	Assert.assertEquals(0, bakje.getBuurman(11).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsInhoudDertienGeefHandDoorTotHandLeegIsKalahaIsZevenWantSteentjeEindigtInLeegBakje() {
    	Subbakje bakje = new Subbakje(13, true);
    	bakje.startBeurt();
    	Assert.assertEquals(7, bakje.getBuurman(6).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsDerdeBakjeInhoudIsVierLaatsteBakjeIsKalahaInhoudIsEen() {
    	Subbakje bakje = new Subbakje();
    	bakje.startBeurt(3);
    	Assert.assertEquals(1, bakje.getBuurman(6).getInhoud());
    }
    
    @Test
    public void bakjeStartBeurtIsTweedeBakjeInhoudIsVierBeurtGaatNaarAndereSpeler() {
    	Subbakje bakje = new Subbakje();
    	bakje.startBeurt(2);
    	Assert.assertTrue(bakje.getBuurman(7).getEigenaar().getBeurt());
    }
    
    @Test
    public void bakjeStartBeurtIsDerdeBakjeInhoudIsVierBeurtBlijftBijSpeler() {
    	Subbakje bakje = new Subbakje();
    	bakje.startBeurt(3);
    	Assert.assertTrue(bakje.getEigenaar().getBeurt());
    }
    
    @Test
    public void bakjeStartBeurtIsTweedeBakjeBakjesAndereSpelerZijnLeegVoorWisselbeurtEindigtSpel() {
    	Subbakje bakje = new Subbakje();
    	Subbakje bakje1Speler2 = (Subbakje) bakje.getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman().getBuurman();
    	Subbakje bakje2Speler2 = (Subbakje) bakje1Speler2.getBuurman();
    	Subbakje bakje3Speler2 = (Subbakje) bakje2Speler2.getBuurman();
    	Subbakje bakje4Speler2 = (Subbakje) bakje3Speler2.getBuurman();
    	Subbakje bakje5Speler2 = (Subbakje) bakje4Speler2.getBuurman();
    	Subbakje bakje6Speler2 = (Subbakje) bakje5Speler2.getBuurman();
    	bakje1Speler2.haalLeeg();
    	bakje2Speler2.haalLeeg();
    	bakje3Speler2.haalLeeg();
    	bakje4Speler2.haalLeeg();
    	bakje5Speler2.haalLeeg();
    	bakje6Speler2.haalLeeg();
    	bakje.startBeurt(2);
    	Assert.assertFalse(bakje.getBuurman(7).getEigenaar().getBeurt());
    }
    
    @Test
    public void bakjeStartBeurtIsZesdeBakjeSpelerIsNogEenKeerMaarAlleBakjesZijnLeegSpelIsVoorbij() {
    	Subbakje bakje = new Subbakje();
    	Subbakje bakje2 = (Subbakje) bakje.getBuurman();
    	Subbakje bakje3 = (Subbakje) bakje2.getBuurman();
    	Subbakje bakje4 = (Subbakje) bakje3.getBuurman();
    	Subbakje bakje5 = (Subbakje) bakje4.getBuurman();
    	Subbakje bakje6 = (Subbakje) bakje5.getBuurman();
    	bakje.haalLeeg();
    	bakje2.haalLeeg();
    	bakje3.haalLeeg();
    	bakje4.haalLeeg();
    	bakje5.haalLeeg();
    	bakje6.haalLeeg(3);
    	bakje.startBeurt(6);
    	Assert.assertFalse(bakje.getEigenaar().getBeurt());
    }
    
    @Test
    public void bakjeStartbeurtIsEersteBakjeMaarBakjeIsLeegSpelerHoudtDeBeurt() {
    	Subbakje bakje = new Subbakje();
    	bakje.haalLeeg();
    	bakje.startBeurt(1);
    	Assert.assertTrue(bakje.getEigenaar().getBeurt());
    }
}
