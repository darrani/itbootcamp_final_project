package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{
//    Test #1: Set locale to ES
//Koraci:
//Postaviti jezik na ES
//Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje
//


    @Test(priority = 10)
    @Description("Test #1: Set locale to ES")
    public void setLocaleToES(){
        navPage.getLanguageButton().click();
        navPage.getESButton().click();
    }



    //Test #2: Set locale to EN
//Koraci:
//Postaviti jezik na EN
//Verifikovati da se na stranici u hederu javlja tekst Landing
//
    @Test(priority = 20)
    @Description("Test #1: Set locale to EN")
    public void setLocaleToEN(){
        navPage.getLanguageButton().click();
        navPage.getENButton().click();
}
//Test #3: Set locale to CN
//Koraci:
//Postaviti jezik na CN
//Verifikovati da se na stranici u hederu javlja tekst 首页
    @Test(priority = 30)
    @Description("Test #1: Set locale to CN")
    public void setLocaleToCN(){
        navPage.getLanguageButton().click();
        navPage.getCNButton().click();
}
//Test #4: Set locale to FR
//Koraci:
//Postaviti jezik na FR
//Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage

    @Test(priority = 40)
    @Description("Test #1: Set locale to FR")
    public void setLocaleToFR(){
        navPage.getLanguageButton().click();
        navPage.getFRButton().click();
    }
}
