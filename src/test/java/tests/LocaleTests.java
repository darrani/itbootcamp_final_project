package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test(priority = 10)
    @Description("TC1: Set locale to ES")
    public void setLocaleToES(){
        navPage.getLanguageButton().click();
        navPage.getESButton().click();
    }

    @Test(priority = 20)
    @Description("TC2: Set locale to EN")
    public void setLocaleToEN(){
        navPage.getLanguageButton().click();
        navPage.getENButton().click();
}

    @Test(priority = 30)
    @Description("TC3: Set locale to CN")
    public void setLocaleToCN(){
        navPage.getLanguageButton().click();
        navPage.getCNButton().click();
}

    @Test(priority = 40)
    @Description("TC4: Set locale to FR")
    public void setLocaleToFR(){
        navPage.getLanguageButton().click();
        navPage.getFRButton().click();
    }
}
